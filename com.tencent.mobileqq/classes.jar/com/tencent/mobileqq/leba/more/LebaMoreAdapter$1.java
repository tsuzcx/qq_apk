package com.tencent.mobileqq.leba.more;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

class LebaMoreAdapter$1
  implements View.OnClickListener
{
  LebaMoreAdapter$1(LebaMoreAdapter paramLebaMoreAdapter, LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem) {}
  
  public void onClick(View paramView)
  {
    if (this.c.j) {
      this.a.c.performClick();
    } else if (this.c.h != null) {
      this.c.h.a(paramView, this.b.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreAdapter.1
 * JD-Core Version:    0.7.0.1
 */