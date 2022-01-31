package com.tencent.qqmini.sdk.core.manager;

import bgvc;

public class VoIPManager$RoomConfig
{
  @bgvc(a="groupId")
  public String groupId;
  @bgvc(a="muteConfig")
  public VoIPManager.MuteConfig muteConfig;
  @bgvc(a="nonceStr")
  public String nonceStr;
  @bgvc(a="signature")
  public String signature;
  @bgvc(a="timeStamp")
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