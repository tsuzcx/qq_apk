package com.tencent.mobileqq.mini.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class MiniAppGameDebugSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppGameDebugSettingFragment$2(MiniAppGameDebugSettingFragment paramMiniAppGameDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    MiniAppGameDebugSettingFragment.access$000(this.this$0).edit().putBoolean("pref_key_use_old_desktop", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */