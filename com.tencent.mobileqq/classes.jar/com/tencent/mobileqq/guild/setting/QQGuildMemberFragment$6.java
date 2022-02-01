package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.Observer;
import com.tencent.widget.SwipListView;

class QQGuildMemberFragment$6
  implements Observer<Boolean>
{
  QQGuildMemberFragment$6(QQGuildMemberFragment paramQQGuildMemberFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.a.o.setDragEnable(false);
      return;
    }
    this.a.o.setDragEnable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.6
 * JD-Core Version:    0.7.0.1
 */