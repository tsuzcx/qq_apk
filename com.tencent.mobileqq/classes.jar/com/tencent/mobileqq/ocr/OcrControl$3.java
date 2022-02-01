package com.tencent.mobileqq.ocr;

import aohk;
import aohl;
import axmu;
import axmw;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(axmu paramaxmu, String paramString, aohk paramaohk) {}
  
  public void run()
  {
    aohl localaohl = axmu.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localaohl != null) && (axmu.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localaohl.c;
      axmu.a(this.this$0).a(4, null, this.jdField_a_of_type_Aohk.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */