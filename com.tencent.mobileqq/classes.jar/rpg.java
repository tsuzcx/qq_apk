import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.widget.XEditTextEx;

class rpg
  implements DialogInterface.OnClickListener
{
  rpg(rpf paramrpf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (BaseChatPie.j(this.a.a.a) > 0)
      {
        if (this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label133;
        }
        this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        this.a.a.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        BaseChatPie.a(this.a.a.a).delete(0, BaseChatPie.a(this.a.a.a).length());
        paramDialogInterface.dismiss();
        return;
        label133:
        this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpg
 * JD-Core Version:    0.7.0.1
 */