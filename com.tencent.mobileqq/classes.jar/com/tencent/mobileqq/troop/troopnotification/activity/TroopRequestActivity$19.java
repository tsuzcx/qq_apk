package com.tencent.mobileqq.troop.troopnotification.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$19
  implements View.OnClickListener
{
  TroopRequestActivity$19(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ITroopSysMsgDependApiService)TroopRequestActivity.a(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localObject1 != null)
    {
      Object localObject2 = this.a;
      ((ITroopSysMsgDependApiService)localObject1).openProfileCardForTroopSysMsg((Context)localObject2, TroopRequestActivity.a((TroopRequestActivity)localObject2), this.a.a.msg.group_code.get(), this.a.a.msg.action_uin.get(), this.a.b, this.a.a.msg.sub_type.get(), true);
      localObject1 = TroopRequestActivity.a(this.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.a.msg.group_code.get());
      ((StringBuilder)localObject2).append("");
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((StringBuilder)localObject2).toString(), "3", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.19
 * JD-Core Version:    0.7.0.1
 */