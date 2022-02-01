package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyLikeLimitManagerUtil
  extends QRouteApi
{
  public abstract boolean isNeedNewLimitCheck(long paramLong);
  
  public abstract void report(Object paramObject, String paramString1, String paramString2);
  
  public abstract void report(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil
 * JD-Core Version:    0.7.0.1
 */