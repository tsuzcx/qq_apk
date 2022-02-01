package com.tencent.mobileqq.mini.common.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$SimpleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mOnShowListener", "Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;", "(Landroid/view/View;Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;)V", "onShow", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
final class RecyclerWrapperAdapter$SimpleViewHolder
  extends RecyclerView.ViewHolder
{
  private final RecyclerWrapperAdapter.OnShowListener mOnShowListener;
  
  public RecyclerWrapperAdapter$SimpleViewHolder(@NotNull View paramView, @Nullable RecyclerWrapperAdapter.OnShowListener paramOnShowListener)
  {
    super(paramView);
    this.mOnShowListener = paramOnShowListener;
  }
  
  public final void onShow()
  {
    RecyclerWrapperAdapter.OnShowListener localOnShowListener = this.mOnShowListener;
    if (localOnShowListener != null)
    {
      View localView = this.itemView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "itemView");
      localOnShowListener.onShow(localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter.SimpleViewHolder
 * JD-Core Version:    0.7.0.1
 */