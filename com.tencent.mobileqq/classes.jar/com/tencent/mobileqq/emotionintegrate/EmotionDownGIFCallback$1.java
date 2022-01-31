package com.tencent.mobileqq.emotionintegrate;

import aqaj;
import awir;
import awjh;
import awjm;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(aqaj paramaqaj, awir paramawir) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      awjm localawjm = new awjm();
      localawjm.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localawjm.jdField_a_of_type_JavaLangObject = this.a;
      localawjm.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Awjh == null)
        {
          awjh localawjh = new awjh();
          localawjh.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localawjh.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Awjh = localawjh;
        }
        localawjm.jdField_a_of_type_Awjh = this.a.jdField_a_of_type_Awjh;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localawjm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */