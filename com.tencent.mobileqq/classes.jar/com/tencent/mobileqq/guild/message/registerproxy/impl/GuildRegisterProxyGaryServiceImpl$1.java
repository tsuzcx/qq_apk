package com.tencent.mobileqq.guild.message.registerproxy.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class GuildRegisterProxyGaryServiceImpl$1
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  GuildRegisterProxyGaryServiceImpl$1(GuildRegisterProxyGaryServiceImpl paramGuildRegisterProxyGaryServiceImpl) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("GUILD")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildRegisterProxyGaryServiceImpl", 2, "onSharedPreferenceChanged.");
      }
      GuildRegisterProxyGaryServiceImpl.access$000(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.impl.GuildRegisterProxyGaryServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */