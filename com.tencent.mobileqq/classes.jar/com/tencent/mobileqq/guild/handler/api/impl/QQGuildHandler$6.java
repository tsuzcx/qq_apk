package com.tencent.mobileqq.guild.handler.api.impl;

import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;

class QQGuildHandler$6
  implements ISetChannelTalkPermissionCallback
{
  QQGuildHandler$6(QQGuildHandler paramQQGuildHandler, ISetChannelTalkPermissionCallback paramISetChannelTalkPermissionCallback) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult))) {
      this.b.notifyUI(4, true, null);
    }
    ISetChannelTalkPermissionCallback localISetChannelTalkPermissionCallback = this.a;
    if (localISetChannelTalkPermissionCallback != null) {
      localISetChannelTalkPermissionCallback.a(paramInt, paramIGProChannelInfo, paramString, paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler.6
 * JD-Core Version:    0.7.0.1
 */