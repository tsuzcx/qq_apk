package com.tencent.mobileqq.hotpic;

import android.os.Handler;
import android.os.Message;

class HotPicTab$1
  extends Handler
{
  HotPicTab$1(HotPicTab paramHotPicTab) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      HotPicTab.a(this.a, 0.0F);
      HotPicTab.a(this.a, (float)(HotPicTab.a(this.a) + 0.1D));
      this.a.invalidate();
      sendMessageDelayed(HotPicTab.a(this.a).obtainMessage(1), 10L);
      return;
    case 1: 
      HotPicTab.a(this.a, (float)(HotPicTab.a(this.a) + 0.1D));
      if (HotPicTab.a(this.a) < 1.0F)
      {
        this.a.invalidate();
        sendMessageDelayed(HotPicTab.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(HotPicTab.a(this.a).obtainMessage(2), 10L);
      return;
    }
    HotPicTab.a(this.a, 1.0F);
    HotPicTab.a(this.a, HotPicTab.a(this.a));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTab.1
 * JD-Core Version:    0.7.0.1
 */