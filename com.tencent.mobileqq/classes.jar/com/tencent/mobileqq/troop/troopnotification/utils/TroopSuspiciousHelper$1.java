package com.tencent.mobileqq.troop.troopnotification.utils;

import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Comparator;
import tencent.mobileim.structmsg.structmsg.StructMsg;

final class TroopSuspiciousHelper$1
  implements Comparator<structmsg.StructMsg>
{
  public int a(structmsg.StructMsg paramStructMsg1, structmsg.StructMsg paramStructMsg2)
  {
    if (paramStructMsg1.msg_time.get() < paramStructMsg2.msg_time.get()) {
      return 1;
    }
    if (paramStructMsg1.msg_time.get() > paramStructMsg2.msg_time.get()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.utils.TroopSuspiciousHelper.1
 * JD-Core Version:    0.7.0.1
 */