package com.tencent.mobileqq.mini.common.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter$performSetLoadingMoreVisible$1", "Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;", "onShow", "", "view", "Landroid/view/View;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class LoadingMoreRecyclerAdapter$performSetLoadingMoreVisible$1
  implements RecyclerWrapperAdapter.OnShowListener
{
  public void onShow(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.this$0.onLoadFooterShown$qqmini_impl_release(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter.performSetLoadingMoreVisible.1
 * JD-Core Version:    0.7.0.1
 */