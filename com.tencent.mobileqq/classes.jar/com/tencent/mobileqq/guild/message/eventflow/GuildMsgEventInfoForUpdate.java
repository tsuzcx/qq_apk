package com.tencent.mobileqq.guild.message.eventflow;

public class GuildMsgEventInfoForUpdate
{
  public long a = 0L;
  public GuildMsgEventInfo b = new GuildMsgEventInfo();
  
  public boolean a()
  {
    GuildMsgEventInfo localGuildMsgEventInfo = this.b;
    if (localGuildMsgEventInfo != null) {
      return localGuildMsgEventInfo.a();
    }
    return false;
  }
  
  public long b()
  {
    GuildMsgEventInfo localGuildMsgEventInfo = this.b;
    if (localGuildMsgEventInfo != null) {
      return localGuildMsgEventInfo.b;
    }
    return 9223372036854775807L;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof GuildMsgEventInfoForUpdate;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (this.a == ((GuildMsgEventInfoForUpdate)paramObject).a) {
      bool1 = true;
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgSeq:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfoForUpdate
 * JD-Core Version:    0.7.0.1
 */