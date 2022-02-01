package com.tencent.widget;

import android.os.Handler;
import android.os.Message;

class ProgressPieView$AnimationHandler
  extends Handler
{
  int mAnimateTo;
  boolean mHide;
  
  ProgressPieView$AnimationHandler(ProgressPieView paramProgressPieView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.this$0.mProgress > this.mAnimateTo)
    {
      paramMessage = this.this$0;
      paramMessage.setProgress(paramMessage.mProgress - 1);
      sendEmptyMessageDelayed(0, this.this$0.mAnimationSpeed);
      return;
    }
    if (this.this$0.mProgress < this.mAnimateTo)
    {
      int i = this.this$0.mProgress + this.this$0.mAnimationSpeedLevel;
      int j = this.mAnimateTo;
      if (i <= j) {
        this.this$0.setProgress(i);
      } else {
        this.this$0.setProgress(j);
      }
      sendEmptyMessageDelayed(0, this.this$0.mAnimationSpeed);
      return;
    }
    removeMessages(0);
    if (this.mHide)
    {
      this.this$0.setVisibility(4);
      this.this$0.setShowImage(false);
      this.this$0.mShowArc = true;
      this.mHide = false;
    }
  }
  
  public void setAnimateTo(int paramInt)
  {
    this.mAnimateTo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ProgressPieView.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */