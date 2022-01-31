package com.tencent.mobileqq.ocr;

import anbq;
import anbr;
import avxc;
import avxe;
import bdhb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$5$2
  implements Runnable
{
  public OcrControl$5$2(avxc paramavxc, anbr paramanbr) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_Anbr.a.a;
    String str2 = new File(str1).getParent();
    if (avxe.a.equals(str2))
    {
      bdhb.d(str1);
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