package com.tencent.mobileqq.guild.message.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildMessageBoxDataService
  extends IRuntimeService
{
  public abstract void addChannelMsgBoxEvent(ChannelMsgEvent paramChannelMsgEvent);
  
  public abstract void addChannelMsgBoxEventList(String paramString, List<ChannelMsgEvent> paramList);
  
  public abstract void clearChannelMsgBoxReadEventList(String paramString, long paramLong);
  
  public abstract HashMap<String, List<ChannelMsgEvent>> getAllChannelMsgEventList();
  
  @Nullable
  public abstract List<ChannelMsgEvent> getChannelMsgEventList(String paramString, long paramLong);
  
  public abstract int getChannelMsgEventUnreadCount(String paramString, long paramLong);
  
  public abstract String getMessageBoxCookie();
  
  public abstract void removeChannelMsgBoxReadEvent(ChannelMsgEvent paramChannelMsgEvent);
  
  public abstract boolean setMessageBoxCookie(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService
 * JD-Core Version:    0.7.0.1
 */