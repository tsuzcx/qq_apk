package com.tencent.mobileqq.ocr;

import aksg;
import aksh;
import ater;
import atet;
import bace;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$5$2
  implements Runnable
{
  public OcrControl$5$2(ater paramater, aksh paramaksh) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_Aksh.a.a;
    String str2 = new File(str1).getParent();
    if (atet.a.equals(str2))
    {
      bace.d(str1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "delete pic path:" + str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.2
 * JD-Core Version:    0.7.0.1
 */