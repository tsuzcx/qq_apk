package dov.com.qq.im.AECamera.View;

import ahjh;
import awir;
import bgys;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$1
  implements Runnable
{
  public AECameraManager$1(bgys parambgys) {}
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(bgys.b(), 2, " startCamera: " + bgys.a(this.this$0));
    }
    if (bgys.a(this.this$0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(bgys.b(), 2, "startCamera");
    }
    bgys.a(this.this$0, false);
    bgys.a(this.this$0, 0);
    bgys.b(this.this$0, 0);
    bgys.a().a(this.this$0);
    bgys.a().b(bgys.a(this.this$0));
    bgys.b(this.this$0, true);
    if (bgys.a(this.this$0) != null) {
      bgys.a(this.this$0).f();
    }
    ahjh localahjh;
    if (bgys.a(this.this$0) != null)
    {
      localahjh = bgys.a(this.this$0);
      if (bgys.a(this.this$0) != 1) {
        break label199;
      }
    }
    for (;;)
    {
      localahjh.a(bool);
      QLog.d(bgys.b(), 4, "###  startCamera");
      ahhj.a = bgys.a(this.this$0);
      return;
      label199:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraManager.1
 * JD-Core Version:    0.7.0.1
 */