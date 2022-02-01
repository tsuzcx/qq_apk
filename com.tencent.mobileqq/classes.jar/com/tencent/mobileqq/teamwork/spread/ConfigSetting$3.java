package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ConfigSetting$3
  implements Runnable
{
  ConfigSetting$3(ConfigSetting paramConfigSetting) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = this.this$0.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.a.getCurrentAccountUin());
    localStringBuilder.append("_m_str_teamwork_tips_sp");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("file_str_key_max_count_local", ConfigSetting.a(this.this$0)).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting.3
 * JD-Core Version:    0.7.0.1
 */