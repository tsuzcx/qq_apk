package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

public class GuildNotice$GuildNoticeAction
{
  public int a = 0;
  public String b;
  public String c;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" actionId:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" title:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeAction
 * JD-Core Version:    0.7.0.1
 */