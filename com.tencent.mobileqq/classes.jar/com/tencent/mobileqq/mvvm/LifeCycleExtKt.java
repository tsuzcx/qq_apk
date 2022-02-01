package com.tencent.mobileqq.mvvm;

import android.app.Application;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.BaseApplicationImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ofViewModelProvider", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "observe", "", "T", "Landroidx/lifecycle/LifecycleOwner;", "liveData", "Landroidx/lifecycle/LiveData;", "observer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class LifeCycleExtKt
{
  @NotNull
  public static final ViewModelProvider a(@NotNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    Intrinsics.checkParameterIsNotNull(paramViewModelStoreOwner, "owner");
    ViewModelProvider.AndroidViewModelFactory localAndroidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance((Application)BaseApplicationImpl.getApplication());
    Intrinsics.checkExpressionValueIsNotNull(localAndroidViewModelFactory, "ViewModelProvider.Androi…ionImpl.getApplication())");
    return a(paramViewModelStoreOwner, (ViewModelProvider.Factory)localAndroidViewModelFactory);
  }
  
  @NotNull
  public static final ViewModelProvider a(@NotNull ViewModelStoreOwner paramViewModelStoreOwner, @NotNull ViewModelProvider.Factory paramFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramViewModelStoreOwner, "owner");
    Intrinsics.checkParameterIsNotNull(paramFactory, "factory");
    return new ViewModelProvider(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
  
  public static final <T> void a(@NotNull LifecycleOwner paramLifecycleOwner, @NotNull LiveData<T> paramLiveData, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramLifecycleOwner, "$this$observe");
    Intrinsics.checkParameterIsNotNull(paramLiveData, "liveData");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "observer");
    paramLiveData.observe(paramLifecycleOwner, (Observer)new LifeCycleExtKt.observe.1(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.LifeCycleExtKt
 * JD-Core Version:    0.7.0.1
 */