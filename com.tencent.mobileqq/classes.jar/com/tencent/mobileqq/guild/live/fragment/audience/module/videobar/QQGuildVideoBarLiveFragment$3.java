package com.tencent.mobileqq.guild.live.fragment.audience.module.videobar;

import android.util.Pair;
import androidx.lifecycle.Observer;

class QQGuildVideoBarLiveFragment$3
  implements Observer<Pair<Boolean, Boolean>>
{
  QQGuildVideoBarLiveFragment$3(QQGuildVideoBarLiveFragment paramQQGuildVideoBarLiveFragment) {}
  
  public void a(Pair<Boolean, Boolean> paramPair)
  {
    Object localObject = paramPair.first;
    Boolean localBoolean = Boolean.TRUE;
    boolean bool = false;
    if (localObject != localBoolean)
    {
      QQGuildVideoBarLiveFragment.b(this.a, false);
      return;
    }
    localObject = this.a;
    if (paramPair.second != Boolean.TRUE) {
      bool = true;
    }
    QQGuildVideoBarLiveFragment.b((QQGuildVideoBarLiveFragment)localObject, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.QQGuildVideoBarLiveFragment.3
 * JD-Core Version:    0.7.0.1
 */