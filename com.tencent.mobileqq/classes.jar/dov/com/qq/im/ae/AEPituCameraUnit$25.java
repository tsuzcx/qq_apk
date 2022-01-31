package dov.com.qq.im.ae;

import bkpl;
import bkto;
import bkzy;
import blqr;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$25
  implements Runnable
{
  public AEPituCameraUnit$25(bkpl parambkpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager begin");
    }
    Object localObject = bkpl.a(this.this$0);
    if (bkpl.b(this.this$0) == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      ((bkto)localObject).c(bool);
      localObject = (bkzy)blqr.a(18);
      blra.c = 0;
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