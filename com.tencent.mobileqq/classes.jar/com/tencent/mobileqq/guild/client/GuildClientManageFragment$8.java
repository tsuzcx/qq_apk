package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IGProPopupConfigInfo;

class GuildClientManageFragment$8
  implements Observer<IGProPopupConfigInfo>
{
  GuildClientManageFragment$8(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void a(IGProPopupConfigInfo paramIGProPopupConfigInfo)
  {
    paramIGProPopupConfigInfo = (GuildClientAuthDialogParams)new GuildClientAuthDialogParams().a(paramIGProPopupConfigInfo.a()).b(paramIGProPopupConfigInfo.b()).g(GuildClientManageFragment.a(this.a).i()).d(GuildClientManageFragment.a(this.a).h()).a(1).e();
    GuildClientAuthorizationDialogFragment.a(this.a.getQBaseActivity(), this.a, paramIGProPopupConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.8
 * JD-Core Version:    0.7.0.1
 */