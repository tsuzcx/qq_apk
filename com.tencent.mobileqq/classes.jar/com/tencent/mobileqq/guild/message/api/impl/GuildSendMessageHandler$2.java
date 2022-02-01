package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class GuildSendMessageHandler$2
  implements Runnable
{
  GuildSendMessageHandler$2(GuildSendMessageHandler paramGuildSendMessageHandler, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    try
    {
      ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)GuildSendMessageHandler.a(this.this$0)).b(this.a, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GuildSendMessageHandler", 1, "sendMessage:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler.2
 * JD-Core Version:    0.7.0.1
 */