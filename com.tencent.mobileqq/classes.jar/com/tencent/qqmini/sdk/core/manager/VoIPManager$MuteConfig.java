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
    return "muteConfig{isMuteMicrophone=" + this.isMuteMicrophone + ", isMuteEarphone=" + this.isMuteEarphone + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.MuteConfig
 * JD-Core Version:    0.7.0.1
 */