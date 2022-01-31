package com.tencent.mobileqq.mini.zxing;

import java.util.Map;

public abstract interface Reader
{
  public abstract Result decode(BinaryBitmap paramBinaryBitmap);
  
  public abstract Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.Reader
 * JD-Core Version:    0.7.0.1
 */