package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.annotation.JsonORM.Column;

public class VoIPManager$RoomConfig
{
  @JsonORM.Column(key="groupId")
  public String groupId;
  @JsonORM.Column(key="muteConfig")
  public VoIPManager.MuteConfig muteConfig;
  @JsonORM.Column(key="nonceStr")
  public String nonceStr;
  @JsonORM.Column(key="signature")
  public String signature;
  @JsonORM.Column(key="timeStamp")
  public int timeStamp;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RoomConfig{signature='");
    localStringBuilder.append(this.signature);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nonceStr='");
    localStringBuilder.append(this.nonceStr);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append(", groupId=");
    localStringBuilder.append(this.groupId);
    localStringBuilder.append(", muteConfig=");
    localStringBuilder.append(this.muteConfig);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.RoomConfig
 * JD-Core Version:    0.7.0.1
 */