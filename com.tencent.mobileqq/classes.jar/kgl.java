import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;

class kgl
  implements DialogInterface.OnClickListener
{
  kgl(kgk paramkgk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((GroupVideoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_JavaLangString, "4", "openRoom");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kgl
 * JD-Core Version:    0.7.0.1
 */