package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;

class GuildClientManageFragment$9
  implements Observer<GuildClientRoleInfo>
{
  GuildClientManageFragment$9(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void a(GuildClientRoleInfo paramGuildClientRoleInfo)
  {
    paramGuildClientRoleInfo = (GuildClientSelectRoleDialogParams)new GuildClientSelectRoleDialogParams().a(paramGuildClientRoleInfo).g(GuildClientManageFragment.a(this.a).i()).d(GuildClientManageFragment.a(this.a).h()).a(1).e();
    GuildClientSelectRoleDialogFragment.a(this.a.getQBaseActivity(), this.a, paramGuildClientRoleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.9
 * JD-Core Version:    0.7.0.1
 */