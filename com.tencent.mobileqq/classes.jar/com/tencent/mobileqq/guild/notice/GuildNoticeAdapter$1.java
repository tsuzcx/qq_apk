package com.tencent.mobileqq.guild.notice;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildNoticeAdapter$1
  implements View.OnClickListener
{
  GuildNoticeAdapter$1(GuildNoticeAdapter paramGuildNoticeAdapter, GuildNotice paramGuildNotice) {}
  
  public void onClick(View paramView)
  {
    GuildNoticeAdapter.b(this.b).a(this.a, GuildNoticeAdapter.a(this.b));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeAdapter.1
 * JD-Core Version:    0.7.0.1
 */