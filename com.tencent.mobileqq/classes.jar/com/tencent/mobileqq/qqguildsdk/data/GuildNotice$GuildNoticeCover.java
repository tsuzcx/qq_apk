package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

public class GuildNotice$GuildNoticeCover
{
  public int a = 0;
  public long b = 0L;
  public String c;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" id:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeCover
 * JD-Core Version:    0.7.0.1
 */