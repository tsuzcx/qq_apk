package dov.com.qq.im.ae.camera.core;

import bkoi;
import blfg;

public class AECameraManager$2
  implements Runnable
{
  public AECameraManager$2(bkoi parambkoi, boolean paramBoolean) {}
  
  public void run()
  {
    blfg.b("AECameraManager", "stopCamera---cameraCreated=" + bkoi.a(this.this$0) + ", isGif=" + this.a);
    if (!bkoi.a(this.this$0)) {
      return;
    }
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.2
 * JD-Core Version:    0.7.0.1
 */