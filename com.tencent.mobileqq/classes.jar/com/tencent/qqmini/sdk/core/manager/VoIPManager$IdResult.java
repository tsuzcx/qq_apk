package com.tencent.qqmini.sdk.core.manager;

import bgvc;

public class VoIPManager$IdResult
{
  @bgvc(a="openId")
  public String openId;
  @bgvc(a="roomId")
  public int roomId;
  @bgvc(a="tinyId")
  public long tinyId;
  
  public String toString()
  {
    return "IdResult{openId='" + this.openId + '\'' + ", tinyId=" + this.tinyId + ", roomId=" + this.roomId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.IdResult
 * JD-Core Version:    0.7.0.1
 */