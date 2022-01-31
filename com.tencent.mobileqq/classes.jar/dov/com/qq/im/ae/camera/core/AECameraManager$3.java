package dov.com.qq.im.ae.camera.core;

import avsz;
import axhz;
import bika;
import bjah;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(bika parambika, boolean paramBoolean) {}
  
  public void run()
  {
    bjah.b("AECameraManager", "forceStopCamera---BEGIN");
    bika.a().a(false);
    bika.a(this.this$0, false);
    bika.a().b(bika.b(this.this$0));
    bika.b(this.this$0, false);
    if (bika.a(this.this$0) != null) {
      bika.a(this.this$0).g();
    }
    bika.a().b(this.this$0);
    bika.a().b(PeakAppInterface.a);
    if (!this.a) {
      avsz.a(bika.a(this.this$0));
    }
    bjah.b("AECameraManager", "forceStopCamera---END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */