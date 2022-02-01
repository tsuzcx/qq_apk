package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.annotation.JsonORM.Column;

public class VoIPManager$IdResult
{
  @JsonORM.Column(key="openId")
  public String openId;
  @JsonORM.Column(key="roomId")
  public int roomId;
  @JsonORM.Column(key="tinyId")
  public long tinyId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IdResult{openId='");
    localStringBuilder.append(this.openId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tinyId=");
    localStringBuilder.append(this.tinyId);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.IdResult
 * JD-Core Version:    0.7.0.1
 */