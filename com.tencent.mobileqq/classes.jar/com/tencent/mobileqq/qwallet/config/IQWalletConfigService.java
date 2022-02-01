package com.tencent.mobileqq.qwallet.config;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Map;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;
import org.json.JSONObject;

@Service(needUin=false, process={""})
public abstract interface IQWalletConfigService
  extends IRuntimeService
{
  public abstract void getAllConfig(int paramInt);
  
  public abstract JSONArray getArray(String paramString, String... paramVarArgs);
  
  public abstract String getConfig(String paramString);
  
  public abstract void getConfig(long paramLong, IQWalletConfigService.ConfigListener paramConfigListener, String paramString, Map<String, String> paramMap);
  
  public abstract void getConfig(long paramLong, IQWalletConfigService.ConfigListener paramConfigListener, Map<String, String> paramMap);
  
  public abstract JSONArray getConfigArray(String paramString);
  
  public abstract ConfigInfo getConfigInfo(String paramString);
  
  public abstract JSONObject getConfigObj(String paramString);
  
  public abstract int getInt(String paramString, int paramInt, String... paramVarArgs);
  
  public abstract long getLastReqTime();
  
  public abstract JSONObject getObj(String paramString, String... paramVarArgs);
  
  public abstract String getString(String paramString1, String paramString2, String... paramVarArgs);
  
  public abstract String getValueInModule(String paramString1, String paramString2);
  
  public abstract void handleQWalletSettingCofig(ConfigurationService.Config paramConfig);
  
  public abstract boolean isPublicAccountSupportPay(String paramString);
  
  public abstract boolean isVersionUpdate();
  
  public abstract void registerUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener);
  
  public abstract void setConfigSession(Map<String, String> paramMap);
  
  public abstract void tryGetConfig(int paramInt);
  
  public abstract void tryGetConfigAgain();
  
  public abstract void unRegisterUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.IQWalletConfigService
 * JD-Core Version:    0.7.0.1
 */