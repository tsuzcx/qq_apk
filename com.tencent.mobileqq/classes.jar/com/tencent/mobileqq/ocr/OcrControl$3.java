package com.tencent.mobileqq.ocr;

import aksg;
import aksh;
import ateq;
import ates;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(ateq paramateq, String paramString, aksg paramaksg) {}
  
  public void run()
  {
    aksh localaksh = ateq.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localaksh != null) && (ateq.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localaksh.c;
      ateq.a(this.this$0).a(4, null, this.jdField_a_of_type_Aksg.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */