package com.tencent.mobileqq.mini.entry;

import awbv;
import awdj;

public class MiniAppRedDotEntity
  extends awbv
{
  public static final String TAG = "MiniAppRedDotEntity";
  @awdj
  public String appId;
  public int publicAccountRedDotNum;
  public int wnsPushRedDotNum;
  
  public MiniAppRedDotEntity() {}
  
  public MiniAppRedDotEntity(String paramString, int paramInt1, int paramInt2)
  {
    this.appId = paramString;
    this.publicAccountRedDotNum = paramInt1;
    this.wnsPushRedDotNum = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:").append(this.appId).append(", publicAccountRedDotNum:").append(this.publicAccountRedDotNum).append(", wnsPushRedDotNum:").append(this.wnsPushRedDotNum);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity
 * JD-Core Version:    0.7.0.1
 */