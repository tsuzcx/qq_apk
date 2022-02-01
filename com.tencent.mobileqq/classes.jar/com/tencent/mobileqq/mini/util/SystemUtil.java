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
        if (!TextUtils.isEmpty(getSystemProperty("ro.miui.internal.storage"))) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    isMiui = bool1;
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
    catch (Exception localException)
    {
      label34:
      break label34;
    }
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
    catch (Exception localException)
    {
      label31:
      break label31;
    }
    return 0L;
  }
  
  /* Error */
  public static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 85	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore_1
    //   6: new 87	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 90
    //   17: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: new 96	java/io/BufferedReader
    //   30: dup
    //   31: new 98	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: aload_3
    //   37: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 105	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   43: invokevirtual 111	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   46: invokespecial 114	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: sipush 1024
    //   52: invokespecial 117	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: aload_1
    //   59: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 123	java/io/BufferedReader:close	()V
    //   69: aload_1
    //   70: invokevirtual 123	java/io/BufferedReader:close	()V
    //   73: aload_2
    //   74: areturn
    //   75: astore_0
    //   76: getstatic 125	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   79: iconst_2
    //   80: ldc 127
    //   82: aload_0
    //   83: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_2
    //   89: goto +12 -> 101
    //   92: astore_0
    //   93: aload_2
    //   94: astore_1
    //   95: goto +46 -> 141
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: getstatic 125	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   106: iconst_2
    //   107: ldc 135
    //   109: aload_2
    //   110: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_1
    //   114: ifnull +20 -> 134
    //   117: aload_1
    //   118: invokevirtual 123	java/io/BufferedReader:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_0
    //   124: getstatic 125	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   127: iconst_2
    //   128: ldc 127
    //   130: aload_0
    //   131: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_2
    //   137: aload_0
    //   138: astore_1
    //   139: aload_2
    //   140: astore_0
    //   141: aload_1
    //   142: ifnull +21 -> 163
    //   145: aload_1
    //   146: invokevirtual 123	java/io/BufferedReader:close	()V
    //   149: goto +14 -> 163
    //   152: astore_1
    //   153: getstatic 125	com/tencent/mobileqq/mini/util/SystemUtil:TAG	Ljava/lang/String;
    //   156: iconst_2
    //   157: ldc 127
    //   159: aload_1
    //   160: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_0
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString	String
    //   5	141	1	localObject1	Object
    //   152	8	1	localIOException1	java.io.IOException
    //   1	86	2	str	String
    //   88	6	2	localIOException2	java.io.IOException
    //   98	12	2	localIOException3	java.io.IOException
    //   136	4	2	localObject2	Object
    //   13	24	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	73	75	java/io/IOException
    //   58	63	88	java/io/IOException
    //   65	69	88	java/io/IOException
    //   2	56	92	finally
    //   2	56	98	java/io/IOException
    //   117	121	123	java/io/IOException
    //   58	63	136	finally
    //   65	69	136	finally
    //   103	113	136	finally
    //   145	149	152	java/io/IOException
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationContext().getFilesDir().getAbsolutePath());
      localStringBuilder.append("/");
      APP_ROOT = localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */