package com.tencent.mobileqq.guild.handler.api.impl;

import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;

class QQGuildHandler$3
  implements ISetChannelNameCallback
{
  QQGuildHandler$3(QQGuildHandler paramQQGuildHandler, ISetChannelNameCallback paramISetChannelNameCallback) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult))) {
      this.b.notifyUI(3, true, paramIGProChannelInfo);
    }
    ISetChannelNameCallback localISetChannelNameCallback = this.a;
    if (localISetChannelNameCallback != null) {
      localISetChannelNameCallback.a(paramInt, paramIGProChannelInfo, paramString, paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler.3
 * JD-Core Version:    0.7.0.1
 */