package com.tencent.mobileqq.newfriend.api.impl;

import com.tencent.mobileqq.data.SysSuspiciousMsg;
import java.util.Comparator;

class NewFriendServiceImpl$2
  implements Comparator<SysSuspiciousMsg>
{
  NewFriendServiceImpl$2(NewFriendServiceImpl paramNewFriendServiceImpl) {}
  
  public int a(SysSuspiciousMsg paramSysSuspiciousMsg1, SysSuspiciousMsg paramSysSuspiciousMsg2)
  {
    if ((paramSysSuspiciousMsg1 != null) && (paramSysSuspiciousMsg2 != null)) {
      return (int)(paramSysSuspiciousMsg2.time - paramSysSuspiciousMsg1.time);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */