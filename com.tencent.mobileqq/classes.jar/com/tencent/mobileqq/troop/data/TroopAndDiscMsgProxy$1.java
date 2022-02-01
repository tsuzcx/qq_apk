package com.tencent.mobileqq.troop.data;

import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class TroopAndDiscMsgProxy$1
  implements Comparator<MessageRecord>
{
  TroopAndDiscMsgProxy$1(TroopAndDiscMsgProxy paramTroopAndDiscMsgProxy) {}
  
  private long a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return a(paramMessageRecord1, paramMessageRecord2, paramMessageRecord1.time - paramMessageRecord2.time);
  }
  
  private long a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, long paramLong)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      boolean bool1 = MsgProxyUtils.j(paramMessageRecord1.msgtype);
      boolean bool2 = MsgProxyUtils.j(paramMessageRecord2.msgtype);
      if (bool1)
      {
        if (bool2) {
          return paramMessageRecord1.time - paramMessageRecord2.time;
        }
        return 1L;
      }
      l = paramLong;
      if (bool2) {
        l = -1L;
      }
    }
    return l;
  }
  
  private long b(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq;
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    long l2 = b(paramMessageRecord1, paramMessageRecord2);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = a(paramMessageRecord1, paramMessageRecord2);
    }
    return (int)l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.1
 * JD-Core Version:    0.7.0.1
 */