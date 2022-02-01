package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.Comparator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationRecordMessageController$4
  implements Comparator<MessageRecord>
{
  TroopNotificationRecordMessageController$4(TroopNotificationRecordMessageController paramTroopNotificationRecordMessageController) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramMessageRecord1 = ((MessageForSystemMsg)paramMessageRecord1).getSystemMsg();
    paramMessageRecord2 = ((MessageForSystemMsg)paramMessageRecord2).getSystemMsg();
    if (paramMessageRecord1.msg_seq.get() < paramMessageRecord2.msg_seq.get()) {
      return 1;
    }
    if (paramMessageRecord1.msg_seq.get() == paramMessageRecord2.msg_seq.get())
    {
      if ((paramMessageRecord1.msg.has()) && (paramMessageRecord1.msg.sub_type.get() != 1)) {
        return 1;
      }
      if ((paramMessageRecord2.msg.has()) && (paramMessageRecord2.msg.sub_type.get() != 1)) {
        return -1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationRecordMessageController.4
 * JD-Core Version:    0.7.0.1
 */