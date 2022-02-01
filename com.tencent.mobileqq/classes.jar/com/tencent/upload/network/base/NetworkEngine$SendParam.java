package com.tencent.upload.network.base;

final class NetworkEngine$SendParam
{
  public final byte[] buf;
  public final int recvTimeout;
  public final int sendSequence;
  public final int sendTimeout;
  
  public NetworkEngine$SendParam(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.buf = paramArrayOfByte;
    this.sendSequence = paramInt1;
    this.sendTimeout = paramInt2;
    this.recvTimeout = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.base.NetworkEngine.SendParam
 * JD-Core Version:    0.7.0.1
 */