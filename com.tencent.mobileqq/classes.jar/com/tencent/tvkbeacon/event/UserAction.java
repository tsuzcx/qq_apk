package com.tencent.tvkbeacon.event;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.c.i;
import com.tencent.tvkbeacon.core.event.TunnelModule;
import com.tencent.tvkbeacon.core.event.UserEventModule;
import com.tencent.tvkbeacon.core.info.d;
import com.tencent.tvkbeacon.g.IAsyncQimeiListener;
import com.tencent.tvkbeacon.g.QimeiSDK;
import com.tencent.tvkbeacon.upload.InitHandleListener;
import com.tencent.tvkbeacon.upload.TunnelInfo;
import com.tencent.tvkbeacon.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserAction
{
  private static boolean a = false;
  public static List<com.tencent.tvkbeacon.core.b> beaconModules = new ArrayList();
  public static Context mContext = null;
  
  @Deprecated
  public static void closeUseInfoEvent() {}
  
  public static void doUploadRecords()
  {
    com.tencent.tvkbeacon.core.a.b.d().a(new UserAction.2());
  }
  
  public static void flushObjectsToDB(boolean paramBoolean)
  {
    TunnelModule.flushObjectsToDB(paramBoolean);
  }
  
  public static Map<String, String> getAdditionalInfo()
  {
    return TunnelModule.getAdditionalInfo(null);
  }
  
  public static Map<String, String> getAdditionalInfo(String paramString)
  {
    return TunnelModule.getAdditionalInfo(paramString);
  }
  
  public static String getAppKey()
  {
    return com.tencent.tvkbeacon.core.info.b.a;
  }
  
  public static String getCloudParas(String paramString)
  {
    if (mContext == null) {}
    Map localMap;
    do
    {
      return null;
      localMap = com.tencent.tvkbeacon.core.strategy.b.a().d();
    } while (localMap == null);
    return (String)localMap.get(paramString);
  }
  
  public static String getQIMEI()
  {
    return QimeiSDK.getInstance().getQimeiInternal();
  }
  
  public static void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    QimeiSDK.getInstance().getQimei(paramIAsyncQimeiListener);
  }
  
  @Deprecated
  public static String getRtQIMEI(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tvkbeacon_DENGTA_META", 0);
    paramContext = "";
    if (localSharedPreferences != null) {
      paramContext = localSharedPreferences.getString("QIMEI_DENGTA", "");
    }
    return paramContext;
  }
  
  public static String getSDKVersion()
  {
    return com.tencent.tvkbeacon.core.info.b.a(mContext).d();
  }
  
  public static String getUserID(String paramString)
  {
    return TunnelModule.getUserId(paramString);
  }
  
  public static void initUserAction(Context paramContext)
  {
    initUserAction(paramContext, true);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean)
  {
    initUserAction(paramContext, paramBoolean, 0L);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong)
  {
    initUserAction(paramContext, paramBoolean, paramLong, null, null);
  }
  
  @TargetApi(14)
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong, InitHandleListener paramInitHandleListener, UploadHandleListener paramUploadHandleListener)
  {
    if (mContext != null)
    {
      c.d("[core] SDK is already initialized.", new Object[0]);
      return;
    }
    if (paramContext == null)
    {
      c.c("[core] context is null! init failed!", new Object[0]);
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      mContext = localContext;
    }
    for (;;)
    {
      try
      {
        if (!a)
        {
          a = true;
          com.tencent.tvkbeacon.core.c.a.b(mContext);
          if (Integer.valueOf(Build.VERSION.SDK).intValue() < 14) {
            break label188;
          }
          paramContext = new com.tencent.tvkbeacon.core.a.e();
          ((Application)mContext).registerActivityLifecycleCallbacks(paramContext);
          ((Application)mContext).registerActivityLifecycleCallbacks(new com.tencent.tvkbeacon.core.a.f());
          com.tencent.tvkbeacon.core.b.h.a(mContext).a(paramBoolean);
          if (paramUploadHandleListener != null) {
            com.tencent.tvkbeacon.core.b.h.a(mContext).a(paramUploadHandleListener);
          }
          QimeiSDK.getInstance().init(mContext);
          com.tencent.tvkbeacon.core.a.b.d().a(new UserAction.1(paramInitHandleListener, paramLong));
          return;
          mContext = paramContext;
          break;
        }
        return;
      }
      finally {}
      label188:
      paramContext = new com.tencent.tvkbeacon.core.a.a(mContext);
      com.tencent.tvkbeacon.core.a.b.d().a(paramContext);
    }
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (mContext != null)
    {
      d.a(mContext);
      paramMap.put("A33", d.j(mContext));
    }
    return onUserAction("rqd_wgLogin", paramBoolean, paramLong, 0L, paramMap, true);
  }
  
  public static void onPageIn(String paramString)
  {
    com.tencent.tvkbeacon.core.event.f.a(com.tencent.tvkbeacon.core.c.b.c(paramString));
  }
  
  public static void onPageOut(String paramString)
  {
    com.tencent.tvkbeacon.core.event.f.b(com.tencent.tvkbeacon.core.c.b.c(paramString));
  }
  
  public static boolean onUserAction(String paramString, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    return onUserAction(paramString, true, -1L, -1L, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    return onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    com.tencent.tvkbeacon.core.c.h.a(paramMap);
    return TunnelModule.onUserAction(null, paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static boolean onUserActionToTunnel(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    return onUserActionToTunnel(paramString1, paramString2, true, -1L, -1L, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public static boolean onUserActionToTunnel(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return TunnelModule.onUserAction(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static void registerTunnel(TunnelInfo paramTunnelInfo)
  {
    TunnelModule.registerTunnel(paramTunnelInfo);
  }
  
  public static void setAdditionalInfo(String paramString, Map<String, String> paramMap)
  {
    TunnelModule.setAdditionalInfo(paramString, paramMap);
  }
  
  public static void setAdditionalInfo(Map<String, String> paramMap)
  {
    TunnelModule.setAdditionalInfo(null, paramMap);
  }
  
  public static void setAppKey(String paramString)
  {
    if (!i.a(paramString))
    {
      com.tencent.tvkbeacon.core.info.b.a = paramString;
      TunnelModule localTunnelModule = TunnelModule.getInstance();
      if (localTunnelModule != null) {
        localTunnelModule.setAppKey(paramString);
      }
    }
  }
  
  public static void setAppVersion(String paramString)
  {
    if (!i.a(paramString)) {
      com.tencent.tvkbeacon.core.info.b.b = paramString;
    }
  }
  
  @Deprecated
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    if (!i.a(paramString)) {
      com.tencent.tvkbeacon.core.info.b.c = com.tencent.tvkbeacon.core.c.b.a(paramString);
    }
  }
  
  public static void setCollectImei(boolean paramBoolean)
  {
    com.tencent.tvkbeacon.upload.UploadStrategy.IS_COLLECT_IMEI = paramBoolean;
  }
  
  public static void setCollectMAC(boolean paramBoolean)
  {
    com.tencent.tvkbeacon.upload.UploadStrategy.IS_COLLECT_MAC = paramBoolean;
  }
  
  public static void setJsClientId(String paramString)
  {
    com.tencent.tvkbeacon.core.info.e.b(mContext).d(paramString);
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    c.a = paramBoolean1;
    c.b = paramBoolean2;
    c.c = paramBoolean1 & paramBoolean2;
  }
  
  public static void setOmgId(String paramString)
  {
    if (!i.a(paramString)) {
      com.tencent.tvkbeacon.core.info.c.a = paramString;
    }
  }
  
  public static void setQQ(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Long.parseLong(paramString) > 10000L) {
          com.tencent.tvkbeacon.core.info.c.b = paramString;
        }
        return;
      }
      catch (Exception paramString)
      {
        c.c("[core] set qq is not available !", new Object[0]);
        return;
      }
    }
    c.c("[core] set qq is null !", new Object[0]);
  }
  
  public static void setReportDomain(String paramString1, String paramString2)
  {
    com.tencent.tvkbeacon.core.strategy.b.a().a(paramString1, paramString2);
  }
  
  public static void setScheduledService(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (paramScheduledExecutorService != null)
    {
      com.tencent.tvkbeacon.core.a.b.a(com.tencent.tvkbeacon.core.a.b.a(paramScheduledExecutorService));
      return;
    }
    c.d("service param error!", new Object[0]);
  }
  
  public static void setStopBackgroundTask(boolean paramBoolean)
  {
    com.tencent.tvkbeacon.upload.UploadStrategy.IS_STOP_BACKGROUND_TASK = paramBoolean;
  }
  
  public static void setStrictMode(boolean paramBoolean)
  {
    com.tencent.tvkbeacon.core.c.h.a.set(paramBoolean);
    if (mContext != null) {
      com.tencent.tvkbeacon.core.c.h.a(mContext);
    }
  }
  
  public static void setUploadMode(boolean paramBoolean)
  {
    Object localObject = UserEventModule.getInstance();
    if (localObject != null) {
      ((UserEventModule)localObject).setUploadMode(paramBoolean);
    }
    for (;;)
    {
      localObject = TunnelModule.getInstance();
      if (localObject != null) {
        ((TunnelModule)localObject).setUploadMode(paramBoolean);
      }
      return;
      c.c("[core] UserEventModule is null, init sdk first!", new Object[0]);
    }
  }
  
  public static void setUserID(String paramString)
  {
    setUserID(null, paramString);
  }
  
  public static void setUserID(String paramString1, String paramString2)
  {
    c.a("[core] setUserID:".concat(String.valueOf(paramString2)), new Object[0]);
    TunnelModule.setUserId(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */