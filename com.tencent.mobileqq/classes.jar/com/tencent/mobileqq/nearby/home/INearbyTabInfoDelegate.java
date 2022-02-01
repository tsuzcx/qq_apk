package com.tencent.mobileqq.nearby.home;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INearbyTabInfoDelegate
  extends QRouteApi
{
  public abstract int getVpContentViewId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.home.INearbyTabInfoDelegate
 * JD-Core Version:    0.7.0.1
 */