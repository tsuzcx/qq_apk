package com.tencent.qqmini.sdk.server.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.VisibleForTesting;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;", "", "()V", "TAG", "", "createLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "config", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "process", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;", "appId", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "createLaunchIntent$lib_miniserver_internalRelease", "findExistedProcessForGame", "game", "runningProcesses", "", "findExistedProcessForGame$lib_miniserver_internalRelease", "findProcessForLaunch", "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "processConfig", "findProcessForLaunch$lib_miniserver_internalRelease", "findProcessToClean", "findProcessToClean$lib_miniserver_internalRelease", "findProcessToPreload", "findProcessToPreload$lib_miniserver_internalRelease", "getOrPutFist", "T", "", "condition", "Lkotlin/Function1;", "", "factory", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "moveToFront", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "toId", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;", "toId$lib_miniserver_internalRelease", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameLaunchStrategy$Companion
{
  private final <T> T getOrPutFist(@NotNull List<T> paramList, Function1<? super T, Boolean> paramFunction1, Function0<? extends T> paramFunction0)
  {
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
      {
        paramFunction1 = localObject;
        break label55;
      }
    }
    paramFunction1 = null;
    label55:
    if (paramFunction1 != null) {
      return paramFunction1;
    }
    paramFunction1 = paramFunction0.invoke();
    paramList.add(0, paramFunction1);
    return paramFunction1;
  }
  
  private final <T> void moveToFront(@NotNull List<T> paramList, T paramT)
  {
    paramList.remove(paramT);
    paramList.add(0, paramT);
  }
  
  @VisibleForTesting
  @NotNull
  public final Intent createLaunchIntent$lib_miniserver_internalRelease(@NotNull Context paramContext, @NotNull GameLaunchConfig paramGameLaunchConfig, @NotNull GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo, @NotNull AppIdentity paramAppIdentity)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramGameLaunchConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramRunningProcessInfo, "process");
    Intrinsics.checkParameterIsNotNull(paramAppIdentity, "appId");
    paramContext = new Intent(paramContext, paramRunningProcessInfo.getConfig().appUIClass);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext.addFlags(524288);
      paramContext.addFlags(8192);
      paramContext.addFlags(268435456);
      paramContext.setData(paramAppIdentity.getUri());
      return paramContext;
    }
    paramContext.addFlags(536870912);
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  @VisibleForTesting
  @Nullable
  public final GameLaunchStrategy.RunningProcessInfo findExistedProcessForGame$lib_miniserver_internalRelease(@NotNull AppIdentity paramAppIdentity, @NotNull List<GameLaunchStrategy.RunningProcessInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramAppIdentity, "game");
    Intrinsics.checkParameterIsNotNull(paramList, "runningProcesses");
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (((GameLaunchStrategy.RunningProcessInfo)paramList).has(paramAppIdentity))
      {
        paramAppIdentity = paramList;
        break label56;
      }
    }
    paramAppIdentity = null;
    label56:
    return (GameLaunchStrategy.RunningProcessInfo)paramAppIdentity;
  }
  
  @VisibleForTesting
  @NotNull
  public final MiniProcessorConfig findProcessForLaunch$lib_miniserver_internalRelease(@NotNull List<? extends MiniProcessorConfig> paramList, @NotNull List<GameLaunchStrategy.RunningProcessInfo> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "processConfig");
    Intrinsics.checkParameterIsNotNull(paramList1, "runningProcesses");
    if (paramList1.isEmpty()) {
      return (MiniProcessorConfig)CollectionsKt.first(paramList);
    }
    Iterable localIterable = (Iterable)paramList1;
    Iterator localIterator = ((Iterable)CollectionsKt.sortedWith(localIterable, (Comparator)new GameLaunchStrategy.Companion.findProcessForLaunch..inlined.sortedByDescending.1())).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((((GameLaunchStrategy.RunningProcessInfo)localObject).getFull() ^ true)) {
        break label95;
      }
    }
    Object localObject = null;
    label95:
    localObject = (GameLaunchStrategy.RunningProcessInfo)localObject;
    if (localObject != null) {
      return ((GameLaunchStrategy.RunningProcessInfo)localObject).getConfig();
    }
    if (paramList1.size() < paramList.size())
    {
      paramList = (Iterable)CollectionsKt.toSet((Iterable)paramList);
      paramList1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(localIterable, 10));
      localObject = localIterable.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList1.add(((GameLaunchStrategy.RunningProcessInfo)((Iterator)localObject).next()).getConfig());
      }
      return (MiniProcessorConfig)CollectionsKt.first((Iterable)CollectionsKt.subtract(paramList, (Iterable)CollectionsKt.toSet((Iterable)paramList1)));
    }
    paramList = (Throwable)new IllegalStateException("all process are full, no idle process available");
    for (;;)
    {
      throw paramList;
    }
  }
  
  @VisibleForTesting
  @Nullable
  public final GameLaunchStrategy.RunningProcessInfo findProcessToClean$lib_miniserver_internalRelease(@NotNull List<? extends MiniProcessorConfig> paramList, @NotNull List<GameLaunchStrategy.RunningProcessInfo> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "processConfig");
    Intrinsics.checkParameterIsNotNull(paramList1, "runningProcesses");
    if (paramList1.size() == paramList.size())
    {
      paramList = (Iterable)paramList1;
      boolean bool = paramList instanceof Collection;
      int j = 1;
      int i;
      if ((bool) && (((Collection)paramList).isEmpty()))
      {
        i = j;
      }
      else
      {
        paramList = paramList.iterator();
        do
        {
          i = j;
          if (!paramList.hasNext()) {
            break;
          }
        } while (((GameLaunchStrategy.RunningProcessInfo)paramList.next()).getFull());
        i = 0;
      }
      if (i != 0) {
        return (GameLaunchStrategy.RunningProcessInfo)CollectionsKt.last(paramList1);
      }
    }
    return null;
  }
  
  @VisibleForTesting
  @Nullable
  public final MiniProcessorConfig findProcessToPreload$lib_miniserver_internalRelease(@NotNull List<? extends MiniProcessorConfig> paramList, @NotNull List<GameLaunchStrategy.RunningProcessInfo> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "processConfig");
    Intrinsics.checkParameterIsNotNull(paramList1, "runningProcesses");
    Object localObject = (Iterable)paramList1;
    boolean bool = localObject instanceof Collection;
    int j = 1;
    int i;
    if ((bool) && (((Collection)localObject).isEmpty()))
    {
      i = j;
    }
    else
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((GameLaunchStrategy.RunningProcessInfo)localIterator.next()).getFull());
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    if (paramList1.size() == paramList.size()) {
      return null;
    }
    paramList = (Iterable)CollectionsKt.toSet((Iterable)paramList);
    paramList1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList1.add(((GameLaunchStrategy.RunningProcessInfo)((Iterator)localObject).next()).getConfig());
    }
    return (MiniProcessorConfig)CollectionsKt.first((Iterable)CollectionsKt.subtract(paramList, (Iterable)CollectionsKt.toSet((Iterable)paramList1)));
  }
  
  @VisibleForTesting
  @NotNull
  public final AppIdentity toId$lib_miniserver_internalRelease(@NotNull MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramMiniAppBaseInfo, "$this$toId");
    String str = paramMiniAppBaseInfo.appId;
    Intrinsics.checkExpressionValueIsNotNull(str, "appId");
    return new AppIdentity(str, paramMiniAppBaseInfo.verType, paramMiniAppBaseInfo.version, paramMiniAppBaseInfo.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy.Companion
 * JD-Core Version:    0.7.0.1
 */