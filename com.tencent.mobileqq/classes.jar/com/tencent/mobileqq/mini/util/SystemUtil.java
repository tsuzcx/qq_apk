package com.tencent.mobileqq.mini.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;

public class SystemUtil
{
  public static String APP_ROOT = "/data/data/com.qq.qwallet/files/";
  private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
  private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
  private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
  public static String TAG = "SystemUtil";
  static boolean isCheckMiui;
  static boolean isMiui;
  
  public static void checkMIUI()
  {
    boolean bool2 = true;
    isCheckMiui = true;
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.code")))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"))) {
        if (TextUtils.isEmpty(getSystemProperty("ro.miui.internal.storage"))) {
          break label50;
        }
      }
    }
    label50:
    for (bool1 = bool2;; bool1 = false)
    {
      isMiui = bool1;
      return;
    }
  }
  
  public static long getSDCardAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static long getSystemAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(APP_ROOT);
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  /* Error */
  public static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 83	java/io/BufferedReader
    //   5: dup
    //   6: new 85	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 91	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: new 93	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   20: ldc 96
    //   22: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 107	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 113	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 116	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: sipush 1024
    //   44: invokespecial 119	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 122	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: invokevirtual 125	java/io/BufferedReader:close	()V
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 125	java/io/BufferedReader:close	()V
    //   69: aload_2
    //   70: areturn
    //   71: astore_0
    //   72: getstatic 25	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   75: iconst_2
    //   76: ldc 127
    //   78: aload_0
    //   79: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: astore_0
    //   89: getstatic 25	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   92: iconst_2
    //   93: ldc 135
    //   95: aload_2
    //   96: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 125	java/io/BufferedReader:close	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: getstatic 25	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   113: iconst_2
    //   114: ldc 127
    //   116: aload_0
    //   117: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: goto -13 -> 107
    //   123: astore_0
    //   124: aload_2
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 125	java/io/BufferedReader:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_1
    //   137: getstatic 25	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   140: iconst_2
    //   141: ldc 127
    //   143: aload_1
    //   144: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: goto -13 -> 134
    //   150: astore_2
    //   151: aload_0
    //   152: astore_1
    //   153: aload_2
    //   154: astore_0
    //   155: goto -29 -> 126
    //   158: astore_2
    //   159: goto -72 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   47	84	1	localObject1	Object
    //   136	8	1	localIOException1	java.io.IOException
    //   152	1	1	str1	String
    //   1	82	2	str2	String
    //   84	41	2	localIOException2	java.io.IOException
    //   150	4	2	localObject2	Object
    //   158	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   2	48	84	java/io/IOException
    //   103	107	109	java/io/IOException
    //   2	48	123	finally
    //   130	134	136	java/io/IOException
    //   50	55	150	finally
    //   57	61	150	finally
    //   89	99	150	finally
    //   50	55	158	java/io/IOException
    //   57	61	158	java/io/IOException
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext != null) {
      APP_ROOT = paramContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/";
    }
  }
  
  public static boolean isExistSDCard()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = Environment.getExternalStorageState().equals("mounted");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isFlyme()
  {
    boolean bool = false;
    try
    {
      Method localMethod = Build.class.getMethod("hasSmartBar", new Class[0]);
      if (localMethod != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isMIUI()
  {
    if (isCheckMiui) {
      return isMiui;
    }
    checkMIUI();
    return isMiui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */