package com.tencent.mobileqq.troop.troopnotification;

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
    Object localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if (localObject != null)
    {
      int i = ((structmsg.StructMsg)localObject).msg.group_inviter_role.get();
      if (((i == 2) || (i == 3)) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$10.b == 1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        localObject = ((StringBuilder)localObject).toString();
        String str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        IMessageHandler localIMessageHandler = (IMessageHandler)TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$10.this$0).getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.saveTroopName((String)localObject, str);
        }
      }
    }
    if (this.jdField_a_of_type_Long != 0L) {
      try
      {
        if ((TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$10.this$0) != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null))
        {
          localObject = (IMessageFacade)TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$10.this$0).getRuntimeService(IMessageFacade.class, "");
          if (localObject != null)
          {
            ((IMessageFacade)localObject).updateMsgContentByUniseq(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, this.jdField_a_of_type_Long, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.10.1
 * JD-Core Version:    0.7.0.1
 */