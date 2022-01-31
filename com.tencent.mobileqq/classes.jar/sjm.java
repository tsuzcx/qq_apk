import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class sjm
  implements DialogInterface.OnClickListener
{
  sjm(sjl paramsjl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.cancel();
      return;
    }
    try
    {
      ForwardSdkShareOption.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, true, "action_game_join_group", Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.c).longValue(), -1, this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.cancel();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("Q.chatopttroop", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjm
 * JD-Core Version:    0.7.0.1
 */