package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.GuildGuestObserver;

class GuildGuestHelper$1
  extends GuildGuestObserver
{
  GuildGuestHelper$1(GuildGuestHelper paramGuildGuestHelper) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    if (!GuildGuestHelper.a(this.a).T().equals(paramString)) {
      return;
    }
    if ((paramBoolean) && (paramInt1 == 1))
    {
      GuildGuestHelper.a(this.a).c(131075);
      return;
    }
    if ((paramInt1 == 2) && (paramInt2 == 200006)) {
      GuildGuestHelper.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildGuestHelper.1
 * JD-Core Version:    0.7.0.1
 */