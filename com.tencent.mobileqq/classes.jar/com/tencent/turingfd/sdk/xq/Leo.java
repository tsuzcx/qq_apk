package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Leo
  extends case
{
  public static Map<Integer, byte[]> ea = new HashMap();
  public static Norma fa;
  public static Lynx ga;
  public static Octans ha;
  public static Map<Integer, String> ia;
  public static Map<Integer, String> ja;
  public Map<Integer, byte[]> ka = null;
  public int la = 0;
  public Norma ma = null;
  public Lynx na = null;
  public Octans oa = null;
  public Map<Integer, String> pa = null;
  public Map<Integer, String> qa = null;
  public long timestamp = 0L;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ea.put(localInteger, new byte[] { 0 });
    fa = new Norma();
    ga = new Lynx();
    ha = new Octans();
    ia = new HashMap();
    ia.put(localInteger, "");
    ja = new HashMap();
    ja.put(localInteger, "");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.timestamp, 0);
    parambyte.a(this.ka, 1);
    parambyte.b(this.la, 2);
    parambyte.a(this.ma, 3);
    parambyte.a(this.na, 4);
    Object localObject = this.oa;
    if (localObject != null) {
      parambyte.a((case)localObject, 5);
    }
    localObject = this.pa;
    if (localObject != null) {
      parambyte.a((Map)localObject, 6);
    }
    localObject = this.qa;
    if (localObject != null) {
      parambyte.a((Map)localObject, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.timestamp = paramtry.a(this.timestamp, 0, true);
    this.ka = ((Map)paramtry.a(ea, 1, true));
    this.la = paramtry.a(this.la, 2, true);
    this.ma = ((Norma)paramtry.a(fa, 3, true));
    this.na = ((Lynx)paramtry.a(ga, 4, true));
    this.oa = ((Octans)paramtry.a(ha, 5, false));
    this.pa = ((Map)paramtry.a(ia, 6, false));
    this.qa = ((Map)paramtry.a(ja, 7, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Leo
 * JD-Core Version:    0.7.0.1
 */