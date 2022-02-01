package com.tencent.msf.service.protocol.security;

import java.io.Serializable;

public final class s
  implements Serializable
{
  public static final int a = 0;
  public static final s b = new s(0, 0, "VPIC_FORMAT_JPG");
  public static final int c = 1;
  public static final s d = new s(1, 1, "VPIC_FORMAT_PNG");
  public static final int e = 2;
  public static final s f = new s(2, 2, "VPIC_FORMAT_BMP");
  private static s[] h = new s[3];
  private int i;
  private String j = new String();
  
  private s(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public static s a(int paramInt)
  {
    int k = 0;
    for (;;)
    {
      localObject = h;
      if (k >= localObject.length) {
        break;
      }
      if (localObject[k].a() == paramInt) {
        return h[k];
      }
      k += 1;
    }
    if (g) {
      return null;
    }
    Object localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static s a(String paramString)
  {
    int k = 0;
    for (;;)
    {
      s[] arrayOfs = h;
      if (k >= arrayOfs.length) {
        break;
      }
      if (arrayOfs[k].toString().equals(paramString)) {
        return h[k];
      }
      k += 1;
    }
    if (g) {
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
    return this.i;
  }
  
  public String toString()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.s
 * JD-Core Version:    0.7.0.1
 */