package com.tencent.qqmini.sdk.launcher.log;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import java.io.File;

@MiniKeep
public class QMLog
{
  public static final String TAG_DOWNLOAD = "downloader";
  public static final String TAG_DOWNLOAD_RESULT = "downloader_result";
  private static int debugMode;
  private static String process;
  private static Log sLog;
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log localLog = sLog;
    if (localLog != null)
    {
      localLog.d(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.d(getLogTag(paramString1), paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log localLog = sLog;
    if (localLog != null)
    {
      localLog.e(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(getLogTag(paramString1), paramString2, paramThrowable);
  }
  
  public static int getDebug()
  {
    if (debugMode == 0)
    {
      int i;
      if (new File("/sdcard/debug").exists()) {
        i = 1;
      } else {
        i = 2;
      }
      debugMode = i;
    }
    return debugMode;
  }
  
  public static Log getLog()
  {
    return sLog;
  }
  
  public static int getLogLevel()
  {
    Log localLog = sLog;
    if (localLog != null) {
      return localLog.getLogLevel();
    }
    return 3;
  }
  
  private static String getLogTag(String paramString)
  {
    if (getDebug() == 1)
    {
      localObject = Thread.currentThread().getStackTrace();
      if (localObject.length > 5)
      {
        localObject = localObject[5];
        String str = String.format("(%s:%s)", new Object[] { ((StackTraceElement)localObject).getFileName(), Integer.valueOf(((StackTraceElement)localObject).getLineNumber()) });
        return String.format("[MiniSDK]|%s{%d}|%s[%s]%s", new Object[] { getProcessName(), Long.valueOf(Thread.currentThread().getId()), str, ((StackTraceElement)localObject).getMethodName(), paramString });
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniSDK]");
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
  }
  
  /* Error */
  private static String getProcessName()
  {
    // Byte code:
    //   0: getstatic 138	com/tencent/qqmini/sdk/launcher/log/QMLog:process	Ljava/lang/String;
    //   3: ifnonnull +188 -> 191
    //   6: new 140	java/io/FileInputStream
    //   9: dup
    //   10: ldc 142
    //   12: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: sipush 256
    //   21: newarray byte
    //   23: astore 4
    //   25: iconst_0
    //   26: istore_0
    //   27: aload_3
    //   28: astore_2
    //   29: aload_3
    //   30: invokevirtual 146	java/io/FileInputStream:read	()I
    //   33: istore_1
    //   34: iload_1
    //   35: ifle +25 -> 60
    //   38: aload_3
    //   39: astore_2
    //   40: iload_0
    //   41: aload 4
    //   43: arraylength
    //   44: if_icmpge +16 -> 60
    //   47: aload 4
    //   49: iload_0
    //   50: iload_1
    //   51: i2b
    //   52: bastore
    //   53: iload_0
    //   54: iconst_1
    //   55: iadd
    //   56: istore_0
    //   57: goto -30 -> 27
    //   60: iload_0
    //   61: ifle +21 -> 82
    //   64: aload_3
    //   65: astore_2
    //   66: new 99	java/lang/String
    //   69: dup
    //   70: aload 4
    //   72: iconst_0
    //   73: iload_0
    //   74: ldc 148
    //   76: invokespecial 151	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   79: putstatic 138	com/tencent/qqmini/sdk/launcher/log/QMLog:process	Ljava/lang/String;
    //   82: aload_3
    //   83: astore_2
    //   84: getstatic 138	com/tencent/qqmini/sdk/launcher/log/QMLog:process	Ljava/lang/String;
    //   87: ldc 153
    //   89: invokevirtual 157	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   92: istore_0
    //   93: iload_0
    //   94: ifle +101 -> 195
    //   97: aload_3
    //   98: astore_2
    //   99: getstatic 138	com/tencent/qqmini/sdk/launcher/log/QMLog:process	Ljava/lang/String;
    //   102: iload_0
    //   103: invokevirtual 161	java/lang/String:substring	(I)Ljava/lang/String;
    //   106: astore 4
    //   108: goto +3 -> 111
    //   111: aload_3
    //   112: astore_2
    //   113: aload 4
    //   115: putstatic 138	com/tencent/qqmini/sdk/launcher/log/QMLog:process	Ljava/lang/String;
    //   118: aload_3
    //   119: invokevirtual 164	java/io/FileInputStream:close	()V
    //   122: goto +69 -> 191
    //   125: astore 4
    //   127: goto +13 -> 140
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_3
    //   133: goto +40 -> 173
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_3
    //   141: astore_2
    //   142: aload 4
    //   144: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   147: aload_3
    //   148: ifnull +43 -> 191
    //   151: aload_3
    //   152: invokevirtual 164	java/io/FileInputStream:close	()V
    //   155: goto +36 -> 191
    //   158: astore_2
    //   159: aload_2
    //   160: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   163: goto +28 -> 191
    //   166: astore 4
    //   168: aload_2
    //   169: astore_3
    //   170: aload 4
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +15 -> 189
    //   177: aload_3
    //   178: invokevirtual 164	java/io/FileInputStream:close	()V
    //   181: goto +8 -> 189
    //   184: astore_3
    //   185: aload_3
    //   186: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   189: aload_2
    //   190: athrow
    //   191: getstatic 138	com/tencent/qqmini/sdk/launcher/log/QMLog:process	Ljava/lang/String;
    //   194: areturn
    //   195: ldc 170
    //   197: astore 4
    //   199: goto -88 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	77	0	i	int
    //   33	18	1	j	int
    //   17	96	2	localObject1	Object
    //   130	1	2	localObject2	Object
    //   141	1	2	localObject3	Object
    //   158	11	2	localIOException1	java.io.IOException
    //   172	18	2	localObject4	Object
    //   15	163	3	localObject5	Object
    //   184	2	3	localIOException2	java.io.IOException
    //   23	91	4	localObject6	Object
    //   125	1	4	localThrowable1	Throwable
    //   136	7	4	localThrowable2	Throwable
    //   166	5	4	localObject7	Object
    //   197	1	4	str	String
    // Exception table:
    //   from	to	target	type
    //   18	25	125	java/lang/Throwable
    //   29	34	125	java/lang/Throwable
    //   40	47	125	java/lang/Throwable
    //   66	82	125	java/lang/Throwable
    //   84	93	125	java/lang/Throwable
    //   99	108	125	java/lang/Throwable
    //   113	118	125	java/lang/Throwable
    //   6	16	130	finally
    //   6	16	136	java/lang/Throwable
    //   118	122	158	java/io/IOException
    //   151	155	158	java/io/IOException
    //   18	25	166	finally
    //   29	34	166	finally
    //   40	47	166	finally
    //   66	82	166	finally
    //   84	93	166	finally
    //   99	108	166	finally
    //   113	118	166	finally
    //   142	147	166	finally
    //   177	181	184	java/io/IOException
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log localLog = sLog;
    if (localLog != null)
    {
      localLog.i(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.i(getLogTag(paramString1), paramString2, paramThrowable);
  }
  
  public static boolean isColorLevel()
  {
    return true;
  }
  
  public static boolean isDebugEnabled()
  {
    return 2 >= getLogLevel();
  }
  
  public static boolean isErrorEnabled()
  {
    return 5 >= getLogLevel();
  }
  
  public static boolean isInfoEnabled()
  {
    return 3 >= getLogLevel();
  }
  
  public static boolean isWarningEnabled()
  {
    return 4 >= getLogLevel();
  }
  
  public static void setLog(Log paramLog)
  {
    if (paramLog != null) {
      sLog = paramLog;
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log localLog = sLog;
    if (localLog != null)
    {
      localLog.w(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(getLogTag(paramString1), paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.log.QMLog
 * JD-Core Version:    0.7.0.1
 */