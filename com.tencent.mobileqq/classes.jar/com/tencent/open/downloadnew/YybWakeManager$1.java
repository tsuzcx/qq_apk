package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Message;
import com.tencent.open.base.LogUtility;

class YybWakeManager$1
  extends Handler
{
  YybWakeManager$1(YybWakeManager paramYybWakeManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.what == 100)
    {
      if (paramMessage.arg1 != 101) {
        return;
      }
      YybWakeManager.a(this.a);
      LogUtility.c("YybWakeManager", "yyb not alive, startYybByInstrumentation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybWakeManager.1
 * JD-Core Version:    0.7.0.1
 */