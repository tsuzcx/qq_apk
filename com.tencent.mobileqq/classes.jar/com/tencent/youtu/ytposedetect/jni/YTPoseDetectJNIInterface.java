package com.tencent.youtu.ytposedetect.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import java.io.ByteArrayOutputStream;

public class YTPoseDetectJNIInterface
{
  private static YTPoseDetectJNIInterface.IYtLoggerListener loggerListener;
  
  public static native boolean canReflect();
  
  public static native void configNativeLog(boolean paramBoolean);
  
  public static byte[] encodeJpeg(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 99, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static native YTActRefData getActionReflectData(int paramInt);
  
  public static native byte[] getBestImage(int paramInt);
  
  public static native byte[] getEyeImage(int paramInt);
  
  public static native byte[][] getFrameList();
  
  public static native byte[] getMouthImage(int paramInt);
  
  public static native String getVersion();
  
  public static native int initModel(String paramString);
  
  public static native boolean isRecordingDone();
  
  public static void nativeLog(int paramInt, String paramString)
  {
    YTPoseDetectJNIInterface.IYtLoggerListener localIYtLoggerListener = loggerListener;
    if (localIYtLoggerListener != null) {
      localIYtLoggerListener.log("[YTPoseDetectJNIInterface.nativeLog]", paramString);
    }
  }
  
  public static void nativeLog(String paramString1, String paramString2)
  {
    YTPoseDetectJNIInterface.IYtLoggerListener localIYtLoggerListener = loggerListener;
    if (localIYtLoggerListener != null) {
      localIYtLoggerListener.log(paramString1, paramString2);
    }
  }
  
  public static native int poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt5);
  
  public static native void releaseAll();
  
  public static native void resetDetect();
  
  public static native byte[] rotateYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static void setLoggerListener(YTPoseDetectJNIInterface.IYtLoggerListener paramIYtLoggerListener)
  {
    loggerListener = paramIYtLoggerListener;
  }
  
  public static native void setSafetyLevel(int paramInt);
  
  public static native int updateParam(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface
 * JD-Core Version:    0.7.0.1
 */