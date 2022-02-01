package com.tencent.mobileqq.mini.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class MiniAppGameDebugSettingFragment$6
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppGameDebugSettingFragment$6(MiniAppGameDebugSettingFragment paramMiniAppGameDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append("_user_ipv6only_miniapp_");
    paramCompoundButton.getSharedPreferences(localStringBuilder.toString(), 4).edit().putBoolean("_user_ipv6only_miniapp_", paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */