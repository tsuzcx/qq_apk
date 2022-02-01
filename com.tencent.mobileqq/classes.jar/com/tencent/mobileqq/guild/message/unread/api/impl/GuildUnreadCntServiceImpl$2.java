package com.tencent.mobileqq.guild.message.unread.api.impl;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;

class GuildUnreadCntServiceImpl$2
  implements Runnable
{
  GuildUnreadCntServiceImpl$2(GuildUnreadCntServiceImpl paramGuildUnreadCntServiceImpl, IGuildUnreadCntService.NotifyObj paramNotifyObj) {}
  
  public void run()
  {
    GuildUnreadCntServiceImpl.access$100(this.this$0);
    this.this$0.notifyObservers(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.impl.GuildUnreadCntServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */