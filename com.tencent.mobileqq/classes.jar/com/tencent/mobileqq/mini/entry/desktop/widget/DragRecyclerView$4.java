package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import blsk;
import com.tencent.qphone.base.util.QLog;

class DragRecyclerView$4
  extends blsk
{
  DragRecyclerView$4(DragRecyclerView paramDragRecyclerView) {}
  
  public boolean canDropOver(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (DragRecyclerView.access$000(this.this$0) != null) {
      return DragRecyclerView.access$000(this.this$0).isItemDropable(paramViewHolder2.getAdapterPosition());
    }
    return super.canDropOver(paramRecyclerView, paramViewHolder1, paramViewHolder2);
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("DragRecycleView", 1, "clearView");
    super.clearView(paramRecyclerView, paramViewHolder);
    DragRecyclerView.access$302(this.this$0, false);
  }
  
  public long getAnimationDuration(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
  {
    return super.getAnimationDuration(paramRecyclerView, paramInt, paramFloat1, paramFloat2);
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return makeMovementFlags(15, 0);
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return false;
  }
  
  public boolean isLongPressDragEnabled()
  {
    return false;
  }
  
  public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      paramFloat2 = Math.abs(paramFloat1) / paramViewHolder.itemView.getWidth();
      paramViewHolder.itemView.setAlpha(1.0F - paramFloat2);
      paramViewHolder.itemView.setTranslationX(paramFloat1);
      return;
    }
    super.onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    int i = paramViewHolder1.getAdapterPosition();
    int j = paramViewHolder2.getAdapterPosition();
    if ((i >= 0) && (j >= 0) && (DragRecyclerView.access$000(this.this$0) != null)) {
      DragRecyclerView.access$000(this.this$0).onItemMoved(i, j);
    }
    return false;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.4
 * JD-Core Version:    0.7.0.1
 */