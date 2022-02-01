package com.tencent.mobileqq.guild.client;

import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.qphone.base.util.QLog;

class GuildClientManageViewModel$6
  implements IBindAppRoleCallback
{
  GuildClientManageViewModel$6(GuildClientManageViewModel paramGuildClientManageViewModel) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      QLog.e("GuildClientManageViewModel", 1, String.format("unBindAppRole network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 }));
      return;
    }
    GuildClientManageViewModel.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.6
 * JD-Core Version:    0.7.0.1
 */