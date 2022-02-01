package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.persistence.EntityManager;

class GuildMessageBoxDataServiceImpl$2
  implements Runnable
{
  GuildMessageBoxDataServiceImpl$2(GuildMessageBoxDataServiceImpl paramGuildMessageBoxDataServiceImpl, ChannelMsgEvent paramChannelMsgEvent) {}
  
  public void run()
  {
    GuildMessageBoxDataServiceImpl.access$100(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessageBoxDataServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */