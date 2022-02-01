package com.tencent.mobileqq.imgproc;

import com.tencent.qbar.QBarImageUtil;

public class ImgProcessScan
{
  public static int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    return QBarImageUtil.ArrayConvert(paramInt, paramArrayOfByte, paramArrayOfInt);
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return QBarImageUtil.YUVrotateLessMemCost(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return QBarImageUtil.YUVrotate(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    return QBarImageUtil.CropGray2(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return QBarImageUtil.YuvToCropIntArray(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return QBarImageUtil.gray_rotate_sub(paramArrayOfByte1, paramArrayOfInt, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return QBarImageUtil.gray_rotate_crop_sub(paramArrayOfByte1, paramArrayOfInt, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return QBarImageUtil.TransPixels(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int b(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return QBarImageUtil.TransBytes(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imgproc.ImgProcessScan
 * JD-Core Version:    0.7.0.1
 */