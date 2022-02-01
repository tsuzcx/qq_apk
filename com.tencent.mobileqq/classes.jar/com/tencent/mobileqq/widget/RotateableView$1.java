package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;

class RotateableView$1
  extends Handler
{
  RotateableView$1(RotateableView paramRotateableView) {}
  
  public void handleMessage(Message paramMessage)
  {
    RotateableView.a(this.a, RotateableView.a(this.a) + 8.0F);
    if (RotateableView.a(this.a) >= 360.0F) {
      RotateableView.a(this.a, RotateableView.a(this.a) - 360.0F);
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateableView.1
 * JD-Core Version:    0.7.0.1
 */