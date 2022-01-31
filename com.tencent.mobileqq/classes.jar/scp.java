import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;

public class scp
  implements DialogInterface.OnClickListener
{
  public scp(ChatSettingForTroop paramChatSettingForTroop, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
    }
    paramDialogInterface = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.a(20);
    if ((NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131435283, 0);
      paramDialogInterface.i(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      if (paramDialogInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131434613, 1500);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131435287, 1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scp
 * JD-Core Version:    0.7.0.1
 */