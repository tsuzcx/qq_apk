package com.tencent.mobileqq.kandian.biz.atlas;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoySettingActivity$14
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoySettingActivity$14(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReadInJoySettingActivity.a(this.a, false);
      paramView = this.a;
      ReadInJoySettingActivity.b(paramView, ReadInJoySettingActivity.a(paramView));
    }
    ReadInJoySettingActivity.a(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.14
 * JD-Core Version:    0.7.0.1
 */