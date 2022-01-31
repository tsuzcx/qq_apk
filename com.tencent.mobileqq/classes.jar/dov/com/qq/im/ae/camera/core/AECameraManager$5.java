package dov.com.qq.im.ae.camera.core;

import axhz;
import bika;
import bjah;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(bika parambika) {}
  
  public void run()
  {
    if ((bika.a(this.this$0) != null) && (bika.a(this.this$0)))
    {
      if (!bika.c(this.this$0)) {
        bika.a(this.this$0);
      }
      while ((bika.b(this.this$0) == this.this$0.a) && (bika.c(this.this$0) == this.this$0.b)) {
        return;
      }
      bika.a().a(true);
      bika.a(this.this$0, false);
      bika.a(this.this$0);
      return;
    }
    bjah.b("AECameraManager", "### startCameraPreview failed: mSurfaceTexture = " + bika.a(this.this$0) + ", cameraCreated = " + bika.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */