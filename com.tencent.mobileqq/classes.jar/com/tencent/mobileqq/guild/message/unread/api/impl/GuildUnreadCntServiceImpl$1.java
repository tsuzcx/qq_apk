package com.tencent.mobileqq.guild.message.unread.api.impl;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildUnreadCntServiceImpl$1
  extends GPServiceObserver
{
  GuildUnreadCntServiceImpl$1(GuildUnreadCntServiceImpl paramGuildUnreadCntServiceImpl) {}
  
  protected void a()
  {
    QLog.i("GuildUnreadCntServiceImpl", 1, "onGuildListUpdated");
    GuildUnreadCntServiceImpl.access$000(this.a, new IGuildUnreadCntService.NotifyObj(3, ""));
  }
  
  protected void b(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMsgRecvTypeChanged key:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" channelId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" notifyType:");
    localStringBuilder.append(paramInt);
    QLog.i("GuildUnreadCntServiceImpl", 1, localStringBuilder.toString());
    this.a.refreshAndNotifyChannelUnreadCntInfo(paramString2);
    this.a.refreshAndNotifyGuildUnreadCntInfo(paramString1);
  }
  
  protected void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChannelListUpdated key:");
    localStringBuilder.append(paramString);
    QLog.i("GuildUnreadCntServiceImpl", 1, localStringBuilder.toString());
    this.a.refreshAndNotifyGuildUnreadCntInfo(paramString);
  }
  
  protected void f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChannelListUpdated key:");
    localStringBuilder.append(paramString);
    QLog.i("GuildUnreadCntServiceImpl", 1, localStringBuilder.toString());
    this.a.refreshAndNotifyGuildUnreadCntInfo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.impl.GuildUnreadCntServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */