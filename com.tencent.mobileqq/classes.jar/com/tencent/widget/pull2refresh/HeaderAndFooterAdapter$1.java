package com.tencent.widget.pull2refresh;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HeaderAndFooterAdapter$1
  implements View.OnClickListener
{
  HeaderAndFooterAdapter$1(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = this.val$holder.getPosition();
    if (i >= 0) {
      this.this$0.mOnItemClickListener.onItemClick(this.val$holder.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.HeaderAndFooterAdapter.1
 * JD-Core Version:    0.7.0.1
 */