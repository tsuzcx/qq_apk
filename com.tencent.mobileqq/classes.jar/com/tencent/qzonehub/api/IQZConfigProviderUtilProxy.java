package com.tencent.qzonehub.api;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentValues;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQZConfigProviderUtilProxy
  extends QRouteApi
{
  public abstract void cleanAll();
  
  public abstract ContentValues convertNavigatorConfig(String paramString, entrance_cfg paramentrance_cfg);
  
  public abstract void deleteLastUpdateLog();
  
  public abstract String getConfigCookie();
  
  public abstract String getHighPriorityConfig(String paramString1, String paramString2, String paramString3);
  
  public abstract String getHighPriorityConfigSPKey(String paramString1, String paramString2);
  
  public abstract SharedPreferences getHighPriorityConfigSharedPreferences();
  
  public abstract long getLastCheckTime();
  
  public abstract String getLastUpdate();
  
  public abstract boolean getNavigatorConfigs(String paramString, ArrayList<entrance_cfg> paramArrayList);
  
  public abstract String getOneConfig(String paramString1, String paramString2);
  
  public abstract boolean isEeveeSysTemPolling();
  
  public abstract boolean isQQCircleUseEeveeRedPoint();
  
  public abstract boolean loadAllConfigs(Map<String, ConcurrentHashMap<String, String>> paramMap);
  
  public abstract Map<String, String> loadIspConfigs();
  
  public abstract boolean recUpdateSource(String paramString);
  
  public abstract void saveConfigCookie(String paramString);
  
  public abstract void saveIspCheckTime(long paramLong);
  
  public abstract void saveIspConfig(Map<String, String> paramMap);
  
  public abstract void saveNavigatorBar(String paramString, ArrayList<entrance_cfg> paramArrayList);
  
  public abstract void updateConfigAndCookie(Map<String, byte[]> paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
 * JD-Core Version:    0.7.0.1
 */