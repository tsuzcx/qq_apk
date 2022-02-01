package dov.com.qq.im.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.util.AEQLog;

class AEMaterialPanel$4
  implements Animation.AnimationListener
{
  AEMaterialPanel$4(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, false);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel) != null) {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel).b();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, true);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel) != null)
    {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel).setAlpha(1.0F);
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel).setVisibility(0);
      return;
    }
    AEQLog.d("AEMaterialPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.4
 * JD-Core Version:    0.7.0.1
 */