package com.tencent.mobileqq.guild.profilecard.manage;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;

class GuildProfileManageComponent$3
  implements Observer<Boolean>
{
  GuildProfileManageComponent$3(GuildProfileManageComponent paramGuildProfileManageComponent) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      boolean bool = GuildProfileManageComponent.access$200(this.a).isChecked();
      GuildProfileManageComponent.access$200(this.a).setOnCheckedChangeListener(null);
      GuildProfileManageComponent.access$200(this.a).setChecked(bool ^ true);
      GuildProfileManageComponent.access$200(this.a).setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageComponent.3
 * JD-Core Version:    0.7.0.1
 */