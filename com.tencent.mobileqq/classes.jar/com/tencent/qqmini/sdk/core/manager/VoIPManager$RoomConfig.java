package com.tencent.qqmini.sdk.core.manager;

import bgqv;

public class VoIPManager$RoomConfig
{
  @bgqv(a="groupId")
  public String groupId;
  @bgqv(a="muteConfig")
  public VoIPManager.MuteConfig muteConfig;
  @bgqv(a="nonceStr")
  public String nonceStr;
  @bgqv(a="signature")
  public String signature;
  @bgqv(a="timeStamp")
  public int timeStamp;
  
  public String toString()
  {
    return "RoomConfig{signature='" + this.signature + '\'' + ", nonceStr='" + this.nonceStr + '\'' + ", timeStamp=" + this.timeStamp + ", groupId=" + this.groupId + ", muteConfig=" + this.muteConfig + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.RoomConfig
 * JD-Core Version:    0.7.0.1
 */