package com.tencent.mobileqq.ocr;

import anzj;
import ayza;
import azbu;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultFragmentNew$7$2
  implements Runnable
{
  public OCRResultFragmentNew$7$2(ayza paramayza, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_Ayza.a).dismiss();
      OCRResultFragmentNew.a(this.jdField_a_of_type_Ayza.a).a(0);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Ayza.a, true);
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Ayza.a), 2, anzj.a(2131706700), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_Ayza.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Ayza.a), 1, anzj.a(2131706694), 0).a();
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