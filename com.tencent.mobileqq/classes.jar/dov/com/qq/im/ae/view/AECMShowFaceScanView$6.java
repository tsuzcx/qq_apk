package dov.com.qq.im.ae.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AECMShowFaceScanView$6
  implements Animator.AnimatorListener
{
  AECMShowFaceScanView$6(AECMShowFaceScanView paramAECMShowFaceScanView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowFaceScanView.b(this.a, false);
    if (this.a.a != null) {
      this.a.a.F();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowFaceScanView.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECMShowFaceScanView.6
 * JD-Core Version:    0.7.0.1
 */