package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildMessagePushHandler$1
  extends GPServiceObserver
{
  GuildMessagePushHandler$1(GuildMessagePushHandler paramGuildMessagePushHandler) {}
  
  protected void a(IGProChannelInfo paramIGProChannelInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildMessagePushHandler", 2, "onCreateChannel.");
    }
    if (paramIGProChannelInfo != null) {
      GuildMessagePushHandler.a(this.a, paramIGProChannelInfo.getGuildId(), false);
    }
  }
  
  protected void a(IGProGuildInfo paramIGProGuildInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildMessagePushHandler", 2, "onAddGuild.");
    }
    if ((paramIGProGuildInfo != null) && (paramIGProGuildInfo.getUserType() == 0)) {
      GuildMessagePushHandler.a(this.a, paramIGProGuildInfo.getGuildID(), true);
    }
  }
  
  protected void b(IGProGuildInfo paramIGProGuildInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildMessagePushHandler", 2, "onCreateGuild.");
    }
    if (paramIGProGuildInfo != null) {
      GuildMessagePushHandler.a(this.a, paramIGProGuildInfo.getGuildID(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessagePushHandler.1
 * JD-Core Version:    0.7.0.1
 */