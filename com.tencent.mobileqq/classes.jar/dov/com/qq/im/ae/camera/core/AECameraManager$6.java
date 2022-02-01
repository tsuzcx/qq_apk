package dov.com.qq.im.ae.camera.core;

import bcio;
import bnho;
import bnzb;
import java.util.concurrent.atomic.AtomicInteger;

public class AECameraManager$6
  implements Runnable
{
  public AECameraManager$6(bnho parambnho) {}
  
  public void run()
  {
    bnzb.b("AECameraManager", "cameraStopPreview---ENTER");
    if (!bnho.b(this.this$0))
    {
      bnzb.d("AECameraManager", "cameraStopPreview---EXIT, is not previewing");
      return;
    }
    bnho.a(this.this$0).a(false);
    bnho.a(this.this$0).set(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.6
 * JD-Core Version:    0.7.0.1
 */