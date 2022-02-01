package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;

public class MiniCard$Sign
{
  public int a = 0;
  public String b = "";
  public String c = "";
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("actionId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("actionAndData");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("plainText");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.Sign
 * JD-Core Version:    0.7.0.1
 */