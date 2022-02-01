package com.tencent.upload.network.base;

public abstract interface INetworkEngine
{
  public abstract boolean connectAsync(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3);
  
  public abstract boolean isRunning();
  
  public abstract boolean sendAsync(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean start();
  
  public abstract boolean stop();
  
  public abstract void wakeUp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.base.INetworkEngine
 * JD-Core Version:    0.7.0.1
 */