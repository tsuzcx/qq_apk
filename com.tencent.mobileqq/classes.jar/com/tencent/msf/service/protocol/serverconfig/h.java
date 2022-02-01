package com.tencent.msf.service.protocol.serverconfig;

import java.io.Serializable;

public final class h
  implements Serializable
{
  public static final int a = 1;
  public static final h b = new h(0, 1, "PUSH_SERVER_LIST");
  public static final int c = 2;
  public static final h d = new h(1, 2, "PUSH_FMT_SERVER_LIST");
  public static final int e = 3;
  public static final h f = new h(2, 3, "PUSH_CLILOG_CONFIG");
  private static h[] h = new h[3];
  private int i;
  private String j = new String();
  
  private h(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public static h a(int paramInt)
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
  
  public static h a(String paramString)
  {
    int k = 0;
    for (;;)
    {
      h[] arrayOfh = h;
      if (k >= arrayOfh.length) {
        break;
      }
      if (arrayOfh[k].toString().equals(paramString)) {
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
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.h
 * JD-Core Version:    0.7.0.1
 */