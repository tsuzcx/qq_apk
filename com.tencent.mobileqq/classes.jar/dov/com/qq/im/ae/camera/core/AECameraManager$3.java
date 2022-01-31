package dov.com.qq.im.ae.camera.core;

import axky;
import azdf;
import bkoi;
import blfg;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(bkoi parambkoi, boolean paramBoolean) {}
  
  public void run()
  {
    blfg.b("AECameraManager", "forceStopCamera---BEGIN");
    bkoi.a().a(false);
    bkoi.a(this.this$0, false);
    bkoi.a().b(bkoi.b(this.this$0));
    bkoi.b(this.this$0, false);
    if (bkoi.a(this.this$0) != null) {
      bkoi.a(this.this$0).g();
    }
    bkoi.a().b(this.this$0);
    bkoi.a().b(PeakAppInterface.a);
    if (!this.a) {
      axky.a(bkoi.a(this.this$0));
    }
    blfg.b("AECameraManager", "forceStopCamera---END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */