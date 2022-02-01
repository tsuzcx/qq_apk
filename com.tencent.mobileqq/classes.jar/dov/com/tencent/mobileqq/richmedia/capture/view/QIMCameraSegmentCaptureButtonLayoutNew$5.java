package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMCameraSegmentCaptureButtonLayoutNew$5
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCameraSegmentCaptureButtonLayoutNew$5(QIMCameraSegmentCaptureButtonLayoutNew paramQIMCameraSegmentCaptureButtonLayoutNew) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayoutNew.5
 * JD-Core Version:    0.7.0.1
 */