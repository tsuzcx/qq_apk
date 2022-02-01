package com.tencent.mobileqq.hotpic;

import android.os.Handler;
import android.os.Message;

class HotPicTab$1
  extends Handler
{
  HotPicTab$1(HotPicTab paramHotPicTab) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        HotPicTab.a(this.a, 1.0F);
        paramMessage = this.a;
        HotPicTab.a(paramMessage, HotPicTab.c(paramMessage));
        this.a.invalidate();
        return;
      }
      paramMessage = this.a;
      d = HotPicTab.a(paramMessage);
      Double.isNaN(d);
      HotPicTab.a(paramMessage, (float)(d + 0.1D));
      if (HotPicTab.a(this.a) < 1.0F)
      {
        this.a.invalidate();
        sendMessageDelayed(HotPicTab.b(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(HotPicTab.b(this.a).obtainMessage(2), 10L);
      return;
    }
    HotPicTab.a(this.a, 0.0F);
    paramMessage = this.a;
    double d = HotPicTab.a(paramMessage);
    Double.isNaN(d);
    HotPicTab.a(paramMessage, (float)(d + 0.1D));
    this.a.invalidate();
    sendMessageDelayed(HotPicTab.b(this.a).obtainMessage(1), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTab.1
 * JD-Core Version:    0.7.0.1
 */