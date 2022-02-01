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
    paramView = this.d;
    paramView.a = new ReadInJoyDailySettingPopupWindow((Activity)ReadInJoyDailySettingAdapter.a(paramView), new ReadInJoyDailySettingAdapter.1.1(this), this.b.f, this.b.e);
    this.d.a.b(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingAdapter.1
 * JD-Core Version:    0.7.0.1
 */