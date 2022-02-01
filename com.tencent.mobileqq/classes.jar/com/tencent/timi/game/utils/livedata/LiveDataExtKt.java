package com.tencent.timi.game.utils.livedata;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getNonNull", "T", "Landroidx/lifecycle/LiveData;", "default", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;)Ljava/lang/Object;", "observeNonNull", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lkotlin/Function1;", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class LiveDataExtKt
{
  public static final <T> T a(@NotNull LiveData<T> paramLiveData, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveData, "$this$getNonNull");
    paramLiveData = paramLiveData.getValue();
    if (paramLiveData != null) {
      return paramLiveData;
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.livedata.LiveDataExtKt
 * JD-Core Version:    0.7.0.1
 */