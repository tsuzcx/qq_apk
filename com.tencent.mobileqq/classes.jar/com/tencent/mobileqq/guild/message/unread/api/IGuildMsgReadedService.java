package com.tencent.mobileqq.guild.message.unread.api;

import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildMsgReadedService
  extends IRuntimeService
{
  public abstract void checkAndcleanMsgAndMsgData(String paramString);
  
  public abstract boolean clearMsgNavigateInfo(String paramString, List<String> paramList);
  
  public abstract void onMsgReadedNotify(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract void onRegisterProxyMsgReaded(String paramString, List<String> paramList);
  
  public abstract void setChannelMsgReaded(String paramString, ArrayList<String> paramArrayList, int paramInt);
  
  public abstract void setGuildReaded(String paramString, int paramInt);
  
  public abstract void setMessageRecordReaded(String paramString, List<String> paramList);
  
  public abstract void setMsgReadedAndReport(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem);
  
  public abstract void setMsgReadedAndReport(String paramString, ArrayList<String> paramArrayList, int paramInt);
  
  public abstract void setMsgReadedAndReportForce(String paramString, ArrayList<String> paramArrayList, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService
 * JD-Core Version:    0.7.0.1
 */