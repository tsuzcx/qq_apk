package com.tencent.mobileqq.ocr;

import ajyc;
import auaf;
import audu;
import bcpw;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(auaf paramauaf, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_Auaf.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_Auaf.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_Auaf.a, false);
      bcpw.a(this.jdField_a_of_type_Auaf.a, 2, ajyc.a(2131707821), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Auaf.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bcpw.a(this.jdField_a_of_type_Auaf.a, 1, ajyc.a(2131707815), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10.2
 * JD-Core Version:    0.7.0.1
 */