package com.tencent.mobileqq.vashealth;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class StepAlarmReceiver$1
  implements Runnable
{
  StepAlarmReceiver$1(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    ((SportManager)this.this$0.a.getManager(QQManagerFactory.SPORT_MANAGER)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver.1
 * JD-Core Version:    0.7.0.1
 */