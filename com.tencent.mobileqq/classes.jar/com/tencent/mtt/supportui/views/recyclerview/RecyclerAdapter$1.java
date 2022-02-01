package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecyclerAdapter$1
  implements View.OnClickListener
{
  RecyclerAdapter$1(RecyclerAdapter paramRecyclerAdapter, RecyclerView.ViewHolderWrapper paramViewHolderWrapper) {}
  
  public void onClick(View paramView)
  {
    if (((paramView instanceof RecyclerViewItem)) && (this.this$0.mRecyclerViewItemListener != null)) {
      this.this$0.mRecyclerViewItemListener.onItemClick(this.val$holder.itemView, this.val$holder.mPosition, this.val$holder.mContentHolder);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter.1
 * JD-Core Version:    0.7.0.1
 */