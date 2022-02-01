package dov.com.qq.im.ae;

import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraOpenCallback;

class AEPituCameraUnit$39
  implements AECameraManager.CameraOpenCallback
{
  AEPituCameraUnit$39(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.c()) {
        CameraHelper.a(paramInt);
      }
      if (this.a.b) {
        this.a.t();
      }
    }
    else
    {
      return;
    }
    this.a.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.39
 * JD-Core Version:    0.7.0.1
 */