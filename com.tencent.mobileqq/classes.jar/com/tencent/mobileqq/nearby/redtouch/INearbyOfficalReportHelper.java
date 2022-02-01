package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyOfficalReportHelper
  extends QRouteApi
{
  public abstract void reportLebaRedDotEvent(Object paramObject, String paramString1, String paramString2);
  
  public abstract void reportNearByRedDotEvent(Object paramObject, String paramString1, String paramString2);
  
  public abstract void reportRedDotReceive(Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper
 * JD-Core Version:    0.7.0.1
 */