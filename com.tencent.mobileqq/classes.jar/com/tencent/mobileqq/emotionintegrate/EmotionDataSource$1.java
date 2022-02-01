package com.tencent.mobileqq.emotionintegrate;

import askm;
import askp;
import askq;
import java.util.List;

public class EmotionDataSource$1
  implements Runnable
{
  public EmotionDataSource$1(askp paramaskp, boolean paramBoolean, askq paramaskq, askm paramaskm) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Askq != null) {
      this.jdField_a_of_type_Askq.a(localList, this.jdField_a_of_type_Askm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
 * JD-Core Version:    0.7.0.1
 */