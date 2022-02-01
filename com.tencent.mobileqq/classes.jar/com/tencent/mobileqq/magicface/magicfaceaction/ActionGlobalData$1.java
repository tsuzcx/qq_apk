package com.tencent.mobileqq.magicface.magicfaceaction;

import java.util.TimerTask;

class ActionGlobalData$1
  extends TimerTask
{
  ActionGlobalData$1(ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    ActionGlobalData localActionGlobalData = this.this$0;
    localActionGlobalData.h += 1;
    localActionGlobalData = this.this$0;
    localActionGlobalData.jdField_a_of_type_Float -= 0.1F;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver.b();
    }
    if (this.this$0.h * 100 == this.this$0.c * 1000)
    {
      this.this$0.jdField_a_of_type_Float = 0.0F;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */