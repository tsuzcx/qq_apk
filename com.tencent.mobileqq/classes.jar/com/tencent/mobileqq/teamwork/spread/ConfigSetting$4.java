package com.tencent.mobileqq.teamwork.spread;

import alpo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import armz;
import bafb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSetting$4
  implements Runnable
{
  public void run()
  {
    this.this$0.a.getApp().getSharedPreferences(this.this$0.a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit().putInt("file_str_key_max_count_local", bafb.a(this.this$0)).commit();
    armz.d(alpo.a(2131702804));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting.4
 * JD-Core Version:    0.7.0.1
 */