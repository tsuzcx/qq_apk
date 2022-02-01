package dov.com.qq.im.ae;

import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.AEMaterialPanelListener;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.util.AEQLog;

class AEPituCameraUnit$2
  implements AEMaterialPanel.AEMaterialPanelListener
{
  AEPituCameraUnit$2(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a()
  {
    this.a.a.a(null);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (this.a.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      this.a.a.a(paramAEMaterialMetaData);
      return;
    }
    AEQLog.d(this.a.jdField_b_of_type_JavaLangString, "onMaterialSelected---but current capture mode is not normal");
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */