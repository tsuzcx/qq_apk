package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class TombLogRecordHelper
{
  static List<File> a(Context paramContext)
  {
    int i = 0;
    Object localObject1 = new File(paramContext.getDir("tombs", 0).getAbsolutePath());
    paramContext = new ArrayList();
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        long l = localObject2.length();
        if ((l > 0L) && (l < 16000L)) {
          paramContext.add(localObject2);
        }
        i += 1;
      }
    }
    return paramContext;
  }
  
  public static void a()
  {
    Object localObject = MobileQQ.context;
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject).getSharedPreferences("QQCrashReportManager", 4);
    if (localSharedPreferences.getBoolean("KEY_IS_NATIVE_CRASH_HAPPENED", false))
    {
      localObject = new TombLogRecordHelper.1((BaseApplication)localObject);
      ThreadManager.getSubThreadHandler().postDelayed((Runnable)localObject, 10000L);
    }
    localSharedPreferences.edit().putBoolean("KEY_IS_NATIVE_CRASH_HAPPENED", false).commit();
  }
  
  static void a(Context paramContext)
  {
    paramContext = a(paramContext).iterator();
    while (paramContext.hasNext()) {
      a((File)paramContext.next());
    }
  }
  
  /* Error */
  static void a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 25	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore_1
    //   5: new 134	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: new 134	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 141
    //   31: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 5
    //   37: aload_2
    //   38: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aconst_null
    //   46: astore_3
    //   47: aconst_null
    //   48: astore 4
    //   50: aconst_null
    //   51: astore_1
    //   52: new 146	java/io/BufferedReader
    //   55: dup
    //   56: new 148	java/io/FileReader
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 150	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   64: invokespecial 153	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 156	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +21 -> 95
    //   77: aload 5
    //   79: aload_1
    //   80: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: ldc 141
    //   88: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: goto -24 -> 68
    //   95: aload_0
    //   96: invokevirtual 159	java/io/BufferedReader:close	()V
    //   99: goto +69 -> 168
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: aload_2
    //   106: astore_0
    //   107: goto +97 -> 204
    //   110: astore_2
    //   111: goto +14 -> 125
    //   114: astore_2
    //   115: goto +31 -> 146
    //   118: astore_0
    //   119: goto +85 -> 204
    //   122: astore_2
    //   123: aload_3
    //   124: astore_0
    //   125: aload_0
    //   126: astore_1
    //   127: aload_2
    //   128: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   131: aload_0
    //   132: ifnull +36 -> 168
    //   135: aload_0
    //   136: invokevirtual 159	java/io/BufferedReader:close	()V
    //   139: goto +29 -> 168
    //   142: astore_2
    //   143: aload 4
    //   145: astore_0
    //   146: aload_0
    //   147: astore_1
    //   148: aload_2
    //   149: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   152: aload_0
    //   153: ifnull +15 -> 168
    //   156: aload_0
    //   157: invokevirtual 159	java/io/BufferedReader:close	()V
    //   160: goto +8 -> 168
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   168: new 134	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   175: astore_0
    //   176: aload_0
    //   177: ldc 166
    //   179: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_0
    //   184: aload 5
    //   186: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 61
    //   195: iconst_1
    //   196: aload_0
    //   197: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: return
    //   204: aload_1
    //   205: ifnull +15 -> 220
    //   208: aload_1
    //   209: invokevirtual 159	java/io/BufferedReader:close	()V
    //   212: goto +8 -> 220
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   220: goto +5 -> 225
    //   223: aload_0
    //   224: athrow
    //   225: goto -2 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramFile	File
    //   4	205	1	localObject1	Object
    //   215	2	1	localIOException	java.io.IOException
    //   21	17	2	localStringBuilder1	java.lang.StringBuilder
    //   102	4	2	localObject2	Object
    //   110	1	2	localException1	java.lang.Exception
    //   114	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   122	6	2	localException2	java.lang.Exception
    //   142	7	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   46	78	3	localObject3	Object
    //   48	96	4	localObject4	Object
    //   12	173	5	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   68	73	102	finally
    //   77	92	102	finally
    //   68	73	110	java/lang/Exception
    //   77	92	110	java/lang/Exception
    //   68	73	114	java/io/FileNotFoundException
    //   77	92	114	java/io/FileNotFoundException
    //   52	68	118	finally
    //   127	131	118	finally
    //   148	152	118	finally
    //   52	68	122	java/lang/Exception
    //   52	68	142	java/io/FileNotFoundException
    //   95	99	163	java/io/IOException
    //   135	139	163	java/io/IOException
    //   156	160	163	java/io/IOException
    //   208	212	215	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.TombLogRecordHelper
 * JD-Core Version:    0.7.0.1
 */