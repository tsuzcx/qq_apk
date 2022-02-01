package com.tencent.mobileqq.kandian.biz.atlas;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$7
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$7(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.a(this.a, paramBoolean ^ true);
    if ((ReadInJoySettingActivity.a(this.a).isPressed()) && (!this.a.c))
    {
      if (!paramBoolean)
      {
        paramCompoundButton = this.a;
        ReadInJoySettingActivity.b(paramCompoundButton, ReadInJoySettingActivity.a(paramCompoundButton));
        return;
      }
      ReadInJoySettingActivity.a(this.a).show();
      return;
    }
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.7
 * JD-Core Version:    0.7.0.1
 */