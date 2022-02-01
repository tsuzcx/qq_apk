package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Bootes
  extends case
  implements Cloneable
{
  public static Map<String, String> C;
  public static Map<Integer, Integer> D;
  public static Map<String, String> F;
  public long G = 0L;
  public boolean H = true;
  public Map<Integer, Integer> I = null;
  public long J = 0L;
  public Map<String, String> K = null;
  public Map<String, String> path = null;
  public long version = 0L;
  
  static
  {
    C = new HashMap();
    C.put("", "");
    D = new HashMap();
    D.put(Integer.valueOf(0), Integer.valueOf(0));
    F = new HashMap();
    F.put("", "");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.G, 0);
    parambyte.a(this.H, 1);
    parambyte.a(this.version, 2);
    parambyte.a(this.path, 3);
    parambyte.a(this.I, 4);
    parambyte.a(this.J, 5);
    Map localMap = this.K;
    if (localMap != null) {
      parambyte.a(localMap, 6);
    }
  }
  
  public void a(try paramtry)
  {
    this.G = paramtry.a(this.G, 0, true);
    this.H = paramtry.a(this.H, 1, true);
    this.version = paramtry.a(this.version, 2, true);
    this.path = ((Map)paramtry.a(C, 3, true));
    this.I = ((Map)paramtry.a(D, 4, true));
    this.J = paramtry.a(this.J, 5, true);
    this.K = ((Map)paramtry.a(F, 6, false));
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
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Bootes)paramObject;
    } while ((!char.a(this.G, paramObject.G)) || (!char.a(this.H, paramObject.H)) || (!char.a(this.version, paramObject.version)) || (!char.equals(this.path, paramObject.path)) || (!char.equals(this.I, paramObject.I)) || (!char.a(this.J, paramObject.J)) || (!char.equals(this.K, paramObject.K)));
    return true;
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
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bootes
 * JD-Core Version:    0.7.0.1
 */