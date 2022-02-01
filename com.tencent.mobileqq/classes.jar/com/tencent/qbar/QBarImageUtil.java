package com.tencent.qbar;

public class QBarImageUtil
{
  public static int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfInt != null)) {
      return QbarNative.nativeArrayConvert(paramInt, paramArrayOfByte.length, paramArrayOfByte, paramArrayOfInt);
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return QbarNative.nativeYUVrotateLess(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      return QbarNative.nativeYUVrotate(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      return QbarNative.nativeCropGray2(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3);
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfInt != null)) {
      return QbarNative.nativeYuvToCropIntArray(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      return QbarNative.nativeGrayRotateCropSub(paramArrayOfByte2, paramInt1, paramInt2, 0, 0, paramInt1, paramInt2, paramArrayOfByte1, paramArrayOfInt, paramInt3, paramInt4);
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      return QbarNative.nativeGrayRotateCropSub(paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfByte1, paramArrayOfInt, paramInt7, paramInt8);
    }
    return -1;
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfByte != null)) {
      return QbarNative.nativeTransPixels(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public static int b(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfByte != null)) {
      return QbarNative.nativeTransBytes(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qbar.QBarImageUtil
 * JD-Core Version:    0.7.0.1
 */