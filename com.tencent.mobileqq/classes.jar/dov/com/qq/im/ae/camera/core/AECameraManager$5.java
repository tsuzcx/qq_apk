package dov.com.qq.im.ae.camera.core;

import axhx;
import bijj;
import bizq;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(bijj parambijj) {}
  
  public void run()
  {
    if ((bijj.a(this.this$0) != null) && (bijj.a(this.this$0)))
    {
      if (!bijj.c(this.this$0)) {
        bijj.a(this.this$0);
      }
      while ((bijj.b(this.this$0) == this.this$0.a) && (bijj.c(this.this$0) == this.this$0.b)) {
        return;
      }
      bijj.a().a(true);
      bijj.a(this.this$0, false);
      bijj.a(this.this$0);
      return;
    }
    bizq.b("AECameraManager", "### startCameraPreview failed: mSurfaceTexture = " + bijj.a(this.this$0) + ", cameraCreated = " + bijj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */