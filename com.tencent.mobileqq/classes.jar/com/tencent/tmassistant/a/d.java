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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.b);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.a);
    if (this.c != 0L)
    {
      m = 1;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|");
      localStringBuilder2.append(this.c);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else
    {
      m = 0;
    }
    int k = m;
    if (!TextUtils.isEmpty(this.d))
    {
      k = m | 0x2;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|");
      localStringBuilder2.append(this.d);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    int m = k;
    if (this.e != 0L)
    {
      m = k | 0x4;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|");
      localStringBuilder2.append(this.e / 1000L);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    k = m;
    if (!TextUtils.isEmpty(this.f))
    {
      k = m | 0x8;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|");
      localStringBuilder2.append(this.f);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    m = k;
    if (this.g != 0L)
    {
      m = k | 0x10;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|");
      localStringBuilder2.append(this.g / 1000L);
      localStringBuilder2.append("_");
      localStringBuilder2.append(this.h / 1000L);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    k = m;
    if (this.i != 0)
    {
      k = m | 0x20;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|");
      localStringBuilder2.append(this.i);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    m = k;
    if (!TextUtils.isEmpty(this.j))
    {
      m = k | 0x40;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|");
      localStringBuilder2.append(this.j);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder1.append(";");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(m);
    localStringBuilder2.append("|");
    localStringBuilder2.append(localStringBuilder1.toString());
    return localStringBuilder2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.a.d
 * JD-Core Version:    0.7.0.1
 */