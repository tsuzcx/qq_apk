package dov.com.qq.im.ae;

import bljy;
import bloc;
import bluy;
import bmql;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$25
  implements Runnable
{
  public AEPituCameraUnit$25(bljy parambljy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "onResourceDownload update filterpager begin");
    }
    bloc localbloc = this.this$0.jdField_a_of_type_Bloc;
    if (this.this$0.b == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      localbloc.d(bool);
      ((bluy)bmql.a(18)).b(false);
      bmqu.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.25
 * JD-Core Version:    0.7.0.1
 */