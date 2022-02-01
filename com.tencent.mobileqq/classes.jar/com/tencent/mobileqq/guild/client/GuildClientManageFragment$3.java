package com.tencent.mobileqq.guild.client;

import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton.OnCheckedChangeListener;

class GuildClientManageFragment$3
  implements GuildSwitchButton.OnCheckedChangeListener
{
  GuildClientManageFragment$3(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void onCheckedChanged(GuildSwitchButton paramGuildSwitchButton, boolean paramBoolean)
  {
    if (QQGuildUIUtil.a()) {
      return;
    }
    GuildClientManageFragment.a(this.a, "clck", paramBoolean ^ true);
    GuildClientManageFragment.a(this.a).b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.3
 * JD-Core Version:    0.7.0.1
 */