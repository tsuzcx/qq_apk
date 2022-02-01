package com.tencent.tar.jni;

public class TARMarkerNative
{
  private static native int odDetect(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt);
  
  private static native int odInit(String paramString);
  
  private static native int odRelease();
  
  private static native int odResetCfd();
  
  private static native int tarAddCloudMarker(int paramInt1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt2, float[] paramArrayOfFloat, int paramInt3, String paramString4, int[] paramArrayOfInt, boolean paramBoolean);
  
  private static native int tarAddMarker(int paramInt, String paramString1, String paramString2, String paramString3, int[] paramArrayOfInt);
  
  private static native int tarAddMarkerBinary(int paramInt1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt2, int[] paramArrayOfInt);
  
  private static native int tarAddMarkerBinaryRegen(int paramInt1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean);
  
  private static native int tarAddMarkerRegen(int paramInt, String paramString1, String paramString2, String paramString3, int[] paramArrayOfInt, boolean paramBoolean);
  
  private static native int tarDelMarker(int paramInt, int[] paramArrayOfInt);
  
  private static native int tarDetectFace(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, float[] paramArrayOfFloat, int[] paramArrayOfInt);
  
  private static native void tarFaceRelease();
  
  private static native void tarFaceSetMin(float paramFloat);
  
  private static native void tarFaceSetThreadNum(int paramInt);
  
  private static native void tarFaceSetup(String paramString);
  
  private static native int tarGenerateFeature(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt);
  
  private static native int tarGetAction(int paramInt1, int[] paramArrayOfInt, int paramInt2, float[] paramArrayOfFloat1, boolean paramBoolean, float[] paramArrayOfFloat2);
  
  private static native int tarGetFacialPoint(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt);
  
  private static native int tarGetMarkerTransform(int paramInt, float[] paramArrayOfFloat);
  
  private static native int tarGetMarkerTransformAndScreenV(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native int tarGetProjectionMatrix(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat);
  
  private static native int tarGetProjectionMatrixEx(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat);
  
  private static native int tarGetSDKRunStatusInfo(int paramInt, int[] paramArrayOfInt);
  
  private static native String tarGetVersion();
  
  private static native int tarInitialize(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  private static native int tarObjectFeatureDetect(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private static native int tarObjectMotionDetect(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt);
  
  private static native int tarOnFrame(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean);
  
  private static native boolean tarProfilerSupported();
  
  private static native int tarRelease();
  
  private static native int tarReset(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt);
  
  private static native int tarScanFilter(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, boolean paramBoolean, String paramString, byte[] paramArrayOfByte2);
  
  private static native void tarSetCfgKeyValue(String paramString1, String paramString2);
  
  private static native void tarSetConfig(int paramInt1, int paramInt2);
  
  private static native void tarSetFrameMode(int paramInt);
  
  private static native void tarSetLogCallback();
  
  private static native int tarSetMarkerStatus(int paramInt, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private static native int tarSmartMotionDetect(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private static native void tarStartProfiler();
  
  private static native void tarStopProfiler();
  
  private static native int tarTrackFace(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, float[] paramArrayOfFloat, int[] paramArrayOfInt);
  
  public int a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return tarSmartMotionDetect(paramInt1, paramInt2, paramArrayOfByte, paramBoolean, paramArrayOfInt1, paramArrayOfInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tar.jni.TARMarkerNative
 * JD-Core Version:    0.7.0.1
 */