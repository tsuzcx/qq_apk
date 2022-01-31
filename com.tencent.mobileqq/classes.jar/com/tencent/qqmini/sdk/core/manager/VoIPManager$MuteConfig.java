package com.tencent.qqmini.sdk.core.manager;

import bgvc;

public class VoIPManager$MuteConfig
{
  @bgvc(a="muteEarphone")
  public boolean isMuteEarphone;
  @bgvc(a="muteMicrophone")
  public boolean isMuteMicrophone;
  
  public String toString()
  {
    return "muteConfig{isMuteMicrophone=" + this.isMuteMicrophone + ", isMuteEarphone=" + this.isMuteEarphone + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.MuteConfig
 * JD-Core Version:    0.7.0.1
 */