package com.tencent.mobileqq.ocr;

import anvx;
import ayrw;
import ayvn;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(ayrw paramayrw, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_Ayrw.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_Ayrw.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_Ayrw.a, false);
      QQToast.a(this.jdField_a_of_type_Ayrw.a, 2, anvx.a(2131707276), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Ayrw.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(this.jdField_a_of_type_Ayrw.a, 1, anvx.a(2131707270), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10.2
 * JD-Core Version:    0.7.0.1
 */