package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import java.util.HashMap;
import java.util.Map;

public class Blackberry
  extends else
{
  public static Map<Integer, FeatureInfo> a = new HashMap();
  public Map<Integer, FeatureInfo> b = null;
  public int c = 0;
  
  static
  {
    FeatureInfo localFeatureInfo = new FeatureInfo();
    a.put(Integer.valueOf(0), localFeatureInfo);
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.b, 0);
    paramcase.a(this.c, 1);
  }
  
  public void a(try paramtry)
  {
    this.b = ((Map)paramtry.a(a, 0, true));
    this.c = paramtry.a(this.c, 1, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Blackberry)) {
      return false;
    }
    paramObject = (Blackberry)paramObject;
    Map localMap1 = this.b;
    Map localMap2 = paramObject.b;
    int i = goto.a;
    return (localMap1.equals(localMap2)) && (goto.a(this.c, paramObject.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Blackberry
 * JD-Core Version:    0.7.0.1
 */