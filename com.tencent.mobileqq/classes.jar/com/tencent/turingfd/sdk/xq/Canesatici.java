package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Canesatici
  extends case
{
  public static Map<Integer, byte[]> W = new HashMap();
  public static Cassiopeia aa;
  public static CanisMinor ba;
  public static Centaurus ca;
  public static Map<Integer, String> da;
  public static Map<Integer, String> ea;
  public Map<Integer, byte[]> fa = null;
  public int ga = 0;
  public Cassiopeia ha = null;
  public CanisMinor ia = null;
  public Centaurus ja = null;
  public Map<Integer, String> ka = null;
  public Map<Integer, String> la = null;
  public long timestamp = 0L;
  
  static
  {
    W.put(Integer.valueOf(0), new byte[] { 0 });
    aa = new Cassiopeia();
    ba = new CanisMinor();
    ca = new Centaurus();
    da = new HashMap();
    da.put(Integer.valueOf(0), "");
    ea = new HashMap();
    ea.put(Integer.valueOf(0), "");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.timestamp, 0);
    parambyte.a(this.fa, 1);
    parambyte.a(this.ga, 2);
    parambyte.a(this.ha, 3);
    parambyte.a(this.ia, 4);
    Object localObject = this.ja;
    if (localObject != null) {
      parambyte.a((case)localObject, 5);
    }
    localObject = this.ka;
    if (localObject != null) {
      parambyte.a((Map)localObject, 6);
    }
    localObject = this.la;
    if (localObject != null) {
      parambyte.a((Map)localObject, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.timestamp = paramtry.a(this.timestamp, 0, true);
    this.fa = ((Map)paramtry.a(W, 1, true));
    this.ga = paramtry.a(this.ga, 2, true);
    this.ha = ((Cassiopeia)paramtry.a(aa, 3, true));
    this.ia = ((CanisMinor)paramtry.a(ba, 4, true));
    this.ja = ((Centaurus)paramtry.a(ca, 5, false));
    this.ka = ((Map)paramtry.a(da, 6, false));
    this.la = ((Map)paramtry.a(ea, 7, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Canesatici
 * JD-Core Version:    0.7.0.1
 */