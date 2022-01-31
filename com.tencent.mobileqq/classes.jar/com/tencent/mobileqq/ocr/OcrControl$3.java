package com.tencent.mobileqq.ocr;

import algr;
import algs;
import aubo;
import aubq;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(aubo paramaubo, String paramString, algr paramalgr) {}
  
  public void run()
  {
    algs localalgs = aubo.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localalgs != null) && (aubo.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localalgs.c;
      aubo.a(this.this$0).a(4, null, this.jdField_a_of_type_Algr.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */