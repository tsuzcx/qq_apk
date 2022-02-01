package com.tencent.mobileqq.subaccount;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class SubAccountControll$5
  implements Runnable
{
  SubAccountControll$5(SubAccountControll paramSubAccountControll) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("launchTroopTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
      if (this.this$0.a != null) {
        break label83;
      }
    }
    label83:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.this$0.a.isRunning()))
    {
      QLog.d("SUB_ACCOUNT", 2, localObject);
      if ((this.this$0.a != null) && (this.this$0.a.isRunning())) {
        this.this$0.a.startAllSubMessageAccountMsg(false, 2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControll.5
 * JD-Core Version:    0.7.0.1
 */