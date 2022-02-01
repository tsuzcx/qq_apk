package com.tencent.mobileqq.newfriend.api.impl;

import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import java.util.Comparator;

class NewFriendServiceImpl$8
  implements Comparator<Object>
{
  NewFriendServiceImpl$8(NewFriendServiceImpl paramNewFriendServiceImpl) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return 0;
    }
    if (paramObject1 == null) {
      return -1;
    }
    if (paramObject2 == null) {
      return 1;
    }
    boolean bool1 = paramObject1 instanceof NewFriendMessage;
    if ((bool1) && ((paramObject2 instanceof NewFriendMessage))) {
      return (int)(((NewFriendMessage)paramObject2).d - ((NewFriendMessage)paramObject1).d);
    }
    if ((bool1) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((NewFriendMessage)paramObject1).d * 1000L);
    }
    boolean bool2 = paramObject1 instanceof PhoneContact;
    if ((bool2) && ((paramObject2 instanceof PhoneContact))) {
      return (int)(((PhoneContact)paramObject2).lastScanTime - ((PhoneContact)paramObject1).lastScanTime);
    }
    if ((bool2) && ((paramObject2 instanceof NewFriendMessage))) {
      return (int)(((NewFriendMessage)paramObject2).d * 1000L - ((PhoneContact)paramObject1).lastScanTime);
    }
    if (!bool2)
    {
      if (bool1) {
        return -1;
      }
      if (!(paramObject2 instanceof PhoneContact))
      {
        if ((paramObject2 instanceof NewFriendMessage)) {
          return 1;
        }
        return paramObject1.hashCode() - paramObject2.hashCode();
      }
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */