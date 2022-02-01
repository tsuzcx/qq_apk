package com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar;

import com.tencent.mobileqq.banner.TipsBar;
import cooperation.qzone.util.NetworkState.NetworkStateListener;

class QQGuildSubTopBarLiveFragment$1
  implements NetworkState.NetworkStateListener
{
  QQGuildSubTopBarLiveFragment$1(QQGuildSubTopBarLiveFragment paramQQGuildSubTopBarLiveFragment) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    QQGuildSubTopBarLiveFragment.a(this.a).post(new QQGuildSubTopBarLiveFragment.1.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar.QQGuildSubTopBarLiveFragment.1
 * JD-Core Version:    0.7.0.1
 */