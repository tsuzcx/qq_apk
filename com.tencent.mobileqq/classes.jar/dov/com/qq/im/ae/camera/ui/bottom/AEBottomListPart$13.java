package dov.com.qq.im.ae.camera.ui.bottom;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;

class AEBottomListPart$13
  implements Animation.AnimationListener
{
  AEBottomListPart$13(AEBottomListPart paramAEBottomListPart, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (!AEBottomListPart.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart)))
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(4);
    }
    if (AEBottomListPart.b(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart) != null)
    {
      AEBottomListPart.c(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart).a(this.jdField_a_of_type_Int, new Object[0]);
      AEBottomListPart.d(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListPart.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.13
 * JD-Core Version:    0.7.0.1
 */