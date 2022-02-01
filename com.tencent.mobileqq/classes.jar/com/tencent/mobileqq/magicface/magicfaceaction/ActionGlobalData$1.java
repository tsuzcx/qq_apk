package com.tencent.mobileqq.magicface.magicfaceaction;

import awyb;
import awyc;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(awyb paramawyb) {}
  
  public void run()
  {
    awyb localawyb = this.this$0;
    localawyb.h += 1;
    localawyb = this.this$0;
    localawyb.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Awyc != null) {
      this.this$0.jdField_a_of_type_Awyc.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Awyc != null) {
        this.this$0.jdField_a_of_type_Awyc.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */