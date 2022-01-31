package com.tencent.mobileqq.emotionintegrate;

import aqae;
import aqah;
import aqai;
import java.util.List;

public class EmotionDataSource$1
  implements Runnable
{
  public EmotionDataSource$1(aqah paramaqah, boolean paramBoolean, aqai paramaqai, aqae paramaqae) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Aqai != null) {
      this.jdField_a_of_type_Aqai.a(localList, this.jdField_a_of_type_Aqae);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
 * JD-Core Version:    0.7.0.1
 */