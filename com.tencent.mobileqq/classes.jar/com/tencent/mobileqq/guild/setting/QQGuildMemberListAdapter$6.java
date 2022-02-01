package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.Observer;
import java.util.List;

class QQGuildMemberListAdapter$6
  implements Observer<Boolean>
{
  QQGuildMemberListAdapter$6(QQGuildMemberListAdapter paramQQGuildMemberListAdapter) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      QQGuildMemberListAdapter.f(this.a).clear();
      QQGuildMemberListAdapter.c(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter.6
 * JD-Core Version:    0.7.0.1
 */