package com.tencent.mobileqq.qmcf;

public class QMCF
{
  public static native String getDefaultSign();
  
  public static native byte[] nDrink(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  public native void ArtDestroy(long paramLong);
  
  public native long ArtInit(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3);
  
  public native String ArtProcess(long paramLong, int paramInt1, int paramInt2);
  
  public native String ArtSwitchModel(long paramLong, String paramString1, String paramString2, String paramString3);
  
  public native void BigHeadDestroy(long paramLong);
  
  public native long BigHeadInit(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public native String BigHeadProcess(long paramLong, int paramInt1, int paramInt2);
  
  public native void PoseDestroy(long paramLong);
  
  public native long PoseInit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString1, String paramString2, String paramString3);
  
  public native String PoseProcess(long paramLong, int paramInt1, int paramInt2);
  
  public native void getSkeletonPose(long paramLong, float[] paramArrayOfFloat);
  
  public native int snpeAvaliableType();
  
  public native String snpeBigHeadDestroy(long paramLong);
  
  public native long snpeBigHeadInit(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3);
  
  public native String snpeBigHeadProcess(long paramLong, int paramInt1, int paramInt2);
  
  public native String snpePoseInit(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4);
  
  public native String snpePoseProcess(int paramInt1, int paramInt2);
  
  public native void snpeSkeletonPose(float[] paramArrayOfFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QMCF
 * JD-Core Version:    0.7.0.1
 */