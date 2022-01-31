package com.tencent.youtu.ytfacetrack;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;

public class YTFaceTrack
{
  public static String Version = "2.3.3.3";
  private static YTFaceTrack instance = null;
  public long handleId = 0L;
  private long nativePtr;
  
  static
  {
    nativeInit();
  }
  
  public YTFaceTrack()
  {
    NativeConstructor();
  }
  
  public static int GlobalInit(String paramString)
  {
    int i = GlobalInitInner(paramString);
    if (i == 0) {
      instance = new YTFaceTrack();
    }
    return i;
  }
  
  private static native int GlobalInitInner(String paramString);
  
  private static native int GlobalInitSuccessCount();
  
  public static boolean GlobalRelease()
  {
    if (instance != null)
    {
      instance.destroy();
      instance = null;
    }
    return GlobalReleaseInner();
  }
  
  private static native boolean GlobalReleaseInner();
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static YTFaceTrack getInstance()
  {
    try
    {
      if (instance == null)
      {
        Log.w("TAG", "Please call YTFaceTrack.GlobalInit() before YTFaceTrack.getInstance()");
        instance = new YTFaceTrack();
      }
      YTFaceTrack localYTFaceTrack = instance;
      return localYTFaceTrack;
    }
    finally {}
  }
  
  private static native boolean nativeInit();
  
  public native YTFaceTrack.FaceStatus[] DoDetectionProcess(YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.FaceStatus[] DoDetectionProcessBitmap(Bitmap paramBitmap, int paramInt, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.FaceStatus[] DoDetectionProcessRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.FaceStatus[] DoDetectionProcessRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.FaceStatus[] DoDetectionProcessYUVWithBlur(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, float[] paramArrayOfFloat, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceAlignParam GetFaceAlignParam();
  
  public native YTFaceDetectParam GetFaceDetectParam();
  
  public native Rect[] GetFaceRect(YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrackParam GetFaceTrackParam();
  
  public native YTFaceTrack.YTImage GetYTImageBitmap(Bitmap paramBitmap, int paramInt);
  
  public native int GetYTImageBitmapReuseData(Bitmap paramBitmap, int paramInt, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.YTImage GetYTImageRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native YTFaceTrack.YTImage GetYTImageRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageRGBAReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native int GetYTImageRGBReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.YTImage GetYTImageYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageYUVReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native byte[] RotateYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native void SaveYTImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean SetFaceAlignParam(YTFaceAlignParam paramYTFaceAlignParam);
  
  public native boolean SetFaceDetectParam(YTFaceDetectParam paramYTFaceDetectParam);
  
  public native boolean SetFaceTrackParam(YTFaceTrackParam paramYTFaceTrackParam);
  
  public void destroy()
  {
    NativeDestructor();
  }
  
  protected void finalize()
  {
    NativeDestructor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrack.YTFaceTrack
 * JD-Core Version:    0.7.0.1
 */