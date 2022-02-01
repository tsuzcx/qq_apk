package com.tencent.mobileqq.kandian.biz.daily;

import android.widget.TextView;
import java.util.List;

class ReadInJoyDailySettingAdapter$1$1
  implements ReadInJoyDailySettingPopupWindow.Callback
{
  ReadInJoyDailySettingAdapter$1$1(ReadInJoyDailySettingAdapter.1 param1) {}
  
  public void a(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter$DailySettingViewHolder.b.setText(paramString2);
    this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyReadInJoyDailySettingModel.d = paramString2;
    this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyReadInJoyDailySettingModel.c = paramString1;
    if (this.a.jdField_a_of_type_Int < ReadInJoyDailySettingAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter).size()) {
      ReadInJoyDailySettingAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoDailyReadInJoyDailySettingModel);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */