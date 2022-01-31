package com.tencent.mobileqq.mini.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.ThreadManagerV2;

class MiniAppGameDebugSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppGameDebugSettingFragment$1(MiniAppGameDebugSettingFragment paramMiniAppGameDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    MiniAppGameDebugSettingFragment.access$000(this.this$0).edit().putBoolean("pref_key_use_system_webview", paramBoolean).apply();
    if (paramBoolean)
    {
      this.this$0.startTitleProgress();
      ThreadManagerV2.executeOnSubThread(new MiniAppGameDebugSettingFragment.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */