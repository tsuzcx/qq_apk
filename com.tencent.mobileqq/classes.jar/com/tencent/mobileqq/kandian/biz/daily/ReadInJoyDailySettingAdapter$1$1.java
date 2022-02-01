package com.tencent.mobileqq.kandian.biz.daily;

import android.widget.TextView;
import java.util.List;

class ReadInJoyDailySettingAdapter$1$1
  implements ReadInJoyDailySettingPopupWindow.Callback
{
  ReadInJoyDailySettingAdapter$1$1(ReadInJoyDailySettingAdapter.1 param1) {}
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a.b.setText(paramString2);
    this.a.b.d = paramString2;
    this.a.b.c = paramString1;
    if (this.a.c < ReadInJoyDailySettingAdapter.b(this.a.d).size()) {
      ReadInJoyDailySettingAdapter.a(this.a.d, this.a.c, this.a.b);
    }
    this.a.d.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */