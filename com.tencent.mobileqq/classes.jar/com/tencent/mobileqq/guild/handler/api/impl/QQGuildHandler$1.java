package com.tencent.mobileqq.guild.handler.api.impl;

import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.data.QQGuildWrapData;
import com.tencent.mobileqq.qqguildsdk.callback.ICreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;

class QQGuildHandler$1
  implements ICreateChannelCallback
{
  QQGuildHandler$1(QQGuildHandler paramQQGuildHandler, String paramString, ICreateChannelCallback paramICreateChannelCallback) {}
  
  public void a(int paramInt, String paramString, IGProChannelInfo paramIGProChannelInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult))) {
      this.c.notifyUI(1, true, new QQGuildWrapData(paramIGProChannelInfo, this.a));
    }
    ICreateChannelCallback localICreateChannelCallback = this.b;
    if (localICreateChannelCallback != null) {
      localICreateChannelCallback.a(paramInt, paramString, paramIGProChannelInfo, paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler.1
 * JD-Core Version:    0.7.0.1
 */