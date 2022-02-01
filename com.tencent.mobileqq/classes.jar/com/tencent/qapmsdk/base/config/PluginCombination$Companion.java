package com.tencent.qapmsdk.base.config;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/PluginCombination$Companion;", "", "()V", "anrPlugin", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "austerityPlugins", "", "bigBitmapPlugin", "ceilingHprofPlugin", "ceilingValuePlugin", "crashPlugin", "dbPlugin", "devicePlugin", "dropFramePlugin", "httpPlugin", "ioPlugin", "jsErrorPlugin", "leakPlugin", "loopStackPlugin", "loosePlugins", "getLoosePlugins$qapmbase_release", "()Ljava/util/List;", "modeAll", "", "getModeAll", "()I", "modeAll$delegate", "Lkotlin/Lazy;", "modeStable", "getModeStable", "modeStable$delegate", "qqBatteryPlugin", "resourcePlugin", "stablePlugins", "startUpPlugin", "statisticsPlugin", "userBreadCrumbPlugin", "webViewPlugin", "each", "block", "Lkotlin/Function1;", "handle", "plugin", "isAusterityPlugin", "", "isLoosePlugin", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class PluginCombination$Companion
{
  @Nullable
  public final Object each(@NotNull Function1<? super DefaultPluginConfig, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    Iterator localIterator1 = ((Iterable)CollectionsKt.listOf(new List[] { PluginCombination.access$getAusterityPlugins$cp(), ((Companion)this).getLoosePlugins$qapmbase_release() })).iterator();
    Object localObject = null;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        localObject = paramFunction1.invoke((DefaultPluginConfig)localIterator2.next());
      }
    }
    return localObject;
  }
  
  @NotNull
  public final List<DefaultPluginConfig> getLoosePlugins$qapmbase_release()
  {
    return PluginCombination.access$getLoosePlugins$cp();
  }
  
  public final int getModeAll()
  {
    Lazy localLazy = PluginCombination.access$getModeAll$cp();
    Object localObject = PluginCombination.Companion;
    localObject = $$delegatedProperties[0];
    return ((Number)localLazy.getValue()).intValue();
  }
  
  public final int getModeStable()
  {
    Lazy localLazy = PluginCombination.access$getModeStable$cp();
    Object localObject = PluginCombination.Companion;
    localObject = $$delegatedProperties[1];
    return ((Number)localLazy.getValue()).intValue();
  }
  
  @Nullable
  public final Object handle(int paramInt, @NotNull Function1<? super DefaultPluginConfig, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    Iterator localIterator1 = ((Iterable)CollectionsKt.listOf(new List[] { PluginCombination.access$getAusterityPlugins$cp(), ((Companion)this).getLoosePlugins$qapmbase_release() })).iterator();
    Object localObject1 = null;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
      {
        localObject2 = localIterator2.next();
        int i;
        if (((DefaultPluginConfig)localObject2).plugin == paramInt) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label120;
        }
      }
      Object localObject2 = null;
      label120:
      localObject2 = (DefaultPluginConfig)localObject2;
      if (localObject2 != null) {
        localObject1 = paramFunction1.invoke(localObject2);
      }
    }
    return localObject1;
  }
  
  public final boolean isAusterityPlugin(int paramInt)
  {
    Object localObject = (Iterable)PluginCombination.access$getAusterityPlugins$cp();
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      if (((DefaultPluginConfig)((Iterator)localObject).next()).plugin == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    bool1 = true;
    return bool1;
  }
  
  public final boolean isLoosePlugin(int paramInt)
  {
    Object localObject = (Iterable)((Companion)this).getLoosePlugins$qapmbase_release();
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      if (((DefaultPluginConfig)((Iterator)localObject).next()).plugin == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    bool1 = true;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.PluginCombination.Companion
 * JD-Core Version:    0.7.0.1
 */