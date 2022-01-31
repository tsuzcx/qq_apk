package dov.com.qq.im.ae.camera.core;

import bksp;
import bljn;

public class AECameraManager$2
  implements Runnable
{
  public AECameraManager$2(bksp parambksp, boolean paramBoolean) {}
  
  public void run()
  {
    bljn.b("AECameraManager", "stopCamera---cameraCreated=" + bksp.a(this.this$0) + ", isGif=" + this.a);
    if (!bksp.a(this.this$0)) {
      return;
    }
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.2
 * JD-Core Version:    0.7.0.1
 */