package com.tencent.mobileqq.mini.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class MiniAppGameDebugSettingFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppGameDebugSettingFragment$3(MiniAppGameDebugSettingFragment paramMiniAppGameDebugSettingFragment, SharedPreferences paramSharedPreferences) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.val$miniGameSp.edit().putBoolean("_minigame_start_with_sdk", paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */