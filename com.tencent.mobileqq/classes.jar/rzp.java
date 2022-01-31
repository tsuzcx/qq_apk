import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class rzp
  implements ActionSheet.OnButtonClickListener
{
  public rzp(ChatSettingForTroop paramChatSettingForTroop, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt).c)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ChatSettingForTroop.e(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.d == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        TroopReportor.a("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app != null)) {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.d == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
          {
            TroopReportor.a("Grp_set_new", "grpData_admin", "clk_report", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, null, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getAccount(), 10022, null);
          }
          else
          {
            String str = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
            for (paramView = "1";; paramView = "0")
            {
              TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_report", 0, 0, new String[] { str, paramView });
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, new rzq(this));
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
            this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a("Grp_Admin_data", "Clk_share", "");
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.d == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
              TroopReportor.a("Grp_set_new", "grpData_admin", "clk_share", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzp
 * JD-Core Version:    0.7.0.1
 */