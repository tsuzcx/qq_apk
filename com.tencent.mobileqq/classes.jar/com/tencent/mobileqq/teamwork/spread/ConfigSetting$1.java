package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import axgz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSetting$1
  implements Runnable
{
  public ConfigSetting$1(axgz paramaxgz) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.a.getApp().getSharedPreferences(this.this$0.a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0);
    axgz.a(this.this$0, localSharedPreferences.getInt("file_str_key_max_count_local", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting.1
 * JD-Core Version:    0.7.0.1
 */