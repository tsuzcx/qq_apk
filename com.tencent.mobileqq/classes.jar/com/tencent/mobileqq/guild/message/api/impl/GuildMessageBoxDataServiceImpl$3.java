package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import java.util.Comparator;

class GuildMessageBoxDataServiceImpl$3
  implements Comparator<ChannelMsgEvent>
{
  GuildMessageBoxDataServiceImpl$3(GuildMessageBoxDataServiceImpl paramGuildMessageBoxDataServiceImpl) {}
  
  public int a(ChannelMsgEvent paramChannelMsgEvent1, ChannelMsgEvent paramChannelMsgEvent2)
  {
    if ((paramChannelMsgEvent1.eventType == 1L) && (paramChannelMsgEvent2.eventType == 1L))
    {
      if (paramChannelMsgEvent1.msgSeq == paramChannelMsgEvent2.msgSeq) {
        return 0;
      }
      if (paramChannelMsgEvent1.msgSeq > paramChannelMsgEvent2.msgSeq) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessageBoxDataServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */