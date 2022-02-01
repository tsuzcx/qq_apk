package com.tencent.mobileqq.nearby.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyConfigUtil
  extends QRouteApi
{
  public abstract void clearRedDotInNearbyEnter(Object paramObject, int paramInt);
  
  public abstract Object getDatingConfig();
  
  public abstract boolean hasEnterItem(AppInterface paramAppInterface, int paramInt);
  
  public abstract boolean hasNearbyMsgTab(AppInterface paramAppInterface);
  
  public abstract boolean isNewNearbyTab(AppInterface paramAppInterface);
  
  public abstract boolean isOldEnterHasItem(Object paramObject, int paramInt);
  
  public abstract void updateDatingConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyConfigUtil
 * JD-Core Version:    0.7.0.1
 */