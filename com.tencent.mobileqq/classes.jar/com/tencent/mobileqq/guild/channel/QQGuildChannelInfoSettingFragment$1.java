package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

class QQGuildChannelInfoSettingFragment$1
  extends GPServiceObserver
{
  QQGuildChannelInfoSettingFragment$1(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  protected void e(String paramString)
  {
    super.e(paramString);
    if ((this.a.o != null) && (this.a.o.getChannelUin().equals(paramString))) {
      QQGuildChannelInfoSettingFragment.a(this.a);
    }
  }
  
  protected void f(String paramString)
  {
    super.f(paramString);
    if ((this.a.o != null) && (this.a.o.getGuildId().equals(paramString))) {
      QQGuildChannelInfoSettingFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */