package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import java.util.HashMap;
import java.util.Map;

public class Bennet
  extends case
{
  public static Map<Integer, FeatureInfo> kc = new HashMap();
  public Map<Integer, FeatureInfo> lc = null;
  public int qd = 0;
  
  static
  {
    FeatureInfo localFeatureInfo = new FeatureInfo();
    kc.put(Integer.valueOf(0), localFeatureInfo);
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.lc, 0);
    parambyte.b(this.qd, 1);
  }
  
  public void a(try paramtry)
  {
    this.lc = ((Map)paramtry.a(kc, 0, true));
    this.qd = paramtry.a(this.qd, 1, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Bennet)) {
      return false;
    }
    paramObject = (Bennet)paramObject;
    return (char.equals(this.lc, paramObject.lc)) && (char.equals(this.qd, paramObject.qd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bennet
 * JD-Core Version:    0.7.0.1
 */