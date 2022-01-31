package com.tencent.mobileqq.qmcf;

public class QMCF
{
  public static native String getDefaultSign();
  
  public static native byte[] nDrink(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  public native String ArtInit(String paramString1, String paramString2, String paramString3);
  
  public native String ArtProcess(int paramInt1, int paramInt2);
  
  public native String ArtSwitchModel(String paramString1, String paramString2, String paramString3);
  
  public native String PoseInit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public native float[] PoseKeyPoints();
  
  public native String PoseProcess(int paramInt1, int paramInt2);
  
  public native int snpeAvaliableType();
  
  public native void snpePoseInit(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public native void snpePoseInitEnc(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean);
  
  public native float[] snpePoseKeyPoints();
  
  public native void snpePoseProcess(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QMCF
 * JD-Core Version:    0.7.0.1
 */