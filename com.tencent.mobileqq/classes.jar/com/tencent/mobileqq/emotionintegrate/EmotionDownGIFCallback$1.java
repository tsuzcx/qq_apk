package com.tencent.mobileqq.emotionintegrate;

import askr;
import azjk;
import azkb;
import azkf;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(askr paramaskr, azjk paramazjk) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      azkf localazkf = new azkf();
      localazkf.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localazkf.jdField_a_of_type_JavaLangObject = this.a;
      localazkf.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Azkb == null)
        {
          azkb localazkb = new azkb();
          localazkb.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localazkb.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Azkb = localazkb;
        }
        localazkf.jdField_a_of_type_Azkb = this.a.jdField_a_of_type_Azkb;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localazkf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */