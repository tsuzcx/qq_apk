package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

class QQGuildMemberListAdapter$5
  implements Observer<List<IGProUserInfo>>
{
  QQGuildMemberListAdapter$5(QQGuildMemberListAdapter paramQQGuildMemberListAdapter) {}
  
  public void a(List<IGProUserInfo> paramList)
  {
    QQGuildMemberListAdapter.b(this.a, paramList);
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter.5
 * JD-Core Version:    0.7.0.1
 */