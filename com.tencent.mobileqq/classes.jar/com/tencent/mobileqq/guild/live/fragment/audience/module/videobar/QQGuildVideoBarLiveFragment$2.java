package com.tencent.mobileqq.guild.live.fragment.audience.module.videobar;

import androidx.lifecycle.Observer;

class QQGuildVideoBarLiveFragment$2
  implements Observer<Boolean>
{
  QQGuildVideoBarLiveFragment$2(QQGuildVideoBarLiveFragment paramQQGuildVideoBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    QQGuildVideoBarLiveFragment localQQGuildVideoBarLiveFragment = this.a;
    boolean bool;
    if (paramBoolean == Boolean.TRUE) {
      bool = true;
    } else {
      bool = false;
    }
    QQGuildVideoBarLiveFragment.a(localQQGuildVideoBarLiveFragment, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.QQGuildVideoBarLiveFragment.2
 * JD-Core Version:    0.7.0.1
 */