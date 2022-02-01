package com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar;

import androidx.lifecycle.Observer;

class QQGuildSubTopBarLiveFragment$5
  implements Observer<Boolean>
{
  QQGuildSubTopBarLiveFragment$5(QQGuildSubTopBarLiveFragment paramQQGuildSubTopBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    QQGuildSubTopBarLiveFragment localQQGuildSubTopBarLiveFragment = this.a;
    boolean bool;
    if (paramBoolean == Boolean.TRUE) {
      bool = true;
    } else {
      bool = false;
    }
    QQGuildSubTopBarLiveFragment.a(localQQGuildSubTopBarLiveFragment, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar.QQGuildSubTopBarLiveFragment.5
 * JD-Core Version:    0.7.0.1
 */