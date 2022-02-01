package com.tencent.tfd.sdk.wxa;

import java.util.HashMap;
import java.util.Map;

public final class interface
  extends try
  implements Cloneable
{
  public static Map<String, String> n;
  public static Map<Integer, Integer> o;
  public static Map<String, String> p;
  public Map<String, String> path = null;
  public long r = 0L;
  public boolean s = true;
  public Map<Integer, Integer> t = null;
  public long u = 0L;
  public Map<String, String> v = null;
  public long version = 0L;
  
  static
  {
    n = new HashMap();
    n.put("", "");
    o = new HashMap();
    Integer localInteger = Integer.valueOf(0);
    o.put(localInteger, localInteger);
    p = new HashMap();
    p.put("", "");
  }
  
  public void a(int paramint)
  {
    this.r = paramint.a(this.r, 0, true);
    this.s = paramint.a(this.s, 1, true);
    this.version = paramint.a(this.version, 2, true);
    this.path = ((Map)paramint.a(n, 3, true));
    this.t = ((Map)paramint.a(o, 4, true));
    this.u = paramint.a(this.u, 5, true);
    this.v = ((Map)paramint.a(p, 6, false));
  }
  
  public void a(new paramnew)
  {
    paramnew.a(this.r, 0);
    paramnew.a(this.s, 1);
    paramnew.a(this.version, 2);
    paramnew.a(this.path, 3);
    paramnew.a(this.t, 4);
    paramnew.a(this.u, 5);
    Map localMap = this.v;
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
    if (q) {
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
    paramObject = (interface)paramObject;
    boolean bool1 = bool2;
    if (byte.a(this.r, paramObject.r))
    {
      bool1 = bool2;
      if (byte.a(this.s, paramObject.s))
      {
        bool1 = bool2;
        if (byte.a(this.version, paramObject.version))
        {
          bool1 = bool2;
          if (byte.equals(this.path, paramObject.path))
          {
            bool1 = bool2;
            if (byte.equals(this.t, paramObject.t))
            {
              bool1 = bool2;
              if (byte.a(this.u, paramObject.u))
              {
                bool1 = bool2;
                if (byte.equals(this.v, paramObject.v)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.interface
 * JD-Core Version:    0.7.0.1
 */