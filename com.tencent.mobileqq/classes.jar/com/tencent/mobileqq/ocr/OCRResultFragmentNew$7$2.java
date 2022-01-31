package com.tencent.mobileqq.ocr;

import ajya;
import aubc;
import audw;
import bcql;

public class OCRResultFragmentNew$7$2
  implements Runnable
{
  public OCRResultFragmentNew$7$2(aubc paramaubc, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aubc.a).dismiss();
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aubc.a).a(0);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aubc.a, true);
      bcql.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Aubc.a), 2, ajya.a(2131707832), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Aubc.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bcql.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Aubc.a), 1, ajya.a(2131707826), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.2
 * JD-Core Version:    0.7.0.1
 */