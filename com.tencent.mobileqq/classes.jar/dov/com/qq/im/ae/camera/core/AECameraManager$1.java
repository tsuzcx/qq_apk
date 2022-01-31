package dov.com.qq.im.ae.camera.core;

import ajng;
import azdf;
import bkoi;
import blbo;
import blfg;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$1
  implements Runnable
{
  public AECameraManager$1(bkoi parambkoi) {}
  
  public void run()
  {
    boolean bool = true;
    blfg.b("AECameraManager", "openCamera---cameraCreated=" + bkoi.a(this.this$0));
    if (bkoi.a(this.this$0)) {
      return;
    }
    bkoi.a(this.this$0, false);
    bkoi.a(this.this$0, 0);
    bkoi.b(this.this$0, 0);
    bkoi.a().a(this.this$0);
    bkoi.a().b(bkoi.a(this.this$0));
    bkoi.b(this.this$0, true);
    if (bkoi.a(this.this$0) != null) {
      bkoi.a(this.this$0).f();
    }
    ajng localajng;
    if (bkoi.a(this.this$0) != null)
    {
      localajng = bkoi.a(this.this$0);
      if (bkoi.a(this.this$0) != 1) {
        break label175;
      }
    }
    for (;;)
    {
      localajng.a(bool);
      ajli.a = bkoi.a(this.this$0);
      blbo.a().a("openCamera-end");
      return;
      label175:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.1
 * JD-Core Version:    0.7.0.1
 */