package com.tencent.mobileqq.guild.message.unread.api;

import android.util.Pair;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildUnreadCntService
  extends IRuntimeService
{
  public abstract void addObserver(Observer paramObserver);
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract IGuildUnreadCntService.UnreadCntInfo getAllGuildAtUnreadCntInfo();
  
  public abstract IGuildUnreadCntService.UnreadCntInfo getChannelUnreadCnt(String paramString, int paramInt);
  
  public abstract Pair<Long, Long> getChannelUnreadCntToShow(IGProChannelInfo paramIGProChannelInfo);
  
  public abstract IGuildUnreadCntService.UnreadCntInfo getGuildUnreadCnt(String paramString);
  
  public abstract boolean refreshAndNotifyChannelUnreadCntInfo(String paramString);
  
  public abstract boolean refreshAndNotifyGuildUnreadCntInfo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService
 * JD-Core Version:    0.7.0.1
 */