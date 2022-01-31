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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.LruCache;
import bdgc;
import bdgd;
import bdld;
import bdnr;
import bdns;
import bdnw;
import bdsc;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandLaunchManager
  implements bdnr
{
  private static final int KILL_MODE_PID = 0;
  private static final int KILL__MODE_BROADCAST = 1;
  public static final int MINI_APP_CRASH_PROTECT_TIME_DEFAULT = 3600000;
  private static final int MINI_APP_PROCESS_DETECT_TIME_DEFAULT = 600000;
  private static final int PROCESS_APP_RECYCLE_TIME = 1800000;
  private static final int PROCESS_GAME_MAX_COUNT_DEFAULT = 3;
  private static final int PROCESS_GAME_RECYCLE_TIME = 900000;
  private static final int PROCESS_MAX_COUNT_DEFAULT = 6;
  private static final int PROCESS_PRELOAD_COUNT_DEFAULT = 2;
  private static final String TAG = "minisdk-start_AppBrandLaunchManager";
  public static LinkedHashMap<String, bdld> subAppProcessorInfoMap = new LinkedHashMap();
  public static LinkedHashMap<String, bdld> subGameProcessorInfoMap = new LinkedHashMap();
  public static LinkedHashMap<String, bdld> subProcessorInfoMap = new LinkedHashMap();
  public long appProcessRecycleTime = 1800000L;
  public long gameProcessRecycleTime = 900000L;
  private bdld lastKillingProcessor;
  private Context mContext;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private int mKillProcessMode = 0;
  private long mLastPreloadDetectTime;
  private boolean mMiniAppUsed;
  private ConcurrentHashMap<String, String> mPreloadingTask = new ConcurrentHashMap();
  private int mProcessGameMaxCount;
  private int mProcessMaxCount;
  private int mProcessPreloadCount;
  private LruCache<String, bdld> mProcessStack;
  private int mStartTimeInterval = 1500;
  private long mStartTimestamp;
  private MiniAppBaseInfo mStartingMiniAppConfig;
  private HashMap<String, Long> startAppIdMap = new HashMap();
  
  private boolean canPreloadApp(bdld parambdld)
  {
    return true;
  }
  
  private boolean canPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    int j;
    label32:
    int i;
    if ("preload_game".equals(paramString))
    {
      j = this.mProcessGameMaxCount;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      i = 0;
      label48:
      if (!((Iterator)localObject1).hasNext()) {
        break label119;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 == null) {
        break label126;
      }
      localObject2 = (bdld)((Map.Entry)localObject2).getValue();
      if ((localObject2 == null) || (!paramString.equals(((bdld)localObject2).jdField_b_of_type_JavaLangString))) {
        break label126;
      }
      i += 1;
    }
    label119:
    label126:
    for (;;)
    {
      break label48;
      j = this.mProcessMaxCount;
      break label32;
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
          break label354;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 == null) {
          break label353;
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
          localObject4 = (bdld)((Map.Entry)localObject4).getValue();
          if (localObject4 == null) {
            continue;
          }
          Iterator localIterator2 = ((List)localObject1).iterator();
          if (localIterator2.hasNext())
          {
            if (((ActivityManager.RunningAppProcessInfo)localIterator2.next()).pid != ((bdld)localObject4).jdField_a_of_type_Int) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            bdnw.b("minisdk-start_AppBrandLaunchManager", "Process has been died, clean the record! processName=" + (String)localObject3 + " pid=" + ((bdld)localObject4).jdField_a_of_type_Int);
            this.mProcessStack.remove(localObject3);
          }
        }
        else
        {
          localIterator1 = this.mPreloadingTask.entrySet().iterator();
        }
      }
      catch (Throwable localThrowable)
      {
        bdnw.d("minisdk-start_AppBrandLaunchManager", "", localThrowable);
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
                break label346;
              }
              bdnw.b("minisdk-start_AppBrandLaunchManager", "Process has been died, clean the preloading record! processName=" + (String)localObject3);
              localIterator1.remove();
              break;
            }
            label346:
            continue;
            i = 0;
            break;
          }
        }
      }
      label353:
      return;
      label354:
      Object localObject2 = null;
    }
  }
  
  private void checkPreload()
  {
    bdnw.b("minisdk-start_AppBrandLaunchManager", "checkPreload MiniAppUsed:" + this.mMiniAppUsed);
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
      bdnw.d("minisdk-start_AppBrandLaunchManager", "", localThrowable);
    }
  }
  
  private void cleanProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      bdld localbdld = (bdld)this.mProcessStack.remove(paramString);
      if (localbdld != null) {
        localbdld.c();
      }
    } while ((this.lastKillingProcessor == null) || (!paramString.equals(this.lastKillingProcessor.jdField_a_of_type_JavaLangString)));
    paramString = this.lastKillingProcessor;
    getHandler().postDelayed(new AppBrandLaunchManager.1(this, paramString), 2000L);
    this.lastKillingProcessor = null;
  }
  
  private void doPreloadApp(bdld parambdld, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambdld == null) || ((!paramBoolean2) && (!canPreloadApp(parambdld)))) {
      return;
    }
    for (;;)
    {
      try
      {
        bdnw.b("minisdk-start_AppBrandLaunchManager", "do preload mini process name=" + parambdld.jdField_a_of_type_JavaLangString + " Preload=" + parambdld.c.getSimpleName() + " isMiniApp:" + paramBoolean1);
        Intent localIntent = new Intent();
        localIntent.setClass(this.mContext, parambdld.c);
        if (paramBoolean1)
        {
          localObject = "mini_preload_app";
          localIntent.setAction((String)localObject);
          if ((paramBoolean3) && (bdgd.a != null)) {
            localIntent.putExtra("tissuenativelibdir", bdgd.a.getNativeLibDir());
          }
          localObject = this.mPreloadingTask;
          String str = parambdld.jdField_a_of_type_JavaLangString;
          if (!paramBoolean1) {
            break label197;
          }
          parambdld = "preload_app";
          ((ConcurrentHashMap)localObject).put(str, parambdld);
          this.mContext.sendBroadcast(localIntent);
          return;
        }
      }
      catch (Throwable parambdld)
      {
        bdnw.d("minisdk-start_AppBrandLaunchManager", "send preload Broadcast exception!", parambdld);
        return;
      }
      Object localObject = "mini_preload_game";
      continue;
      label197:
      parambdld = "preload_game";
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private void doStartMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Object localObject = obtainIdleProcessor(paramMiniAppInfo);
    if ((localObject == null) || (paramMiniAppInfo == null))
    {
      bdnw.d("minisdk-start_AppBrandLaunchManager", "obtain idle processor config failed!");
      return;
    }
    if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppInfo)) && (System.currentTimeMillis() - this.mStartTimestamp <= this.mStartTimeInterval))
    {
      bdnw.c("minisdk-start_AppBrandLaunchManager", "startMiniApp duplicate. The miniapp is starting! interval=" + this.mStartTimeInterval + " appId=" + paramMiniAppInfo.appId);
      return;
    }
    bdsc.a("2click", null, paramMiniAppInfo.launchParam.c, paramMiniAppInfo);
    if (paramMiniAppInfo != null) {
      this.startAppIdMap.put(paramMiniAppInfo.appId, Long.valueOf(System.currentTimeMillis()));
    }
    this.mStartingMiniAppConfig = paramMiniAppInfo;
    this.mStartTimestamp = System.currentTimeMillis();
    bdnw.b("minisdk-start_AppBrandLaunchManager", "doStartMiniApp appId=" + paramMiniAppInfo.appId + " appName=" + paramMiniAppInfo.name + " engineType=" + paramMiniAppInfo.getEngineType() + " reportType=" + -1 + " targetProcess=" + ((bdld)localObject).jdField_a_of_type_JavaLangString);
    Context localContext = this.mContext;
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {}
    for (localObject = ((bdld)localObject).jdField_b_of_type_JavaLangClass;; localObject = ((bdld)localObject).jdField_a_of_type_JavaLangClass)
    {
      localObject = new Intent(localContext, (Class)localObject);
      ((Intent)localObject).addFlags(805371904);
      ((Intent)localObject).putExtra("KEY_APPINFO", paramMiniAppInfo);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      if (paramActivity == null) {
        break;
      }
      paramActivity.startActivity((Intent)localObject);
      return;
    }
    if (paramResultReceiver != null)
    {
      paramActivity = ((Intent)localObject).getExtras();
      paramActivity.putParcelable("Activity", ((Intent)localObject).getComponent());
      paramResultReceiver.send(1, paramActivity);
      return;
    }
    this.mContext.startActivity((Intent)localObject);
  }
  
  private bdld findLastMiniGameProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
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
        localObject2 = (bdld)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (((bdld)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) || (!((bdld)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame())) {
          break label136;
        }
        i += 1;
        if ((((bdld)localObject2).a(paramMiniAppBaseInfo)) || (localObject1 != null)) {
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
  
  private boolean finishAndRemoveTask(bdld parambdld)
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
      if (parambdld == null)
      {
        bdnw.d("miniapp", "当前进程信息为空");
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          bdnw.d("miniapp", "will finish and remove task: id=" + localAppTask.getTaskInfo().id);
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(parambdld.jdField_a_of_type_JavaLangClass)) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(parambdld.jdField_b_of_type_JavaLangClass))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable parambdld)
    {
      bdnw.d("miniapp", "finishAndRemoveAllTasks exception.");
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
      bdnw.d("minisdk-start_AppBrandLaunchManager", "", paramContext);
    }
    return "";
  }
  
  private boolean hasPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (bdld)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((bdld)localObject).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) && (paramString.equals(((bdld)localObject).jdField_b_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    localIterator = this.mPreloadingTask.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if ((localObject != null) && (paramString.equals((String)((Map.Entry)localObject).getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean needPreloadMiniApp()
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (bdld)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((bdld)localObject).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null)) {
          return false;
        }
      }
    }
    return this.mPreloadingTask.size() <= 0;
  }
  
  private bdld obtainIdleMiniAppProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
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
          localObject4 = (bdld)((Map.Entry)localObject4).getValue();
          if ((localObject4 != null) && (((bdld)localObject4).a(paramMiniAppBaseInfo)))
          {
            bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain loaded processor from stack:" + (String)localObject3);
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
        localObject3 = (bdld)((Map.Entry)localObject3).getValue();
        if ((localObject3 != null) && (((bdld)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) && ("preload_app".equals(((bdld)localObject3).jdField_b_of_type_JavaLangString)))
        {
          bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack:" + (String)localObject2);
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
        localObject3 = (bdld)((Map.Entry)localObject3).getValue();
        if ((!((Map)localObject1).containsKey(localObject2)) && (localObject3 != null))
        {
          bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    Object localObject2 = this.mProcessStack.snapshot().entrySet().iterator();
    paramMiniAppBaseInfo = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
      if (localObject1 != null)
      {
        localObject3 = (bdld)((Map.Entry)localObject1).getValue();
        paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
        if (localObject3 != null)
        {
          paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
          if (((bdld)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null)
          {
            paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
            if (!((bdld)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame()) {
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
        paramMiniAppBaseInfo = (bdld)paramMiniAppBaseInfo.getValue();
        if (paramMiniAppBaseInfo != null)
        {
          bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack bottom:" + (String)localObject1);
          return paramMiniAppBaseInfo;
        }
      }
      return null;
    }
  }
  
  private bdld obtainIdleMiniGameProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
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
          localObject3 = (bdld)((Map.Entry)localObject3).getValue();
          if ((localObject3 != null) && (((bdld)localObject3).a(paramMiniAppBaseInfo)))
          {
            bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain loaded processor from stack:" + (String)localObject2);
            return localObject3;
          }
        }
      }
    }
    int j = this.mProcessGameMaxCount;
    paramMiniAppBaseInfo = this.mProcessStack.snapshot().entrySet().iterator();
    int i = 0;
    while (paramMiniAppBaseInfo.hasNext())
    {
      localObject1 = (Map.Entry)paramMiniAppBaseInfo.next();
      if (localObject1 != null)
      {
        localObject1 = (bdld)((Map.Entry)localObject1).getValue();
        if ((localObject1 == null) || (((bdld)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) || (!((bdld)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame())) {
          break label627;
        }
        i += 1;
      }
    }
    label624:
    label627:
    for (;;)
    {
      break;
      if (i < j)
      {
        paramMiniAppBaseInfo = this.mProcessStack.snapshot();
        localObject1 = paramMiniAppBaseInfo.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          if (localObject3 != null)
          {
            localObject2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (bdld)((Map.Entry)localObject3).getValue();
            if ((localObject3 != null) && (((bdld)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) && ("preload_game".equals(((bdld)localObject3).jdField_b_of_type_JavaLangString)))
            {
              bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack:" + (String)localObject2);
              return localObject3;
            }
          }
        }
        if (paramMiniAppBaseInfo.size() < this.mProcessMaxCount)
        {
          localObject1 = subGameProcessorInfoMap.entrySet().iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            localObject2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (bdld)((Map.Entry)localObject3).getValue();
          } while ((paramMiniAppBaseInfo.containsKey(localObject2)) || (localObject3 == null));
          bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
      else
      {
        localObject2 = this.mProcessStack.snapshot().entrySet().iterator();
        paramMiniAppBaseInfo = null;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Map.Entry)((Iterator)localObject2).next();
          if (localObject1 != null)
          {
            localObject3 = (bdld)((Map.Entry)localObject1).getValue();
            if ((localObject3 == null) || (paramMiniAppBaseInfo != null) || (((bdld)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) || (!((bdld)localObject3).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame())) {
              break label624;
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
          paramMiniAppBaseInfo = (bdld)paramMiniAppBaseInfo.getValue();
          if (paramMiniAppBaseInfo != null)
          {
            bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain idle processor from stack bottom:" + (String)localObject1);
            return paramMiniAppBaseInfo;
          }
        }
        bdnw.d("minisdk-start_AppBrandLaunchManager", "has no idle processor!!!");
        return null;
      }
    }
  }
  
  private bdld obtainIdleProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
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
    bdnw.c("minisdk-start_AppBrandLaunchManager", "current process count=" + i + " " + localStringBuilder.toString());
  }
  
  public void forceKillProcess(bdld parambdld)
  {
    if (parambdld == null) {
      return;
    }
    this.lastKillingProcessor = parambdld;
    bdnw.b("minisdk-start_AppBrandLaunchManager", "kill mini process: " + this.lastKillingProcessor);
    int i = parambdld.jdField_a_of_type_Int;
    if (i > 0) {
      try
      {
        if (this.mKillProcessMode == 0)
        {
          bdnw.c("minisdk-start_AppBrandLaunchManager", "kill process by pid:" + i);
          Process.killProcess(i);
          finishAndRemoveTask(parambdld);
          cleanProcess(parambdld.jdField_a_of_type_JavaLangString);
          printProcessStack();
          return;
        }
      }
      catch (Throwable parambdld)
      {
        bdnw.d("minisdk-start_AppBrandLaunchManager", "kill process exception!", parambdld);
        return;
      }
    }
    bdnw.c("minisdk-start_AppBrandLaunchManager", "kill process by broadcast" + parambdld.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, parambdld.c);
    this.mContext.sendBroadcast(localIntent);
  }
  
  public bdld getCacheApp(MiniAppBaseInfo paramMiniAppBaseInfo)
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
          localObject2 = (bdld)((Map.Entry)localObject2).getValue();
          if ((localObject2 != null) && (((bdld)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null) && (((bdld)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId.equals(paramMiniAppBaseInfo.appId)))
          {
            bdnw.b("minisdk-start_AppBrandLaunchManager", "obtain loaded processor from stack:" + str);
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
        bdnw.d("minisdk-start_AppBrandLaunchManager", "get config StartTimeInterval exception!", paramContext);
      }
    }
  }
  
  public boolean isMiniProcess(String paramString)
  {
    return subProcessorInfoMap.containsKey(paramString);
  }
  
  public void onAppBackground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    Class localClass = null;
    bdld localbdld1 = null;
    if (paramMiniAppBaseInfo != null)
    {
      paramBundle = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label115;
      }
      localObject = paramMiniAppBaseInfo.name;
      label25:
      if (paramMiniAppBaseInfo == null) {
        break label121;
      }
    }
    label115:
    label121:
    for (int i = paramMiniAppBaseInfo.getEngineType();; i = -1)
    {
      bdnw.b("minisdk-start_AppBrandLaunchManager", "onAppBackground process=" + paramString + " appId=" + paramBundle + " appName=" + (String)localObject + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label127;
      }
      return;
      paramBundle = null;
      break;
      localObject = null;
      break label25;
    }
    label127:
    bdld localbdld2 = (bdld)this.mProcessStack.get(paramString);
    if (localbdld2 != null)
    {
      paramString = localbdld1;
      if (localbdld2.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null) {
        paramString = localbdld2.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId;
      }
      if (paramString != null)
      {
        localObject = localbdld2;
        if (paramString.equals(paramBundle)) {}
      }
      else
      {
        localbdld2.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
        localObject = localbdld2;
      }
      ((bdld)localObject).a();
      printProcessStack();
      return;
    }
    localbdld1 = (bdld)subProcessorInfoMap.get(paramString);
    if (localbdld1 != null)
    {
      paramBundle = localbdld1.jdField_a_of_type_JavaLangClass;
      label224:
      if (localbdld1 == null) {
        break label289;
      }
    }
    label289:
    for (Object localObject = localbdld1.jdField_b_of_type_JavaLangClass;; localObject = null)
    {
      if (localbdld1 != null) {
        localClass = localbdld1.c;
      }
      localObject = new bdld(this, paramString, paramBundle, (Class)localObject, localClass);
      ((bdld)localObject).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
      this.mProcessStack.put(paramString, localObject);
      break;
      paramBundle = null;
      break label224;
    }
  }
  
  public void onAppForeground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    label23:
    int i;
    label33:
    int j;
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
      if (paramBundle == null) {
        break label140;
      }
      j = paramBundle.getInt("PID");
      label46:
      bdnw.b("minisdk-start_AppBrandLaunchManager", "onAppForeground process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label146;
      }
    }
    label128:
    label134:
    label140:
    label146:
    label238:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label23;
        i = -1;
        break label33;
        j = 0;
        break label46;
        paramBundle = (bdld)this.mProcessStack.get(paramString);
        if (paramBundle == null) {
          break label238;
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
          forceKillProcess(paramString);
          return;
          localObject2 = (bdld)subProcessorInfoMap.get(paramString);
          if (localObject2 != null)
          {
            paramBundle = ((bdld)localObject2).jdField_a_of_type_JavaLangClass;
            if (localObject2 == null) {
              break label325;
            }
            localObject1 = ((bdld)localObject2).jdField_b_of_type_JavaLangClass;
            if (localObject2 == null) {
              break label331;
            }
          }
          for (localObject2 = ((bdld)localObject2).c;; localObject2 = null)
          {
            paramBundle = new bdld(this, paramString, paramBundle, (Class)localObject1, (Class)localObject2);
            paramBundle.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
            this.mProcessStack.put(paramString, paramBundle);
            paramString = paramBundle;
            break;
            paramBundle = null;
            break label261;
            localObject1 = null;
            break label273;
          }
        }
        if (!paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
          bool = true;
        }
        preloadExtraMiniApp(bool);
        return;
      }
    } while (paramMiniAppBaseInfo == null);
    label261:
    label273:
    label325:
    label331:
    getHandler().postDelayed(new AppBrandLaunchManager.2(this, paramMiniAppBaseInfo), 500L);
  }
  
  public void onAppStart(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    Object localObject4 = null;
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
      bdnw.b("minisdk-start_AppBrandLaunchManager", "onAppStart process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
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
    Object localObject2 = (bdld)this.mProcessStack.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = (bdld)subProcessorInfoMap.get(paramString);
      if (localObject3 == null) {
        break label343;
      }
      localObject1 = ((bdld)localObject3).jdField_a_of_type_JavaLangClass;
      if (localObject3 == null) {
        break label349;
      }
      localObject2 = ((bdld)localObject3).jdField_b_of_type_JavaLangClass;
      label204:
      if (localObject3 == null) {
        break label355;
      }
    }
    label343:
    label349:
    label355:
    for (Object localObject3 = ((bdld)localObject3).c;; localObject3 = null)
    {
      localObject2 = new bdld(this, paramString, (Class)localObject1, (Class)localObject2, (Class)localObject3);
      ((bdld)localObject2).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
      localObject1 = localObject4;
      if (paramBundle != null) {
        localObject1 = paramBundle.getString("mini_key_preload_type", null);
      }
      ((bdld)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
      this.mProcessStack.put(paramString, localObject2);
      localObject1 = localObject2;
      if (paramMiniAppBaseInfo != null) {
        ((bdld)localObject1).jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo = paramMiniAppBaseInfo;
      }
      ((bdld)localObject1).jdField_a_of_type_Int = j;
      this.mPreloadingTask.remove(paramString);
      printProcessStack();
      paramString = getprocessName(this.mContext);
      bdnw.b("minisdk-start_AppBrandLaunchManager", "updateBaseLib onAppStart " + paramString);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label204;
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
      bdnw.b("minisdk-start_AppBrandLaunchManager", "onAppStop process=" + paramString + " appId=" + str1 + " appName=" + str2 + " engineType=" + i + " reportType=" + -1);
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
        doPreloadApp((bdld)localEntry.getValue(), paramBoolean, false, false);
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
    for (;;)
    {
      int j;
      Map localMap;
      int i;
      try
      {
        bool = needPreloadMiniApp();
        if (!bool) {
          return;
        }
        j = this.mProcessPreloadCount - this.mProcessStack.size();
        if (j <= 0) {
          continue;
        }
        paramBundle = getprocessName(this.mContext);
        bdnw.b("minisdk-start_AppBrandLaunchManager", "updateBaseLib preloadMiniApp " + paramBundle + ", process count=" + j);
        printProcessStack();
        localMap = this.mProcessStack.snapshot();
        i = 0;
      }
      finally {}
      if (bool)
      {
        paramBundle = subAppProcessorInfoMap;
        paramBundle = paramBundle.entrySet().iterator();
        if (paramBundle.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramBundle.next();
          if (localMap.containsKey((String)localEntry.getKey())) {
            continue;
          }
          doPreloadApp((bdld)localEntry.getValue(), bool, true, true);
        }
      }
      else
      {
        paramBundle = subGameProcessorInfoMap;
        continue;
      }
      for (;;)
      {
        if (j <= 0) {
          break label211;
        }
        if (i % 2 != 0) {
          break label213;
        }
        bool = true;
        break;
        j -= 1;
        i += 1;
      }
      label211:
      continue;
      label213:
      boolean bool = false;
    }
  }
  
  public void registerProcessInfo(List<bdns> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bdns localbdns = (bdns)paramList.next();
        if ((localbdns != null) && (!TextUtils.isEmpty(localbdns.jdField_a_of_type_JavaLangString)))
        {
          bdld localbdld = new bdld(this, localbdns.jdField_a_of_type_JavaLangString, localbdns.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType, localbdns.jdField_a_of_type_JavaLangClass, localbdns.jdField_b_of_type_JavaLangClass);
          bdnw.b("minisdk-start_AppBrandLaunchManager", "registerProcessInfo " + localbdld);
          switch (bdlc.a[localbdns.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType.ordinal()])
          {
          default: 
            break;
          case 1: 
            if (localbdns.jdField_a_of_type_JavaLangClass != null)
            {
              subAppProcessorInfoMap.put(localbdns.jdField_a_of_type_JavaLangString, localbdld);
              subProcessorInfoMap.put(localbdns.jdField_a_of_type_JavaLangString, localbdld);
            }
            break;
          case 2: 
            if (localbdns.jdField_a_of_type_JavaLangClass != null)
            {
              subGameProcessorInfoMap.put(localbdns.jdField_a_of_type_JavaLangString, localbdld);
              subProcessorInfoMap.put(localbdns.jdField_a_of_type_JavaLangString, localbdld);
            }
            break;
          }
        }
      }
    }
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null)
    {
      bdnw.d("minisdk-start_AppBrandLaunchManager", "startMiniApp params is empty! ,appConfig=" + paramMiniAppInfo + " Activity=" + paramActivity);
      return;
    }
    this.mMiniAppUsed = true;
    bdnw.b("minisdk-start_AppBrandLaunchManager", "---startApp---- appid:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
    checkAndCleanAllMiniProcess();
    doStartMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void stopAllMiniApp()
  {
    Iterator localIterator = subAppProcessorInfoMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      forceKillProcess((bdld)subAppProcessorInfoMap.get(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager
 * JD-Core Version:    0.7.0.1
 */