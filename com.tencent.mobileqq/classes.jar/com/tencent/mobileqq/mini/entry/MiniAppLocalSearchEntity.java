package com.tencent.mobileqq.mini.entry;

import aukm;
import auma;
import java.io.Serializable;

public class MiniAppLocalSearchEntity
  extends aukm
  implements Serializable
{
  @auma
  public String appId;
  public String appName;
  public String desc;
  public String iconUrl;
  public int showMask;
  
  public MiniAppLocalSearchEntity() {}
  
  public MiniAppLocalSearchEntity(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.appId = paramString1;
    this.appName = paramString2;
    this.iconUrl = paramString3;
    this.desc = paramString4;
    this.showMask = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId: ").append(this.appId).append(", appName: ").append(this.appName).append(", iconUrl: ").append(this.iconUrl).append(", showMask: ").append(this.showMask);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity
 * JD-Core Version:    0.7.0.1
 */