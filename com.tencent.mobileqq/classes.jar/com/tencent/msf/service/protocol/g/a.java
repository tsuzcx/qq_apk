package com.tencent.msf.service.protocol.g;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public static final int a = 1;
  public static final a b = new a(0, 1, "REQUEST");
  public static final int c = 3;
  public static final a d = new a(1, 3, "QUERYSMSSTAT");
  public static final int e = 4;
  public static final a f = new a(2, 4, "REQUESTSMSAG");
  public static final int g = 5;
  public static final a h = new a(3, 5, "VERIFYSMSCODE");
  public static final int i = 6;
  public static final a j = new a(4, 6, "GETQQ");
  public static final int k = 7;
  public static final a l = new a(5, 7, "QUERYACCOUNT");
  public static final int m = 9;
  public static final a n = new a(6, 9, "VERIFYANDGETQQ");
  public static final int o = 10;
  public static final a p = new a(7, 10, "REQUEST_EX");
  private static a[] r = new a[8];
  private int s;
  private String t = new String();
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this.t = paramString;
    this.s = paramInt2;
    r[paramInt1] = this;
  }
  
  public static a a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      localObject = r;
      if (i1 >= localObject.length) {
        break;
      }
      if (localObject[i1].a() == paramInt) {
        return r[i1];
      }
      i1 += 1;
    }
    if (q) {
      return null;
    }
    Object localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static a a(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      a[] arrayOfa = r;
      if (i1 >= arrayOfa.length) {
        break;
      }
      if (arrayOfa[i1].toString().equals(paramString)) {
        return r[i1];
      }
      i1 += 1;
    }
    if (q) {
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
    return this.s;
  }
  
  public String toString()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.g.a
 * JD-Core Version:    0.7.0.1
 */