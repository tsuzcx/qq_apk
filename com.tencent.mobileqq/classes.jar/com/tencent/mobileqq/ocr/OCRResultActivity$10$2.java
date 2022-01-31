package com.tencent.mobileqq.ocr;

import ajya;
import auah;
import audw;
import bcql;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(auah paramauah, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_Auah.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_Auah.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_Auah.a, false);
      bcql.a(this.jdField_a_of_type_Auah.a, 2, ajya.a(2131707832), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Auah.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bcql.a(this.jdField_a_of_type_Auah.a, 1, ajya.a(2131707826), 0).a();
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