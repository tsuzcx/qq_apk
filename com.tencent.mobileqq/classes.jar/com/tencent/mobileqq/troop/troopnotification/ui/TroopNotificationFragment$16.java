package com.tencent.mobileqq.troop.troopnotification.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.ViewHolder;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$16
  implements View.OnClickListener
{
  TroopNotificationFragment$16(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof NotifyAndRecAdapter.ViewHolder))
    {
      NotifyAndRecAdapter.ViewHolder localViewHolder = (NotifyAndRecAdapter.ViewHolder)paramView.getTag();
      Object localObject1;
      Object localObject2;
      if (localViewHolder.r.msg.group_msg_type.get() == 80)
      {
        localObject1 = TroopInfoUIUtil.a(String.valueOf(localViewHolder.r.msg.group_code.get()), 5);
        localObject2 = (ITroopSysMsgDependApiService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject2 != null) {
          ((ITroopSysMsgDependApiService)localObject2).openTroopProfile(this.a.getActivity(), (Bundle)localObject1);
        }
      }
      else
      {
        if (this.a.n == 1) {
          ReportController.b(TroopNotificationFragment.f(this.a), "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 2, 0, String.valueOf(localViewHolder.r.msg.group_code.get()), String.valueOf(localViewHolder.r.msg.group_msg_type.get()), String.valueOf(localViewHolder.r.msg_seq), "");
        } else {
          ReportController.b(TroopNotificationFragment.f(this.a), "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 1, 0, String.valueOf(localViewHolder.r.msg.group_code.get()), String.valueOf(localViewHolder.r.msg.group_msg_type.get()), String.valueOf(localViewHolder.r.msg_seq), "");
        }
        if (!NetworkUtil.isNetSupport(this.a.getActivity()))
        {
          QQToast.makeText(this.a.g, this.a.getActivity().getString(2131917585), 0).show(this.a.b());
        }
        else
        {
          localObject1 = (ITroopSysMsgDependApiService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
          if (localObject1 != null) {
            ((ITroopSysMsgDependApiService)localObject1).getFriendInfo(String.valueOf(localViewHolder.r.req_uin.get()));
          }
          TroopNotificationFragment.a(this.a, (structmsg.StructMsg)localViewHolder.r.get(), localViewHolder.s);
          Object localObject3 = localViewHolder.r.msg.group_info.msg_alert.get();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localViewHolder.r.msg.group_code.get());
          ((StringBuilder)localObject1).append("");
          String str = ((StringBuilder)localObject1).toString();
          if (localViewHolder.b == 91)
          {
            localObject2 = (ITroopInfoService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopInfoService.class, "");
            long l = 0L;
            if ((localObject2 != null) && ((localViewHolder.u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)))
            {
              localObject1 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localViewHolder.u;
              localObject2 = ((ITroopInfoService)localObject2).findTroopInfo(String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).j));
              if (localObject2 != null) {
                l = ((TroopInfo)localObject2).dwGroupClassExt;
              }
              ReportController.b(null, "dc00898", "", String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).j), "0X800B4B3", "0X800B4B3", 0, 0, String.valueOf(l), "", "", "");
            }
          }
          localObject1 = this.a.a;
          localObject2 = "1";
          if ((localObject1 != null) && (localViewHolder.q < this.a.a.d)) {
            localObject1 = "1";
          } else {
            localObject1 = "0";
          }
          int i = localViewHolder.r.msg.group_inviter_role.get();
          if ((i != 2) && (i != 3)) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            localObject2 = "0";
          }
          if ((localObject3 != null) && (!"".equals(localObject3)))
          {
            TroopNotificationFragment.a(this.a, 0, (structmsg.StructMsg)localViewHolder.r.get());
            if (localViewHolder.b == 1) {
              TroopReportor.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            } else if (localViewHolder.b == 2) {
              TroopReportor.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            }
          }
          else if (localViewHolder.b == 82)
          {
            TroopNotificationFragment.a(this.a, localViewHolder.r.req_uin.get(), (structmsg.StructMsg)localViewHolder.r.get());
          }
          else if (localViewHolder.r.msg.group_msg_type.get() == 2)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("doCheckPayTroopReq start: ");
              ((StringBuilder)localObject3).append(str);
              QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject3).toString());
            }
            if (((localViewHolder.u instanceof InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)) && (((InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)localViewHolder.u).a != 0))
            {
              if (QLog.isColorLevel()) {
                QLog.i("TroopNotificationFragment", 2, "showJoinTroopSafeDialog");
              }
              TroopNotifyHelper.a(this.a.getActivity(), TroopNotificationFragment.v(this.a), new Object[] { localViewHolder, str, localObject1, localObject2 });
              break label1305;
            }
            ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this.a.g, TroopNotificationFragment.r(this.a), str, localViewHolder.r, this.a.E);
            TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str, localObject1, localObject2, "0" });
          }
          else
          {
            TroopNotificationFragment.a(this.a, 1, (structmsg.StructMsg)localViewHolder.r.get());
            if ((localViewHolder.r.msg.has()) && (localViewHolder.r.msg.req_uin_nick.has()))
            {
              localObject3 = (IBizTroopMemberInfoService)TroopNotificationFragment.f(this.a).getRuntimeService(IBizTroopMemberInfoService.class, "");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(localViewHolder.r.req_uin.get());
              localStringBuilder.append("");
              ((IBizTroopMemberInfoService)localObject3).handleAgreeJion(str, localStringBuilder.toString(), localViewHolder.r.msg.req_uin_nick.get());
            }
            if (localViewHolder.b == 1) {
              TroopReportor.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            } else if (localViewHolder.b == 2) {
              TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            }
          }
          TroopNotificationFragment.w(this.a);
          TroopNotificationFragment.j(this.a).c(2131916272);
          TroopNotificationFragment.j(this.a).show();
        }
      }
    }
    label1305:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.16
 * JD-Core Version:    0.7.0.1
 */