package com.tencent.mobileqq.guild.mainframe.container.inbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildInboxAdapter$1
  implements View.OnClickListener
{
  GuildInboxAdapter$1(GuildInboxAdapter paramGuildInboxAdapter, GuildNoticeRedPoint paramGuildNoticeRedPoint) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == 1)
    {
      int i = GuildInboxAdapter.a(this.b).e().l();
      if (i != GuildAttachContainerController.f)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onclick but left frame type=");
        localStringBuilder.append(i);
        QLog.w("GuildInboxAdapter", 1, localStringBuilder.toString());
        GuildInboxAdapter.a(this.b).e().a(GuildAttachContainerController.f, null);
      }
      GuildInboxAdapter.a(this.b).e().e(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxAdapter.1
 * JD-Core Version:    0.7.0.1
 */