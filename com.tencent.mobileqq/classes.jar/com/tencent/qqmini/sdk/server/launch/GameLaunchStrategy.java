package com.tencent.qqmini.sdk.server.launch;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;", "Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy;", "context", "Landroid/content/Context;", "processConfig", "", "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "gameLaunchConfig", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "preloader", "Lcom/tencent/qqmini/sdk/server/launch/ProcessPreloader;", "debug", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;Lcom/tencent/qqmini/sdk/server/launch/ProcessPreloader;Z)V", "inspectRunningProcess", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;", "inspectRunningProcess$annotations", "()V", "getInspectRunningProcess$lib_miniserver_internalRelease", "()Ljava/util/List;", "runningProcess", "Ljava/util/LinkedList;", "checkProcessConfig", "", "config", "checkProcessConfig$lib_miniserver_internalRelease", "cleanOldGameIfNeed", "debugAssert", "condition", "message", "Lkotlin/Function0;", "", "debugThrow", "getOrAddProcessInfo", "processName", "killAllProcess", "killMiniAppProcess", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "logCurrentState", "action", "onAppBackground", "appConfig", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;", "bundle", "Landroid/os/Bundle;", "onAppForeground", "onAppStart", "onAppStop", "onPreloaded", "onProcessExited", "runningProcessInfo", "onProcessExited$lib_miniserver_internalRelease", "onReceiveProcessRunningAppInfos", "runningApps", "performFinishTaskForOldGameInProcess", "process", "lastApp", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "performFinishTaskForOldGameInProcess$lib_miniserver_internalRelease", "performKillProcess", "performKillProcess$lib_miniserver_internalRelease", "performPreloadProcess", "preformCleanOldGameInProcess", "preloadProcess", "registerProcessMessenger", "messenger", "Landroid/os/Messenger;", "sendMessageToMiniProcess", "Landroid/os/Message;", "startMiniApp", "Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData;", "Companion", "RunningProcessInfo", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public class GameLaunchStrategy
  implements LaunchStrategy
{
  public static final GameLaunchStrategy.Companion Companion = new GameLaunchStrategy.Companion(null);
  @NotNull
  public static final String TAG = "GameLaunchStrategy";
  private final Context context;
  private final boolean debug;
  private final GameLaunchConfig gameLaunchConfig;
  private final ProcessPreloader preloader;
  private final List<MiniProcessorConfig> processConfig;
  private final LinkedList<GameLaunchStrategy.RunningProcessInfo> runningProcess;
  
  public GameLaunchStrategy(@NotNull Context paramContext, @NotNull List<? extends MiniProcessorConfig> paramList, @NotNull GameLaunchConfig paramGameLaunchConfig, @NotNull ProcessPreloader paramProcessPreloader, boolean paramBoolean)
  {
    this.context = paramContext;
    this.gameLaunchConfig = paramGameLaunchConfig;
    this.preloader = paramProcessPreloader;
    this.debug = paramBoolean;
    paramContext = (Iterable)paramList;
    this.processConfig = CollectionsKt.toList(paramContext);
    if (this.debug)
    {
      if ((((Collection)paramList).isEmpty() ^ true))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          paramList = (MiniProcessorConfig)paramContext.next();
          checkProcessConfig$lib_miniserver_internalRelease(this.context, paramList);
        }
      }
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    this.runningProcess = new LinkedList();
  }
  
  private final void cleanOldGameIfNeed()
  {
    GameLaunchStrategy.RunningProcessInfo localRunningProcessInfo = Companion.findProcessToClean$lib_miniserver_internalRelease(this.processConfig, (List)this.runningProcess);
    if (localRunningProcessInfo != null) {
      preformCleanOldGameInProcess(localRunningProcessInfo);
    }
  }
  
  private final void debugAssert(boolean paramBoolean, Function0<String> paramFunction0)
  {
    if (!paramBoolean) {
      access$debugThrow(this, (String)paramFunction0.invoke());
    }
  }
  
  private final void debugThrow(String paramString)
  {
    if (!this.debug)
    {
      QMLog.e("GameLaunchStrategy", paramString);
      return;
    }
    throw ((Throwable)new IllegalStateException(paramString));
  }
  
  private final GameLaunchStrategy.RunningProcessInfo getOrAddProcessInfo(String paramString)
  {
    Object localObject1 = Companion;
    List localList = (List)this.runningProcess;
    Object localObject2 = ((Iterable)localList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (Intrinsics.areEqual(((GameLaunchStrategy.RunningProcessInfo)localObject1).getConfig().processName, paramString)) {
        break label63;
      }
    }
    localObject1 = null;
    label63:
    if (localObject1 == null)
    {
      localObject1 = ((Iterable)this.processConfig).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MiniProcessorConfig)((Iterator)localObject1).next();
      } while (!Intrinsics.areEqual(((MiniProcessorConfig)localObject2).processName, paramString));
      localObject1 = new GameLaunchStrategy.RunningProcessInfo(this, (MiniProcessorConfig)localObject2);
      localList.add(0, localObject1);
    }
    return (GameLaunchStrategy.RunningProcessInfo)localObject1;
    paramString = (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
    for (;;)
    {
      throw paramString;
    }
  }
  
  private final void logCurrentState(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentStateOfRunningProcessAndApps");
    if (paramString != null)
    {
      localStringBuilder.append(" [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
    }
    localStringBuilder.append('\n');
    localStringBuilder.append(CollectionsKt.joinToString$default((Iterable)this.runningProcess, (CharSequence)"\n", null, null, 0, null, (Function1)GameLaunchStrategy.logCurrentState.message.1.2.INSTANCE, 30, null));
    localStringBuilder.append('\n');
    paramString = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "StringBuilder().apply(builderAction).toString()");
    QMLog.i("GameLaunchStrategy", paramString);
  }
  
  private final void performPreloadProcess(MiniProcessorConfig paramMiniProcessorConfig)
  {
    this.preloader.performPreloadProcess(paramMiniProcessorConfig);
    Object localObject = Companion;
    List localList = (List)this.runningProcess;
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(((GameLaunchStrategy.RunningProcessInfo)localObject).getConfig(), paramMiniProcessorConfig)) {
        break label70;
      }
    }
    localObject = null;
    label70:
    if (localObject != null) {
      return;
    }
    localList.add(0, new GameLaunchStrategy.RunningProcessInfo(this, paramMiniProcessorConfig));
  }
  
  private final void preformCleanOldGameInProcess(GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo)
  {
    if ((this.gameLaunchConfig.getEnableProcessReuse()) && (Build.VERSION.SDK_INT >= 21))
    {
      performFinishTaskForOldGameInProcess$lib_miniserver_internalRelease(paramRunningProcessInfo, paramRunningProcessInfo.getLastApp());
      return;
    }
    performKillProcess$lib_miniserver_internalRelease(paramRunningProcessInfo);
  }
  
  @VisibleForTesting
  public void checkProcessConfig$lib_miniserver_internalRelease(@NotNull Context paramContext, @NotNull MiniProcessorConfig paramMiniProcessorConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramMiniProcessorConfig, "config");
    Object localObject = paramMiniProcessorConfig.processType;
    ProcessType localProcessType = ProcessType.MINI_GAME;
    int j = 1;
    int i;
    if (localObject == localProcessType) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (Activity.class.isAssignableFrom(paramMiniProcessorConfig.appUIClass))
      {
        if (BroadcastReceiver.class.isAssignableFrom(paramMiniProcessorConfig.appPreLoadClass))
        {
          localObject = paramContext.getPackageManager();
          paramContext = paramContext.getPackageName();
          paramMiniProcessorConfig = paramMiniProcessorConfig.appUIClass;
          Intrinsics.checkExpressionValueIsNotNull(paramMiniProcessorConfig, "config.appUIClass");
          paramContext = ((PackageManager)localObject).getActivityInfo(new ComponentName(paramContext, paramMiniProcessorConfig.getName()), 0);
          if (paramContext.launchMode == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (Build.VERSION.SDK_INT >= 21)
            {
              i = j;
              if (paramContext.documentLaunchMode != 0) {
                if (paramContext.documentLaunchMode == 1) {
                  i = j;
                } else {
                  i = 0;
                }
              }
              if (i != 0) {
                return;
              }
              throw ((Throwable)new IllegalStateException("MiniGame activity:documentLaunchMode must be 'none' or 'intoExisting'".toString()));
            }
            return;
          }
          throw ((Throwable)new IllegalStateException("MiniGame activity:launchMode must be 'standard'".toString()));
        }
        throw ((Throwable)new IllegalStateException("Check failed.".toString()));
      }
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  @NotNull
  public final List<GameLaunchStrategy.RunningProcessInfo> getInspectRunningProcess$lib_miniserver_internalRelease()
  {
    return CollectionsKt.toList((Iterable)this.runningProcess);
  }
  
  public void killAllProcess()
  {
    try
    {
      Iterator localIterator = ((Iterable)this.runningProcess).iterator();
      while (localIterator.hasNext()) {
        performKillProcess$lib_miniserver_internalRelease((GameLaunchStrategy.RunningProcessInfo)localIterator.next());
      }
      logCurrentState("killAllProcess");
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean killMiniAppProcess(@NotNull MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramMiniAppInfo, "miniAppInfo");
      localObject2 = Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)paramMiniAppInfo);
      Iterator localIterator = ((Iterable)this.runningProcess).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localIterator.next();
      } while (!((GameLaunchStrategy.RunningProcessInfo)localObject1).has((AppIdentity)localObject2));
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        boolean bool;
        for (;;)
        {
          throw paramMiniAppInfo;
        }
        Object localObject1 = null;
      }
    }
    localObject1 = (GameLaunchStrategy.RunningProcessInfo)localObject1;
    if (localObject1 != null)
    {
      performKillProcess$lib_miniserver_internalRelease((GameLaunchStrategy.RunningProcessInfo)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("killMiniAppProcess ");
      ((StringBuilder)localObject2).append(Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)paramMiniAppInfo));
      logCurrentState(((StringBuilder)localObject2).toString());
      paramMiniAppInfo = (MiniAppInfo)localObject1;
    }
    else
    {
      paramMiniAppInfo = null;
    }
    if (paramMiniAppInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onAppBackground(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @Nullable Bundle paramBundle)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramMiniAppBaseInfo, "appConfig");
      getOrAddProcessInfo(paramString).appBackground(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      paramString = new StringBuilder();
      paramString.append("onAppBackground ");
      paramString.append(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      logCurrentState(paramString.toString());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onAppForeground(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @Nullable Bundle paramBundle)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramMiniAppBaseInfo, "appConfig");
      paramString = getOrAddProcessInfo(paramString);
      paramBundle = Companion;
      paramBundle = (List)this.runningProcess;
      paramBundle.remove(paramString);
      paramBundle.add(0, paramString);
      paramString.appForeground(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      paramString = new StringBuilder();
      paramString.append("onAppForeground ");
      paramString.append(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      logCurrentState(paramString.toString());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onAppStart(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @NotNull Bundle paramBundle)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramMiniAppBaseInfo, "appConfig");
      Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
      paramString = getOrAddProcessInfo(paramString);
      Object localObject = Companion;
      localObject = (List)this.runningProcess;
      ((List)localObject).remove(paramString);
      ((List)localObject).add(0, paramString);
      paramString.addApp(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      paramString.onProcessStarted(paramBundle);
      cleanOldGameIfNeed();
      paramString = new StringBuilder();
      paramString.append("onAppStart ");
      paramString.append(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      logCurrentState(paramString.toString());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onAppStop(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @Nullable Bundle paramBundle)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramMiniAppBaseInfo, "appConfig");
      getOrAddProcessInfo(paramString).removeApp(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      paramString = new StringBuilder();
      paramString.append("onAppStop ");
      paramString.append(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      logCurrentState(paramString.toString());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onPreloaded(@NotNull String paramString, @NotNull Bundle paramBundle)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
      GameLaunchStrategy.RunningProcessInfo localRunningProcessInfo = getOrAddProcessInfo(paramString);
      localRunningProcessInfo.onPreloaded();
      localRunningProcessInfo.onProcessStarted(paramBundle);
      paramBundle = new StringBuilder();
      paramBundle.append("onPreloaded ");
      paramBundle.append(paramString);
      logCurrentState(paramBundle.toString());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @VisibleForTesting
  public final void onProcessExited$lib_miniserver_internalRelease(@NotNull GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramRunningProcessInfo, "runningProcessInfo");
      this.runningProcess.remove(paramRunningProcessInfo);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProcessExited ");
      localStringBuilder.append(paramRunningProcessInfo.toSimpleString());
      logCurrentState(localStringBuilder.toString());
      return;
    }
    finally
    {
      paramRunningProcessInfo = finally;
      throw paramRunningProcessInfo;
    }
  }
  
  public void onReceiveProcessRunningAppInfos(@NotNull String paramString, @NotNull List<? extends MiniAppInfo> paramList)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramList, "runningApps");
      getOrAddProcessInfo(paramString).restoreRunningApps(paramList);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @RequiresApi(21)
  @VisibleForTesting
  public void performFinishTaskForOldGameInProcess$lib_miniserver_internalRelease(@NotNull GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo, @NotNull AppIdentity paramAppIdentity)
  {
    Intrinsics.checkParameterIsNotNull(paramRunningProcessInfo, "process");
    Intrinsics.checkParameterIsNotNull(paramAppIdentity, "lastApp");
    paramRunningProcessInfo = this.context.getSystemService("activity");
    if (paramRunningProcessInfo != null)
    {
      paramRunningProcessInfo = ((ActivityManager)paramRunningProcessInfo).getAppTasks();
      Intrinsics.checkExpressionValueIsNotNull(paramRunningProcessInfo, "(context.getSystemServic…ActivityManager).appTasks");
      Iterator localIterator = ((Iterable)paramRunningProcessInfo).iterator();
      while (localIterator.hasNext())
      {
        paramRunningProcessInfo = localIterator.next();
        Object localObject = (ActivityManager.AppTask)paramRunningProcessInfo;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
        localObject = ((ActivityManager.AppTask)localObject).getTaskInfo().baseIntent;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.taskInfo.baseIntent");
        if (Intrinsics.areEqual(((Intent)localObject).getData(), paramAppIdentity.getUri())) {
          break label122;
        }
      }
      paramRunningProcessInfo = null;
      label122:
      paramRunningProcessInfo = (ActivityManager.AppTask)paramRunningProcessInfo;
      if (paramRunningProcessInfo != null)
      {
        paramAppIdentity = new StringBuilder();
        paramAppIdentity.append("performFinishTaskForOldGameInProcess ");
        paramAppIdentity.append(paramRunningProcessInfo.getTaskInfo().baseIntent);
        QMLog.i("GameLaunchStrategy", paramAppIdentity.toString());
        paramRunningProcessInfo.finishAndRemoveTask();
      }
      return;
    }
    paramRunningProcessInfo = new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    for (;;)
    {
      throw paramRunningProcessInfo;
    }
  }
  
  @VisibleForTesting
  public void performKillProcess$lib_miniserver_internalRelease(@NotNull GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRunningProcessInfo, "process");
    Process.killProcess(paramRunningProcessInfo.getPid());
  }
  
  public boolean preloadProcess(@Nullable Bundle paramBundle)
  {
    try
    {
      paramBundle = Companion.findProcessToPreload$lib_miniserver_internalRelease(this.processConfig, (List)this.runningProcess);
      if (paramBundle != null)
      {
        performPreloadProcess(paramBundle);
        cleanOldGameIfNeed();
      }
      else
      {
        paramBundle = null;
      }
      boolean bool;
      if (paramBundle != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  public void registerProcessMessenger(@NotNull String paramString, @NotNull Messenger paramMessenger)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramMessenger, "messenger");
      paramString = getOrAddProcessInfo(paramString);
      Object localObject = Companion;
      localObject = (List)this.runningProcess;
      ((List)localObject).remove(paramString);
      ((List)localObject).add(0, paramString);
      paramString.setMessenger(paramMessenger);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void sendMessageToMiniProcess(@NotNull MiniAppInfo paramMiniAppInfo, @NotNull Message paramMessage)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramMiniAppInfo, "miniAppInfo");
      Intrinsics.checkParameterIsNotNull(paramMessage, "message");
      AppIdentity localAppIdentity = Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)paramMiniAppInfo);
      Iterator localIterator = ((Iterable)this.runningProcess).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMiniAppInfo = localIterator.next();
      } while (!((GameLaunchStrategy.RunningProcessInfo)paramMiniAppInfo).has(localAppIdentity));
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramMiniAppInfo;
        }
        paramMiniAppInfo = null;
      }
    }
    paramMiniAppInfo = (GameLaunchStrategy.RunningProcessInfo)paramMiniAppInfo;
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = paramMiniAppInfo.getMessenger();
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.send(paramMessage);
      }
    }
  }
  
  @NotNull
  public LaunchStrategy.LaunchData startMiniApp(@NotNull MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramMiniAppInfo, "appConfig");
      cleanOldGameIfNeed();
      localObject3 = Companion.findExistedProcessForGame$lib_miniserver_internalRelease(Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)paramMiniAppInfo), (List)this.runningProcess);
      if (localObject3 != null) {}
    }
    finally
    {
      Object localObject3;
      label65:
      Object localObject1;
      Object localObject4;
      Object localObject5;
      label147:
      label169:
      label242:
      GameLaunchConfig localGameLaunchConfig;
      AppIdentity localAppIdentity;
      label329:
      int i;
      for (;;)
      {
        throw paramMiniAppInfo;
      }
    }
    try
    {
      localObject3 = Companion.findProcessForLaunch$lib_miniserver_internalRelease(this.processConfig, (List)this.runningProcess);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label65;
      Object localObject2 = null;
      if (localObject2 == null) {
        break label147;
      }
      break label169;
      bool = false;
      break label329;
    }
    localObject3 = ((GameLaunchStrategy.RunningProcessInfo)CollectionsKt.last((List)this.runningProcess)).getConfig();
    localObject1 = Companion;
    localObject4 = (List)this.runningProcess;
    localObject5 = ((Iterable)localObject4).iterator();
    do
    {
      if (!((Iterator)localObject5).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject5).next();
    } while (!Intrinsics.areEqual(((GameLaunchStrategy.RunningProcessInfo)localObject1).getConfig(), localObject3));
    break label430;
    localObject1 = new GameLaunchStrategy.RunningProcessInfo(this, (MiniProcessorConfig)localObject3);
    ((List)localObject4).add(0, localObject1);
    localObject3 = (GameLaunchStrategy.RunningProcessInfo)localObject1;
    localObject1 = ((GameLaunchStrategy.RunningProcessInfo)localObject3).getState();
    ((GameLaunchStrategy.RunningProcessInfo)localObject3).addApp(Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)paramMiniAppInfo));
    localObject4 = Companion;
    localObject4 = (List)this.runningProcess;
    ((List)localObject4).remove(localObject3);
    ((List)localObject4).add(0, localObject3);
    break label242;
    localObject1 = ((GameLaunchStrategy.RunningProcessInfo)localObject3).getState();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("Start ");
    ((StringBuilder)localObject4).append(Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)paramMiniAppInfo));
    logCurrentState(((StringBuilder)localObject4).toString());
    localObject4 = Companion;
    localObject5 = this.context;
    localGameLaunchConfig = this.gameLaunchConfig;
    localAppIdentity = Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)paramMiniAppInfo);
    if (paramMiniAppInfo.launchParam.forceReload != 0)
    {
      bool = true;
      localObject3 = ((GameLaunchStrategy.Companion)localObject4).createLaunchIntent$lib_miniserver_internalRelease((Context)localObject5, localGameLaunchConfig, (GameLaunchStrategy.RunningProcessInfo)localObject3, localAppIdentity, bool);
      i = GameLaunchStrategy.WhenMappings.$EnumSwitchMapping$0[localObject1.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            paramMiniAppInfo = ProcessState.PRELOADED;
          } else {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          paramMiniAppInfo = ProcessState.REUSE;
        }
      }
      else {
        paramMiniAppInfo = ProcessState.EMPTY;
      }
      paramMiniAppInfo = new LaunchStrategy.LaunchData((Intent)localObject3, paramMiniAppInfo);
      return paramMiniAppInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy
 * JD-Core Version:    0.7.0.1
 */