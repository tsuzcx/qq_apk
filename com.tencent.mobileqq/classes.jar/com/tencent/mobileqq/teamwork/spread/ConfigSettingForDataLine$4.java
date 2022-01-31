package com.tencent.mobileqq.teamwork.spread;

import ajjy;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apcb;
import axhb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSettingForDataLine$4
  implements Runnable
{
  public void run()
  {
    this.this$0.a.getApp().getSharedPreferences(this.this$0.a.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).edit().putInt("file_str_key_max_count_local", axhb.a(this.this$0)).commit();
    apcb.d(ajjy.a(2131636635));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.4
 * JD-Core Version:    0.7.0.1
 */