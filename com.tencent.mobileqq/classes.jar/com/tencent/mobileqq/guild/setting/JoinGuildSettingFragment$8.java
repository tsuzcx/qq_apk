package com.tencent.mobileqq.guild.setting;

import android.widget.TextView;
import androidx.lifecycle.Observer;

class JoinGuildSettingFragment$8
  implements Observer<Boolean>
{
  JoinGuildSettingFragment$8(JoinGuildSettingFragment paramJoinGuildSettingFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      this.a.d.setEnabled(true);
      return;
    }
    this.a.d.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */