package com.tencent.mobileqq.kandian.biz.daily;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;

class DailyDynamicHeaderViewController$10
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$10(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController) != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      ReadInJoyUtils.a(DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController).getContext(), this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.10
 * JD-Core Version:    0.7.0.1
 */