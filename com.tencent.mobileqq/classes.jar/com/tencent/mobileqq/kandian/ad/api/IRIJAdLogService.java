package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdLogService
  extends QRouteApi
{
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService
 * JD-Core Version:    0.7.0.1
 */