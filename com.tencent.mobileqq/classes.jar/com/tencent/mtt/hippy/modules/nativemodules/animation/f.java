package com.tencent.mtt.hippy.modules.nativemodules.animation;

import com.tencent.mtt.hippy.common.HippyArray;

public class f
{
  protected HippyArray a;
  protected HippyArray b;
  
  public f(HippyArray paramHippyArray1, HippyArray paramHippyArray2)
  {
    this.a = paramHippyArray1;
    this.b = paramHippyArray2;
  }
  
  public Object a(Number paramNumber)
  {
    HippyArray localHippyArray = this.a;
    if (localHippyArray == null) {
      return null;
    }
    if (this.b == null) {
      return null;
    }
    int m = localHippyArray.size();
    if (m != this.b.size()) {
      return null;
    }
    if (m == 0) {
      return null;
    }
    double d4 = paramNumber.doubleValue();
    int i = 0;
    double d1 = -1.0D;
    int j = 0;
    while (i < m)
    {
      paramNumber = this.a.get(i);
      if (paramNumber != null)
      {
        if (!(paramNumber instanceof Number)) {
          return null;
        }
        double d3 = ((Number)paramNumber).doubleValue();
        int k = j;
        double d2 = d1;
        if (d3 <= d4)
        {
          d3 = Math.abs(d4 - d3);
          if (d3 >= d1)
          {
            k = j;
            d2 = d1;
            if (d1 != -1.0D) {}
          }
          else
          {
            k = i;
            d2 = d3;
          }
        }
        i += 1;
        j = k;
        d1 = d2;
      }
      else
      {
        return null;
      }
    }
    return this.b.get(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.f
 * JD-Core Version:    0.7.0.1
 */