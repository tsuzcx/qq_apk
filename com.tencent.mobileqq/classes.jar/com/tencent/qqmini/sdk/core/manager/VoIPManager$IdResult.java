package com.tencent.qqmini.sdk.core.manager;

import bgqv;

public class VoIPManager$IdResult
{
  @bgqv(a="openId")
  public String openId;
  @bgqv(a="roomId")
  public int roomId;
  @bgqv(a="tinyId")
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