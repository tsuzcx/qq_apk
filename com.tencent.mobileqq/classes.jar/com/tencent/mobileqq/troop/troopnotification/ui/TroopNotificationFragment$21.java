package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$21
  implements TroopNotificationUtils.TroopPrivilegeCallback
{
  TroopNotificationFragment$21(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    long l = paramInt;
    int i;
    if ((TroopInfo.hasPayPrivilege(l, 128)) && (TroopInfo.hasPayPrivilege(l, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("onTroopPrivilege payTroop, rspTroopUin: ");
        paramStructMsg.append(paramString);
        paramStructMsg.append(", privilegeFlag = ");
        paramStructMsg.append(paramInt);
        QLog.d("TroopNotificationFragment", 2, paramStructMsg.toString());
      }
      TroopNotificationUtils.a(this.a.g, paramString, "");
      TroopNotificationUtils.c((AppInterface)TroopNotificationFragment.f(this.a));
      if ((TroopNotificationFragment.j(this.a) != null) && (TroopNotificationFragment.j(this.a).isShowing())) {
        TroopNotificationFragment.j(this.a).dismiss();
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "pay_troop", "", "", "");
      return;
    }
    paramStructMsg = TroopNotificationUtils.b(paramString);
    if (paramStructMsg != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTroopPrivilege normalTroop, rspTroopUin: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", privilegeFlag = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", sendSystemMsgAction-----");
        QLog.d("TroopNotificationFragment", 2, localStringBuilder.toString());
      }
      TroopNotificationFragment.a(this.a, 1, (structmsg.StructMsg)paramStructMsg.get());
      if (paramStructMsg.msg.group_msg_type.get() == 2)
      {
        ReportController.b(TroopNotificationFragment.f(this.a), "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString, "", "0", "0");
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop", "", "", "");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopNotificationFragment", 2, "NotificationView onTroopPrivilege cache error--------------");
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop_error", "", "", "");
    }
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    if ((TroopNotificationFragment.j(this.a) != null) && (TroopNotificationFragment.j(this.a).isShowing())) {
      TroopNotificationFragment.j(this.a).dismiss();
    }
    if (QLog.isColorLevel())
    {
      paramStructMsg = new StringBuilder();
      paramStructMsg.append("NotificationView onTroopPrivilege network! error rspTroopUin = ");
      paramStructMsg.append(paramString1);
      QLog.e("TroopNotificationFragment", 2, paramStructMsg.toString());
    }
    paramString1 = this.a.g;
    if (paramInt1 == 72) {
      paramInt1 = 2131886623;
    } else {
      paramInt1 = 2131886622;
    }
    QQToast.makeText(paramString1, paramInt1, 1).show();
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "err", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.21
 * JD-Core Version:    0.7.0.1
 */