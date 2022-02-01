package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Octans
  extends else
{
  public static Map<Integer, byte[]> a = new HashMap();
  public static Perseus b;
  public static Orion c;
  public static Phoenix d;
  public static Map<Integer, String> e;
  public static Map<Integer, String> f;
  public long g = 0L;
  public Map<Integer, byte[]> h = null;
  public int i = 0;
  public Perseus j = null;
  public Orion k = null;
  public Phoenix l = null;
  public Map<Integer, String> m = null;
  public Map<Integer, String> n = null;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    a.put(localInteger, new byte[] { 0 });
    b = new Perseus();
    c = new Orion();
    d = new Phoenix();
    e = new HashMap();
    e.put(localInteger, "");
    f = new HashMap();
    f.put(localInteger, "");
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.g, 0);
    paramcase.a(this.h, 1);
    paramcase.a(this.i, 2);
    paramcase.a(this.j, 3);
    paramcase.a(this.k, 4);
    Object localObject = this.l;
    if (localObject != null) {
      paramcase.a((else)localObject, 5);
    }
    localObject = this.m;
    if (localObject != null) {
      paramcase.a((Map)localObject, 6);
    }
    localObject = this.n;
    if (localObject != null) {
      paramcase.a((Map)localObject, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.g = paramtry.a(this.g, 0, true);
    this.h = ((Map)paramtry.a(a, 1, true));
    this.i = paramtry.a(this.i, 2, true);
    this.j = ((Perseus)paramtry.a(b, 3, true));
    this.k = ((Orion)paramtry.a(c, 4, true));
    this.l = ((Phoenix)paramtry.a(d, 5, false));
    this.m = ((Map)paramtry.a(e, 6, false));
    this.n = ((Map)paramtry.a(f, 7, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Octans
 * JD-Core Version:    0.7.0.1
 */