package com.tencent.mobileqq.guild.profilecard.manage;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildProfileManageViewModel$2
  extends GPServiceObserver
{
  GuildProfileManageViewModel$2(GuildProfileManageViewModel paramGuildProfileManageViewModel) {}
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuildManageProfileViewModel", 1, String.format("guild: %s, black: %d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    if (paramString.equals(GuildProfileManageViewModel.a(this.a).a())) {
      GuildProfileManageViewModel.b(this.a).setValue(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageViewModel.2
 * JD-Core Version:    0.7.0.1
 */