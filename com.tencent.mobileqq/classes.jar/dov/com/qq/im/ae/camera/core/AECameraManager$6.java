package dov.com.qq.im.ae.camera.core;

import bbuk;
import bmbx;
import java.util.concurrent.atomic.AtomicInteger;

class AECameraManager$6
  implements Runnable
{
  AECameraManager$6(AECameraManager paramAECameraManager) {}
  
  public void run()
  {
    bmbx.b("AECameraManager", "cameraStopPreview---ENTER");
    if (!AECameraManager.access$600(this.this$0))
    {
      bmbx.d("AECameraManager", "cameraStopPreview---EXIT, is not previewing");
      return;
    }
    AECameraManager.access$800(this.this$0).a(false);
    AECameraManager.access$900(this.this$0).set(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.6
 * JD-Core Version:    0.7.0.1
 */