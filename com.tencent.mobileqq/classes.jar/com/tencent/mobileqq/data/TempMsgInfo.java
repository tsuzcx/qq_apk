package com.tencent.mobileqq.data;

import awge;
import awhs;
import java.io.Serializable;

public class TempMsgInfo
  extends awge
  implements Serializable
{
  public long timeStamp;
  @awhs
  public String typeWithUin;
  
  public TempMsgInfo() {}
  
  public TempMsgInfo(String paramString, long paramLong)
  {
    this.typeWithUin = paramString;
    this.timeStamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TempMsgInfo
 * JD-Core Version:    0.7.0.1
 */