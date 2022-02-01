package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;

class JoinGuildSettingFragment$5
  implements Observer<AddGuildOption>
{
  JoinGuildSettingFragment$5(JoinGuildSettingFragment paramJoinGuildSettingFragment) {}
  
  public void a(AddGuildOption paramAddGuildOption)
  {
    if (paramAddGuildOption == null) {
      return;
    }
    if (paramAddGuildOption.a == 4)
    {
      JoinGuildSettingFragment.c(this.a).setText(paramAddGuildOption.b);
      JoinGuildSettingFragment.b(this.a).setText(paramAddGuildOption.c);
      return;
    }
    if (paramAddGuildOption.a == 5) {
      JoinGuildSettingFragment.e(this.a).setText(paramAddGuildOption.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */