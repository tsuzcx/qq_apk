package com.tencent.mobileqq.guild.navigatebar;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.BaseMessageNavigateInfo;

public class GuildMessageNavigateInfo
  extends BaseMessageNavigateInfo
{
  public String channelId;
  
  public boolean equals(@Nullable Object paramObject)
  {
    paramObject = (GuildMessageNavigateInfo)paramObject;
    String str = this.channelId;
    return (str != null) && (str.equals(paramObject.channelId)) && (this.type == paramObject.type) && (this.shmsgseq == paramObject.shmsgseq) && (this.msgseq == paramObject.msgseq);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopMessageNavigateInfo{troopCode='");
    localStringBuilder.append(this.channelId);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", shmsgseq=");
    localStringBuilder.append(this.shmsgseq);
    localStringBuilder.append(", msgseq=");
    localStringBuilder.append(this.msgseq);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */