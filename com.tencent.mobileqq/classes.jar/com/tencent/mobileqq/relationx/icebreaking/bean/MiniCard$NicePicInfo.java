package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;

public class MiniCard$NicePicInfo
{
  public String a = "";
  public String b = "";
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("oriUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("mediumUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.NicePicInfo
 * JD-Core Version:    0.7.0.1
 */