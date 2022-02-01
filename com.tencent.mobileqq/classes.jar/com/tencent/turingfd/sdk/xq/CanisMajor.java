package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class CanisMajor
  extends case
{
  public static Centaurus ca = new Centaurus();
  public static Map<Integer, byte[]> oa = new HashMap();
  public int R = 0;
  public Centaurus ja = null;
  public Map<Integer, byte[]> pa = null;
  
  static
  {
    oa.put(Integer.valueOf(0), new byte[] { 0 });
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.R, 0);
    parambyte.a(this.pa, 1);
    Centaurus localCentaurus = this.ja;
    if (localCentaurus != null) {
      parambyte.a(localCentaurus, 2);
    }
  }
  
  public void a(try paramtry)
  {
    this.R = paramtry.a(this.R, 0, true);
    this.pa = ((Map)paramtry.a(oa, 1, true));
    this.ja = ((Centaurus)paramtry.a(ca, 2, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.CanisMajor
 * JD-Core Version:    0.7.0.1
 */