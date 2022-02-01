package dov.com.qq.im.ae;

import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraOpenCallback;

class AEBaseCameraUnit$2
  implements AECameraManager.CameraOpenCallback
{
  AEBaseCameraUnit$2(AEBaseCameraUnit paramAEBaseCameraUnit) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a.onChangeCamera(paramInt);
      if (this.a.c()) {
        CameraHelper.a(paramInt);
      }
      this.a.n();
      this.a.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEBaseCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */