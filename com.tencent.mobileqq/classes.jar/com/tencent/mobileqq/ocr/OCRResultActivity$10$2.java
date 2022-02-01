package com.tencent.mobileqq.ocr;

import amtj;
import axln;
import axpc;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(axln paramaxln, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_Axln.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_Axln.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_Axln.a, false);
      QQToast.a(this.jdField_a_of_type_Axln.a, 2, amtj.a(2131706930), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Axln.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(this.jdField_a_of_type_Axln.a, 1, amtj.a(2131706924), 0).a();
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