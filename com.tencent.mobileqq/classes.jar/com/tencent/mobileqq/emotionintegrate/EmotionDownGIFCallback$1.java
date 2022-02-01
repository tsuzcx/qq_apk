package com.tencent.mobileqq.emotionintegrate;

import asex;
import ayxd;
import ayxt;
import ayxy;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(asex paramasex, ayxd paramayxd) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      ayxy localayxy = new ayxy();
      localayxy.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localayxy.jdField_a_of_type_JavaLangObject = this.a;
      localayxy.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Ayxt == null)
        {
          ayxt localayxt = new ayxt();
          localayxt.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localayxt.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Ayxt = localayxt;
        }
        localayxy.jdField_a_of_type_Ayxt = this.a.jdField_a_of_type_Ayxt;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localayxy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */