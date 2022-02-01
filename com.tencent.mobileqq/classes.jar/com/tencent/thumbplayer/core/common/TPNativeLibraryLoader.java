package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;

public class TPNativeLibraryLoader
{
  private static final String DEFAULT_LIB_PLAYER_CORE_VERSION = "2.5.0.1085.full";
  private static final String MAIN_PLAYER_CORE_VERSION = "2.5.0";
  private static boolean mIsLibLoaded = false;
  private static Object mIsLibLoadedLock = new Object();
  private static ITPNativeLibraryExternalLoader mLibLoader = null;
  private static final boolean mLibNameHasArchSuffix = false;
  private static final String mLibPlayerCorePrefix = "TPCore-master";
  
  private static native String _getPlayerCoreVersion();
  
  public static String getLibVersion()
  {
    return getPlayerCoreVersion();
  }
  
  public static String getPlayerCoreVersion()
  {
    try
    {
      String str = _getPlayerCoreVersion();
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(2, "getPlayerCoreVersion: *.so is not loaded yet, return the hard-coded version number:2.5.0.1085.full");
    }
    return "2.5.0.1085.full";
  }
  
  /* Error */
  public static boolean isLibLoaded()
  {
    // Byte code:
    //   0: aconst_null
    //   1: invokestatic 58	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:loadLibIfNeeded	(Landroid/content/Context;)V
    //   4: getstatic 29	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:mIsLibLoadedLock	Ljava/lang/Object;
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: getstatic 31	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:mIsLibLoaded	Z
    //   13: istore_0
    //   14: aload_1
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: astore_1
    //   19: iconst_4
    //   20: new 60	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   27: ldc 63
    //   29: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 70	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   36: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   45: goto -41 -> 4
    //   48: astore_2
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	4	0	bool	boolean
    //   18	32	1	localThrowable	Throwable
    //   48	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	18	java/lang/Throwable
    //   10	16	48	finally
    //   49	51	48	finally
  }
  
  private static boolean isMatchJavaAndPlayerCore(String paramString1, String paramString2)
  {
    TPNativeLog.printLog(2, "javaVersion:" + paramString1 + ", coreVersion:" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
    } while ((paramString1.length < 3) || (paramString2.length < 3));
    int i = 0;
    for (;;)
    {
      if (i >= 3) {
        break label100;
      }
      if (!paramString1[i].matches(paramString2[i])) {
        break;
      }
      i += 1;
    }
    label100:
    return true;
  }
  
  private static boolean loadLib(Context paramContext)
  {
    TPNativeLog.printLog(2, "loadLib cpu arch:" + TPSystemInfo.getCpuArchitecture());
    if ((TPSystemInfo.getCpuArchitecture() == 3) || (TPSystemInfo.getCpuArchitecture() == 4) || (TPSystemInfo.getCpuArchitecture() == 0)) {
      return false;
    }
    String str = "TPCore-master" + "";
    if (mLibLoader != null) {}
    boolean bool2;
    for (boolean bool1 = mLibLoader.loadLib(str, "2.5.0.1085.full");; bool1 = loadLibDefault(str, paramContext))
    {
      bool2 = bool1;
      if (bool1)
      {
        paramContext = getPlayerCoreVersion();
        bool1 = isMatchJavaAndPlayerCore("2.5.0", paramContext);
        bool2 = bool1;
        if (!bool1)
        {
          TPNativeLog.printLog(4, "nativePlayerCoreVer(" + paramContext + ") doesn't match javaPlayerCoreVer:(" + "2.5.0" + ")");
          bool2 = bool1;
        }
      }
      if (!bool2) {
        break;
      }
      TPNativeLog.printLog(2, "Native libs loaded successfully");
      return bool2;
    }
    TPNativeLog.printLog(4, "Failed to load native libs");
    return bool2;
  }
  
  /* Error */
  private static boolean loadLibDefault(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_3
    //   3: istore_2
    //   4: iconst_2
    //   5: new 60	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   12: ldc 134
    //   14: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   27: iload_3
    //   28: istore_2
    //   29: aload_0
    //   30: invokestatic 140	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   33: iconst_1
    //   34: istore_2
    //   35: iconst_2
    //   36: new 60	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   43: ldc 142
    //   45: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 144
    //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   63: iconst_1
    //   64: istore_2
    //   65: iload_2
    //   66: istore_3
    //   67: iload_2
    //   68: ifne +98 -> 166
    //   71: iload_2
    //   72: istore_3
    //   73: aload_1
    //   74: ifnull +92 -> 166
    //   77: iload_2
    //   78: istore_3
    //   79: invokestatic 107	com/tencent/thumbplayer/core/common/TPSystemInfo:getCpuArchitecture	()I
    //   82: bipush 6
    //   84: if_icmplt +82 -> 166
    //   87: iload_2
    //   88: istore_3
    //   89: iconst_2
    //   90: new 60	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   97: ldc 146
    //   99: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 148
    //   108: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   117: iload_2
    //   118: istore_3
    //   119: aload_0
    //   120: ldc 2
    //   122: invokevirtual 154	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   125: aload_1
    //   126: invokestatic 160	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:load	(Ljava/lang/String;Ljava/lang/ClassLoader;Landroid/content/Context;)Z
    //   129: istore_2
    //   130: iload_2
    //   131: ifeq +78 -> 209
    //   134: iload_2
    //   135: istore_3
    //   136: iconst_2
    //   137: new 60	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   144: ldc 162
    //   146: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 164
    //   155: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   164: iload_2
    //   165: istore_3
    //   166: iload_3
    //   167: ireturn
    //   168: astore 4
    //   170: iconst_4
    //   171: new 60	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   178: ldc 166
    //   180: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 168
    //   189: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 4
    //   194: invokevirtual 70	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   206: goto -141 -> 65
    //   209: iload_2
    //   210: istore_3
    //   211: iconst_4
    //   212: new 60	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   219: ldc 162
    //   221: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 170
    //   230: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   239: iload_2
    //   240: ireturn
    //   241: astore_1
    //   242: iconst_4
    //   243: new 60	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   250: ldc 162
    //   252: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc 172
    //   261: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 70	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   268: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 52	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   277: iload_3
    //   278: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramString	String
    //   0	279	1	paramContext	Context
    //   3	237	2	bool1	boolean
    //   1	277	3	bool2	boolean
    //   168	25	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   4	27	168	java/lang/Throwable
    //   29	33	168	java/lang/Throwable
    //   35	63	168	java/lang/Throwable
    //   89	117	241	java/lang/Throwable
    //   119	130	241	java/lang/Throwable
    //   136	164	241	java/lang/Throwable
    //   211	239	241	java/lang/Throwable
  }
  
  public static void loadLibIfNeeded(Context paramContext)
  {
    for (;;)
    {
      synchronized (mIsLibLoadedLock)
      {
        if (!mIsLibLoaded)
        {
          mIsLibLoaded = loadLib(paramContext);
          if (mIsLibLoaded) {
            TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib successfully");
          }
        }
        else
        {
          if (mIsLibLoaded) {
            break;
          }
          throw new UnsupportedOperationException("Failed to load native library");
        }
      }
      TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib failed");
    }
  }
  
  public static void setLibLoader(ITPNativeLibraryExternalLoader paramITPNativeLibraryExternalLoader)
  {
    mLibLoader = paramITPNativeLibraryExternalLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPNativeLibraryLoader
 * JD-Core Version:    0.7.0.1
 */