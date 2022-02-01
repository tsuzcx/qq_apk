package com.tencent.mobileqq.troop.troopnotification.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopRequestActivity$2
  implements View.OnClickListener
{
  TroopRequestActivity$2(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.d;
    ITroopSysMsgDependApiService localITroopSysMsgDependApiService = (ITroopSysMsgDependApiService)TroopRequestActivity.a(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localITroopSysMsgDependApiService != null) {
      localITroopSysMsgDependApiService.showOnePicture(this.a, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.2
 * JD-Core Version:    0.7.0.1
 */