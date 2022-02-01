package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;

public class MiniCard$BaseProfile
{
  public int a = -1;
  public int b = -1;
  public String c = "";
  public String d = "";
  public int e = -1;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("age");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("gender");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("place");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("addSrc");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("commFrdCnt");
    localStringBuilder.append("=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.BaseProfile
 * JD-Core Version:    0.7.0.1
 */