package dov.com.qq.im.ae.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AECMShowFaceScanView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AECMShowFaceScanView$3(AECMShowFaceScanView paramAECMShowFaceScanView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AECMShowFaceScanView.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECMShowFaceScanView.3
 * JD-Core Version:    0.7.0.1
 */