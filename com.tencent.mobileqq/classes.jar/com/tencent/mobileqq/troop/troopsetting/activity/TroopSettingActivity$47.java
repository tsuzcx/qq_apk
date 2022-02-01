package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopSettingActivity$47
  implements ActionSheet.OnButtonClickListener
{
  TroopSettingActivity$47(TroopSettingActivity paramTroopSettingActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopSettingActivity.v(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity);
      TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_actionsheet_click set", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.a.troopUin });
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.47
 * JD-Core Version:    0.7.0.1
 */