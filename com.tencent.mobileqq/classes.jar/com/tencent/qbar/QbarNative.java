package com.tencent.qbar;

import android.graphics.Bitmap;

public class QbarNative
{
  public static native int Encode(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  public static native int EncodeBitmap(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5);
  
  public static native String GetVersion();
  
  public native int DetectCode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int GetOneResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int[] paramArrayOfInt, int paramInt);
  
  public native int GetPossibleInfo(QbarNative.QbarPossibleInfo paramQbarPossibleInfo, int paramInt);
  
  public native int Init(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2);
  
  public native int Release(int paramInt);
  
  public native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int SetReaders(int[] paramArrayOfInt, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */