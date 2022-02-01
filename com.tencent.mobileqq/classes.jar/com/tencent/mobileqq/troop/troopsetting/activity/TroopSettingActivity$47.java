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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopSettingActivity.y(this.b);
      TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_actionsheet_click set", 0, 0, new String[] { this.b.i.troopUin });
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.47
 * JD-Core Version:    0.7.0.1
 */