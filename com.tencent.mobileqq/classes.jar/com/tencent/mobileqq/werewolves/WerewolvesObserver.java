package com.tencent.mobileqq.werewolves;

import com.tencent.mobileqq.app.BusinessObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;

public class WerewolvesObserver
  implements BusinessObserver
{
  public void a(int paramInt) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(submsgtype0xdd.MsgBody paramMsgBody) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        a(((Integer)paramObject).intValue());
        return;
      }
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    }
    a((submsgtype0xdd.MsgBody)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesObserver
 * JD-Core Version:    0.7.0.1
 */