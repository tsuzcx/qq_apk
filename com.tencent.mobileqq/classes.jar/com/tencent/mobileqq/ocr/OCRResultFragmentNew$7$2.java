package com.tencent.mobileqq.ocr;

import anvx;
import aysr;
import ayvn;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultFragmentNew$7$2
  implements Runnable
{
  public OCRResultFragmentNew$7$2(aysr paramaysr, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aysr.a).dismiss();
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aysr.a).a(0);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aysr.a, true);
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Aysr.a), 2, anvx.a(2131707276), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Aysr.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Aysr.a), 1, anvx.a(2131707270), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.2
 * JD-Core Version:    0.7.0.1
 */