package com.tencent.mobileqq.guild.mainframe.container.facade;

import com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager;
import com.tencent.qphone.base.util.QLog;

class QQGuildFacadeFragment$3
  implements Runnable
{
  QQGuildFacadeFragment$3(QQGuildFacadeFragment paramQQGuildFacadeFragment) {}
  
  public void run()
  {
    QLog.i("GuildDiscover", 2, "setMaskGone, 动画未播完，延迟 GONE");
    GuildDiscoverAnimationManager.a(QQGuildFacadeFragment.e(this.this$0), this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.QQGuildFacadeFragment.3
 * JD-Core Version:    0.7.0.1
 */