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
      CountDownProgressBar.a(paramMessage, CountDownProgressBar.a(paramMessage) + CountDownProgressBar.a(this.a));
      if (CountDownProgressBar.a(this.a) > (float)CountDownProgressBar.a(this.a))
      {
        paramMessage = this.a;
        CountDownProgressBar.a(paramMessage, (int)(CountDownProgressBar.a(paramMessage) / (float)CountDownProgressBar.a(this.a) * 360.0F));
        this.a.invalidate();
        if (CountDownProgressBar.a(this.a) != null) {
          CountDownProgressBar.a(this.a).a();
        }
      }
      else
      {
        paramMessage = this.a;
        CountDownProgressBar.a(paramMessage, (int)(CountDownProgressBar.a(paramMessage) / (float)CountDownProgressBar.a(this.a) * 360.0F));
        if (CountDownProgressBar.b(this.a) >= (float)CountDownProgressBar.b(this.a))
        {
          CountDownProgressBar.b(this.a, 0.0F);
          paramMessage = this.a;
          CountDownProgressBar.b(paramMessage, CountDownProgressBar.b(paramMessage) - 1);
        }
        else
        {
          paramMessage = this.a;
          CountDownProgressBar.b(paramMessage, CountDownProgressBar.b(paramMessage) + CountDownProgressBar.a(this.a));
        }
        this.a.invalidate();
        CountDownProgressBar.a(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.a));
      }
    }
    else
    {
      paramMessage = this.a;
      CountDownProgressBar.a(paramMessage, CountDownProgressBar.a(paramMessage) + CountDownProgressBar.a(this.a));
      CountDownProgressBar.a(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.CountDownProgressBar.1
 * JD-Core Version:    0.7.0.1
 */