package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;

class QIMCameraSegmentCaptureButtonLayoutNew$7
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCameraSegmentCaptureButtonLayoutNew$7(QIMCameraSegmentCaptureButtonLayoutNew paramQIMCameraSegmentCaptureButtonLayoutNew) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayoutNew.7
 * JD-Core Version:    0.7.0.1
 */