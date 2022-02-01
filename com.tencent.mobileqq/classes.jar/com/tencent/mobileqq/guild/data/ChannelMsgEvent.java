package com.tencent.mobileqq.guild.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="channelId,eventType,msgSeq,eventRandom")
public class ChannelMsgEvent
  extends Entity
  implements Serializable
{
  public String channelId;
  public long eventRandom = 0L;
  public long eventType = 0L;
  public long msgSeq = 0L;
  public String tinyId;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof ChannelMsgEvent)) {
      return false;
    }
    paramObject = (ChannelMsgEvent)paramObject;
    int i;
    if (paramObject.eventRandom == this.eventRandom) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramObject.eventType == 1L) {
      i = 1;
    }
    String str = paramObject.channelId;
    return (str != null) && (str.equals(this.channelId)) && (paramObject.eventType == this.eventType) && (paramObject.msgSeq == this.msgSeq) && (i != 0);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("MsgEvent{");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("channelId = ");
    localStringBuilder2.append(this.channelId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", eventType = ");
    localStringBuilder2.append(this.eventType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", msgSeq = ");
    localStringBuilder2.append(this.msgSeq);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", tinyId = ");
    localStringBuilder2.append(this.tinyId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", eventRandom = ");
    localStringBuilder2.append(this.eventRandom);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.data.ChannelMsgEvent
 * JD-Core Version:    0.7.0.1
 */