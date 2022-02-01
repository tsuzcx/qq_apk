package com.tencent.widget.pull2refresh;

import android.view.View;
import android.view.View.OnLongClickListener;

class HeaderAndFooterAdapter$2
  implements View.OnLongClickListener
{
  HeaderAndFooterAdapter$2(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.val$holder.getPosition();
    if (i >= 0) {
      this.this$0.mOnItemLongClickListener.onItemLongClick(this.val$holder.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.HeaderAndFooterAdapter.2
 * JD-Core Version:    0.7.0.1
 */