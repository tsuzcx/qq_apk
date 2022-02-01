package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$10$1
  implements Runnable
{
  TroopNotificationFragment$10$1(TroopNotificationFragment.10 param10, structmsg.StructMsg paramStructMsg, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      int i = ((structmsg.StructMsg)localObject).msg.group_inviter_role.get();
      if (((i == 2) || (i == 3)) && (this.c.g == 1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(this.a.msg.group_code.get());
        localObject = ((StringBuilder)localObject).toString();
        String str = this.a.msg.group_name.get();
        IMessageHandler localIMessageHandler = (IMessageHandler)TroopNotificationFragment.f(this.c.this$0).getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.saveTroopName((String)localObject, str);
        }
      }
    }
    if (this.b != 0L) {
      try
      {
        if ((TroopNotificationFragment.f(this.c.this$0) != null) && (this.a != null))
        {
          localObject = (IMessageFacade)TroopNotificationFragment.f(this.c.this$0).getRuntimeService(IMessageFacade.class, "");
          if (localObject != null)
          {
            ((IMessageFacade)localObject).updateMsgContentByUniseq(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, this.b, this.a.toByteArray());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotificationFragment", 2, "onSendSystemMsgActionFin Exception!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.10.1
 * JD-Core Version:    0.7.0.1
 */