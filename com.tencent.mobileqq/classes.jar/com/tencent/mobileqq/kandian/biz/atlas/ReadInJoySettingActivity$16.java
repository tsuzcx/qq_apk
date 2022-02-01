package com.tencent.mobileqq.kandian.biz.atlas;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoySettingActivity$16
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoySettingActivity$16(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReadInJoySettingActivity.i(this.a, false);
      paramView = this.a;
      ReadInJoySettingActivity.j(paramView, ReadInJoySettingActivity.i(paramView));
    }
    ReadInJoySettingActivity.j(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.16
 * JD-Core Version:    0.7.0.1
 */