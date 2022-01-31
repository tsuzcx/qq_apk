package com.tencent.mobileqq.ocr;

import anbq;
import anbr;
import avxb;
import avxd;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(avxb paramavxb, String paramString, anbq paramanbq) {}
  
  public void run()
  {
    anbr localanbr = avxb.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localanbr != null) && (avxb.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localanbr.c;
      avxb.a(this.this$0).a(4, null, this.jdField_a_of_type_Anbq.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */