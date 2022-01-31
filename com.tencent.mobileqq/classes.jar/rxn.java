import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class rxn
  implements DialogInterface.OnClickListener
{
  rxn(rxm paramrxm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString, true, true, this.a.jdField_a_of_type_JavaUtilMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxn
 * JD-Core Version:    0.7.0.1
 */