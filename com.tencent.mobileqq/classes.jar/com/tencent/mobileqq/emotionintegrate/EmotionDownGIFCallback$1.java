package com.tencent.mobileqq.emotionintegrate;

import apwa;
import awei;
import awey;
import awfd;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(apwa paramapwa, awei paramawei) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      awfd localawfd = new awfd();
      localawfd.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localawfd.jdField_a_of_type_JavaLangObject = this.a;
      localawfd.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Awey == null)
        {
          awey localawey = new awey();
          localawey.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localawey.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Awey = localawey;
        }
        localawfd.jdField_a_of_type_Awey = this.a.jdField_a_of_type_Awey;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localawfd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */