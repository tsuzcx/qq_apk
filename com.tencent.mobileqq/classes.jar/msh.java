import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class msh
  implements DialogInterface.OnClickListener
{
  msh(msg parammsg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((awaa)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236)).a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_JavaLangString, "4", "openRoom");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msh
 * JD-Core Version:    0.7.0.1
 */