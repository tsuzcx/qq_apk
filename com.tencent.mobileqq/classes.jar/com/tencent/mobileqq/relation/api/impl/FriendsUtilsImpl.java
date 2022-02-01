package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.relation.api.IFriendsUtils;
import com.tencent.mobileqq.relation.api.IFriendsUtils.FriendListObserverInterface;

public class FriendsUtilsImpl
  implements IFriendsUtils
{
  public BusinessObserver createFriendObserver(IFriendsUtils.FriendListObserverInterface paramFriendListObserverInterface)
  {
    return new FriendsUtilsImpl.1(this, paramFriendListObserverInterface);
  }
  
  public int getNetworkType(int paramInt1, int paramInt2, int paramInt3)
  {
    return FriendsUtils.a(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.FriendsUtilsImpl
 * JD-Core Version:    0.7.0.1
 */