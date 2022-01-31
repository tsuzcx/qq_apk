package dov.com.qq.im.AECamera.View;

import awir;
import bgys;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$6
  implements Runnable
{
  public AECameraManager$6(bgys parambgys) {}
  
  public void run()
  {
    bgys.a().a(false);
    if (QLog.isColorLevel()) {
      QLog.d(bgys.b(), 2, "###  cameraStopPreview");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraManager.6
 * JD-Core Version:    0.7.0.1
 */