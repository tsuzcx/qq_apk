package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.util.Pair;
import android.widget.ImageView;
import androidx.lifecycle.Observer;

class QQGuildTopBarLiveFragment$2
  implements Observer<Pair<Boolean, Boolean>>
{
  QQGuildTopBarLiveFragment$2(QQGuildTopBarLiveFragment paramQQGuildTopBarLiveFragment) {}
  
  public void a(Pair<Boolean, Boolean> paramPair)
  {
    int i;
    if ((paramPair.second != Boolean.TRUE) && (paramPair.first == Boolean.TRUE)) {
      i = 2130840947;
    } else {
      i = 2130840900;
    }
    QQGuildTopBarLiveFragment.b(this.a).setImageResource(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment.2
 * JD-Core Version:    0.7.0.1
 */