import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;

public class sjh
  implements DialogInterface.OnClickListener
{
  public sjh(ChatSettingForTroop paramChatSettingForTroop, BizTroopHandler paramBizTroopHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopCode, false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin, "", "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "share_set_close", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjh
 * JD-Core Version:    0.7.0.1
 */