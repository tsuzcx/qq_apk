package dov.com.qq.im.ae;

import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel.AEWaterMarkPanelListener;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;

class AEPituCameraUnit$3
  implements AEWaterMarkPanel.AEWaterMarkPanelListener
{
  AEPituCameraUnit$3(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a()
  {
    this.a.a.a(null);
    AECameraPrefsUtil.a().a("sp_key_ae_user_selected_watermark", "sp_val_ae_user_selected_watermark_none", 0);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a.a.a(paramAEMaterialMetaData);
    AECameraPrefsUtil.a().a("sp_key_ae_user_selected_watermark", paramAEMaterialMetaData.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */