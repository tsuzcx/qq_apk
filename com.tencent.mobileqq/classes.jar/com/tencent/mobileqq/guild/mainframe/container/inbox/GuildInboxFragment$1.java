package com.tencent.mobileqq.guild.mainframe.container.inbox;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import java.util.List;

class GuildInboxFragment$1
  implements Observer<List<GuildNoticeRedPoint>>
{
  GuildInboxFragment$1(GuildInboxFragment paramGuildInboxFragment) {}
  
  public void a(List<GuildNoticeRedPoint> paramList)
  {
    if (paramList != null)
    {
      GuildInboxFragment.a(this.a, paramList);
      GuildInboxFragment.b(this.a).a(GuildInboxFragment.a(this.a));
      GuildInboxFragment.b(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxFragment.1
 * JD-Core Version:    0.7.0.1
 */