package com.tencent.mobileqq.ocr;

import aohk;
import aohl;
import axmv;
import axmx;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$5$2
  implements Runnable
{
  public OcrControl$5$2(axmv paramaxmv, aohl paramaohl) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_Aohl.a.a;
    String str2 = new File(str1).getParent();
    if (axmx.a.equals(str2))
    {
      FileUtils.deleteFile(str1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "delete pic path:" + str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.2
 * JD-Core Version:    0.7.0.1
 */