package dov.com.qq.im.ae.camera.core;

import ahvw;
import axhz;
import bika;
import biwu;
import bjah;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$1
  implements Runnable
{
  public AECameraManager$1(bika parambika) {}
  
  public void run()
  {
    boolean bool = true;
    bjah.b("AECameraManager", "openCamera---cameraCreated=" + bika.a(this.this$0));
    if (bika.a(this.this$0)) {
      return;
    }
    bika.a(this.this$0, false);
    bika.a(this.this$0, 0);
    bika.b(this.this$0, 0);
    bika.a().a(this.this$0);
    bika.a().b(bika.a(this.this$0));
    bika.b(this.this$0, true);
    if (bika.a(this.this$0) != null) {
      bika.a(this.this$0).f();
    }
    ahvw localahvw;
    if (bika.a(this.this$0) != null)
    {
      localahvw = bika.a(this.this$0);
      if (bika.a(this.this$0) != 1) {
        break label175;
      }
    }
    for (;;)
    {
      localahvw.a(bool);
      ahty.a = bika.a(this.this$0);
      biwu.a().a("openCamera-end");
      return;
      label175:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.1
 * JD-Core Version:    0.7.0.1
 */