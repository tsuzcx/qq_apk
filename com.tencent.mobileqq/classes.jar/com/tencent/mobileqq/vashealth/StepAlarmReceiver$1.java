package com.tencent.mobileqq.vashealth;

import com.tencent.mobileqq.vashealth.api.ISportManager;
import mqq.app.AppRuntime;

class StepAlarmReceiver$1
  implements Runnable
{
  StepAlarmReceiver$1(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    ISportManager localISportManager = (ISportManager)this.this$0.d.getRuntimeService(ISportManager.class, "multi");
    if (localISportManager != null) {
      localISportManager.doOnTimer1();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver.1
 * JD-Core Version:    0.7.0.1
 */