package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Map;

public final class Pegasus
  extends else
{
  public static Map<Integer, byte[]> a = new HashMap();
  public static Phoenix b = new Phoenix();
  public int c = 0;
  public Map<Integer, byte[]> d = null;
  public Phoenix e = null;
  
  static
  {
    a.put(Integer.valueOf(0), new byte[] { 0 });
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.c, 0);
    paramcase.a(this.d, 1);
    Phoenix localPhoenix = this.e;
    if (localPhoenix != null) {
      paramcase.a(localPhoenix, 2);
    }
  }
  
  public void a(try paramtry)
  {
    this.c = paramtry.a(this.c, 0, true);
    this.d = ((Map)paramtry.a(a, 1, true));
    this.e = ((Phoenix)paramtry.a(b, 2, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Pegasus
 * JD-Core Version:    0.7.0.1
 */