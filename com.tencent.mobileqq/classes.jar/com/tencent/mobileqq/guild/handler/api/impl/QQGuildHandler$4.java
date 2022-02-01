package com.tencent.mobileqq.guild.handler.api.impl;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

class QQGuildHandler$4
  implements ISetChannelMsgNotifyTypeCallback
{
  QQGuildHandler$4(QQGuildHandler paramQQGuildHandler, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    if (paramInt == 0) {
      this.b.notifyUI(3, true, paramIGProChannelInfo);
    }
    ISetChannelMsgNotifyTypeCallback localISetChannelMsgNotifyTypeCallback = this.a;
    if (localISetChannelMsgNotifyTypeCallback != null) {
      localISetChannelMsgNotifyTypeCallback.a(paramInt, paramIGProChannelInfo, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler.4
 * JD-Core Version:    0.7.0.1
 */