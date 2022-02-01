package com.tencent.mobileqq.guild.forwardshare.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.SendTextMsgParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class GuildShareForwardApiImpl$1
  extends GuildMessageObserver
{
  GuildShareForwardApiImpl$1(GuildShareForwardApiImpl paramGuildShareForwardApiImpl) {}
  
  protected void a(String paramString, long paramLong)
  {
    if ((GuildShareForwardApiImpl.access$000(this.a) != null) && (GuildShareForwardApiImpl.access$000(this.a).containsKey(Long.valueOf(paramLong))))
    {
      paramString = (IGuildSendMessageHandler.SendTextMsgParams)GuildShareForwardApiImpl.access$000(this.a).get(Long.valueOf(paramLong));
      if (paramString != null) {
        ((IGuildSendMessageHandler)GuildShareForwardApiImpl.access$100(this.a).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).b(GuildShareForwardApiImpl.access$100(this.a), paramString);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uinque:");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("params:");
        localStringBuilder.append(paramString.d);
        QLog.i("GuildShareForwardApiImpl", 2, localStringBuilder.toString());
      }
      GuildShareForwardApiImpl.access$000(this.a).remove(Long.valueOf(paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.forwardshare.api.impl.GuildShareForwardApiImpl.1
 * JD-Core Version:    0.7.0.1
 */