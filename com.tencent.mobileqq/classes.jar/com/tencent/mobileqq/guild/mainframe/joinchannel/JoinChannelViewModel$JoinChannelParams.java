package com.tencent.mobileqq.guild.mainframe.joinchannel;

import com.tencent.qphone.base.util.QLog;

public class JoinChannelViewModel$JoinChannelParams
{
  public String a;
  public String b;
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JoinChannelParams{guildId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinSig='");
    String str;
    if (QLog.isDebugVersion()) {
      str = this.b;
    } else {
      str = "***";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('\'');
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams
 * JD-Core Version:    0.7.0.1
 */