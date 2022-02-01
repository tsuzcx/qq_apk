package com.tencent.mobileqq.mini.audiorecorder;

public class LameMp3Native
{
  public static native void close();
  
  public static native int encode(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte);
  
  public static native int flush(byte[] paramArrayOfByte);
  
  public static void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    init(paramInt1, paramInt2, paramInt3, paramInt4, 7);
  }
  
  public static native void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static void jniClose() {}
  
  public static int jniEncode(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfShort1, paramArrayOfShort2, paramInt, paramArrayOfByte);
  }
  
  public static int jniFlush(byte[] paramArrayOfByte)
  {
    return flush(paramArrayOfByte);
  }
  
  public static void jniInit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    init(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3Native
 * JD-Core Version:    0.7.0.1
 */