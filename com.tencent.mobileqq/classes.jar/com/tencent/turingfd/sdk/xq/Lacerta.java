package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Lacerta
  extends case
  implements Cloneable
{
  public static Map<String, String> I;
  public static Map<Integer, Integer> J;
  public static Map<String, String> K;
  public long Q = 0L;
  public boolean R = true;
  public Map<Integer, Integer> S = null;
  public long U = 0L;
  public Map<String, String> W = null;
  public Map<String, String> path = null;
  public long version = 0L;
  
  static
  {
    I = new HashMap();
    I.put("", "");
    J = new HashMap();
    Integer localInteger = Integer.valueOf(0);
    J.put(localInteger, localInteger);
    K = new HashMap();
    K.put("", "");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.Q, 0);
    parambyte.a(this.R, 1);
    parambyte.a(this.version, 2);
    parambyte.a(this.path, 3);
    parambyte.a(this.S, 4);
    parambyte.a(this.U, 5);
    Map localMap = this.W;
    if (localMap != null) {
      parambyte.a(localMap, 6);
    }
  }
  
  public void a(try paramtry)
  {
    this.Q = paramtry.a(this.Q, 0, true);
    this.R = paramtry.a(this.R, 1, true);
    this.version = paramtry.a(this.version, 2, true);
    this.path = ((Map)paramtry.a(I, 3, true));
    this.S = ((Map)paramtry.a(J, 4, true));
    this.U = paramtry.a(this.U, 5, true);
    this.W = ((Map)paramtry.a(K, 6, false));
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
    paramObject = (Lacerta)paramObject;
    boolean bool1 = bool2;
    if (char.a(this.Q, paramObject.Q))
    {
      bool1 = bool2;
      if (char.a(this.R, paramObject.R))
      {
        bool1 = bool2;
        if (char.a(this.version, paramObject.version))
        {
          bool1 = bool2;
          if (char.equals(this.path, paramObject.path))
          {
            bool1 = bool2;
            if (char.equals(this.S, paramObject.S))
            {
              bool1 = bool2;
              if (char.a(this.U, paramObject.U))
              {
                bool1 = bool2;
                if (char.equals(this.W, paramObject.W)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lacerta
 * JD-Core Version:    0.7.0.1
 */