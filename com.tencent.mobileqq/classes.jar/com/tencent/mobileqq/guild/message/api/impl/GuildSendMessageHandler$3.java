package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class GuildSendMessageHandler$3
  implements Runnable
{
  GuildSendMessageHandler$3(GuildSendMessageHandler paramGuildSendMessageHandler, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    Object localObject = (MessageCache)GuildSendMessageHandler.a(this.this$0).getMsgCache();
    if ((localObject != null) && (((MessageCache)localObject).f(this.a)))
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delay notify: ");
        ((StringBuilder)localObject).append(MessageCache.a);
        QLog.d("MsgSend", 4, ((StringBuilder)localObject).toString());
      }
      this.this$0.notifyUI(GuildMessageObserver.b, true, new String[] { this.a.frienduin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler.3
 * JD-Core Version:    0.7.0.1
 */