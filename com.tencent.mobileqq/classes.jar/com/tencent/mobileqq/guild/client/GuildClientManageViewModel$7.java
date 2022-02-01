package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.ISwitchPresenceArchiveCallback;
import com.tencent.qphone.base.util.QLog;

class GuildClientManageViewModel$7
  implements ISwitchPresenceArchiveCallback
{
  GuildClientManageViewModel$7(GuildClientManageViewModel paramGuildClientManageViewModel, boolean paramBoolean) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt != 0)
    {
      QLog.e("GuildClientManageViewModel", 1, String.format("requestSetShowPresence network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt), paramString2 }));
      return;
    }
    GuildClientManageViewModel.e(this.b).setValue(Boolean.valueOf(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.7
 * JD-Core Version:    0.7.0.1
 */