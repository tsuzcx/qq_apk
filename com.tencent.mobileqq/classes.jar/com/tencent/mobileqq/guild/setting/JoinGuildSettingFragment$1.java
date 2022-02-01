package com.tencent.mobileqq.guild.setting;

import android.text.Editable;
import android.text.TextWatcher;

class JoinGuildSettingFragment$1
  implements TextWatcher
{
  JoinGuildSettingFragment$1(JoinGuildSettingFragment paramJoinGuildSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    JoinGuildSettingFragment.a(this.a).a(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */