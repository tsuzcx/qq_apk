package dov.com.qq.im.ae;

import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture.ZoomGestureListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.util.AEQLog;

class AEPituCameraUnit$5
  implements CameraZoomGesture.ZoomGestureListener
{
  AEPituCameraUnit$5(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(int paramInt)
  {
    AEQLog.a(this.a.b, "onRequestZoom: " + paramInt);
    this.a.a.setZoom(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.5
 * JD-Core Version:    0.7.0.1
 */