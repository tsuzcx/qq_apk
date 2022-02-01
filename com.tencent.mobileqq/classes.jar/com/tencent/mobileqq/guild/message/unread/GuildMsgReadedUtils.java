package com.tencent.mobileqq.guild.message.unread;

import com.tencent.mobileqq.guild.message.GuildMsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.api.impl.GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.qphone.base.util.QLog;

public class GuildMsgReadedUtils
{
  private static String a = "GuildMsgReadedUtils";
  
  public static GuildMsgSeqTimeItem a(GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue paramGuildMsgSeqTimeValue)
  {
    if (paramGuildMsgSeqTimeValue == null) {
      return null;
    }
    GuildMsgSeqTimeItem localGuildMsgSeqTimeItem = new GuildMsgSeqTimeItem();
    localGuildMsgSeqTimeItem.guildId = paramGuildMsgSeqTimeValue.a;
    localGuildMsgSeqTimeItem.channelId = paramGuildMsgSeqTimeValue.b;
    localGuildMsgSeqTimeItem.lastLocalMsgSeq = paramGuildMsgSeqTimeValue.c.a;
    localGuildMsgSeqTimeItem.lastLocalCntSeq = paramGuildMsgSeqTimeValue.c.b;
    localGuildMsgSeqTimeItem.lastLocalMsgTime = paramGuildMsgSeqTimeValue.c.c;
    localGuildMsgSeqTimeItem.lastLocalMsgMeta = paramGuildMsgSeqTimeValue.c.d;
    localGuildMsgSeqTimeItem.lastSvrMsgSeq = paramGuildMsgSeqTimeValue.d.a;
    localGuildMsgSeqTimeItem.lastSvrCntSeq = paramGuildMsgSeqTimeValue.d.b;
    localGuildMsgSeqTimeItem.lastSvrMsgTime = paramGuildMsgSeqTimeValue.d.c;
    localGuildMsgSeqTimeItem.lastSvrMsgMeta = paramGuildMsgSeqTimeValue.d.d;
    localGuildMsgSeqTimeItem.readedMsgSeq = paramGuildMsgSeqTimeValue.e.a;
    localGuildMsgSeqTimeItem.readedCntSeq = paramGuildMsgSeqTimeValue.e.b;
    localGuildMsgSeqTimeItem.readedMsgTime = paramGuildMsgSeqTimeValue.e.c;
    localGuildMsgSeqTimeItem.readedMsgMeta = paramGuildMsgSeqTimeValue.e.d;
    localGuildMsgSeqTimeItem.lastLocalVisibleMsgSeq = paramGuildMsgSeqTimeValue.f.a;
    localGuildMsgSeqTimeItem.lastLocalVisibleCntSeq = paramGuildMsgSeqTimeValue.f.b;
    localGuildMsgSeqTimeItem.lastLocalVisibleMsgTime = paramGuildMsgSeqTimeValue.f.c;
    localGuildMsgSeqTimeItem.lastLocalVisibleMsgMeta = paramGuildMsgSeqTimeValue.f.d;
    localGuildMsgSeqTimeItem.expiredMsgSeq = paramGuildMsgSeqTimeValue.g;
    localGuildMsgSeqTimeItem.decreaseMsgSeqList = paramGuildMsgSeqTimeValue.h;
    localGuildMsgSeqTimeItem.eventFlowTimeItem = paramGuildMsgSeqTimeValue.i;
    return localGuildMsgSeqTimeItem;
  }
  
  public static GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue a(GuildMsgSeqTimeItem paramGuildMsgSeqTimeItem)
  {
    if (paramGuildMsgSeqTimeItem == null) {
      return null;
    }
    GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue localGuildMsgSeqTimeValue = new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(paramGuildMsgSeqTimeItem.guildId, paramGuildMsgSeqTimeItem.channelId);
    localGuildMsgSeqTimeValue.c = new IGuildMsgSeqTimeService.MsgSeqTimeItem(paramGuildMsgSeqTimeItem.lastLocalMsgSeq, paramGuildMsgSeqTimeItem.lastLocalCntSeq, paramGuildMsgSeqTimeItem.lastLocalMsgTime, paramGuildMsgSeqTimeItem.lastLocalMsgMeta);
    localGuildMsgSeqTimeValue.d = new IGuildMsgSeqTimeService.MsgSeqTimeItem(paramGuildMsgSeqTimeItem.lastSvrMsgSeq, paramGuildMsgSeqTimeItem.lastSvrCntSeq, paramGuildMsgSeqTimeItem.lastSvrMsgTime, paramGuildMsgSeqTimeItem.lastSvrMsgMeta);
    localGuildMsgSeqTimeValue.e = new IGuildMsgSeqTimeService.MsgSeqTimeItem(paramGuildMsgSeqTimeItem.readedMsgSeq, paramGuildMsgSeqTimeItem.readedCntSeq, paramGuildMsgSeqTimeItem.readedMsgTime, paramGuildMsgSeqTimeItem.readedMsgMeta);
    localGuildMsgSeqTimeValue.f = new IGuildMsgSeqTimeService.MsgSeqTimeItem(paramGuildMsgSeqTimeItem.lastLocalVisibleMsgSeq, paramGuildMsgSeqTimeItem.lastLocalVisibleCntSeq, paramGuildMsgSeqTimeItem.lastLocalVisibleMsgTime, paramGuildMsgSeqTimeItem.lastLocalVisibleMsgMeta);
    localGuildMsgSeqTimeValue.g = paramGuildMsgSeqTimeItem.expiredMsgSeq;
    localGuildMsgSeqTimeValue.h = paramGuildMsgSeqTimeItem.decreaseMsgSeqList;
    localGuildMsgSeqTimeValue.i = paramGuildMsgSeqTimeItem.eventFlowTimeItem;
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConvToGuildMsgSeqTimeValue. guildId: ");
      localStringBuilder.append(paramGuildMsgSeqTimeItem.guildId);
      localStringBuilder.append(" channelId: ");
      localStringBuilder.append(paramGuildMsgSeqTimeItem.channelId);
      localStringBuilder.append(" localMsgSeqTimeItem: ");
      localStringBuilder.append(localGuildMsgSeqTimeValue.c.toString());
      localStringBuilder.append(" svrMsgSeqTimeItem: ");
      localStringBuilder.append(localGuildMsgSeqTimeValue.d.toString());
      localStringBuilder.append(" readedMsgSeqTimeItem: ");
      localStringBuilder.append(localGuildMsgSeqTimeValue.e.toString());
      localStringBuilder.append(" localVisibleMsgSeqTimeItem:");
      localStringBuilder.append(localGuildMsgSeqTimeValue.f.toString());
      localStringBuilder.append(" eventFlowTimeItem:");
      localStringBuilder.append(localGuildMsgSeqTimeValue.i.toString());
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return localGuildMsgSeqTimeValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.GuildMsgReadedUtils
 * JD-Core Version:    0.7.0.1
 */