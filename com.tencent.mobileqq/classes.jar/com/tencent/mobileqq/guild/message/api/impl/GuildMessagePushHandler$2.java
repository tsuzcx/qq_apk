package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;

class GuildMessagePushHandler$2
  implements Runnable
{
  GuildMessagePushHandler$2(GuildMessagePushHandler paramGuildMessagePushHandler) {}
  
  public void run()
  {
    try
    {
      ((IGPSService)GuildMessagePushHandler.b(this.this$0).getRuntimeService(IGPSService.class, "")).addObserver(GuildMessagePushHandler.a(this.this$0));
      GuildMessagePushHandler.a(this.this$0, true);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGPSObserver FAILED! ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GuildMessagePushHandler", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessagePushHandler.2
 * JD-Core Version:    0.7.0.1
 */