package com.tencent.mobileqq.magicface.magicfaceaction;

import ascr;
import ascs;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(ascr paramascr) {}
  
  public void run()
  {
    ascr localascr = this.this$0;
    localascr.h += 1;
    localascr = this.this$0;
    localascr.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Ascs != null) {
      this.this$0.jdField_a_of_type_Ascs.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Ascs != null) {
        this.this$0.jdField_a_of_type_Ascs.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */