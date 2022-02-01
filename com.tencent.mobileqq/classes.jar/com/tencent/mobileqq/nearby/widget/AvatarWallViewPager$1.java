package com.tencent.mobileqq.nearby.widget;

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
    if (this.a.f.c() > 1)
    {
      paramMessage = this.a;
      paramMessage.w += 1;
      paramMessage = this.a;
      paramMessage.w %= this.a.f.c();
      this.a.d.setCurrentItem(this.a.w, true);
      this.a.x.sendMessageDelayed(this.a.x.obtainMessage(), this.a.p);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.1
 * JD-Core Version:    0.7.0.1
 */