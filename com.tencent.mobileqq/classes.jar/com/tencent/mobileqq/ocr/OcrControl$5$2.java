package com.tencent.mobileqq.ocr;

import amxh;
import amxi;
import avst;
import avsv;
import bdcs;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$5$2
  implements Runnable
{
  public OcrControl$5$2(avst paramavst, amxi paramamxi) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_Amxi.a.a;
    String str2 = new File(str1).getParent();
    if (avsv.a.equals(str2))
    {
      bdcs.d(str1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "delete pic path:" + str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.2
 * JD-Core Version:    0.7.0.1
 */