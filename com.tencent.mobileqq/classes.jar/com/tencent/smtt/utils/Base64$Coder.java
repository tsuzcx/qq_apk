package com.tencent.smtt.utils;

abstract class Base64$Coder
{
  public int op;
  public byte[] output;
  
  public abstract int maxOutputSize(int paramInt);
  
  public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.Base64.Coder
 * JD-Core Version:    0.7.0.1
 */