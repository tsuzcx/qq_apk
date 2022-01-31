package com.tencent.mobileqq.data;

import aukm;
import auma;
import java.io.Serializable;

public class TempMsgInfo
  extends aukm
  implements Serializable
{
  public long timeStamp;
  @auma
  public String typeWithUin;
  
  public TempMsgInfo() {}
  
  public TempMsgInfo(String paramString, long paramLong)
  {
    this.typeWithUin = paramString;
    this.timeStamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TempMsgInfo
 * JD-Core Version:    0.7.0.1
 */