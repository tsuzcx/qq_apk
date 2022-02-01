package dov.com.qq.im.ae;

import bofh;
import bojx;
import boqr;
import bplq;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$23
  implements Runnable
{
  public AEPituCameraUnit$23(bofh parambofh) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager begin");
    }
    bojx localbojx = bofh.a(this.this$0);
    if (bofh.b(this.this$0) == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      localbojx.c(bool);
      ((boqr)bplq.a(18)).b(false);
      bplz.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.23
 * JD-Core Version:    0.7.0.1
 */