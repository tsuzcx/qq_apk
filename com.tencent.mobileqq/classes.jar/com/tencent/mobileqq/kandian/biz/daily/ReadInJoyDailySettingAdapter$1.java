package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel;

class ReadInJoyDailySettingAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDailySettingAdapter$1(ReadInJoyDailySettingAdapter paramReadInJoyDailySettingAdapter, ReadInJoyDailySettingAdapter.DailySettingViewHolder paramDailySettingViewHolder, ReadInJoyDailySettingModel paramReadInJoyDailySettingModel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter;
    paramView.a = new ReadInJoyDailySettingPopupWindow((Activity)ReadInJoyDailySettingAdapter.a(paramView), new ReadInJoyDailySettingAdapter.1.1(this), this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyReadInJoyDailySettingModel.b, this.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyReadInJoyDailySettingModel.a);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter.a.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter$DailySettingViewHolder.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingAdapter.1
 * JD-Core Version:    0.7.0.1
 */