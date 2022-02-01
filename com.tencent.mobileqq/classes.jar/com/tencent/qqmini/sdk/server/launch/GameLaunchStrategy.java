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
import android.os.Messenger;
import android.os.Process;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
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
    this.processConfig = CollectionsKt.toList((Iterable)paramList);
    if (this.debug)
    {
      if (!((Collection)paramList).isEmpty()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalStateException("Check failed.".toString()));
      }
      paramContext = ((Iterable)paramList).iterator();
      while (paramContext.hasNext())
      {
        paramList = (MiniProcessorConfig)paramContext.next();
        checkProcessConfig$lib_miniserver_internalRelease(this.context, paramList);
      }
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
    if (this.debug) {
      throw ((Throwable)new IllegalStateException(paramString));
    }
    QMLog.e("GameLaunchStrategy", paramString);
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
        if (localObject1 == null) {
          break label72;
        }
      }
    }
    for (;;)
    {
      return (GameLaunchStrategy.RunningProcessInfo)localObject1;
      localObject1 = null;
      break;
      label72:
      localObject1 = ((Iterable)this.processConfig).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
      } while (!Intrinsics.areEqual(((MiniProcessorConfig)localObject2).processName, paramString));
      localObject1 = new GameLaunchStrategy.RunningProcessInfo(this, (MiniProcessorConfig)localObject2);
      localList.add(0, localObject1);
    }
    throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
  }
  
  private final void logCurrentState(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentStateOfRunningProcessAndApps");
    if (paramString != null) {
      localStringBuilder.append(" [").append(paramString).append("]");
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
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Intrinsics.areEqual(((GameLaunchStrategy.RunningProcessInfo)localObject).getConfig(), paramMiniProcessorConfig));
    while (localObject != null)
    {
      return;
      localObject = null;
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
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramMiniProcessorConfig, "config");
    if (paramMiniProcessorConfig.processType == ProcessType.MINI_GAME) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (!Activity.class.isAssignableFrom(paramMiniProcessorConfig.appUIClass)) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (!BroadcastReceiver.class.isAssignableFrom(paramMiniProcessorConfig.appPreLoadClass)) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    paramMiniProcessorConfig = paramMiniProcessorConfig.appUIClass;
    Intrinsics.checkExpressionValueIsNotNull(paramMiniProcessorConfig, "config.appUIClass");
    paramContext = localPackageManager.getActivityInfo(new ComponentName(paramContext, paramMiniProcessorConfig.getName()), 0);
    if (paramContext.launchMode == 0) {}
    for (i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("MiniGame activity:launchMode must be 'standard'".toString()));
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramContext.documentLaunchMode != 0)
      {
        i = j;
        if (paramContext.documentLaunchMode != 1) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        throw ((Throwable)new IllegalStateException("MiniGame activity:documentLaunchMode must be 'none' or 'intoExisting'".toString()));
      }
    }
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
  }
  
  /* Error */
  public boolean killMiniAppProcess(@NotNull MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 389
    //   6: invokestatic 116	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   12: aload_1
    //   13: checkcast 391	com/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo
    //   16: invokevirtual 395	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:toId$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;)Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   25: checkcast 131	java/lang/Iterable
    //   28: invokeinterface 162 1 0
    //   33: astore 5
    //   35: aload 5
    //   37: invokeinterface 167 1 0
    //   42: ifeq +82 -> 124
    //   45: aload 5
    //   47: invokeinterface 171 1 0
    //   52: astore_3
    //   53: aload_3
    //   54: checkcast 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   57: aload 4
    //   59: invokevirtual 399	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:has	(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)Z
    //   62: ifeq -27 -> 35
    //   65: aload_3
    //   66: checkcast 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +58 -> 129
    //   74: aload_0
    //   75: aload_3
    //   76: invokevirtual 322	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:performKillProcess$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;)V
    //   79: aload_0
    //   80: new 249	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 401
    //   90: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   96: aload_1
    //   97: checkcast 391	com/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo
    //   100: invokevirtual 395	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:toId$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;)Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   103: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 297	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:logCurrentState	(Ljava/lang/String;)V
    //   112: aload_3
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +19 -> 134
    //   118: iconst_1
    //   119: istore_2
    //   120: aload_0
    //   121: monitorexit
    //   122: iload_2
    //   123: ireturn
    //   124: aconst_null
    //   125: astore_3
    //   126: goto -61 -> 65
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -17 -> 114
    //   134: iconst_0
    //   135: istore_2
    //   136: goto -16 -> 120
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	GameLaunchStrategy
    //   0	144	1	paramMiniAppInfo	MiniAppInfo
    //   119	17	2	bool	boolean
    //   52	74	3	localObject	Object
    //   19	39	4	localAppIdentity	AppIdentity
    //   33	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	35	139	finally
    //   35	65	139	finally
    //   65	70	139	finally
    //   74	112	139	finally
  }
  
  public void onAppBackground(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @Nullable Bundle paramBundle)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "processName");
      Intrinsics.checkParameterIsNotNull(paramMiniAppBaseInfo, "appConfig");
      getOrAddProcessInfo(paramString).appBackground(Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
      logCurrentState("onAppBackground " + Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
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
      logCurrentState("onAppForeground " + Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
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
      logCurrentState("onAppStart " + Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
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
      logCurrentState("onAppStop " + Companion.toId$lib_miniserver_internalRelease(paramMiniAppBaseInfo));
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
      logCurrentState("onPreloaded " + paramString);
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
      logCurrentState("onProcessExited " + paramRunningProcessInfo.toSimpleString());
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
    if (paramRunningProcessInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    paramRunningProcessInfo = ((ActivityManager)paramRunningProcessInfo).getAppTasks();
    Intrinsics.checkExpressionValueIsNotNull(paramRunningProcessInfo, "(context.getSystemServic…ActivityManager).appTasks");
    Iterator localIterator = ((Iterable)paramRunningProcessInfo).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramRunningProcessInfo = localIterator.next();
      localObject = (ActivityManager.AppTask)paramRunningProcessInfo;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      localObject = ((ActivityManager.AppTask)localObject).getTaskInfo().baseIntent;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.taskInfo.baseIntent");
    } while (!Intrinsics.areEqual(((Intent)localObject).getData(), paramAppIdentity.getUri()));
    for (;;)
    {
      paramRunningProcessInfo = (ActivityManager.AppTask)paramRunningProcessInfo;
      if (paramRunningProcessInfo != null) {
        paramRunningProcessInfo.finishAndRemoveTask();
      }
      return;
      paramRunningProcessInfo = null;
    }
  }
  
  @VisibleForTesting
  public void performKillProcess$lib_miniserver_internalRelease(@NotNull GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRunningProcessInfo, "process");
    Process.killProcess(paramRunningProcessInfo.getPid());
  }
  
  /* Error */
  public boolean preloadProcess(@Nullable Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   5: aload_0
    //   6: getfield 139	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:processConfig	Ljava/util/List;
    //   9: aload_0
    //   10: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   13: checkcast 197	java/util/List
    //   16: invokevirtual 529	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:findProcessToPreload$lib_miniserver_internalRelease	(Ljava/util/List;Ljava/util/List;)Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +22 -> 43
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 530	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:performPreloadProcess	(Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;)V
    //   29: aload_0
    //   30: invokespecial 435	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:cleanOldGameIfNeed	()V
    //   33: aload_1
    //   34: ifnull +14 -> 48
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: aconst_null
    //   44: astore_1
    //   45: goto -12 -> 33
    //   48: iconst_0
    //   49: istore_2
    //   50: goto -11 -> 39
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	GameLaunchStrategy
    //   0	58	1	paramBundle	Bundle
    //   38	12	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	53	finally
    //   24	33	53	finally
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
  
  /* Error */
  public void sendMessageToMiniProcess(@NotNull MiniAppInfo paramMiniAppInfo, @NotNull android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 389
    //   6: invokestatic 116	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 538
    //   13: invokestatic 116	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   19: aload_1
    //   20: checkcast 391	com/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo
    //   23: invokevirtual 395	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:toId$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;)Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   31: checkcast 131	java/lang/Iterable
    //   34: invokeinterface 162 1 0
    //   39: astore 4
    //   41: aload 4
    //   43: invokeinterface 167 1 0
    //   48: ifeq +48 -> 96
    //   51: aload 4
    //   53: invokeinterface 171 1 0
    //   58: astore_1
    //   59: aload_1
    //   60: checkcast 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   63: aload_3
    //   64: invokevirtual 399	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:has	(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)Z
    //   67: ifeq -26 -> 41
    //   70: aload_1
    //   71: checkcast 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +17 -> 93
    //   79: aload_1
    //   80: invokevirtual 542	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:getMessenger	()Landroid/os/Messenger;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +8 -> 93
    //   88: aload_1
    //   89: aload_2
    //   90: invokevirtual 548	android/os/Messenger:send	(Landroid/os/Message;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aconst_null
    //   97: astore_1
    //   98: goto -28 -> 70
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	GameLaunchStrategy
    //   0	106	1	paramMiniAppInfo	MiniAppInfo
    //   0	106	2	paramMessage	android.os.Message
    //   26	38	3	localAppIdentity	AppIdentity
    //   39	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	41	101	finally
    //   41	70	101	finally
    //   70	75	101	finally
    //   79	84	101	finally
    //   88	93	101	finally
  }
  
  /* Error */
  @NotNull
  public LaunchStrategy.LaunchData startMiniApp(@NotNull MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 408
    //   6: invokestatic 116	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokespecial 435	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:cleanOldGameIfNeed	()V
    //   13: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   16: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   19: aload_1
    //   20: checkcast 391	com/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo
    //   23: invokevirtual 395	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:toId$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;)Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   26: aload_0
    //   27: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   30: checkcast 197	java/util/List
    //   33: invokevirtual 553	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:findExistedProcessForGame$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;Ljava/util/List;)Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +314 -> 352
    //   41: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   44: aload_0
    //   45: getfield 139	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:processConfig	Ljava/util/List;
    //   48: aload_0
    //   49: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   52: checkcast 197	java/util/List
    //   55: invokevirtual 556	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:findProcessForLaunch$lib_miniserver_internalRelease	(Ljava/util/List;Ljava/util/List;)Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;
    //   58: astore_3
    //   59: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   62: astore_2
    //   63: aload_0
    //   64: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   67: checkcast 197	java/util/List
    //   70: astore 4
    //   72: aload 4
    //   74: checkcast 131	java/lang/Iterable
    //   77: invokeinterface 162 1 0
    //   82: astore 5
    //   84: aload 5
    //   86: invokeinterface 167 1 0
    //   91: ifeq +274 -> 365
    //   94: aload 5
    //   96: invokeinterface 171 1 0
    //   101: astore_2
    //   102: aload_2
    //   103: checkcast 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   106: invokevirtual 227	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:getConfig	()Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;
    //   109: aload_3
    //   110: invokestatic 233	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   113: ifeq -29 -> 84
    //   116: goto +239 -> 355
    //   119: aload_2
    //   120: checkcast 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   123: astore_2
    //   124: aload_2
    //   125: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   128: aload_1
    //   129: checkcast 391	com/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo
    //   132: invokevirtual 395	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:toId$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;)Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   135: invokevirtual 429	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:addApp	(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)V
    //   138: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   141: astore_3
    //   142: aload_0
    //   143: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   146: checkcast 197	java/util/List
    //   149: astore_3
    //   150: aload_3
    //   151: aload_2
    //   152: invokeinterface 420 2 0
    //   157: pop
    //   158: aload_3
    //   159: iconst_0
    //   160: aload_2
    //   161: invokeinterface 240 3 0
    //   166: aload_0
    //   167: new 249	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 558
    //   177: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   183: aload_1
    //   184: checkcast 391	com/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo
    //   187: invokevirtual 395	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:toId$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;)Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   190: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokespecial 297	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:logCurrentState	(Ljava/lang/String;)V
    //   199: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   202: aload_0
    //   203: getfield 123	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:context	Landroid/content/Context;
    //   206: aload_0
    //   207: getfield 125	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:gameLaunchConfig	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;
    //   210: aload_2
    //   211: getstatic 108	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:Companion	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;
    //   214: aload_1
    //   215: checkcast 391	com/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo
    //   218: invokevirtual 395	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:toId$lib_miniserver_internalRelease	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;)Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   221: invokevirtual 562	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion:createLaunchIntent$lib_miniserver_internalRelease	(Landroid/content/Context;Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)Landroid/content/Intent;
    //   224: astore_3
    //   225: aload_2
    //   226: invokevirtual 566	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:getState	()Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   229: astore_1
    //   230: getstatic 572	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$WhenMappings:$EnumSwitchMapping$0	[I
    //   233: aload_1
    //   234: invokevirtual 577	com/tencent/qqmini/sdk/server/launch/RunningProcessState:ordinal	()I
    //   237: iaload
    //   238: tableswitch	default:+124 -> 362, 1:+82->320, 2:+100->338, 3:+107->345
    //   265: iconst_m1
    //   266: fstore_0
    //   267: dup
    //   268: invokespecial 580	kotlin/NoWhenBranchMatchedException:<init>	()V
    //   271: athrow
    //   272: astore_1
    //   273: aload_0
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    //   277: astore_2
    //   278: aload_0
    //   279: getfield 181	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:runningProcess	Ljava/util/LinkedList;
    //   282: checkcast 197	java/util/List
    //   285: invokestatic 584	kotlin/collections/CollectionsKt:last	(Ljava/util/List;)Ljava/lang/Object;
    //   288: checkcast 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   291: invokevirtual 227	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:getConfig	()Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;
    //   294: astore_3
    //   295: goto -236 -> 59
    //   298: new 223	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo
    //   301: dup
    //   302: aload_0
    //   303: aload_3
    //   304: invokespecial 236	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:<init>	(Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;)V
    //   307: astore_2
    //   308: aload 4
    //   310: iconst_0
    //   311: aload_2
    //   312: invokeinterface 240 3 0
    //   317: goto -198 -> 119
    //   320: getstatic 590	com/tencent/qqmini/sdk/server/launch/ProcessState:EMPTY	Lcom/tencent/qqmini/sdk/server/launch/ProcessState;
    //   323: astore_1
    //   324: new 592	com/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData
    //   327: dup
    //   328: aload_3
    //   329: aload_1
    //   330: invokespecial 595	com/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData:<init>	(Landroid/content/Intent;Lcom/tencent/qqmini/sdk/server/launch/ProcessState;)V
    //   333: astore_1
    //   334: aload_0
    //   335: monitorexit
    //   336: aload_1
    //   337: areturn
    //   338: getstatic 598	com/tencent/qqmini/sdk/server/launch/ProcessState:REUSE	Lcom/tencent/qqmini/sdk/server/launch/ProcessState;
    //   341: astore_1
    //   342: goto -18 -> 324
    //   345: getstatic 601	com/tencent/qqmini/sdk/server/launch/ProcessState:PRELOADED	Lcom/tencent/qqmini/sdk/server/launch/ProcessState;
    //   348: astore_1
    //   349: goto -25 -> 324
    //   352: goto -186 -> 166
    //   355: aload_2
    //   356: ifnull -58 -> 298
    //   359: goto -240 -> 119
    //   362: goto -98 -> 264
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -12 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	GameLaunchStrategy
    //   0	370	1	paramMiniAppInfo	MiniAppInfo
    //   36	190	2	localObject1	Object
    //   277	1	2	localIllegalStateException	IllegalStateException
    //   307	60	2	localRunningProcessInfo	GameLaunchStrategy.RunningProcessInfo
    //   58	271	3	localObject2	Object
    //   70	239	4	localList	List
    //   82	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	37	272	finally
    //   41	59	272	finally
    //   59	84	272	finally
    //   84	116	272	finally
    //   119	166	272	finally
    //   166	264	272	finally
    //   264	272	272	finally
    //   278	295	272	finally
    //   298	317	272	finally
    //   320	324	272	finally
    //   324	334	272	finally
    //   338	342	272	finally
    //   345	349	272	finally
    //   41	59	277	java/lang/IllegalStateException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy
 * JD-Core Version:    0.7.0.1
 */