package com.tencent.qqmini.sdk.core.manager;

import bgqv;

public class VoIPManager$MuteConfig
{
  @bgqv(a="muteEarphone")
  public boolean isMuteEarphone;
  @bgqv(a="muteMicrophone")
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