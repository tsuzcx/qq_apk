package com.tencent.mobileqq.magicface.magicfaceaction;

import argn;
import argo;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(argn paramargn) {}
  
  public void run()
  {
    argn localargn = this.this$0;
    localargn.h += 1;
    localargn = this.this$0;
    localargn.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Argo != null) {
      this.this$0.jdField_a_of_type_Argo.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Argo != null) {
        this.this$0.jdField_a_of_type_Argo.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */