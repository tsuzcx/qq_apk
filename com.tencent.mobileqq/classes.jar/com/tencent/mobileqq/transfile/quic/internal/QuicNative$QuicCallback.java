package com.tencent.mobileqq.transfile.quic.internal;

public abstract interface QuicNative$QuicCallback
{
  public abstract void onClose(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onCompleted(int paramInt);
  
  public abstract void onConnect(int paramInt1, int paramInt2);
  
  public abstract void onDataReceive(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicNative.QuicCallback
 * JD-Core Version:    0.7.0.1
 */