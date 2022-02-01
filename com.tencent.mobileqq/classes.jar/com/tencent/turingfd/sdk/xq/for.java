package com.tencent.turingfd.sdk.xq;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class for
  extends case
{
  public static byte[] k = null;
  public static Map<String, String> l = null;
  public short n = 0;
  public byte o = 0;
  public int p = 0;
  public int q = 0;
  public String r = null;
  public String s = null;
  public Map<String, String> status;
  public byte[] t;
  public int u = 0;
  public Map<String, String> v;
  
  public void a(byte parambyte)
  {
    parambyte.a(this.n, 1);
    parambyte.a(this.o, 2);
    parambyte.a(this.p, 3);
    parambyte.a(this.q, 4);
    parambyte.b(this.r, 5);
    parambyte.b(this.s, 6);
    parambyte.a(this.t, 7);
    parambyte.a(this.u, 8);
    parambyte.a(this.v, 9);
    parambyte.a(this.status, 10);
  }
  
  public void a(try paramtry)
  {
    try
    {
      this.n = paramtry.a(this.n, 1, true);
      this.o = paramtry.a(this.o, 2, true);
      this.p = paramtry.a(this.p, 3, true);
      this.q = paramtry.a(this.q, 4, true);
      this.r = paramtry.a(5, true);
      this.s = paramtry.a(6, true);
      Object localObject = k;
      if (localObject == null) {
        k = new byte[] { 0 };
      }
      this.t = paramtry.a(k, 7, true);
      this.u = paramtry.a(this.u, 8, true);
      if (l == null)
      {
        l = new HashMap();
        localObject = l;
        ((Map)localObject).put("", "");
      }
      this.v = ((Map)paramtry.a(l, 9, true));
      if (l == null)
      {
        l = new HashMap();
        localObject = l;
        ((Map)localObject).put("", "");
      }
      this.status = ((Map)paramtry.a(l, 10, true));
      return;
    }
    catch (Exception paramtry)
    {
      paramtry.printStackTrace();
      System.out.println(if.a(this.t));
      throw new RuntimeException(paramtry);
    }
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (m) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (for)paramObject;
    return (char.equals(1, paramObject.n)) && (char.equals(1, paramObject.o)) && (char.equals(1, paramObject.p)) && (char.equals(1, paramObject.q)) && (char.equals(Integer.valueOf(1), paramObject.r)) && (char.equals(Integer.valueOf(1), paramObject.s)) && (char.equals(Integer.valueOf(1), paramObject.t)) && (char.equals(1, paramObject.u)) && (char.equals(Integer.valueOf(1), paramObject.v)) && (char.equals(Integer.valueOf(1), paramObject.status));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.for
 * JD-Core Version:    0.7.0.1
 */