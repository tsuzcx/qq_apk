package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anzj;
import auna;
import bedl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSettingForDataLine$4
  implements Runnable
{
  public void run()
  {
    this.this$0.a.getApp().getSharedPreferences(this.this$0.a.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).edit().putInt("file_str_key_max_count_local", bedl.a(this.this$0)).commit();
    auna.d(anzj.a(2131701341));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.4
 * JD-Core Version:    0.7.0.1
 */