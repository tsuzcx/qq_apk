package com.tencent.mobileqq.emotionintegrate;

import apvv;
import apvy;
import apvz;
import java.util.List;

public class EmotionDataSource$1
  implements Runnable
{
  public EmotionDataSource$1(apvy paramapvy, boolean paramBoolean, apvz paramapvz, apvv paramapvv) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Apvz != null) {
      this.jdField_a_of_type_Apvz.a(localList, this.jdField_a_of_type_Apvv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
 * JD-Core Version:    0.7.0.1
 */