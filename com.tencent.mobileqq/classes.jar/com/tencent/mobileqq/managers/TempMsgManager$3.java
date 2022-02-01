package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class TempMsgManager$3
  implements Runnable
{
  TempMsgManager$3(TempMsgManager paramTempMsgManager, String paramString) {}
  
  public void run()
  {
    QQToast.a(TempMsgManager.a(this.this$0).getApp(), this.a, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager.3
 * JD-Core Version:    0.7.0.1
 */