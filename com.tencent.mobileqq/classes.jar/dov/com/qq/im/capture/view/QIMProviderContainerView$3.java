package dov.com.qq.im.capture.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QIMProviderContainerView$3
  implements Animation.AnimationListener
{
  QIMProviderContainerView$3(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QIMProviderContainerView.a(this.a) != null)
    {
      QIMProviderContainerView.a(this.a).setAlpha(1.0F);
      QIMProviderContainerView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.3
 * JD-Core Version:    0.7.0.1
 */