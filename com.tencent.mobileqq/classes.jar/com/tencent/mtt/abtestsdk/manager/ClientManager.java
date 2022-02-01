package com.tencent.mtt.abtestsdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.abtest.ExperimentClient;
import com.tencent.mtt.abtestsdk.abtest.FeatureClient;
import com.tencent.mtt.abtestsdk.abtest.RemoteConfigClient;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig.ClientType;
import com.tencent.mtt.abtestsdk.entity.ConfigValue;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.entity.FeatureEntity;
import com.tencent.mtt.abtestsdk.listener.ConfigValueChangeListener;
import com.tencent.mtt.abtestsdk.listener.ExpInitListener;
import com.tencent.mtt.abtestsdk.listener.FeatureInitListener;
import com.tencent.mtt.abtestsdk.listener.FeatureUpdateListener;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.GetFeatureListener;
import com.tencent.mtt.abtestsdk.report.BeaconReport;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientManager
{
  private CacheManager cacheMgr;
  private boolean isSDKInit = false;
  private ExperimentClient mABClient = new ExperimentClient();
  private ABTestConfig mConfig;
  private RemoteConfigClient mConfigClient = new RemoteConfigClient();
  private Context mContext;
  private FeatureClient mFeatureClient = new FeatureClient();
  private Handler mainHandler = new ClientManager.1(this, Looper.getMainLooper());
  
  public static ClientManager getInstance()
  {
    return ClientManager.ClientManagerHolder.access$100();
  }
  
  private void handleSDKInit(ABTestConfig paramABTestConfig)
  {
    paramABTestConfig = paramABTestConfig.getClientTypeList();
    if (paramABTestConfig.contains(ABTestConfig.ClientType.ABClient)) {
      this.mABClient.init(this.mContext, this.mConfig, this.mainHandler);
    }
    if (paramABTestConfig.contains(ABTestConfig.ClientType.FeatureClient)) {
      this.mFeatureClient.init(this.mContext, this.mConfig, this.mainHandler);
    }
    if (paramABTestConfig.contains(ABTestConfig.ClientType.RemoteConfigClient)) {
      this.mConfigClient.init(this.mContext, this.mConfig, this.mainHandler);
    }
  }
  
  private void initClientData()
  {
    boolean bool = this.mConfig.isDiskCache();
    this.cacheMgr = CacheManager.getInstance(this.mContext, bool);
    this.cacheMgr.saveCommonDeviceEntity(this.mConfig);
  }
  
  private void initSPBuglySDK()
  {
    this.mContext.getSharedPreferences("BuglySdkInfos", 0).edit().putString("4aeafa6143", "3.0.14").apply();
    ABTestLog.debug("[SDKInit] the Bugly SDK init finished", new Object[0]);
  }
  
  public List<String> getAllExpIds()
  {
    Object localObject = this.cacheMgr;
    int i = 0;
    if (localObject == null)
    {
      ABTestLog.error("[SDK_EXP] the cacheMgr is null", new Object[0]);
      return new ArrayList();
    }
    localObject = ((CacheManager)localObject).getCacheAllExpData();
    ArrayList localArrayList = new ArrayList();
    while (i < ((List)localObject).size())
    {
      ExpEntity localExpEntity = (ExpEntity)((List)localObject).get(i);
      if (localExpEntity != null) {
        localArrayList.add(localExpEntity.getGrayId());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void getAllExperiments(GetExperimentListener paramGetExperimentListener, int paramInt)
  {
    if (paramGetExperimentListener != null)
    {
      Object localObject = this.cacheMgr;
      if (localObject == null)
      {
        ABTestLog.error("[SDK_EXP] the cacheMgr is null", new Object[0]);
        return;
      }
      localObject = ((CacheManager)localObject).getCacheAllExpData();
      if (!((List)localObject).isEmpty())
      {
        ABTestLog.debug("get all exp data successfully from cache", new Object[0]);
        paramGetExperimentListener.getExperimentSucceed((List)localObject);
        return;
      }
      paramGetExperimentListener = new ClientManager.4(this, (List)localObject, paramGetExperimentListener);
      this.mABClient.fetchExpDataByNet("", paramGetExperimentListener, paramInt);
      return;
    }
    ABTestLog.error("the listener is null", new Object[0]);
    throw new NullPointerException("the listener is not null");
  }
  
  public ConfigValue getConfigValue(String paramString1, String paramString2)
  {
    paramString2 = new ConfigValue(paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    Object localObject = this.cacheMgr;
    if (localObject == null)
    {
      ABTestLog.configUpload("please check config and init the sdk", new Object[0]);
      return paramString2;
    }
    localObject = ((CacheManager)localObject).getRemoteConfigMap();
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      if (!((Map)localObject).containsKey(paramString1)) {
        return paramString2;
      }
      return (ConfigValue)((Map)localObject).get(paramString1);
    }
    return paramString2;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public ExpEntity getExpById(String paramString)
  {
    Object localObject = this.cacheMgr;
    int i = 0;
    if (localObject == null)
    {
      ABTestLog.error("[SDK_EXP] the cacheMgr is null", new Object[0]);
      return new ExpEntity("");
    }
    localObject = ((CacheManager)localObject).getCacheAllExpData();
    while (i < ((List)localObject).size())
    {
      ExpEntity localExpEntity = (ExpEntity)((List)localObject).get(i);
      if ((localExpEntity != null) && (TextUtils.equals(paramString, localExpEntity.getGrayId()))) {
        return localExpEntity;
      }
      i += 1;
    }
    return new ExpEntity("");
  }
  
  public ExpEntity getExpByLayerCode(String paramString)
  {
    ExpEntity localExpEntity = new ExpEntity("");
    Object localObject = this.cacheMgr;
    if (localObject == null)
    {
      ABTestLog.error("[SDK_EXP] the cacheMgr is null", new Object[0]);
      return localExpEntity;
    }
    Map localMap = ((CacheManager)localObject).getExpEntityMap();
    localObject = localExpEntity;
    if (localMap != null)
    {
      localObject = localExpEntity;
      if (!localMap.isEmpty())
      {
        paramString = (ExpEntity)localMap.get(paramString);
        localObject = paramString;
        if (paramString != null) {}
      }
    }
    return localObject;
  }
  
  public void getExpByName(@NonNull String paramString, @NonNull GetExperimentListener paramGetExperimentListener, int paramInt, boolean paramBoolean)
  {
    if (this.cacheMgr == null)
    {
      paramGetExperimentListener.getExperimentFailed(1001, "sdk not init");
      ABTestLog.expUpload("sdk not init", new Object[0]);
      return;
    }
    long l = System.currentTimeMillis();
    String str;
    if (paramBoolean) {
      str = "getExpByNameWithExpose";
    } else {
      str = "getExpByName";
    }
    ExpEntity localExpEntity = this.cacheMgr.getCacheExpByName(paramString);
    boolean bool = localExpEntity.isDefaultRomaExp();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localExpEntity);
    if (!bool)
    {
      paramString = new StringBuilder();
      paramString.append("expose:");
      paramString.append(paramBoolean);
      paramString.append(", get data successfully from cache");
      ABTestLog.debug(paramString.toString(), new Object[0]);
      if (paramBoolean) {
        reportExpExpose(localExpEntity, "0");
      }
      paramGetExperimentListener.getExperimentSucceed(localArrayList);
      reportBeaconApiEvent(str, true, System.currentTimeMillis() - l);
      return;
    }
    paramGetExperimentListener = new ClientManager.3(this, paramString, paramBoolean, localArrayList, l, str, paramGetExperimentListener);
    this.mABClient.fetchExpDataByNet(paramString, paramGetExperimentListener, paramInt);
  }
  
  public void getFeatureByKey(String paramString, GetFeatureListener paramGetFeatureListener, int paramInt)
  {
    FeatureClient localFeatureClient = this.mFeatureClient;
    if (localFeatureClient == null)
    {
      ABTestLog.error("featureClient is null and check whether to initialize SDK", new Object[0]);
      paramGetFeatureListener.getFeatureFailed(1008, "client not init");
      return;
    }
    localFeatureClient.getFeatureByKey(paramString, paramGetFeatureListener, paramInt);
  }
  
  public void init(@Nullable WeakReference<Context> paramWeakReference, ABTestConfig paramABTestConfig)
  {
    if (this.isSDKInit)
    {
      ABTestLog.error("[SDKInit] Please do not repeat the initialization SDK", new Object[0]);
      return;
    }
    this.mContext = ((Context)paramWeakReference.get());
    this.mConfig = paramABTestConfig;
    initSPBuglySDK();
    initClientData();
    handleSDKInit(this.mConfig);
    this.isSDKInit = true;
  }
  
  public void registerExpInitListener(ExpInitListener paramExpInitListener)
  {
    if (paramExpInitListener == null)
    {
      ABTestLog.error("please check experiment register params and listener is not empty", new Object[0]);
      return;
    }
    if (this.mABClient == null) {
      paramExpInitListener.expInitFailed();
    }
    this.mABClient.registerExpInitListener(paramExpInitListener);
  }
  
  public void registerFeatureInitListener(FeatureInitListener paramFeatureInitListener)
  {
    if (paramFeatureInitListener == null)
    {
      ABTestLog.error("please check feature init register params and listener is not empty", new Object[0]);
      return;
    }
    FeatureClient localFeatureClient = this.mFeatureClient;
    if (localFeatureClient == null)
    {
      paramFeatureInitListener.featureInitFailed(1008, "client not init");
      return;
    }
    localFeatureClient.registerFeatureInitListener(paramFeatureInitListener);
  }
  
  public void registerFeatureUpdateListener(FeatureUpdateListener paramFeatureUpdateListener)
  {
    if (paramFeatureUpdateListener == null)
    {
      ABTestLog.error("please check feature update register params and listener is not empty", new Object[0]);
      return;
    }
    if (this.mFeatureClient == null) {
      paramFeatureUpdateListener.updateFeatureFailed();
    }
    this.mFeatureClient.registerFeatureUpdateListener(paramFeatureUpdateListener);
  }
  
  public void registerValueChangeListener(String paramString, ConfigValueChangeListener paramConfigValueChangeListener)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramConfigValueChangeListener != null))
    {
      RemoteConfigClient localRemoteConfigClient = this.mConfigClient;
      if (localRemoteConfigClient == null)
      {
        ABTestLog.error("mConfigClient is null and check whether to initialize SDK", new Object[0]);
        return;
      }
      localRemoteConfigClient.registerValueChangeListener(paramString, paramConfigValueChangeListener);
      return;
    }
    ABTestLog.error("please check config register value params and params is not empty", new Object[0]);
  }
  
  public boolean reportBeaconApiEvent(String paramString, boolean paramBoolean, long paramLong)
  {
    for (;;)
    {
      try
      {
        localObject2 = this.mConfig.getGuid();
        String str2 = ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig);
        if (paramBoolean)
        {
          Object localObject1 = "1";
          paramBoolean = BeaconReport.reportApiEvent("TabApiEvent", (String)localObject2, str2, paramString, (String)localObject1, String.valueOf(paramLong));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" api report event ");
          ((StringBuilder)localObject1).append(paramBoolean);
          ABTestLog.stepReport(((StringBuilder)localObject1).toString(), new Object[0]);
          return paramBoolean;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("beacon report ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" failed!  ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        ABTestLog.stepReport(((StringBuilder)localObject2).toString(), new Object[0]);
        return false;
      }
      String str1 = "0";
    }
  }
  
  public void reportExpExpose(ExpEntity paramExpEntity, String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = paramExpEntity.getExpName();
    String str = paramExpEntity.getAssignment();
    paramExpEntity = paramExpEntity.getGrayId();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("default".equals(str)))
    {
      ABTestLog.stepReport("assignment is default and give up reporting", new Object[0]);
      return;
    }
    boolean bool = this.mABClient.reportBeaconExpExpose(paramExpEntity, (String)localObject, paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report beacon status: ");
    ((StringBuilder)localObject).append(bool);
    ABTestLog.stepReport(((StringBuilder)localObject).toString(), new Object[0]);
    if (bool)
    {
      reportBeaconApiEvent("reportExpExpose", true, System.currentTimeMillis() - l);
      return;
    }
    this.mABClient.reportExpAttaExpose(paramExpEntity, paramString);
    reportBeaconApiEvent("reportExpExpose", false, System.currentTimeMillis());
  }
  
  public void switchAccountId(String paramString, GetExperimentListener paramGetExperimentListener)
  {
    CacheManager.getInstance(this.mContext, this.mConfig.isDiskCache()).putStringToDisk("Tabcommon", "guid", paramString);
    this.mConfig.setGuid(paramString);
    paramString = new ClientManager.2(this, new ArrayList(), paramGetExperimentListener);
    this.mABClient.fetchExpDataByNet("", paramString, 0);
  }
  
  public void switchFeatureUserID(String paramString)
  {
    if (this.mFeatureClient == null)
    {
      ABTestLog.error("please init the feature", new Object[0]);
      return;
    }
    CacheManager.getInstance(this.mContext, this.mConfig.isDiskCache()).putStringToDisk("Tabcommon", "guid", paramString);
    this.mConfig.setGuid(paramString);
    this.mFeatureClient.handleIntervalFetchFeatureByNet(null, 0);
  }
  
  public ExpEntity syncGetExpByName(@NonNull String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.cacheMgr;
      if (localObject != null)
      {
        paramString = ((CacheManager)localObject).getCacheExpByName(paramString);
        if (!paramString.isDefaultRomaExp())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("expose：");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(" get data successfully");
          ABTestLog.debug(((StringBuilder)localObject).toString(), new Object[0]);
          if (paramBoolean) {
            reportExpExpose(paramString, "0");
          }
        }
        return paramString;
      }
      ABTestLog.error("[SDK_EXP] please init SDK", new Object[0]);
      throw new NullPointerException("please init SDK");
    }
    paramString = new StringBuilder();
    paramString.append("expose：");
    paramString.append(paramBoolean);
    paramString.append("  expName must be not empty");
    ABTestLog.error(paramString.toString(), new Object[0]);
    throw new NullPointerException("expName must be not empty");
  }
  
  public FeatureEntity syncGetFeatureByKey(String paramString)
  {
    FeatureEntity localFeatureEntity = new FeatureEntity();
    if (this.mFeatureClient == null)
    {
      ABTestLog.error("featureClient is null and check whether to initialize SDK", new Object[0]);
      return localFeatureEntity;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ABTestLog.error("invalid featureKey", new Object[0]);
      return localFeatureEntity;
    }
    return this.mFeatureClient.syncGetFeatureByKey(paramString);
  }
  
  public Map<String, FeatureEntity> syncGetFeatures()
  {
    HashMap localHashMap = new HashMap();
    FeatureClient localFeatureClient = this.mFeatureClient;
    if (localFeatureClient == null)
    {
      ABTestLog.error("please init the feature", new Object[0]);
      return localHashMap;
    }
    return localFeatureClient.syncGetFeatures();
  }
  
  public void unregisterExpInitListener(ExpInitListener paramExpInitListener)
  {
    if (paramExpInitListener == null)
    {
      ABTestLog.error("please check experiment register params and listener is not empty", new Object[0]);
      return;
    }
    if (this.mABClient == null) {
      paramExpInitListener.expInitFailed();
    }
    this.mABClient.unregisterExpInitListener(paramExpInitListener);
  }
  
  public void unregisterFeatureInitListener(FeatureInitListener paramFeatureInitListener)
  {
    if (paramFeatureInitListener == null)
    {
      ABTestLog.error("please check feature init unregister params and listener is not empty", new Object[0]);
      return;
    }
    FeatureClient localFeatureClient = this.mFeatureClient;
    if (localFeatureClient == null)
    {
      paramFeatureInitListener.featureInitFailed(1008, "client not init");
      return;
    }
    localFeatureClient.unregisterFeatureInitListener(paramFeatureInitListener);
  }
  
  public void unregisterFeatureUpdateListener(FeatureUpdateListener paramFeatureUpdateListener)
  {
    if (paramFeatureUpdateListener == null)
    {
      ABTestLog.error("please check feature update unregister params and listener is not empty", new Object[0]);
      return;
    }
    if (this.mFeatureClient == null) {
      paramFeatureUpdateListener.updateFeatureFailed();
    }
    this.mFeatureClient.unregisterFeatureUpdateListener(paramFeatureUpdateListener);
  }
  
  public void unregisterValueChangeListener(String paramString)
  {
    RemoteConfigClient localRemoteConfigClient = this.mConfigClient;
    if (localRemoteConfigClient == null)
    {
      ABTestLog.error("mConfigClient is null and check whether to initialize SDK", new Object[0]);
      return;
    }
    localRemoteConfigClient.unregisterValueChangeListener(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.manager.ClientManager
 * JD-Core Version:    0.7.0.1
 */