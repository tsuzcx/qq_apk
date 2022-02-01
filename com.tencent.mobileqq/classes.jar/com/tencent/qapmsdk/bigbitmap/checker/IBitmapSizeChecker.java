package com.tencent.qapmsdk.bigbitmap.checker;

public abstract interface IBitmapSizeChecker
{
  public abstract Boolean check(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract float getThreshold();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.checker.IBitmapSizeChecker
 * JD-Core Version:    0.7.0.1
 */