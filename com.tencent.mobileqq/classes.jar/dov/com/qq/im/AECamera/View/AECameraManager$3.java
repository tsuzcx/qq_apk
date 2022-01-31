package dov.com.qq.im.AECamera.View;

import auto;
import awir;
import bgys;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(bgys parambgys) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(bgys.b(), 2, "stopCamera");
    }
    bgys.a().a(false);
    bgys.a(this.this$0, false);
    bgys.a().b(bgys.b(this.this$0));
    bgys.b(this.this$0, false);
    if (bgys.a(this.this$0) != null) {
      bgys.a(this.this$0).g();
    }
    bgys.a().b(this.this$0);
    bgys.a().b(PeakAppInterface.a);
    auto.a(bgys.a(this.this$0));
    QLog.d(bgys.b(), 4, "###  stopCamera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */