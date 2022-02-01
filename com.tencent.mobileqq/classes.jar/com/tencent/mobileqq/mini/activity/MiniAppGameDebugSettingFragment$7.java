package com.tencent.mobileqq.mini.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class MiniAppGameDebugSettingFragment$7
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppGameDebugSettingFragment$7(MiniAppGameDebugSettingFragment paramMiniAppGameDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_embedded_video_", 4).edit().putBoolean("_user_embedded_video_", paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */