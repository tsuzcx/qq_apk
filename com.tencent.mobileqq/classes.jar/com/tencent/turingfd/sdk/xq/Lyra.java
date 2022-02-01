package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Lyra
  extends case
{
  public static Map<Integer, Integer> fc = new HashMap();
  public Map<Integer, Integer> gc = null;
  
  static
  {
    fc.put(Integer.valueOf(0), Integer.valueOf(0));
  }
  
  public void a(byte parambyte)
  {
    Map localMap = this.gc;
    if (localMap != null) {
      parambyte.a(localMap, 0);
    }
  }
  
  public void a(try paramtry)
  {
    this.gc = ((Map)paramtry.a(fc, 0, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lyra
 * JD-Core Version:    0.7.0.1
 */