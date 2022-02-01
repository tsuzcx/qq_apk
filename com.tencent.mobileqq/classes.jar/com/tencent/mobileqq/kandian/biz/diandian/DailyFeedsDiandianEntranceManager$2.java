package com.tencent.mobileqq.kandian.biz.diandian;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyOverScrollListener;
import com.tencent.qphone.base.util.QLog;

class DailyFeedsDiandianEntranceManager$2
  implements View.OnClickListener
{
  DailyFeedsDiandianEntranceManager$2(DailyFeedsDiandianEntranceManager paramDailyFeedsDiandianEntranceManager, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 2, "jump to recommend feeds");
      ReadInJoyDailyOverScrollListener.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 2130772355);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianDailyFeedsDiandianEntranceManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager.2
 * JD-Core Version:    0.7.0.1
 */