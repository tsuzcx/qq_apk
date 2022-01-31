package com.tencent.qqmini.sdk.launcher;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.LruCache;
import bglq;
import bgpt;
import bgpw;
import bgxl;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager.MiniProcessorConfig;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandLaunchManager
  implements ILaunchManager
{
  private static final int KILL_MODE_PID = 0;
  private static final int KILL__MODE_BROADCAST = 1;
  public static final int MINI_APP_CRASH_PROTECT_TIME_DEFAULT = 3600000;
  private static final int MINI_APP_PROCESS_DETECT_TIME_DEFAULT = 600000;
  private static final int MINI_GAME_PROCESS_REUSE_DEFAULT = 1;
  private static final int PROCESS_APP_RECYCLE_TIME = 1800000;
  private static final int PROCESS_GAME_MAX_COUNT_DEFAULT = 3;
  private static final int PROCESS_GAME_RECYCLE_TIME = 900000;
  private static final int PROCESS_MAX_COUNT_DEFAULT = 6;
  private static final int PROCESS_PRELOAD_COUNT_DEFAULT = 2;
  private static final String TAG = "minisdk-start_AppBrandLaunchManager";
  private static List<String> gameProcessReuseBlacklist;
  private static bgpw sInternalProcessInfo;
  public static LinkedHashMap<String, bgpw> subAppProcessorInfoMap = new LinkedHashMap();
  public static LinkedHashMap<String, bgpw> subGameProcessorInfoMap = new LinkedHashMap();
  public static LinkedHashMap<String, bgpw> subProcessorInfoMap = new LinkedHashMap();
  public long appProcessRecycleTime = 1800000L;
  public long gameProcessRecycleTime = 900000L;
  private bgpw lastKillingProcessor;
  private final Map<String, Messenger> mClientMessengerMap = new HashMap();
  private Context mContext;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private int mKillProcessMode = 0;
  private long mLastPreloadDetectTime;
  private boolean mMiniAppUsed;
  private ConcurrentHashMap<String, String> mPreloadingTask = new ConcurrentHashMap();
  private int mProcessGameMaxCount;
  private int mProcessMaxCount;
  private int mProcessPreloadCount;
  private LruCache<String, bgpw> mProcessStack;
  private int mStartTimeInterval = 1500;
  private long mStartTimestamp;
  private MiniAppBaseInfo mStartingMiniAppConfig;
  private HashMap<String, Long> startAppIdMap = new HashMap();
  
  private boolean canPreloadApp(bgpw parambgpw)
  {
    return true;
  }
  
  private boolean canPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
    }
    int j;
    label52:
    int i;
    if ("preload_game".equals(paramString))
    {
      j = this.mProcessGameMaxCount;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      i = 0;
      label68:
      if (!((Iterator)localObject1).hasNext()) {
        break label139;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 == null) {
        break label146;
      }
      localObject2 = (bgpw)((Map.Entry)localObject2).getValue();
      if ((localObject2 == null) || (!paramString.equals(((bgpw)localObject2).jdField_b_of_type_JavaLangString))) {
        break label146;
      }
      i += 1;
    }
    label139:
    label146:
    for (;;)
    {
      break label68;
      j = this.mProcessMaxCount;
      break label52;
      if (i >= j) {
        break;
      }
      return true;
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
          break label370;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 == null) {
          break label369;
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
          localObject4 = (bgpw)((Map.Entry)localObject4).getValue();
          if (localObject4 == null) {
            continue;
          }
          Iterator localIterator2 = ((List)localObject1).iterator();
          if (localIterator2.hasNext())
          {
            if (((ActivityManager.RunningAppProcessInfo)localIterator2.next()).pid != ((bgpw)localObject4).jdField_a_of_type_Int) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            QMLog.i("minisdk-start_AppBrandLaunchManager", "Process has been died, clean the record! processName=" + (String)localObject3 + " pid=" + ((bgpw)localObject4).jdField_a_of_type_Int);
            localObject3 = (bgpw)this.mProcessStack.remove(localObject3);
            if (localObject3 == null) {
              continue;
            }
            ((bgpw)localObject3).c();
          }
        }
        else
        {
          localIterator1 = this.mPreloadingTask.entrySet().iterator();
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_AppBrandLaunchManager", "", localThrowable);
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
                break label362;
              }
              QMLog.i("minisdk-start_AppBrandLaunchManager", "Process has been died, clean the preloading record! processName=" + (String)localObject3);
              localIterator1.remove();
              break;
            }
            label362:
            continue;
            i = 0;
            break;
          }
        }
      }
      label369:
      return;
      label370:
      Object localObject2 = null;
    }
  }
  
  private void checkPreload()
  {
    QMLog.i("minisdk-start_AppBrandLaunchManager", "checkPreload MiniAppUsed:" + this.mMiniAppUsed);
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
      QMLog.e("minisdk-start_AppBrandLaunchManager", "", localThrowable);
    }
  }
  
  private void cleanProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      bgpw localbgpw = (bgpw)this.mProcessStack.remove(paramString);
      if (localbgpw != null) {
        localbgpw.c();
      }
    } while ((this.lastKillingProcessor == null) || (!paramString.equals(this.lastKillingProcessor.jdField_a_of_type_JavaLangString)));
    paramString = this.lastKillingProcessor;
    getHandler().postDelayed(new AppBrandLaunchManager.2(this, paramString), 2000L);
    this.lastKillingProcessor = null;
  }
  
  private void doPreloadApp(bgpw parambgpw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambgpw == null) || ((!paramBoolean2) && (!canPreloadApp(parambgpw)))) {
      return;
    }
    for (;;)
    {
      try
      {
        QMLog.i("minisdk-start_AppBrandLaunchManager", "do preload mini process name=" + parambgpw.jdField_a_of_type_JavaLangString + " Preload=" + parambgpw.jdField_b_of_type_JavaLangClass.getSimpleName() + " isMiniApp:" + paramBoolean1);
        Intent localIntent = new Intent();
        localIntent.setClass(this.mContext, parambgpw.jdField_b_of_type_JavaLangClass);
        if (paramBoolean1)
        {
          localObject = "mini_preload_app";
          localIntent.setAction((String)localObject);
          localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
          localIntent.putExtra("KEY_LOGININFO", new LoginInfo(((MiniAppProxy)localObject).getLoginType(), ((MiniAppProxy)localObject).getAccount(), ((MiniAppProxy)localObject).getNickName(), ((MiniAppProxy)localObject).getPayOpenId(), ((MiniAppProxy)localObject).getPayOpenKey(), ((MiniAppProxy)localObject).getLoginSig(), ((MiniAppProxy)localObject).getPlatformId(), ((MiniAppProxy)localObject).getAppId()));
          if ((paramBoolean3) && (TissueGlobal.tissueEnv != null)) {
            localIntent.putExtra("tissuenativelibdir", TissueGlobal.tissueEnv.getNativeLibDir());
          }
          localObject = this.mPreloadingTask;
          String str = parambgpw.jdField_a_of_type_JavaLangString;
          if (!paramBoolean1) {
            break label264;
          }
          parambgpw = "preload_app";
          ((ConcurrentHashMap)localObject).put(str, parambgpw);
          this.mContext.sendBroadcast(localIntent);
          return;
        }
      }
      catch (Throwable parambgpw)
      {
        QMLog.e("minisdk-start_AppBrandLaunchManager", "send preload Broadcast exception!", parambgpw);
        return;
      }
      Object localObject = "mini_preload_game";
      continue;
      label264:
      parambgpw = "preload_game";
    }
  }
  
  private void doPreloadApp(Map<String, bgpw> paramMap, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = subAppProcessorInfoMap;; localObject = subGameProcessorInfoMap)
    {
      localObject = ((LinkedHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (!paramMap.containsKey((String)localEntry.getKey())) {
          doPreloadApp((bgpw)localEntry.getValue(), paramBoolean, true, true);
        }
      }
      return;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private void doStartMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    bgpw localbgpw = obtainIdleProcessor(paramMiniAppInfo);
    if ((localbgpw == null) || (paramMiniAppInfo == null))
    {
      QMLog.e("minisdk-start_AppBrandLaunchManager", "obtain idle processor config failed!");
      return;
    }
    if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppInfo)) && (System.currentTimeMillis() - this.mStartTimestamp <= this.mStartTimeInterval))
    {
      QMLog.w("minisdk-start_AppBrandLaunchManager", "startMiniApp duplicate. The miniapp is starting! interval=" + this.mStartTimeInterval + " appId=" + paramMiniAppInfo.appId);
      return;
    }
    bgxl.a("2click", null, paramMiniAppInfo.launchParam.entryPath, paramMiniAppInfo);
    if (paramMiniAppInfo != null) {
      this.startAppIdMap.put(paramMiniAppInfo.appId, Long.valueOf(System.currentTimeMillis()));
    }
    this.mStartingMiniAppConfig = paramMiniAppInfo;
    this.mStartTimestamp = System.currentTimeMillis();
    QMLog.i("minisdk-start_AppBrandLaunchManager", "doStartMiniApp appId=" + paramMiniAppInfo.appId + " appName=" + paramMiniAppInfo.name + " engineType=" + paramMiniAppInfo.getEngineType() + " reportType=" + -1 + " targetProcess=" + localbgpw.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent(this.mContext, localbgpw.jdField_a_of_type_JavaLangClass);
    localIntent.addFlags(805371904);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    localIntent.putExtra("KEY_LOGININFO", new LoginInfo(localMiniAppProxy.getLoginType(), localMiniAppProxy.getAccount(), localMiniAppProxy.getNickName(), localMiniAppProxy.getPayOpenId(), localMiniAppProxy.getPayOpenKey(), localMiniAppProxy.getLoginSig(), localMiniAppProxy.getPlatformId(), localMiniAppProxy.getAppId()));
    localIntent.putExtra("KEY_APPINFO", paramMiniAppInfo);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("receiver", paramResultReceiver);
    localIntent.putExtra("processName", localbgpw.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("startDuration", System.currentTimeMillis());
    int j = 3;
    int i;
    if ((localbgpw.jdField_a_of_type_Int > 0) && (localbgpw.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null)) {
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("start_mode", i);
      if (paramActivity == null) {
        break;
      }
      paramActivity.startActivity(localIntent);
      return;
      i = j;
      if (localbgpw.jdField_a_of_type_Int > 0)
      {
        i = j;
        if (localbgpw.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null) {
          i = 2;
        }
      }
    }
    if (paramResultReceiver != null)
    {
      paramActivity = localIntent.getExtras();
      paramActivity.putParcelable("Activity", localIntent.getComponent());
      paramResultReceiver.send(1, paramActivity);
      return;
    }
    this.mContext.startActivity(localIntent);
  }
  
  private boolean enableGameProcessReuse()
  {
    boolean bool = true;
    int i;
    if (bglq.a("qqminiapp", "mini_game_process_reuse", 1) > 0)
    {
      i = 1;
      if (i != 0) {
        break label28;
      }
    }
    label28:
    String str;
    do
    {
      return false;
      i = 0;
      break;
      str = Build.MODEL;
    } while (TextUtils.isEmpty(str));
    if (gameProcessReuseBlacklist == null)
    {
      gameProcessReuseBlacklist = new ArrayList();
      Object localObject = bglq.a("qqminiapp", "mini_game_process_reuse_blacklist", "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = ((String)localObject).split(",");
          if (localObject != null)
          {
            int j = localObject.length;
            i = 0;
            while (i < j)
            {
              CharSequence localCharSequence = localObject[i];
              if (!TextUtils.isEmpty(localCharSequence)) {
                gameProcessReuseBlacklist.add(localCharSequence);
              }
              i += 1;
            }
          }
          if (gameProcessReuseBlacklist.contains(str)) {}
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("minisdk-start_AppBrandLaunchManager", "init gameProcessReuseBlacklist error,", localThrowable);
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private bgpw findLastMiniGameProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    int i = 0;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      if (localObject2 != null)
      {
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (bgpw)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) || (!((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame())) {
          break label136;
        }
        i += 1;
        if ((((bgpw)localObject2).a(paramMiniAppBaseInfo)) || (localObject1 != null)) {
          break label133;
        }
        localObject1 = localObject2;
      }
    }
    label133:
    label136:
    for (;;)
    {
      break;
      if (i >= this.mProcessGameMaxCount) {
        return localObject1;
      }
      return null;
    }
  }
  
  private bgpw findMiniAppProcessInfo(MiniAppInfo paramMiniAppInfo)
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
      localObject = (bgpw)((Map.Entry)localObject).getValue();
    } while ((localObject == null) || (!((bgpw)localObject).a(paramMiniAppInfo)));
    for (paramMiniAppInfo = (MiniAppInfo)localObject;; paramMiniAppInfo = null) {
      return paramMiniAppInfo;
    }
  }
  
  private boolean finishAndRemoveTask(bgpw parambgpw)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)this.mContext.getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getAppTasks();
      if (localObject == null) {
        return false;
      }
      if (parambgpw == null)
      {
        QMLog.e("miniapp", "当前进程信息为空");
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          String str = localAppTask.getTaskInfo().baseIntent.getComponent().getClassName();
          QMLog.i("minisdk-start_AppBrandLaunchManager", "finishAndRemoveTask try finish and remove task: id=" + localAppTask.getTaskInfo().id + ", componentName:" + str);
          if ((!TextUtils.isEmpty(str)) && (parambgpw.jdField_a_of_type_JavaLangClass != null) && (str.equals(parambgpw.jdField_a_of_type_JavaLangClass.getName())))
          {
            QMLog.i("minisdk-start_AppBrandLaunchManager", "finishAndRemoveTask finish and remove task: id=" + localAppTask.getTaskInfo().id);
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable parambgpw)
    {
      QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
    }
    return false;
  }
  
  public static String getprocessName(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == Process.myPid())
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QMLog.e("minisdk-start_AppBrandLaunchManager", "", paramContext);
    }
    return "";
  }
  
  private boolean hasPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (bgpw)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) && (paramString.equals(((bgpw)localObject2).jdField_b_of_type_JavaLangString))) {
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
  
  private boolean needPreloadMiniApp(String paramString)
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (bgpw)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((bgpw)localObject).a()) && (paramString != null) && (paramString.equals(((bgpw)localObject).jdField_b_of_type_JavaLangString)))
        {
          QMLog.d("minisdk-start_AppBrandLaunchManager", "No need to preload mini process. " + paramString + ". Already has idle process " + localObject);
          return false;
        }
      }
    }
    if (hasPreloadingTask(paramString))
    {
      QMLog.d("minisdk-start_AppBrandLaunchManager", "No need to preload mini process " + paramString + ". Already has preloading task " + this.mPreloadingTask);
      return false;
    }
    return true;
  }
  
  private bgpw obtainIdleMiniAppProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject3;
    if (paramMiniAppBaseInfo != null)
    {
      localObject2 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        if (localObject4 != null)
        {
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (bgpw)((Map.Entry)localObject4).getValue();
          if ((localObject4 != null) && (((bgpw)localObject4).a(paramMiniAppBaseInfo)))
          {
            QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain loaded processor from stack:" + (String)localObject3);
            return localObject4;
          }
        }
      }
    }
    paramMiniAppBaseInfo = ((Map)localObject1).entrySet().iterator();
    while (paramMiniAppBaseInfo.hasNext())
    {
      localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
      if (localObject3 != null)
      {
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (bgpw)((Map.Entry)localObject3).getValue();
        if ((localObject3 != null) && (((bgpw)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) && ("preload_app".equals(((bgpw)localObject3).jdField_b_of_type_JavaLangString)))
        {
          QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    if (this.mProcessStack.size() < this.mProcessMaxCount)
    {
      paramMiniAppBaseInfo = subAppProcessorInfoMap.entrySet().iterator();
      while (paramMiniAppBaseInfo.hasNext())
      {
        localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (bgpw)((Map.Entry)localObject3).getValue();
        if ((!((Map)localObject1).containsKey(localObject2)) && (localObject3 != null))
        {
          QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    paramMiniAppBaseInfo = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      paramMiniAppBaseInfo.remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject2 = paramMiniAppBaseInfo.entrySet().iterator();
    paramMiniAppBaseInfo = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
      if (localObject1 != null)
      {
        localObject3 = (bgpw)((Map.Entry)localObject1).getValue();
        paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
        if (localObject3 != null)
        {
          paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
          if (((bgpw)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null)
          {
            paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
            if (!((bgpw)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame()) {
              paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramMiniAppBaseInfo != null)
      {
        localObject1 = (String)paramMiniAppBaseInfo.getKey();
        paramMiniAppBaseInfo = (bgpw)paramMiniAppBaseInfo.getValue();
        if (paramMiniAppBaseInfo != null)
        {
          QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack bottom:" + (String)localObject1);
          return paramMiniAppBaseInfo;
        }
      }
      return null;
    }
  }
  
  private bgpw obtainIdleMiniGameProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject3;
    Object localObject2;
    if (paramMiniAppBaseInfo != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (bgpw)((Map.Entry)localObject3).getValue();
          if ((localObject3 != null) && (((bgpw)localObject3).a(paramMiniAppBaseInfo)))
          {
            QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain loaded processor from stack:" + (String)localObject2);
            return localObject3;
          }
        }
      }
    }
    int j = this.mProcessGameMaxCount;
    localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (bgpw)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) || (!((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame())) {
          break label919;
        }
        i += 1;
      }
    }
    label916:
    label919:
    for (;;)
    {
      break;
      if (i < j)
      {
        localObject1 = this.mProcessStack.snapshot();
        if (sInternalProcessInfo != null) {
          ((Map)localObject1).remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
        }
        localObject2 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
          if (localObject4 != null)
          {
            localObject3 = (String)((Map.Entry)localObject4).getKey();
            localObject4 = (bgpw)((Map.Entry)localObject4).getValue();
            if ((localObject4 != null) && (((bgpw)localObject4).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) && ("preload_game".equals(((bgpw)localObject4).jdField_b_of_type_JavaLangString)))
            {
              QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack:" + (String)localObject3);
              if (paramMiniAppBaseInfo != null)
              {
                QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from preload, baselibMiniVersion required: " + paramMiniAppBaseInfo.baselibMiniVersion + ", current preload:" + ((bgpw)localObject4).c);
                if ((TextUtils.isEmpty(paramMiniAppBaseInfo.baselibMiniVersion)) || (TextUtils.isEmpty(((bgpw)localObject4).c)))
                {
                  QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from preload, required baselibMiniVersion is empty: " + (String)localObject3);
                  return localObject4;
                }
                if ((!TextUtils.isEmpty(paramMiniAppBaseInfo.baselibMiniVersion)) && (!TextUtils.isEmpty(((bgpw)localObject4).c)) && (EngineVersion.a(paramMiniAppBaseInfo.baselibMiniVersion, ((bgpw)localObject4).c) <= 0))
                {
                  QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from preload, required baselibMiniVersion matched: " + (String)localObject3);
                  return localObject4;
                }
                QMLog.e("minisdk-start_AppBrandLaunchManager", "obtain idle processor from preload, baselibMiniVersion does not match, required: " + paramMiniAppBaseInfo.baselibMiniVersion + ", current preload:" + ((bgpw)localObject4).c);
              }
            }
          }
        }
        if (((Map)localObject1).size() < this.mProcessMaxCount)
        {
          paramMiniAppBaseInfo = subGameProcessorInfoMap.entrySet().iterator();
          do
          {
            if (!paramMiniAppBaseInfo.hasNext()) {
              break;
            }
            localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
            localObject2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (bgpw)((Map.Entry)localObject3).getValue();
          } while ((((Map)localObject1).containsKey(localObject2)) || (localObject3 == null));
          QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
      else
      {
        paramMiniAppBaseInfo = this.mProcessStack.snapshot();
        if (sInternalProcessInfo != null) {
          paramMiniAppBaseInfo.remove(sInternalProcessInfo.jdField_a_of_type_JavaLangString);
        }
        localObject2 = paramMiniAppBaseInfo.entrySet().iterator();
        paramMiniAppBaseInfo = null;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Map.Entry)((Iterator)localObject2).next();
          if (localObject1 != null)
          {
            localObject3 = (bgpw)((Map.Entry)localObject1).getValue();
            if ((localObject3 == null) || (paramMiniAppBaseInfo != null) || (((bgpw)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) || (!((bgpw)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame())) {
              break label916;
            }
            paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
          }
        }
      }
      for (;;)
      {
        break;
        if (paramMiniAppBaseInfo != null)
        {
          localObject1 = (String)paramMiniAppBaseInfo.getKey();
          paramMiniAppBaseInfo = (bgpw)paramMiniAppBaseInfo.getValue();
          if (paramMiniAppBaseInfo != null)
          {
            QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack bottom:" + (String)localObject1);
            return paramMiniAppBaseInfo;
          }
        }
        QMLog.e("minisdk-start_AppBrandLaunchManager", "has no idle processor!!!");
        return null;
      }
    }
  }
  
  private bgpw obtainIdleProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
    }
    if ((paramMiniAppBaseInfo.isInternalApp()) && (sInternalProcessInfo != null)) {
      return sInternalProcessInfo;
    }
    if (paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return obtainIdleMiniGameProcessor(paramMiniAppBaseInfo);
    }
    return obtainIdleMiniAppProcessor(paramMiniAppBaseInfo);
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
      if (localEntry != null) {
        localStringBuilder.append("{").append(localEntry.getKey()).append(" ").append(localEntry.getValue()).append("}*******");
      }
    }
    QMLog.w("minisdk-start_AppBrandLaunchManager", "current process count=" + i + " " + localStringBuilder.toString());
  }
  
  public void forceKillProcess(bgpw parambgpw)
  {
    if (parambgpw == null) {
      return;
    }
    this.lastKillingProcessor = parambgpw;
    QMLog.i("minisdk-start_AppBrandLaunchManager", "kill mini process: " + this.lastKillingProcessor);
    int i = parambgpw.jdField_a_of_type_Int;
    if (i > 0) {
      try
      {
        if (this.mKillProcessMode == 0)
        {
          QMLog.w("minisdk-start_AppBrandLaunchManager", "kill process by pid:" + i);
          finishAndRemoveTask(parambgpw);
          Process.killProcess(i);
          cleanProcess(parambgpw.jdField_a_of_type_JavaLangString);
          printProcessStack();
          return;
        }
      }
      catch (Throwable parambgpw)
      {
        QMLog.e("minisdk-start_AppBrandLaunchManager", "kill process exception!", parambgpw);
        return;
      }
    }
    QMLog.w("minisdk-start_AppBrandLaunchManager", "kill process by broadcast" + parambgpw.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, parambgpw.jdField_b_of_type_JavaLangClass);
    this.mContext.sendBroadcast(localIntent);
  }
  
  public bgpw getCacheApp(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    if (paramMiniAppBaseInfo != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (bgpw)((Map.Entry)localObject2).getValue();
          if ((localObject2 != null) && (((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null) && (((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId.equals(paramMiniAppBaseInfo.appId)))
          {
            QMLog.i("minisdk-start_AppBrandLaunchManager", "obtain loaded processor from stack:" + str);
            return localObject2;
          }
        }
      }
    }
    return null;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public void init(Context paramContext)
  {
    if (this.mContext != null) {
      return;
    }
    this.mContext = paramContext;
    this.mProcessPreloadCount = 2;
    this.mProcessGameMaxCount = subGameProcessorInfoMap.size();
    this.appProcessRecycleTime = 1800000L;
    this.gameProcessRecycleTime = 900000L;
    try
    {
      this.mStartTimeInterval = 1500;
      this.mKillProcessMode = 0;
      this.mProcessMaxCount = (subAppProcessorInfoMap.size() + subGameProcessorInfoMap.size());
      this.mProcessStack = new LruCache(this.mProcessMaxCount);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QMLog.e("minisdk-start_AppBrandLaunchManager", "get config StartTimeInterval exception!", paramContext);
      }
    }
  }
  
  public boolean isMiniProcess(String paramString)
  {
    return subProcessorInfoMap.containsKey(paramString);
  }
  
  public void onAppBackground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    Object localObject2 = null;
    if (paramMiniAppBaseInfo != null)
    {
      paramBundle = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label112;
      }
      localObject1 = paramMiniAppBaseInfo.name;
      label22:
      if (paramMiniAppBaseInfo == null) {
        break label118;
      }
    }
    label112:
    label118:
    for (int i = paramMiniAppBaseInfo.getEngineType();; i = -1)
    {
      QMLog.i("minisdk-start_AppBrandLaunchManager", "onAppBackground process=" + paramString + " appId=" + paramBundle + " appName=" + (String)localObject1 + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label124;
      }
      return;
      paramBundle = null;
      break;
      localObject1 = null;
      break label22;
    }
    label124:
    bgpw localbgpw = (bgpw)this.mProcessStack.get(paramString);
    if (localbgpw != null)
    {
      paramString = localObject2;
      if (localbgpw.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null) {
        paramString = localbgpw.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId;
      }
      if (paramString != null)
      {
        localObject1 = localbgpw;
        if (paramString.equals(paramBundle)) {}
      }
      else
      {
        localbgpw.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
        localObject1 = localbgpw;
      }
      ((bgpw)localObject1).a();
      printProcessStack();
      return;
    }
    Object localObject1 = (bgpw)subProcessorInfoMap.get(paramString);
    if (localObject1 != null)
    {
      paramBundle = ((bgpw)localObject1).jdField_a_of_type_JavaLangClass;
      label221:
      if (localObject1 == null) {
        break label272;
      }
    }
    label272:
    for (localObject1 = ((bgpw)localObject1).jdField_b_of_type_JavaLangClass;; localObject1 = null)
    {
      localObject1 = new bgpw(this, paramString, paramBundle, (Class)localObject1);
      ((bgpw)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
      this.mProcessStack.put(paramString, localObject1);
      break;
      paramBundle = null;
      break label221;
    }
  }
  
  public void onAppForeground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject;
    String str;
    label23:
    int i;
    label33:
    int j;
    if (paramMiniAppBaseInfo != null)
    {
      localObject = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label128;
      }
      str = paramMiniAppBaseInfo.name;
      if (paramMiniAppBaseInfo == null) {
        break label134;
      }
      i = paramMiniAppBaseInfo.getEngineType();
      if (paramBundle == null) {
        break label140;
      }
      j = paramBundle.getInt("PID");
      label46:
      QMLog.i("minisdk-start_AppBrandLaunchManager", "onAppForeground process=" + paramString + " appId=" + (String)localObject + " appName=" + str + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label146;
      }
    }
    label128:
    label134:
    label140:
    label146:
    label294:
    label344:
    do
    {
      do
      {
        return;
        localObject = null;
        break;
        str = null;
        break label23;
        i = -1;
        break label33;
        j = 0;
        break label46;
        paramBundle = (bgpw)this.mProcessStack.get(paramString);
        if (paramBundle == null) {
          break label271;
        }
        paramBundle.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
        paramString = paramBundle;
        if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppBaseInfo))) {
          this.mStartingMiniAppConfig = null;
        }
        if (j > 0) {
          paramString.jdField_a_of_type_Int = j;
        }
        paramString.b();
        printProcessStack();
      } while (paramMiniAppBaseInfo == null);
      if (paramMiniAppBaseInfo.isEngineTypeMiniGame())
      {
        paramString = findLastMiniGameProcessor(paramMiniAppBaseInfo);
        if (paramString != null)
        {
          if (enableGameProcessReuse())
          {
            QMLog.w("minisdk-start_AppBrandLaunchManager", "onAppForeground enableGameProcessReuse, try finishAndRemoveTask lastMiniGameProcessor =" + paramString);
            finishAndRemoveTask(paramString);
            return;
            localObject = (bgpw)subProcessorInfoMap.get(paramString);
            if (localObject != null)
            {
              paramBundle = ((bgpw)localObject).jdField_a_of_type_JavaLangClass;
              if (localObject == null) {
                break label344;
              }
            }
            for (localObject = ((bgpw)localObject).jdField_b_of_type_JavaLangClass;; localObject = null)
            {
              paramBundle = new bgpw(this, paramString, paramBundle, (Class)localObject);
              paramBundle.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
              this.mProcessStack.put(paramString, paramBundle);
              paramString = paramBundle;
              break;
              paramBundle = null;
              break label294;
            }
          }
          QMLog.w("minisdk-start_AppBrandLaunchManager", "onAppForeground disableGameProcessReuse, try kill lastMiniGameProcessor = " + paramString);
          forceKillProcess(paramString);
          return;
        }
        if (!paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
          bool = true;
        }
        preloadExtraMiniApp(bool);
        return;
      }
    } while (paramMiniAppBaseInfo == null);
    label271:
    getHandler().postDelayed(new AppBrandLaunchManager.4(this, paramMiniAppBaseInfo), 500L);
  }
  
  public void onAppStart(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    Object localObject3 = null;
    label23:
    int i;
    if (paramMiniAppBaseInfo != null)
    {
      localObject1 = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label128;
      }
      localObject2 = paramMiniAppBaseInfo.name;
      if (paramMiniAppBaseInfo == null) {
        break label134;
      }
      i = paramMiniAppBaseInfo.getEngineType();
      label33:
      if (paramBundle == null) {
        break label140;
      }
    }
    label128:
    label134:
    label140:
    for (int j = paramBundle.getInt("PID");; j = 0)
    {
      QMLog.i("minisdk-start_AppBrandLaunchManager", "onAppStart process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label146;
      }
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label23;
      i = -1;
      break label33;
    }
    label146:
    Object localObject2 = (bgpw)this.mProcessStack.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (bgpw)subProcessorInfoMap.get(paramString);
      if (localObject2 == null) {
        break label333;
      }
      localObject1 = ((bgpw)localObject2).jdField_a_of_type_JavaLangClass;
      if (localObject2 == null) {
        break label339;
      }
    }
    label333:
    label339:
    for (localObject2 = ((bgpw)localObject2).jdField_b_of_type_JavaLangClass;; localObject2 = null)
    {
      localObject2 = new bgpw(this, paramString, (Class)localObject1, (Class)localObject2);
      ((bgpw)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
      localObject1 = localObject3;
      if (paramBundle != null) {
        localObject1 = paramBundle.getString("mini_key_preload_type", null);
      }
      ((bgpw)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
      this.mProcessStack.put(paramString, localObject2);
      localObject1 = localObject2;
      if (paramMiniAppBaseInfo != null) {
        ((bgpw)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
      }
      ((bgpw)localObject1).jdField_a_of_type_Int = j;
      this.mPreloadingTask.remove(paramString);
      printProcessStack();
      paramString = getprocessName(this.mContext);
      QMLog.i("minisdk-start_AppBrandLaunchManager", "updateBaseLib onAppStart " + paramString);
      updateBaseLib();
      return;
      localObject1 = null;
      break;
    }
  }
  
  public void onAppStop(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    String str1;
    String str2;
    if (paramMiniAppBaseInfo != null)
    {
      str1 = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label126;
      }
      str2 = paramMiniAppBaseInfo.name;
      label20:
      if (paramMiniAppBaseInfo == null) {
        break label132;
      }
    }
    label132:
    for (int i = paramMiniAppBaseInfo.getEngineType();; i = -1)
    {
      if (paramBundle != null) {
        paramBundle.getInt("PID");
      }
      QMLog.i("minisdk-start_AppBrandLaunchManager", "onAppStop process=" + paramString + " appId=" + str1 + " appName=" + str2 + " engineType=" + i + " reportType=" + -1);
      cleanProcess(paramString);
      printProcessStack();
      return;
      str1 = null;
      break;
      label126:
      str2 = null;
      break label20;
    }
  }
  
  public void onHostAppBackground() {}
  
  public void onPreloadBaseLib(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      getHandler().post(new AppBrandLaunchManager.5(this, paramString1, paramString2));
    }
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo) {}
  
  public void preloadExtraMiniApp(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        int i = this.mProcessStack.size();
        int j = this.mProcessMaxCount;
        Object localObject1;
        Map localMap;
        if (i >= j) {}else
        {
          if (!paramBoolean) {
            break label151;
          }
          localObject1 = "preload_app";
          if ((hasPreloadProcess((String)localObject1)) || (!canPreloadProcess((String)localObject1))) {
            continue;
          }
          localMap = this.mProcessStack.snapshot();
          if (!paramBoolean) {
            break label158;
          }
          localObject1 = subAppProcessorInfoMap;
          localObject1 = ((Map)localObject1).entrySet().iterator();
        }
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (localMap.containsKey((String)localEntry.getKey())) {
          continue;
        }
        doPreloadApp((bgpw)localEntry.getValue(), paramBoolean, false, false);
        continue;
        localObject3 = "preload_game";
      }
      finally {}
      label151:
      continue;
      label158:
      Object localObject3 = subGameProcessorInfoMap;
    }
  }
  
  public void preloadMiniApp(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      int m;
      int i;
      int j;
      int k;
      try
      {
        paramBundle = paramBundle.getString("mini_key_preload_type");
        bool = needPreloadMiniApp(paramBundle);
        if (!bool)
        {
          return;
          paramBundle = null;
          continue;
        }
        m = this.mProcessPreloadCount - this.mProcessStack.size();
        if (m <= 0) {
          continue;
        }
        Object localObject = getprocessName(this.mContext);
        QMLog.i("minisdk-start_AppBrandLaunchManager", "updateBaseLib preloadMiniApp " + (String)localObject + ", process count=" + m);
        printProcessStack();
        updateBaseLib();
        ThreadManager.b().post(new AppBrandLaunchManager.1(this));
        localObject = this.mProcessStack.snapshot();
        if (paramBundle == null)
        {
          i = 1;
          if ("preload_app".equals(paramBundle))
          {
            j = 1;
            if (!"preload_game".equals(paramBundle)) {
              continue;
            }
            k = 1;
            break label208;
            doPreloadApp((Map)localObject, bool);
            m -= 1;
            break label211;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        j = 0;
        continue;
        k = 0;
      }
      finally {}
      boolean bool = false;
      break label226;
      label208:
      int n = 0;
      label211:
      if (m > 0) {
        if (n % 2 == 0)
        {
          bool = true;
          label226:
          n += 1;
          if (((!bool) || (j == 0)) && ((bool) || (k == 0))) {
            if (i == 0) {}
          }
        }
      }
    }
  }
  
  public void registerClientMessenger(String paramString, Messenger paramMessenger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMessenger == null)) {
      return;
    }
    QMLog.w("minisdk-start_AppBrandLaunchManager", "registerClientMessenger pName=" + paramString + " messenger:" + paramMessenger);
    this.mClientMessengerMap.put(paramString, paramMessenger);
  }
  
  public void registerProcessInfo(List<ILaunchManager.MiniProcessorConfig> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ILaunchManager.MiniProcessorConfig localMiniProcessorConfig = (ILaunchManager.MiniProcessorConfig)paramList.next();
        if ((localMiniProcessorConfig != null) && (!TextUtils.isEmpty(localMiniProcessorConfig.processName)))
        {
          bgpw localbgpw = new bgpw(this, localMiniProcessorConfig.processName, localMiniProcessorConfig.processType, localMiniProcessorConfig.appUIClass, localMiniProcessorConfig.appPreLoadClass);
          QMLog.i("minisdk-start_AppBrandLaunchManager", "registerProcessInfo " + localbgpw);
          switch (bgpv.a[localMiniProcessorConfig.processType.ordinal()])
          {
          default: 
            break;
          case 1: 
            if (localMiniProcessorConfig.appUIClass != null)
            {
              subAppProcessorInfoMap.put(localMiniProcessorConfig.processName, localbgpw);
              subProcessorInfoMap.put(localMiniProcessorConfig.processName, localbgpw);
            }
            break;
          case 2: 
            if (localMiniProcessorConfig.appUIClass != null)
            {
              subGameProcessorInfoMap.put(localMiniProcessorConfig.processName, localbgpw);
              subProcessorInfoMap.put(localMiniProcessorConfig.processName, localbgpw);
            }
            break;
          case 3: 
            if (localMiniProcessorConfig.appUIClass != null)
            {
              sInternalProcessInfo = localbgpw;
              subProcessorInfoMap.put(localMiniProcessorConfig.processName, localbgpw);
            }
            break;
          }
        }
      }
    }
  }
  
  public boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_AppBrandLaunchManager", "sendCmdToMiniProcess failed! miniAppInfo is null.");
      return false;
    }
    Object localObject = findMiniAppProcessInfo(paramMiniAppInfo);
    if ((localObject == null) || (TextUtils.isEmpty(((bgpw)localObject).jdField_a_of_type_JavaLangString)))
    {
      QMLog.e("minisdk-start_AppBrandLaunchManager", "sendCmdToMiniProcess failed! Has no processor info.");
      return false;
    }
    Messenger localMessenger = (Messenger)this.mClientMessengerMap.get(((bgpw)localObject).jdField_a_of_type_JavaLangString);
    if (localMessenger == null)
    {
      QMLog.e("minisdk-start_AppBrandLaunchManager", "sendCmdToMiniProcess failed! Messenger is null.");
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putParcelable("KEY_APPINFO", paramMiniAppInfo);
    ((Bundle)localObject).putParcelable("receiver", paramResultReceiver);
    localMessage.setData((Bundle)localObject);
    try
    {
      QMLog.i("minisdk-start_AppBrandLaunchManager", "Messenger sendCmdToMiniProcess cmd=" + paramInt);
      localMessenger.send(localMessage);
      return true;
    }
    catch (Throwable paramBundle)
    {
      QMLog.e("minisdk-start_AppBrandLaunchManager", "Messenger sendCmdToMiniProcess exception!", paramBundle);
      if (paramResultReceiver != null) {
        paramResultReceiver.send(-1, new Bundle());
      }
    }
    return false;
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null) {
      QMLog.e("minisdk-start_AppBrandLaunchManager", "startMiniApp params is empty! ,appConfig=" + paramMiniAppInfo + " Activity=" + paramActivity);
    }
    do
    {
      return;
      this.mMiniAppUsed = true;
      QMLog.i("minisdk-start_AppBrandLaunchManager", "---startApp---- appid:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
      checkAndCleanAllMiniProcess();
      doStartMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
    } while ((paramMiniAppInfo.isFakeAppInfo()) || (paramMiniAppInfo.isShortcutFakeApp()));
    paramResultReceiver = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (paramMiniAppInfo.launchParam != null)
    {
      paramActivity = String.valueOf(paramMiniAppInfo.launchParam.scene);
      if (paramMiniAppInfo.via == null) {
        break label189;
      }
    }
    label189:
    for (paramBundle = paramMiniAppInfo.via;; paramBundle = "")
    {
      paramResultReceiver.useUserApp(paramMiniAppInfo.appId, paramMiniAppInfo.verType, 0, paramActivity, paramBundle, null, new bgpt(this));
      return;
      paramActivity = "";
      break;
    }
  }
  
  public void stopAllMiniApp()
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        String str = (String)localEntry.getKey();
        forceKillProcess((bgpw)localEntry.getValue());
        cleanProcess(str);
      }
    }
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = getCacheApp(paramMiniAppInfo);
    if (paramMiniAppInfo != null) {
      forceKillProcess(paramMiniAppInfo);
    }
  }
  
  /* Error */
  public void updateBaseLib()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 998	com/tencent/qqmini/sdk/utils/QUAUtil:isQQApp	()Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: invokestatic 1003	bgrl:a	()Lbgrl;
    //   16: new 1005	bgpu
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 1006	bgpu:<init>	(Lcom/tencent/qqmini/sdk/launcher/AppBrandLaunchManager;)V
    //   24: invokevirtual 1009	bgrl:a	(Lbgrp;)V
    //   27: goto -17 -> 10
    //   30: astore_2
    //   31: ldc 30
    //   33: ldc_w 1011
    //   36: aload_2
    //   37: invokestatic 268	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: goto -30 -> 10
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	AppBrandLaunchManager
    //   5	2	1	bool	boolean
    //   30	7	2	localThrowable	Throwable
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	27	30	java/lang/Throwable
    //   2	6	43	finally
    //   13	27	43	finally
    //   31	40	43	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager
 * JD-Core Version:    0.7.0.1
 */