package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.sdk.JsonORM.Column;

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
    return "RoomConfig{signature='" + this.signature + '\'' + ", nonceStr='" + this.nonceStr + '\'' + ", timeStamp=" + this.timeStamp + ", groupId=" + this.groupId + ", muteConfig=" + this.muteConfig + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.RoomConfig
 * JD-Core Version:    0.7.0.1
 */