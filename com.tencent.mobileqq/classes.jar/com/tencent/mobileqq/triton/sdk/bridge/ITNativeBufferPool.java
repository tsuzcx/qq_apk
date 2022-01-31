package com.tencent.mobileqq.triton.sdk.bridge;

public abstract interface ITNativeBufferPool
{
  public abstract byte[] getNativeBuffer(int paramInt);
  
  public abstract int newNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool
 * JD-Core Version:    0.7.0.1
 */