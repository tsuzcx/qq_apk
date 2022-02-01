package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelInfoSettingFragment$5
  extends QQGuildObserver
{
  QQGuildChannelInfoSettingFragment$5(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  public void b(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramBoolean) && (paramIGProChannelInfo != null))
    {
      QQGuildChannelInfoSettingFragment localQQGuildChannelInfoSettingFragment = this.a;
      localQQGuildChannelInfoSettingFragment.o = paramIGProChannelInfo;
      QQGuildChannelInfoSettingFragment.c(localQQGuildChannelInfoSettingFragment);
      return;
    }
    QLog.e("QQGuildObserver", 1, new Object[] { "onChannelUpdate error isSuccess:", Boolean.valueOf(paramBoolean), ", channelInfo:", paramIGProChannelInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */