package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;

class RotateableView$1
  extends Handler
{
  RotateableView$1(RotateableView paramRotateableView) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = this.a;
    RotateableView.a(paramMessage, RotateableView.a(paramMessage) + 8.0F);
    if (RotateableView.a(this.a) >= 360.0F)
    {
      paramMessage = this.a;
      RotateableView.a(paramMessage, RotateableView.a(paramMessage) - 360.0F);
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateableView.1
 * JD-Core Version:    0.7.0.1
 */