package com.tencent.mobileqq.guild.message.data;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.base.AbsGuildSystemMessageProcessorCallback;
import com.tencent.mobileqq.msg.api.IMessageFacade;

public class GuildSystemMessageProcessorCallback
  extends AbsGuildSystemMessageProcessorCallback
{
  private void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    paramAppInterface = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
    RefreshMessageContext localRefreshMessageContext = new RefreshMessageContext();
    localRefreshMessageContext.a = new ChatContext(paramMessageRecord.frienduin);
    localRefreshMessageContext.q = 10014;
    paramAppInterface.setChangeAndNotify(localRefreshMessageContext);
    paramAppInterface.cancelNotificationWhenRevokeMessage(paramMessageRecord);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    a(paramAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.data.GuildSystemMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */