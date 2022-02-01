package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IGuildMemberCountInfos;

class QQGuildMemberFragment$7
  implements Observer<IGuildMemberCountInfos>
{
  QQGuildMemberFragment$7(QQGuildMemberFragment paramQQGuildMemberFragment) {}
  
  public void a(IGuildMemberCountInfos paramIGuildMemberCountInfos)
  {
    if (paramIGuildMemberCountInfos != null) {
      QQGuildMemberFragment.b(this.a).b(paramIGuildMemberCountInfos.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.7
 * JD-Core Version:    0.7.0.1
 */