package dov.com.qq.im.ae.camera.core;

import akur;
import android.graphics.SurfaceTexture;
import bmbx;

class AECameraManager$5
  implements Runnable
{
  AECameraManager$5(AECameraManager paramAECameraManager, SurfaceTexture paramSurfaceTexture, akur paramakur) {}
  
  public void run()
  {
    if (!AECameraManager.access$500(this.this$0))
    {
      bmbx.d("AECameraManager", "startCameraPreview EXIT: camera NOT created");
      return;
    }
    if (AECameraManager.access$600(this.this$0))
    {
      bmbx.d("AECameraManager", "startCameraPreview EXIT: camera is already previewing");
      return;
    }
    AECameraManager.access$700(this.this$0, this.val$previewTexture, this.val$previewSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */