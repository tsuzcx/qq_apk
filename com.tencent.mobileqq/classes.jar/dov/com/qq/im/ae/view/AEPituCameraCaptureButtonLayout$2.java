package dov.com.qq.im.ae.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEPituCameraCaptureButtonLayout$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AEPituCameraCaptureButtonLayout$2(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout.2
 * JD-Core Version:    0.7.0.1
 */