package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ConfigSettingForDataLine$2
  implements Runnable
{
  ConfigSettingForDataLine$2(ConfigSettingForDataLine paramConfigSettingForDataLine) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.a.getCurrentAccountUin());
    localStringBuilder.append("_m_str_teamwork_dataline_tips_sp");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    ConfigSettingForDataLine.a(this.this$0, ((SharedPreferences)localObject).getInt("file_str_key_max_count_local", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.2
 * JD-Core Version:    0.7.0.1
 */