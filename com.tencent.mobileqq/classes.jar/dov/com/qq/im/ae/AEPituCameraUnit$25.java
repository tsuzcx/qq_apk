package dov.com.qq.im.ae;

import bkle;
import bkph;
import bkvr;
import blmf;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$25
  implements Runnable
{
  public AEPituCameraUnit$25(bkle parambkle) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager begin");
    }
    Object localObject = bkle.a(this.this$0);
    if (bkle.b(this.this$0) == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      ((bkph)localObject).c(bool);
      localObject = (bkvr)blmf.a(18);
      blmo.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.25
 * JD-Core Version:    0.7.0.1
 */