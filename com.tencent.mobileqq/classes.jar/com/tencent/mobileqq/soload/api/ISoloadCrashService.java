package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISoloadCrashService
  extends QRouteApi
{
  public abstract void handleCrash(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.ISoloadCrashService
 * JD-Core Version:    0.7.0.1
 */