package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;

class GuildClientManageFragment$7
  implements Observer<Boolean>
{
  GuildClientManageFragment$7(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    GuildClientManageFragment.f(this.a).setChecked(paramBoolean.booleanValue());
    GuildClientManageFragment.b(this.a, "imp", paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.7
 * JD-Core Version:    0.7.0.1
 */