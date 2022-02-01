package com.tencent.mobileqq.troop.adapter;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;

class QuickRecyclerAdapter$3
  implements View.OnLongClickListener
{
  QuickRecyclerAdapter$3(QuickRecyclerAdapter paramQuickRecyclerAdapter, ViewHolder paramViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.b.h != null)
    {
      int i = this.a.getAdapterPosition();
      return this.b.h.b(paramView, this.a, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.3
 * JD-Core Version:    0.7.0.1
 */