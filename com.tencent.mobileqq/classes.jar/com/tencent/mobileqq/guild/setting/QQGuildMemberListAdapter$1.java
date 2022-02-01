package com.tencent.mobileqq.guild.setting;

import android.util.SparseArray;
import androidx.lifecycle.Observer;

class QQGuildMemberListAdapter$1
  implements Observer<Boolean>
{
  QQGuildMemberListAdapter$1(QQGuildMemberListAdapter paramQQGuildMemberListAdapter) {}
  
  public void a(Boolean paramBoolean)
  {
    QQGuildMemberListAdapter.a(this.a).clear();
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */