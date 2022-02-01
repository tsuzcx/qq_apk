package com.tencent.mobileqq.mini.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class MiniAppGameDebugSettingFragment$9
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppGameDebugSettingFragment$9(MiniAppGameDebugSettingFragment paramMiniAppGameDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append("_loadingad_select_use_nulllist_");
    paramCompoundButton.getSharedPreferences(localStringBuilder.toString(), 4).edit().putBoolean("_loadingad_select_use_nulllist_", paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */