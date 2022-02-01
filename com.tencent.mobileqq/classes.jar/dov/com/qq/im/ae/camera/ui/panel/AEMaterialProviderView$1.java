package dov.com.qq.im.ae.camera.ui.panel;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;

class AEMaterialProviderView$1
  extends CaptureConfigUpdateObserver
{
  AEMaterialProviderView$1(AEMaterialProviderView paramAEMaterialProviderView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialProviderView", 2, "material list updated!");
    }
    if (AEMaterialProviderView.a(this.a)) {
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView.1
 * JD-Core Version:    0.7.0.1
 */