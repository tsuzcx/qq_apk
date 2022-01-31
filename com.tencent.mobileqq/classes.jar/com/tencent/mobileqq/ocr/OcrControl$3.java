package com.tencent.mobileqq.ocr;

import algs;
import algt;
import aubm;
import aubo;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(aubm paramaubm, String paramString, algs paramalgs) {}
  
  public void run()
  {
    algt localalgt = aubm.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localalgt != null) && (aubm.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localalgt.c;
      aubm.a(this.this$0).a(4, null, this.jdField_a_of_type_Algs.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */