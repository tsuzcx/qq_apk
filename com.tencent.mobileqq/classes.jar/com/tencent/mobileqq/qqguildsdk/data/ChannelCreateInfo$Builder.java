package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.Nullable;
import java.util.List;

public class ChannelCreateInfo$Builder
{
  private int a;
  private String b;
  private int c;
  private int d;
  private int e;
  private int f;
  private String g;
  private String h;
  private long i = 0L;
  private int j;
  private List<String> k;
  
  public Builder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.i = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder a(@Nullable List<String> paramList)
  {
    this.k = paramList;
    return this;
  }
  
  public ChannelCreateInfo a()
  {
    return new ChannelCreateInfo(this, null);
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo.Builder
 * JD-Core Version:    0.7.0.1
 */