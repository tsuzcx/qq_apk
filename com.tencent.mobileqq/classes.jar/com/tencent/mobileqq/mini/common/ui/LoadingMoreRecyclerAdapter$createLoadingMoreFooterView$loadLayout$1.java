package com.tencent.mobileqq.mini.common.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run"}, k=3, mv={1, 1, 16})
final class LoadingMoreRecyclerAdapter$createLoadingMoreFooterView$loadLayout$1
  implements Runnable
{
  LoadingMoreRecyclerAdapter$createLoadingMoreFooterView$loadLayout$1(LoadingMoreRecyclerAdapter paramLoadingMoreRecyclerAdapter, Ref.ObjectRef paramObjectRef) {}
  
  public final void run()
  {
    LoadingMoreRecyclerAdapter localLoadingMoreRecyclerAdapter = this.this$0;
    LoadLayout localLoadLayout = (LoadLayout)this.$view.element;
    if (localLoadLayout == null) {
      Intrinsics.throwNpe();
    }
    localLoadingMoreRecyclerAdapter.onLoadFooterShown$qqmini_impl_release((View)localLoadLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter.createLoadingMoreFooterView.loadLayout.1
 * JD-Core Version:    0.7.0.1
 */