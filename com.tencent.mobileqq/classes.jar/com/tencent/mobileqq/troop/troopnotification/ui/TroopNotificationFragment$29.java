package com.tencent.mobileqq.troop.troopnotification.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousHolder;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopSuspiciousHelper;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$29
  implements View.OnClickListener
{
  TroopNotificationFragment$29(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (SuspiciousHolder)paramView.getTag();
    Object localObject2;
    if (((SuspiciousHolder)localObject1).g.msg.group_msg_type.get() == 80)
    {
      localObject1 = TroopInfoUIUtil.a(String.valueOf(((SuspiciousHolder)localObject1).g.msg.group_code.get()), 5);
      localObject2 = (ITroopSysMsgDependApiService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (localObject2 != null) {
        ((ITroopSysMsgDependApiService)localObject2).openTroopProfile(this.a.getActivity(), (Bundle)localObject1);
      }
    }
    else if (!NetworkUtil.isNetSupport(this.a.getActivity()))
    {
      QQToast.makeText(this.a.g, this.a.getActivity().getString(2131917585), 0).show(this.a.b());
    }
    else
    {
      localObject2 = (ITroopSysMsgDependApiService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (localObject2 != null) {
        ((ITroopSysMsgDependApiService)localObject2).getFriendInfo(String.valueOf(((SuspiciousHolder)localObject1).g.req_uin.get()));
      }
      TroopSuspiciousHelper.a((structmsg.StructMsg)((SuspiciousHolder)localObject1).g.get());
      TroopNotificationFragment.a(this.a, (structmsg.StructMsg)((SuspiciousHolder)localObject1).g.get(), ((SuspiciousHolder)localObject1).h);
      Object localObject3 = ((SuspiciousHolder)localObject1).g.msg.group_info.msg_alert.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((SuspiciousHolder)localObject1).g.msg.group_code.get());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      if ((localObject3 != null) && (!"".equals(localObject3)))
      {
        TroopNotificationFragment.b(this.a, 0, (structmsg.StructMsg)((SuspiciousHolder)localObject1).g.get());
      }
      else
      {
        TroopNotificationFragment.b(this.a, 1, (structmsg.StructMsg)((SuspiciousHolder)localObject1).g.get());
        if ((((SuspiciousHolder)localObject1).g.msg.has()) && (((SuspiciousHolder)localObject1).g.msg.req_uin_nick.has()))
        {
          localObject3 = (IBizTroopMemberInfoService)TroopNotificationFragment.f(this.a).getRuntimeService(IBizTroopMemberInfoService.class, "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((SuspiciousHolder)localObject1).g.req_uin.get());
          localStringBuilder.append("");
          ((IBizTroopMemberInfoService)localObject3).handleAgreeJion((String)localObject2, localStringBuilder.toString(), ((SuspiciousHolder)localObject1).g.msg.req_uin_nick.get());
        }
        TroopSuspiciousHelper.a(((SuspiciousHolder)localObject1).g, "unnormal_join");
      }
      TroopNotificationFragment.z(this.a);
      TroopNotificationFragment.j(this.a).c(2131916272);
      TroopNotificationFragment.j(this.a).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.29
 * JD-Core Version:    0.7.0.1
 */