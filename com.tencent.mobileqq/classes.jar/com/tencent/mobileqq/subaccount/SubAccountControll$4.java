package com.tencent.mobileqq.subaccount;

import ayaq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SubAccountControll$4
  implements Runnable
{
  public SubAccountControll$4(ayaq paramayaq) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("launchTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
      if (this.this$0.a != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.this$0.a.isRunning()))
    {
      QLog.d("SUB_ACCOUNT", 2, localObject);
      if ((this.this$0.a != null) && (this.this$0.a.isRunning())) {
        this.this$0.a.g(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControll.4
 * JD-Core Version:    0.7.0.1
 */