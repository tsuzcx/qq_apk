package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;

class QQGuildMemberListAdapter$3
  implements Observer<IGProUserInfo>
{
  QQGuildMemberListAdapter$3(QQGuildMemberListAdapter paramQQGuildMemberListAdapter) {}
  
  public void a(IGProUserInfo paramIGProUserInfo)
  {
    QQGuildMemberListAdapter.a(this.a, paramIGProUserInfo);
    QQGuildMemberListAdapter.c(this.a, paramIGProUserInfo);
    QQGuildMemberListAdapter.c(this.a).q();
    QQGuildMemberListAdapter.b(this.a);
    QQGuildMemberListAdapter.b(this.a, paramIGProUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter.3
 * JD-Core Version:    0.7.0.1
 */