package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;

class GuildClientManageFragment$6
  implements Observer<Boolean>
{
  GuildClientManageFragment$6(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    GuildClientManageFragment.e(this.a).setChecked(paramBoolean.booleanValue());
    GuildClientManageFragment.a(this.a, "imp", paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.6
 * JD-Core Version:    0.7.0.1
 */