package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ConfigSetting$1
  implements Runnable
{
  ConfigSetting$1(ConfigSetting paramConfigSetting) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.a.getCurrentAccountUin());
    localStringBuilder.append("_m_str_teamwork_tips_sp");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    ConfigSetting.a(this.this$0, ((SharedPreferences)localObject).getInt("file_str_key_max_count_local", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting.1
 * JD-Core Version:    0.7.0.1
 */