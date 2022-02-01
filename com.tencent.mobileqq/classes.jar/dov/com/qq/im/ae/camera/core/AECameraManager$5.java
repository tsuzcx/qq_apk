package dov.com.qq.im.ae.camera.core;

import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.activity.richmedia.Size;
import dov.com.qq.im.ae.util.AEQLog;

class AECameraManager$5
  implements Runnable
{
  AECameraManager$5(AECameraManager paramAECameraManager, SurfaceTexture paramSurfaceTexture, Size paramSize) {}
  
  public void run()
  {
    if (!AECameraManager.access$500(this.this$0))
    {
      AEQLog.d("AECameraManager", "startCameraPreview EXIT: camera NOT created");
      return;
    }
    if (AECameraManager.access$600(this.this$0))
    {
      AEQLog.d("AECameraManager", "startCameraPreview EXIT: camera is already previewing");
      return;
    }
    AECameraManager.access$700(this.this$0, this.val$previewTexture, this.val$previewSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */