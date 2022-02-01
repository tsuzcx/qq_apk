package com.tencent.mtt.hippy.dom;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class e$d
  extends Handler
{
  public e$d(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
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
        this.a.a(paramMessage.arg1);
        return;
      }
      this.a.b();
      return;
    }
    this.a.a(System.nanoTime(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e.d
 * JD-Core Version:    0.7.0.1
 */