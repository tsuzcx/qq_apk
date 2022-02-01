package com.tencent.mobileqq.kandian.biz.xtab.badge;

import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/RIJXTabBadgeDispatcher;", "", "()V", "CHANGER_LISTENERS", "", "Lkotlin/Function0;", "", "getCHANGER_LISTENERS", "()Ljava/util/List;", "CHANGER_LISTENERS$delegate", "Lkotlin/Lazy;", "addListener", "listener", "notifyChange", "removeListener", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBadgeDispatcher
{
  public static final RIJXTabBadgeDispatcher a = new RIJXTabBadgeDispatcher();
  private static final Lazy b = LazyKt.lazy((Function0)RIJXTabBadgeDispatcher.CHANGER_LISTENERS.2.INSTANCE);
  
  @JvmStatic
  public static final void a()
  {
    try
    {
      Iterator localIterator = ((Iterable)a.b()).iterator();
      while (localIterator.hasNext()) {
        ((Function0)localIterator.next()).invoke();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private final List<Function0<Unit>> b()
  {
    return (List)b.getValue();
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramFunction0, "listener");
      if (!b().contains(paramFunction0)) {
        b().add(paramFunction0);
      }
      return;
    }
    finally
    {
      paramFunction0 = finally;
      throw paramFunction0;
    }
  }
  
  public final boolean b(@NotNull Function0<Unit> paramFunction0)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramFunction0, "listener");
      boolean bool = b().remove(paramFunction0);
      return bool;
    }
    finally
    {
      paramFunction0 = finally;
      throw paramFunction0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeDispatcher
 * JD-Core Version:    0.7.0.1
 */