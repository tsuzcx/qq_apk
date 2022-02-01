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
    if (Build.VERSION.SDK_INT >= 28) {}
    for (String str = Application.getProcessName();; str = null)
    {
      if (!TextUtils.isEmpty(str)) {
        paramContext = str;
      }
      do
      {
        do
        {
          do
          {
            return paramContext;
            str = processNameFromRunningProcess(paramContext);
            paramContext = str;
          } while (!TextUtils.isEmpty(str));
          str = processNameFromLinuxFile(Process.myPid());
          paramContext = str;
        } while (!TextUtils.isEmpty(str));
        str = processNameFromReflection();
        paramContext = str;
      } while (!TextUtils.isEmpty(str));
      QMLog.e("ProcessNameUtil", "WTF, process name is null");
      return null;
    }
  }
  
  /* Error */
  private static String processNameFromLinuxFile(int paramInt)
  {
    // Byte code:
    //   0: ldc 62
    //   2: astore 5
    //   4: new 64	java/io/BufferedReader
    //   7: dup
    //   8: new 66	java/io/InputStreamReader
    //   11: dup
    //   12: new 68	java/io/FileInputStream
    //   15: dup
    //   16: new 70	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   23: ldc 73
    //   25: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_0
    //   29: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 82
    //   34: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: ldc 90
    //   45: invokespecial 93	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   48: invokespecial 96	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_3
    //   52: aload_3
    //   53: astore_2
    //   54: new 70	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   61: astore 4
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 99	java/io/BufferedReader:read	()I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +100 -> 171
    //   74: aload_3
    //   75: astore_2
    //   76: aload 4
    //   78: iload_1
    //   79: i2c
    //   80: invokevirtual 102	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: goto -21 -> 63
    //   87: astore 4
    //   89: aload_3
    //   90: astore_2
    //   91: ldc 8
    //   93: new 70	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   100: ldc 104
    //   102: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload_0
    //   106: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc 82
    //   111: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aload 4
    //   119: invokestatic 107	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload 5
    //   124: astore_2
    //   125: aload_3
    //   126: ifnull +10 -> 136
    //   129: aload_3
    //   130: invokevirtual 110	java/io/BufferedReader:close	()V
    //   133: aload 5
    //   135: astore_2
    //   136: ldc 8
    //   138: new 70	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   145: ldc 112
    //   147: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 114
    //   156: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload_0
    //   160: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 117	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_2
    //   170: areturn
    //   171: aload_3
    //   172: astore_2
    //   173: aload 4
    //   175: invokevirtual 120	java/lang/StringBuilder:trimToSize	()V
    //   178: aload_3
    //   179: astore_2
    //   180: aload 4
    //   182: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore 4
    //   187: aload 4
    //   189: astore_2
    //   190: aload_3
    //   191: ifnull -55 -> 136
    //   194: aload_3
    //   195: invokevirtual 110	java/io/BufferedReader:close	()V
    //   198: aload 4
    //   200: astore_2
    //   201: goto -65 -> 136
    //   204: astore_2
    //   205: ldc 8
    //   207: ldc 122
    //   209: aload_2
    //   210: invokestatic 107	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload 4
    //   215: astore_2
    //   216: goto -80 -> 136
    //   219: astore_2
    //   220: ldc 8
    //   222: ldc 122
    //   224: aload_2
    //   225: invokestatic 107	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload 5
    //   230: astore_2
    //   231: goto -95 -> 136
    //   234: astore_3
    //   235: aconst_null
    //   236: astore_2
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 110	java/io/BufferedReader:close	()V
    //   245: aload_3
    //   246: athrow
    //   247: astore_2
    //   248: ldc 8
    //   250: ldc 122
    //   252: aload_2
    //   253: invokestatic 107	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: goto -11 -> 245
    //   259: astore_3
    //   260: goto -23 -> 237
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_3
    //   267: goto -178 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramInt	int
    //   69	10	1	i	int
    //   53	148	2	localObject1	Object
    //   204	6	2	localIOException1	java.io.IOException
    //   215	1	2	localObject2	Object
    //   219	6	2	localIOException2	java.io.IOException
    //   230	12	2	str1	String
    //   247	6	2	localIOException3	java.io.IOException
    //   51	144	3	localBufferedReader	java.io.BufferedReader
    //   234	12	3	localObject3	Object
    //   259	1	3	localObject4	Object
    //   266	1	3	localObject5	Object
    //   61	16	4	localStringBuilder	java.lang.StringBuilder
    //   87	94	4	localException1	java.lang.Exception
    //   185	29	4	str2	String
    //   263	1	4	localException2	java.lang.Exception
    //   2	227	5	str3	String
    // Exception table:
    //   from	to	target	type
    //   54	63	87	java/lang/Exception
    //   65	70	87	java/lang/Exception
    //   76	84	87	java/lang/Exception
    //   173	178	87	java/lang/Exception
    //   180	187	87	java/lang/Exception
    //   194	198	204	java/io/IOException
    //   129	133	219	java/io/IOException
    //   4	52	234	finally
    //   241	245	247	java/io/IOException
    //   54	63	259	finally
    //   65	70	259	finally
    //   76	84	259	finally
    //   91	122	259	finally
    //   173	178	259	finally
    //   180	187	259	finally
    //   4	52	263	java/lang/Exception
  }
  
  private static String processNameFromReflection()
  {
    try
    {
      Class localClass = Class.forName("android.app.ActivityThread");
      if (Build.VERSION.SDK_INT >= 18) {}
      for (String str = "currentProcessName";; str = "currentPackageName")
      {
        str = (String)localClass.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        QMLog.d("ProcessNameUtil", "Get process name: " + str + " by reflection");
        return str;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ProcessNameUtil", "getProcessName exception!", localThrowable);
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
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          QMLog.d("ProcessNameUtil", "Loop running process matched process name: " + localRunningAppProcessInfo.processName + " for pid: " + i);
          return localRunningAppProcessInfo.processName;
        }
      }
      QMLog.e("ProcessNameUtil", "Failed to get process name, running app processes: " + paramContext);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QMLog.e("ProcessNameUtil", "getProcessName exception!", paramContext);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */