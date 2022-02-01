package com.tencent.mobileqq.guild.mainframe.leftbar;

import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.qphone.base.util.QLog;

class GuildListController$3
  extends QQGuildObserver
{
  GuildListController$3(GuildListController paramGuildListController) {}
  
  public void a(Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildObserver", 2, new Object[] { "onUserTypeUpdate: ", paramObject });
    }
    this.a.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController.3
 * JD-Core Version:    0.7.0.1
 */