package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class DailyDynamicHeaderViewController$4$1
  implements QQPermissionCallback
{
  DailyDynamicHeaderViewController$4$1(DailyDynamicHeaderViewController.4 param4, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[deny] ACCESS_FINE_LOCATION");
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[grant] ACCESS_FINE_LOCATION");
    DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController$4.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.4.1
 * JD-Core Version:    0.7.0.1
 */