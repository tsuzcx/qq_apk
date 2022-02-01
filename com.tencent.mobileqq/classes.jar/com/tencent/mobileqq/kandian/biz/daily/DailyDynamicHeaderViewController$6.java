package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class DailyDynamicHeaderViewController$6
  extends ReadInJoyObserver
{
  DailyDynamicHeaderViewController$6(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDailyDynamicHeaderDataUpdated] ");
    localStringBuilder.append(paramBoolean);
    QLog.i("DailyHeaderViewController", 1, localStringBuilder.toString());
    if (!paramBoolean)
    {
      if ((DailyDynamicHeaderViewController.a(this.a) != -1) && (DailyDynamicHeaderViewController.a(this.a) != 0))
      {
        DailyDynamicHeaderViewController.a(this.a, 4);
        return;
      }
      DailyDynamicHeaderViewController.a(this.a, 0);
      return;
    }
    DailyDynamicHeaderViewController.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.6
 * JD-Core Version:    0.7.0.1
 */