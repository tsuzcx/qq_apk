package com.tencent.mobileqq.guild.mainframe.api;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildInboxRedService
  extends IRuntimeService
{
  public abstract void addNoticeRedUpdateListener(IGuildInboxRedService.INoticeRedUpdateListener paramINoticeRedUpdateListener);
  
  public abstract void clearNoticeRedPoint(int paramInt);
  
  public abstract void fetchNoticeRedPoint(AppRuntime paramAppRuntime);
  
  public abstract List<GuildNoticeRedPoint> getNoticeGroupList();
  
  public abstract IGuildUnreadCntService.UnreadCntInfo getNoticeRedCount();
  
  public abstract GuildNoticeRedPoint getNoticeRedPoint(int paramInt);
  
  public abstract boolean needFetchNoticeRed();
  
  public abstract void removeNoticeRedUpdateListener(IGuildInboxRedService.INoticeRedUpdateListener paramINoticeRedUpdateListener);
  
  public abstract void setNoticeRedPoint(int paramInt1, int paramInt2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
 * JD-Core Version:    0.7.0.1
 */