package com.tencent.mobileqq.magicface.magicfaceaction;

import ascp;
import ascq;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(ascp paramascp) {}
  
  public void run()
  {
    ascp localascp = this.this$0;
    localascp.h += 1;
    localascp = this.this$0;
    localascp.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_Ascq != null) {
      this.this$0.jdField_a_of_type_Ascq.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_Ascq != null) {
        this.this$0.jdField_a_of_type_Ascq.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */