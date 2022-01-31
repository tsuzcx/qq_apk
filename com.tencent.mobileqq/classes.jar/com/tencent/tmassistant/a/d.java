package com.tencent.tmassistant.a;

import android.text.TextUtils;

class d
{
  String a;
  byte b;
  long c;
  String d;
  long e;
  String f;
  long g;
  long h;
  int i;
  String j;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.a);
    if (this.c != 0L)
    {
      m = 1;
      localStringBuilder.append("|" + this.c);
    }
    int k = m;
    if (!TextUtils.isEmpty(this.d))
    {
      k = m | 0x2;
      localStringBuilder.append("|" + this.d);
    }
    m = k;
    if (this.e != 0L)
    {
      m = k | 0x4;
      localStringBuilder.append("|" + this.e / 1000L);
    }
    k = m;
    if (!TextUtils.isEmpty(this.f))
    {
      k = m | 0x8;
      localStringBuilder.append("|" + this.f);
    }
    m = k;
    if (this.g != 0L)
    {
      m = k | 0x10;
      localStringBuilder.append("|" + this.g / 1000L + "_" + this.h / 1000L);
    }
    k = m;
    if (this.i != 0)
    {
      k = m | 0x20;
      localStringBuilder.append("|" + this.i);
    }
    m = k;
    if (!TextUtils.isEmpty(this.j))
    {
      m = k | 0x40;
      localStringBuilder.append("|" + this.j);
    }
    localStringBuilder.append(";");
    return m + "|" + localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.a.d
 * JD-Core Version:    0.7.0.1
 */