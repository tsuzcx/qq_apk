package com.tencent.mobileqq.mini.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class MiniAppGameDebugSettingFragment$5
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppGameDebugSettingFragment$5(MiniAppGameDebugSettingFragment paramMiniAppGameDebugSettingFragment, SharedPreferences paramSharedPreferences) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.val$miniGameSp.edit().putBoolean("_minigame_enable_jank_canary_brief", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */