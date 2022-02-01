package com.tencent.mobileqq.guild.navigatebar;

import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.data.ChannelMsgEventCollection;
import com.tencent.mobileqq.guild.message.GuildMessageBoxObserver;
import java.util.Iterator;
import java.util.List;

class GuildAioNavigateBarManager$1
  extends GuildMessageBoxObserver
{
  GuildAioNavigateBarManager$1(GuildAioNavigateBarManager paramGuildAioNavigateBarManager) {}
  
  protected void a(boolean paramBoolean, List<ChannelMsgEventCollection> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ChannelMsgEventCollection)paramList.next();
        if ((localObject != null) && (((ChannelMsgEventCollection)localObject).msgEventList != null))
        {
          localObject = ((ChannelMsgEventCollection)localObject).msgEventList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ChannelMsgEvent localChannelMsgEvent = (ChannelMsgEvent)((Iterator)localObject).next();
            if ((localChannelMsgEvent != null) && (localChannelMsgEvent.eventType == 1L)) {
              this.b.a(localChannelMsgEvent.channelId, 23, localChannelMsgEvent.msgSeq, localChannelMsgEvent.msgSeq, "", null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager.1
 * JD-Core Version:    0.7.0.1
 */