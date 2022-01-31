package dov.com.qq.im.ae.camera.core;

import ahvy;
import axhx;
import bijj;
import biwd;
import bizq;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;

public class AECameraManager$1
  implements Runnable
{
  public AECameraManager$1(bijj parambijj) {}
  
  public void run()
  {
    boolean bool = true;
    bizq.b("AECameraManager", "openCamera---cameraCreated=" + bijj.a(this.this$0));
    if (bijj.a(this.this$0)) {
      return;
    }
    bijj.a(this.this$0, false);
    bijj.a(this.this$0, 0);
    bijj.b(this.this$0, 0);
    bijj.a().a(this.this$0);
    bijj.a().b(bijj.a(this.this$0));
    bijj.b(this.this$0, true);
    if (bijj.a(this.this$0) != null) {
      bijj.a(this.this$0).f();
    }
    ahvy localahvy;
    if (bijj.a(this.this$0) != null)
    {
      localahvy = bijj.a(this.this$0);
      if (bijj.a(this.this$0) != 1) {
        break label175;
      }
    }
    for (;;)
    {
      localahvy.a(bool);
      ahua.a = bijj.a(this.this$0);
      biwd.a().a("openCamera-end");
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