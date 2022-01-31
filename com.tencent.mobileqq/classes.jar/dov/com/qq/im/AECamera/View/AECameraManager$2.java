package dov.com.qq.im.AECamera.View;

import bgys;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$2
  implements Runnable
{
  public AECameraManager$2(bgys parambgys) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(bgys.b(), 2, " stopCamera: " + bgys.a(this.this$0));
    }
    if (!bgys.a(this.this$0)) {
      return;
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraManager.2
 * JD-Core Version:    0.7.0.1
 */