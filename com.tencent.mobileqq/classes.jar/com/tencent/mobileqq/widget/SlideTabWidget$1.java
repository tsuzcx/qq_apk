package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;

class SlideTabWidget$1
  extends Handler
{
  SlideTabWidget$1(SlideTabWidget paramSlideTabWidget) {}
  
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
        SlideTabWidget.a(this.a, 1.0F);
        paramMessage = this.a;
        SlideTabWidget.a(paramMessage, SlideTabWidget.a(paramMessage));
        return;
      }
      if (SlideTabWidget.a(this.a) < 1.0F)
      {
        paramMessage = this.a;
        d = SlideTabWidget.a(paramMessage);
        Double.isNaN(d);
        SlideTabWidget.a(paramMessage, (float)(d + 0.1D));
        if (SlideTabWidget.a(this.a) >= 1.0F) {
          SlideTabWidget.a(this.a, false);
        }
        this.a.invalidate();
        sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(2), 10L);
      return;
    }
    SlideTabWidget.a(this.a, 0.0F);
    paramMessage = this.a;
    double d = SlideTabWidget.a(paramMessage);
    Double.isNaN(d);
    SlideTabWidget.a(paramMessage, (float)(d + 0.1D));
    this.a.invalidate();
    sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(1), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideTabWidget.1
 * JD-Core Version:    0.7.0.1
 */