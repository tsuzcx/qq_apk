package com.tencent.msf.service.protocol.serverconfig;

import java.io.Serializable;

public final class b
  implements Serializable
{
  public static final int a = 1;
  public static final b b = new b(0, 1, "CliLogCfgByTime");
  public static final int c = 2;
  public static final b d = new b(1, 2, "CliLogCfgSetLevel");
  private static b[] f = new b[2];
  private int g;
  private String h = new String();
  
  private b(int paramInt1, int paramInt2, String paramString)
  {
    this.h = paramString;
    this.g = paramInt2;
    f[paramInt1] = this;
  }
  
  public static b a(int paramInt)
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
  
  public static b a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      b[] arrayOfb = f;
      if (i >= arrayOfb.length) {
        break;
      }
      if (arrayOfb[i].toString().equals(paramString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.b
 * JD-Core Version:    0.7.0.1
 */