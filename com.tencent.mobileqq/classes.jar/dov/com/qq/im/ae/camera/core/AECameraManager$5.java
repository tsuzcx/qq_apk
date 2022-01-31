package dov.com.qq.im.ae.camera.core;

import azho;
import bksp;
import bljn;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(bksp parambksp) {}
  
  public void run()
  {
    if ((bksp.a(this.this$0) != null) && (bksp.a(this.this$0)))
    {
      if (!bksp.c(this.this$0)) {
        bksp.a(this.this$0);
      }
      while ((bksp.b(this.this$0) == this.this$0.a) && (bksp.c(this.this$0) == this.this$0.b)) {
        return;
      }
      bksp.a().a(true);
      bksp.a(this.this$0, false);
      bksp.a(this.this$0);
      return;
    }
    bljn.b("AECameraManager", "### startCameraPreview failed: mSurfaceTexture = " + bksp.a(this.this$0) + ", cameraCreated = " + bksp.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */