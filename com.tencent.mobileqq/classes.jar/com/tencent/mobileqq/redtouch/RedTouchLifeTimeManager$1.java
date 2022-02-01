package com.tencent.mobileqq.redtouch;

import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;

class RedTouchLifeTimeManager$1
  implements Runnable
{
  RedTouchLifeTimeManager$1(RedTouchLifeTimeManager paramRedTouchLifeTimeManager, TianShuReportData paramTianShuReportData) {}
  
  public void run()
  {
    TianShuManager.getInstance().report(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager.1
 * JD-Core Version:    0.7.0.1
 */