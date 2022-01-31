package com.tencent.mobileqq.ocr;

import ajyc;
import auba;
import audu;
import bcpw;

public class OCRResultFragmentNew$7$2
  implements Runnable
{
  public OCRResultFragmentNew$7$2(auba paramauba, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_Auba.a).dismiss();
      OCRResultFragmentNew.a(this.jdField_a_of_type_Auba.a).a(0);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Auba.a, true);
      bcpw.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Auba.a), 2, ajyc.a(2131707821), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Auba.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bcpw.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Auba.a), 1, ajyc.a(2131707815), 0).a();
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