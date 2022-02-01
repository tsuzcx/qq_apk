package com.tencent.mobileqq.kandian.base.view.widget;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicBoolean;

class BaseTabbar$1
  extends Handler
{
  BaseTabbar$1(BaseTabbar paramBaseTabbar) {}
  
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
        BaseTabbar.e(this.a);
        paramMessage = this.a;
        paramMessage.a(BaseTabbar.c(paramMessage), BaseTabbar.d(this.a));
        BaseTabbar.a(this.a, 1.0F);
        paramMessage = this.a;
        BaseTabbar.a(paramMessage, BaseTabbar.d(paramMessage));
        this.a.invalidate();
        BaseTabbar.f(this.a).set(false);
        return;
      }
      if (BaseTabbar.a(this.a) < 1.0F)
      {
        paramMessage = this.a;
        d = BaseTabbar.a(paramMessage);
        Double.isNaN(d);
        BaseTabbar.a(paramMessage, (float)(d + 0.05D));
        this.a.invalidate();
        sendMessageDelayed(BaseTabbar.b(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(BaseTabbar.b(this.a).obtainMessage(2), 10L);
      return;
    }
    BaseTabbar.a(this.a, 0.0F);
    BaseTabbar localBaseTabbar = this.a;
    double d = BaseTabbar.a(localBaseTabbar);
    Double.isNaN(d);
    BaseTabbar.a(localBaseTabbar, (float)(d + 0.05D));
    this.a.invalidate();
    i = paramMessage.arg1;
    sendMessageDelayed(BaseTabbar.b(this.a).obtainMessage(1), 10L);
    if (i != 1)
    {
      paramMessage = this.a;
      BaseTabbar.a(paramMessage, BaseTabbar.c(paramMessage), BaseTabbar.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.1
 * JD-Core Version:    0.7.0.1
 */