package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$15
  implements View.OnClickListener
{
  TroopSettingActivity$15(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131436180)
    {
      TroopSettingActivity.g(this.a);
      this.a.finish();
    }
    else if (i == 2131436194)
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
      Object localObject1 = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
      Object localObject2 = this.a;
      ((IChatSettingForTroopApi)localObject1).initTroopShareUtility((Activity)localObject2, ((TroopSettingActivity)localObject2).i, TroopSettingActivity.a(this.a));
      TroopReportor.a("Grp_set_new", "grpData_admin", "share_click", 0, 0, new String[] { this.a.i.troopUin });
      if (this.a.i.isMember) {
        localObject1 = "grpData_admin";
      } else {
        localObject1 = "grpData_visitor";
      }
      String str = this.a.i.troopUin;
      if (this.a.i.isMember) {
        localObject2 = TroopReportor.a(this.a.i);
      } else {
        localObject2 = "0";
      }
      TroopReportor.a("Grp_set_new", (String)localObject1, "clk_upright", 0, 0, new String[] { str, localObject2 });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.15
 * JD-Core Version:    0.7.0.1
 */