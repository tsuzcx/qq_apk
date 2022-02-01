package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;

class QIMCameraCaptureButtonLayoutNew$4
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCameraCaptureButtonLayoutNew$4(QIMCameraCaptureButtonLayoutNew paramQIMCameraCaptureButtonLayoutNew) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayoutNew.4
 * JD-Core Version:    0.7.0.1
 */