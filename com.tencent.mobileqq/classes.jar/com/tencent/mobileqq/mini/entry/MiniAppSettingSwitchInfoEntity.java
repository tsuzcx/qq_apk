package com.tencent.mobileqq.mini.entry;

import awbv;
import awdj;

public class MiniAppSettingSwitchInfoEntity
  extends awbv
{
  public static final String TAG = "MiniAppSettingSwitchInfoEntity";
  @awdj
  public String key;
  public String subTitle;
  public String title;
  public int value;
  
  public MiniAppSettingSwitchInfoEntity() {}
  
  public MiniAppSettingSwitchInfoEntity(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.key = paramString1;
    this.title = paramString2;
    this.subTitle = paramString3;
    this.value = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key:").append(this.key).append(", title:").append(this.title).append(", subTitle:").append(this.subTitle).append(", value:").append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity
 * JD-Core Version:    0.7.0.1
 */