package com.tencent.upload.common;

import android.content.Context;
import com.tencent.upload.network.route.IUploadRouteStrategy.RouteCategoryType;
import com.tencent.upload.network.route.RecentRouteRecord;
import com.tencent.upload.network.route.RecentRouteRecordStorage;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.utils.UploadLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public final class UploadConfiguration
{
  private static final int CONNECTION_TIMEOUT_MS = 20000;
  private static final int DATA_TIMEOUT_MS = 60000;
  private static final int[] DEFAULT_MAS_SEGMENT_SIZE_ARRAY = { 1440, 1200, 700 };
  public static final List DEF_PORTS = Arrays.asList(new Integer[] { Integer.valueOf(80), Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(14000) });
  private static final int DOMAIN_NAME_PARSE_TIMEOUT_MS = 20000;
  private static final int MAX_SESSION_PACKET_SIZE_BYTE = 2097152;
  private static final String TAG = "Configuration";
  @Deprecated
  public static final HashMap<String, Integer> UPLOAD_IP_TIMEOUT_MAP = new HashMap();
  private static volatile long[] sServerTimePair;
  
  public static final void checkVaildConnection(Context paramContext, Long paramLong, String paramString)
  {
    Utility.keepLongConnection(paramContext, paramLong, paramString);
  }
  
  public static final String getChangeRouteRetCode()
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getChangeRouteRetCodes();
    }
    return null;
  }
  
  public static final int getConnectionTimeout()
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getConnectTimeout() * 1000;
    }
    return 20000;
  }
  
  public static final String getCurrentApn()
  {
    return UploadGlobalConfig.getUploadEnv().getApnName();
  }
  
  public static int getCurrentNetworkCategory()
  {
    return UploadGlobalConfig.getUploadEnv().getCurrentNetworkCategory();
  }
  
  public static final int getCurrentOperatorCategory()
  {
    IUploadEnv localIUploadEnv = UploadGlobalConfig.getUploadEnv();
    if (localIUploadEnv == null) {
      return 0;
    }
    if (localIUploadEnv.isMobile()) {
      return localIUploadEnv.getMobileOperatorCategory();
    }
    if (localIUploadEnv.isWifi()) {
      return getWifiOperatorCategory();
    }
    return 0;
  }
  
  public static final int getDataTimeout()
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getDataTimeout() * 1000;
    }
    return 60000;
  }
  
  public static final int getDoNotFragment()
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig == null) {
      return 1;
    }
    return localIUploadConfig.getDoNotFragment();
  }
  
  public static final int getDomainNameParseTimeout()
  {
    return 20000;
  }
  
  public static final String getExifTagCode(String paramString)
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig == null) {
      return null;
    }
    return localIUploadConfig.getExifTagCode(paramString);
  }
  
  public static int getGifUploadLimit(int paramInt)
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig == null) {
      return 5242880;
    }
    return localIUploadConfig.getGifUploadLimit(paramInt);
  }
  
  public static final int getMaxSegmentSize(String paramString)
  {
    if (!isWifiSetting()) {
      return -1;
    }
    synchronized (UPLOAD_IP_TIMEOUT_MAP)
    {
      Object localObject = (Integer)UPLOAD_IP_TIMEOUT_MAP.get(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = Integer.valueOf(0);
      }
      localObject = UploadGlobalConfig.getConfig();
      if (localObject == null) {
        return DEFAULT_MAS_SEGMENT_SIZE_ARRAY[(paramString.intValue() % DEFAULT_MAS_SEGMENT_SIZE_ARRAY.length)];
      }
      ??? = null;
      HashMap localHashMap1;
      try
      {
        String str = ((IUploadConfig)localObject).getMaxSegmentSizeArray();
        localObject = ???;
        if (str != null)
        {
          localObject = ???;
          if (str.length() > 0) {
            localObject = str.split("\\|");
          }
        }
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        UploadLog.w("Configuration", localPatternSyntaxException.toString());
        localHashMap1 = ???;
      }
      if ((localHashMap1 != null) && (localHashMap1.length != 0))
      {
        localHashMap1 = localHashMap1[(paramString.intValue() % localHashMap1.length)];
        try
        {
          int i = Math.max(Integer.parseInt(localHashMap1), 64);
          return i;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          UploadLog.w("Configuration", localNumberFormatException.toString());
          return DEFAULT_MAS_SEGMENT_SIZE_ARRAY[(paramString.intValue() % DEFAULT_MAS_SEGMENT_SIZE_ARRAY.length)];
        }
      }
      return DEFAULT_MAS_SEGMENT_SIZE_ARRAY[(paramString.intValue() % DEFAULT_MAS_SEGMENT_SIZE_ARRAY.length)];
    }
  }
  
  public static final int getMaxSessionPacketSize()
  {
    return 2097152;
  }
  
  public static final String getNetworkUnavailableRetCode()
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getNetworkUnavailableRetCodes();
    }
    return null;
  }
  
  public static final int getPictureQuality(String paramString)
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig == null) {
      return 0;
    }
    return (int)localIUploadConfig.getPictureQuality(paramString);
  }
  
  public static final String getProviderName()
  {
    return UploadGlobalConfig.getUploadEnv().getProviderName();
  }
  
  public static final String getRecentRouteApnKey()
  {
    IUploadEnv localIUploadEnv = UploadGlobalConfig.getUploadEnv();
    if (localIUploadEnv == null) {
      return null;
    }
    if (localIUploadEnv.isMobile()) {
      return localIUploadEnv.getApnName();
    }
    if (localIUploadEnv.isWifi()) {
      return localIUploadEnv.getBSSID();
    }
    return null;
  }
  
  public static final long getRecentRouteExpire()
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig == null) {
      return 604800000L;
    }
    return localIUploadConfig.getRecentRouteExpire();
  }
  
  public static final long[] getUploadServerTimePair()
  {
    return sServerTimePair;
  }
  
  public static final int getWifiOperatorCategory()
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig == null) {
      return 0;
    }
    int j = localIUploadConfig.getWifiOperator();
    int i = 3;
    if (j != 3)
    {
      i = 4;
      if (j != 4)
      {
        if (j != 5)
        {
          if (j != 8) {
            return 0;
          }
          return 1;
        }
        return 2;
      }
    }
    return i;
  }
  
  public static final boolean isMobileSetting()
  {
    return UploadGlobalConfig.getUploadEnv().isMobile();
  }
  
  public static final boolean isNetworkAvailable()
  {
    return UploadGlobalConfig.getUploadEnv().isAvailable();
  }
  
  public static boolean isPictureNeedToCompress(String paramString)
  {
    IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
    if (localIUploadConfig == null) {
      return true;
    }
    return localIUploadConfig.isPictureNeedToCompress(paramString);
  }
  
  public static final boolean isWapSetting()
  {
    return UploadGlobalConfig.getUploadEnv().isWap();
  }
  
  public static final boolean isWifiSetting()
  {
    return UploadGlobalConfig.getUploadEnv().isWifi();
  }
  
  public static final void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    IUploadEnv localIUploadEnv = UploadGlobalConfig.getUploadEnv();
    if ((paramNetworkStateObserver != null) && (localIUploadEnv != null))
    {
      localIUploadEnv.registerNetworkStateObserver(paramNetworkStateObserver);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("observer:");
    localStringBuilder.append(paramNetworkStateObserver);
    localStringBuilder.append(" env:");
    localStringBuilder.append(localIUploadEnv);
    UploadLog.d("Configuration", localStringBuilder.toString());
  }
  
  public static final RecentRouteRecord saveAsRecentIp(ServerRouteTable paramServerRouteTable, String paramString, UploadRoute paramUploadRoute)
  {
    RecentRouteRecordStorage localRecentRouteRecordStorage = new RecentRouteRecordStorage(paramServerRouteTable);
    RecentRouteRecord localRecentRouteRecord = localRecentRouteRecordStorage.getData(paramString);
    paramServerRouteTable = localRecentRouteRecord;
    if (localRecentRouteRecord == null)
    {
      paramServerRouteTable = new RecentRouteRecord();
      paramServerRouteTable.setTimeStamp(System.currentTimeMillis());
    }
    paramUploadRoute = paramUploadRoute.clone();
    paramUploadRoute.setRouteCategory(IUploadRouteStrategy.RouteCategoryType.RECENT);
    paramServerRouteTable.setRecentRoute(paramUploadRoute);
    localRecentRouteRecordStorage.setData(paramString, paramServerRouteTable);
    return paramServerRouteTable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.common.UploadConfiguration
 * JD-Core Version:    0.7.0.1
 */