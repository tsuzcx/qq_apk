package com.tencent.mobileqq.guild.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildNameBaseFragment$2
  implements View.OnClickListener
{
  QQGuildNameBaseFragment$2(QQGuildNameBaseFragment paramQQGuildNameBaseFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */