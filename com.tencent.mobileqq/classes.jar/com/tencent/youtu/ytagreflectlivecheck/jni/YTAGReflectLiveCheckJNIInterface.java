package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.EncodeReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
  
  public static native String FRVersion();
  
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
  
  public static void compressTest(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      Object localObject = new File("/sdcard/reflect/");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = "/sdcard/reflect/" + paramInt + "/";
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new FileOutputStream(new File((String)localObject, "mytestInJava_" + System.currentTimeMillis() + ".jpg"));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, (OutputStream)localObject);
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public static byte[] encodeJpeg(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 99, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] encodeJpeg(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
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
    return "";
  }
  
  public static String sdkVersion()
  {
    return "";
  }
  
  public native int FRDoDetectionYuvs(boolean paramBoolean, int paramInt);
  
  public native FullPack FRGetAGin();
  
  public native Bitmap FRGetBestImg(int paramInt);
  
  public native int FRGetChangePoint();
  
  public native int FRGetConfigBegin();
  
  public native int FRGetConfigEnd();
  
  public native EncodeReflectData FRGetEncodeReflectData();
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface
 * JD-Core Version:    0.7.0.1
 */