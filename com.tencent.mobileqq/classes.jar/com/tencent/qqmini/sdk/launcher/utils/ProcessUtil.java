package com.tencent.qqmini.sdk.launcher.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class ProcessUtil
{
  private static final String TAG = "ProcessNameUtil";
  
  public static String getProcessName(Context paramContext)
  {
    String str;
    if (Build.VERSION.SDK_INT >= 28) {
      str = Application.getProcessName();
    } else {
      str = null;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    paramContext = processNameFromRunningProcess(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    paramContext = processNameFromLinuxFile(Process.myPid());
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    paramContext = processNameFromReflection();
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    QMLog.e("ProcessNameUtil", "WTF, process name is null");
    return null;
  }
  
  /* Error */
  private static String processNameFromLinuxFile(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: new 62	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   14: astore 4
    //   16: aload_3
    //   17: astore_2
    //   18: aload 4
    //   20: ldc 65
    //   22: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: astore_2
    //   28: aload 4
    //   30: iload_0
    //   31: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: astore_2
    //   37: aload 4
    //   39: ldc 74
    //   41: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: astore_2
    //   47: new 76	java/io/BufferedReader
    //   50: dup
    //   51: new 78	java/io/InputStreamReader
    //   54: dup
    //   55: new 80	java/io/FileInputStream
    //   58: dup
    //   59: aload 4
    //   61: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   67: ldc 88
    //   69: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   72: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   75: astore_3
    //   76: new 62	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   83: astore_2
    //   84: aload_3
    //   85: invokevirtual 97	java/io/BufferedReader:read	()I
    //   88: istore_1
    //   89: iload_1
    //   90: ifle +13 -> 103
    //   93: aload_2
    //   94: iload_1
    //   95: i2c
    //   96: invokevirtual 100	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: goto -16 -> 84
    //   103: aload_2
    //   104: invokevirtual 103	java/lang/StringBuilder:trimToSize	()V
    //   107: aload_2
    //   108: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore_2
    //   112: aload_3
    //   113: invokevirtual 106	java/io/BufferedReader:close	()V
    //   116: goto +116 -> 232
    //   119: astore_3
    //   120: ldc 8
    //   122: ldc 108
    //   124: aload_3
    //   125: invokestatic 111	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: goto +104 -> 232
    //   131: astore 4
    //   133: aload_3
    //   134: astore_2
    //   135: aload 4
    //   137: astore_3
    //   138: goto +139 -> 277
    //   141: astore 4
    //   143: goto +12 -> 155
    //   146: astore_3
    //   147: goto +130 -> 277
    //   150: astore 4
    //   152: aload 5
    //   154: astore_3
    //   155: aload_3
    //   156: astore_2
    //   157: new 62	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   164: astore 5
    //   166: aload_3
    //   167: astore_2
    //   168: aload 5
    //   170: ldc 113
    //   172: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_3
    //   177: astore_2
    //   178: aload 5
    //   180: iload_0
    //   181: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_3
    //   186: astore_2
    //   187: aload 5
    //   189: ldc 74
    //   191: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_3
    //   196: astore_2
    //   197: ldc 8
    //   199: aload 5
    //   201: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: aload 4
    //   206: invokestatic 111	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_3
    //   210: ifnull +19 -> 229
    //   213: aload_3
    //   214: invokevirtual 106	java/io/BufferedReader:close	()V
    //   217: goto +12 -> 229
    //   220: astore_2
    //   221: ldc 8
    //   223: ldc 108
    //   225: aload_2
    //   226: invokestatic 111	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   229: ldc 115
    //   231: astore_2
    //   232: new 62	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   239: astore_3
    //   240: aload_3
    //   241: ldc 117
    //   243: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_3
    //   248: aload_2
    //   249: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_3
    //   254: ldc 119
    //   256: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_3
    //   261: iload_0
    //   262: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: ldc 8
    //   268: aload_3
    //   269: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 122	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload_2
    //   276: areturn
    //   277: aload_2
    //   278: ifnull +19 -> 297
    //   281: aload_2
    //   282: invokevirtual 106	java/io/BufferedReader:close	()V
    //   285: goto +12 -> 297
    //   288: astore_2
    //   289: ldc 8
    //   291: ldc 108
    //   293: aload_2
    //   294: invokestatic 111	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   297: goto +5 -> 302
    //   300: aload_3
    //   301: athrow
    //   302: goto -2 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramInt	int
    //   88	7	1	i	int
    //   6	191	2	localObject1	Object
    //   220	6	2	localIOException1	java.io.IOException
    //   231	51	2	str	String
    //   288	6	2	localIOException2	java.io.IOException
    //   4	109	3	localBufferedReader	java.io.BufferedReader
    //   119	15	3	localIOException3	java.io.IOException
    //   137	1	3	localObject2	Object
    //   146	1	3	localObject3	Object
    //   154	147	3	localStringBuilder1	StringBuilder
    //   14	46	4	localStringBuilder2	StringBuilder
    //   131	5	4	localObject4	Object
    //   141	1	4	localException1	java.lang.Exception
    //   150	55	4	localException2	java.lang.Exception
    //   1	199	5	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   112	116	119	java/io/IOException
    //   76	84	131	finally
    //   84	89	131	finally
    //   93	100	131	finally
    //   103	112	131	finally
    //   76	84	141	java/lang/Exception
    //   84	89	141	java/lang/Exception
    //   93	100	141	java/lang/Exception
    //   103	112	141	java/lang/Exception
    //   7	16	146	finally
    //   18	26	146	finally
    //   28	35	146	finally
    //   37	45	146	finally
    //   47	76	146	finally
    //   157	166	146	finally
    //   168	176	146	finally
    //   178	185	146	finally
    //   187	195	146	finally
    //   197	209	146	finally
    //   7	16	150	java/lang/Exception
    //   18	26	150	java/lang/Exception
    //   28	35	150	java/lang/Exception
    //   37	45	150	java/lang/Exception
    //   47	76	150	java/lang/Exception
    //   213	217	220	java/io/IOException
    //   281	285	288	java/io/IOException
  }
  
  private static String processNameFromReflection()
  {
    for (;;)
    {
      try
      {
        Object localObject = Class.forName("android.app.ActivityThread");
        if (Build.VERSION.SDK_INT >= 18)
        {
          String str1 = "currentProcessName";
          str1 = (String)((Class)localObject).getDeclaredMethod(str1, new Class[0]).invoke(null, new Object[0]);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Get process name: ");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(" by reflection");
          QMLog.d("ProcessNameUtil", ((StringBuilder)localObject).toString());
          return str1;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("ProcessNameUtil", "getProcessName exception!", localThrowable);
        return null;
      }
      String str2 = "currentPackageName";
    }
  }
  
  private static String processNameFromRunningProcess(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      int i = Process.myPid();
      paramContext = paramContext.getRunningAppProcesses();
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i)
        {
          paramContext = new StringBuilder();
          paramContext.append("Loop running process matched process name: ");
          paramContext.append(((ActivityManager.RunningAppProcessInfo)localObject).processName);
          paramContext.append(" for pid: ");
          paramContext.append(i);
          QMLog.d("ProcessNameUtil", paramContext.toString());
          return ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to get process name, running app processes: ");
      ((StringBuilder)localObject).append(paramContext);
      QMLog.e("ProcessNameUtil", ((StringBuilder)localObject).toString());
    }
    catch (Throwable paramContext)
    {
      QMLog.e("ProcessNameUtil", "getProcessName exception!", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */