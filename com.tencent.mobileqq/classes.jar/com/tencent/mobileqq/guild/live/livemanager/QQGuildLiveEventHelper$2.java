package com.tencent.mobileqq.guild.live.livemanager;

import cooperation.qzone.util.NetworkState.NetworkStateListener;

class QQGuildLiveEventHelper$2
  implements NetworkState.NetworkStateListener
{
  QQGuildLiveEventHelper$2(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if ((!QQGuildLiveEventHelper.a(this.a)) && (paramBoolean)) {
      QQGuildLiveEventHelper.b(this.a);
    }
    QQGuildLiveEventHelper.a(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.2
 * JD-Core Version:    0.7.0.1
 */