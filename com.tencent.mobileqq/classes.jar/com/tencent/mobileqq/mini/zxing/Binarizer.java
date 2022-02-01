package com.tencent.mobileqq.mini.zxing;

import com.tencent.mobileqq.mini.zxing.common.BitArray;
import com.tencent.mobileqq.mini.zxing.common.BitMatrix;

public abstract class Binarizer
{
  private final LuminanceSource source;
  
  protected Binarizer(LuminanceSource paramLuminanceSource)
  {
    this.source = paramLuminanceSource;
  }
  
  public abstract Binarizer createBinarizer(LuminanceSource paramLuminanceSource);
  
  public abstract BitMatrix getBlackMatrix();
  
  public abstract BitArray getBlackRow(int paramInt, BitArray paramBitArray);
  
  public final int getHeight()
  {
    return this.source.getHeight();
  }
  
  public final LuminanceSource getLuminanceSource()
  {
    return this.source;
  }
  
  public final int getWidth()
  {
    return this.source.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.Binarizer
 * JD-Core Version:    0.7.0.1
 */