package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YTAGReflectLiveCheckJNIInterface
{
  public static int TIME_REGULATION_LOOSE = 1;
  public static int TIME_REGULATION_STRICT = 0;
  private static YTAGReflectLiveCheckJNIInterface instance = null;
  private static Lock instanceLock = new ReentrantLock();
  private static YTAGReflectLiveCheckJNIInterface.IYtLoggerListener loggerListener;
  private long FRnativePtr;
  public Context context = null;
  
  private YTAGReflectLiveCheckJNIInterface()
  {
    FRNativeConstructor();
  }
  
  public static native String FRGenConfigData(int paramInt, String paramString);
  
  public static native String FRVersion();
  
  /* Error */
  public static void clearInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 49 1 0
    //   11: getstatic 25	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   14: ifnull +13 -> 27
    //   17: getstatic 25	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   20: invokevirtual 52	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRNativeDestructor	()V
    //   23: aconst_null
    //   24: putstatic 25	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   27: getstatic 32	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   30: invokeinterface 55 1 0
    //   35: ldc 2
    //   37: monitorexit
    //   38: return
    //   39: astore_0
    //   40: getstatic 32	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   43: invokeinterface 55 1 0
    //   48: aload_0
    //   49: athrow
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	10	0	localObject1	Object
    //   50	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	27	39	finally
    //   27	35	50	finally
    //   40	50	50	finally
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
  
  public static native void configNativeLog(boolean paramBoolean);
  
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
  
  /* Error */
  public static YTAGReflectLiveCheckJNIInterface getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 49 1 0
    //   11: getstatic 25	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   14: ifnonnull +13 -> 27
    //   17: new 2	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface
    //   20: dup
    //   21: invokespecial 145	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:<init>	()V
    //   24: putstatic 25	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   27: getstatic 32	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   30: invokeinterface 55 1 0
    //   35: getstatic 25	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: getstatic 32	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 55 1 0
    //   53: aload_0
    //   54: athrow
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	5	0	localYTAGReflectLiveCheckJNIInterface	YTAGReflectLiveCheckJNIInterface
    //   44	10	0	localObject1	Object
    //   55	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	27	44	finally
    //   27	39	55	finally
    //   45	55	55	finally
  }
  
  public static String modelVersion()
  {
    return "";
  }
  
  public static void nativeLog(int paramInt, String paramString)
  {
    if (loggerListener != null) {
      loggerListener.log("[YTAGReflectLiveCheckJNIInterface.nativeLog]", paramString);
    }
  }
  
  public static void nativeLog(String paramString1, String paramString2)
  {
    if (loggerListener != null) {
      loggerListener.log(paramString1, paramString2);
    }
  }
  
  public static String sdkVersion()
  {
    return "";
  }
  
  public static void setLoggerListener(YTAGReflectLiveCheckJNIInterface.IYtLoggerListener paramIYtLoggerListener)
  {
    loggerListener = paramIYtLoggerListener;
  }
  
  public static native int updateParam(String paramString1, String paramString2);
  
  public native int FRDoDetectionYuvs(boolean paramBoolean, int paramInt);
  
  public native FullPack FRGetAGin();
  
  public native int FRGetChangePoint();
  
  public native int FRGetConfigBegin();
  
  public native int FRGetConfigEnd();
  
  public native int FRGetISOCaptureTimeVecSize();
  
  public native double FRGetISObackup();
  
  public native int FRGetISOchangeFrame();
  
  public native double FRGetISOmin();
  
  public native RawYuvData[] FRGetRawYuvDatas();
  
  public native int FRGetTriggerTime();
  
  public native int FRInit(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong, float paramFloat);
  
  public native void FRNativeConstructor();
  
  public native void FRNativeDestructor();
  
  public native void FRPushCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOImgYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRPushYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3, float[] paramArrayOfFloat);
  
  public native int FRRelease();
  
  public native void FRSetBegin(Timeval paramTimeval);
  
  public native void FRSetChangePointTime(Timeval paramTimeval);
  
  public native void FRSetDoingDelayCalc(boolean paramBoolean);
  
  public native void FRSetEnd(Timeval paramTimeval);
  
  public native void FRSetISObackup(double paramDouble);
  
  public native void FRSetISOchangeFrame(int paramInt);
  
  public native void FRSetISOchangeTime(Timeval paramTimeval);
  
  public native void FRSetSafetyLevel(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface
 * JD-Core Version:    0.7.0.1
 */