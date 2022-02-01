package com.tencent.qqmini.sdk.server.launch;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.server.LaunchManagerService.ServiceBinder;
import com.tencent.qqmini.sdk.server.MiniServer;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class AppLaunchStrategy
  implements LaunchStrategy
{
  public static final String KEY_APP_INTENT_APP_ID = "APP_INTENT_APP_ID";
  private static final int KILL_MODE_PID = 0;
  private static final int KILL__MODE_BROADCAST = 1;
  public static final int MINI_APP_CRASH_PROTECT_TIME_DEFAULT = 3600000;
  private static final int MINI_APP_PROCESS_DETECT_TIME_DEFAULT = 600000;
  private static final int MINI_GAME_PROCESS_REUSE_DEFAULT = 1;
  private static final int PROCESS_APP_RECYCLE_TIME = 1800000;
  private static final int PROCESS_GAME_RECYCLE_TIME = 900000;
  private static final int PROCESS_MAX_COUNT_DEFAULT = 6;
  private static final int PROCESS_PRELOAD_COUNT_DEFAULT = 2;
  private static final String TAG = "minisdk-start_LaunchManagerService";
  private static AppLaunchStrategy.MiniAppSubProcessorInfo sInternalProcessInfo;
  public static LinkedHashMap<String, AppLaunchStrategy.MiniAppSubProcessorInfo> subAppProcessorInfoMap = new LinkedHashMap();
  public static LinkedHashMap<String, AppLaunchStrategy.MiniAppSubProcessorInfo> subProcessorInfoMap = new LinkedHashMap();
  public long appProcessRecycleTime = 1800000L;
  public long gameProcessRecycleTime = 900000L;
  private AppLaunchStrategy.MiniAppSubProcessorInfo lastKillingProcessor;
  private final Map<String, Messenger> mClientMessengerMap = new HashMap();
  private final Context mContext;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private int mKillProcessMode = 0;
  private long mLastPreloadDetectTime;
  private boolean mMiniAppUsed = false;
  private ConcurrentHashMap<String, String> mPreloadingTask = new ConcurrentHashMap();
  private int mProcessMaxCount = 0;
  private int mProcessPreloadCount = 0;
  private LruCache<String, AppLaunchStrategy.MiniAppSubProcessorInfo> mProcessStack;
  private int mStartTimeInterval = 1500;
  private long mStartTimestamp;
  private MiniAppBaseInfo mStartingMiniAppConfig;
  private HashMap<String, Long> startAppIdMap = new HashMap();
  
  public AppLaunchStrategy(@NotNull Context paramContext, @NotNull List<MiniProcessorConfig> paramList1, @NotNull List<MiniProcessorConfig> paramList2)
  {
    this.mContext = paramContext;
    paramContext = paramList1.iterator();
    while (paramContext.hasNext()) {
      initProcessInfo((MiniProcessorConfig)paramContext.next());
    }
    paramContext = paramList2.iterator();
    while (paramContext.hasNext()) {
      initProcessInfo((MiniProcessorConfig)paramContext.next());
    }
    this.mProcessPreloadCount = 2;
    this.appProcessRecycleTime = 1800000L;
    this.gameProcessRecycleTime = 900000L;
    this.mStartTimeInterval = 1500;
    this.mProcessMaxCount = (paramList1.size() + paramList2.size());
    this.mProcessStack = new LruCache(this.mProcessMaxCount);
  }
  
  private boolean canPreloadApp(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    return true;
  }
  
  private boolean canPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label129:
    label130:
    for (;;)
    {
      return false;
      Object localObject1 = this.mProcessStack.snapshot();
      if (sInternalProcessInfo != null) {
        ((Map)localObject1).remove(sInternalProcessInfo.processName);
      }
      int j = this.mProcessMaxCount;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (localObject2 == null) {
          break label129;
        }
        localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (!paramString.equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType))) {
          break label129;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if (i >= j) {
          break label130;
        }
        return true;
      }
    }
  }
  
  private void checkAndCleanAllMiniProcess()
  {
    for (;;)
    {
      Iterator localIterator1;
      Object localObject4;
      Object localObject3;
      int i;
      try
      {
        Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 == null) {
          break label371;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 == null) {
          break label370;
        }
        if (((List)localObject1).size() <= 0) {
          return;
        }
        localIterator1 = this.mProcessStack.snapshot().entrySet().iterator();
        if (localIterator1.hasNext())
        {
          localObject4 = (Map.Entry)localIterator1.next();
          if (localObject4 == null) {
            continue;
          }
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject4).getValue();
          if (localObject4 == null) {
            continue;
          }
          Iterator localIterator2 = ((List)localObject1).iterator();
          if (localIterator2.hasNext())
          {
            if (((ActivityManager.RunningAppProcessInfo)localIterator2.next()).pid != ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject4).pid) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            QMLog.i("minisdk-start_LaunchManagerService", "Process has been died, clean the record! processName=" + (String)localObject3 + " pid=" + ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject4).pid);
            localObject3 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.remove(localObject3);
            if (localObject3 == null) {
              continue;
            }
            ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject3).clean();
          }
        }
        else
        {
          localIterator1 = this.mPreloadingTask.entrySet().iterator();
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
        return;
      }
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localObject3 = (Map.Entry)localIterator1.next();
          if (localObject3 != null)
          {
            localObject3 = (String)((Map.Entry)localObject3).getKey();
            localObject4 = localThrowable.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
            } while (!TextUtils.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject4).next()).processName, (CharSequence)localObject3));
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label363;
              }
              QMLog.i("minisdk-start_LaunchManagerService", "Process has been died, clean the preloading record! processName=" + (String)localObject3);
              localIterator1.remove();
              break;
            }
            label363:
            continue;
            i = 0;
            break;
          }
        }
      }
      label370:
      return;
      label371:
      Object localObject2 = null;
    }
  }
  
  private void checkPreload()
  {
    QMLog.i("minisdk-start_LaunchManagerService", "checkPreload MiniAppUsed:" + this.mMiniAppUsed);
    try
    {
      if (this.mMiniAppUsed)
      {
        this.mLastPreloadDetectTime = System.currentTimeMillis();
        checkAndCleanAllMiniProcess();
        preloadExtraMiniApp(true);
        preloadExtraMiniApp(false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
    }
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo checkProcessForLoadedApp(MiniAppBaseInfo paramMiniAppBaseInfo, Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap)
  {
    if (paramMiniAppBaseInfo != null)
    {
      Object localObject;
      String str;
      Iterator localIterator;
      do
      {
        paramMap = paramMap.entrySet().iterator();
        while (!localIterator.hasNext())
        {
          do
          {
            do
            {
              if (!paramMap.hasNext()) {
                break;
              }
              localObject = (Map.Entry)paramMap.next();
            } while (localObject == null);
            str = (String)((Map.Entry)localObject).getKey();
            localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
          } while (localObject == null);
          if (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).containsAppConfig(paramMiniAppBaseInfo))
          {
            QMLog.i("minisdk-start_LaunchManagerService", "obtain loaded processor from stack:" + str);
            return localObject;
          }
          localIterator = ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).allMiniAppInfo.iterator();
        }
      } while (!equalAppInfo(paramMiniAppBaseInfo, (MiniAppBaseInfo)localIterator.next()));
      QMLog.i("minisdk-start_LaunchManagerService", "obtain loaded processor from stack for cache runtime:" + str);
      return localObject;
    }
    return null;
  }
  
  private void cleanProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.remove(paramString);
      if (localMiniAppSubProcessorInfo != null) {
        localMiniAppSubProcessorInfo.clean();
      }
    } while ((this.lastKillingProcessor == null) || (!paramString.equals(this.lastKillingProcessor.processName)));
    paramString = this.lastKillingProcessor;
    getHandler().postDelayed(new AppLaunchStrategy.1(this, paramString), 2000L);
    this.lastKillingProcessor = null;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo createProcessorInfo(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    Class localClass3 = null;
    Class localClass1;
    Class localClass2;
    label23:
    int i;
    if (paramMiniAppSubProcessorInfo != null)
    {
      localClass1 = paramMiniAppSubProcessorInfo.uiClass;
      if (paramMiniAppSubProcessorInfo == null) {
        break label96;
      }
      localClass2 = paramMiniAppSubProcessorInfo.internalUIClass;
      if (paramMiniAppSubProcessorInfo != null) {
        localClass3 = paramMiniAppSubProcessorInfo.appPreLoadClass;
      }
      if (paramMiniAppSubProcessorInfo == null) {
        break label102;
      }
      i = paramMiniAppSubProcessorInfo.supportRuntimeType;
      label43:
      paramMiniAppSubProcessorInfo = new AppLaunchStrategy.MiniAppSubProcessorInfo(this, paramString, localClass1, localClass2, localClass3, i);
      if ((paramMiniAppSubProcessorInfo.preloadType == null) && (paramMiniAppBaseInfo != null)) {
        if (!paramMiniAppBaseInfo.isEngineTypeMiniApp()) {
          break label108;
        }
      }
    }
    label96:
    label102:
    label108:
    for (paramString = "preload_app";; paramString = "preload_game")
    {
      paramMiniAppSubProcessorInfo.preloadType = paramString;
      return paramMiniAppSubProcessorInfo;
      localClass1 = null;
      break;
      localClass2 = null;
      break label23;
      i = 0;
      break label43;
    }
  }
  
  private void doPreLaunchMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if ((paramMiniAppInfo == null) || (!paramMiniAppInfo.isEngineTypeMiniApp())) {
      return;
    }
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo;
    try
    {
      QMLog.i("minisdk-start_LaunchManagerService", "PreLaunch mini app. appId:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
      localMiniAppSubProcessorInfo = obtainPreLaunchProcessor(paramMiniAppInfo);
      if (localMiniAppSubProcessorInfo == null)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "obtain processor config failed!");
        return;
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "send preload Broadcast exception!", paramMiniAppInfo);
      return;
    }
    QMLog.i("minisdk-start_LaunchManagerService", "PreLaunch mini app in process:" + localMiniAppSubProcessorInfo.processName + " appId:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
    paramMiniAppInfo = new Intent();
    paramMiniAppInfo.setClass(this.mContext, localMiniAppSubProcessorInfo.appPreLoadClass);
    paramMiniAppInfo.setAction("mini_prelaunch_app");
    paramMiniAppInfo.putExtra("sdk_mode", true);
    if (paramBundle != null) {
      paramMiniAppInfo.putExtras(paramBundle);
    }
    paramBundle = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    paramMiniAppInfo.putExtra("KEY_LOGININFO", new LoginInfo(paramBundle.getLoginType(), paramBundle.getAccount(), paramBundle.getNickName(), paramBundle.getPayOpenId(), paramBundle.getPayOpenKey(), paramBundle.getPayAccessToken(), paramBundle.getLoginSig(), paramBundle.getPlatformId(), paramBundle.getAppId()));
    paramMiniAppInfo.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
    this.mContext.sendBroadcast(paramMiniAppInfo);
  }
  
  private void doPreloadApp(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    if ((paramMiniAppSubProcessorInfo == null) || ((!paramBoolean2) && (!canPreloadApp(paramMiniAppSubProcessorInfo)))) {
      return;
    }
    for (;;)
    {
      try
      {
        QMLog.i("minisdk-start_LaunchManagerService", "do preload mini process name=" + paramMiniAppSubProcessorInfo.processName + " Preload=" + paramMiniAppSubProcessorInfo.appPreLoadClass.getSimpleName() + " isMiniApp:" + paramBoolean1);
        Intent localIntent = new Intent();
        localIntent.setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
        if (paramBoolean1)
        {
          str = "mini_preload_app";
          localIntent.setAction(str);
          localIntent.putExtra("sdk_mode", true);
          if (paramBundle != null) {
            localIntent.putExtras(paramBundle);
          }
          paramBundle = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
          localIntent.putExtra("KEY_LOGININFO", new LoginInfo(paramBundle.getLoginType(), paramBundle.getAccount(), paramBundle.getNickName(), paramBundle.getPayOpenId(), paramBundle.getPayOpenKey(), paramBundle.getPayAccessToken(), paramBundle.getLoginSig(), paramBundle.getPlatformId(), paramBundle.getAppId()));
          localIntent.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
          paramBundle = this.mPreloadingTask;
          str = paramMiniAppSubProcessorInfo.processName;
          if (!paramBoolean1) {
            break label279;
          }
          paramMiniAppSubProcessorInfo = "preload_app";
          paramBundle.put(str, paramMiniAppSubProcessorInfo);
          this.mContext.sendBroadcast(localIntent);
          return;
        }
      }
      catch (Throwable paramMiniAppSubProcessorInfo)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "send preload Broadcast exception!", paramMiniAppSubProcessorInfo);
        return;
      }
      String str = "mini_preload_game";
      continue;
      label279:
      paramMiniAppSubProcessorInfo = "preload_game";
    }
  }
  
  private void doPreloadApp(Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap, boolean paramBoolean, Bundle paramBundle)
  {
    Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!paramMap.containsKey((String)localEntry.getKey())) {
        doPreloadApp((AppLaunchStrategy.MiniAppSubProcessorInfo)localEntry.getValue(), paramBoolean, true, true, paramBundle);
      }
    }
  }
  
  private void doPreloadExtraMiniApp(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {}
    while ((paramMiniAppBaseInfo.isEngineTypeMiniGame()) || (paramMiniAppBaseInfo == null)) {
      return;
    }
    getHandler().postDelayed(new AppLaunchStrategy.2(this, paramMiniAppBaseInfo), 1000L);
  }
  
  public static boolean equalAppInfo(MiniAppBaseInfo paramMiniAppBaseInfo1, MiniAppBaseInfo paramMiniAppBaseInfo2)
  {
    if ((paramMiniAppBaseInfo1 == null) || (paramMiniAppBaseInfo2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (paramMiniAppBaseInfo1.getEngineType() != paramMiniAppBaseInfo2.getEngineType());
      if ((!TextUtils.isEmpty(paramMiniAppBaseInfo1.appId)) && (TextUtils.equals(paramMiniAppBaseInfo1.appId, paramMiniAppBaseInfo2.appId))) {
        return true;
      }
    } while ((TextUtils.isEmpty(paramMiniAppBaseInfo1.link)) || (!TextUtils.equals(paramMiniAppBaseInfo1.link, paramMiniAppBaseInfo2.link)));
    return true;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo findCacheMiniProcessInfo(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1;
    if (paramMiniAppBaseInfo == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject2;
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)localIterator.next();
          } while (localObject1 == null);
          localObject2 = (String)((Map.Entry)localObject1).getKey();
          localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        } while (localObject2 == null);
        localObject1 = localObject2;
        if (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).containsAppConfig(paramMiniAppBaseInfo)) {
          break;
        }
        localObject1 = ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).allMiniAppInfo.iterator();
      }
    } while (!equalAppInfo(paramMiniAppBaseInfo, (MiniAppBaseInfo)((Iterator)localObject1).next()));
    return localObject2;
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findExitingIdelProcess(Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).currentAppInfo == null) && ("preload_app".equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).preloadType)) && ((!paramBoolean1) || (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).internalUIClass != null)) && ((!paramBoolean2) || ((((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).supportRuntimeType & 0x2) > 0)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from stack:" + str);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private boolean findExitingProcessForPreLaunch(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (findCacheMiniProcessInfo(paramMiniAppBaseInfo) != null)
    {
      QMLog.i("minisdk-start_LaunchManagerService", "The app has loaded, no need to PreLaunch again.");
      return true;
    }
    return false;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findFirstSupportedProcessForPreLaunch(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localIterator.next()).getValue();
      if ((localMiniAppSubProcessorInfo != null) && (localMiniAppSubProcessorInfo.support(paramBoolean, paramInt)))
      {
        QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch processor from config list: " + localMiniAppSubProcessorInfo.processName);
        return localMiniAppSubProcessorInfo;
      }
    }
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findIdelProcessForPreLaunch(Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap, boolean paramBoolean, int paramInt)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).currentAppInfo == null) && ("preload_app".equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).preloadType)) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).support(paramBoolean, paramInt)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch processor from stack:" + str);
          return localObject;
        }
      }
    }
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findInternalAppProcessForPrelaunch(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).support(paramBoolean, paramInt)))
      {
        QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch processor support internal mode " + ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).processName);
        return localObject;
      }
    }
    return null;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo findMiniAppProcessInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (localObject == null);
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
    } while ((localObject == null) || (!((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).containsAppConfig(paramMiniAppInfo)));
    for (paramMiniAppInfo = (MiniAppInfo)localObject;; paramMiniAppInfo = null) {
      return paramMiniAppInfo;
    }
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findProcessForInternalApp()
  {
    Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).internalUIClass != null))
      {
        QMLog.i("minisdk-start_LaunchManagerService", "obtain processor support internal mode " + ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).processName);
        return localObject;
      }
    }
    return null;
  }
  
  private boolean finishAndRemoveTask(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    for (;;)
    {
      ActivityManager.AppTask localAppTask;
      try
      {
        localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 == null) {
          return false;
        }
        Object localObject2 = ((ActivityManager)localObject1).getAppTasks();
        if (localObject2 == null) {
          return false;
        }
        if (paramMiniAppSubProcessorInfo == null)
        {
          QMLog.e("miniapp", "当前进程信息为空");
          return false;
        }
        if ((paramBoolean) || (paramMiniAppSubProcessorInfo.allMiniAppInfo.isEmpty())) {
          break label351;
        }
        localObject1 = (MiniAppBaseInfo)paramMiniAppSubProcessorInfo.allMiniAppInfo.get(paramMiniAppSubProcessorInfo.allMiniAppInfo.size() - 1);
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label349;
        }
        localAppTask = (ActivityManager.AppTask)((Iterator)localObject2).next();
        if ((localAppTask == null) || (localAppTask.getTaskInfo() == null) || (localAppTask.getTaskInfo().baseIntent == null) || (localAppTask.getTaskInfo().baseIntent.getComponent() == null)) {
          continue;
        }
        if (paramBoolean)
        {
          String str = localAppTask.getTaskInfo().baseIntent.getComponent().getClassName();
          if ((TextUtils.isEmpty(str)) || (paramMiniAppSubProcessorInfo.uiClass == null) || (!str.equals(paramMiniAppSubProcessorInfo.uiClass.getName()))) {
            continue;
          }
          QMLog.i("minisdk-start_LaunchManagerService", "finishAndRemoveTask finish and remove task: id=" + localAppTask.getTaskInfo().id + " ui:" + paramMiniAppSubProcessorInfo.uiClass);
          continue;
        }
        if (!TextUtils.equals(localAppTask.getTaskInfo().baseIntent.getStringExtra("APP_INTENT_APP_ID"), ((MiniAppBaseInfo)localObject1).appId)) {
          continue;
        }
      }
      catch (Throwable paramMiniAppSubProcessorInfo)
      {
        QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
        return false;
      }
      QMLog.i("minisdk-start_LaunchManagerService", "finishAndRemoveTask finish and remove task: id=" + localAppTask.getTaskInfo().id + " app:" + ((MiniAppBaseInfo)localObject1).name);
      localAppTask.finishAndRemoveTask();
      label349:
      return true;
      label351:
      Object localObject1 = null;
    }
  }
  
  private void forceKillProcess(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    if (paramMiniAppSubProcessorInfo == null) {
      return;
    }
    this.lastKillingProcessor = paramMiniAppSubProcessorInfo;
    QMLog.i("minisdk-start_LaunchManagerService", "kill mini process: " + this.lastKillingProcessor);
    int i = paramMiniAppSubProcessorInfo.pid;
    if (i > 0) {
      try
      {
        if (this.mKillProcessMode == 0)
        {
          QMLog.w("minisdk-start_LaunchManagerService", "kill process by pid:" + i);
          finishAndRemoveTask(paramMiniAppSubProcessorInfo, true);
          Process.killProcess(i);
          cleanProcess(paramMiniAppSubProcessorInfo.processName);
          printProcessStack();
          return;
        }
      }
      catch (Throwable paramMiniAppSubProcessorInfo)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "kill process exception!", paramMiniAppSubProcessorInfo);
        return;
      }
    }
    QMLog.w("minisdk-start_LaunchManagerService", "kill process by broadcast" + paramMiniAppSubProcessorInfo.processName);
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
    this.mContext.sendBroadcast(localIntent);
  }
  
  private String getAppName(@NotNull MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo.name;
    }
    return null;
  }
  
  private String getAppid(@NotNull MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo.appId;
    }
    return null;
  }
  
  private int getEngineType(@NotNull MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo.getEngineType();
    }
    return -1;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo getLowestPriorityProcess()
  {
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.processName);
    }
    Iterator localIterator = ((Map)localObject1).entrySet().iterator();
    localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        localObject1 = localObject2;
        if (localMiniAppSubProcessorInfo != null)
        {
          localObject1 = localObject2;
          if (localMiniAppSubProcessorInfo.currentAppInfo != null)
          {
            localObject1 = localObject2;
            if ((localMiniAppSubProcessorInfo.supportRuntimeType & 0x3) != 0) {
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        if (localObject1 != null)
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from stack bottom:" + (String)localObject2);
          return localObject1;
        }
      }
      return null;
    }
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo getLowestProcessForPreLaunch()
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        localObject1 = localObject2;
        if (localMiniAppSubProcessorInfo != null)
        {
          localObject1 = localObject2;
          if (localMiniAppSubProcessorInfo.currentAppInfo != null)
          {
            localObject1 = localObject2;
            if (TextUtils.equals(localMiniAppSubProcessorInfo.preloadType, "preload_app")) {
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        if (localObject1 != null)
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch idle processor from stack bottom:" + (String)localObject2);
          return localObject1;
        }
      }
      return null;
    }
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo getMiniAppSubProcessorInfo(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @NotNull Bundle paramBundle)
  {
    Object localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    Object localObject1 = localObject2;
    label58:
    Class localClass;
    label70:
    int i;
    if (localObject2 == null)
    {
      AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      if (localMiniAppSubProcessorInfo == null) {
        break label163;
      }
      localObject1 = localMiniAppSubProcessorInfo.uiClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label169;
      }
      localObject2 = localMiniAppSubProcessorInfo.internalUIClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label175;
      }
      localClass = localMiniAppSubProcessorInfo.appPreLoadClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label181;
      }
      i = localMiniAppSubProcessorInfo.supportRuntimeType;
      label82:
      localObject1 = new AppLaunchStrategy.MiniAppSubProcessorInfo(this, paramString, (Class)localObject1, (Class)localObject2, localClass, i);
      if (paramBundle == null) {
        break label187;
      }
      paramBundle = paramBundle.getString("mini_key_preload_type", null);
      label114:
      ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).preloadType = paramBundle;
      if ((((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).preloadType == null) && (paramMiniAppBaseInfo != null)) {
        if (!paramMiniAppBaseInfo.isEngineTypeMiniApp()) {
          break label192;
        }
      }
    }
    label163:
    label169:
    label175:
    label181:
    label187:
    label192:
    for (paramMiniAppBaseInfo = "preload_app";; paramMiniAppBaseInfo = "preload_game")
    {
      ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).preloadType = paramMiniAppBaseInfo;
      this.mProcessStack.put(paramString, localObject1);
      return localObject1;
      localObject1 = null;
      break;
      localObject2 = null;
      break label58;
      localClass = null;
      break label70;
      i = 0;
      break label82;
      paramBundle = null;
      break label114;
    }
  }
  
  private int getPid(@NotNull Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getInt("PID");
    }
    return 0;
  }
  
  private ProcessState getProcessState(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    ProcessState localProcessState = ProcessState.EMPTY;
    if ((paramMiniAppSubProcessorInfo.pid > 0) && (paramMiniAppSubProcessorInfo.allMiniAppInfo.isEmpty())) {
      localProcessState = ProcessState.PRELOADED;
    }
    while (paramMiniAppSubProcessorInfo.pid <= 0) {
      return localProcessState;
    }
    return ProcessState.REUSE;
  }
  
  private boolean hasPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.processName);
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).allMiniAppInfo.isEmpty()) && (paramString.equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType))) {
          return true;
        }
      }
    }
    localObject1 = this.mPreloadingTask.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((localObject2 != null) && (paramString.equals((String)((Map.Entry)localObject2).getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasPreloadingTask(String paramString)
  {
    if (paramString == null) {
      return this.mPreloadingTask.size() > 0;
    }
    return this.mPreloadingTask.containsValue(paramString);
  }
  
  private void initProcessInfo(MiniProcessorConfig paramMiniProcessorConfig)
  {
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = new AppLaunchStrategy.MiniAppSubProcessorInfo(this, paramMiniProcessorConfig.processName, paramMiniProcessorConfig.processType, paramMiniProcessorConfig.appUIClass, paramMiniProcessorConfig.internalUIClass, paramMiniProcessorConfig.appPreLoadClass, paramMiniProcessorConfig.supportRuntimeType);
    subProcessorInfoMap.put(localMiniAppSubProcessorInfo.processName, localMiniAppSubProcessorInfo);
    if (paramMiniProcessorConfig.processType == ProcessType.MINI_APP)
    {
      subAppProcessorInfoMap.put(localMiniAppSubProcessorInfo.processName, localMiniAppSubProcessorInfo);
      return;
    }
    if (paramMiniProcessorConfig.processType == ProcessType.MINI_INTERNAL)
    {
      subAppProcessorInfoMap.put(localMiniAppSubProcessorInfo.processName, localMiniAppSubProcessorInfo);
      sInternalProcessInfo = localMiniAppSubProcessorInfo;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  private boolean isProcessAlive(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 == null) {
          break label106;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 == null) {
          break label104;
        }
        if (((List)localObject1).size() <= 0) {
          return false;
        }
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          int i = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).pid;
          if (i != paramInt) {
            continue;
          }
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
        return false;
      }
      boolean bool = false;
      continue;
      label104:
      return false;
      label106:
      Object localObject2 = null;
    }
  }
  
  private boolean isProcessAlive(String paramString)
  {
    try
    {
      Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
          if ((paramString.equals(str)) && (localObject != null))
          {
            boolean bool = isProcessAlive(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).pid);
            return bool;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "", paramString);
    }
    return false;
  }
  
  private boolean needPreloadMiniApp(String paramString)
  {
    checkAndCleanAllMiniProcess();
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).isIdleProcess()) && (paramString != null) && (paramString.equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).preloadType)))
        {
          QMLog.d("minisdk-start_LaunchManagerService", "No need to preload mini process. " + paramString + ". Already has idle process " + localObject);
          return false;
        }
      }
    }
    if (hasPreloadingTask(paramString))
    {
      QMLog.d("minisdk-start_LaunchManagerService", "No need to preload mini process " + paramString + ". Already has preloading task " + this.mPreloadingTask);
      return false;
    }
    return true;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainAppProcessorForPreLaunch(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    int j = 1;
    Object localObject = this.mProcessStack.snapshot();
    boolean bool = paramMiniAppBaseInfo.isInternalApp();
    int i;
    if ((paramMiniAppBaseInfo.renderInfo != null) && (paramMiniAppBaseInfo.renderInfo.renderMode == 1) && (paramMiniAppBaseInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null))
    {
      i = 1;
      if (i != 0) {
        j = 2;
      }
      if (!findExitingProcessForPreLaunch(paramMiniAppBaseInfo)) {
        break label79;
      }
      paramMiniAppBaseInfo = null;
    }
    label79:
    do
    {
      return paramMiniAppBaseInfo;
      i = 0;
      break;
      paramMiniAppBaseInfo = findIdelProcessForPreLaunch((Map)localObject, bool, j);
      if (paramMiniAppBaseInfo != null) {
        return paramMiniAppBaseInfo;
      }
      if (bool) {
        return findInternalAppProcessForPrelaunch(bool, j);
      }
      paramMiniAppBaseInfo = startNewProcessForPreLaunch((Map)localObject, bool, j);
      if (paramMiniAppBaseInfo != null) {
        return paramMiniAppBaseInfo;
      }
      localObject = findFirstSupportedProcessForPreLaunch(bool, j);
      paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject;
    } while (localObject != null);
    return getLowestProcessForPreLaunch();
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainIdleMiniAppProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    boolean bool1 = true;
    Map localMap = this.mProcessStack.snapshot();
    boolean bool2 = paramMiniAppBaseInfo.isInternalApp();
    if ((paramMiniAppBaseInfo.renderInfo != null) && (paramMiniAppBaseInfo.renderInfo.renderMode == 1) && (paramMiniAppBaseInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null))
    {
      if (sInternalProcessInfo != null) {
        localMap.remove(sInternalProcessInfo.processName);
      }
      paramMiniAppBaseInfo = checkProcessForLoadedApp(paramMiniAppBaseInfo, localMap);
      if (paramMiniAppBaseInfo == null) {
        break label92;
      }
    }
    label92:
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo;
    do
    {
      do
      {
        return paramMiniAppBaseInfo;
        bool1 = false;
        break;
        localMiniAppSubProcessorInfo = findExitingIdelProcess(localMap, bool2, bool1);
        paramMiniAppBaseInfo = localMiniAppSubProcessorInfo;
      } while (localMiniAppSubProcessorInfo != null);
      if (bool2) {
        return findProcessForInternalApp();
      }
      localMiniAppSubProcessorInfo = tryStartNewProcess(localMap);
      paramMiniAppBaseInfo = localMiniAppSubProcessorInfo;
    } while (localMiniAppSubProcessorInfo != null);
    return getLowestPriorityProcess();
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainIdleProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
    }
    if ((paramMiniAppBaseInfo.isInternalApp()) && (sInternalProcessInfo != null)) {
      return sInternalProcessInfo;
    }
    return obtainIdleMiniAppProcessor(paramMiniAppBaseInfo);
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainPreLaunchProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {}
    while (paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return null;
    }
    return obtainAppProcessorForPreLaunch(paramMiniAppBaseInfo);
  }
  
  private void printProcessStack()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    Object localObject = this.mProcessStack.snapshot();
    int i = this.mProcessStack.size();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("{").append((String)localEntry.getKey()).append(" ").append(localEntry.getValue()).append("}\n");
    }
    QMLog.w("minisdk-start_LaunchManagerService", "current process count=" + i + " " + localStringBuilder.toString());
  }
  
  private void setIntentFlags(Intent paramIntent, MiniAppInfo paramMiniAppInfo)
  {
    paramIntent.addFlags(805371904);
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo startNewProcessForPreLaunch(Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap, boolean paramBoolean, int paramInt)
  {
    if (this.mProcessStack.size() < this.mProcessMaxCount)
    {
      Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((!paramMap.containsKey(str)) && (localObject != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).support(paramBoolean, paramInt)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from create:" + str);
          return localObject;
        }
      }
    }
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo tryStartNewProcess(Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap)
  {
    if (this.mProcessStack.size() < this.mProcessMaxCount)
    {
      Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((!paramMap.containsKey(str)) && (localObject != null))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from create:" + str);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void updateAllMiniAppInfoForProcess(@android.support.annotation.Nullable MiniAppBaseInfo paramMiniAppBaseInfo, @NonNull Bundle paramBundle, @NonNull AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    paramBundle = paramBundle.getParcelableArrayList("bundle_key_runtime_list");
    if (paramMiniAppBaseInfo != null) {
      paramMiniAppSubProcessorInfo.currentAppInfo = paramMiniAppBaseInfo;
    }
    paramMiniAppSubProcessorInfo.setAllMiniAppInfo(paramMiniAppBaseInfo, paramBundle);
  }
  
  public void doPreloadByRuntimeType(int paramInt)
  {
    QMLog.e("minisdk-start_LaunchManagerService", "preload by runtime type:" + paramInt);
    checkAndCleanAllMiniProcess();
    Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
      if ((localObject != null) && ((((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).supportRuntimeType & paramInt) != 0))
      {
        QMLog.i("minisdk-start_LaunchManagerService", "obtain targe processor:" + str);
        if (!isProcessAlive(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).processName))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "preload targe processor:" + str);
          doPreloadApp((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject, true, true, true, null);
        }
      }
    }
  }
  
  public AppLaunchStrategy.MiniAppSubProcessorInfo getCacheApp(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo != null) {
      return getCacheApp(paramMiniAppBaseInfo.appId);
    }
    return null;
  }
  
  public AppLaunchStrategy.MiniAppSubProcessorInfo getCacheApp(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      String str;
      Iterator localIterator2;
      do
      {
        Iterator localIterator1 = this.mProcessStack.snapshot().entrySet().iterator();
        while (!localIterator2.hasNext())
        {
          do
          {
            do
            {
              if (!localIterator1.hasNext()) {
                break;
              }
              localObject = (Map.Entry)localIterator1.next();
            } while (localObject == null);
            str = (String)((Map.Entry)localObject).getKey();
            localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
          } while ((localObject == null) || (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).allMiniAppInfo.isEmpty()));
          localIterator2 = ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).allMiniAppInfo.iterator();
        }
      } while (!TextUtils.equals(((MiniAppBaseInfo)localIterator2.next()).appId, paramString));
      QMLog.i("minisdk-start_LaunchManagerService", "obtain loaded processor from stack:" + str);
      return localObject;
    }
    return null;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public void killAllProcess()
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        String str = (String)localEntry.getKey();
        forceKillProcess((AppLaunchStrategy.MiniAppSubProcessorInfo)localEntry.getValue());
        cleanProcess(str);
      }
    }
  }
  
  public boolean killMiniAppProcess(@NotNull MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = getCacheApp(paramMiniAppInfo);
    if (paramMiniAppInfo != null) {
      forceKillProcess(paramMiniAppInfo);
    }
    return false;
  }
  
  public void onAppBackground(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    Class localClass = null;
    if (paramBundle != null) {
      paramBundle.setClassLoader(LaunchManagerService.ServiceBinder.class.getClassLoader());
    }
    Object localObject1 = getAppid(paramMiniAppBaseInfo);
    Object localObject2 = getAppName(paramMiniAppBaseInfo);
    int i = getEngineType(paramMiniAppBaseInfo);
    QMLog.i("minisdk-start_LaunchManagerService", "onAppBackground process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.snapshot().get(paramString);
    localObject1 = localObject2;
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo;
    if (localObject2 == null)
    {
      localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      if (localMiniAppSubProcessorInfo == null) {
        break label249;
      }
      localObject1 = localMiniAppSubProcessorInfo.uiClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label255;
      }
      localObject2 = localMiniAppSubProcessorInfo.internalUIClass;
      label177:
      if (localMiniAppSubProcessorInfo != null) {
        localClass = localMiniAppSubProcessorInfo.appPreLoadClass;
      }
      if (localMiniAppSubProcessorInfo == null) {
        break label261;
      }
    }
    label261:
    for (i = localMiniAppSubProcessorInfo.supportRuntimeType;; i = 0)
    {
      localObject1 = new AppLaunchStrategy.MiniAppSubProcessorInfo(this, paramString, (Class)localObject1, (Class)localObject2, localClass, i);
      this.mProcessStack.put(paramString, localObject1);
      updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1);
      ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).onEnterBackground();
      printProcessStack();
      return;
      label249:
      localObject1 = null;
      break;
      label255:
      localObject2 = null;
      break label177;
    }
  }
  
  public void onAppForeground(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    }
    Object localObject1 = getAppid(paramMiniAppBaseInfo);
    Object localObject2 = getAppName(paramMiniAppBaseInfo);
    int i = getEngineType(paramMiniAppBaseInfo);
    int j = getPid(paramBundle);
    QMLog.i("minisdk-start_LaunchManagerService", "onAppForeground process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = createProcessorInfo(paramString, paramMiniAppBaseInfo, (AppLaunchStrategy.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString));
      this.mProcessStack.put(paramString, localObject1);
    }
    updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1);
    if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppBaseInfo))) {
      this.mStartingMiniAppConfig = null;
    }
    if (j > 0) {
      ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).pid = j;
    }
    ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).onEnterForeground();
    printProcessStack();
  }
  
  public void onAppStart(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @NotNull Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    }
    Object localObject = getAppid(paramMiniAppBaseInfo);
    String str = getAppName(paramMiniAppBaseInfo);
    int i = getEngineType(paramMiniAppBaseInfo);
    int j = getPid(paramBundle);
    QMLog.i("minisdk-start_LaunchManagerService", "onAppStart process=" + paramString + " appId=" + (String)localObject + " appName=" + str + " engineType=" + i + " reportType=" + -1);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject = getMiniAppSubProcessorInfo(paramString, paramMiniAppBaseInfo, paramBundle);
    updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (AppLaunchStrategy.MiniAppSubProcessorInfo)localObject);
    ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).pid = j;
    this.mPreloadingTask.remove(paramString);
    printProcessStack();
    paramString = ProcessUtil.getCurrentProcessName(this.mContext);
    QMLog.i("minisdk-start_LaunchManagerService", "updateBaseLib onAppStart " + paramString);
  }
  
  public void onAppStop(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(LaunchManagerService.ServiceBinder.class.getClassLoader());
    }
    String str = getAppid(paramMiniAppBaseInfo);
    Object localObject = getAppName(paramMiniAppBaseInfo);
    int i = getEngineType(paramMiniAppBaseInfo);
    getPid(paramBundle);
    QMLog.i("minisdk-start_LaunchManagerService", "onAppStop process=" + paramString + " appId=" + str + " appName=" + (String)localObject + " engineType=" + i + " reportType=" + -1);
    paramMiniAppBaseInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    if (paramMiniAppBaseInfo != null)
    {
      paramBundle = paramMiniAppBaseInfo.allMiniAppInfo.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (MiniAppBaseInfo)paramBundle.next();
        if (TextUtils.equals(((MiniAppBaseInfo)localObject).appId, str)) {
          paramMiniAppBaseInfo.allMiniAppInfo.remove(localObject);
        }
      }
      if (paramMiniAppBaseInfo.isIdleProcess()) {
        cleanProcess(paramString);
      }
    }
    printProcessStack();
  }
  
  public void onPreloaded(@NotNull String paramString, @NotNull Bundle paramBundle) {}
  
  public void onReceiveProcessRunningAppInfos(@NonNull String paramString, @NotNull List<? extends MiniAppInfo> paramList) {}
  
  public void onRecvCommand(String paramString1, String paramString2, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_LaunchManagerService", "onRecvCommand cmd=" + paramString1 + " processName=" + paramString2);
    if ("cmd_notify_runtime_info".equals(paramString1))
    {
      paramString1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.snapshot().get(paramString2);
      if (paramString1 != null) {
        updateAllMiniAppInfoForProcess(null, paramBundle, paramString1);
      }
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      paramString1 = paramBundle.getParcelableArrayList("bundle_key_runtime_list");
      if (paramString1 != null)
      {
        Iterator localIterator = paramString1.iterator();
        for (paramString1 = "";; paramString1 = paramString1 + paramBundle.name + ";")
        {
          paramBundle = paramString1;
          if (!localIterator.hasNext()) {
            break;
          }
          paramBundle = (MiniAppInfo)localIterator.next();
        }
      }
      paramBundle = "";
      QMLog.i("minisdk-start_LaunchManagerService", "notify runtime info from process:" + paramString2 + " appsDecc:" + paramBundle);
    }
    for (;;)
    {
      printProcessStack();
      return;
      if ("cmd_notify_runtime_lifecycle".equals(paramString1))
      {
        paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        paramString1 = paramBundle.getString("bundle_key_runtime_lifecycle", "N/A");
        paramBundle = (MiniAppInfo)paramBundle.getParcelable("bundle_key_appinfo");
        QMLog.i("minisdk-start_LaunchManagerService", "notify runtime lifecycle from process:" + paramString2 + " lifecycle:" + paramString1);
        if ((paramBundle != null) && ("first_frame".equals(paramString1))) {
          doPreloadExtraMiniApp(paramBundle);
        }
      }
    }
  }
  
  public void preloadExtraMiniApp(boolean paramBoolean)
  {
    label144:
    for (;;)
    {
      try
      {
        int i = this.mProcessStack.size();
        int j = this.mProcessMaxCount;
        Object localObject1;
        Iterator localIterator;
        if (i >= j) {}else
        {
          if (!paramBoolean) {
            break label144;
          }
          localObject1 = "preload_app";
          if ((hasPreloadProcess((String)localObject1)) || (!canPreloadProcess((String)localObject1))) {
            continue;
          }
          localObject1 = this.mProcessStack.snapshot();
          localIterator = subAppProcessorInfoMap.entrySet().iterator();
        }
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (!((Map)localObject1).containsKey((String)localEntry.getKey()))
          {
            doPreloadApp((AppLaunchStrategy.MiniAppSubProcessorInfo)localEntry.getValue(), paramBoolean, false, false, null);
            continue;
            String str = "preload_game";
          }
        }
      }
      finally {}
    }
  }
  
  public boolean preloadProcess(@org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    try
    {
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramBundle.getParcelable("mini_appinfo");
      if (localMiniAppInfo != null)
      {
        doPreLaunchMiniApp(localMiniAppInfo, paramBundle);
        return true;
      }
      i = paramBundle.getInt("mini_key_preload_runtime_type", 0);
      if (i > 0)
      {
        doPreloadByRuntimeType(i);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
      if (paramBundle != null) {}
      for (String str = paramBundle.getString("mini_key_preload_type"); !needPreloadMiniApp(str); str = null) {
        return false;
      }
      int j = this.mProcessPreloadCount - this.mProcessStack.size();
      if (j <= 0) {
        return false;
      }
      Object localObject = ProcessUtil.getCurrentProcessName(this.mContext);
      QMLog.i("minisdk-start_LaunchManagerService", "updateBaseLib preloadMiniApp " + (String)localObject + ", process count=" + j);
      printProcessStack();
      localObject = this.mProcessStack.snapshot();
      boolean bool2 = "preload_app".equals(str);
      int i = 0;
      if ((bool2) && (j > 0))
      {
        if (i % 2 == 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          int k = i + 1;
          i = k;
          if (!bool1) {
            break;
          }
          i = k;
          if (!bool2) {
            break;
          }
          doPreloadApp((Map)localObject, bool1, paramBundle);
          j -= 1;
          i = k;
          break;
        }
      }
    }
    return true;
  }
  
  public void registerProcessMessenger(@NotNull String paramString, @NotNull Messenger paramMessenger)
  {
    QMLog.w("minisdk-start_LaunchManagerService", "registerClientMessenger pName=" + paramString + " messenger:" + paramMessenger);
    this.mClientMessengerMap.put(paramString, paramMessenger);
  }
  
  public void sendMessageToMiniProcess(@NotNull MiniAppInfo paramMiniAppInfo, @NotNull Message paramMessage)
  {
    paramMiniAppInfo = findMiniAppProcessInfo(paramMiniAppInfo);
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.processName))) {
      throw new RemoteException("sendCmdToMiniProcess failed! Has no processor info.");
    }
    paramMiniAppInfo = (Messenger)this.mClientMessengerMap.get(paramMiniAppInfo.processName);
    if (paramMiniAppInfo == null) {
      throw new RemoteException("sendCmdToMiniProcess failed! Messenger is null.");
    }
    paramMiniAppInfo.send(paramMessage);
  }
  
  @NotNull
  public LaunchStrategy.LaunchData startMiniApp(@NotNull MiniAppInfo paramMiniAppInfo)
  {
    checkAndCleanAllMiniProcess();
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = obtainIdleProcessor(paramMiniAppInfo);
    if ((localMiniAppSubProcessorInfo == null) || (paramMiniAppInfo == null)) {
      throw new IllegalStateException("obtain idle processor config failed!");
    }
    if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppInfo)) && (System.currentTimeMillis() - this.mStartTimestamp <= this.mStartTimeInterval)) {
      QMLog.i("minisdk-start_LaunchManagerService", "startMiniApp duplicate. The miniapp is starting! interval=" + this.mStartTimeInterval + " appId=" + paramMiniAppInfo.appId);
    }
    this.startAppIdMap.put(paramMiniAppInfo.appId, Long.valueOf(System.currentTimeMillis()));
    this.mStartingMiniAppConfig = paramMiniAppInfo;
    this.mStartTimestamp = System.currentTimeMillis();
    boolean bool = localMiniAppSubProcessorInfo.containsAppConfig(paramMiniAppInfo);
    QMLog.i("minisdk-start_LaunchManagerService", "doStartMiniApp appId=" + paramMiniAppInfo.appId + " appName=" + paramMiniAppInfo.name + " isInternal:" + paramMiniAppInfo.isInternalApp() + " engineType=" + paramMiniAppInfo.getEngineType() + " reportType=" + -1 + " targetProcess=" + localMiniAppSubProcessorInfo.processName + " alreadyStarted=" + bool);
    Context localContext = this.mContext;
    if ((paramMiniAppInfo.isInternalApp()) && (localMiniAppSubProcessorInfo.internalUIClass != null)) {}
    for (Object localObject = localMiniAppSubProcessorInfo.internalUIClass;; localObject = localMiniAppSubProcessorInfo.uiClass)
    {
      localObject = new Intent(localContext, (Class)localObject);
      setIntentFlags((Intent)localObject, paramMiniAppInfo);
      return new LaunchStrategy.LaunchData((Intent)localObject, getProcessState(localMiniAppSubProcessorInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy
 * JD-Core Version:    0.7.0.1
 */