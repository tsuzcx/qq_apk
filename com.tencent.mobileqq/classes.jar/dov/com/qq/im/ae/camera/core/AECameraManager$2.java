package dov.com.qq.im.ae.camera.core;

import bijj;
import bizq;

public class AECameraManager$2
  implements Runnable
{
  public AECameraManager$2(bijj parambijj, boolean paramBoolean) {}
  
  public void run()
  {
    bizq.b("AECameraManager", "stopCamera---cameraCreated=" + bijj.a(this.this$0) + ", isGif=" + this.a);
    if (!bijj.a(this.this$0)) {
      return;
    }
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.2
 * JD-Core Version:    0.7.0.1
 */