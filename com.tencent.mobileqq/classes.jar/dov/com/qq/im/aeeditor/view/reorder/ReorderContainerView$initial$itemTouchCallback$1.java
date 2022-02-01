package dov.com.qq.im.aeeditor.view.reorder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.SimpleCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dov/com/qq/im/aeeditor/view/reorder/ReorderContainerView$initial$itemTouchCallback$1", "Lcom/tencent/widget/itemtouchhelper/ItemTouchHelper$SimpleCallback;", "interpolateOutOfBoundsScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewSize", "viewSizeOutOfBounds", "totalSize", "msSinceStartScroll", "", "isLongPressDragEnabled", "", "onMove", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "target", "onSelectedChanged", "", "actionState", "onSwiped", "direction", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView$initial$itemTouchCallback$1
  extends ItemTouchHelper.SimpleCallback
{
  ReorderContainerView$initial$itemTouchCallback$1(int paramInt1, int paramInt2)
  {
    super(paramInt2, i);
  }
  
  public int interpolateOutOfBoundsScroll(@Nullable RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return (int)Math.signum(paramInt2) * 5;
  }
  
  public boolean isLongPressDragEnabled()
  {
    return false;
  }
  
  public boolean onMove(@Nullable RecyclerView paramRecyclerView, @Nullable RecyclerView.ViewHolder paramViewHolder1, @Nullable RecyclerView.ViewHolder paramViewHolder2)
  {
    int j = -1;
    if (paramViewHolder1 != null) {}
    for (int i = paramViewHolder1.getAdapterPosition();; i = -1)
    {
      if (paramViewHolder2 != null) {
        j = paramViewHolder2.getAdapterPosition();
      }
      if ((j != 0) && (!(paramViewHolder2 instanceof ReorderContainerView.SpacingVH)) && (j != ReorderContainerView.a(this.a).getItemCount() - 1)) {
        break;
      }
      return false;
    }
    ReorderContainerView.a(this.a).a(i - 1, j - 1);
    ReorderContainerView.a(this.a).notifyItemMoved(i, j);
    ReorderContainerView.a(this.a, j - 1);
    if (paramViewHolder1 != null)
    {
      paramRecyclerView = paramViewHolder1.itemView;
      if (paramRecyclerView != null) {
        paramRecyclerView.performHapticFeedback(0, 2);
      }
    }
    return true;
  }
  
  public void onSelectedChanged(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
    switch (paramInt)
    {
    case 1: 
    default: 
    case 2: 
      do
      {
        do
        {
          return;
          ReorderContainerView.a(this.a, paramViewHolder);
          paramViewHolder = ReorderContainerView.a(this.a);
          if (paramViewHolder != null)
          {
            paramViewHolder = paramViewHolder.itemView;
            if (paramViewHolder != null) {
              paramViewHolder.setSelected(true);
            }
          }
          paramViewHolder = ReorderContainerView.a(this.a);
        } while (paramViewHolder == null);
        paramViewHolder = paramViewHolder.itemView;
      } while (paramViewHolder == null);
      paramViewHolder.performHapticFeedback(0, 2);
      return;
    }
    paramViewHolder = ReorderContainerView.a(this.a);
    if (paramViewHolder != null)
    {
      paramViewHolder = paramViewHolder.itemView;
      if (paramViewHolder != null) {
        paramViewHolder.setSelected(false);
      }
    }
    ReorderContainerView.a(this.a, (RecyclerView.ViewHolder)null);
    paramViewHolder = ReorderContainerView.a(this.a);
    if (paramViewHolder != null)
    {
      ReorderListener localReorderListener = this.a.a();
      if (localReorderListener != null) {
        localReorderListener.a(paramViewHolder, ReorderContainerView.a(this.a));
      }
    }
    ReorderContainerView.a(this.a, (String)null);
    ReorderContainerView.a(this.a, -1);
  }
  
  public void onSwiped(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView.initial.itemTouchCallback.1
 * JD-Core Version:    0.7.0.1
 */