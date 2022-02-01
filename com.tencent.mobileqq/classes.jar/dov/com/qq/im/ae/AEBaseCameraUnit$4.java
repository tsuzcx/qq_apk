package dov.com.qq.im.ae;

import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

class AEBaseCameraUnit$4
  implements CameraCover.PictureCallback
{
  AEBaseCameraUnit$4(AEBaseCameraUnit paramAEBaseCameraUnit) {}
  
  public void a(String paramString)
  {
    paramString = new AEPhotoCaptureResult(1, 0, paramString, null, this.a.a.getEffectOrientation());
    this.a.onPhotoCaptured(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEBaseCameraUnit.4
 * JD-Core Version:    0.7.0.1
 */