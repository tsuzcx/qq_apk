package com.tencent.mobileqq.guild.client;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;

class GuildClientManageFragment$5
  implements Observer<GuildClientManageViewModel.RoleInfo>
{
  GuildClientManageFragment$5(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void a(GuildClientManageViewModel.RoleInfo paramRoleInfo)
  {
    GuildClientManageFragment.c(this.a).setChecked(paramRoleInfo.a);
    if (paramRoleInfo.a)
    {
      GuildClientManageFragment.d(this.a).setText(GuildClientManageFragment.a(this.a, paramRoleInfo.b));
      GuildClientManageFragment.d(this.a).setTextColor(Color.parseColor("#8D9AAD"));
      GuildClientManageFragment.d(this.a).setVisibility(0);
      ((View)GuildClientManageFragment.e(this.a).getParent()).setVisibility(0);
      ((View)GuildClientManageFragment.f(this.a).getParent()).setVisibility(0);
    }
    else
    {
      GuildClientManageFragment.d(this.a).setVisibility(8);
      ((View)GuildClientManageFragment.e(this.a).getParent()).setVisibility(8);
      ((View)GuildClientManageFragment.f(this.a).getParent()).setVisibility(8);
    }
    GuildClientManageFragment.a(this.a, "imp", paramRoleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.5
 * JD-Core Version:    0.7.0.1
 */