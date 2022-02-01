package dov.com.qq.im.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class AEProviderContainerView$2
  implements Animator.AnimatorListener
{
  AEProviderContainerView$2(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEProviderContainerView", 2, "panel opened");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView.2
 * JD-Core Version:    0.7.0.1
 */