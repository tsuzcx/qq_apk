package com.tencent.mobileqq.guild.notice;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildNoticeFragment$3
  implements View.OnClickListener
{
  GuildNoticeFragment$3(GuildNoticeFragment paramGuildNoticeFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeFragment.3
 * JD-Core Version:    0.7.0.1
 */