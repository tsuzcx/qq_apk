package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$45
  implements View.OnClickListener
{
  TroopSettingActivity$45(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "setTroopUinTextViewClickListener onClick");
    }
    TroopSettingActivity.x(this.a);
    TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_click", 0, 0, new String[] { this.a.i.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.45
 * JD-Core Version:    0.7.0.1
 */