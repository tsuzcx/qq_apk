package com.tencent.mobileqq.ptt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IPttOptimizeParams
  extends QRouteApi
{
  public abstract boolean doesSupportActivateNet(AppRuntime paramAppRuntime);
  
  public abstract boolean doesSupportDirectDownload(AppRuntime paramAppRuntime);
  
  public abstract boolean doesSupportHttpSideWay(AppRuntime paramAppRuntime);
  
  public abstract boolean doesSupportSSCM(AppRuntime paramAppRuntime);
  
  public abstract int getFixScheduleTryCount_dpc(AppRuntime paramAppRuntime);
  
  public abstract long getOptString(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract int getPreSend_dpc(AppRuntime paramAppRuntime);
  
  public abstract int getTryCount_dpc(AppRuntime paramAppRuntime);
  
  public abstract int getTryTime_dpc(AppRuntime paramAppRuntime);
  
  public abstract void initOptimizeCfg(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void savePttOptimizeCfg(AppRuntime paramAppRuntime, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.api.IPttOptimizeParams
 * JD-Core Version:    0.7.0.1
 */