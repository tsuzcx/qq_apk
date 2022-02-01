package com.tencent.mobileqq.ocr;

import apah;
import apai;
import aygt;
import aygv;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(aygt paramaygt, String paramString, apah paramapah) {}
  
  public void run()
  {
    apai localapai = aygt.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localapai != null) && (aygt.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localapai.c;
      aygt.a(this.this$0).a(4, null, this.jdField_a_of_type_Apah.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */