package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;

class GuildClientAuthorizationAbstractDialogFragment$3
  implements Observer<GuildClientManageViewModel.RoleInfo>
{
  GuildClientAuthorizationAbstractDialogFragment$3(GuildClientAuthorizationAbstractDialogFragment paramGuildClientAuthorizationAbstractDialogFragment, QBaseActivity paramQBaseActivity) {}
  
  public void a(GuildClientManageViewModel.RoleInfo paramRoleInfo)
  {
    GuildClientAuthorizationAbstractDialogFragment.a(this.b, paramRoleInfo);
    ClientAuthorizationHelper.a(this.a, this.b.d, true);
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractDialogFragment.3
 * JD-Core Version:    0.7.0.1
 */