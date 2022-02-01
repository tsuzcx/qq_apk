package com.tencent.mobileqq.troop.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class AvatarWallViewPager$1
  extends Handler
{
  AvatarWallViewPager$1(AvatarWallViewPager paramAvatarWallViewPager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!AvatarWallViewPager.a(this.a))
    {
      if (!AvatarWallViewPager.b(this.a)) {
        return;
      }
      if (this.a.e.getCount() > 1)
      {
        paramMessage = this.a;
        paramMessage.p += 1;
        paramMessage = this.a;
        paramMessage.p %= this.a.e.getCount();
        this.a.c.setCurrentItem(this.a.p, true);
        this.a.r.sendMessageDelayed(this.a.r.obtainMessage(), 4000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager.1
 * JD-Core Version:    0.7.0.1
 */