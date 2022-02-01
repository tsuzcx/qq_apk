package com.youtu.arsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArFeatureSwepNativeSoLoader;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.io.File;

public class ARShell
{
  public static final int ERROR_LOST_TARGET = 3;
  public static final int ERROR_OK = 0;
  public static final int ERROR_TARGET_EMPTY = 4;
  public static final int ERROR_TARGET_RECOGNIZED = 1;
  public static final int ERROR_TARGET_TRACKED = 2;
  public static final int ERROR_TRAINING_DATA_LOAD_FAILED = -1001;
  private static volatile boolean loadARCoreSoSuccess = false;
  private static volatile boolean loadARFeatureSoSuccess = false;
  private static boolean loadSoSuccess = false;
  private static boolean soLoaded = false;
  
  public static boolean getARCoreSoHasLoadSuccess()
  {
    return loadARCoreSoSuccess;
  }
  
  public static String getCommonSoFilename()
  {
    return AEResUtil.a(AEResInfo.b) + "libYTCommon.so";
  }
  
  public static native int getMarkerCount();
  
  public static native int getMarkerInfo(long paramLong, ARPatternInfo paramARPatternInfo);
  
  public static native void getPatternSizeById(int paramInt, float[] paramArrayOfFloat);
  
  public static native void getProjectionMatrix(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public static native String getSDKVersion();
  
  public static boolean loadARFeatureNativeLibrary()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary");
        }
        boolean bool3 = loadARFeatureSoSuccess;
        if (bool3) {
          return bool1;
        }
        if (!ArFeatureSwepNativeSoLoader.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "native so is not exist!");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary soLoaded=" + soLoaded);
          }
          loadARFeatureSoSuccess = true;
          try
          {
            int i = ArFeatureSwepNativeSoLoader.a("libARFeature");
            if (i != 0) {
              break label219;
            }
            bool1 = bool2;
            loadARFeatureSoSuccess = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary ret1=" + i);
            }
          }
          catch (Throwable localThrowable)
          {
            loadARFeatureSoSuccess = false;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ARShell", 2, "loadARFeatureNativeLibrary", localThrowable);
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary loadSoSuccess=" + loadARFeatureSoSuccess);
          }
          bool1 = loadARFeatureSoSuccess;
          continue;
        }
        bool1 = false;
      }
      finally {}
      continue;
      label219:
      bool1 = false;
    }
  }
  
  /* Error */
  public static boolean loadArCoreNativeLibrary()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 83
    //   13: iconst_2
    //   14: new 42	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   21: ldc 120
    //   23: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   29: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: getstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +8 -> 51
    //   46: ldc 2
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: invokestatic 125	com/tencent/mobileqq/ar/arcore/ArCoreNativeSoManager:a	()Lcom/tencent/mobileqq/ar/arcore/IArCoreNativeSoLoader;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +14 -> 70
    //   59: iconst_0
    //   60: putstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   63: getstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   66: istore_1
    //   67: goto -21 -> 46
    //   70: aload_3
    //   71: invokestatic 128	com/tencent/mobileqq/ar/arcore/ArCoreNativeSoManager:a	(Lcom/tencent/mobileqq/ar/arcore/IArCoreNativeSoLoader;)Z
    //   74: ifeq +162 -> 236
    //   77: aload_3
    //   78: invokeinterface 133 1 0
    //   83: astore 4
    //   85: aload 4
    //   87: ifnull +13 -> 100
    //   90: aload 4
    //   92: invokeinterface 138 1 0
    //   97: ifne +14 -> 111
    //   100: iconst_0
    //   101: putstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   104: getstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   107: istore_1
    //   108: goto -62 -> 46
    //   111: aload 4
    //   113: invokeinterface 142 1 0
    //   118: astore 4
    //   120: aload 4
    //   122: invokeinterface 147 1 0
    //   127: ifeq +98 -> 225
    //   130: aload 4
    //   132: invokeinterface 151 1 0
    //   137: checkcast 153	java/lang/String
    //   140: astore 5
    //   142: aload_3
    //   143: aload 5
    //   145: invokestatic 156	com/tencent/mobileqq/ar/arcore/ArCoreNativeSoManager:a	(Lcom/tencent/mobileqq/ar/arcore/IArCoreNativeSoLoader;Ljava/lang/String;)I
    //   148: istore_0
    //   149: iload_0
    //   150: ifeq -30 -> 120
    //   153: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +38 -> 194
    //   159: ldc 83
    //   161: iconst_2
    //   162: new 42	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   169: ldc 158
    //   171: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_0
    //   175: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc 160
    //   180: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 5
    //   185: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iconst_0
    //   195: putstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   198: getstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   201: istore_1
    //   202: goto -156 -> 46
    //   205: astore_3
    //   206: iconst_0
    //   207: putstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   210: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +12 -> 225
    //   216: ldc 83
    //   218: iconst_2
    //   219: ldc 161
    //   221: aload_3
    //   222: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: iconst_1
    //   226: putstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   229: getstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   232: istore_1
    //   233: goto -187 -> 46
    //   236: iconst_0
    //   237: putstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   240: getstatic 30	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   243: istore_1
    //   244: goto -198 -> 46
    //   247: astore_3
    //   248: ldc 2
    //   250: monitorexit
    //   251: aload_3
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   148	27	0	i	int
    //   1	243	1	bool1	boolean
    //   41	2	2	bool2	boolean
    //   54	89	3	localIArCoreNativeSoLoader	com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader
    //   205	17	3	localThrowable	Throwable
    //   247	5	3	localObject1	Object
    //   83	48	4	localObject2	Object
    //   140	44	5	str	String
    // Exception table:
    //   from	to	target	type
    //   111	120	205	java/lang/Throwable
    //   120	149	205	java/lang/Throwable
    //   153	194	205	java/lang/Throwable
    //   194	202	205	java/lang/Throwable
    //   5	38	247	finally
    //   38	42	247	finally
    //   51	55	247	finally
    //   59	67	247	finally
    //   70	85	247	finally
    //   90	100	247	finally
    //   100	108	247	finally
    //   111	120	247	finally
    //   120	149	247	finally
    //   153	194	247	finally
    //   194	202	247	finally
    //   206	225	247	finally
    //   225	233	247	finally
    //   236	244	247	finally
  }
  
  /* Error */
  public static boolean loadNativeLibrary()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 166
    //   9: invokestatic 171	com/tencent/mobileqq/ar/ArSDK2NativeSoLoader:a	(Ljava/lang/String;)Z
    //   12: ifne +26 -> 38
    //   15: iload_2
    //   16: istore_1
    //   17: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +13 -> 33
    //   23: ldc 83
    //   25: iconst_2
    //   26: ldc 173
    //   28: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iload_2
    //   32: istore_1
    //   33: ldc 2
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +30 -> 71
    //   44: ldc 83
    //   46: iconst_2
    //   47: new 42	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   54: ldc 175
    //   56: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: getstatic 28	com/youtu/arsdk/ARShell:soLoaded	Z
    //   62: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_1
    //   72: putstatic 28	com/youtu/arsdk/ARShell:soLoaded	Z
    //   75: ldc 177
    //   77: invokestatic 183	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   80: ldc 166
    //   82: invokestatic 184	com/tencent/mobileqq/ar/ArSDK2NativeSoLoader:a	(Ljava/lang/String;)I
    //   85: istore_0
    //   86: iload_0
    //   87: ifne +5 -> 92
    //   90: iconst_1
    //   91: istore_1
    //   92: iload_1
    //   93: putstatic 26	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   96: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +28 -> 127
    //   102: ldc 83
    //   104: iconst_2
    //   105: new 42	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   112: ldc 186
    //   114: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload_0
    //   118: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +30 -> 160
    //   133: ldc 83
    //   135: iconst_2
    //   136: new 42	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   143: ldc 188
    //   145: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 26	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   151: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   154: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: getstatic 26	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   163: istore_1
    //   164: goto -131 -> 33
    //   167: astore_3
    //   168: iconst_0
    //   169: putstatic 26	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   172: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq -48 -> 127
    //   178: ldc 83
    //   180: iconst_2
    //   181: ldc 189
    //   183: aload_3
    //   184: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: goto -60 -> 127
    //   190: astore_3
    //   191: ldc 2
    //   193: monitorexit
    //   194: aload_3
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   85	33	0	i	int
    //   1	163	1	bool1	boolean
    //   3	29	2	bool2	boolean
    //   167	17	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   190	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   75	86	167	java/lang/UnsatisfiedLinkError
    //   92	127	167	java/lang/UnsatisfiedLinkError
    //   7	15	190	finally
    //   17	31	190	finally
    //   38	71	190	finally
    //   71	75	190	finally
    //   75	86	190	finally
    //   92	127	190	finally
    //   127	160	190	finally
    //   160	164	190	finally
    //   168	187	190	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.youtu.arsdk.ARShell
 * JD-Core Version:    0.7.0.1
 */