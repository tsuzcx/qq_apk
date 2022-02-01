package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Almond
  extends case
{
  public static Map<Integer, Integer> kc = new HashMap();
  public Map<Integer, Integer> lc = null;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    kc.put(localInteger, localInteger);
  }
  
  public void a(byte parambyte)
  {
    Map localMap = this.lc;
    if (localMap != null) {
      parambyte.a(localMap, 0);
    }
  }
  
  public void a(try paramtry)
  {
    this.lc = ((Map)paramtry.a(kc, 0, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Almond
 * JD-Core Version:    0.7.0.1
 */