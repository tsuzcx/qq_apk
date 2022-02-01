package com.tencent.mobileqq.leba.more;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LebaMoreAdapter$2
  implements View.OnClickListener
{
  LebaMoreAdapter$2(LebaMoreAdapter paramLebaMoreAdapter, LebaMoreAdapter.PluginViewHolder paramPluginViewHolder, LebaMoreViewItem paramLebaMoreViewItem) {}
  
  public void onClick(View paramView)
  {
    LebaDaTong.a(this.a.c, this.b.d, this.b.c.b.getDaTongID());
    LebaMoreAdapter.a(this.c, this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreAdapter.2
 * JD-Core Version:    0.7.0.1
 */