package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;

class RedTouchLifeTimeManager$1
  implements Runnable
{
  RedTouchLifeTimeManager$1(RedTouchLifeTimeManager paramRedTouchLifeTimeManager, TianShuReportData paramTianShuReportData) {}
  
  public void run()
  {
    TianShuManager.getInstance().report(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager.1
 * JD-Core Version:    0.7.0.1
 */