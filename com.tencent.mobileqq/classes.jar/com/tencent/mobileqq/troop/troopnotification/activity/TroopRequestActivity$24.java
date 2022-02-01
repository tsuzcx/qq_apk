package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$24
  implements TroopNotificationUtils.TroopPrivilegeCallback
{
  TroopRequestActivity$24(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if ((this.a.W != null) && (this.a.W.msg != null))
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
          QLog.d("Q.systemmsg.TroopRequestActivity", 2, paramStructMsg.toString());
        }
        TroopNotificationUtils.a(this.a, paramString, "");
        TroopNotificationUtils.c(TroopRequestActivity.a(this.a));
        this.a.h();
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "pay_troop", "", "", "");
        return;
      }
      if (((this.a.W.msg.group_msg_type.get() == 11) && (this.a.W.msg.sub_type.get() == 3)) || (this.a.W.msg.group_msg_type.get() == 7))
      {
        if (this.a.aq != null)
        {
          try
          {
            l = Long.parseLong(this.a.c);
            this.a.g();
            this.a.aq.a(l, 8390784);
            return;
          }
          catch (Exception paramString)
          {
            if (!QLog.isColorLevel()) {
              break label383;
            }
          }
          QLog.i("Q.systemmsg.TroopRequestActivity", 2, paramString.toString());
        }
      }
      else
      {
        this.a.g();
        TroopRequestActivity.a(this.a, 1);
        if (this.a.W.msg.group_msg_type.get() == 2)
        {
          ReportController.b(TroopRequestActivity.a(this.a), "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString, "", "0", "0");
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop", "", "", "");
        }
      }
      label383:
      return;
    }
    this.a.finish();
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.h();
    paramStructMsg = this.a;
    if (paramInt1 == 72) {
      paramInt1 = 2131886623;
    } else {
      paramInt1 = 2131886622;
    }
    QQToast.makeText(paramStructMsg, paramInt1, 1).show();
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "err", "", "", "");
    if (QLog.isColorLevel())
    {
      paramStructMsg = new StringBuilder();
      paramStructMsg.append("NotificationView onTroopPrivilege network! error rspTroopUin = ");
      paramStructMsg.append(paramString1);
      QLog.e("Q.systemmsg.TroopRequestActivity", 2, paramStructMsg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.24
 * JD-Core Version:    0.7.0.1
 */