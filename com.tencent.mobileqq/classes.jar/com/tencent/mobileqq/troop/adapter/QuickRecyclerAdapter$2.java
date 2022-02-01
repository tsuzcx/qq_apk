package com.tencent.mobileqq.troop.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QuickRecyclerAdapter$2
  implements View.OnClickListener
{
  QuickRecyclerAdapter$2(QuickRecyclerAdapter paramQuickRecyclerAdapter, ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.b.h != null)
    {
      int i = this.a.getAdapterPosition();
      this.b.h.a(paramView, this.a, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.2
 * JD-Core Version:    0.7.0.1
 */