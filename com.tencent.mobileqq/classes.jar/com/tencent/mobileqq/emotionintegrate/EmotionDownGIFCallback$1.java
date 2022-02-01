package com.tencent.mobileqq.emotionintegrate;

import asul;
import azpq;
import azqh;
import azql;
import com.tencent.qphone.base.util.QLog;

public class EmotionDownGIFCallback$1
  implements Runnable
{
  public EmotionDownGIFCallback$1(asul paramasul, azpq paramazpq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      azql localazql = new azql();
      localazql.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localazql.jdField_a_of_type_JavaLangObject = this.a;
      localazql.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_Azqh == null)
        {
          azqh localazqh = new azqh();
          localazqh.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localazqh.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_Azqh = localazqh;
        }
        localazql.jdField_a_of_type_Azqh = this.a.jdField_a_of_type_Azqh;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localazql);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */