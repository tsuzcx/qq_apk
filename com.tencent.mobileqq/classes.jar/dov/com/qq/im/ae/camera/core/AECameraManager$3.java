package dov.com.qq.im.ae.camera.core;

import axph;
import azho;
import bksp;
import bljn;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(bksp parambksp, boolean paramBoolean) {}
  
  public void run()
  {
    bljn.b("AECameraManager", "forceStopCamera---BEGIN");
    bksp.a().a(false);
    bksp.a(this.this$0, false);
    bksp.a().b(bksp.b(this.this$0));
    bksp.b(this.this$0, false);
    if (bksp.a(this.this$0) != null) {
      bksp.a(this.this$0).g();
    }
    bksp.a().b(this.this$0);
    bksp.a().b(PeakAppInterface.a);
    if (!this.a) {
      axph.a(bksp.a(this.this$0));
    }
    bljn.b("AECameraManager", "forceStopCamera---END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */