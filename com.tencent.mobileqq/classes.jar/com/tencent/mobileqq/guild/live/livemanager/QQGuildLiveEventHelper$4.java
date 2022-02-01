package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.event.QQGuildEventManager;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;

class QQGuildLiveEventHelper$4
  extends QQGuildObserver
{
  QQGuildLiveEventHelper$4(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void a(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramBoolean) && (QQGuildLiveEventHelper.a(this.a, paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo.getChannelUin())))
    {
      QLog.i("QQGuildObserver", 1, "onChannelDelete.");
      if (!QQGuildEventManager.a.a(QQGuildLiveEventHelper.g(this.a), paramIGProChannelInfo.getChannelUin(), 1)) {
        paramIGProChannelInfo = HardCodeUtil.a(2131890421);
      } else {
        paramIGProChannelInfo = "";
      }
      QQGuildLiveEventHelper.a(this.a, paramIGProChannelInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.4
 * JD-Core Version:    0.7.0.1
 */