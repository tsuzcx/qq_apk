package com.tencent.qqmini.v8rt.engine;

public abstract interface INativeBuffer
{
  public abstract byte[] getNativeBuffer(int paramInt);
  
  public abstract int newNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.INativeBuffer
 * JD-Core Version:    0.7.0.1
 */