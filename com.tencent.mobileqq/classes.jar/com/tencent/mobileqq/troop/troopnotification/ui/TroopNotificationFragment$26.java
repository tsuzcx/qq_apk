package com.tencent.mobileqq.troop.troopnotification.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$26
  implements View.OnClickListener
{
  TroopNotificationFragment$26(TroopNotificationFragment paramTroopNotificationFragment, structmsg.SystemMsg paramSystemMsg) {}
  
  public void onClick(View paramView)
  {
    ITroopSysMsgDependApiService localITroopSysMsgDependApiService = (ITroopSysMsgDependApiService)TroopNotificationFragment.f(this.b).getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localITroopSysMsgDependApiService != null) {
      localITroopSysMsgDependApiService.openTroopMemberCard(TroopNotificationFragment.g(this.b), String.valueOf(this.a.group_code.get()), String.valueOf(this.a.action_uin.get()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.26
 * JD-Core Version:    0.7.0.1
 */