package com.tencent.mobileqq.magicface.magicfaceaction;

import awfj;
import awfk;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(awfj paramawfj) {}
  
  public void run()
  {
    awfj localawfj = this.this$0;
    localawfj.h += 1;
    localawfj = this.this$0;
    localawfj.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Awfk != null) {
      this.this$0.jdField_a_of_type_Awfk.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Awfk != null) {
        this.this$0.jdField_a_of_type_Awfk.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */