package com.tencent.mobileqq.dpc.api;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IDPCApi
  extends IDPCApiConstant, QRouteApi
{
  public abstract void addObserver(DPCObserver paramDPCObserver);
  
  public abstract ConfigurationService.ReqGetConfig buidldReqConfig(AppRuntime paramAppRuntime);
  
  public abstract int getAbRamdom();
  
  public abstract String getFeatureValue(String paramString);
  
  public abstract String getFeatureValue(String paramString1, String paramString2);
  
  public abstract String getFeatureValueWithoutAccountManager(String paramString);
  
  public abstract String getFeatureValueWithoutAccountManager(String paramString1, String paramString2);
  
  public abstract int getMaxAbRamdom();
  
  public abstract int getServerDataCurrentState();
  
  public abstract int getServerDataCurrentStateWithoutAccountManager();
  
  public abstract boolean isFeatureSupported(String paramString);
  
  public abstract boolean isFeatureSupported(String paramString, long paramLong);
  
  public abstract boolean isInited();
  
  public abstract void nextServerDataState(int paramInt);
  
  public abstract boolean onDPCResponse(ConfigurationService.RespGetConfig paramRespGetConfig, String paramString);
  
  public abstract int parseComplexParamsBySimpleStringParser(String paramString, String[] paramArrayOfString);
  
  public abstract int parseComplexParamsByStringToIntParser(String paramString, Integer[] paramArrayOfInteger);
  
  public abstract void registerBroadCast(AppRuntime paramAppRuntime);
  
  public abstract void removeObserver(DPCObserver paramDPCObserver);
  
  public abstract void unRegisterBroadCast(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.api.IDPCApi
 * JD-Core Version:    0.7.0.1
 */