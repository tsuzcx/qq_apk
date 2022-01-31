package com.tencent.tmassistantbase.util;

import android.text.TextUtils;

public final class u
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public int h;
  public int i;
  
  private String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("0");
    localStringBuffer.append(this.b.subSequence(0, 1));
    localStringBuffer.append(this.c);
    return localStringBuffer.toString();
  }
  
  public String a()
  {
    String str = b();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("TMASDK_");
    localStringBuffer.append(this.b);
    if (!TextUtils.isEmpty(this.d))
    {
      localStringBuffer.append("_");
      localStringBuffer.append(this.d);
    }
    localStringBuffer.append("/");
    localStringBuffer.append(str);
    localStringBuffer.append("&NA/");
    localStringBuffer.append(str);
    localStringBuffer.append("&");
    localStringBuffer.append(this.f);
    localStringBuffer.append("_");
    localStringBuffer.append(this.i);
    localStringBuffer.append("&");
    localStringBuffer.append(this.g / 16);
    localStringBuffer.append("_");
    localStringBuffer.append(this.h / 16);
    localStringBuffer.append("_");
    localStringBuffer.append("14&");
    localStringBuffer.append(this.a);
    localStringBuffer.append("&");
    localStringBuffer.append(this.e);
    localStringBuffer.append("&");
    localStringBuffer.append("NA");
    localStringBuffer.append("&");
    localStringBuffer.append("V3");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.u
 * JD-Core Version:    0.7.0.1
 */