package com.tencent.mobileqq.guild.mainframe.helper;

import android.os.Bundle;
import java.io.Serializable;

public class JoinGuildParam
  implements Serializable
{
  public String channelId;
  public Bundle extras;
  public int from = 0;
  public String guildId = "";
  public String joinSignature = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JoinGuildParam{guildId='");
    localStringBuilder.append(this.guildId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelId='");
    localStringBuilder.append(this.channelId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinSignature='");
    localStringBuilder.append('\'');
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.from);
    localStringBuilder.append(", extras=");
    localStringBuilder.append(this.extras);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam
 * JD-Core Version:    0.7.0.1
 */