package dov.com.qq.im.ae.camera.core;

import bika;
import bjah;

public class AECameraManager$2
  implements Runnable
{
  public AECameraManager$2(bika parambika, boolean paramBoolean) {}
  
  public void run()
  {
    bjah.b("AECameraManager", "stopCamera---cameraCreated=" + bika.a(this.this$0) + ", isGif=" + this.a);
    if (!bika.a(this.this$0)) {
      return;
    }
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.2
 * JD-Core Version:    0.7.0.1
 */