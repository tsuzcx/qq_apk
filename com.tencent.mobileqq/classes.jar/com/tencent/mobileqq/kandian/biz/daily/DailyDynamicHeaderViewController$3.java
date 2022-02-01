package com.tencent.mobileqq.kandian.biz.daily;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class DailyDynamicHeaderViewController$3
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$3(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToRefresh");
    DailyDynamicHeaderViewController.a(this.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.3
 * JD-Core Version:    0.7.0.1
 */