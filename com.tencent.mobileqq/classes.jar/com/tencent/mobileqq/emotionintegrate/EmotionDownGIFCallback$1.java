package com.tencent.mobileqq.emotionintegrate;

import aodt;
import aumz;
import aunp;
import aunu;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(aodt paramaodt, aumz paramaumz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      aunu localaunu = new aunu();
      localaunu.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localaunu.jdField_a_of_type_JavaLangObject = this.a;
      localaunu.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Aunp == null)
        {
          aunp localaunp = new aunp();
          localaunp.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localaunp.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Aunp = localaunp;
        }
        localaunu.jdField_a_of_type_Aunp = this.a.jdField_a_of_type_Aunp;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localaunu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */