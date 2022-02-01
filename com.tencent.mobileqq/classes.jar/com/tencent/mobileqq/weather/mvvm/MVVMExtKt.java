package com.tencent.mobileqq.weather.mvvm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"observe", "", "T", "Landroidx/lifecycle/LifecycleOwner;", "liveData", "Landroidx/lifecycle/LiveData;", "observer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "postNext", "Landroidx/lifecycle/MutableLiveData;", "nextValue", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "setNext", "qq-weather-impl_release"}, k=2, mv={1, 1, 16})
public final class MVVMExtKt
{
  public static final <T> void a(@NotNull LifecycleOwner paramLifecycleOwner, @NotNull LiveData<T> paramLiveData, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramLifecycleOwner, "$this$observe");
    Intrinsics.checkParameterIsNotNull(paramLiveData, "liveData");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "observer");
    paramLiveData.observe(paramLifecycleOwner, (Observer)new MVVMExtKt.observe.1(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.mvvm.MVVMExtKt
 * JD-Core Version:    0.7.0.1
 */