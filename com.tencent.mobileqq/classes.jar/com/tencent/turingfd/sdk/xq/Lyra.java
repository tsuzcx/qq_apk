package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Lyra
  extends case
{
  public static Octans ha = new Octans();
  public static Map<Integer, byte[]> ta = new HashMap();
  public int ba = 0;
  public Octans oa = null;
  public Map<Integer, byte[]> ua = null;
  
  static
  {
    ta.put(Integer.valueOf(0), new byte[] { 0 });
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ba, 0);
    parambyte.a(this.ua, 1);
    Octans localOctans = this.oa;
    if (localOctans != null) {
      parambyte.a(localOctans, 2);
    }
  }
  
  public void a(try paramtry)
  {
    this.ba = paramtry.a(this.ba, 0, true);
    this.ua = ((Map)paramtry.a(ta, 1, true));
    this.oa = ((Octans)paramtry.a(ha, 2, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lyra
 * JD-Core Version:    0.7.0.1
 */