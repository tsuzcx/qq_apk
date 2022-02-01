package dov.com.qq.im.ae.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.graphics.Paint;

class AECMShowFaceScanView$4
  implements Animator.AnimatorListener
{
  AECMShowFaceScanView$4(AECMShowFaceScanView paramAECMShowFaceScanView, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowFaceScanView.a(this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView, false);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.d.setAlpha(255);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowFaceScanView.a(this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView, true);
    if (this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView$ScanViewListener != null) {
      this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView$ScanViewListener.G();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECMShowFaceScanView.4
 * JD-Core Version:    0.7.0.1
 */