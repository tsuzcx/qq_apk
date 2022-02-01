package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.view.View;
import androidx.lifecycle.Observer;

class QQGuildTopBarLiveFragment$3
  implements Observer<Boolean>
{
  QQGuildTopBarLiveFragment$3(QQGuildTopBarLiveFragment paramQQGuildTopBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean != Boolean.TRUE)
    {
      this.a.g();
      QQGuildTopBarLiveFragment.c(this.a).setVisibility(4);
      return;
    }
    QQGuildTopBarLiveFragment.d(this.a);
    QQGuildTopBarLiveFragment.c(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment.3
 * JD-Core Version:    0.7.0.1
 */