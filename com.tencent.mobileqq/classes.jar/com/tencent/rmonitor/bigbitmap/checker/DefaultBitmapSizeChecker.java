package com.tencent.rmonitor.bigbitmap.checker;

import com.tencent.rmonitor.bigbitmap.BigBitmapConfigHelper;

public class DefaultBitmapSizeChecker
  implements IBitmapSizeChecker
{
  public Boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = BigBitmapConfigHelper.a();
    boolean bool;
    if ((paramInt1 <= paramInt3 * f) && (paramInt2 <= paramInt4 * f)) {
      bool = false;
    } else {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.checker.DefaultBitmapSizeChecker
 * JD-Core Version:    0.7.0.1
 */