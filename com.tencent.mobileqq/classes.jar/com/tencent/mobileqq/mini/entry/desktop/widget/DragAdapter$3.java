package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

class DragAdapter$3
  implements Runnable
{
  DragAdapter$3(DragAdapter paramDragAdapter, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    RecyclerView.ViewHolder localViewHolder = this.val$tempDragVh;
    if (localViewHolder != null) {
      localViewHolder.itemView.setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.3
 * JD-Core Version:    0.7.0.1
 */