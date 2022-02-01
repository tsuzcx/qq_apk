package dov.com.qq.im.capture.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.capture.AbsQIMCaptureController;

class QIMProviderContainerView$5
  implements Animation.AnimationListener
{
  QIMProviderContainerView$5(QIMProviderContainerView paramQIMProviderContainerView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMProviderContainerView.a(this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView) != null)
    {
      QIMProviderContainerView.a(this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView).setAlpha(1.0F);
      QIMProviderContainerView.a(this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView).setVisibility(8);
    }
    if ((!this.jdField_a_of_type_Boolean) && (QIMProviderContainerView.a(this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView) != null)) {
      QIMProviderContainerView.a(this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView).a(false, 150);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.5
 * JD-Core Version:    0.7.0.1
 */