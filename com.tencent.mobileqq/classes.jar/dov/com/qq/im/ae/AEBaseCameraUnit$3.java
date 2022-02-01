package dov.com.qq.im.ae;

import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraOpenCallback;
import dov.com.qq.im.ae.util.AEQLog;

class AEBaseCameraUnit$3
  implements AECameraManager.CameraOpenCallback
{
  AEBaseCameraUnit$3(AEBaseCameraUnit paramAEBaseCameraUnit) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    AEQLog.b(this.a.jdField_b_of_type_JavaLangString, "tryOpenCamera result=" + paramBoolean + ", whichCamera=" + paramInt + ", mActivityResume=" + this.a.jdField_b_of_type_Boolean);
    if (paramBoolean)
    {
      if (this.a.a != null) {
        this.a.a.onChangeCamera(paramInt);
      }
      if (this.a.c()) {
        CameraHelper.a(paramInt);
      }
      if (!this.a.jdField_b_of_type_Boolean) {
        this.a.d(false);
      }
    }
    else
    {
      return;
    }
    this.a.t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEBaseCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */