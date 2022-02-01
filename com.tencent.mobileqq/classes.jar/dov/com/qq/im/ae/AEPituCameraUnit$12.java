package dov.com.qq.im.ae;

import bljy;
import dov.com.qq.im.ae.camera.core.AECameraManager;

public class AEPituCameraUnit$12
  implements Runnable
{
  public AEPituCameraUnit$12(bljy parambljy) {}
  
  public void run()
  {
    if ((this.this$0.a.isFlashEnabled()) && (!bljy.a(this.this$0))) {
      this.this$0.a.turnFlash(this.this$0.a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.12
 * JD-Core Version:    0.7.0.1
 */