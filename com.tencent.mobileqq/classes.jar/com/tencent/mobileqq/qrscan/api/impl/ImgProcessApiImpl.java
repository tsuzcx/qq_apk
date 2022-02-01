package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.imgproc.ImgProcessScan;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;

public class ImgProcessApiImpl
  implements IImgProcessApi
{
  public int ArrayConvert(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    return ImgProcessScan.a(paramInt, paramArrayOfByte, paramArrayOfInt);
  }
  
  public int CropGray2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    return ImgProcessScan.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3);
  }
  
  public int TransBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return ImgProcessScan.b(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int TransPixels(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return ImgProcessScan.a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int YUVrotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return ImgProcessScan.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  public int YUVrotateLessMemCost(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return ImgProcessScan.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int YuvToCropIntArray(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return ImgProcessScan.a(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public int gray_rotate_crop_sub(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return ImgProcessScan.a(paramArrayOfByte1, paramArrayOfInt, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public int gray_rotate_sub(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return ImgProcessScan.a(paramArrayOfByte1, paramArrayOfInt, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.ImgProcessApiImpl
 * JD-Core Version:    0.7.0.1
 */