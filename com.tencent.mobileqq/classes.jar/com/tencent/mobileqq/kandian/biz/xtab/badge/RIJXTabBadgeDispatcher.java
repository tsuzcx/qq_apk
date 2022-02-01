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
  public static final RIJXTabBadgeDispatcher a;
  private static final Lazy a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizXtabBadgeRIJXTabBadgeDispatcher = new RIJXTabBadgeDispatcher();
    jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJXTabBadgeDispatcher.CHANGER_LISTENERS.2.INSTANCE);
  }
  
  private final List<Function0<Unit>> a()
  {
    return (List)jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @JvmStatic
  public static final void a()
  {
    try
    {
      Iterator localIterator = ((Iterable)jdField_a_of_type_ComTencentMobileqqKandianBizXtabBadgeRIJXTabBadgeDispatcher.a()).iterator();
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
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramFunction0, "listener");
      if (!a().contains(paramFunction0)) {
        a().add(paramFunction0);
      }
      return;
    }
    finally
    {
      paramFunction0 = finally;
      throw paramFunction0;
    }
  }
  
  public final boolean a(@NotNull Function0<Unit> paramFunction0)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramFunction0, "listener");
      boolean bool = a().remove(paramFunction0);
      return bool;
    }
    finally
    {
      paramFunction0 = finally;
      throw paramFunction0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeDispatcher
 * JD-Core Version:    0.7.0.1
 */