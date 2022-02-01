package com.tencent.mobileqq.troop.troopnotification.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopRequestActivity$6
  implements View.OnClickListener
{
  TroopRequestActivity$6(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = new ActivityURIRequest(this.a, "/pubaccount/detail");
    Object localObject2 = ((ActivityURIRequest)localObject1).extra();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.W.req_uin.get());
    localStringBuilder.append("");
    ((Bundle)localObject2).putString("uin", localStringBuilder.toString());
    ((ActivityURIRequest)localObject1).extra().putInt("source", 112);
    QRoute.startUri((URIRequest)localObject1, null);
    localObject1 = TroopRequestActivity.a(this.a);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.W.req_uin.get());
    ((StringBuilder)localObject2).append("");
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_public", "", "oper", "Clk_invite", 0, 0, "", "", "", ((StringBuilder)localObject2).toString());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.6
 * JD-Core Version:    0.7.0.1
 */