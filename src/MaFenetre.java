import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MaFenetre extends JFrame  {

	//Gestion des interfaces, gestion des layouts, gestion des evenements
	JLabel jLabel1 = new JLabel("Nom :");
	JTextField jTextField1 = new JTextField(12);
	JButton jButton1 = new JButton("Add");
	JButton jButton2 = new JButton("Supp");
	List list1 = new List();
	List list2 = new List();
	
	public MaFenetre(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Define the layout
	this.setLayout(new BorderLayout());	
	//add a panel
	JPanel jPanel = new JPanel();
	jPanel.setLayout(new FlowLayout());
	jPanel.add(jLabel1);
	jPanel.add(jTextField1);
	jPanel.add(jButton1);
	jPanel.add(jButton2);
	//add panel to north of form
	this.add(jPanel,BorderLayout.NORTH);
	//define second panel
	JPanel jPane2 = new JPanel();
	jPane2.setLayout(new GridLayout());
	jPane2.add(list1);
	jPane2.add(list2);

	//le bouton doit etre a l'écout de listener,quand on clique dessus actionpreform sexecute
	
	//objet anonyme(a condtion dimplementer la method
	jButton1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = jTextField1.getText();
			list1.add(s);
			jTextField1.setText("");
			
		}
	});
	jButton2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int numero = list1.getSelectedIndex();
			list1.remove(numero);
			
		}
	});
	//au lieu de passer par linterface actionlistner on utilise une classe adaptatrice
	this.addWindowListener(new WindowAdapter() {

		
	
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("Fermeture");
			System.exit(0);
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	//add second panel
	this.add(jPane2,BorderLayout.CENTER);
	this.setBounds(10,10,500,500);
	//this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
	this.setVisible(true);
	}


}
