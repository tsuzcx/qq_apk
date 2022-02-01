package com.tencent.mobileqq.troop.troopnotification;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$15
  implements View.OnClickListener
{
  TroopNotificationFragment$15(TroopNotificationFragment paramTroopNotificationFragment, structmsg.SystemMsg paramSystemMsg) {}
  
  public void onClick(View paramView)
  {
    ITroopSysMsgDependApiService localITroopSysMsgDependApiService = (ITroopSysMsgDependApiService)TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment).getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localITroopSysMsgDependApiService != null) {
      localITroopSysMsgDependApiService.openTroopMemberCard(TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.action_uin.get()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.15
 * JD-Core Version:    0.7.0.1
 */