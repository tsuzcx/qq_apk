package dov.com.qq.im.ae;

import bmxa;
import dov.com.qq.im.ae.camera.core.AECameraManager;

public class AEPituCameraUnit$14
  implements Runnable
{
  public AEPituCameraUnit$14(bmxa parambmxa) {}
  
  public void run()
  {
    if ((this.this$0.a.isFlashEnabled()) && (!bmxa.a(this.this$0))) {
      this.this$0.a.turnFlash(this.this$0.a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.14
 * JD-Core Version:    0.7.0.1
 */