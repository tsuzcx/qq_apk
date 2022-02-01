package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface ITroopEnterEffectApi
  extends QRouteApi
{
  public abstract void sendGetBaseVipInfoReq(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract void sendTroopEnterEffectCMD(AppRuntime paramAppRuntime, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopEnterEffectApi
 * JD-Core Version:    0.7.0.1
 */