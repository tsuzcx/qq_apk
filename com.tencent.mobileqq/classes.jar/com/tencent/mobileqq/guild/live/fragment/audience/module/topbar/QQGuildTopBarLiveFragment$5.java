package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

class QQGuildTopBarLiveFragment$5
  implements Observer<IGProChannelInfo>
{
  QQGuildTopBarLiveFragment$5(QQGuildTopBarLiveFragment paramQQGuildTopBarLiveFragment) {}
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    paramIGProChannelInfo = this.a;
    QQGuildTopBarLiveFragment.a(paramIGProChannelInfo, QQGuildTopBarLiveFragment.e(paramIGProChannelInfo));
    paramIGProChannelInfo = this.a;
    QQGuildTopBarLiveFragment.b(paramIGProChannelInfo, QQGuildTopBarLiveFragment.e(paramIGProChannelInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment.5
 * JD-Core Version:    0.7.0.1
 */