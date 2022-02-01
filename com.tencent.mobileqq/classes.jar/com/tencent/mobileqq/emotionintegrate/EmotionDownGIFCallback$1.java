package com.tencent.mobileqq.emotionintegrate;

import argl;
import aycy;
import aydp;
import aydt;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(argl paramargl, aycy paramaycy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      aydt localaydt = new aydt();
      localaydt.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localaydt.jdField_a_of_type_JavaLangObject = this.a;
      localaydt.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Aydp == null)
        {
          aydp localaydp = new aydp();
          localaydp.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localaydp.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Aydp = localaydp;
        }
        localaydt.jdField_a_of_type_Aydp = this.a.jdField_a_of_type_Aydp;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localaydt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */