package com.tencent.mobileqq.ocr;

import alud;
import avwp;
import avzj;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultFragmentNew$7$2
  implements Runnable
{
  public OCRResultFragmentNew$7$2(avwp paramavwp, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_Avwp.a).dismiss();
      OCRResultFragmentNew.a(this.jdField_a_of_type_Avwp.a).a(0);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Avwp.a, true);
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Avwp.a), 2, alud.a(2131708216), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Avwp.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Avwp.a), 1, alud.a(2131708210), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.2
 * JD-Core Version:    0.7.0.1
 */