package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import androidx.lifecycle.Observer;

class QQGuildTopBarLiveFragment$4
  implements Observer<Boolean>
{
  QQGuildTopBarLiveFragment$4(QQGuildTopBarLiveFragment paramQQGuildTopBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    QQGuildTopBarLiveFragment localQQGuildTopBarLiveFragment = this.a;
    boolean bool;
    if (paramBoolean == Boolean.TRUE) {
      bool = true;
    } else {
      bool = false;
    }
    QQGuildTopBarLiveFragment.a(localQQGuildTopBarLiveFragment, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment.4
 * JD-Core Version:    0.7.0.1
 */