package com.tencent.qmsp.sdk.base;

import android.text.TextUtils;

public enum d
{
  private String a;
  
  private d(int paramInt, String paramString)
  {
    this.a = paramString;
  }
  
  public static d a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return b;
    }
    d[] arrayOfd = values();
    int i2 = arrayOfd.length;
    int i1 = 0;
    while (i1 < i2)
    {
      d locald = arrayOfd[i1];
      if (locald.a.equalsIgnoreCase(paramString)) {
        return locald;
      }
      i1 += 1;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.base.d
 * JD-Core Version:    0.7.0.1
 */