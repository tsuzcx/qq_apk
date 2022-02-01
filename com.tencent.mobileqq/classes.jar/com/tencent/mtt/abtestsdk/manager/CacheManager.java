package com.tencent.mtt.abtestsdk.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.ConfigValue;
import com.tencent.mtt.abtestsdk.entity.DeviceEntity;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.entity.ExpStrategyEntity;
import com.tencent.mtt.abtestsdk.entity.FeatureEntity;
import com.tencent.mtt.abtestsdk.entity.FeatureStrategyEntity;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import com.tencent.mtt.abtestsdk.utils.SystemUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class CacheManager
{
  public static final String MMKV_FILE_TAB_COMMON = "Tabcommon";
  public static final String MMKV_FILE_TAB_FEATURE = "Tabfeature";
  public static final String MMKV_FILE_TAB_REMOTE_CONFIG = "Tabremote_config";
  public static final String MMKV_FILE_TAB_TEST = "Tababtest";
  private static volatile CacheManager singleton;
  private Context mContext;
  private boolean mIsDiskCache = true;
  private MMKV mMMKVFeature;
  private MMKV mMMKVRemoteConfig;
  private MMKV mMMKVTabCommon;
  private MMKV mMMKVTabTest;
  private LruCache<String, Object> mMemoryCache;
  
  private CacheManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mMemoryCache = new LruCache(ABTestUtil.maxMemCacheSize());
    this.mIsDiskCache = paramBoolean;
    initMMKV();
    initData();
  }
  
  private ConcurrentHashMap<String, ExpEntity> getExpEntityMapFromDisk()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    String str = this.mMMKVTabTest.a("exp_data");
    if (!TextUtils.isEmpty(str)) {
      localConcurrentHashMap = (ConcurrentHashMap)new Gson().fromJson(str, new CacheManager.2(this).getType());
    }
    return localConcurrentHashMap;
  }
  
  private ExpStrategyEntity getExpReportStrategyFromDisk()
  {
    ExpStrategyEntity localExpStrategyEntity = new ExpStrategyEntity();
    boolean bool = this.mMMKVTabTest.b("enableReport", false);
    Object localObject = this.mMMKVTabTest.b("id", "");
    String str = this.mMMKVTabTest.b("token", "");
    int i = this.mMMKVTabTest.c("refreshDuration", 30);
    long l = this.mMMKVTabTest.b("updateTime", 0L);
    localExpStrategyEntity.setEnableReport(bool);
    localExpStrategyEntity.setReportId((String)localObject);
    localExpStrategyEntity.setReportToken(str);
    localExpStrategyEntity.setRefreshDuration(i);
    localExpStrategyEntity.setLastFetchDataTime(Long.valueOf(l).longValue());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getExpReportStrategyFromDisk:");
    ((StringBuilder)localObject).append(localExpStrategyEntity.toString());
    ABTestLog.debug(((StringBuilder)localObject).toString(), new Object[0]);
    return localExpStrategyEntity;
  }
  
  private Map<String, FeatureEntity> getFeatureEntityMapFromDisk()
  {
    Object localObject1 = new HashMap();
    Object localObject2 = this.mMMKVFeature.a("feature_data");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (Map)new Gson().fromJson((String)localObject2, new CacheManager.3(this).getType());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getFeatureEntityMapFromDisk:");
    ((StringBuilder)localObject2).append(localObject1.toString());
    ABTestLog.debug(((StringBuilder)localObject2).toString(), new Object[0]);
    return localObject1;
  }
  
  private FeatureStrategyEntity getFeatureReportStrategyFromDisk()
  {
    FeatureStrategyEntity localFeatureStrategyEntity = new FeatureStrategyEntity();
    boolean bool = this.mMMKVFeature.b("enableReport", false);
    int i = this.mMMKVFeature.c("sdkReportRate", 0);
    Object localObject = this.mMMKVFeature.b("reportType", "atta");
    String str1 = this.mMMKVFeature.b("reportId", "");
    String str2 = this.mMMKVFeature.b("reportToken", "");
    long l = this.mMMKVFeature.b("reportLastFetchTime", 0L);
    localFeatureStrategyEntity.setEnableReport(bool);
    localFeatureStrategyEntity.setReportInter(i);
    localFeatureStrategyEntity.setReportType((String)localObject);
    localFeatureStrategyEntity.setReportId(str1);
    localFeatureStrategyEntity.setReportToken(str2);
    localFeatureStrategyEntity.setLastFetchTime(l);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getFeatureReportStrategyFromDisk:");
    ((StringBuilder)localObject).append(localFeatureStrategyEntity.toString());
    ABTestLog.debug(((StringBuilder)localObject).toString(), new Object[0]);
    return localFeatureStrategyEntity;
  }
  
  public static CacheManager getInstance(Context paramContext, boolean paramBoolean)
  {
    if (singleton == null) {
      try
      {
        if (singleton == null) {
          singleton = new CacheManager(paramContext, paramBoolean);
        }
      }
      finally {}
    }
    return singleton;
  }
  
  private long getRemoteConfigFetchTimeFromDisk()
  {
    return this.mMMKVRemoteConfig.b("config_last_update_time", 0L);
  }
  
  private Map<String, ConfigValue> getRemoteConfigMapFromDisk()
  {
    Object localObject1 = new HashMap();
    Object localObject2 = this.mMMKVRemoteConfig.a("remote_config_data");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (Map)new Gson().fromJson((String)localObject2, new CacheManager.4(this).getType());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getRemoteConfigMapFromDisk:");
    ((StringBuilder)localObject2).append(localObject1.toString());
    ABTestLog.debug(((StringBuilder)localObject2).toString(), new Object[0]);
    return localObject1;
  }
  
  private String getRemoteConfigVersionFromDisk()
  {
    return this.mMMKVRemoteConfig.b("config_last_update_version", "");
  }
  
  private void initData()
  {
    this.mMMKVTabCommon = MMKV.a("Tabcommon", 2);
    this.mMMKVTabTest = MMKV.a("Tababtest", 2);
    this.mMMKVFeature = MMKV.a("Tabfeature", 2);
    this.mMMKVRemoteConfig = MMKV.a("Tabremote_config", 2);
  }
  
  private void initMMKV()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/mmkv");
    localObject = ((StringBuilder)localObject).toString();
    ABTestLog.debug(String.format("initMMKV Dir: %s", new Object[] { localObject }), new Object[0]);
    try
    {
      MMKV.a((String)localObject, new CacheManager.1(this));
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initMMKV: ");
      localStringBuilder.append(localException.getMessage());
      ABTestLog.error(localStringBuilder.toString(), new Object[0]);
    }
  }
  
  private void saveExpEntityMapToDisk(Map<String, ExpEntity> paramMap)
  {
    paramMap = new Gson().toJson(paramMap);
    this.mMMKVTabTest.a("exp_data", paramMap);
  }
  
  private void saveExpReportStrategyToDisk(ExpStrategyEntity paramExpStrategyEntity)
  {
    this.mMMKVTabTest.a("enableReport", paramExpStrategyEntity.isEnableReport());
    this.mMMKVTabTest.a("id", paramExpStrategyEntity.getReportId());
    this.mMMKVTabTest.a("token", paramExpStrategyEntity.getReportToken());
    this.mMMKVTabTest.b("refreshDuration", paramExpStrategyEntity.getRefreshDuration());
    this.mMMKVTabTest.a("updateTime", paramExpStrategyEntity.getLastFetchDataTime());
  }
  
  private void saveFeatureEntityMapToDisk(Map<String, FeatureEntity> paramMap)
  {
    paramMap = new JSONObject(paramMap).toString();
    this.mMMKVFeature.a("feature_data", paramMap);
  }
  
  private void saveFeatureReportStrategyToDisk(FeatureStrategyEntity paramFeatureStrategyEntity)
  {
    this.mMMKVFeature.a("enableReport", paramFeatureStrategyEntity.isEnableReport());
    this.mMMKVFeature.b("sdkReportRate", paramFeatureStrategyEntity.getReportInter());
    this.mMMKVFeature.a("reportType", paramFeatureStrategyEntity.getReportType());
    this.mMMKVFeature.a("reportId", paramFeatureStrategyEntity.getReportId());
    this.mMMKVFeature.a("reportToken", paramFeatureStrategyEntity.getReportToken());
    this.mMMKVFeature.a("reportLastFetchTime", paramFeatureStrategyEntity.getLastFetchTime());
  }
  
  private void saveRemoteConfigFetchTimeToDisk(long paramLong)
  {
    this.mMMKVRemoteConfig.a("config_last_update_time", paramLong);
  }
  
  private void saveRemoteConfigMapToDisk(Map<String, ConfigValue> paramMap)
  {
    paramMap = new JSONObject(paramMap).toString();
    this.mMMKVRemoteConfig.a("remote_config_data", paramMap);
  }
  
  private void saveRemoteConfigVersionToDisk(String paramString)
  {
    this.mMMKVRemoteConfig.a("config_last_update_version", paramString);
  }
  
  public List<ExpEntity> getCacheAllExpData()
  {
    ArrayList localArrayList2 = new ArrayList();
    ConcurrentHashMap localConcurrentHashMap = getExpEntityMap();
    ArrayList localArrayList1 = localArrayList2;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.isEmpty()) {
        return localArrayList2;
      }
      localArrayList1 = new ArrayList(localConcurrentHashMap.values());
    }
    return localArrayList1;
  }
  
  public ExpEntity getCacheExpByName(String paramString)
  {
    ExpEntity localExpEntity1 = new ExpEntity(paramString);
    Object localObject = getExpEntityMap();
    if (localObject != null)
    {
      if (((ConcurrentHashMap)localObject).isEmpty()) {
        return localExpEntity1;
      }
      localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ExpEntity localExpEntity2 = (ExpEntity)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localExpEntity2 != null) && (TextUtils.equals(localExpEntity2.getExpName(), paramString))) {
          return localExpEntity2;
        }
      }
    }
    return localExpEntity1;
  }
  
  public DeviceEntity getCommonDeviceEntity()
  {
    DeviceEntity localDeviceEntity = new DeviceEntity();
    String str1 = this.mMMKVTabCommon.b("ENV", "RELEASE");
    String str2 = this.mMMKVTabCommon.b("guid", "");
    String str3 = this.mMMKVTabCommon.b("language", SystemUtil.getSystemLanguage());
    String str4 = this.mMMKVTabCommon.b("os_version", SystemUtil.getSystemVersion());
    String str5 = this.mMMKVTabCommon.b("device_brand", SystemUtil.getDeviceBrand());
    String str6 = this.mMMKVTabCommon.b("device_version", SystemUtil.getSystemModel());
    String str7 = this.mMMKVTabCommon.b("device_width", String.valueOf(SystemUtil.getWidth(this.mContext)));
    String str8 = this.mMMKVTabCommon.b("device_height", String.valueOf(SystemUtil.getHeight(this.mContext)));
    String str9 = this.mMMKVTabCommon.b("bundle_package_name", String.valueOf(SystemUtil.getAppInfo(this.mContext)));
    String str10 = this.mMMKVTabCommon.b("bundle_version", String.valueOf(SystemUtil.getVersionName(this.mContext)));
    localDeviceEntity.setEnv(str1);
    localDeviceEntity.setGuid(str2);
    localDeviceEntity.setLanguage(str3);
    localDeviceEntity.setOsVersion(str4);
    localDeviceEntity.setDeviceBrand(str5);
    localDeviceEntity.setDeviceVersion(str6);
    localDeviceEntity.setDeviceWidth(str7);
    localDeviceEntity.setDeviceHeight(str8);
    localDeviceEntity.setBundleId(str9);
    localDeviceEntity.setBundleVersion(str10);
    ABTestLog.debug(String.format("getCommonDeviceEntityFromDisk: %s", new Object[] { localDeviceEntity.toString() }), new Object[0]);
    return localDeviceEntity;
  }
  
  public ConcurrentHashMap<String, ExpEntity> getExpEntityMap()
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mMemoryCache.get("exp_data");
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (this.mIsDiskCache) {
      if (localConcurrentHashMap2 != null)
      {
        localConcurrentHashMap1 = localConcurrentHashMap2;
        if (!localConcurrentHashMap2.isEmpty()) {}
      }
      else
      {
        localConcurrentHashMap1 = getExpEntityMapFromDisk();
      }
    }
    return localConcurrentHashMap1;
  }
  
  public ExpStrategyEntity getExpReportStrategy()
  {
    ExpStrategyEntity localExpStrategyEntity2 = (ExpStrategyEntity)this.mMemoryCache.get("exp_strategy");
    ExpStrategyEntity localExpStrategyEntity1 = localExpStrategyEntity2;
    if (this.mIsDiskCache)
    {
      localExpStrategyEntity1 = localExpStrategyEntity2;
      if (localExpStrategyEntity2 == null) {
        localExpStrategyEntity1 = getExpReportStrategyFromDisk();
      }
    }
    return localExpStrategyEntity1;
  }
  
  public Map<String, FeatureEntity> getFeatureEntityMap()
  {
    new HashMap();
    Map localMap2 = (Map)this.mMemoryCache.get("feature_data");
    Map localMap1 = localMap2;
    if (this.mIsDiskCache) {
      if (localMap2 != null)
      {
        localMap1 = localMap2;
        if (!localMap2.isEmpty()) {}
      }
      else
      {
        localMap1 = getFeatureEntityMapFromDisk();
      }
    }
    return localMap1;
  }
  
  public FeatureStrategyEntity getFeatureReportStrategy()
  {
    FeatureStrategyEntity localFeatureStrategyEntity2 = (FeatureStrategyEntity)this.mMemoryCache.get("feature_strategy");
    FeatureStrategyEntity localFeatureStrategyEntity1 = localFeatureStrategyEntity2;
    if (this.mIsDiskCache)
    {
      localFeatureStrategyEntity1 = localFeatureStrategyEntity2;
      if (localFeatureStrategyEntity2 == null) {
        localFeatureStrategyEntity1 = getFeatureReportStrategyFromDisk();
      }
    }
    return localFeatureStrategyEntity1;
  }
  
  public long getRemoteConfigFetchTime()
  {
    long l;
    if (this.mMemoryCache.get("config_last_update_time") == null) {
      l = System.currentTimeMillis();
    } else {
      l = ((Long)this.mMemoryCache.get("config_last_update_time")).longValue();
    }
    if ((this.mIsDiskCache) && (l == 0L)) {
      getRemoteConfigFetchTimeFromDisk();
    }
    return 0L;
  }
  
  public List<String> getRemoteConfigKeysList()
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap = getRemoteConfigMap();
    if ((localMap == null) && (localMap.isEmpty()))
    {
      ABTestLog.warn("[get_remote_config_key] defaultConfigMap data is empty", new Object[0]);
      return localArrayList;
    }
    return new ArrayList(localMap.keySet());
  }
  
  public Map<String, ConfigValue> getRemoteConfigMap()
  {
    new HashMap();
    Map localMap2 = (Map)this.mMemoryCache.get("remote_config_data");
    Map localMap1 = localMap2;
    if (this.mIsDiskCache) {
      if (localMap2 != null)
      {
        localMap1 = localMap2;
        if (!localMap2.isEmpty()) {}
      }
      else
      {
        localMap1 = getRemoteConfigMapFromDisk();
      }
    }
    return localMap1;
  }
  
  public String getRemoteConfigVersion()
  {
    String str;
    if (this.mMemoryCache.get("config_last_update_version") == null) {
      str = "0";
    } else {
      str = (String)this.mMemoryCache.get("config_last_update_version");
    }
    if (this.mIsDiskCache) {
      str = getRemoteConfigVersionFromDisk();
    }
    return str;
  }
  
  public String getStringFromDisk(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      int i = -1;
      switch (paramString1.hashCode())
      {
      default: 
        break;
      case -232241760: 
        if (paramString1.equals("Tabcommon")) {
          i = 0;
        }
        break;
      case -301304856: 
        if (paramString1.equals("Tababtest")) {
          i = 1;
        }
        break;
      case -539175455: 
        if (paramString1.equals("Tabfeature")) {
          i = 2;
        }
        break;
      case -1827206138: 
        if (paramString1.equals("Tabremote_config")) {
          i = 3;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              ABTestLog.warn("mmkvName data not match format", new Object[0]);
              return "";
            }
            return this.mMMKVRemoteConfig.b(paramString2, paramString3);
          }
          return this.mMMKVFeature.b(paramString2, paramString3);
        }
        return this.mMMKVTabTest.b(paramString2, paramString3);
      }
      return this.mMMKVTabCommon.b(paramString2, paramString3);
    }
    return "";
  }
  
  public void putStringToDisk(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = -1;
      switch (paramString1.hashCode())
      {
      default: 
        break;
      case -232241760: 
        if (paramString1.equals("Tabcommon")) {
          i = 0;
        }
        break;
      case -301304856: 
        if (paramString1.equals("Tababtest")) {
          i = 1;
        }
        break;
      case -539175455: 
        if (paramString1.equals("Tabfeature")) {
          i = 2;
        }
        break;
      case -1827206138: 
        if (paramString1.equals("Tabremote_config")) {
          i = 3;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              ABTestLog.warn("mmkvName data not match format", new Object[0]);
              return;
            }
            this.mMMKVRemoteConfig.a(paramString2, paramString3);
            return;
          }
          this.mMMKVFeature.a(paramString2, paramString3);
          return;
        }
        this.mMMKVTabTest.a(paramString2, paramString3);
        return;
      }
      this.mMMKVTabCommon.a(paramString2, paramString3);
    }
  }
  
  public void saveCommonDeviceEntity(ABTestConfig paramABTestConfig)
  {
    this.mMMKVTabCommon.a("ENV", paramABTestConfig.getCurEnv());
    this.mMMKVTabCommon.a("guid", paramABTestConfig.getGuid());
    this.mMMKVTabCommon.a("disk_cache", paramABTestConfig.isDiskCache());
    this.mMMKVTabCommon.a("language", SystemUtil.getSystemLanguage());
    this.mMMKVTabCommon.a("os_version", SystemUtil.getSystemVersion());
    this.mMMKVTabCommon.a("device_brand", SystemUtil.getDeviceBrand());
    this.mMMKVTabCommon.a("device_version", SystemUtil.getSystemModel());
    this.mMMKVTabCommon.a("device_width", String.valueOf(SystemUtil.getWidth(this.mContext)));
    this.mMMKVTabCommon.a("device_height", String.valueOf(SystemUtil.getHeight(this.mContext)));
    this.mMMKVTabCommon.a("bundle_package_name", String.valueOf(SystemUtil.getAppInfo(this.mContext)));
    this.mMMKVTabCommon.a("bundle_version", String.valueOf(SystemUtil.getVersionName(this.mContext)));
  }
  
  public void saveExpEntityMap(Map<String, ExpEntity> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.mMemoryCache.put("exp_data", paramMap);
      if (this.mIsDiskCache) {
        saveExpEntityMapToDisk(paramMap);
      }
      return;
    }
    ABTestLog.warn("[save_exp_data] expEntityMap is null", new Object[0]);
  }
  
  public void saveExpReportStrategy(ExpStrategyEntity paramExpStrategyEntity)
  {
    if (paramExpStrategyEntity == null)
    {
      ABTestLog.warn("[save_exp_report_data] expReportEntity is null", new Object[0]);
      return;
    }
    this.mMemoryCache.put("exp_strategy", paramExpStrategyEntity);
    if (this.mIsDiskCache) {
      saveExpReportStrategyToDisk(paramExpStrategyEntity);
    }
  }
  
  public void saveFeatureEntityMap(Map<String, FeatureEntity> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.mMemoryCache.put("feature_data", paramMap);
      if (this.mIsDiskCache) {
        saveFeatureEntityMapToDisk(paramMap);
      }
      return;
    }
    ABTestLog.warn("[save_feature_data] featureEntityMap data is empty", new Object[0]);
  }
  
  public void saveFeatureReportStrategy(FeatureStrategyEntity paramFeatureStrategyEntity)
  {
    if (paramFeatureStrategyEntity == null)
    {
      ABTestLog.warn("[save_feature_report_data] featureReportEntity is null", new Object[0]);
      return;
    }
    this.mMemoryCache.put("feature_strategy", paramFeatureStrategyEntity);
    if (this.mIsDiskCache) {
      saveFeatureReportStrategyToDisk(paramFeatureStrategyEntity);
    }
  }
  
  public void saveRemoteConfigFetchTime(long paramLong)
  {
    this.mMemoryCache.put("config_last_update_time", Long.valueOf(paramLong));
    if (this.mIsDiskCache) {
      saveRemoteConfigFetchTimeToDisk(paramLong);
    }
  }
  
  public void saveRemoteConfigMap(Map<String, ConfigValue> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.mMemoryCache.put("remote_config_data", paramMap);
      if (this.mIsDiskCache) {
        saveRemoteConfigMapToDisk(paramMap);
      }
      return;
    }
    ABTestLog.warn("[save_remote_config_data] defaultConfigMap data is empty", new Object[0]);
  }
  
  public void saveRemoteConfigVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ABTestLog.warn("[save_remote_config_version] fetchVersion is empty", new Object[0]);
      return;
    }
    this.mMemoryCache.put("config_last_update_version", paramString);
    if (this.mIsDiskCache) {
      saveRemoteConfigVersionToDisk(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.manager.CacheManager
 * JD-Core Version:    0.7.0.1
 */