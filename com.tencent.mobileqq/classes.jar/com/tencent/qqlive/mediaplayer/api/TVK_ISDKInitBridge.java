package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import java.util.Map;

public abstract interface TVK_ISDKInitBridge
{
  public abstract int cleanStorage(Context paramContext);
  
  public abstract void deInit();
  
  public abstract String getAdChid();
  
  public abstract int getHevcHwMaxResolution();
  
  public abstract int getHevcSwMaxResolution();
  
  public abstract String getPlatform();
  
  public abstract String getSdkVersion();
  
  public abstract void initSdk(Context paramContext, String paramString1, String paramString2);
  
  public abstract void initSdkWithGuid(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract boolean isAuthorized();
  
  public abstract boolean isUseFileConfig();
  
  public abstract void setConfigMap(Map<String, String> paramMap);
  
  public abstract void setDebugEnable(boolean paramBoolean);
  
  public abstract void setExtraMapInfo(String paramString, Object paramObject);
  
  public abstract void setGuid(String paramString);
  
  public abstract void setHostConfigBeforeInitSDK(String paramString);
  
  public abstract void setOnLogListener(TVK_SDKMgr.OnLogListener paramOnLogListener);
  
  public abstract void setOnLogReportListener(TVK_SDKMgr.OnLogReportListener paramOnLogReportListener);
  
  public abstract void setPreloadMaxStorageSize(Context paramContext, long paramLong);
  
  public abstract void setUpc(String paramString);
  
  public abstract void useFileConfigBeforeInitSDK(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_ISDKInitBridge
 * JD-Core Version:    0.7.0.1
 */