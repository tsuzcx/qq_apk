package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import java.util.HashMap;
import java.util.Map;

public class Pyxis
  extends case
{
  public static Map<Integer, FeatureInfo> fc = new HashMap();
  public Map<Integer, FeatureInfo> gc = null;
  public int ld = 0;
  
  static
  {
    FeatureInfo localFeatureInfo = new FeatureInfo();
    fc.put(Integer.valueOf(0), localFeatureInfo);
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.gc, 0);
    parambyte.a(this.ld, 1);
  }
  
  public void a(try paramtry)
  {
    this.gc = ((Map)paramtry.a(fc, 0, true));
    this.ld = paramtry.a(this.ld, 1, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof Pyxis)) {
        return false;
      }
      paramObject = (Pyxis)paramObject;
    } while ((char.equals(this.gc, paramObject.gc)) && (char.equals(this.ld, paramObject.ld)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Pyxis
 * JD-Core Version:    0.7.0.1
 */