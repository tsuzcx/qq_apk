package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;

class GuildClientSelectRoleDialogFragment$2
  implements Observer<GuildClientManageViewModel.RoleInfo>
{
  GuildClientSelectRoleDialogFragment$2(GuildClientSelectRoleDialogFragment paramGuildClientSelectRoleDialogFragment, QBaseActivity paramQBaseActivity) {}
  
  public void a(GuildClientManageViewModel.RoleInfo paramRoleInfo)
  {
    if (paramRoleInfo.a())
    {
      GuildClientSelectRoleDialogFragment.a(this.b, paramRoleInfo);
      ClientAuthorizationHelper.a(this.a, GuildClientSelectRoleDialogFragment.b(this.b), true);
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */