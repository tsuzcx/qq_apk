package com.tencent.mobileqq.guild.notice;

import androidx.lifecycle.Observer;
import com.tencent.widget.XListView;

class GuildNoticeFragment$5
  implements Observer<Boolean>
{
  GuildNoticeFragment$5(GuildNoticeFragment paramGuildNoticeFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
      GuildNoticeFragment.a(this.a).setOverScrollFooter(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeFragment.5
 * JD-Core Version:    0.7.0.1
 */