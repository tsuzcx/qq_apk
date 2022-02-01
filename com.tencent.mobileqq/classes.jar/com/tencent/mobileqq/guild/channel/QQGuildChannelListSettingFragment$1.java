package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;

class QQGuildChannelListSettingFragment$1
  extends QQGuildObserver
{
  QQGuildChannelListSettingFragment$1(QQGuildChannelListSettingFragment paramQQGuildChannelListSettingFragment) {}
  
  public void a(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    QQGuildChannelListSettingFragment.a(this.a);
    if ("list_setting".equals(paramString))
    {
      int i = QQGuildChannelListSettingFragment.b(this.a).a(paramIGProChannelInfo);
      if (i > 0) {
        QQGuildChannelListSettingFragment.c(this.a).smoothScrollToPosition(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */