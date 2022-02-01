package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton.OnCheckedChangeListener;

class GuildClientManageFragment$2
  implements GuildSwitchButton.OnCheckedChangeListener
{
  GuildClientManageFragment$2(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void onCheckedChanged(GuildSwitchButton paramGuildSwitchButton, boolean paramBoolean)
  {
    paramGuildSwitchButton = (GuildClientManageViewModel.RoleInfo)GuildClientManageFragment.a(this.a).c().getValue();
    if ((paramBoolean) && (paramGuildSwitchButton != null) && (!paramGuildSwitchButton.a))
    {
      GuildClientManageFragment.c(this.a).setChecked(false);
      if (QQGuildUIUtil.a()) {
        return;
      }
      GuildClientManageFragment.a(this.a, "clck", paramGuildSwitchButton);
      if (QQGuildSPUtils.f(GuildClientManageFragment.a(this.a).i()))
      {
        GuildClientManageFragment.a(this.a).m();
        return;
      }
      GuildClientManageFragment.a(this.a).l();
      return;
    }
    if ((!paramBoolean) && (paramGuildSwitchButton != null) && (paramGuildSwitchButton.a))
    {
      GuildClientManageFragment.c(this.a).setChecked(true);
      if (QQGuildUIUtil.a()) {
        return;
      }
      GuildClientManageFragment.a(this.a, "clck", paramGuildSwitchButton);
      GuildClientManageFragment.a(this.a).a(paramGuildSwitchButton);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.2
 * JD-Core Version:    0.7.0.1
 */