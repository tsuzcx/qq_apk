package com.tencent.mobileqq.guild.handler.api.impl;

import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;

class QQGuildHandler$2
  implements IResultWithSecurityCallback
{
  QQGuildHandler$2(QQGuildHandler paramQQGuildHandler, IGProChannelInfo paramIGProChannelInfo, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult))) {
      this.c.notifyUI(2, true, this.a);
    }
    IResultWithSecurityCallback localIResultWithSecurityCallback = this.b;
    if (localIResultWithSecurityCallback != null) {
      localIResultWithSecurityCallback.a(paramInt, paramString, paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler.2
 * JD-Core Version:    0.7.0.1
 */