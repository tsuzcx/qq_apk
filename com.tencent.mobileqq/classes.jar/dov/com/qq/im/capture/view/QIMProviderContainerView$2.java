package dov.com.qq.im.capture.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class QIMProviderContainerView$2
  implements Animator.AnimatorListener
{
  QIMProviderContainerView$2(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c.setVisibility(0);
    QIMProviderContainerView.a(this.a, true);
    QIMProviderContainerView.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "panelOpened : " + QIMProviderContainerView.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.2
 * JD-Core Version:    0.7.0.1
 */