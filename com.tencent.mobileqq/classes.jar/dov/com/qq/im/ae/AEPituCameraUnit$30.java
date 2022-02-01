package dov.com.qq.im.ae;

import bmxa;
import bnbn;
import bnkb;
import bogd;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$30
  implements Runnable
{
  public AEPituCameraUnit$30(bmxa parambmxa) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "onResourceDownload update filterpager begin");
    }
    bnbn localbnbn = this.this$0.jdField_a_of_type_Bnbn;
    if (this.this$0.b == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      localbnbn.d(bool);
      ((bnkb)bogd.a(18)).b(false);
      bogm.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.30
 * JD-Core Version:    0.7.0.1
 */