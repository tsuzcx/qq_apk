package com.tencent.mobileqq.guild.handler.api.impl;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelAdminMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class QQGuildHandler$5
  implements ISetChannelAdminMsgNotifyTypeCallback
{
  QQGuildHandler$5(QQGuildHandler paramQQGuildHandler, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt == 0) {
      this.b.notifyUI(3, true, paramIGProChannelInfo);
    }
    paramIGProSecurityResult = this.a;
    if (paramIGProSecurityResult != null) {
      paramIGProSecurityResult.a(paramInt, paramIGProChannelInfo, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler.5
 * JD-Core Version:    0.7.0.1
 */