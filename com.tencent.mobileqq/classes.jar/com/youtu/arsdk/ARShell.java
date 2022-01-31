package com.youtu.arsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArSDK2NativeSoLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ARShell
{
  public static final int ERROR_LOST_TARGET = 3;
  public static final int ERROR_OK = 0;
  public static final int ERROR_TARGET_EMPTY = 4;
  public static final int ERROR_TARGET_RECOGNIZED = 1;
  public static final int ERROR_TARGET_TRACKED = 2;
  public static final int ERROR_TRAINING_DATA_LOAD_FAILED = -1001;
  private static boolean loadSoSuccess;
  private static boolean soLoaded;
  
  public static String getLicense()
  {
    return ArSDK2NativeSoLoader.a();
  }
  
  public static native int getMarkerCount();
  
  public static native int getMarkerInfo(long paramLong, ARPatternInfo paramARPatternInfo);
  
  public static native void getPatternSizeById(int paramInt, float[] paramArrayOfFloat);
  
  public static native void getProjectionMatrix(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public static native String getSDKVersion();
  
  /* Error */
  public static boolean loadNativeLibrary()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: ldc 2
    //   7: monitorenter
    //   8: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +11 -> 22
    //   14: ldc 52
    //   16: iconst_2
    //   17: ldc 54
    //   19: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: ldc 60
    //   24: invokestatic 63	com/tencent/mobileqq/ar/ArSDK2NativeSoLoader:a	(Ljava/lang/String;)Z
    //   27: ifeq +11 -> 38
    //   30: ldc 65
    //   32: invokestatic 63	com/tencent/mobileqq/ar/ArSDK2NativeSoLoader:a	(Ljava/lang/String;)Z
    //   35: ifne +26 -> 61
    //   38: iload_3
    //   39: istore_2
    //   40: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +13 -> 56
    //   46: ldc 52
    //   48: iconst_2
    //   49: ldc 67
    //   51: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: iload_3
    //   55: istore_2
    //   56: ldc 2
    //   58: monitorexit
    //   59: iload_2
    //   60: ireturn
    //   61: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +30 -> 94
    //   67: ldc 52
    //   69: iconst_2
    //   70: new 69	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   77: ldc 72
    //   79: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: getstatic 78	com/youtu/arsdk/ARShell:soLoaded	Z
    //   85: invokevirtual 81	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: iconst_1
    //   95: putstatic 78	com/youtu/arsdk/ARShell:soLoaded	Z
    //   98: ldc 65
    //   100: invokestatic 87	com/tencent/mobileqq/ar/ArSDK2NativeSoLoader:a	(Ljava/lang/String;)I
    //   103: istore_0
    //   104: ldc 60
    //   106: invokestatic 87	com/tencent/mobileqq/ar/ArSDK2NativeSoLoader:a	(Ljava/lang/String;)I
    //   109: istore_1
    //   110: iload 4
    //   112: istore_2
    //   113: iload_0
    //   114: ifne +12 -> 126
    //   117: iload 4
    //   119: istore_2
    //   120: iload_1
    //   121: ifne +5 -> 126
    //   124: iconst_1
    //   125: istore_2
    //   126: iload_2
    //   127: putstatic 89	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   130: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +37 -> 170
    //   136: ldc 52
    //   138: iconst_2
    //   139: new 69	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   146: ldc 91
    //   148: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: iload_0
    //   152: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc 96
    //   157: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload_1
    //   161: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +30 -> 203
    //   176: ldc 52
    //   178: iconst_2
    //   179: new 69	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   186: ldc 98
    //   188: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: getstatic 89	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   194: invokevirtual 81	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: getstatic 89	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   206: istore_2
    //   207: goto -151 -> 56
    //   210: astore 5
    //   212: iconst_0
    //   213: putstatic 89	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   216: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq -49 -> 170
    //   222: ldc 52
    //   224: iconst_2
    //   225: ldc 99
    //   227: aload 5
    //   229: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   232: goto -62 -> 170
    //   235: astore 5
    //   237: ldc 2
    //   239: monitorexit
    //   240: aload 5
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   103	49	0	i	int
    //   109	52	1	j	int
    //   39	168	2	bool1	boolean
    //   4	51	3	bool2	boolean
    //   1	117	4	bool3	boolean
    //   210	18	5	localThrowable	java.lang.Throwable
    //   235	6	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   98	110	210	java/lang/Throwable
    //   126	170	210	java/lang/Throwable
    //   8	22	235	finally
    //   22	38	235	finally
    //   40	54	235	finally
    //   61	94	235	finally
    //   94	98	235	finally
    //   98	110	235	finally
    //   126	170	235	finally
    //   170	203	235	finally
    //   203	207	235	finally
    //   212	232	235	finally
  }
  
  private static boolean loadSo()
  {
    soLoaded = true;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Object localObject2;
    Object localObject1;
    String str;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject2 = localBaseApplicationImpl.getApplicationInfo().nativeLibraryDir + "/";
      localObject1 = (String)localObject2 + "libAlphaAR.so";
      str = localBaseApplicationImpl.getFilesDir() + "libAlphaAR.so";
      if (!new File((String)localObject1).exists()) {
        break label286;
      }
    }
    for (;;)
    {
      label102:
      localObject2 = (String)localObject2 + "libYTCommon.so";
      str = localBaseApplicationImpl.getFilesDir() + "libYTCommon.so";
      if (new File((String)localObject2).exists()) {}
      for (;;)
      {
        if ((!((String)localObject1).equals("")) && (!((String)localObject2).equals("")))
        {
          try
          {
            System.load((String)localObject2);
            System.load((String)localObject1);
            QLog.i("ARShell", 1, "load " + (String)localObject1 + " successfully!");
            QLog.i("ARShell", 1, "load " + (String)localObject2 + " successfully!");
            loadSoSuccess = true;
            boolean bool = loadSoSuccess;
            return bool;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            label286:
            QLog.i("ARShell", 1, "load " + (String)localObject1 + " failed!" + localUnsatisfiedLinkError.getMessage());
            QLog.i("ARShell", 1, "load " + (String)localObject2 + " failed!" + localUnsatisfiedLinkError.getMessage());
          }
          localObject2 = localBaseApplicationImpl.getApplicationInfo().dataDir + "/lib/";
          break;
          if (!new File(str).exists()) {
            break label473;
          }
          localObject1 = str;
          break label102;
          if (!new File(str).exists()) {
            break label467;
          }
          localObject2 = str;
          continue;
        }
        QLog.i("ARShell", 1, "load " + (String)localObject1 + " failed!");
        QLog.i("ARShell", 1, "load " + (String)localObject2 + " failed!");
        loadSoSuccess = false;
        return loadSoSuccess;
        label467:
        localObject2 = "";
      }
      label473:
      localObject1 = "";
    }
  }
  
  public static native int nativeAddMarker(String paramString1, String paramString2);
  
  public static native int nativeAddMarkers(String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  public static native boolean nativeCreate(Context paramContext);
  
  public static native boolean nativeDestroy();
  
  public static native long[] nativeGetMarkerIndice();
  
  public static native int nativeGetScore(byte[] paramArrayOfByte);
  
  public static native int nativeInitialize(AROption paramAROption);
  
  public static native int nativeRecognize(byte[] paramArrayOfByte, ARTargetInfo[] paramArrayOfARTargetInfo);
  
  public static native boolean nativeStart();
  
  public static native boolean nativeStop();
  
  public static native int nativeTrack(byte[] paramArrayOfByte, ARTargetInfo[] paramArrayOfARTargetInfo);
  
  public static native int removeAllMarkers();
  
  public static native int removeMarker(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.youtu.arsdk.ARShell
 * JD-Core Version:    0.7.0.1
 */