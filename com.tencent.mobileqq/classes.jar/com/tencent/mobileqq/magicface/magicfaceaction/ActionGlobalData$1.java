package com.tencent.mobileqq.magicface.magicfaceaction;

import attr;
import atts;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(attr paramattr) {}
  
  public void run()
  {
    attr localattr = this.this$0;
    localattr.h += 1;
    localattr = this.this$0;
    localattr.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Atts != null) {
      this.this$0.jdField_a_of_type_Atts.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Atts != null) {
        this.this$0.jdField_a_of_type_Atts.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */