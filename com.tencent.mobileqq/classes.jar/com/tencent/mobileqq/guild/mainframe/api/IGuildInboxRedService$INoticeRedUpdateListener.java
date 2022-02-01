package com.tencent.mobileqq.guild.mainframe.api;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import java.util.List;

public abstract interface IGuildInboxRedService$INoticeRedUpdateListener
{
  public abstract void a(IGuildUnreadCntService.UnreadCntInfo paramUnreadCntInfo);
  
  public abstract void a(GuildNoticeRedPoint paramGuildNoticeRedPoint);
  
  public abstract void a(List<GuildNoticeRedPoint> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.INoticeRedUpdateListener
 * JD-Core Version:    0.7.0.1
 */