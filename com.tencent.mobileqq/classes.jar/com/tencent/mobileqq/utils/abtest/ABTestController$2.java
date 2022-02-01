package com.tencent.mobileqq.utils.abtest;

import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class ABTestController$2
  implements Runnable
{
  ABTestController$2(ABTestController paramABTestController) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.this$0.a(MobileQQ.sMobileQQ, localAppRuntime.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController.2
 * JD-Core Version:    0.7.0.1
 */