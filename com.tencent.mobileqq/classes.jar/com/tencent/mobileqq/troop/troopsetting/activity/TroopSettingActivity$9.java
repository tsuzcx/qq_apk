package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$9
  implements View.OnClickListener
{
  TroopSettingActivity$9(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onClick(View paramView)
  {
    IChatSettingForTroopApi localIChatSettingForTroopApi = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
    TroopSettingActivity localTroopSettingActivity = this.a;
    localIChatSettingForTroopApi.doReportTroop(localTroopSettingActivity, localTroopSettingActivity.a, TroopSettingActivity.a(this.a));
    TroopReportor.a("Grp_set_new", "grpData_admin", "tipoff_click", 0, 0, new String[] { this.a.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.9
 * JD-Core Version:    0.7.0.1
 */