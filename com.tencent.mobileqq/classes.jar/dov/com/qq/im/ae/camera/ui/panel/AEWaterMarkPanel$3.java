package dov.com.qq.im.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AEWaterMarkPanel$3
  implements Animator.AnimatorListener
{
  AEWaterMarkPanel$3(AEWaterMarkPanel paramAEWaterMarkPanel, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEWaterMarkPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel, false);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEWaterMarkPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel.3
 * JD-Core Version:    0.7.0.1
 */