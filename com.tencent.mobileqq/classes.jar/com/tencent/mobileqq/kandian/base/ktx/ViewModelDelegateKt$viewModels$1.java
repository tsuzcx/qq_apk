package com.tencent.mobileqq.kandian.base.ktx;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k=3, mv={1, 1, 16})
public final class ViewModelDelegateKt$viewModels$1
  extends Lambda
  implements Function0<ViewModelStore>
{
  public ViewModelDelegateKt$viewModels$1(ComponentActivity paramComponentActivity)
  {
    super(0);
  }
  
  @NotNull
  public final ViewModelStore invoke()
  {
    ViewModelStore localViewModelStore = this.$this_viewModels.getViewModelStore();
    Intrinsics.checkExpressionValueIsNotNull(localViewModelStore, "viewModelStore");
    return localViewModelStore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewModelDelegateKt.viewModels.1
 * JD-Core Version:    0.7.0.1
 */