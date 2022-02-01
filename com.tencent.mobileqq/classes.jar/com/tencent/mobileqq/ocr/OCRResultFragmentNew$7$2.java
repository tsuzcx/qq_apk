package com.tencent.mobileqq.ocr;

import amtj;
import axmi;
import axpc;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultFragmentNew$7$2
  implements Runnable
{
  public OCRResultFragmentNew$7$2(axmi paramaxmi, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_Axmi.a).dismiss();
      OCRResultFragmentNew.a(this.jdField_a_of_type_Axmi.a).a(0);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Axmi.a, true);
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Axmi.a), 2, amtj.a(2131706930), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Axmi.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Axmi.a), 1, amtj.a(2131706924), 0).a();
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