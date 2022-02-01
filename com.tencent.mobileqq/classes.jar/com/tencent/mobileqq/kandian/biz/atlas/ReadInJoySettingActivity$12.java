package com.tencent.mobileqq.kandian.biz.atlas;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class ReadInJoySettingActivity$12
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$12(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isPressed()) {
      return;
    }
    ReadInJoySettingActivity.f(this.a, paramBoolean ^ true);
    ReadInJoySettingActivity.g(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.12
 * JD-Core Version:    0.7.0.1
 */