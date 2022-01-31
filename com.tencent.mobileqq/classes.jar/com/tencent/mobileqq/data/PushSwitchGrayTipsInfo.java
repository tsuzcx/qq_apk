package com.tencent.mobileqq.data;

import awbv;
import java.io.Serializable;

public class PushSwitchGrayTipsInfo
  extends awbv
  implements Serializable
{
  public long lastShowTime;
  public int sessionType;
  public int showCount;
  public String toUin;
  public String uin;
  
  public PushSwitchGrayTipsInfo() {}
  
  public PushSwitchGrayTipsInfo(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    this.uin = paramString1;
    this.toUin = paramString2;
    this.sessionType = paramInt1;
    this.lastShowTime = paramLong;
    this.showCount = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PushSwitchGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */