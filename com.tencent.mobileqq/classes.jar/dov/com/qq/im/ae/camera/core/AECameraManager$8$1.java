package dov.com.qq.im.ae.camera.core;

import bdbf;
import bdbk;
import com.tencent.qphone.base.util.QLog;

class AECameraManager$8$1
  implements bdbk
{
  AECameraManager$8$1(AECameraManager.8 param8) {}
  
  public void onAutoFocusCallback(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AECameraManager", 2, "onAutoFocusCallback single tap focus " + paramBoolean1 + ", camera2:" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      AECameraManager.access$402(this.this$1.this$0, true);
      return;
    }
    AECameraManager.access$800(this.this$1.this$0).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.8.1
 * JD-Core Version:    0.7.0.1
 */