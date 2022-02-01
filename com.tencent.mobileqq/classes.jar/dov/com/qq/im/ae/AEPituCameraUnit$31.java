package dov.com.qq.im.ae;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.capture.QIMManager;

class AEPituCameraUnit$31
  implements Runnable
{
  AEPituCameraUnit$31(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_b_of_type_JavaLangString, 2, "onResourceDownload update filterpager begin");
    }
    FilterPagerViewStubHolder localFilterPagerViewStubHolder = this.this$0.a;
    if (this.this$0.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      localFilterPagerViewStubHolder.d(bool);
      ((AEMaterialManager)QIMManager.a(18)).b(false);
      dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_b_of_type_JavaLangString, 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.31
 * JD-Core Version:    0.7.0.1
 */