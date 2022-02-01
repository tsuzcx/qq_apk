package com.tencent.mobileqq.guild.setting;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

class JoinGuildSettingFragment$4
  implements Observer<Boolean>
{
  JoinGuildSettingFragment$4(JoinGuildSettingFragment paramJoinGuildSettingFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()) && (this.a.getActivity() != null))
    {
      JoinGuildSettingFragment.d(this.a);
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */