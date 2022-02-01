package com.tencent.mobileqq.troop.troopnotification;

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
      if (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
      {
        localObject1 = TroopInfoUIUtil.a(String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
        localObject2 = (ITroopSysMsgDependApiService)TroopNotificationFragment.a(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject2 != null) {
          ((ITroopSysMsgDependApiService)localObject2).openTroopProfile(this.a.getActivity(), (Bundle)localObject1);
        }
      }
      else
      {
        if (this.a.b == 1) {
          ReportController.b(TroopNotificationFragment.a(this.a), "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 2, 0, String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq), "");
        } else {
          ReportController.b(TroopNotificationFragment.a(this.a), "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 1, 0, String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq), "");
        }
        if (!NetworkUtil.isNetSupport(this.a.getActivity()))
        {
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.getActivity().getString(2131719980), 0).b(this.a.a());
        }
        else
        {
          localObject1 = (ITroopSysMsgDependApiService)TroopNotificationFragment.a(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
          if (localObject1 != null) {
            ((ITroopSysMsgDependApiService)localObject1).getFriendInfo(String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
          }
          TroopNotificationFragment.a(this.a, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localViewHolder.c);
          Object localObject3 = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          ((StringBuilder)localObject1).append("");
          String str = ((StringBuilder)localObject1).toString();
          if (localViewHolder.jdField_a_of_type_Int == 91)
          {
            localObject2 = (ITroopInfoService)TroopNotificationFragment.a(this.a).getRuntimeService(ITroopInfoService.class, "");
            long l = 0L;
            if ((localObject2 != null) && ((localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)))
            {
              localObject1 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
              localObject2 = ((ITroopInfoService)localObject2).findTroopInfo(String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).e));
              if (localObject2 != null) {
                l = ((TroopInfo)localObject2).dwGroupClassExt;
              }
              ReportController.b(null, "dc00898", "", String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).e), "0X800B4B3", "0X800B4B3", 0, 0, String.valueOf(l), "", "", "");
            }
          }
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
          localObject2 = "1";
          if ((localObject1 != null) && (localViewHolder.b < this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.jdField_a_of_type_Int)) {
            localObject1 = "1";
          } else {
            localObject1 = "0";
          }
          int i = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
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
            TroopNotificationFragment.a(this.a, 0, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
            if (localViewHolder.jdField_a_of_type_Int == 1) {
              TroopReportor.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            } else if (localViewHolder.jdField_a_of_type_Int == 2) {
              TroopReportor.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            }
          }
          else if (localViewHolder.jdField_a_of_type_Int == 82)
          {
            TroopNotificationFragment.a(this.a, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          }
          else if (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("doCheckPayTroopReq start: ");
              ((StringBuilder)localObject3).append(str);
              QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject3).toString());
            }
            if (((localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)) && (((InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo).jdField_a_of_type_Int != 0))
            {
              if (QLog.isColorLevel()) {
                QLog.i("TroopNotificationFragment", 2, "showJoinTroopSafeDialog");
              }
              TroopNotifyHelper.a(this.a.getActivity(), TroopNotificationFragment.a(this.a), new Object[] { localViewHolder, str, localObject1, localObject2 });
              break label1302;
            }
            ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this.a.jdField_a_of_type_AndroidContentContext, TroopNotificationFragment.a(this.a), str, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback);
            TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str, localObject1, localObject2, "0" });
          }
          else
          {
            TroopNotificationFragment.a(this.a, 1, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
            if ((localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has()))
            {
              localObject3 = (IBizTroopMemberInfoService)TroopNotificationFragment.a(this.a).getRuntimeService(IBizTroopMemberInfoService.class, "");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
              localStringBuilder.append("");
              ((IBizTroopMemberInfoService)localObject3).handleAgreeJion(str, localStringBuilder.toString(), localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
            }
            if (localViewHolder.jdField_a_of_type_Int == 1) {
              TroopReportor.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            } else if (localViewHolder.jdField_a_of_type_Int == 2) {
              TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str, localObject1, localObject2, "0" });
            }
          }
          TroopNotificationFragment.m(this.a);
          TroopNotificationFragment.a(this.a).c(2131718766);
          TroopNotificationFragment.a(this.a).show();
        }
      }
    }
    label1302:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.16
 * JD-Core Version:    0.7.0.1
 */