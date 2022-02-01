package dov.com.qq.im.ae.camera.ui.bottom;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class AEBottomListPart$11
  implements Animator.AnimatorListener
{
  AEBottomListPart$11(AEBottomListPart paramAEBottomListPart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEBottomListPart", 2, "Watermark Panel Opened!");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.11
 * JD-Core Version:    0.7.0.1
 */