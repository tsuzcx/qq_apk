package com.tencent.msf.service.protocol.security;

import java.io.Serializable;

public final class t
  implements Serializable
{
  public static final int a = 0;
  public static final t b = new t(0, 0, "VPIC_TYPE_URL");
  public static final int c = 1;
  public static final t d = new t(1, 1, "VPIC_TYPE_BIN");
  private static t[] f = new t[2];
  private int g;
  private String h = new String();
  
  private t(int paramInt1, int paramInt2, String paramString)
  {
    this.h = paramString;
    this.g = paramInt2;
    f[paramInt1] = this;
  }
  
  public static t a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject = f;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i].a() == paramInt) {
        return f[i];
      }
      i += 1;
    }
    if (e) {
      return null;
    }
    Object localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static t a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      t[] arrayOft = f;
      if (i >= arrayOft.length) {
        break;
      }
      if (arrayOft[i].toString().equals(paramString)) {
        return f[i];
      }
      i += 1;
    }
    if (e) {
      return null;
    }
    paramString = new AssertionError();
    for (;;)
    {
      throw paramString;
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public String toString()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.t
 * JD-Core Version:    0.7.0.1
 */