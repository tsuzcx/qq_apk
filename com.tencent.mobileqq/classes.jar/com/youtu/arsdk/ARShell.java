package com.youtu.arsdk;

import amxc;
import amxn;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
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
  private static volatile boolean loadARCoreSoSuccess;
  private static volatile boolean loadARFeatureSoSuccess;
  private static boolean loadSoSuccess;
  private static boolean soLoaded;
  
  public static boolean getARCoreSoHasLoadSuccess()
  {
    return loadARCoreSoSuccess;
  }
  
  public static String getLicense()
  {
    return amxn.b();
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
        if (!amxc.a())
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
            int i = amxc.a("libARFeature");
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
    //   5: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 57
    //   13: iconst_2
    //   14: new 74	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   21: ldc 109
    //   23: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   29: invokevirtual 86	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +8 -> 51
    //   46: ldc 2
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: invokestatic 114	anaf:a	()Lanah;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +14 -> 70
    //   59: iconst_0
    //   60: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   63: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   66: istore_1
    //   67: goto -21 -> 46
    //   70: aload_3
    //   71: invokestatic 117	anaf:a	(Lanah;)Z
    //   74: ifeq +162 -> 236
    //   77: aload_3
    //   78: invokeinterface 122 1 0
    //   83: astore 4
    //   85: aload 4
    //   87: ifnull +13 -> 100
    //   90: aload 4
    //   92: invokeinterface 127 1 0
    //   97: ifne +14 -> 111
    //   100: iconst_0
    //   101: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   104: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   107: istore_1
    //   108: goto -62 -> 46
    //   111: aload 4
    //   113: invokeinterface 131 1 0
    //   118: astore 4
    //   120: aload 4
    //   122: invokeinterface 136 1 0
    //   127: ifeq +98 -> 225
    //   130: aload 4
    //   132: invokeinterface 140 1 0
    //   137: checkcast 142	java/lang/String
    //   140: astore 5
    //   142: aload_3
    //   143: aload 5
    //   145: invokestatic 145	anaf:a	(Lanah;Ljava/lang/String;)I
    //   148: istore_0
    //   149: iload_0
    //   150: ifeq -30 -> 120
    //   153: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +38 -> 194
    //   159: ldc 57
    //   161: iconst_2
    //   162: new 74	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   169: ldc 147
    //   171: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_0
    //   175: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc 149
    //   180: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 5
    //   185: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iconst_0
    //   195: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   198: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   201: istore_1
    //   202: goto -156 -> 46
    //   205: astore_3
    //   206: iconst_0
    //   207: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   210: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +12 -> 225
    //   216: ldc 57
    //   218: iconst_2
    //   219: ldc 150
    //   221: aload_3
    //   222: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: iconst_1
    //   226: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   229: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   232: istore_1
    //   233: goto -187 -> 46
    //   236: iconst_0
    //   237: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   240: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
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
    //   54	89	3	localanah	anah
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
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: ldc 2
    //   7: monitorenter
    //   8: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +11 -> 22
    //   14: ldc 57
    //   16: iconst_2
    //   17: ldc 153
    //   19: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: ldc 155
    //   24: invokestatic 158	amxn:a	(Ljava/lang/String;)Z
    //   27: ifeq +11 -> 38
    //   30: ldc 160
    //   32: invokestatic 158	amxn:a	(Ljava/lang/String;)Z
    //   35: ifne +26 -> 61
    //   38: iload_3
    //   39: istore_2
    //   40: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +13 -> 56
    //   46: ldc 57
    //   48: iconst_2
    //   49: ldc 72
    //   51: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: iload_3
    //   55: istore_2
    //   56: ldc 2
    //   58: monitorexit
    //   59: iload_2
    //   60: ireturn
    //   61: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +30 -> 94
    //   67: ldc 57
    //   69: iconst_2
    //   70: new 74	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   77: ldc 162
    //   79: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: getstatic 83	com/youtu/arsdk/ARShell:soLoaded	Z
    //   85: invokevirtual 86	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: iconst_1
    //   95: putstatic 83	com/youtu/arsdk/ARShell:soLoaded	Z
    //   98: ldc 160
    //   100: invokestatic 163	amxn:a	(Ljava/lang/String;)I
    //   103: istore_0
    //   104: ldc 155
    //   106: invokestatic 163	amxn:a	(Ljava/lang/String;)I
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
    //   127: putstatic 165	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   130: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +37 -> 170
    //   136: ldc 57
    //   138: iconst_2
    //   139: new 74	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   146: ldc 167
    //   148: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: iload_0
    //   152: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc 169
    //   157: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload_1
    //   161: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +30 -> 203
    //   176: ldc 57
    //   178: iconst_2
    //   179: new 74	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   186: ldc 171
    //   188: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: getstatic 165	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   194: invokevirtual 86	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: getstatic 165	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   206: istore_2
    //   207: goto -151 -> 56
    //   210: astore 5
    //   212: iconst_0
    //   213: putstatic 165	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   216: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq -49 -> 170
    //   222: ldc 57
    //   224: iconst_2
    //   225: ldc 172
    //   227: aload 5
    //   229: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   210	18	5	localThrowable	Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.youtu.arsdk.ARShell
 * JD-Core Version:    0.7.0.1
 */