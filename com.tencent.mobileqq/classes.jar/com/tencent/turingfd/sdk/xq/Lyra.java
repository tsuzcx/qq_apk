package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Lyra
  extends else
  implements Cloneable
{
  public static Map<String, String> a;
  public static Map<Integer, Integer> b;
  public static Map<String, String> c;
  public long e = 0L;
  public boolean f = true;
  public long g = 0L;
  public Map<String, String> h = null;
  public Map<Integer, Integer> i = null;
  public long j = 0L;
  public Map<String, String> k = null;
  
  static
  {
    Object localObject = new HashMap();
    a = (Map)localObject;
    ((Map)localObject).put("", "");
    b = new HashMap();
    localObject = Integer.valueOf(0);
    b.put(localObject, localObject);
    localObject = new HashMap();
    c = (Map)localObject;
    ((Map)localObject).put("", "");
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.e, 0);
    paramcase.a((byte)this.f, 1);
    paramcase.a(this.g, 2);
    paramcase.a(this.h, 3);
    paramcase.a(this.i, 4);
    paramcase.a(this.j, 5);
    Map localMap = this.k;
    if (localMap != null) {
      paramcase.a(localMap, 6);
    }
  }
  
  public void a(try paramtry)
  {
    this.e = paramtry.a(this.e, 0, true);
    this.f = paramtry.a(this.f, 1, true);
    this.g = paramtry.a(this.g, 2, true);
    this.h = ((Map)paramtry.a(a, 3, true));
    this.i = ((Map)paramtry.a(b, 4, true));
    this.j = paramtry.a(this.j, 5, true);
    this.k = ((Map)paramtry.a(c, 6, false));
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
    if (d) {
      return null;
    }
    throw new AssertionError();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (Lyra)paramObject;
    boolean bool1 = bool2;
    if (goto.a(this.e, paramObject.e))
    {
      bool1 = bool2;
      if (goto.a(this.f, paramObject.f))
      {
        bool1 = bool2;
        if (goto.a(this.g, paramObject.g))
        {
          bool1 = bool2;
          if (this.h.equals(paramObject.h))
          {
            bool1 = bool2;
            if (this.i.equals(paramObject.i))
            {
              bool1 = bool2;
              if (goto.a(this.j, paramObject.j))
              {
                bool1 = bool2;
                if (this.k.equals(paramObject.k)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lyra
 * JD-Core Version:    0.7.0.1
 */