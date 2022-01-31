package dov.com.qq.im.ae.camera.core;

import ajrv;
import azho;
import bksp;
import blfv;
import bljn;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$1
  implements Runnable
{
  public AECameraManager$1(bksp parambksp) {}
  
  public void run()
  {
    boolean bool = true;
    bljn.b("AECameraManager", "openCamera---cameraCreated=" + bksp.a(this.this$0));
    if (bksp.a(this.this$0)) {
      return;
    }
    bksp.a(this.this$0, false);
    bksp.a(this.this$0, 0);
    bksp.b(this.this$0, 0);
    bksp.a().a(this.this$0);
    bksp.a().b(bksp.a(this.this$0));
    bksp.b(this.this$0, true);
    if (bksp.a(this.this$0) != null) {
      bksp.a(this.this$0).f();
    }
    ajrv localajrv;
    if (bksp.a(this.this$0) != null)
    {
      localajrv = bksp.a(this.this$0);
      if (bksp.a(this.this$0) != 1) {
        break label175;
      }
    }
    for (;;)
    {
      localajrv.a(bool);
      ajpx.a = bksp.a(this.this$0);
      blfv.a().a("openCamera-end");
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