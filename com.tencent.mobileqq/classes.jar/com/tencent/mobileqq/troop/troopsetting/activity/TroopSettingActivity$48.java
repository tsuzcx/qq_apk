package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class TroopSettingActivity$48
  implements View.OnClickListener
{
  TroopSettingActivity$48(TroopSettingActivity paramTroopSettingActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_actionsheet_click cancel", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.48
 * JD-Core Version:    0.7.0.1
 */