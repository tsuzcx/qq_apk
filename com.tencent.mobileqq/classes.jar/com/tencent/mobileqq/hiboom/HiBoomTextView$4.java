package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class HiBoomTextView$4
  extends Handler
{
  HiBoomTextView$4(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 258)
    {
      if (i != 260) {
        return;
      }
      if (HiBoomTextView.j() != null)
      {
        HiBoomTextView.j().recycle();
        HiBoomTextView.a(null);
      }
    }
    else
    {
      HiBoomTextView.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.4
 * JD-Core Version:    0.7.0.1
 */