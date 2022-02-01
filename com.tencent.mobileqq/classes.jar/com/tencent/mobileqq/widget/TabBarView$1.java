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
        TabBarView.a(paramMessage, paramMessage.o, this.a.n);
        paramMessage = this.a;
        paramMessage.a = 1.0F;
        TabBarView.b(paramMessage, paramMessage.o, this.a.n);
        paramMessage = this.a;
        paramMessage.o = paramMessage.n;
        this.a.invalidate();
        TabBarView.a(this.a);
        return;
      }
      if (this.a.a < 1.0F)
      {
        paramMessage = this.a;
        d = paramMessage.a;
        Double.isNaN(d);
        paramMessage.a = ((float)(d + 0.1D));
        this.a.invalidate();
        sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(2), 10L);
      return;
    }
    paramMessage = this.a;
    paramMessage.a = 0.0F;
    double d = paramMessage.a;
    Double.isNaN(d);
    paramMessage.a = ((float)(d + 0.1D));
    this.a.invalidate();
    sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView.1
 * JD-Core Version:    0.7.0.1
 */