package com.tencent.mobileqq.kandian.base.ktx;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider.Factory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k=3, mv={1, 1, 16})
public final class ViewModelDelegateKt$viewModels$factoryPromise$1
  extends Lambda
  implements Function0<ViewModelProvider.Factory>
{
  public ViewModelDelegateKt$viewModels$factoryPromise$1(ComponentActivity paramComponentActivity)
  {
    super(0);
  }
  
  @NotNull
  public final ViewModelProvider.Factory invoke()
  {
    ViewModelProvider.Factory localFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
    Intrinsics.checkExpressionValueIsNotNull(localFactory, "defaultViewModelProviderFactory");
    return localFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewModelDelegateKt.viewModels.factoryPromise.1
 * JD-Core Version:    0.7.0.1
 */