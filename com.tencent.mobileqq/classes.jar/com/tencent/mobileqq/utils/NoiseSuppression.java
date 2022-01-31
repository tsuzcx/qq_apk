package com.tencent.mobileqq.utils;

public class NoiseSuppression
{
  public static int a = 160;
  private int b = nativeCreate();
  
  private native int nativeCreate();
  
  private native int nativeInit(int paramInt1, int paramInt2);
  
  private native int nativeProcess(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private native int nativeRelease(int paramInt);
  
  private native int nativeSetPolicy(int paramInt1, int paramInt2);
  
  public int a()
  {
    if (this.b != 0) {
      return nativeRelease(this.b);
    }
    return -1;
  }
  
  protected void finalize()
  {
    super.finalize();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NoiseSuppression
 * JD-Core Version:    0.7.0.1
 */