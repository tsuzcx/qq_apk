package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;

class ProgressPieDrawable$AnimationHandler
  extends Handler
{
  public int a;
  
  ProgressPieDrawable$AnimationHandler(ProgressPieDrawable paramProgressPieDrawable) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.b.isVisible())
    {
      this.b.e = this.a;
      return;
    }
    if (this.b.e > this.a)
    {
      paramMessage = this.b;
      paramMessage.d(paramMessage.e - 1);
      sendEmptyMessageDelayed(0, this.b.z);
      return;
    }
    if (this.b.e < this.a)
    {
      int i = this.b.e + this.b.A;
      int j = this.a;
      if (i <= j) {
        this.b.d(i);
      } else {
        this.b.d(j);
      }
      sendEmptyMessageDelayed(0, this.b.z);
      return;
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressPieDrawable.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */