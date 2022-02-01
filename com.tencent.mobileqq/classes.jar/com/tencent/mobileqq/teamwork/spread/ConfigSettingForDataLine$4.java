package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.BaseApplication;

class ConfigSettingForDataLine$4
  implements Runnable
{
  public void run()
  {
    BaseApplication localBaseApplication = this.this$0.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.a.getCurrentAccountUin());
    localStringBuilder.append("_m_str_teamwork_dataline_tips_sp");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("file_str_key_max_count_local", ConfigSettingForDataLine.a(this.this$0)).commit();
    FMToastUtil.d(HardCodeUtil.a(2131900607));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.4
 * JD-Core Version:    0.7.0.1
 */