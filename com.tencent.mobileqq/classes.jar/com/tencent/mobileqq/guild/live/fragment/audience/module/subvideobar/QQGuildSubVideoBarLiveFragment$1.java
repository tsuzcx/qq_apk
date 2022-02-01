package com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar;

import android.os.Handler;
import android.view.View;
import androidx.lifecycle.Observer;

class QQGuildSubVideoBarLiveFragment$1
  implements Observer<Boolean>
{
  QQGuildSubVideoBarLiveFragment$1(QQGuildSubVideoBarLiveFragment paramQQGuildSubVideoBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    QQGuildSubVideoBarLiveFragment localQQGuildSubVideoBarLiveFragment = this.a;
    boolean bool;
    if (paramBoolean == Boolean.TRUE) {
      bool = true;
    } else {
      bool = false;
    }
    QQGuildSubVideoBarLiveFragment.a(localQQGuildSubVideoBarLiveFragment, bool);
    QQGuildSubVideoBarLiveFragment.a(this.a).removeCallbacksAndMessages(null);
    QQGuildSubVideoBarLiveFragment.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment.1
 * JD-Core Version:    0.7.0.1
 */