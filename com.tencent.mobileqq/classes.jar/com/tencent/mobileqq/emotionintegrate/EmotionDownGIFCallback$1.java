package com.tencent.mobileqq.emotionintegrate;

import aody;
import aunb;
import aunr;
import aunw;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(aody paramaody, aunb paramaunb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      aunw localaunw = new aunw();
      localaunw.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localaunw.jdField_a_of_type_JavaLangObject = this.a;
      localaunw.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Aunr == null)
        {
          aunr localaunr = new aunr();
          localaunr.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localaunr.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Aunr = localaunr;
        }
        localaunw.jdField_a_of_type_Aunr = this.a.jdField_a_of_type_Aunr;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localaunw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */