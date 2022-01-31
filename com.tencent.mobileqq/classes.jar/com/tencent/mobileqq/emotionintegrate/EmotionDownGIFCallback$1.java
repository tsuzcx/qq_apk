package com.tencent.mobileqq.emotionintegrate;

import anni;
import atpb;
import atpr;
import atpw;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(anni paramanni, atpb paramatpb) {}
  
  public void run()
  {
    QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      atpw localatpw = new atpw();
      localatpw.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localatpw.jdField_a_of_type_JavaLangObject = this.a;
      localatpw.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Atpr == null)
        {
          atpr localatpr = new atpr();
          localatpr.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localatpr.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Atpr = localatpr;
        }
        localatpw.jdField_a_of_type_Atpr = this.a.jdField_a_of_type_Atpr;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localatpw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */