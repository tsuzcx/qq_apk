package com.tencent.widget;

import android.os.Handler;
import android.os.Message;

class CountDownProgressBar$1
  extends Handler
{
  CountDownProgressBar$1(CountDownProgressBar paramCountDownProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramMessage = this.a;
      CountDownProgressBar.a(paramMessage, CountDownProgressBar.a(paramMessage) + CountDownProgressBar.b(this.a));
      if (CountDownProgressBar.a(this.a) > (float)CountDownProgressBar.d(this.a))
      {
        paramMessage = this.a;
        CountDownProgressBar.a(paramMessage, (int)(CountDownProgressBar.a(paramMessage) / (float)CountDownProgressBar.d(this.a) * 360.0F));
        this.a.invalidate();
        if (CountDownProgressBar.e(this.a) != null) {
          CountDownProgressBar.e(this.a).a();
        }
      }
      else
      {
        paramMessage = this.a;
        CountDownProgressBar.a(paramMessage, (int)(CountDownProgressBar.a(paramMessage) / (float)CountDownProgressBar.d(this.a) * 360.0F));
        if (CountDownProgressBar.f(this.a) >= (float)CountDownProgressBar.g(this.a))
        {
          CountDownProgressBar.b(this.a, 0.0F);
          paramMessage = this.a;
          CountDownProgressBar.b(paramMessage, CountDownProgressBar.h(paramMessage) - 1);
        }
        else
        {
          paramMessage = this.a;
          CountDownProgressBar.b(paramMessage, CountDownProgressBar.f(paramMessage) + CountDownProgressBar.b(this.a));
        }
        this.a.invalidate();
        CountDownProgressBar.c(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.b(this.a));
      }
    }
    else
    {
      paramMessage = this.a;
      CountDownProgressBar.a(paramMessage, CountDownProgressBar.a(paramMessage) + CountDownProgressBar.b(this.a));
      CountDownProgressBar.c(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.CountDownProgressBar.1
 * JD-Core Version:    0.7.0.1
 */