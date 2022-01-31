package dov.com.qq.im.ae.camera.core;

import avsx;
import axhx;
import bijj;
import bizq;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(bijj parambijj, boolean paramBoolean) {}
  
  public void run()
  {
    bizq.b("AECameraManager", "forceStopCamera---BEGIN");
    bijj.a().a(false);
    bijj.a(this.this$0, false);
    bijj.a().b(bijj.b(this.this$0));
    bijj.b(this.this$0, false);
    if (bijj.a(this.this$0) != null) {
      bijj.a(this.this$0).g();
    }
    bijj.a().b(this.this$0);
    bijj.a().b(PeakAppInterface.a);
    if (!this.a) {
      avsx.a(bijj.a(this.this$0));
    }
    bizq.b("AECameraManager", "forceStopCamera---END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */