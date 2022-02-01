package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.nearby.INearByGeneralManager;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyManagerHelper
  extends QRouteApi
{
  public abstract Object getLocalRedTouchManager(Object paramObject);
  
  public abstract INearbyCardManager getNearbyCardManager(Object paramObject);
  
  public abstract INearByGeneralManager getNearbyGeneralManager(Object paramObject);
  
  public abstract INearbyLikeLimitManager getNearbyLikeLimitManager(Object paramObject);
  
  public abstract INearbyProxy getNearbyProxy(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyManagerHelper
 * JD-Core Version:    0.7.0.1
 */