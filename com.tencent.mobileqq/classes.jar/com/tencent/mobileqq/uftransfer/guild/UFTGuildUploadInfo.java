package com.tencent.mobileqq.uftransfer.guild;

import com.tencent.mobileqq.uftransfer.api.UFTBaseUploadInfo;

public class UFTGuildUploadInfo
  extends UFTBaseUploadInfo
{
  String a;
  String b;
  long c;
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  public long g()
  {
    return this.c;
  }
  
  public String h()
  {
    return this.a;
  }
  
  public String i()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mGuildId = ");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mChannelId = ");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(super.toString());
    localStringBuilder2.append(localStringBuilder1.toString());
    return localStringBuilder2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadInfo
 * JD-Core Version:    0.7.0.1
 */