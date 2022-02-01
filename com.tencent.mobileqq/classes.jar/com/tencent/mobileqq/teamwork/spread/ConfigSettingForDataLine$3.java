package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ConfigSettingForDataLine$3
  implements Runnable
{
  ConfigSettingForDataLine$3(ConfigSettingForDataLine paramConfigSettingForDataLine) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.a.getCurrentAccountUin());
    localStringBuilder.append("_m_str_teamwork_dataline_tips_sp");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    ((SharedPreferences)localObject).edit().putInt("file_str_key_max_count_local", ConfigSettingForDataLine.a(this.this$0)).commit();
    ((SharedPreferences)localObject).edit().putLong("file_str_lstat_show_time_local", ConfigSettingForDataLine.a(this.this$0)).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.3
 * JD-Core Version:    0.7.0.1
 */