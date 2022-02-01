package com.tencent.mobileqq.troop.troopnotification.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousHolder;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$27
  implements View.OnClickListener
{
  TroopNotificationFragment$27(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof SuspiciousHolder))
    {
      Object localObject2 = (SuspiciousHolder)paramView.getTag();
      if (localObject2 != null)
      {
        Object localObject3 = ((SuspiciousHolder)localObject2).g;
        int j = ((SuspiciousHolder)localObject2).a;
        int k = TroopNotificationUtils.a(j);
        int i = 0;
        Object localObject1;
        if (k == 0)
        {
          localObject1 = (ITroopUtilApi)QRoute.api(ITroopUtilApi.class);
          if (localObject1 != null) {
            ((ITroopUtilApi)localObject1).openTroopInfoActivity(TroopNotificationFragment.g(this.a), String.valueOf(((SuspiciousHolder)localObject2).g.msg.group_code.get()));
          }
          if ((j == 2) || (j == 10) || (j == 12)) {
            i = 1;
          }
          localObject3 = TroopNotificationFragment.f(this.a);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((SuspiciousHolder)localObject2).g.msg.group_code.get());
          ((StringBuilder)localObject1).append("");
          localObject2 = ((StringBuilder)localObject1).toString();
          if (i != 0) {
            localObject1 = "0";
          } else {
            localObject1 = "1";
          }
          ReportController.b((AppRuntime)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject2, (String)localObject1, "", "");
        }
        else if ((((SuspiciousHolder)localObject2).a != 2) || (!TroopInfo.isQidianPrivateTroop(((SuspiciousHolder)localObject2).g.msg.uint32_group_flagext3.get())))
        {
          Object localObject4;
          if (((SuspiciousHolder)localObject2).a == 82)
          {
            localObject1 = new ActivityURIRequest(this.a.g, "/pubaccount/detail");
            localObject3 = ((ActivityURIRequest)localObject1).extra();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((SuspiciousHolder)localObject2).g.req_uin.get());
            ((StringBuilder)localObject4).append("");
            ((Bundle)localObject3).putString("uin", ((StringBuilder)localObject4).toString());
            ((ActivityURIRequest)localObject1).extra().putInt("source", 112);
            QRoute.startUri((URIRequest)localObject1, null);
          }
          else
          {
            localObject1 = String.valueOf(((structmsg.StructMsg)localObject3).req_uin.get());
            i = TroopNotificationUtils.a(j);
            if (i != 1)
            {
              if (i != 2) {}
              for (;;)
              {
                bool1 = false;
                break;
                localObject1 = ((SuspiciousHolder)localObject2).d;
              }
            }
            localObject1 = String.valueOf(((SuspiciousHolder)localObject2).g.msg.action_uin.get());
            boolean bool1 = true;
            long l = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
            boolean bool2 = TroopInfo.isQidianPrivateTroop(l);
            i = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("notification headView onClick: msgType=");
              ((StringBuilder)localObject4).append(i);
              ((StringBuilder)localObject4).append(", isQidianPrivateTroop=");
              ((StringBuilder)localObject4).append(bool2);
              ((StringBuilder)localObject4).append(", flagExt3=");
              ((StringBuilder)localObject4).append(l);
              QLog.d(".troop.qidian_private_troop", 2, ((StringBuilder)localObject4).toString());
            }
            if ((!bool2) || (i != 2))
            {
              localObject4 = (ITroopSysMsgDependApiService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
              if (localObject4 != null)
              {
                ((ITroopSysMsgDependApiService)localObject4).openProfileCardForTroopSysMsg(this.a.getActivity(), (String)localObject1, ((structmsg.StructMsg)localObject3).msg.group_code.get(), ((structmsg.StructMsg)localObject3).msg.action_uin.get(), i, ((structmsg.StructMsg)localObject3).msg.sub_type.get(), bool1);
                localObject1 = TroopNotificationFragment.f(this.a);
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(((SuspiciousHolder)localObject2).g.msg.group_code.get());
                ((StringBuilder)localObject3).append("");
                ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((StringBuilder)localObject3).toString(), "3", "", "");
              }
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.27
 * JD-Core Version:    0.7.0.1
 */