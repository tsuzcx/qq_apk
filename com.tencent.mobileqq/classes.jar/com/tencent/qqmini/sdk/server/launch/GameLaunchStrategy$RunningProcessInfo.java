package com.tencent.qqmini.sdk.server.launch;

import android.os.Messenger;
import android.support.annotation.VisibleForTesting;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;", "", "config", "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "(Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;)V", "apps", "Ljava/util/LinkedList;", "Lcom/tencent/qqmini/sdk/server/launch/RunningApp;", "getConfig", "()Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "deathNotifier", "Lcom/tencent/qqmini/sdk/launcher/ipc/ProcessDeathNotifier;", "full", "", "getFull", "()Z", "idle", "getIdle", "inspectApps", "", "inspectApps$annotations", "()V", "getInspectApps$lib_miniserver_internalRelease", "()Ljava/util/List;", "lastApp", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "getLastApp", "()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "messenger", "Landroid/os/Messenger;", "getMessenger", "()Landroid/os/Messenger;", "setMessenger", "(Landroid/os/Messenger;)V", "<set-?>", "", "pid", "getPid", "()I", "runningAppCount", "getRunningAppCount", "Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;", "state", "getState", "()Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;", "addApp", "", "app", "appBackground", "appForeground", "has", "onPreloaded", "onProcessStarted", "bundle", "Landroid/os/Bundle;", "removeApp", "restoreRunningApps", "runningApps", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "toSimpleString", "", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
@VisibleForTesting
public final class GameLaunchStrategy$RunningProcessInfo
{
  private final LinkedList<RunningApp> apps;
  @NotNull
  private final MiniProcessorConfig config;
  private ProcessDeathNotifier deathNotifier;
  @Nullable
  private Messenger messenger;
  private int pid;
  @NotNull
  private RunningProcessState state;
  
  public GameLaunchStrategy$RunningProcessInfo(MiniProcessorConfig paramMiniProcessorConfig)
  {
    this.config = localObject;
    this.apps = new LinkedList();
    this.state = RunningProcessState.STARTING;
    this.pid = -1;
  }
  
  /* Error */
  public final void addApp(@NotNull AppIdentity paramAppIdentity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 114
    //   5: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getstatic 117	com/tencent/qqmini/sdk/server/launch/RunningProcessState:RUNNING	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   12: putfield 105	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:state	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   15: aload_0
    //   16: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   19: checkcast 119	java/lang/Iterable
    //   22: invokeinterface 123 1 0
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 128 1 0
    //   36: ifeq +34 -> 70
    //   39: aload 4
    //   41: invokeinterface 132 1 0
    //   46: astore_3
    //   47: aload_3
    //   48: checkcast 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   51: invokevirtual 137	com/tencent/qqmini/sdk/server/launch/RunningApp:getId	()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   54: aload_1
    //   55: invokestatic 141	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   58: istore_2
    //   59: iload_2
    //   60: ifeq -31 -> 29
    //   63: aload_3
    //   64: ifnull +11 -> 75
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aconst_null
    //   71: astore_3
    //   72: goto -9 -> 63
    //   75: aload_0
    //   76: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   79: new 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 143	com/tencent/qqmini/sdk/server/launch/RunningApp:<init>	(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)V
    //   87: invokevirtual 147	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   90: goto -23 -> 67
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	RunningProcessInfo
    //   0	98	1	paramAppIdentity	AppIdentity
    //   58	2	2	bool	boolean
    //   46	26	3	localObject	Object
    //   27	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	29	93	finally
    //   29	59	93	finally
    //   75	90	93	finally
  }
  
  /* Error */
  public final void appBackground(@NotNull AppIdentity paramAppIdentity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 114
    //   5: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   12: checkcast 149	java/util/List
    //   15: astore_3
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_3
    //   19: invokeinterface 150 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 128 1 0
    //   31: ifeq +71 -> 102
    //   34: aload_3
    //   35: invokeinterface 132 1 0
    //   40: checkcast 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   43: invokevirtual 137	com/tencent/qqmini/sdk/server/launch/RunningApp:getId	()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   46: aload_1
    //   47: invokestatic 141	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   50: ifeq +45 -> 95
    //   53: iload_2
    //   54: iconst_m1
    //   55: if_icmpeq +52 -> 107
    //   58: aload_0
    //   59: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   62: iload_2
    //   63: invokevirtual 154	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   66: astore_1
    //   67: aload_1
    //   68: ldc 156
    //   70: invokestatic 159	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   73: aload_1
    //   74: checkcast 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   77: astore_1
    //   78: aload_1
    //   79: getstatic 165	com/tencent/qqmini/sdk/server/launch/RunningMiniAppState:BACKGROUND	Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;
    //   82: invokevirtual 169	com/tencent/qqmini/sdk/server/launch/RunningApp:setState	(Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;)V
    //   85: aload_0
    //   86: getstatic 117	com/tencent/qqmini/sdk/server/launch/RunningProcessState:RUNNING	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   89: putfield 105	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:state	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: iload_2
    //   96: iconst_1
    //   97: iadd
    //   98: istore_2
    //   99: goto -74 -> 25
    //   102: iconst_m1
    //   103: istore_2
    //   104: goto -51 -> 53
    //   107: new 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   110: dup
    //   111: aload_1
    //   112: invokespecial 143	com/tencent/qqmini/sdk/server/launch/RunningApp:<init>	(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)V
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   120: aload_1
    //   121: invokevirtual 172	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   124: goto -46 -> 78
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	RunningProcessInfo
    //   0	132	1	paramAppIdentity	AppIdentity
    //   17	87	2	i	int
    //   15	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	127	finally
    //   18	25	127	finally
    //   25	53	127	finally
    //   58	78	127	finally
    //   78	92	127	finally
    //   107	124	127	finally
  }
  
  /* Error */
  public final void appForeground(@NotNull AppIdentity paramAppIdentity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 114
    //   5: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   12: checkcast 149	java/util/List
    //   15: astore_3
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_3
    //   19: invokeinterface 150 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 128 1 0
    //   31: ifeq +79 -> 110
    //   34: aload_3
    //   35: invokeinterface 132 1 0
    //   40: checkcast 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   43: invokevirtual 137	com/tencent/qqmini/sdk/server/launch/RunningApp:getId	()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   46: aload_1
    //   47: invokestatic 141	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   50: ifeq +53 -> 103
    //   53: iload_2
    //   54: iconst_m1
    //   55: if_icmpeq +60 -> 115
    //   58: aload_0
    //   59: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   62: iload_2
    //   63: invokevirtual 175	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   66: astore_1
    //   67: aload_1
    //   68: ldc 177
    //   70: invokestatic 159	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   73: aload_1
    //   74: checkcast 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   82: aload_1
    //   83: invokevirtual 147	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   86: aload_0
    //   87: getstatic 117	com/tencent/qqmini/sdk/server/launch/RunningProcessState:RUNNING	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   90: putfield 105	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:state	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   93: aload_1
    //   94: getstatic 180	com/tencent/qqmini/sdk/server/launch/RunningMiniAppState:FOREGROUND	Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;
    //   97: invokevirtual 169	com/tencent/qqmini/sdk/server/launch/RunningApp:setState	(Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -82 -> 25
    //   110: iconst_m1
    //   111: istore_2
    //   112: goto -59 -> 53
    //   115: new 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 143	com/tencent/qqmini/sdk/server/launch/RunningApp:<init>	(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)V
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   128: aload_1
    //   129: invokevirtual 147	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   132: goto -46 -> 86
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	RunningProcessInfo
    //   0	140	1	paramAppIdentity	AppIdentity
    //   17	95	2	i	int
    //   15	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	135	finally
    //   18	25	135	finally
    //   25	53	135	finally
    //   58	86	135	finally
    //   86	100	135	finally
    //   115	132	135	finally
  }
  
  @NotNull
  public final MiniProcessorConfig getConfig()
  {
    return this.config;
  }
  
  public final boolean getFull()
  {
    return getRunningAppCount() >= GameLaunchStrategy.access$getGameLaunchConfig$p(this.this$0).getMultiInstanceCount();
  }
  
  public final boolean getIdle()
  {
    return getRunningAppCount() == 0;
  }
  
  @NotNull
  public final List<RunningApp> getInspectApps$lib_miniserver_internalRelease()
  {
    return CollectionsKt.toList((Iterable)this.apps);
  }
  
  @NotNull
  public final AppIdentity getLastApp()
  {
    return ((RunningApp)CollectionsKt.last((List)this.apps)).getId();
  }
  
  @Nullable
  public final Messenger getMessenger()
  {
    return this.messenger;
  }
  
  public final int getPid()
  {
    return this.pid;
  }
  
  public final int getRunningAppCount()
  {
    return this.apps.size();
  }
  
  @NotNull
  public final RunningProcessState getState()
  {
    return this.state;
  }
  
  public final boolean has(@NotNull AppIdentity paramAppIdentity)
  {
    Intrinsics.checkParameterIsNotNull(paramAppIdentity, "app");
    Object localObject = (Iterable)this.apps;
    if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (Intrinsics.areEqual(((RunningApp)((Iterator)localObject).next()).getId(), paramAppIdentity)) {
        return true;
      }
    }
    return false;
  }
  
  public final void onPreloaded()
  {
    try
    {
      if (this.state == RunningProcessState.STARTING) {
        this.state = RunningProcessState.PRELOAD;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void onProcessStarted(@NotNull android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 220
    //   5: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 222	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:deathNotifier	Lcom/tencent/qqmini/sdk/launcher/ipc/ProcessDeathNotifier;
    //   12: ifnonnull +116 -> 128
    //   15: aload_1
    //   16: ldc 224
    //   18: invokevirtual 230	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   21: invokevirtual 236	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   24: aload_1
    //   25: ldc 238
    //   27: invokevirtual 242	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnonnull +6 -> 38
    //   35: invokestatic 245	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   38: aload_0
    //   39: aload_3
    //   40: checkcast 224	com/tencent/qqmini/sdk/launcher/ipc/ProcessDeathNotifier
    //   43: putfield 222	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:deathNotifier	Lcom/tencent/qqmini/sdk/launcher/ipc/ProcessDeathNotifier;
    //   46: aload_0
    //   47: getfield 222	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:deathNotifier	Lcom/tencent/qqmini/sdk/launcher/ipc/ProcessDeathNotifier;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +6 -> 58
    //   55: invokestatic 245	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   58: aload_3
    //   59: new 247	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo$onProcessStarted$1
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 250	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo$onProcessStarted$1:<init>	(Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;)V
    //   67: checkcast 252	java/lang/Runnable
    //   70: invokevirtual 256	com/tencent/qqmini/sdk/launcher/ipc/ProcessDeathNotifier:observeDeath	(Ljava/lang/Runnable;)V
    //   73: aload_0
    //   74: aload_1
    //   75: ldc_w 258
    //   78: iconst_m1
    //   79: invokevirtual 262	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   82: putfield 107	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:pid	I
    //   85: aload_0
    //   86: getfield 89	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:this$0	Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 107	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:pid	I
    //   94: iconst_m1
    //   95: if_icmpeq +36 -> 131
    //   98: iconst_1
    //   99: istore_2
    //   100: iload_2
    //   101: ifne +27 -> 128
    //   104: aload_3
    //   105: new 264	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 267
    //   115: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 282	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy:access$debugThrow	(Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;Ljava/lang/String;)V
    //   128: aload_0
    //   129: monitorexit
    //   130: return
    //   131: iconst_0
    //   132: istore_2
    //   133: goto -33 -> 100
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	RunningProcessInfo
    //   0	141	1	paramBundle	android.os.Bundle
    //   99	34	2	i	int
    //   30	75	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	136	finally
    //   35	38	136	finally
    //   38	51	136	finally
    //   55	58	136	finally
    //   58	98	136	finally
    //   104	128	136	finally
  }
  
  /* Error */
  public final void removeApp(@NotNull AppIdentity paramAppIdentity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 114
    //   5: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   12: checkcast 149	java/util/List
    //   15: astore 4
    //   17: iconst_0
    //   18: istore_2
    //   19: aload 4
    //   21: invokeinterface 150 1 0
    //   26: astore 4
    //   28: aload 4
    //   30: invokeinterface 128 1 0
    //   35: ifeq +40 -> 75
    //   38: aload 4
    //   40: invokeinterface 132 1 0
    //   45: checkcast 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   48: invokevirtual 137	com/tencent/qqmini/sdk/server/launch/RunningApp:getId	()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;
    //   51: aload_1
    //   52: invokestatic 141	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   55: istore_3
    //   56: iload_3
    //   57: ifeq +11 -> 68
    //   60: iload_2
    //   61: iconst_m1
    //   62: if_icmpne +18 -> 80
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: istore_2
    //   72: goto -44 -> 28
    //   75: iconst_m1
    //   76: istore_2
    //   77: goto -17 -> 60
    //   80: aload_0
    //   81: getfield 98	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:apps	Ljava/util/LinkedList;
    //   84: iload_2
    //   85: invokevirtual 175	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   88: checkcast 134	com/tencent/qqmini/sdk/server/launch/RunningApp
    //   91: getstatic 285	com/tencent/qqmini/sdk/server/launch/RunningMiniAppState:STOPPED	Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;
    //   94: invokevirtual 169	com/tencent/qqmini/sdk/server/launch/RunningApp:setState	(Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;)V
    //   97: aload_0
    //   98: getstatic 117	com/tencent/qqmini/sdk/server/launch/RunningProcessState:RUNNING	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   101: putfield 105	com/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo:state	Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;
    //   104: goto -39 -> 65
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	RunningProcessInfo
    //   0	112	1	paramAppIdentity	AppIdentity
    //   18	67	2	i	int
    //   55	2	3	bool	boolean
    //   15	24	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	107	finally
    //   19	28	107	finally
    //   28	56	107	finally
    //   80	104	107	finally
  }
  
  public final void restoreRunningApps(@NotNull List<? extends MiniAppInfo> paramList)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramList, "runningApps");
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MiniAppInfo)((Iterator)localObject1).next();
        paramList.add(GameLaunchStrategy.Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)localObject2));
      }
      paramList = CollectionsKt.toSet((Iterable)paramList);
    }
    finally {}
    Object localObject2 = (Iterable)this.apps;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((RunningApp)((Iterator)localObject2).next()).getId());
    }
    localObject1 = (Iterable)SetsKt.minus(paramList, (Iterable)localObject1);
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = new RunningApp((AppIdentity)((Iterator)localObject1).next());
      ((RunningApp)localObject2).setState(RunningMiniAppState.BACKGROUND);
      paramList.add(localObject2);
    }
    paramList = (List)paramList;
    this.apps.addAll(0, (Collection)paramList);
  }
  
  public final void setMessenger(@Nullable Messenger paramMessenger)
  {
    this.messenger = paramMessenger;
  }
  
  @NotNull
  public final String toSimpleString()
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.config.processName;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "config.processName");
    ((StringBuilder)localObject1).append(StringsKt.substringAfter$default((String)localObject2, ":", null, 2, null));
    ((StringBuilder)localObject1).append(" ");
    localObject2 = this.state;
    switch (GameLaunchStrategy.RunningProcessInfo.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(CollectionsKt.joinToString$default((Iterable)this.apps, (CharSequence)", ", (CharSequence)"[ ", (CharSequence)" ]", 0, null, (Function1)GameLaunchStrategy.RunningProcessInfo.toSimpleString.1.1.INSTANCE, 24, null));
      localObject1 = ((StringBuilder)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
      return localObject1;
      ((StringBuilder)localObject1).append("🚀S");
      continue;
      ((StringBuilder)localObject1).append("😁R");
      continue;
      ((StringBuilder)localObject1).append("💾P");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy.RunningProcessInfo
 * JD-Core Version:    0.7.0.1
 */