package com.tencent.mobileqq.mini.entry;

import awge;
import awhs;
import java.io.Serializable;

public class RecommendMiniAppEntity
  extends awge
  implements Serializable
{
  @awhs
  public String appId;
  public String appName;
  public int recommendType;
  
  public RecommendMiniAppEntity() {}
  
  public RecommendMiniAppEntity(String paramString1, String paramString2, int paramInt)
  {
    this.appId = paramString1;
    this.appName = paramString2;
    this.recommendType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId: ").append(this.appId).append(", appName: ").append(this.appName).append(", recommendType: ").append(this.recommendType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.RecommendMiniAppEntity
 * JD-Core Version:    0.7.0.1
 */