package com.tencent.youtu.ytposedetect.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import java.io.ByteArrayOutputStream;

public class YTPoseDetectJNIInterface
{
  public static native boolean canReflect();
  
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
  
  public static native int poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static native void releaseAll();
  
  public static native void resetDetect();
  
  public static native void setSafetyLevel(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface
 * JD-Core Version:    0.7.0.1
 */