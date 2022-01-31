package com.tencent.mobileqq.vashealth;

import basg;
import com.tencent.mobileqq.app.QQAppInterface;

class StepAlarmReceiver$1
  implements Runnable
{
  StepAlarmReceiver$1(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    ((basg)this.this$0.a.getManager(260)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver.1
 * JD-Core Version:    0.7.0.1
 */