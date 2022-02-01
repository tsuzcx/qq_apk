package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$56
  implements View.OnClickListener
{
  TroopSettingActivity$56(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.t != null)
    {
      ((ITroopAppService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopAppService.class, "all")).setProfileAppListChangedFromWebOperate(true, this.a.i.troopUin);
      String str = this.a.t.troopuin;
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).handleTroopAppManageShortcutBar(TroopSettingActivity.a(this.a), str, this.a);
      ReportController.b(null, "dc00898", "", "", "0X800AFC5", "0X800AFC5", 0, 0, String.valueOf(this.a.t.dwGroupClassExt), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.56
 * JD-Core Version:    0.7.0.1
 */