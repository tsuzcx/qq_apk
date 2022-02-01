package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;

class GuildClientAuthorizationAbstractDialogFragment$1
  implements Observer<GuildClientRoleInfo>
{
  GuildClientAuthorizationAbstractDialogFragment$1(GuildClientAuthorizationAbstractDialogFragment paramGuildClientAuthorizationAbstractDialogFragment, QBaseActivity paramQBaseActivity) {}
  
  public void a(GuildClientRoleInfo paramGuildClientRoleInfo)
  {
    this.b.dismiss();
    paramGuildClientRoleInfo = new GuildClientSelectRoleDialogParams(this.b.d).a(paramGuildClientRoleInfo).a();
    GuildClientSelectRoleDialogFragment.a(this.a, this.b.getTargetFragment(), paramGuildClientRoleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */