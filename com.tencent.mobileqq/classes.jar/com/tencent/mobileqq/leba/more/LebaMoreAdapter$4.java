package com.tencent.mobileqq.leba.more;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.business.LebaMoreVipBizProxy;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

class LebaMoreAdapter$4
  implements View.OnClickListener
{
  LebaMoreAdapter$4(LebaMoreAdapter paramLebaMoreAdapter, LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem) {}
  
  public void onClick(View paramView)
  {
    if (this.c.j) {
      this.a.c.performClick();
    } else if (this.c.k != null) {
      this.c.k.a(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreAdapter.4
 * JD-Core Version:    0.7.0.1
 */