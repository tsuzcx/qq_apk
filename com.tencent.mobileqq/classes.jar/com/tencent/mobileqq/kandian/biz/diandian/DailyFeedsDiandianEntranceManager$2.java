package com.tencent.mobileqq.kandian.biz.diandian;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyOverScrollListener;
import com.tencent.qphone.base.util.QLog;

class DailyFeedsDiandianEntranceManager$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 2, "jump to recommend feeds");
      ReadInJoyDailyOverScrollListener.a(this.a);
      this.a.overridePendingTransition(0, 2130772447);
      this.b.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager.2
 * JD-Core Version:    0.7.0.1
 */