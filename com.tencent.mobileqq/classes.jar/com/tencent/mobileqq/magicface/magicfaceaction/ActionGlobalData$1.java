package com.tencent.mobileqq.magicface.magicfaceaction;

import awrn;
import awro;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(awrn paramawrn) {}
  
  public void run()
  {
    awrn localawrn = this.this$0;
    localawrn.h += 1;
    localawrn = this.this$0;
    localawrn.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Awro != null) {
      this.this$0.jdField_a_of_type_Awro.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Awro != null) {
        this.this$0.jdField_a_of_type_Awro.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */