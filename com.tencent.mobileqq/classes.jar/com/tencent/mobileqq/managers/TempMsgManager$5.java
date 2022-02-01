package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class TempMsgManager$5
  implements Runnable
{
  TempMsgManager$5(TempMsgManager paramTempMsgManager, String paramString) {}
  
  public void run()
  {
    QQToast.makeText(TempMsgManager.a(this.this$0).getApp(), this.a, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager.5
 * JD-Core Version:    0.7.0.1
 */