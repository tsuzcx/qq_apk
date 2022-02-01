package com.tencent.mobileqq.guild.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildDescriptionEditFragment$6
  implements View.OnClickListener
{
  QQGuildDescriptionEditFragment$6(QQGuildDescriptionEditFragment paramQQGuildDescriptionEditFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.6
 * JD-Core Version:    0.7.0.1
 */