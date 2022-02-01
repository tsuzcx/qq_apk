package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anzj;
import auna;
import bedj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSetting$4
  implements Runnable
{
  public void run()
  {
    this.this$0.a.getApp().getSharedPreferences(this.this$0.a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit().putInt("file_str_key_max_count_local", bedj.a(this.this$0)).commit();
    auna.d(anzj.a(2131701343));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting.4
 * JD-Core Version:    0.7.0.1
 */