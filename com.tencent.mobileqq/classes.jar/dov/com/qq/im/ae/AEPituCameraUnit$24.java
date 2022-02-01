package dov.com.qq.im.ae;

import bndy;
import bnip;
import bnpc;
import bojv;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$24
  implements Runnable
{
  public AEPituCameraUnit$24(bndy parambndy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager begin");
    }
    Object localObject = bndy.a(this.this$0);
    if (bndy.b(this.this$0) == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      ((bnip)localObject).c(bool);
      localObject = (bnpc)bojv.a(18);
      boke.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.24
 * JD-Core Version:    0.7.0.1
 */