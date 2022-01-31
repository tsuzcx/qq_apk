package com.tencent.mobileqq.magicface.magicfaceaction;

import atya;
import atyb;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(atya paramatya) {}
  
  public void run()
  {
    atya localatya = this.this$0;
    localatya.h += 1;
    localatya = this.this$0;
    localatya.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Atyb != null) {
      this.this$0.jdField_a_of_type_Atyb.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Atyb != null) {
        this.this$0.jdField_a_of_type_Atyb.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */