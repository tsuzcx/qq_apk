package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$initial$itemTouchCallback$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ItemTouchHelper$SimpleCallback;", "isLongPressDragEnabled", "", "onMove", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "target", "onSelectedChanged", "", "actionState", "", "onSwiped", "direction", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView$initial$itemTouchCallback$1
  extends ItemTouchHelper.SimpleCallback
{
  ReorderContainerView$initial$itemTouchCallback$1(int paramInt1, int paramInt2)
  {
    super(paramInt2, i);
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return;
      }
      ReorderContainerView.a(this.a, paramViewHolder);
      paramViewHolder = ReorderContainerView.c(this.a);
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.itemView;
        if (paramViewHolder != null) {
          paramViewHolder.setSelected(true);
        }
      }
      paramViewHolder = ReorderContainerView.c(this.a);
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.itemView;
        if (paramViewHolder != null) {
          paramViewHolder.performHapticFeedback(0, 2);
        }
      }
    }
    else
    {
      paramViewHolder = ReorderContainerView.c(this.a);
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.itemView;
        if (paramViewHolder != null) {
          paramViewHolder.setSelected(false);
        }
      }
      ReorderContainerView.a(this.a, (RecyclerView.ViewHolder)null);
      paramViewHolder = ReorderContainerView.d(this.a);
      if (paramViewHolder != null)
      {
        ReorderListener localReorderListener = this.a.getReorderListener();
        if (localReorderListener != null) {
          localReorderListener.a(paramViewHolder, ReorderContainerView.b(this.a));
        }
      }
      ReorderContainerView.a(this.a, (String)null);
      ReorderContainerView.a(this.a, -1);
    }
  }
  
  public boolean b(@NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.ViewHolder paramViewHolder1, @NotNull RecyclerView.ViewHolder paramViewHolder2)
  {
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "recyclerView");
    Intrinsics.checkParameterIsNotNull(paramViewHolder1, "viewHolder");
    Intrinsics.checkParameterIsNotNull(paramViewHolder2, "target");
    int i = paramViewHolder1.getAdapterPosition();
    int j = paramViewHolder2.getAdapterPosition();
    if ((j != 0) && (!(paramViewHolder2 instanceof ReorderContainerView.SpacingVH)))
    {
      if (j == ReorderContainerView.a(this.a).getItemCount() - 1) {
        return false;
      }
      paramRecyclerView = ReorderContainerView.a(this.a);
      int k = j - 1;
      paramRecyclerView.a(i - 1, k);
      ReorderContainerView.a(this.a).notifyItemMoved(i, j);
      ReorderContainerView.a(this.a, k);
      paramViewHolder1.itemView.performHapticFeedback(0, 2);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView.initial.itemTouchCallback.1
 * JD-Core Version:    0.7.0.1
 */