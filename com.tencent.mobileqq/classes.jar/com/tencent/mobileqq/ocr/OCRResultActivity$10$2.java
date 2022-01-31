package com.tencent.mobileqq.ocr;

import alud;
import avvu;
import avzj;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(avvu paramavvu, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_Avvu.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_Avvu.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_Avvu.a, false);
      QQToast.a(this.jdField_a_of_type_Avvu.a, 2, alud.a(2131708216), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Avvu.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(this.jdField_a_of_type_Avvu.a, 1, alud.a(2131708210), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10.2
 * JD-Core Version:    0.7.0.1
 */