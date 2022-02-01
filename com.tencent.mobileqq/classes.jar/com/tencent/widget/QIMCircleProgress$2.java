package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.qphone.base.util.QLog;

class QIMCircleProgress$2
  extends AnimatorListenerAdapter
{
  QIMCircleProgress$2(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.isCapturedSegmentBlink = false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] capturedSegmentBlinkAnimator cancel");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.this$0;
    paramAnimator.isCapturedSegmentBlink = false;
    if ((paramAnimator.needNextSegmentAnimation) && (this.this$0.nextSegmentBlinkAnimator != null)) {
      this.this$0.nextSegmentBlinkAnimator.start();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] capturedSegmentBlinkAnimator end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.isCapturedSegmentBlink = true;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "capturedSegmentBlinkAnimator start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.QIMCircleProgress.2
 * JD-Core Version:    0.7.0.1
 */