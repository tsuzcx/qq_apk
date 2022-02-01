package com.tencent.mobileqq.guild.data;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class ChannelMsgEventCollection
  implements Serializable
{
  public String channelId;
  public String guildId;
  public List<ChannelMsgEvent> msgEventList;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelMsgEvent{");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId = ");
    ((StringBuilder)localObject).append(this.guildId);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(", channelId = ");
    ((StringBuilder)localObject).append(this.channelId);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(", msgEventList = ");
    localObject = this.msgEventList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localStringBuilder.append("[ ");
      localObject = this.msgEventList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(((ChannelMsgEvent)((Iterator)localObject).next()).toString());
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("]");
    }
    else
    {
      localStringBuilder.append("null");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.data.ChannelMsgEventCollection
 * JD-Core Version:    0.7.0.1
 */