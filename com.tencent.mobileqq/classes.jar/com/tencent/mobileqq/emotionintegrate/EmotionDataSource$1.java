package com.tencent.mobileqq.emotionintegrate;

import aodt;
import aodw;
import aodx;
import java.util.List;

public class EmotionDataSource$1
  implements Runnable
{
  public EmotionDataSource$1(aodw paramaodw, boolean paramBoolean, aodx paramaodx, aodt paramaodt) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Aodx != null) {
      this.jdField_a_of_type_Aodx.a(localList, this.jdField_a_of_type_Aodt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
 * JD-Core Version:    0.7.0.1
 */