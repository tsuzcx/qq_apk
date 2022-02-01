package com.tencent.mtt.abtestsdk.abtest;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.FeatureEntity;
import com.tencent.mtt.abtestsdk.entity.FeatureStrategyEntity;
import com.tencent.mtt.abtestsdk.listener.FeatureInitListener;
import com.tencent.mtt.abtestsdk.listener.FeatureUpdateListener;
import com.tencent.mtt.abtestsdk.listener.GetFeatureListener;
import com.tencent.mtt.abtestsdk.manager.CacheManager;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil;
import com.tencent.mtt.abtestsdk.utils.ThreadPoolUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeatureClient
{
  public static boolean sIsInitFeatureClient = false;
  private final List<FeatureInitListener> initListenerList = new CopyOnWriteArrayList();
  private CacheManager mCacheMgr;
  private ABTestConfig mConfig;
  private Context mContext;
  private Handler mMainHandler;
  private final List<FeatureUpdateListener> updateListenerList = new CopyOnWriteArrayList();
  
  private boolean checkIsFetchFeatureInIntervalTime(FeatureStrategyEntity paramFeatureStrategyEntity)
  {
    ABTestLog.featureUpload("feature fetch data by net", new Object[0]);
    if (paramFeatureStrategyEntity == null) {
      return true;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = paramFeatureStrategyEntity.getLastFetchTime();
    int i = paramFeatureStrategyEntity.getReportFetchTimeInSecs();
    l1 -= l2;
    ABTestLog.featureUpload(String.format("feature fetch data interval time: %d, fetchIntervalTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i) }), new Object[0]);
    return l1 >= i;
  }
  
  private void fetchFeatureDataByNet(String paramString, GetFeatureListener paramGetFeatureListener, int paramInt)
  {
    JSONObject localJSONObject = handlePostBodyData(paramString);
    if (localJSONObject == null) {
      return;
    }
    String str = this.mConfig.getFeatureUrl();
    ABTestLog.featureUpload(String.format("featureUrl: %s", new Object[] { str }), new Object[0]);
    ThreadPoolUtil.execute(new FeatureClient.1(this, str, localJSONObject, paramInt, paramGetFeatureListener, paramString));
  }
  
  private void handleOnFailedEvent(int paramInt, String paramString, GetFeatureListener paramGetFeatureListener)
  {
    if (!sIsInitFeatureClient)
    {
      localObject = this.initListenerList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FeatureInitListener)((Iterator)localObject).next()).featureInitFailed(paramInt, paramString);
      }
    }
    Object localObject = this.mMainHandler.obtainMessage(3);
    Bundle localBundle = ((Message)localObject).getData();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    ((Message)localObject).setData(localBundle);
    ((Message)localObject).obj = paramGetFeatureListener;
    ((Message)localObject).sendToTarget();
  }
  
  private void handleOnSuccessEvent(String paramString1, GetFeatureListener paramGetFeatureListener, String paramString2)
  {
    if (paramString1.contains("<html>"))
    {
      handleOnFailedEvent(1002, "unknown error", paramGetFeatureListener);
      return;
    }
    try
    {
      int i = new JSONObject(paramString1).optInt("code");
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                handleOnFailedEvent(1006, "server error", paramGetFeatureListener);
                return;
              }
              handleOnFailedEvent(1015, "invalid appId", paramGetFeatureListener);
              return;
            }
            handleOnFailedEvent(1014, "appId and guid is required", paramGetFeatureListener);
            return;
          }
          handleOnFailedEvent(1013, "feature not exists", paramGetFeatureListener);
          return;
        }
        handleOnFailedEvent(1012, "server feature cache is empty", paramGetFeatureListener);
        return;
      }
      Map localMap = updateRemoteData(paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new FeatureEntity();
        if (localMap != null) {
          paramString1 = (FeatureEntity)localMap.get(paramString2);
        }
        paramString2 = this.mMainHandler.obtainMessage(2);
        paramString2.obj = new Object[] { paramString1, paramGetFeatureListener };
        paramString2.sendToTarget();
      }
      return;
    }
    catch (JSONException paramString1)
    {
      label189:
      break label189;
    }
    ABTestLog.featureUpload(String.format("feature response json format invalid", new Object[0]), new Object[0]);
    handleOnFailedEvent(1005, "json parser error", paramGetFeatureListener);
  }
  
  private JSONObject handlePostBodyData(String paramString)
  {
    if (this.mConfig == null)
    {
      ABTestLog.warn("please check feature config", new Object[0]);
      this.mConfig = new ABTestConfig();
    }
    Object localObject2 = ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig);
    String str2 = this.mConfig.getGuid();
    Map localMap = this.mConfig.getCustomProfiles();
    String str1 = new JSONObject(localMap).toString();
    ABTestLog.featureUpload(String.format("feature appId: %s, guid: %s, customTag: %s", new Object[] { localObject2, str2, str1 }), new Object[0]);
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("appid", localObject2);
      ((JSONObject)localObject1).put("guid", str2);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = new ArrayList();
        ((List)localObject2).add(paramString);
        ((JSONObject)localObject1).put("featureKey", new JSONArray((Collection)localObject2));
      }
      if (!localMap.isEmpty()) {
        ((JSONObject)localObject1).put("profiles", new JSONObject(str1));
      }
      paramString = new StringBuilder();
      paramString.append("feature postBody: ");
      paramString.append(localObject1);
      ABTestLog.featureUpload(paramString.toString(), new Object[0]);
      return localObject1;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fetchFeatureDataByNet failed ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      ABTestLog.error(((StringBuilder)localObject1).toString(), new Object[0]);
    }
    return null;
  }
  
  private void initClientData()
  {
    this.mCacheMgr = CacheManager.getInstance(this.mContext, this.mConfig.isDiskCache());
  }
  
  private void notifyUpdateListener(Map<String, FeatureEntity> paramMap)
  {
    paramMap = obtainUpdateEntityMap(paramMap);
    if (paramMap.isEmpty())
    {
      ABTestLog.debug("featureEntity is not modify", new Object[0]);
      return;
    }
    Iterator localIterator = this.updateListenerList.iterator();
    while (localIterator.hasNext()) {
      ((FeatureUpdateListener)localIterator.next()).updateFeatureSuccess(paramMap);
    }
  }
  
  private Map<String, FeatureEntity> obtainUpdateEntityMap(Map<String, FeatureEntity> paramMap)
  {
    Object localObject1 = new HashMap();
    if (this.mCacheMgr != null)
    {
      if (paramMap.equals(localObject1)) {
        return localObject1;
      }
      localObject1 = this.mCacheMgr.getFeatureEntityMap();
      HashMap localHashMap = new HashMap();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (FeatureEntity)((Map.Entry)localObject2).getValue();
        if (!((Map)localObject1).containsKey(str))
        {
          localHashMap.put(str, localObject2);
        }
        else if (!((FeatureEntity)localObject2).equals((FeatureEntity)((Map)localObject1).get(str)))
        {
          localHashMap.put(str, localObject2);
          ((Map)localObject1).remove(str);
        }
        else
        {
          ((Map)localObject1).remove(str);
        }
      }
      if (!((Map)localObject1).isEmpty()) {
        localHashMap.putAll((Map)localObject1);
      }
      return localHashMap;
    }
    return localObject1;
  }
  
  private void startFetchFeatures()
  {
    Message localMessage = HandlerThreadUtil.getHandler().obtainMessage(2, new Object[] { this, this.mCacheMgr });
    HandlerThreadUtil.getHandler().sendMessage(localMessage);
  }
  
  private Map<String, FeatureEntity> updateRemoteData(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramString1 = new JSONObject(paramString1);
      Object localObject1 = paramString1.optJSONObject("featureStrategy");
      Object localObject2 = new FeatureStrategyEntity();
      if (localObject1 != null) {
        ((FeatureStrategyEntity)localObject2).readFromJson((JSONObject)localObject1);
      }
      this.mCacheMgr.saveFeatureReportStrategy((FeatureStrategyEntity)localObject2);
      paramString1 = paramString1.optJSONObject("data");
      if (paramString1 != null)
      {
        if (paramString1.keys() == null) {
          return localHashMap;
        }
        localObject1 = paramString1.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          JSONObject localJSONObject = paramString1.getJSONObject((String)localObject2);
          FeatureEntity localFeatureEntity = new FeatureEntity();
          localFeatureEntity.readFeatureJson(localJSONObject);
          localHashMap.put(localObject2, localFeatureEntity);
        }
        if (TextUtils.isEmpty(paramString2))
        {
          notifyUpdateListener(localHashMap);
          this.mCacheMgr.saveFeatureEntityMap(localHashMap);
          if (!sIsInitFeatureClient)
          {
            paramString1 = this.initListenerList.iterator();
            while (paramString1.hasNext()) {
              ((FeatureInitListener)paramString1.next()).featureInitSuccess();
            }
            sIsInitFeatureClient = true;
            return localHashMap;
          }
        }
        else
        {
          localObject1 = this.mCacheMgr.getFeatureEntityMap();
          paramString1 = (String)localObject1;
          if (localObject1 == null) {
            paramString1 = new HashMap();
          }
          localObject1 = (FeatureEntity)localHashMap.get(paramString2);
          if (localObject1 != null)
          {
            paramString1.put(paramString2, localObject1);
            this.mCacheMgr.saveFeatureEntityMap(paramString1);
            return localHashMap;
          }
        }
      }
      else
      {
        return localHashMap;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("invalid format, process feature remote data failed:");
      paramString2.append(paramString1.getMessage());
      ABTestLog.warn(paramString2.toString(), new Object[0]);
    }
    return localHashMap;
  }
  
  public void getFeatureByKey(String paramString, GetFeatureListener paramGetFeatureListener, int paramInt)
  {
    Map localMap = this.mCacheMgr.getFeatureEntityMap();
    if ((localMap != null) && (localMap.containsKey(paramString)))
    {
      paramGetFeatureListener.getFeatureSucceed((FeatureEntity)localMap.get(paramString));
      return;
    }
    fetchFeatureDataByNet(paramString, paramGetFeatureListener, paramInt);
  }
  
  public void handleIntervalFetchFeatureByNet(GetFeatureListener paramGetFeatureListener, int paramInt)
  {
    if ((checkIsFetchFeatureInIntervalTime(this.mCacheMgr.getFeatureReportStrategy())) || (paramGetFeatureListener == null)) {
      fetchFeatureDataByNet("", paramGetFeatureListener, paramInt);
    }
  }
  
  public void init(@Nullable Context paramContext, @Nullable ABTestConfig paramABTestConfig, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mConfig = paramABTestConfig;
    this.mMainHandler = paramHandler;
    initClientData();
    startFetchFeatures();
  }
  
  public void registerFeatureInitListener(FeatureInitListener paramFeatureInitListener)
  {
    List localList = this.initListenerList;
    if ((localList != null) && (!localList.contains(paramFeatureInitListener))) {
      this.initListenerList.add(paramFeatureInitListener);
    }
  }
  
  public void registerFeatureUpdateListener(FeatureUpdateListener paramFeatureUpdateListener)
  {
    List localList = this.updateListenerList;
    if ((localList != null) && (!localList.contains(paramFeatureUpdateListener))) {
      this.updateListenerList.add(paramFeatureUpdateListener);
    }
  }
  
  public FeatureEntity syncGetFeatureByKey(String paramString)
  {
    Map localMap = this.mCacheMgr.getFeatureEntityMap();
    FeatureEntity localFeatureEntity2 = new FeatureEntity();
    FeatureEntity localFeatureEntity1 = localFeatureEntity2;
    if (localMap != null)
    {
      localFeatureEntity1 = localFeatureEntity2;
      if (localMap.containsKey(paramString)) {
        localFeatureEntity1 = (FeatureEntity)localMap.get(paramString);
      }
    }
    return localFeatureEntity1;
  }
  
  public Map<String, FeatureEntity> syncGetFeatures()
  {
    HashMap localHashMap = new HashMap();
    CacheManager localCacheManager = this.mCacheMgr;
    if (localCacheManager == null)
    {
      ABTestLog.warn("cacheMgr is null point, please check init feature", new Object[0]);
      return localHashMap;
    }
    return localCacheManager.getFeatureEntityMap();
  }
  
  public void unregisterFeatureInitListener(FeatureInitListener paramFeatureInitListener)
  {
    List localList = this.initListenerList;
    if ((localList != null) && (localList.contains(paramFeatureInitListener))) {
      this.initListenerList.remove(paramFeatureInitListener);
    }
  }
  
  public void unregisterFeatureUpdateListener(FeatureUpdateListener paramFeatureUpdateListener)
  {
    List localList = this.updateListenerList;
    if ((localList != null) && (localList.contains(paramFeatureUpdateListener))) {
      this.updateListenerList.remove(paramFeatureUpdateListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.FeatureClient
 * JD-Core Version:    0.7.0.1
 */