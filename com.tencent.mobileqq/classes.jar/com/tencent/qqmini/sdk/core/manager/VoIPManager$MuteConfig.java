package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.annotation.JsonORM.Column;

public class VoIPManager$MuteConfig
{
  @JsonORM.Column(key="muteEarphone")
  public boolean isMuteEarphone;
  @JsonORM.Column(key="muteMicrophone")
  public boolean isMuteMicrophone;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteConfig{isMuteMicrophone=");
    localStringBuilder.append(this.isMuteMicrophone);
    localStringBuilder.append(", isMuteEarphone=");
    localStringBuilder.append(this.isMuteEarphone);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.MuteConfig
 * JD-Core Version:    0.7.0.1
 */