package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildMsgSeqTimeService
  extends IRuntimeService
{
  public abstract void addDecreaseMsgSeq(String paramString1, String paramString2, DecreaseMsgSeqInfo paramDecreaseMsgSeqInfo);
  
  public abstract void addObserver(Observer paramObserver);
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract HashSet<DecreaseMsgSeqInfo> getDecreaseMsgSeqList(String paramString);
  
  public abstract GuildEventFlowTimeItem getEventFlowTimeItem(String paramString);
  
  public abstract long getExpiredMsgSeq(String paramString);
  
  public abstract IGuildMsgSeqTimeService.MsgSeqTimeItem getLastLocallMsgSeq(String paramString);
  
  public abstract IGuildMsgSeqTimeService.MsgSeqTimeItem getLastLocallVisibleMsgSeq(String paramString);
  
  public abstract IGuildMsgSeqTimeService.MsgSeqTimeItem getLastSvrMsgSeq(String paramString);
  
  public abstract IGuildMsgSeqTimeService.MsgSeqTimeItem getLatestHasSeenMsg(String paramString);
  
  public abstract IGuildMsgSeqTimeService.MsgSeqTimeItem getReadedMsgSeq(String paramString);
  
  public abstract IGuildMsgSeqTimeService.MsgSeqTimeItem getReportSeqTimeItem(String paramString, boolean paramBoolean);
  
  public abstract void setEventFlowTimeItem(String paramString1, String paramString2, long paramLong);
  
  public abstract void setEventFlowTimeItem(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte);
  
  public abstract void setEventFlowTimeItem(String paramString1, String paramString2, GuildEventFlowTimeItem paramGuildEventFlowTimeItem);
  
  public abstract void setExpiredMsgSeq(String paramString1, String paramString2, long paramLong);
  
  public abstract boolean setLastLocalMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract boolean setLastLocalVisibleMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract boolean setLastSvrMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract void setLatestHasSeenMsg(String paramString, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract boolean setReadedMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem, boolean paramBoolean);
  
  public abstract void updateLastSeqAndTime(ArrayList<MessageRecord> paramArrayList);
  
  public abstract boolean verifyLastLocalVisibleMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract boolean verifyLastSvrMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract boolean verifyReadedMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService
 * JD-Core Version:    0.7.0.1
 */