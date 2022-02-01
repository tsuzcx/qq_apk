package com.tencent.mobileqq.guild.mainframe.leftbar;

import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildListController$4
  extends GPServiceObserver
{
  GuildListController$4(GuildListController paramGuildListController) {}
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildListController", 2, String.format("onBeKickFromGuild: guild: %s, black: %d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    this.a.a(2);
  }
  
  protected void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildListController", 2, String.format("onRemoveGuild: guild: %s", new Object[] { paramString }));
    }
    this.a.a(2);
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildListController", 2, String.format("onDestoryGuild: guild: %s", new Object[] { paramString }));
    }
    this.a.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController.4
 * JD-Core Version:    0.7.0.1
 */