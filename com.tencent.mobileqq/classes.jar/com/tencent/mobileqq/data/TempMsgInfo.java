package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Serializable;

@KeepClassConstructor
public class TempMsgInfo
  extends Entity
  implements Serializable
{
  public long timeStamp;
  @unique
  public String typeWithUin;
  
  public TempMsgInfo() {}
  
  public TempMsgInfo(String paramString, long paramLong)
  {
    this.typeWithUin = paramString;
    this.timeStamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.TempMsgInfo
 * JD-Core Version:    0.7.0.1
 */