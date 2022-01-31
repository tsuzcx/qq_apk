package dov.com.qq.im.ae.camera.core;

import azdf;
import bkoi;
import blfg;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(bkoi parambkoi) {}
  
  public void run()
  {
    if ((bkoi.a(this.this$0) != null) && (bkoi.a(this.this$0)))
    {
      if (!bkoi.c(this.this$0)) {
        bkoi.a(this.this$0);
      }
      while ((bkoi.b(this.this$0) == this.this$0.a) && (bkoi.c(this.this$0) == this.this$0.b)) {
        return;
      }
      bkoi.a().a(true);
      bkoi.a(this.this$0, false);
      bkoi.a(this.this$0);
      return;
    }
    blfg.b("AECameraManager", "### startCameraPreview failed: mSurfaceTexture = " + bkoi.a(this.this$0) + ", cameraCreated = " + bkoi.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */