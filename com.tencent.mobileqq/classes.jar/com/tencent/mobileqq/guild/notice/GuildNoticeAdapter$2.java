package com.tencent.mobileqq.guild.notice;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeAction;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;
import java.util.Map;

class GuildNoticeAdapter$2
  implements View.OnClickListener
{
  GuildNoticeAdapter$2(GuildNoticeAdapter paramGuildNoticeAdapter, GuildNotice paramGuildNotice, GuildNotice.GuildNoticeAction paramGuildNoticeAction, FadeIconImageView paramFadeIconImageView) {}
  
  public void onClick(View paramView)
  {
    GuildNoticeAdapter.b(this.d).a(this.a.a, this.b.c);
    Map localMap = GuildNoticeAdapter.a(this.d, this.a.f);
    VideoReport.reportEvent("clck", this.c, localMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeAdapter.2
 * JD-Core Version:    0.7.0.1
 */