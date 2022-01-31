package com.tencent.mobileqq.ocr;

import amxh;
import amxi;
import avss;
import avsu;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(avss paramavss, String paramString, amxh paramamxh) {}
  
  public void run()
  {
    amxi localamxi = avss.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localamxi != null) && (avss.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localamxi.c;
      avss.a(this.this$0).a(4, null, this.jdField_a_of_type_Amxh.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */