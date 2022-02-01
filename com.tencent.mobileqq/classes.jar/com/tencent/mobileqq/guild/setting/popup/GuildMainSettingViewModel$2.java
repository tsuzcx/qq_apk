package com.tencent.mobileqq.guild.setting.popup;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildMainSettingViewModel$2
  extends GPServiceObserver
{
  GuildMainSettingViewModel$2(GuildMainSettingViewModel paramGuildMainSettingViewModel) {}
  
  protected void c(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(GuildMainSettingViewModel.a(this.a))) && (!TextUtils.isEmpty(GuildMainSettingViewModel.b(this.a).getGuildID())))
    {
      if ((GuildMainSettingViewModel.a(this.a).equals(paramString2)) && (GuildMainSettingViewModel.b(this.a).getGuildID().equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildMainSettingViewModel", 2, String.format("onGuildMemberNameUpdate nick=%s", new Object[] { paramString3 }));
        }
        GuildMainSettingViewModel.c(this.a).setValue(paramString3);
      }
      return;
    }
    QLog.e("GuildMainSettingViewModel", 2, String.format("onGuildMemberNameUpdate mSelfTid=%s, mGuildId=%s", new Object[] { GuildMainSettingViewModel.a(this.a), GuildMainSettingViewModel.b(this.a).getGuildID() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingViewModel.2
 * JD-Core Version:    0.7.0.1
 */