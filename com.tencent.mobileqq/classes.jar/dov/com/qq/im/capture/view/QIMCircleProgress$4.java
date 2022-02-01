package dov.com.qq.im.capture.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class QIMCircleProgress$4
  extends AnimatorListenerAdapter
{
  QIMCircleProgress$4(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] nextSegmentBlinkAnimator cancel");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] nextSegmentBlinkAnimator end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] nextSegmentBlinkAnimator start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMCircleProgress.4
 * JD-Core Version:    0.7.0.1
 */