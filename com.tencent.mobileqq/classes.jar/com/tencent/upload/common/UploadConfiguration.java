package com.tencent.upload.common;

import android.content.Context;
import com.tencent.upload.network.route.RecentRouteSet;
import com.tencent.upload.network.route.RouteFactory.ServerCategory;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.route.c.a;
import com.tencent.upload.network.route.d;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.Utility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public final class UploadConfiguration
{
  public static final HashMap<String, Integer> UPLOAD_IP_TIMEOUT_MAP = new HashMap();
  private static final int[] a = { 1440, 1200, 700 };
  private static final List b = Arrays.asList(new Integer[] { Integer.valueOf(80), Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(14000) });
  private static volatile long[] c;
  
  public static final void checkVaildConnection(Context paramContext, Long paramLong, String paramString)
  {
    Utility.keepLongConnection(paramContext, paramLong, paramString);
  }
  
  public static final String getChangeRouteRetCode()
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getChangeRouteRetCodes();
    }
    return null;
  }
  
  public static final int getConnectionTimeout()
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getConnectTimeout() * 1000;
    }
    return 20000;
  }
  
  public static final String getCurrentApn()
  {
    return a.e().getApnName();
  }
  
  public static int getCurrentNetworkCategory()
  {
    return a.e().getCurrentNetworkCategory();
  }
  
  public static final int getCurrentOperatorCategory()
  {
    IUploadEnv localIUploadEnv = a.e();
    if (localIUploadEnv == null) {}
    do
    {
      return 0;
      if (localIUploadEnv.isMobile()) {
        return localIUploadEnv.getMobileOperatorCategory();
      }
    } while (!localIUploadEnv.isWifi());
    return getWifiOperatorCategory();
  }
  
  public static final int getDataTimeout()
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getDataTimeout() * 1000;
    }
    return 60000;
  }
  
  public static final int getDoNotFragment()
  {
    IUploadConfig localIUploadConfig = a.b();
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
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig == null) {
      return null;
    }
    return localIUploadConfig.getExifTagCode(paramString);
  }
  
  public static int getGifUploadLimit(int paramInt)
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig == null) {
      return 5242880;
    }
    return localIUploadConfig.getGifUploadLimit(paramInt);
  }
  
  public static final int getMaxSegmentSize(String paramString)
  {
    int i;
    if (!isWifiSetting()) {
      i = -1;
    }
    for (;;)
    {
      return i;
      Object localObject;
      synchronized (UPLOAD_IP_TIMEOUT_MAP)
      {
        localObject = (Integer)UPLOAD_IP_TIMEOUT_MAP.get(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = Integer.valueOf(0);
        }
        localObject = a.b();
        if (localObject == null) {
          return a[(paramString.intValue() % a.length)];
        }
      }
      ??? = null;
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
        if ((localObject == null) || (localObject.length == 0)) {
          return a[(paramString.intValue() % a.length)];
        }
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        for (;;)
        {
          b.d("Configuration", localPatternSyntaxException.toString());
          localHashMap1 = ???;
        }
        HashMap localHashMap1 = localHashMap1[(paramString.intValue() % localHashMap1.length)];
        try
        {
          int j = Integer.parseInt(localHashMap1);
          i = j;
          if (j < 64) {
            return 64;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          b.d("Configuration", localNumberFormatException.toString());
        }
      }
    }
    return a[(paramString.intValue() % a.length)];
  }
  
  public static final int getMaxSessionPacketSize()
  {
    return 2097152;
  }
  
  public static final String getNetworkUnavailableRetCode()
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig != null) {
      return localIUploadConfig.getNetworkUnavailableRetCodes();
    }
    return null;
  }
  
  public static final int getPictureQuality(String paramString)
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig == null) {
      return 0;
    }
    return (int)localIUploadConfig.getPictureQuality(paramString);
  }
  
  public static final String getProviderName()
  {
    return a.e().getProviderName();
  }
  
  public static final String getRecentRouteApnKey()
  {
    IUploadEnv localIUploadEnv = a.e();
    if (localIUploadEnv == null) {}
    do
    {
      return null;
      if (localIUploadEnv.isMobile()) {
        return localIUploadEnv.getApnName();
      }
    } while (!localIUploadEnv.isWifi());
    return localIUploadEnv.getBSSID();
  }
  
  public static final long getRecentRouteExpire()
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig == null) {
      return 604800000L;
    }
    return localIUploadConfig.getRecentRouteExpire();
  }
  
  public static final List<Integer> getUploadRoutePorts()
  {
    Object localObject1 = a.b();
    Object localObject3 = ((IUploadConfig)localObject1).getUploadPort();
    if ((localObject1 == null) || (localObject3 == null)) {
      localObject1 = b;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        localObject3 = ((String)localObject3).split(",");
        if (localObject3 == null) {
          return b;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          b.d("Configuration", localException1.toString());
          localObject3 = null;
        }
        ArrayList localArrayList = new ArrayList(localObject3.length);
        try
        {
          int j = localObject3.length;
          int i = 0;
          for (;;)
          {
            Object localObject2 = localArrayList;
            if (i >= j) {
              break;
            }
            localArrayList.add(Integer.valueOf(Integer.parseInt(localObject3[i])));
            i += 1;
          }
          return b;
        }
        catch (Exception localException2)
        {
          b.d("Configuration", localException2.toString());
        }
      }
    }
  }
  
  public static final long[] getUploadServerTimePair()
  {
    return c;
  }
  
  public static final int getWifiOperatorCategory()
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig == null) {
      return 0;
    }
    switch (localIUploadConfig.getWifiOperator())
    {
    case 6: 
    case 7: 
    default: 
      return 0;
    case 3: 
      return 3;
    case 8: 
      return 1;
    case 5: 
      return 2;
    }
    return 4;
  }
  
  public static final boolean isMobileSetting()
  {
    return a.e().isMobile();
  }
  
  public static final boolean isNetworkAvailable()
  {
    return a.e().isAvailable();
  }
  
  public static boolean isPictureNeedToCompress(String paramString)
  {
    IUploadConfig localIUploadConfig = a.b();
    if (localIUploadConfig == null) {
      return true;
    }
    return localIUploadConfig.isPictureNeedToCompress(paramString);
  }
  
  public static final boolean isWapSetting()
  {
    return a.e().isWap();
  }
  
  public static final boolean isWifiSetting()
  {
    return a.e().isWifi();
  }
  
  public static final void registerNetworkStateObserver(NetworkStateObserver paramNetworkStateObserver)
  {
    IUploadEnv localIUploadEnv = a.e();
    if ((paramNetworkStateObserver == null) || (localIUploadEnv == null)) {
      return;
    }
    localIUploadEnv.registerNetworkStateObserver(paramNetworkStateObserver);
  }
  
  public static final RecentRouteSet saveAsRecentIp(RouteFactory.ServerCategory paramServerCategory, String paramString, UploadRoute paramUploadRoute)
  {
    d locald = new d(paramServerCategory);
    RecentRouteSet localRecentRouteSet = locald.a(paramString);
    paramServerCategory = localRecentRouteSet;
    if (localRecentRouteSet == null)
    {
      paramServerCategory = new RecentRouteSet();
      paramServerCategory.setTimeStamp(System.currentTimeMillis());
    }
    paramUploadRoute = paramUploadRoute.clone();
    paramUploadRoute.setRouteCategory(c.a.c);
    paramServerCategory.setRecentRoute(paramUploadRoute);
    locald.a(paramString, paramServerCategory);
    return paramServerCategory;
  }
  
  public static final class NetworkCategory
  {
    public static final int MOBILE_2G = 3;
    public static final int MOBILE_3G = 2;
    public static final int MOBILE_4G = 6;
    public static final int UNKNOWN = 0;
    public static final int WIFI = 1;
  }
  
  public static abstract interface NetworkStateObserver
  {
    public abstract void onStateChanged(boolean paramBoolean);
  }
  
  public static final class OperatorCategory
  {
    public static final int CMCC = 1;
    public static final int CMCT = 3;
    public static final int UNICOM = 2;
    public static final int UNKNOW = 0;
    public static final int WIFI = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.common.UploadConfiguration
 * JD-Core Version:    0.7.0.1
 */