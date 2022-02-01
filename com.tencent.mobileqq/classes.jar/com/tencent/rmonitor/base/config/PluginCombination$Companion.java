package com.tencent.rmonitor.base.config;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/PluginCombination$Companion;", "", "()V", "allPlugin", "", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "getAllPlugin", "()Ljava/util/List;", "austerityPlugins", "batteryPlugin", "bigBitmapPlugin", "ceilingHprofPlugin", "ceilingValuePlugin", "dbPlugin", "devicePlugin", "dropFramePlugin", "fdLeakPlugin", "ioPlugin", "leakPlugin", "loopStackPlugin", "loosePlugins", "getLoosePlugins$rmonitor_base_release", "modeAll", "", "getModeAll", "()I", "modeAll$delegate", "Lkotlin/Lazy;", "modeStable", "getModeStable", "modeStable$delegate", "natMemPlugin", "resourcePlugin", "stablePlugins", "statisticsPlugin", "each", "block", "Lkotlin/Function1;", "getPluginConfig", "plugin", "handle", "isAusterityPlugin", "", "isLoosePlugin", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class PluginCombination$Companion
{
  @Nullable
  public final Object a(int paramInt, @NotNull Function1<? super DefaultPluginConfig, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    Iterator localIterator1 = ((Iterable)CollectionsKt.listOf(new List[] { PluginCombination.e(), ((Companion)this).d() })).iterator();
    Object localObject1 = null;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
      {
        localObject2 = localIterator2.next();
        int i;
        if (((DefaultPluginConfig)localObject2).a == paramInt) {
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
  
  @Nullable
  public final Object a(@NotNull Function1<? super DefaultPluginConfig, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    Iterator localIterator1 = ((Iterable)CollectionsKt.listOf(new List[] { PluginCombination.e(), ((Companion)this).d() })).iterator();
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
  public final List<DefaultPluginConfig> a()
  {
    return PluginCombination.a();
  }
  
  public final boolean a(int paramInt)
  {
    Object localObject = (Iterable)PluginCombination.e();
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
      if (((DefaultPluginConfig)((Iterator)localObject).next()).a == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    bool1 = true;
    return bool1;
  }
  
  public final int b()
  {
    Lazy localLazy = PluginCombination.b();
    Object localObject = PluginCombination.a;
    localObject = a[0];
    return ((Number)localLazy.getValue()).intValue();
  }
  
  public final boolean b(int paramInt)
  {
    Object localObject = (Iterable)((Companion)this).d();
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
      if (((DefaultPluginConfig)((Iterator)localObject).next()).a == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    bool1 = true;
    return bool1;
  }
  
  public final int c()
  {
    Lazy localLazy = PluginCombination.c();
    Object localObject = PluginCombination.a;
    localObject = a[1];
    return ((Number)localLazy.getValue()).intValue();
  }
  
  @JvmStatic
  @Nullable
  public final DefaultPluginConfig c(int paramInt)
  {
    Iterator localIterator = ((Iterable)CollectionsKt.plus((Collection)PluginCombination.e(), (Iterable)((Companion)this).d())).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      int i;
      if (((DefaultPluginConfig)localObject).a == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label74;
      }
    }
    Object localObject = null;
    label74:
    return (DefaultPluginConfig)localObject;
  }
  
  @NotNull
  public final List<DefaultPluginConfig> d()
  {
    return PluginCombination.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.PluginCombination.Companion
 * JD-Core Version:    0.7.0.1
 */