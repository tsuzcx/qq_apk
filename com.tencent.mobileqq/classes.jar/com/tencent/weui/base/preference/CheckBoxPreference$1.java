package com.tencent.weui.base.preference;

import com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch;

class CheckBoxPreference$1
  implements MMSwitchBtn.ISwitch
{
  CheckBoxPreference$1(CheckBoxPreference paramCheckBoxPreference) {}
  
  public void onStatusChange(boolean paramBoolean)
  {
    CheckBoxPreference.a(this.a, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference.1
 * JD-Core Version:    0.7.0.1
 */