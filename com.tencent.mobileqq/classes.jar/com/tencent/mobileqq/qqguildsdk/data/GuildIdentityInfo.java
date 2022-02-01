package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;

public class GuildIdentityInfo
{
  private long a;
  private String b;
  private String c;
  
  public GuildIdentityInfo(long paramLong, String paramString1, String paramString2)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.a != 0L) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildIdentityInfo{appid : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", orgID : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", worldID : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildIdentityInfo
 * JD-Core Version:    0.7.0.1
 */