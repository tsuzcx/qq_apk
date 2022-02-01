package com.tencent.qqmini.sdk.server.launch;

import android.os.Bundle;
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
  
  public final void addApp(@NotNull AppIdentity paramAppIdentity)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramAppIdentity, "app");
      this.state = RunningProcessState.RUNNING;
      Iterator localIterator = ((Iterable)this.apps).iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        boolean bool = Intrinsics.areEqual(((RunningApp)localObject).getId(), paramAppIdentity);
        if (bool) {
          break label68;
        }
      }
      Object localObject = null;
      label68:
      if (localObject != null) {
        return;
      }
      this.apps.addFirst(new RunningApp(paramAppIdentity));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAppIdentity;
    }
  }
  
  public final void appBackground(@NotNull AppIdentity paramAppIdentity)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramAppIdentity, "app");
      localObject = (List)this.apps;
      i = 0;
      localObject = ((List)localObject).iterator();
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          throw paramAppIdentity;
        }
        i += 1;
        continue;
        int i = -1;
      }
    }
    if (((Iterator)localObject).hasNext()) {
      if (Intrinsics.areEqual(((RunningApp)((Iterator)localObject).next()).getId(), paramAppIdentity))
      {
        if (i != -1)
        {
          paramAppIdentity = this.apps.get(i);
          Intrinsics.checkExpressionValueIsNotNull(paramAppIdentity, "apps[index]");
          paramAppIdentity = (RunningApp)paramAppIdentity;
        }
        else
        {
          paramAppIdentity = new RunningApp(paramAppIdentity);
          this.apps.addLast(paramAppIdentity);
        }
        paramAppIdentity.setState(RunningMiniAppState.BACKGROUND);
        this.state = RunningProcessState.RUNNING;
        return;
      }
    }
  }
  
  public final void appForeground(@NotNull AppIdentity paramAppIdentity)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramAppIdentity, "app");
      localObject = (List)this.apps;
      i = 0;
      localObject = ((List)localObject).iterator();
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          throw paramAppIdentity;
        }
        i += 1;
        continue;
        int i = -1;
      }
    }
    if (((Iterator)localObject).hasNext()) {
      if (Intrinsics.areEqual(((RunningApp)((Iterator)localObject).next()).getId(), paramAppIdentity))
      {
        if (i != -1)
        {
          paramAppIdentity = this.apps.remove(i);
          Intrinsics.checkExpressionValueIsNotNull(paramAppIdentity, "apps.removeAt(index)");
          paramAppIdentity = (RunningApp)paramAppIdentity;
          this.apps.addFirst(paramAppIdentity);
        }
        else
        {
          paramAppIdentity = new RunningApp(paramAppIdentity);
          this.apps.addFirst(paramAppIdentity);
        }
        this.state = RunningProcessState.RUNNING;
        paramAppIdentity.setState(RunningMiniAppState.FOREGROUND);
        return;
      }
    }
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
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!Intrinsics.areEqual(((RunningApp)((Iterator)localObject).next()).getId(), paramAppIdentity));
    bool1 = true;
    return bool1;
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
  
  public final void onProcessStarted(@NotNull Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
        if (this.deathNotifier == null)
        {
          paramBundle.setClassLoader(ProcessDeathNotifier.class.getClassLoader());
          Object localObject = paramBundle.getParcelable("CLIENT_PROCESS_DEATH_NOTIFIER");
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          this.deathNotifier = ((ProcessDeathNotifier)localObject);
          localObject = this.deathNotifier;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((ProcessDeathNotifier)localObject).observeDeath((Runnable)new GameLaunchStrategy.RunningProcessInfo.onProcessStarted.1(this));
          this.pid = paramBundle.getInt("CLIENT_PROCESS_PID", -1);
          localObject = this.this$0;
          if (this.pid == -1) {
            break label149;
          }
          i = 1;
          if (i == 0)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("can't get pid from bundle ");
            localStringBuilder.append(paramBundle);
            GameLaunchStrategy.access$debugThrow((GameLaunchStrategy)localObject, localStringBuilder.toString());
          }
        }
        return;
      }
      finally {}
      label149:
      int i = 0;
    }
  }
  
  public final void removeApp(@NotNull AppIdentity paramAppIdentity)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramAppIdentity, "app");
      Object localObject = (List)this.apps;
      int i = 0;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        boolean bool = Intrinsics.areEqual(((RunningApp)((Iterator)localObject).next()).getId(), paramAppIdentity);
        if (bool) {
          break label72;
        }
        i += 1;
      }
      i = -1;
      label72:
      if (i == -1) {
        return;
      }
      ((RunningApp)this.apps.remove(i)).setState(RunningMiniAppState.STOPPED);
      this.state = RunningProcessState.RUNNING;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAppIdentity;
    }
  }
  
  public final void restoreRunningApps(@NotNull List<? extends MiniAppInfo> paramList)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramList, "runningApps");
      Object localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MiniAppInfo)((Iterator)localObject1).next();
        paramList.add(GameLaunchStrategy.Companion.toId$lib_miniserver_internalRelease((MiniAppBaseInfo)localObject2));
      }
      paramList = CollectionsKt.toSet((Iterable)paramList);
      Object localObject2 = (Iterable)this.apps;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
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
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
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
    int i = GameLaunchStrategy.RunningProcessInfo.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          ((StringBuilder)localObject1).append("💾P");
        }
      }
      else {
        ((StringBuilder)localObject1).append("😁R");
      }
    }
    else {
      ((StringBuilder)localObject1).append("🚀S");
    }
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(CollectionsKt.joinToString$default((Iterable)this.apps, (CharSequence)", ", (CharSequence)"[ ", (CharSequence)" ]", 0, null, (Function1)GameLaunchStrategy.RunningProcessInfo.toSimpleString.1.1.INSTANCE, 24, null));
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy.RunningProcessInfo
 * JD-Core Version:    0.7.0.1
 */