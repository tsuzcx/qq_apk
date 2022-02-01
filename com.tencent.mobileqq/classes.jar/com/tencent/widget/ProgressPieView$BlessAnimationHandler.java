package com.tencent.widget;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

class ProgressPieView$BlessAnimationHandler
  extends Handler
{
  int mDuration;
  boolean mHide;
  long startTime;
  
  ProgressPieView$BlessAnimationHandler(ProgressPieView paramProgressPieView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = (int)(SystemClock.elapsedRealtime() - this.startTime);
    if (i < this.this$0.mMax)
    {
      this.this$0.setProgress(i);
      sendEmptyMessageDelayed(0, 1L);
      return;
    }
    paramMessage = this.this$0;
    paramMessage.setProgress(paramMessage.mMax);
  }
  
  public void reset()
  {
    this.startTime = SystemClock.elapsedRealtime();
  }
  
  public void setAnimateDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ProgressPieView.BlessAnimationHandler
 * JD-Core Version:    0.7.0.1
 */