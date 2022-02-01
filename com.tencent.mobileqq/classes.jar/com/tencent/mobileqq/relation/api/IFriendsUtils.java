package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFriendsUtils
  extends QRouteApi
{
  public abstract BusinessObserver createFriendObserver(IFriendsUtils.FriendListObserverInterface paramFriendListObserverInterface);
  
  public abstract int getNetworkType(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IFriendsUtils
 * JD-Core Version:    0.7.0.1
 */