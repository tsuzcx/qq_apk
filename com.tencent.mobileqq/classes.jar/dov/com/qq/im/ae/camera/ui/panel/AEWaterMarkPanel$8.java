package dov.com.qq.im.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;

class AEWaterMarkPanel$8
  implements Animation.AnimationListener
{
  AEWaterMarkPanel$8(AEWaterMarkPanel paramAEWaterMarkPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEWaterMarkPanel.b(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel, false);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEWaterMarkPanel.b(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel, true);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a.setVisibility(0);
      AEBaseDataReporter.a().ar();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a.a();
      return;
    }
    AEQLog.d("AEWaterMarkPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel.8
 * JD-Core Version:    0.7.0.1
 */