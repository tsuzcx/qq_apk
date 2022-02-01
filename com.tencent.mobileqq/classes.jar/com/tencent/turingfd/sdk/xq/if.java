package com.tencent.turingfd.sdk.xq;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class if
  extends else
{
  public static byte[] a = null;
  public static Map<String, String> b = null;
  public short d = 0;
  public byte e = 0;
  public int f = 0;
  public int g = 0;
  public String h = null;
  public String i = null;
  public byte[] j;
  public int k = 0;
  public Map<String, String> l;
  public Map<String, String> m;
  
  public void a(case paramcase)
  {
    paramcase.a(this.d, 1);
    paramcase.a(this.e, 2);
    paramcase.a(this.f, 3);
    paramcase.a(this.g, 4);
    paramcase.a(this.h, 5);
    paramcase.a(this.i, 6);
    paramcase.a(this.j, 7);
    paramcase.a(this.k, 8);
    paramcase.a(this.l, 9);
    paramcase.a(this.m, 10);
  }
  
  public void a(try paramtry)
  {
    try
    {
      this.d = paramtry.a(this.d, 1, true);
      this.e = paramtry.a(this.e, 2, true);
      this.f = paramtry.a(this.f, 3, true);
      this.g = paramtry.a(this.g, 4, true);
      this.h = paramtry.b(5, true);
      this.i = paramtry.b(6, true);
      if (a == null) {
        a = new byte[] { 0 };
      }
      this.j = paramtry.a(7, true);
      this.k = paramtry.a(this.k, 8, true);
      Object localObject = b;
      if (localObject == null)
      {
        localObject = new HashMap();
        b = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.l = ((Map)paramtry.a(b, 9, true));
      if (b == null)
      {
        localObject = new HashMap();
        b = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.m = ((Map)paramtry.a(b, 10, true));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestPacket decode error ");
      paramtry = this.j;
      if ((paramtry != null) && (paramtry.length != 0))
      {
        char[] arrayOfChar1 = new char[paramtry.length * 2];
        int n = 0;
        while (n < paramtry.length)
        {
          int i1 = paramtry[n];
          int i2 = n * 2;
          char[] arrayOfChar2 = do.a;
          arrayOfChar1[(i2 + 1)] = arrayOfChar2[(i1 & 0xF)];
          arrayOfChar1[(i2 + 0)] = arrayOfChar2[((byte)(i1 >>> 4) & 0xF)];
          n += 1;
        }
        paramtry = new String(arrayOfChar1);
      }
      else
      {
        paramtry = null;
      }
      localStringBuilder.append(paramtry);
      localPrintStream.println(localStringBuilder.toString());
      paramtry = new RuntimeException(localException);
    }
    for (;;)
    {
      throw paramtry;
    }
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (c) {
      return null;
    }
    throw new AssertionError();
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (if)paramObject;
    int n = paramObject.d;
    Integer localInteger = Integer.valueOf(1);
    return (goto.a(1, n)) && (goto.a(1, paramObject.e)) && (goto.a(1, paramObject.f)) && (goto.a(1, paramObject.g)) && (localInteger.equals(paramObject.h)) && (localInteger.equals(paramObject.i)) && (localInteger.equals(paramObject.j)) && (goto.a(1, paramObject.k)) && (localInteger.equals(paramObject.l)) && (localInteger.equals(paramObject.m));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.if
 * JD-Core Version:    0.7.0.1
 */