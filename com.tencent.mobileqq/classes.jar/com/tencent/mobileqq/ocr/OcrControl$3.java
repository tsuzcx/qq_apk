package com.tencent.mobileqq.ocr;

import apnx;
import apny;
import ayzm;
import ayzo;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(ayzm paramayzm, String paramString, apnx paramapnx) {}
  
  public void run()
  {
    apny localapny = ayzm.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localapny != null) && (ayzm.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localapny.c;
      ayzm.a(this.this$0).a(4, null, this.jdField_a_of_type_Apnx.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */