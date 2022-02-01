package com.tencent.msf.service.protocol.f;

import java.io.Serializable;

public final class c
  implements Serializable
{
  public static final int a = 0;
  public static final c b = new c(0, 0, "GPS_WGS84");
  public static final int c = 1;
  public static final c d = new c(1, 1, "GPS_MARS");
  public static final int e = 2;
  public static final c f = new c(2, 2, "GPS_WGS_REAL");
  private static c[] h = new c[3];
  private int i;
  private String j = new String();
  
  private c(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public static c a(int paramInt)
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
  
  public static c a(String paramString)
  {
    int k = 0;
    for (;;)
    {
      c[] arrayOfc = h;
      if (k >= arrayOfc.length) {
        break;
      }
      if (arrayOfc[k].toString().equals(paramString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.f.c
 * JD-Core Version:    0.7.0.1
 */