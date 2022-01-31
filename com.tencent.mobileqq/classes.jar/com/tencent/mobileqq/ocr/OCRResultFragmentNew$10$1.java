package com.tencent.mobileqq.ocr;

import asfn;
import asfr;
import avrh;
import avsa;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class OCRResultFragmentNew$10$1
  implements Runnable
{
  public OCRResultFragmentNew$10$1(avsa paramavsa, boolean paramBoolean, asfr paramasfr) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Asfr.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Asfr.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      avrh.b(avrh.a(this.jdField_a_of_type_Asfr.jdField_a_of_type_JavaUtilArrayList));
      avrh.a(avrh.a.a, this.jdField_a_of_type_Asfr.b, this.jdField_a_of_type_Asfr.jdField_a_of_type_JavaUtilHashMap);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Avsa.a, 0);
      return;
    }
    QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Avsa.a), 1, 2131699591, 0).a();
    avrh.a("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */