package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.ByteArrayOutputStream;

public class YTAGReflectLiveCheckJNIInterface
{
  public static int TIME_REGULATION_LOOSE = 1;
  public static int TIME_REGULATION_STRICT = 0;
  private static YTAGReflectLiveCheckJNIInterface instance = null;
  private long FRnativePtr;
  public Context context = null;
  private long nativePtr;
  
  private YTAGReflectLiveCheckJNIInterface()
  {
    FRNativeConstructor();
  }
  
  public static void NativeLog(int paramInt, String paramString)
  {
    if (!YTLogger.isEnableNativeLog()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      YTLogger.d("NativeLog-" + paramInt, "[YTAGReflectLiveCheckJNIInterface.NativeLog] " + paramString);
      return;
    case 2: 
      YTLogger.v("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] " + paramString);
      return;
    case 3: 
      YTLogger.d("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] " + paramString);
      return;
    case 4: 
      YTLogger.i("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] " + paramString);
      return;
    case 5: 
      YTLogger.w("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] " + paramString);
      return;
    }
    YTLogger.e("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] " + paramString);
  }
  
  public static byte[] encodeJpeg(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 99, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static YTAGReflectLiveCheckJNIInterface getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new YTAGReflectLiveCheckJNIInterface();
      }
      YTAGReflectLiveCheckJNIInterface localYTAGReflectLiveCheckJNIInterface = instance;
      return localYTAGReflectLiveCheckJNIInterface;
    }
    finally {}
  }
  
  public static String modelVersion()
  {
    return "0.0.1_20180605";
  }
  
  public static String sdkVersion()
  {
    return "0.0.1_20180605";
  }
  
  public native int FRDoDetectionYuvs(boolean paramBoolean, int paramInt);
  
  public native FullPack FRGetAGin();
  
  public native Bitmap FRGetBestImg(int paramInt);
  
  public native int FRGetChangePoint();
  
  public native int FRGetConfigBegin();
  
  public native int FRGetConfigEnd();
  
  public native double FRGetISObackup();
  
  public native String FRInit(boolean paramBoolean, String paramString, int paramInt);
  
  public native void FRNativeConstructor();
  
  public native void FRNativeDestructor();
  
  public native void FRPushCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOImgYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRPushYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRSetBegin(Timeval paramTimeval);
  
  public native void FRSetChangePointTime(Timeval paramTimeval);
  
  public native void FRSetDoingDelayCalc(boolean paramBoolean);
  
  public native void FRSetEnd(Timeval paramTimeval);
  
  public native void FRSetISObackup(double paramDouble);
  
  public native void FRSetISOchangeTime(Timeval paramTimeval);
  
  public native void FRSetSafetyLevel(int paramInt);
  
  public void destroy()
  {
    FRNativeDestructor();
  }
  
  protected void finalize()
  {
    FRNativeDestructor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface
 * JD-Core Version:    0.7.0.1
 */