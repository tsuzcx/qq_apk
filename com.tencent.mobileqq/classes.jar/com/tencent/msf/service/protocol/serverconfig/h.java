package com.tencent.msf.service.protocol.serverconfig;

import java.io.Serializable;

public final class h
  implements Serializable
{
  public static final int a = 1;
  public static final h b;
  public static final int c = 2;
  public static final h d;
  public static final int e = 3;
  public static final h f;
  public static final int g = 4;
  public static final h h;
  private static h[] j;
  private int k;
  private String l = new String();
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      j = new h[3];
      b = new h(0, 1, "PUSH_SERVER_LIST");
      d = new h(1, 2, "PUSH_FMT_SERVER_LIST");
      f = new h(2, 3, "PUSH_CLILOG_CONFIG");
      h = new h(2, 4, "PUSH_PROXY_LIST");
      return;
    }
  }
  
  private h(int paramInt1, int paramInt2, String paramString)
  {
    this.l = paramString;
    this.k = paramInt2;
    j[paramInt1] = this;
  }
  
  public static h a(int paramInt)
  {
    int m = 0;
    while (m < j.length)
    {
      if (j[m].a() == paramInt) {
        return j[m];
      }
      m += 1;
    }
    if (!i) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static h a(String paramString)
  {
    int m = 0;
    while (m < j.length)
    {
      if (j[m].toString().equals(paramString)) {
        return j[m];
      }
      m += 1;
    }
    if (!i) {
      throw new AssertionError();
    }
    return null;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public String toString()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.h
 * JD-Core Version:    0.7.0.1
 */