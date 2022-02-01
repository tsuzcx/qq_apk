package com.tencent.turingfd.sdk.ams.ga;

import java.util.HashMap;
import java.util.Map;

public final class volatile
  extends try
  implements Cloneable
{
  public static Map<String, String> o;
  public static Map<Integer, Integer> p;
  public static Map<String, String> q;
  public Map<String, String> A = null;
  public Map<String, String> path = null;
  public long s = 0L;
  public boolean t = true;
  public Map<Integer, Integer> u = null;
  public long v = 0L;
  public long version = 0L;
  
  static
  {
    o = new HashMap();
    o.put("", "");
    p = new HashMap();
    Integer localInteger = Integer.valueOf(0);
    p.put(localInteger, localInteger);
    q = new HashMap();
    q.put("", "");
  }
  
  public void a(int paramint)
  {
    this.s = paramint.a(this.s, 0, true);
    this.t = paramint.a(this.t, 1, true);
    this.version = paramint.a(this.version, 2, true);
    this.path = ((Map)paramint.a(o, 3, true));
    this.u = ((Map)paramint.a(p, 4, true));
    this.v = paramint.a(this.v, 5, true);
    this.A = ((Map)paramint.a(q, 6, false));
  }
  
  public void a(new paramnew)
  {
    paramnew.a(this.s, 0);
    paramnew.a(this.t, 1);
    paramnew.a(this.version, 2);
    paramnew.a(this.path, 3);
    paramnew.a(this.u, 4);
    paramnew.a(this.v, 5);
    Map localMap = this.A;
    if (localMap != null) {
      paramnew.a(localMap, 6);
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (volatile)paramObject;
    boolean bool1 = bool2;
    if (byte.a(this.s, paramObject.s))
    {
      bool1 = bool2;
      if (byte.a(this.t, paramObject.t))
      {
        bool1 = bool2;
        if (byte.a(this.version, paramObject.version))
        {
          bool1 = bool2;
          if (byte.equals(this.path, paramObject.path))
          {
            bool1 = bool2;
            if (byte.equals(this.u, paramObject.u))
            {
              bool1 = bool2;
              if (byte.a(this.v, paramObject.v))
              {
                bool1 = bool2;
                if (byte.equals(this.A, paramObject.A)) {
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
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.volatile
 * JD-Core Version:    0.7.0.1
 */