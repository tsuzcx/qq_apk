package com.tencent.mobileqq.guild.notice;

import androidx.lifecycle.Observer;

class GuildNoticeFragment$6
  implements Observer<Boolean>
{
  GuildNoticeFragment$6(GuildNoticeFragment paramGuildNoticeFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue() == true)
    {
      GuildNoticeFragment.c(this.a);
      return;
    }
    GuildNoticeFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeFragment.6
 * JD-Core Version:    0.7.0.1
 */