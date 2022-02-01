package com.tencent.mobileqq.magicface.magicfaceaction;

import avli;
import avlj;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(avli paramavli) {}
  
  public void run()
  {
    avli localavli = this.this$0;
    localavli.h += 1;
    localavli = this.this$0;
    localavli.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Avlj != null) {
      this.this$0.jdField_a_of_type_Avlj.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Avlj != null) {
        this.this$0.jdField_a_of_type_Avlj.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */