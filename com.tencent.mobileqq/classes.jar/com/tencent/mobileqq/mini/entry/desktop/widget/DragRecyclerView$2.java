package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;

class DragRecyclerView$2
  extends OnRecyclerItemClickListener
{
  DragRecyclerView$2(DragRecyclerView paramDragRecyclerView1, DragRecyclerView paramDragRecyclerView2)
  {
    super(paramDragRecyclerView2);
  }
  
  public void onItemClick(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onItemLongPress(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return;
    }
    boolean bool;
    if (DragRecyclerView.access$000(this.this$0) != null) {
      bool = DragRecyclerView.access$000(this.this$0).isItemDragable(paramViewHolder.getAdapterPosition());
    } else {
      bool = false;
    }
    if (bool) {
      DragRecyclerView.access$100(this.this$0, paramViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.2
 * JD-Core Version:    0.7.0.1
 */