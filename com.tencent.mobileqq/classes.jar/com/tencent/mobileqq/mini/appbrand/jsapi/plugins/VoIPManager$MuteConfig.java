package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.sdk.JsonORM.Column;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.MuteConfig
 * JD-Core Version:    0.7.0.1
 */