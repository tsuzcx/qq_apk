package com.tencent.mobileqq.guild.navigatebar;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.NavConstants;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class GuildAioMsgNavigateUpdateMsgInfoUtil
  extends TroopAioMsgNavigateUpdateMsgInfoUtil
{
  protected static String a(String paramString, boolean paramBoolean)
  {
    return paramString;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramInt != 23) {
        return;
      }
      ChannelMsgEvent localChannelMsgEvent = new ChannelMsgEvent();
      localChannelMsgEvent.channelId = paramString;
      localChannelMsgEvent.eventType = 1L;
      localChannelMsgEvent.msgSeq = paramMessageRecord.shmsgseq;
      localChannelMsgEvent.tinyId = paramMessageRecord.senderuin;
      paramQQAppInterface = (IGuildMessageBoxDataService)paramQQAppInterface.getRuntimeService(IGuildMessageBoxDataService.class, "");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.addChannelMsgBoxEvent(localChannelMsgEvent);
      }
    }
  }
  
  @Nullable
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    b(paramQQAppInterface, paramString, paramMessageInfo, paramMessageRecord, paramBoolean);
  }
  
  protected static void b(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i;
    if (paramMessageInfo.a() == 13)
    {
      i = 1;
      paramMessageInfo.c.a = 24;
    }
    else
    {
      i = 0;
    }
    int j = paramMessageInfo.a(paramBoolean);
    paramString = a(paramString, paramBoolean);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNavMsgInfo, msgInfo = ");
      localStringBuilder.append(paramMessageInfo);
      localStringBuilder.append(" mr= ");
      localStringBuilder.append(paramMessageRecord);
      localStringBuilder.append(" channelId = ");
      localStringBuilder.append(paramString);
      QLog.d("GuildAioMsgNavigateUpdateMsgInfoUtil", 2, localStringBuilder.toString());
    }
    j = NavConstants.b(j);
    long l = AioAgent.Message.a(j, paramMessageInfo.c.b, paramMessageInfo.c.c);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNavMsgInfo msgSeq ");
      localStringBuilder.append(l);
      QLog.d("GuildAioMsgNavigateUpdateMsgInfoUtil", 2, localStringBuilder.toString());
    }
    ((GuildAioNavigateBarManager)paramQQAppInterface.getManager(QQManagerFactory.GUILD_AIO_NAVIGATE_BAR)).a(paramString, j, paramMessageInfo.c.b, l, "", null);
    if (i == 0) {
      a(paramQQAppInterface, paramString, paramMessageRecord, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateUpdateMsgInfoUtil
 * JD-Core Version:    0.7.0.1
 */