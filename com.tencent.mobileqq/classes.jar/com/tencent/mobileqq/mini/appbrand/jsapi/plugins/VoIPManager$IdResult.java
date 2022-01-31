package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.sdk.JsonORM.Column;

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
    return "IdResult{openId='" + this.openId + '\'' + ", tinyId=" + this.tinyId + ", roomId=" + this.roomId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.IdResult
 * JD-Core Version:    0.7.0.1
 */