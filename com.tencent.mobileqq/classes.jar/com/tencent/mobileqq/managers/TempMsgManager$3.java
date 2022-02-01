package com.tencent.mobileqq.managers;

import java.util.Map;

class TempMsgManager$3
  implements Runnable
{
  TempMsgManager$3(TempMsgManager paramTempMsgManager, short paramShort, boolean paramBoolean) {}
  
  public void run()
  {
    if (TempMsgManager.b(this.this$0) != null) {
      TempMsgManager.b(this.this$0).a(this.a, this.b, ((Boolean)TempMsgManager.c(this.this$0).get(TempMsgManager.a(this.this$0, this.a))).booleanValue(), ((Boolean)TempMsgManager.d(this.this$0).get(TempMsgManager.a(this.this$0, this.a))).booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager.3
 * JD-Core Version:    0.7.0.1
 */