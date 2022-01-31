package com.tencent.mobileqq.ocr;

import alpo;
import avrl;
import avva;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(avrl paramavrl, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_Avrl.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_Avrl.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_Avrl.a, false);
      QQToast.a(this.jdField_a_of_type_Avrl.a, 2, alpo.a(2131708204), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Avrl.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(this.jdField_a_of_type_Avrl.a, 1, alpo.a(2131708198), 0).a();
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