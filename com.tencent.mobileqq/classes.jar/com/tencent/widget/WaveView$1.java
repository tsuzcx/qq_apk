package com.tencent.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class WaveView$1
  implements Handler.Callback
{
  WaveView$1(WaveView paramWaveView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1003: 
      WaveView.a(this.a).removeMessages(1001);
      WaveView.a(this.a).removeMessages(1002);
      break;
    case 1002: 
      this.a.invalidate();
      paramMessage = this.a;
      WaveView.a(paramMessage, (WaveView.a(paramMessage) - WaveView.b(this.a)) % WaveView.c(this.a));
      paramMessage = this.a;
      WaveView.b(paramMessage, WaveView.d(paramMessage) + WaveView.b(this.a));
      if (WaveView.d(this.a) > 0)
      {
        paramMessage = this.a;
        WaveView.b(paramMessage, WaveView.d(paramMessage) - WaveView.c(this.a));
      }
      WaveView.a(this.a).removeMessages(1002);
      WaveView.a(this.a).sendEmptyMessageDelayed(1002, 40L);
      break;
    case 1001: 
      this.a.invalidate();
      paramMessage = this.a;
      WaveView.a(paramMessage, (WaveView.a(paramMessage) - WaveView.b(this.a)) % WaveView.c(this.a));
      paramMessage = this.a;
      WaveView.b(paramMessage, WaveView.d(paramMessage) + WaveView.b(this.a));
      if (WaveView.d(this.a) > 0)
      {
        paramMessage = this.a;
        WaveView.b(paramMessage, WaveView.d(paramMessage) - WaveView.c(this.a));
      }
      WaveView.a(this.a).sendEmptyMessageDelayed(1002, 40L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.WaveView.1
 * JD-Core Version:    0.7.0.1
 */