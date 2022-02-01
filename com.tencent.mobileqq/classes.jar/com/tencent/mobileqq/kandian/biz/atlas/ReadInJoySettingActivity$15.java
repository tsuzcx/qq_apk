package com.tencent.mobileqq.kandian.biz.atlas;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$15
  implements ActionSheet.OnDismissListener
{
  ReadInJoySettingActivity$15(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onDismiss()
  {
    ReadInJoySettingActivity.a(this.a, true);
    ReadInJoySettingActivity.a(this.a).setChecked(true ^ ReadInJoySettingActivity.a(this.a));
    ReadInJoySettingActivity.a(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.15
 * JD-Core Version:    0.7.0.1
 */