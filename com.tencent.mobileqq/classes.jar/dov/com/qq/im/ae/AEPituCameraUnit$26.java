package dov.com.qq.im.ae;

import biim;
import bikb;
import biqk;
import bivx;
import bjae;
import com.tencent.qphone.base.util.QLog;

public class AEPituCameraUnit$26
  implements Runnable
{
  public AEPituCameraUnit$26(biim parambiim) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager begin");
    }
    Object localObject = biim.a(this.this$0);
    if (biim.a(this.this$0) == bivx.a) {}
    for (boolean bool = true;; bool = false)
    {
      ((bikb)localObject).c(bool);
      localObject = (biqk)bjae.a(18);
      bjan.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.26
 * JD-Core Version:    0.7.0.1
 */