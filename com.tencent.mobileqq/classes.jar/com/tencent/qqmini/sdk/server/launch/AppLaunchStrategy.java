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
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    Object localObject2 = sInternalProcessInfo;
    if (localObject2 != null) {
      ((Map)localObject1).remove(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).processName);
    }
    int j = this.mProcessMaxCount;
    localObject1 = ((Map)localObject1).entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (paramString.equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType))) {
          i += 1;
        }
      }
    }
    if (i < j) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void checkAndCleanAllMiniProcess()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 == null) {
          break label411;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 != null)
        {
          if (((List)localObject1).size() <= 0) {
            return;
          }
          Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
          boolean bool = localIterator.hasNext();
          i = 1;
          Object localObject4;
          Object localObject3;
          if (bool)
          {
            localObject4 = (Map.Entry)localIterator.next();
            if (localObject4 == null) {
              continue;
            }
            localObject3 = (String)((Map.Entry)localObject4).getKey();
            localObject4 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject4).getValue();
            if (localObject4 == null) {
              continue;
            }
            Object localObject5 = ((List)localObject1).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break label416;
            }
            if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject5).next()).pid != ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject4).pid) {
              continue;
            }
            if (i != 0) {
              continue;
            }
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("Process has been died, clean the record! processName=");
            ((StringBuilder)localObject5).append((String)localObject3);
            ((StringBuilder)localObject5).append(" pid=");
            ((StringBuilder)localObject5).append(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject4).pid);
            QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject5).toString());
            localObject3 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.remove(localObject3);
            if (localObject3 == null) {
              continue;
            }
            ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject3).clean();
            continue;
          }
          localIterator = this.mPreloadingTask.entrySet().iterator();
          if (localIterator.hasNext())
          {
            localObject3 = (Map.Entry)localIterator.next();
            if (localObject3 == null) {
              continue;
            }
            localObject3 = (String)((Map.Entry)localObject3).getKey();
            localObject4 = ((List)localObject1).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label421;
            }
            if (!TextUtils.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject4).next()).processName, (CharSequence)localObject3)) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Process has been died, clean the preloading record! processName=");
            ((StringBuilder)localObject4).append((String)localObject3);
            QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject4).toString());
            localIterator.remove();
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
      }
      return;
      label411:
      Object localObject2 = null;
      continue;
      label416:
      int i = 0;
      continue;
      label421:
      i = 0;
    }
  }
  
  private void checkPreload()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkPreload MiniAppUsed:");
    localStringBuilder.append(this.mMiniAppUsed);
    QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
    try
    {
      if (this.mMiniAppUsed)
      {
        this.mLastPreloadDetectTime = System.currentTimeMillis();
        checkAndCleanAllMiniProcess();
        preloadExtraMiniApp(true);
        preloadExtraMiniApp(false);
        return;
      }
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
      Iterator localIterator1 = paramMap.entrySet().iterator();
      Object localObject;
      Iterator localIterator2;
      do
      {
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
            paramMap = (String)((Map.Entry)localObject).getKey();
            localObject = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
          } while (localObject == null);
          if (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).containsAppConfig(paramMiniAppBaseInfo))
          {
            paramMiniAppBaseInfo = new StringBuilder();
            paramMiniAppBaseInfo.append("obtain loaded processor from stack:");
            paramMiniAppBaseInfo.append(paramMap);
            QMLog.i("minisdk-start_LaunchManagerService", paramMiniAppBaseInfo.toString());
            return localObject;
          }
          localIterator2 = ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).allMiniAppInfo.iterator();
        }
      } while (!equalAppInfo(paramMiniAppBaseInfo, (MiniAppBaseInfo)localIterator2.next()));
      paramMiniAppBaseInfo = new StringBuilder();
      paramMiniAppBaseInfo.append("obtain loaded processor from stack for cache runtime:");
      paramMiniAppBaseInfo.append(paramMap);
      QMLog.i("minisdk-start_LaunchManagerService", paramMiniAppBaseInfo.toString());
      return localObject;
    }
    return null;
  }
  
  private void cleanProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.remove(paramString);
    if (localMiniAppSubProcessorInfo != null) {
      localMiniAppSubProcessorInfo.clean();
    }
    localMiniAppSubProcessorInfo = this.lastKillingProcessor;
    if ((localMiniAppSubProcessorInfo != null) && (paramString.equals(localMiniAppSubProcessorInfo.processName)))
    {
      paramString = this.lastKillingProcessor;
      getHandler().postDelayed(new AppLaunchStrategy.1(this, paramString), 2000L);
      this.lastKillingProcessor = null;
    }
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo createProcessorInfo(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    Class localClass3 = null;
    Class localClass1;
    if (paramMiniAppSubProcessorInfo != null) {
      localClass1 = paramMiniAppSubProcessorInfo.uiClass;
    } else {
      localClass1 = null;
    }
    Class localClass2;
    if (paramMiniAppSubProcessorInfo != null) {
      localClass2 = paramMiniAppSubProcessorInfo.internalUIClass;
    } else {
      localClass2 = null;
    }
    if (paramMiniAppSubProcessorInfo != null) {
      localClass3 = paramMiniAppSubProcessorInfo.appPreLoadClass;
    }
    int i;
    if (paramMiniAppSubProcessorInfo != null) {
      i = paramMiniAppSubProcessorInfo.supportRuntimeType;
    } else {
      i = 0;
    }
    paramMiniAppSubProcessorInfo = new AppLaunchStrategy.MiniAppSubProcessorInfo(this, paramString, localClass1, localClass2, localClass3, i);
    if ((paramMiniAppSubProcessorInfo.preloadType == null) && (paramMiniAppBaseInfo != null))
    {
      if (paramMiniAppBaseInfo.isEngineTypeMiniApp()) {
        paramString = "preload_app";
      } else {
        paramString = "preload_game";
      }
      paramMiniAppSubProcessorInfo.preloadType = paramString;
    }
    return paramMiniAppSubProcessorInfo;
  }
  
  private void doPreLaunchMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo != null)
    {
      if (!paramMiniAppInfo.isEngineTypeMiniApp()) {
        return;
      }
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PreLaunch mini app. appId:");
        ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
        ((StringBuilder)localObject).append(" appName:");
        ((StringBuilder)localObject).append(paramMiniAppInfo.name);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
        localObject = obtainPreLaunchProcessor(paramMiniAppInfo);
        if (localObject == null)
        {
          QMLog.e("minisdk-start_LaunchManagerService", "obtain processor config failed!");
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PreLaunch mini app in process:");
        localStringBuilder.append(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).processName);
        localStringBuilder.append(" appId:");
        localStringBuilder.append(paramMiniAppInfo.appId);
        localStringBuilder.append(" appName:");
        localStringBuilder.append(paramMiniAppInfo.name);
        QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
        paramMiniAppInfo = new Intent();
        paramMiniAppInfo.setClass(this.mContext, ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).appPreLoadClass);
        paramMiniAppInfo.setAction("mini_prelaunch_app");
        paramMiniAppInfo.putExtra("sdk_mode", true);
        if (paramBundle != null) {
          paramMiniAppInfo.putExtras(paramBundle);
        }
        paramBundle = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        paramMiniAppInfo.putExtra("KEY_LOGININFO", new LoginInfo(paramBundle.getLoginType(), paramBundle.getAccount(), paramBundle.getNickName(), paramBundle.getPayOpenId(), paramBundle.getPayOpenKey(), paramBundle.getPayAccessToken(), paramBundle.getLoginSig(), paramBundle.getPlatformId(), paramBundle.getAppId()));
        paramMiniAppInfo.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
        this.mContext.sendBroadcast(paramMiniAppInfo);
        return;
      }
      catch (Throwable paramMiniAppInfo)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "send preload Broadcast exception!", paramMiniAppInfo);
      }
    }
  }
  
  private void doPreloadApp(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    if (paramMiniAppSubProcessorInfo != null) {
      if ((!paramBoolean2) && (!canPreloadApp(paramMiniAppSubProcessorInfo))) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("do preload mini process name=");
        ((StringBuilder)localObject1).append(paramMiniAppSubProcessorInfo.processName);
        ((StringBuilder)localObject1).append(" Preload=");
        ((StringBuilder)localObject1).append(paramMiniAppSubProcessorInfo.appPreLoadClass.getSimpleName());
        ((StringBuilder)localObject1).append(" isMiniApp:");
        ((StringBuilder)localObject1).append(paramBoolean1);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
        Intent localIntent = new Intent();
        localIntent.setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
        if (!paramBoolean1) {
          break label339;
        }
        localObject1 = "mini_preload_app";
        localIntent.setAction((String)localObject1);
        localIntent.putExtra("sdk_mode", true);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        Object localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        int i = ((MiniAppProxy)localObject2).getLoginType();
        paramBundle = ((MiniAppProxy)localObject2).getAccount();
        localObject1 = ((MiniAppProxy)localObject2).getNickName();
        String str1 = ((MiniAppProxy)localObject2).getPayOpenId();
        String str2 = ((MiniAppProxy)localObject2).getPayOpenKey();
        String str3 = ((MiniAppProxy)localObject2).getPayAccessToken();
        byte[] arrayOfByte = ((MiniAppProxy)localObject2).getLoginSig();
        String str4 = ((MiniAppProxy)localObject2).getPlatformId();
        localObject2 = ((MiniAppProxy)localObject2).getAppId();
        try
        {
          localIntent.putExtra("KEY_LOGININFO", new LoginInfo(i, paramBundle, (String)localObject1, str1, str2, str3, arrayOfByte, str4, (String)localObject2));
          localIntent.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
          paramBundle = this.mPreloadingTask;
          localObject1 = paramMiniAppSubProcessorInfo.processName;
          if (!paramBoolean1) {
            break label347;
          }
          paramMiniAppSubProcessorInfo = "preload_app";
          paramBundle.put(localObject1, paramMiniAppSubProcessorInfo);
          this.mContext.sendBroadcast(localIntent);
          return;
        }
        catch (Throwable paramMiniAppSubProcessorInfo) {}
        QMLog.e("minisdk-start_LaunchManagerService", "send preload Broadcast exception!", paramMiniAppSubProcessorInfo);
      }
      catch (Throwable paramMiniAppSubProcessorInfo) {}
      return;
      label339:
      Object localObject1 = "mini_preload_game";
      continue;
      label347:
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
    if (paramMiniAppBaseInfo == null) {
      return;
    }
    if ((!paramMiniAppBaseInfo.isEngineTypeMiniGame()) && (paramMiniAppBaseInfo != null)) {
      getHandler().postDelayed(new AppLaunchStrategy.2(this, paramMiniAppBaseInfo), 1000L);
    }
  }
  
  public static boolean equalAppInfo(MiniAppBaseInfo paramMiniAppBaseInfo1, MiniAppBaseInfo paramMiniAppBaseInfo2)
  {
    if (paramMiniAppBaseInfo1 != null)
    {
      if (paramMiniAppBaseInfo2 == null) {
        return false;
      }
      if (paramMiniAppBaseInfo1.getEngineType() != paramMiniAppBaseInfo2.getEngineType()) {
        return false;
      }
      if ((!TextUtils.isEmpty(paramMiniAppBaseInfo1.appId)) && (TextUtils.equals(paramMiniAppBaseInfo1.appId, paramMiniAppBaseInfo2.appId))) {
        return true;
      }
      if ((!TextUtils.isEmpty(paramMiniAppBaseInfo1.link)) && (TextUtils.equals(paramMiniAppBaseInfo1.link, paramMiniAppBaseInfo2.link))) {
        return true;
      }
    }
    return false;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo findCacheMiniProcessInfo(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    do
    {
      Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
      while (!((Iterator)localObject2).hasNext())
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
          localObject1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        } while (localObject1 == null);
        if (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).containsAppConfig(paramMiniAppBaseInfo)) {
          return localObject1;
        }
        localObject2 = ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).allMiniAppInfo.iterator();
      }
    } while (!equalAppInfo(paramMiniAppBaseInfo, (MiniAppBaseInfo)((Iterator)localObject2).next()));
    return localObject1;
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findExitingIdelProcess(Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        paramMap = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).currentAppInfo == null) && ("preload_app".equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType)) && ((!paramBoolean1) || (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).internalUIClass != null)) && ((!paramBoolean2) || ((((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).supportRuntimeType & 0x2) > 0)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("obtain idle processor from stack:");
          ((StringBuilder)localObject1).append(paramMap);
          QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
          return localObject2;
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
    Object localObject = subAppProcessorInfoMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
      if ((localMiniAppSubProcessorInfo != null) && (localMiniAppSubProcessorInfo.support(paramBoolean, paramInt)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("obtain PreLaunch processor from config list: ");
        ((StringBuilder)localObject).append(localMiniAppSubProcessorInfo.processName);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
        return localMiniAppSubProcessorInfo;
      }
    }
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findIdelProcessForPreLaunch(Map<String, AppLaunchStrategy.MiniAppSubProcessorInfo> paramMap, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = paramMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        paramMap = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).currentAppInfo == null) && ("preload_app".equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType)) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).support(paramBoolean, paramInt)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("obtain PreLaunch processor from stack:");
          ((StringBuilder)localObject1).append(paramMap);
          QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
          return localObject2;
        }
      }
    }
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findInternalAppProcessForPrelaunch(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = subAppProcessorInfoMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).support(paramBoolean, paramInt)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("obtain PreLaunch processor support internal mode ");
        ((StringBuilder)localObject1).append(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).processName);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
        return localObject2;
      }
    }
    return null;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo findMiniAppProcessInfo(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    if (paramMiniAppInfo == null) {
      return null;
    }
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject1;
    do
    {
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
      } while (localObject1 == null);
      String str = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
    } while ((localObject1 == null) || (!((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).containsAppConfig(paramMiniAppInfo)));
    return localObject1;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo findProcessForInternalApp()
  {
    Object localObject1 = subAppProcessorInfoMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).internalUIClass != null))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("obtain processor support internal mode ");
        ((StringBuilder)localObject1).append(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).processName);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
        return localObject2;
      }
    }
    return null;
  }
  
  private boolean finishAndRemoveTask(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
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
      ActivityManager.AppTask localAppTask = null;
      localObject1 = localAppTask;
      if (!paramBoolean)
      {
        localObject1 = localAppTask;
        if (!paramMiniAppSubProcessorInfo.allMiniAppInfo.isEmpty()) {
          localObject1 = (MiniAppBaseInfo)paramMiniAppSubProcessorInfo.allMiniAppInfo.get(paramMiniAppSubProcessorInfo.allMiniAppInfo.size() - 1);
        }
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localAppTask = (ActivityManager.AppTask)((Iterator)localObject2).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null))
        {
          Object localObject3 = localAppTask.getTaskInfo().baseIntent.getComponent();
          if (localObject3 != null) {
            if (paramBoolean)
            {
              localObject3 = localAppTask.getTaskInfo().baseIntent.getComponent().getClassName();
              if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (paramMiniAppSubProcessorInfo.uiClass != null) && (((String)localObject3).equals(paramMiniAppSubProcessorInfo.uiClass.getName())))
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("finishAndRemoveTask finish and remove task: id=");
                ((StringBuilder)localObject3).append(localAppTask.getTaskInfo().id);
                ((StringBuilder)localObject3).append(" ui:");
                ((StringBuilder)localObject3).append(paramMiniAppSubProcessorInfo.uiClass);
                QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject3).toString());
              }
            }
            else if (TextUtils.equals(localAppTask.getTaskInfo().baseIntent.getStringExtra("APP_INTENT_APP_ID"), ((MiniAppBaseInfo)localObject1).appId))
            {
              paramMiniAppSubProcessorInfo = new StringBuilder();
              paramMiniAppSubProcessorInfo.append("finishAndRemoveTask finish and remove task: id=");
              paramMiniAppSubProcessorInfo.append(localAppTask.getTaskInfo().id);
              paramMiniAppSubProcessorInfo.append(" app:");
              paramMiniAppSubProcessorInfo.append(((MiniAppBaseInfo)localObject1).name);
              QMLog.i("minisdk-start_LaunchManagerService", paramMiniAppSubProcessorInfo.toString());
              localAppTask.finishAndRemoveTask();
            }
          }
        }
      }
      return true;
    }
    catch (Throwable paramMiniAppSubProcessorInfo)
    {
      label381:
      break label381;
    }
    QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
    return false;
  }
  
  private void forceKillProcess(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    if (paramMiniAppSubProcessorInfo == null) {
      return;
    }
    this.lastKillingProcessor = paramMiniAppSubProcessorInfo;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("kill mini process: ");
    ((StringBuilder)localObject).append(this.lastKillingProcessor);
    QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
    int i = paramMiniAppSubProcessorInfo.pid;
    if (i > 0) {}
    try
    {
      if (this.mKillProcessMode == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("kill process by pid:");
        ((StringBuilder)localObject).append(i);
        QMLog.w("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
        finishAndRemoveTask(paramMiniAppSubProcessorInfo, true);
        Process.killProcess(i);
        cleanProcess(paramMiniAppSubProcessorInfo.processName);
        printProcessStack();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("kill process by broadcast");
      ((StringBuilder)localObject).append(paramMiniAppSubProcessorInfo.processName);
      QMLog.w("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
      localObject = new Intent();
      ((Intent)localObject).setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
      this.mContext.sendBroadcast((Intent)localObject);
      return;
    }
    catch (Throwable paramMiniAppSubProcessorInfo)
    {
      label179:
      break label179;
    }
    QMLog.e("minisdk-start_LaunchManagerService", "kill process exception!", paramMiniAppSubProcessorInfo);
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
    Object localObject2 = sInternalProcessInfo;
    if (localObject2 != null) {
      ((Map)localObject1).remove(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).processName);
    }
    Object localObject3 = ((Map)localObject1).entrySet().iterator();
    localObject1 = null;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
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
    if (localObject1 != null)
    {
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
      if (localObject1 != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("obtain idle processor from stack bottom:");
        ((StringBuilder)localObject3).append((String)localObject2);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject3).toString());
        return localObject1;
      }
    }
    return null;
  }
  
  @android.support.annotation.Nullable
  private AppLaunchStrategy.MiniAppSubProcessorInfo getLowestProcessForPreLaunch()
  {
    Object localObject3 = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject1 = null;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
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
    if (localObject1 != null)
    {
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
      if (localObject1 != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("obtain PreLaunch idle processor from stack bottom:");
        ((StringBuilder)localObject3).append((String)localObject2);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject3).toString());
        return localObject1;
      }
    }
    return null;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo getMiniAppSubProcessorInfo(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @NotNull Bundle paramBundle)
  {
    Object localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      Object localObject3 = null;
      if (localMiniAppSubProcessorInfo != null) {
        localObject1 = localMiniAppSubProcessorInfo.uiClass;
      } else {
        localObject1 = null;
      }
      if (localMiniAppSubProcessorInfo != null) {
        localObject2 = localMiniAppSubProcessorInfo.internalUIClass;
      } else {
        localObject2 = null;
      }
      Class localClass;
      if (localMiniAppSubProcessorInfo != null) {
        localClass = localMiniAppSubProcessorInfo.appPreLoadClass;
      } else {
        localClass = null;
      }
      int i;
      if (localMiniAppSubProcessorInfo != null) {
        i = localMiniAppSubProcessorInfo.supportRuntimeType;
      } else {
        i = 0;
      }
      localObject2 = new AppLaunchStrategy.MiniAppSubProcessorInfo(this, paramString, (Class)localObject1, (Class)localObject2, localClass, i);
      localObject1 = localObject3;
      if (paramBundle != null) {
        localObject1 = paramBundle.getString("mini_key_preload_type", null);
      }
      ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType = ((String)localObject1);
      if ((((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType == null) && (paramMiniAppBaseInfo != null))
      {
        if (paramMiniAppBaseInfo.isEngineTypeMiniApp()) {
          paramMiniAppBaseInfo = "preload_app";
        } else {
          paramMiniAppBaseInfo = "preload_game";
        }
        ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType = paramMiniAppBaseInfo;
      }
      this.mProcessStack.put(paramString, localObject2);
      localObject1 = localObject2;
    }
    return localObject1;
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
      return ProcessState.PRELOADED;
    }
    if (paramMiniAppSubProcessorInfo.pid > 0) {
      localProcessState = ProcessState.REUSE;
    }
    return localProcessState;
  }
  
  private boolean hasPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    Object localObject2 = sInternalProcessInfo;
    if (localObject2 != null) {
      ((Map)localObject1).remove(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).processName);
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
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
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 != null)
        {
          localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
          boolean bool1 = bool2;
          if (localObject1 != null)
          {
            if (((List)localObject1).size() <= 0) {
              return false;
            }
            localObject1 = ((List)localObject1).iterator();
            bool1 = bool2;
            if (((Iterator)localObject1).hasNext())
            {
              int i = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).pid;
              if (i != paramInt) {
                continue;
              }
              bool1 = true;
            }
          }
          return bool1;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
        return false;
      }
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
    Object localObject1 = this.mProcessStack.snapshot().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).isIdleProcess()) && (paramString != null) && (paramString.equals(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject2).preloadType)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("No need to preload mini process. ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(". Already has idle process ");
          ((StringBuilder)localObject1).append(localObject2);
          QMLog.d("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
          return false;
        }
      }
    }
    if (hasPreloadingTask(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No need to preload mini process ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(". Already has preloading task ");
      ((StringBuilder)localObject1).append(this.mPreloadingTask);
      QMLog.d("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
      return false;
    }
    return true;
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainAppProcessorForPreLaunch(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Map localMap = this.mProcessStack.snapshot();
    boolean bool = paramMiniAppBaseInfo.isInternalApp();
    RenderInfo localRenderInfo = paramMiniAppBaseInfo.renderInfo;
    int j = 1;
    int i;
    if ((localRenderInfo != null) && (paramMiniAppBaseInfo.renderInfo.renderMode == 1) && (paramMiniAppBaseInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      j = 2;
    }
    if (findExitingProcessForPreLaunch(paramMiniAppBaseInfo)) {
      return null;
    }
    paramMiniAppBaseInfo = findIdelProcessForPreLaunch(localMap, bool, j);
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo;
    }
    if (bool) {
      return findInternalAppProcessForPrelaunch(bool, j);
    }
    paramMiniAppBaseInfo = startNewProcessForPreLaunch(localMap, bool, j);
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo;
    }
    paramMiniAppBaseInfo = findFirstSupportedProcessForPreLaunch(bool, j);
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo;
    }
    return getLowestProcessForPreLaunch();
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainIdleMiniAppProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Map localMap = this.mProcessStack.snapshot();
    boolean bool2 = paramMiniAppBaseInfo.isInternalApp();
    Object localObject = paramMiniAppBaseInfo.renderInfo;
    boolean bool1 = true;
    if ((localObject == null) || (paramMiniAppBaseInfo.renderInfo.renderMode != 1) || (paramMiniAppBaseInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) == null)) {
      bool1 = false;
    }
    localObject = sInternalProcessInfo;
    if (localObject != null) {
      localMap.remove(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).processName);
    }
    paramMiniAppBaseInfo = checkProcessForLoadedApp(paramMiniAppBaseInfo, localMap);
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo;
    }
    paramMiniAppBaseInfo = findExitingIdelProcess(localMap, bool2, bool1);
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo;
    }
    if (bool2) {
      return findProcessForInternalApp();
    }
    paramMiniAppBaseInfo = tryStartNewProcess(localMap);
    if (paramMiniAppBaseInfo != null) {
      return paramMiniAppBaseInfo;
    }
    return getLowestPriorityProcess();
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainIdleProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
    }
    if (paramMiniAppBaseInfo.isInternalApp())
    {
      AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = sInternalProcessInfo;
      if (localMiniAppSubProcessorInfo != null) {
        return localMiniAppSubProcessorInfo;
      }
    }
    return obtainIdleMiniAppProcessor(paramMiniAppBaseInfo);
  }
  
  private AppLaunchStrategy.MiniAppSubProcessorInfo obtainPreLaunchProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
    }
    if (!paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return obtainAppProcessorForPreLaunch(paramMiniAppBaseInfo);
    }
    return null;
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
      localStringBuilder.append("{");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(" ");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("}\n");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("current process count=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    QMLog.w("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
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
          paramMap = new StringBuilder();
          paramMap.append("obtain idle processor from create:");
          paramMap.append(str);
          QMLog.i("minisdk-start_LaunchManagerService", paramMap.toString());
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
          paramMap = new StringBuilder();
          paramMap.append("obtain idle processor from create:");
          paramMap.append(str);
          QMLog.i("minisdk-start_LaunchManagerService", paramMap.toString());
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("preload by runtime type:");
    ((StringBuilder)localObject1).append(paramInt);
    QMLog.e("minisdk-start_LaunchManagerService", ((StringBuilder)localObject1).toString());
    checkAndCleanAllMiniProcess();
    Object localObject2 = subAppProcessorInfoMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (AppLaunchStrategy.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
      if ((localObject3 != null) && ((((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject3).supportRuntimeType & paramInt) != 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("obtain targe processor:");
        localStringBuilder.append((String)localObject1);
        QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
        if (!isProcessAlive(((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject3).processName))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("preload targe processor:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject2).toString());
          doPreloadApp((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject3, true, true, true, null);
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
      paramString = new StringBuilder();
      paramString.append("obtain loaded processor from stack:");
      paramString.append(str);
      QMLog.i("minisdk-start_LaunchManagerService", paramString.toString());
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
    if (paramBundle != null) {
      paramBundle.setClassLoader(LaunchManagerService.ServiceBinder.class.getClassLoader());
    }
    Object localObject1 = getAppid(paramMiniAppBaseInfo);
    Object localObject2 = getAppName(paramMiniAppBaseInfo);
    int i = getEngineType(paramMiniAppBaseInfo);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onAppBackground process=");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(" appId=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" appName=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" engineType=");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append(" reportType=");
    ((StringBuilder)localObject3).append(-1);
    QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject3).toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject2 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.snapshot().get(paramString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppLaunchStrategy.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      localObject3 = null;
      if (localMiniAppSubProcessorInfo != null) {
        localObject1 = localMiniAppSubProcessorInfo.uiClass;
      } else {
        localObject1 = null;
      }
      if (localMiniAppSubProcessorInfo != null) {
        localObject2 = localMiniAppSubProcessorInfo.internalUIClass;
      } else {
        localObject2 = null;
      }
      if (localMiniAppSubProcessorInfo != null) {
        localObject3 = localMiniAppSubProcessorInfo.appPreLoadClass;
      }
      if (localMiniAppSubProcessorInfo != null) {
        i = localMiniAppSubProcessorInfo.supportRuntimeType;
      } else {
        i = 0;
      }
      localObject1 = new AppLaunchStrategy.MiniAppSubProcessorInfo(this, paramString, (Class)localObject1, (Class)localObject2, (Class)localObject3, i);
      this.mProcessStack.put(paramString, localObject1);
    }
    updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1);
    ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject1).onEnterBackground();
    printProcessStack();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAppForeground process=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" appId=");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" appName=");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(" engineType=");
    localStringBuilder.append(i);
    localStringBuilder.append(" reportType=");
    localStringBuilder.append(-1);
    QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
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
    paramString = this.mStartingMiniAppConfig;
    if ((paramString != null) && (paramString.equals(paramMiniAppBaseInfo))) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAppStart process=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" appId=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" appName=");
    localStringBuilder.append(str);
    localStringBuilder.append(" engineType=");
    localStringBuilder.append(i);
    localStringBuilder.append(" reportType=");
    localStringBuilder.append(-1);
    QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject = getMiniAppSubProcessorInfo(paramString, paramMiniAppBaseInfo, paramBundle);
    updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (AppLaunchStrategy.MiniAppSubProcessorInfo)localObject);
    ((AppLaunchStrategy.MiniAppSubProcessorInfo)localObject).pid = j;
    this.mPreloadingTask.remove(paramString);
    printProcessStack();
    paramString = ProcessUtil.getCurrentProcessName(this.mContext);
    paramMiniAppBaseInfo = new StringBuilder();
    paramMiniAppBaseInfo.append("updateBaseLib onAppStart ");
    paramMiniAppBaseInfo.append(paramString);
    QMLog.i("minisdk-start_LaunchManagerService", paramMiniAppBaseInfo.toString());
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
    paramMiniAppBaseInfo = new StringBuilder();
    paramMiniAppBaseInfo.append("onAppStop process=");
    paramMiniAppBaseInfo.append(paramString);
    paramMiniAppBaseInfo.append(" appId=");
    paramMiniAppBaseInfo.append(str);
    paramMiniAppBaseInfo.append(" appName=");
    paramMiniAppBaseInfo.append((String)localObject);
    paramMiniAppBaseInfo.append(" engineType=");
    paramMiniAppBaseInfo.append(i);
    paramMiniAppBaseInfo.append(" reportType=");
    paramMiniAppBaseInfo.append(-1);
    QMLog.i("minisdk-start_LaunchManagerService", paramMiniAppBaseInfo.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRecvCommand cmd=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" processName=");
    ((StringBuilder)localObject).append(paramString2);
    QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
    if ("cmd_notify_runtime_info".equals(paramString1))
    {
      paramString1 = (AppLaunchStrategy.MiniAppSubProcessorInfo)this.mProcessStack.snapshot().get(paramString2);
      if (paramString1 != null) {
        updateAllMiniAppInfoForProcess(null, paramBundle, paramString1);
      }
      paramString1 = "";
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      localObject = paramBundle.getParcelableArrayList("bundle_key_runtime_list");
      paramBundle = paramString1;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        for (;;)
        {
          paramBundle = paramString1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramBundle = (MiniAppInfo)((Iterator)localObject).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(paramBundle.name);
          localStringBuilder.append(";");
          paramString1 = localStringBuilder.toString();
        }
      }
      paramString1 = new StringBuilder();
      paramString1.append("notify runtime info from process:");
      paramString1.append(paramString2);
      paramString1.append(" appsDecc:");
      paramString1.append(paramBundle);
      QMLog.i("minisdk-start_LaunchManagerService", paramString1.toString());
    }
    else if ("cmd_notify_runtime_lifecycle".equals(paramString1))
    {
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      paramString1 = paramBundle.getString("bundle_key_runtime_lifecycle", "N/A");
      paramBundle = (MiniAppInfo)paramBundle.getParcelable("bundle_key_appinfo");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notify runtime lifecycle from process:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" lifecycle:");
      ((StringBuilder)localObject).append(paramString1);
      QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
      if ((paramBundle != null) && ("first_frame".equals(paramString1))) {
        doPreloadExtraMiniApp(paramBundle);
      }
    }
    printProcessStack();
  }
  
  public void preloadExtraMiniApp(boolean paramBoolean)
  {
    try
    {
      int i = this.mProcessStack.size();
      int j = this.mProcessMaxCount;
      if (i >= j) {
        return;
      }
      if (!paramBoolean) {
        break label162;
      }
      localObject1 = "preload_app";
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Iterator localIterator;
        for (;;)
        {
          throw localObject2;
        }
        label162:
        String str = "preload_game";
      }
    }
    if ((!hasPreloadProcess((String)localObject1)) && (canPreloadProcess((String)localObject1)))
    {
      localObject1 = this.mProcessStack.snapshot();
      localIterator = subAppProcessorInfoMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((Map)localObject1).containsKey((String)localEntry.getKey()))
        {
          doPreloadApp((AppLaunchStrategy.MiniAppSubProcessorInfo)localEntry.getValue(), paramBoolean, false, false, null);
          return;
        }
      }
      return;
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
      String str;
      if (paramBundle != null) {
        str = paramBundle.getString("mini_key_preload_type");
      } else {
        str = null;
      }
      if (!needPreloadMiniApp(str)) {
        return false;
      }
      int j = this.mProcessPreloadCount - this.mProcessStack.size();
      if (j <= 0) {
        return false;
      }
      Object localObject = ProcessUtil.getCurrentProcessName(this.mContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBaseLib preloadMiniApp ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", process count=");
      localStringBuilder.append(j);
      QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
      printProcessStack();
      localObject = this.mProcessStack.snapshot();
      boolean bool2 = "preload_app".equals(str);
      int i = 0;
      while ((bool2) && (j > 0))
      {
        boolean bool1;
        if (i % 2 == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        int k = i + 1;
        i = k;
        if (bool1)
        {
          i = k;
          if (bool2)
          {
            doPreloadApp((Map)localObject, bool1, paramBundle);
            j -= 1;
            i = k;
          }
        }
      }
    }
    return true;
  }
  
  public void registerProcessMessenger(@NotNull String paramString, @NotNull Messenger paramMessenger)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerClientMessenger pName=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" messenger:");
    localStringBuilder.append(paramMessenger);
    QMLog.w("minisdk-start_LaunchManagerService", localStringBuilder.toString());
    this.mClientMessengerMap.put(paramString, paramMessenger);
  }
  
  public void sendMessageToMiniProcess(@NotNull MiniAppInfo paramMiniAppInfo, @NotNull Message paramMessage)
  {
    paramMiniAppInfo = findMiniAppProcessInfo(paramMiniAppInfo);
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.processName)))
    {
      paramMiniAppInfo = (Messenger)this.mClientMessengerMap.get(paramMiniAppInfo.processName);
      if (paramMiniAppInfo != null)
      {
        paramMiniAppInfo.send(paramMessage);
        return;
      }
      throw new RemoteException("sendCmdToMiniProcess failed! Messenger is null.");
    }
    throw new RemoteException("sendCmdToMiniProcess failed! Has no processor info.");
  }
  
  @NotNull
  public LaunchStrategy.LaunchData startMiniApp(@NotNull MiniAppInfo paramMiniAppInfo)
  {
    checkAndCleanAllMiniProcess();
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = obtainIdleProcessor(paramMiniAppInfo);
    if ((localMiniAppSubProcessorInfo != null) && (paramMiniAppInfo != null))
    {
      Object localObject = this.mStartingMiniAppConfig;
      if ((localObject != null) && (((MiniAppBaseInfo)localObject).equals(paramMiniAppInfo)) && (System.currentTimeMillis() - this.mStartTimestamp <= this.mStartTimeInterval))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startMiniApp duplicate. The miniapp is starting! interval=");
        ((StringBuilder)localObject).append(this.mStartTimeInterval);
        ((StringBuilder)localObject).append(" appId=");
        ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
        QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
      }
      this.startAppIdMap.put(paramMiniAppInfo.appId, Long.valueOf(System.currentTimeMillis()));
      this.mStartingMiniAppConfig = paramMiniAppInfo;
      this.mStartTimestamp = System.currentTimeMillis();
      boolean bool = localMiniAppSubProcessorInfo.containsAppConfig(paramMiniAppInfo);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doStartMiniApp appId=");
      ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
      ((StringBuilder)localObject).append(" appName=");
      ((StringBuilder)localObject).append(paramMiniAppInfo.name);
      ((StringBuilder)localObject).append(" isInternal:");
      ((StringBuilder)localObject).append(paramMiniAppInfo.isInternalApp());
      ((StringBuilder)localObject).append(" engineType=");
      ((StringBuilder)localObject).append(paramMiniAppInfo.getEngineType());
      ((StringBuilder)localObject).append(" reportType=");
      ((StringBuilder)localObject).append(-1);
      ((StringBuilder)localObject).append(" targetProcess=");
      ((StringBuilder)localObject).append(localMiniAppSubProcessorInfo.processName);
      ((StringBuilder)localObject).append(" alreadyStarted=");
      ((StringBuilder)localObject).append(bool);
      QMLog.i("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
      Context localContext = this.mContext;
      if ((paramMiniAppInfo.isInternalApp()) && (localMiniAppSubProcessorInfo.internalUIClass != null)) {
        localObject = localMiniAppSubProcessorInfo.internalUIClass;
      } else {
        localObject = localMiniAppSubProcessorInfo.uiClass;
      }
      localObject = new Intent(localContext, (Class)localObject);
      setIntentFlags((Intent)localObject, paramMiniAppInfo);
      return new LaunchStrategy.LaunchData((Intent)localObject, getProcessState(localMiniAppSubProcessorInfo));
    }
    throw new IllegalStateException("obtain idle processor config failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy
 * JD-Core Version:    0.7.0.1
 */