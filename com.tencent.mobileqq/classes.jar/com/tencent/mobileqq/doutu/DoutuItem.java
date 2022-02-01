package com.tencent.mobileqq.doutu;

import android.text.TextUtils;

public class DoutuItem
{
  public String a;
  public String b;
  public long c;
  public String d;
  public String e;
  public long f = 0L;
  public int g = 0;
  
  public DoutuItem() {}
  
  public DoutuItem(long paramLong, int paramInt)
  {
    this.f = paramLong;
    this.g = paramInt;
  }
  
  public DoutuItem(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong;
    this.d = paramString3;
    this.e = paramString4;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoutuItem uuid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", md5");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", fileId");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", url");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",key:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",count:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",picUin:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuItem
 * JD-Core Version:    0.7.0.1
 */