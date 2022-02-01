package com.tencent.mobileqq.guild.setting;

import android.util.SparseArray;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import mqq.util.WeakReference;

class QQGuildMemberListAdapter$4
  implements Observer<List<IGProUserInfo>>
{
  QQGuildMemberListAdapter$4(QQGuildMemberListAdapter paramQQGuildMemberListAdapter) {}
  
  public void a(List<IGProUserInfo> paramList)
  {
    if (QQGuildMemberListAdapter.d(this.a).c()) {
      ((QQGuildMemberFragment)QQGuildMemberListAdapter.e(this.a).get()).a("移除", -2147483648);
    }
    QQGuildMemberListAdapter.a(this.a, paramList);
    QQGuildMemberListAdapter.a(this.a).clear();
    QQGuildMemberListAdapter.b(this.a);
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter.4
 * JD-Core Version:    0.7.0.1
 */