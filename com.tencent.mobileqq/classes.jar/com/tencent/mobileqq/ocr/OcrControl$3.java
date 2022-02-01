package com.tencent.mobileqq.ocr;

import apkm;
import apkn;
import aytd;
import aytf;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(aytd paramaytd, String paramString, apkm paramapkm) {}
  
  public void run()
  {
    apkn localapkn = aytd.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localapkn != null) && (aytd.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localapkn.c;
      aytd.a(this.this$0).a(4, null, this.jdField_a_of_type_Apkm.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */