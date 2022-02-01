package com.tencent.mtt.abtestsdk.abtest;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.ConfigValue;
import com.tencent.mtt.abtestsdk.listener.ConfigValueChangeListener;
import com.tencent.mtt.abtestsdk.listener.GetConfigListener;
import com.tencent.mtt.abtestsdk.manager.CacheManager;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import com.tencent.mtt.abtestsdk.utils.DefaultXmlParserUtil;
import com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil;
import com.tencent.mtt.abtestsdk.utils.SystemUtil;
import com.tencent.mtt.abtestsdk.utils.ThreadPoolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteConfigClient
{
  public static boolean sIsInitRemoteConfigClient = false;
  private CacheManager mCacheMgr;
  private Context mContext;
  private Handler mMainHandler;
  private ABTestConfig mRemoteConfig;
  private Map<String, ConfigValueChangeListener> valueListenerMap = new ConcurrentHashMap();
  
  private boolean checkIsFetchConfigInIntervalTime()
  {
    long l = (System.currentTimeMillis() - this.mCacheMgr.getRemoteConfigFetchTime()) / 1000L;
    ABTestLog.configUpload(String.format("config fetch data by net cur interval time: %d, fetchIntervalTime: %d", new Object[] { Long.valueOf(l), Integer.valueOf(1800) }), new Object[0]);
    return l >= 1800L;
  }
  
  private boolean checkIsResponseDataValid(String paramString, GetConfigListener paramGetConfigListener)
  {
    if (paramString.contains("<html>"))
    {
      handleOnFailedEvent(1002, "unknown error", paramGetConfigListener);
      return false;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("status");
      if (i == 1)
      {
        handleOnFailedEvent(1009, "permission failed", paramGetConfigListener);
        return false;
      }
      if (i == 2)
      {
        handleOnFailedEvent(1010, "traffic limit", paramGetConfigListener);
        return false;
      }
      if (i == 3)
      {
        handleOnFailedEvent(1011, "appid or key not exist", paramGetConfigListener);
        return false;
      }
      return true;
    }
    catch (JSONException paramString)
    {
      label88:
      break label88;
    }
    ABTestLog.error(String.format("remote config response json format invalid", new Object[0]), new Object[0]);
    handleOnFailedEvent(1005, "json parser error", paramGetConfigListener);
    return false;
  }
  
  private void fetchConfigDataByNet(GetConfigListener paramGetConfigListener, int paramInt)
  {
    JSONObject localJSONObject = handlePostBodyData(this.mCacheMgr.getRemoteConfigKeysList());
    if (localJSONObject == null)
    {
      ABTestLog.error("fetchConfigDataByNet: postBodyJson is null", new Object[0]);
      return;
    }
    String str = this.mRemoteConfig.getRemoteConfigUrl();
    ABTestLog.configUpload(String.format("configUrl: %s", new Object[] { str }), new Object[0]);
    ThreadPoolUtil.execute(new RemoteConfigClient.1(this, str, localJSONObject, paramInt, paramGetConfigListener));
  }
  
  private void handleOnFailedEvent(int paramInt, String paramString, GetConfigListener paramGetConfigListener)
  {
    Message localMessage = this.mMainHandler.obtainMessage(5);
    Bundle localBundle = localMessage.getData();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    localMessage.setData(localBundle);
    localMessage.obj = paramGetConfigListener;
    localMessage.sendToTarget();
  }
  
  private void handleOnSuccessEvent(String paramString, GetConfigListener paramGetConfigListener)
  {
    if (!checkIsResponseDataValid(paramString, paramGetConfigListener)) {
      return;
    }
    updateLocalConfigData(paramString);
    paramString = this.mMainHandler.obtainMessage(4);
    paramString.obj = paramGetConfigListener;
    paramString.sendToTarget();
  }
  
  private JSONObject handlePostBodyData(List<String> paramList)
  {
    if (this.mRemoteConfig == null)
    {
      ABTestLog.warn("please check remote config file", new Object[0]);
      this.mRemoteConfig = new ABTestConfig();
    }
    Object localObject = ABTestUtil.getABTestSDKAppId(this.mContext, this.mRemoteConfig);
    String str1 = ABTestUtil.getABTestSDKAppKey(this.mContext, this.mRemoteConfig);
    String str2 = this.mRemoteConfig.getGuid();
    String str3 = this.mCacheMgr.getRemoteConfigVersion();
    Map localMap = this.mRemoteConfig.getCustomProfiles();
    String str4 = SystemUtil.getSystemLanguage();
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("app_id", localObject);
      localHashMap.put("config_keys", paramList);
      localHashMap.put("app_id", localObject);
      localHashMap.put("app_key", str1);
      localHashMap.put("guid", str2);
      localHashMap.put("platform", "ANDROID");
      localHashMap.put("sdk_version", "3.0.14");
      if (!TextUtils.isEmpty(str3)) {
        localHashMap.put("config_version", str3);
      }
      if (!TextUtils.isEmpty(str4)) {
        localHashMap.put("language", str4);
      }
      if ((localMap != null) && (!localMap.isEmpty())) {
        localHashMap.put("profiles", localMap);
      }
      ABTestLog.configUpload(String.format("remote config: %s\n appId: %s, appKey:%s, guid:%s, version:%s, language:%s, customTag:%s", new Object[] { paramList.toString(), localObject, str1, str2, str3, str4, localMap.toString() }), new Object[0]);
      paramList = new JSONObject(localHashMap);
      return paramList;
    }
    catch (Exception paramList)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePostBodyData:");
      ((StringBuilder)localObject).append(paramList.getMessage());
      ABTestLog.error(((StringBuilder)localObject).toString(), new Object[0]);
    }
    return null;
  }
  
  private void initClientData()
  {
    boolean bool = this.mRemoteConfig.isDiskCache();
    int i = this.mRemoteConfig.getXmlDefaultResource();
    this.mCacheMgr = CacheManager.getInstance(this.mContext, bool);
    Map localMap = DefaultXmlParserUtil.getDefaultsFromXml(this.mContext, i);
    this.mCacheMgr.saveRemoteConfigMap(localMap);
    this.mCacheMgr.saveRemoteConfigVersion("0");
  }
  
  private boolean isNeedUpdateConfigData(String paramString)
  {
    if (TextUtils.equals(this.mCacheMgr.getRemoteConfigVersion(), paramString))
    {
      ABTestLog.configUpload("the configVersion is the same and ignore update data", new Object[0]);
      return false;
    }
    return true;
  }
  
  private void startFetchRemoteConfig()
  {
    Message localMessage = HandlerThreadUtil.getHandler().obtainMessage(4, this);
    HandlerThreadUtil.getHandler().sendMessage(localMessage);
  }
  
  private Map<String, ConfigValue> updateLocalConfigData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optString("version");
      if (!isNeedUpdateConfigData(paramString)) {
        return localHashMap;
      }
      localObject1 = ((JSONObject)localObject1).optJSONObject("data");
      if (localObject1 != null)
      {
        if (((JSONObject)localObject1).keys() == null) {
          return localHashMap;
        }
        Iterator localIterator = ((JSONObject)localObject1).keys();
        String str;
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localHashMap.put(str, new ConfigValue(((JSONObject)localObject1).optJSONObject(str).optString("value")));
        }
        if (!localHashMap.isEmpty())
        {
          localObject1 = this.mCacheMgr.getRemoteConfigMap();
          localIterator = localHashMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (Map.Entry)localIterator.next();
            str = (String)((Map.Entry)localObject2).getKey();
            localObject2 = (ConfigValue)((Map.Entry)localObject2).getValue();
            ((Map)localObject1).put(str, localObject2);
            if (this.valueListenerMap.containsKey(str)) {
              ((ConfigValueChangeListener)this.valueListenerMap.get(str)).onValueChange(str, (ConfigValue)localObject2);
            }
          }
          this.mCacheMgr.saveRemoteConfigMap((Map)localObject1);
          this.mCacheMgr.saveRemoteConfigFetchTime(System.currentTimeMillis());
          this.mCacheMgr.saveRemoteConfigVersion(paramString);
        }
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateLocalConfigData error and please check data format: ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      ABTestLog.error(((StringBuilder)localObject1).toString(), new Object[0]);
    }
    return localHashMap;
  }
  
  public void handleIntervalFetchConfigByNet(GetConfigListener paramGetConfigListener, int paramInt)
  {
    if ((checkIsFetchConfigInIntervalTime()) || (paramGetConfigListener == null)) {
      fetchConfigDataByNet(paramGetConfigListener, paramInt);
    }
  }
  
  public void init(@Nullable Context paramContext, @Nullable ABTestConfig paramABTestConfig, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mMainHandler = paramHandler;
    this.mRemoteConfig = paramABTestConfig;
    initClientData();
    startFetchRemoteConfig();
  }
  
  public void registerValueChangeListener(String paramString, ConfigValueChangeListener paramConfigValueChangeListener)
  {
    Map localMap = this.valueListenerMap;
    if ((localMap != null) && (!localMap.containsKey(paramString))) {
      this.valueListenerMap.put(paramString, paramConfigValueChangeListener);
    }
  }
  
  public void unregisterValueChangeListener(String paramString)
  {
    Map localMap = this.valueListenerMap;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      this.valueListenerMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.RemoteConfigClient
 * JD-Core Version:    0.7.0.1
 */