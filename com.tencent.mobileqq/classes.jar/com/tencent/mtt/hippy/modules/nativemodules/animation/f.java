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
    int i = 0;
    if (this.a == null) {
      return null;
    }
    if (this.b == null) {
      return null;
    }
    int k = this.a.size();
    if (k != this.b.size()) {
      return null;
    }
    if (k == 0) {
      return null;
    }
    double d3 = paramNumber.doubleValue();
    double d1 = -1.0D;
    int j = 0;
    if (i < k)
    {
      paramNumber = this.a.get(i);
      if ((paramNumber == null) || (!(paramNumber instanceof Number))) {
        return null;
      }
      double d2 = ((Number)paramNumber).doubleValue();
      if (d2 > d3) {
        break label162;
      }
      d2 = Math.abs(d3 - d2);
      if ((d2 >= d1) && (d1 != -1.0D)) {
        break label162;
      }
      j = i;
      d1 = d2;
    }
    label162:
    for (;;)
    {
      i += 1;
      break;
      return this.b.get(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.f
 * JD-Core Version:    0.7.0.1
 */