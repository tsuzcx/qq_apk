package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;

class TabBarView$1
  extends Handler
{
  TabBarView$1(TabBarView paramTabBarView) {}
  
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
        paramMessage = this.a;
        paramMessage.r = 1.0F;
        paramMessage.invalidate();
        this.a.c();
        return;
      }
      if (this.a.r < 1.0F)
      {
        paramMessage = this.a;
        d = paramMessage.r;
        Double.isNaN(d);
        paramMessage.r = ((float)(d + 0.1D));
        this.a.invalidate();
        sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(2), 10L);
      return;
    }
    paramMessage = this.a;
    paramMessage.r = 0.0F;
    double d = paramMessage.r;
    Double.isNaN(d);
    paramMessage.r = ((float)(d + 0.1D));
    this.a.invalidate();
    sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView.1
 * JD-Core Version:    0.7.0.1
 */