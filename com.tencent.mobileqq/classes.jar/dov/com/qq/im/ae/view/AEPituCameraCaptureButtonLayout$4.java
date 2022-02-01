package dov.com.qq.im.ae.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;

class AEPituCameraCaptureButtonLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  AEPituCameraCaptureButtonLayout$4(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (!AEPituCameraCaptureButtonLayout.a(this.a))
    {
      this.a.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterScaleValue(f);
      return;
    }
    this.a.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout.4
 * JD-Core Version:    0.7.0.1
 */