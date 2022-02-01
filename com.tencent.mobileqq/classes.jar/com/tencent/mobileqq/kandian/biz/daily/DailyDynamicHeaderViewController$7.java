package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class DailyDynamicHeaderViewController$7
  implements QQPermissionCallback
{
  DailyDynamicHeaderViewController$7(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController, Runnable paramRunnable) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[deny] ACCESS_FINE_LOCATION");
    DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController, 3);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[grant] ACCESS_FINE_LOCATION");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.7
 * JD-Core Version:    0.7.0.1
 */