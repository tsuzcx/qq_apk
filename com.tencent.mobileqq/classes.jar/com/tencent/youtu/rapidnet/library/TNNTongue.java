package com.tencent.youtu.rapidnet.library;

public class TNNTongue
{
  private long nativePtr;
  
  public native int deinit();
  
  public native float forward(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int init(String paramString1, String paramString2, String paramString3);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.TNNTongue
 * JD-Core Version:    0.7.0.1
 */