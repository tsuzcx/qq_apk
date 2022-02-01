package com.tencent.mobileqq.qwallet.config;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IQWalletConfigServiceProxy
  extends QRouteApi
{
  public abstract String getConfig(String paramString);
  
  public abstract int getInt(String paramString, int paramInt, String... paramVarArgs);
  
  public abstract String getString(String paramString1, String paramString2, String... paramVarArgs);
  
  public abstract void registerUpdateListenerComm(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener);
  
  public abstract void setConfigSession(HashMap<String, String> paramHashMap);
  
  public abstract void unRegisterUpdateListenerComm(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.IQWalletConfigServiceProxy
 * JD-Core Version:    0.7.0.1
 */