package com.tencent.turingfd.sdk.xq;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class for
  extends case
{
  public static byte[] p = null;
  public static Map<String, String> q = null;
  public String A = null;
  public String B = null;
  public byte[] C;
  public int D = 0;
  public Map<String, String> F;
  public short s = 0;
  public Map<String, String> status;
  public byte t = 0;
  public int u = 0;
  public int v = 0;
  
  public void a(byte parambyte)
  {
    parambyte.a(this.s, 1);
    parambyte.a(this.t, 2);
    parambyte.b(this.u, 3);
    parambyte.b(this.v, 4);
    parambyte.b(this.A, 5);
    parambyte.b(this.B, 6);
    parambyte.a(this.C, 7);
    parambyte.b(this.D, 8);
    parambyte.a(this.F, 9);
    parambyte.a(this.status, 10);
  }
  
  public void a(try paramtry)
  {
    try
    {
      this.s = paramtry.a(this.s, 1, true);
      this.t = paramtry.a(this.t, 2, true);
      this.u = paramtry.a(this.u, 3, true);
      this.v = paramtry.a(this.v, 4, true);
      this.A = paramtry.a(5, true);
      this.B = paramtry.a(6, true);
      localObject = p;
      if (localObject == null) {
        p = new byte[] { 0 };
      }
      this.C = paramtry.a(p, 7, true);
      this.D = paramtry.a(this.D, 8, true);
      localObject = q;
      if (localObject == null)
      {
        q = new HashMap();
        q.put("", "");
      }
      this.F = ((Map)paramtry.a(q, 9, true));
      if (q == null)
      {
        q = new HashMap();
        q.put("", "");
      }
      this.status = ((Map)paramtry.a(q, 10, true));
      return;
    }
    catch (Exception paramtry)
    {
      paramtry.printStackTrace();
      Object localObject = System.out;
      StringBuilder localStringBuilder = do.b("RequestPacket decode error ");
      localStringBuilder.append(if.a(this.C));
      ((PrintStream)localObject).println(localStringBuilder.toString());
      throw new RuntimeException(paramtry);
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
    if (r) {
      return null;
    }
    throw new AssertionError();
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (for)paramObject;
    int i = paramObject.s;
    Integer localInteger = Integer.valueOf(1);
    return (char.equals(1, i)) && (char.equals(1, paramObject.t)) && (char.equals(1, paramObject.u)) && (char.equals(1, paramObject.v)) && (char.equals(localInteger, paramObject.A)) && (char.equals(localInteger, paramObject.B)) && (char.equals(localInteger, paramObject.C)) && (char.equals(1, paramObject.D)) && (char.equals(localInteger, paramObject.F)) && (char.equals(localInteger, paramObject.status));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.for
 * JD-Core Version:    0.7.0.1
 */