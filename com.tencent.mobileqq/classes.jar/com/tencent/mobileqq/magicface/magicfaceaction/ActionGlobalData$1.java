package com.tencent.mobileqq.magicface.magicfaceaction;

import java.util.TimerTask;

class ActionGlobalData$1
  extends TimerTask
{
  ActionGlobalData$1(ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    ActionGlobalData localActionGlobalData = this.this$0;
    localActionGlobalData.w += 1;
    localActionGlobalData = this.this$0;
    localActionGlobalData.p -= 0.1F;
    if (this.this$0.a != null) {
      this.this$0.a.b();
    }
    if (this.this$0.w * 100 == this.this$0.o * 1000)
    {
      localActionGlobalData = this.this$0;
      localActionGlobalData.p = 0.0F;
      if (localActionGlobalData.a != null) {
        this.this$0.a.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */