package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientAccountInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientShowCfgInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GuildClientManageViewModel$1
  extends GPServiceObserver
{
  GuildClientManageViewModel$1(GuildClientManageViewModel paramGuildClientManageViewModel) {}
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3, IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    if ((!TextUtils.isEmpty(GuildClientManageViewModel.a(this.a))) && (GuildClientManageViewModel.a(this.a).equals(paramString3)) && (paramIGProUserProfileInfo != null))
    {
      paramString1 = paramIGProUserProfileInfo.p();
      if (!paramString1.isEmpty())
      {
        paramString1 = (IGProClientAccountInfo)paramString1.get(0);
        GuildClientManageViewModel.b(this.a).setValue(new GuildClientManageViewModel.ClientInfo(paramString1.a(), paramString1.b()));
        GuildClientManageViewModel.c(this.a).setValue(new GuildClientManageViewModel.RoleInfo(true, paramString1.d(), paramString1.c()));
        GuildClientManageViewModel.d(this.a).setValue(Boolean.valueOf(paramString1.e().b()));
        GuildClientManageViewModel.e(this.a).setValue(Boolean.valueOf(paramString1.e().a()));
        return;
      }
      GuildClientManageViewModel.f(this.a);
      return;
    }
    QLog.w("GuildClientManageViewModel", 1, "onUserProfileInfoUpdate error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.1
 * JD-Core Version:    0.7.0.1
 */