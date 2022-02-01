package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import java.util.HashSet;

public class GuildMsgSeqTimeServiceImpl$GuildMsgSeqTimeValue
{
  public String a;
  public String b;
  public IGuildMsgSeqTimeService.MsgSeqTimeItem c = new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  public IGuildMsgSeqTimeService.MsgSeqTimeItem d = new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  public IGuildMsgSeqTimeService.MsgSeqTimeItem e = new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  public IGuildMsgSeqTimeService.MsgSeqTimeItem f = new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  public long g = 0L;
  public HashSet<DecreaseMsgSeqInfo> h = new HashSet();
  public GuildEventFlowTimeItem i = new GuildEventFlowTimeItem();
  
  public GuildMsgSeqTimeServiceImpl$GuildMsgSeqTimeValue(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue
 * JD-Core Version:    0.7.0.1
 */