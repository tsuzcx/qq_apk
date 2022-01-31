package com.tencent.mobileqq.ocr;

import ajjy;
import atdt;
import atgo;
import bbmy;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(atdt paramatdt, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_Atdt.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_Atdt.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_Atdt.a, false);
      bbmy.a(this.jdField_a_of_type_Atdt.a, 2, ajjy.a(2131642036), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Atdt.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bbmy.a(this.jdField_a_of_type_Atdt.a, 1, ajjy.a(2131642030), 0).a();
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