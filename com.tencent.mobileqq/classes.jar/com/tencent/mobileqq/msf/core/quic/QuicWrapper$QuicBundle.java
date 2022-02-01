package com.tencent.mobileqq.msf.core.quic;

public class QuicWrapper$QuicBundle
{
  public byte[] data;
  public int data_len;
  public int retcode;
  
  public QuicWrapper$QuicBundle(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this.retcode = paramInt1;
    this.data = paramArrayOfByte;
    this.data_len = paramInt2;
  }
  
  public void putData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quic.QuicWrapper.QuicBundle
 * JD-Core Version:    0.7.0.1
 */