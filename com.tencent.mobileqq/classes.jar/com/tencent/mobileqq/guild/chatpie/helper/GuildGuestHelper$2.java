package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

class GuildGuestHelper$2
  extends GPServiceObserver
{
  GuildGuestHelper$2(GuildGuestHelper paramGuildGuestHelper) {}
  
  protected void a(IGProGuildInfo paramIGProGuildInfo)
  {
    if ((paramIGProGuildInfo != null) && (!TextUtils.isEmpty(paramIGProGuildInfo.getGuildID())) && (paramIGProGuildInfo.getGuildID().equals(GuildGuestHelper.a(this.a).S()))) {
      GuildGuestHelper.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildGuestHelper.2
 * JD-Core Version:    0.7.0.1
 */