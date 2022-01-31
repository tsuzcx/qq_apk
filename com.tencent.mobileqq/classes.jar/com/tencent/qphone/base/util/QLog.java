package com.tencent.qphone.base.util;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class QLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  private static final int[] INTERVAL_RETRY_INIT;
  private static final int MSG_CLEAR = 3;
  private static final int MSG_INIT_WRITER = 1;
  private static final int MSG_WRITE = 2;
  private static final String QlogSpTag = "QLog";
  private static final String ReportLogSelfTimeTag = "";
  public static final String TAG_REPORTLEVEL_COLORUSER = "W";
  public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
  public static final String TAG_REPORTLEVEL_USER = "E";
  private static int UIN_REPORTLOG_LEVEL = 0;
  public static final int USR = 1;
  public static final int _DEFAULT_REPORTLOG_LEVEL = 1;
  static long colorLogTime = 0L;
  static HashSet colorTags = new HashSet();
  private static String currentLogFileName;
  private static long currentLogSecond = 0L;
  protected static final boolean isDebug = false;
  protected static boolean isLogToFile = true;
  private static long lastCheckLogFileTime = 0L;
  private static long lastPrintMemeoryTime = 0L;
  static SimpleDateFormat logFileFormatter;
  public static final String logLevelHead = "LOGLEVEL_";
  public static final String logLevelTime = "LOGLEVELTIME";
  private static String logPath;
  private static String logTime;
  public static String manualLogLevelPath;
  private static final int myProcessId;
  private static long nextHourTime = 0L;
  public static String packageName;
  private static String processName;
  private static int retryInitTimes = 0;
  static String sBuildNumber = "";
  private static StringBuilder sBuilder = new StringBuilder(10240);
  private static b sHead;
  private static ILogCallback sLogCallback;
  private static RecyclablePool sPool;
  private static b sTail;
  static Field sValueField;
  private static char[] sValues;
  static c sWriteHandler;
  private static final String tag = "MSF.D.QLog";
  static SimpleDateFormat timeFormatter;
  private static BufferedWriter writer;
  
  static
  {
    UIN_REPORTLOG_LEVEL = 1;
    logPath = "";
    currentLogFileName = "";
    processName = "";
    packageName = "";
    myProcessId = Process.myPid();
    manualLogLevelPath = Environment.getExternalStorageDirectory() + "/mqqLogLevel";
    INTERVAL_RETRY_INIT = new int[] { 1, 1, 1, 2, 2, 4, 4, 8, 16, 29 };
    logTime = "";
    logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");
    timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  }
  
  private static void addLogItem(String arg0, int paramInt, String paramString2, Throwable paramThrowable)
  {
    long l = System.currentTimeMillis();
    if ((colorLogTime != 0L) && (l - colorLogTime > 1800000L))
    {
      colorLogTime = 0L;
      colorTags.clear();
    }
    b localb = (b)sPool.obtain(b.class);
    if (localb == null)
    {
      Log.e("QLog", "addLogItem obtain return null");
      return;
    }
    localb.a = l;
    localb.b = Process.myTid();
    localb.c = paramInt;
    localb.d = ???;
    localb.e = paramString2;
    localb.f = paramThrowable;
    for (;;)
    {
      synchronized (processName)
      {
        if (sHead == null)
        {
          sHead = localb;
          sTail = localb;
          return;
        }
      }
      sTail.changeNext(localb, true);
      sTail = localb;
    }
  }
  
  private static boolean checkCurrentLogFileExists()
  {
    long l = System.currentTimeMillis();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    logTime = timeFormatter.format(Long.valueOf(l));
    localObject = logFileFormatter.format(((Calendar)localObject).getTime());
    localObject = logPath + getLogFileName((String)localObject);
    if (!new File(logPath).exists()) {}
    while (!new File((String)localObject).exists()) {
      return false;
    }
    return true;
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.d(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.d(paramString1, str, paramThrowable);
    }
  }
  
  public static void d(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    if (paramThrowable == null) {}
    StringBuilder localStringBuilder;
    for (int i = 0;; i = 128)
    {
      localStringBuilder = new StringBuilder(i + k * 30);
      i = j;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
    }
    d(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    d(paramString, paramInt, null, paramVarArgs);
  }
  
  public static void doReportLogSelf(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    doReportLogSelf(paramInt, paramString1, paramString2, false, paramString3, paramString4);
  }
  
  public static void doReportLogSelf(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    int i = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("QLog", 0);
    long l = ((SharedPreferences)localObject).getLong("", -1L);
    if ((l == -1L) || (System.currentTimeMillis() - l > 3600000L))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
      i = 1;
    }
    if (i != 0)
    {
      paramString1 = new g(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
      paramString1.setName("doReportLogSelfThread");
      paramString1.start();
    }
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    e(paramString1, paramInt, paramString2, null);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.e(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.e(paramString1, str, paramThrowable);
    }
  }
  
  public static void e(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    if (paramThrowable == null) {}
    StringBuilder localStringBuilder;
    for (int i = 0;; i = 128)
    {
      localStringBuilder = new StringBuilder(i + k * 30);
      i = j;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(paramVarArgs[i].toString());
        i += 1;
      }
    }
    e(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString, int paramInt, Object... paramVarArgs)
  {
    e(paramString, paramInt, null, paramVarArgs);
  }
  
  public static void endColorLog(String[] paramArrayOfString, int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      colorTags.remove(str);
      i += 1;
    }
    if (paramBoolean) {
      doReportLogSelf(paramInt, "mobileqq", paramString1, paramString2, paramString3);
    }
  }
  
  public static void flushLog()
  {
    sWriteHandler.sendEmptyMessage(2);
    sWriteHandler.sendEmptyMessageDelayed(2, 20L);
    sWriteHandler.sendEmptyMessageDelayed(2, 80L);
    sWriteHandler.sendEmptyMessageDelayed(2, 160L);
    sWriteHandler.sendEmptyMessageDelayed(2, 320L);
  }
  
  public static void flushLog(boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (processName)
      {
        writeLogToFile();
        return;
      }
    }
    flushLog();
  }
  
  public static SimpleDateFormat getLogFileFormatter()
  {
    return logFileFormatter;
  }
  
  public static String getLogFileName(String paramString)
  {
    return processName.replace(":", "_") + "." + paramString + ".log";
  }
  
  public static String getLogPath()
  {
    return logPath;
  }
  
  public static String getReportLevel(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "E";
    case 2: 
      return "W";
    case 4: 
      return "D";
    }
    return "E";
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    return MsfSdkUtils.getStackTraceString(paramThrowable);
  }
  
  public static char[] getStringValue(StringBuilder paramStringBuilder)
  {
    try
    {
      if (sValueField == null)
      {
        sValueField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        sValueField.setAccessible(true);
      }
      paramStringBuilder = (char[])sValueField.get(paramStringBuilder);
      return paramStringBuilder;
    }
    catch (NoSuchFieldException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramStringBuilder)
    {
      for (;;)
      {
        paramStringBuilder.printStackTrace();
      }
    }
    catch (IllegalAccessException paramStringBuilder)
    {
      for (;;)
      {
        paramStringBuilder.printStackTrace();
      }
    }
  }
  
  public static int getUIN_REPORTLOG_LEVEL()
  {
    return UIN_REPORTLOG_LEVEL;
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    i(paramString1, paramInt, paramString2, null);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.i(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.i(paramString1, str, paramThrowable);
    }
  }
  
  public static void init(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    int i;
    if (sWriteHandler == null)
    {
      processName = paramString2;
      packageName = paramString1;
      sBuildNumber = paramString3;
      paramString1 = new HandlerThread("logWriteThread");
      paramString1.start();
      sWriteHandler = new c(paramString1.getLooper());
      sWriteHandler.sendEmptyMessageDelayed(1, paramLong);
      if (!isDevelopLevel()) {
        break label82;
      }
      i = 512;
    }
    for (;;)
    {
      sPool = new RecyclablePool(b.class, i);
      return;
      label82:
      if (isColorLevel()) {
        i = 256;
      } else {
        i = 128;
      }
    }
  }
  
  static void initLogFile(long paramLong)
    throws IOException
  {
    logPath = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + packageName.replace(".", "/") + "/";
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(paramLong);
    logTime = timeFormatter.format(Long.valueOf(paramLong));
    Object localObject2 = logFileFormatter.format(((Calendar)localObject1).getTime());
    currentLogFileName = (String)localObject2;
    ((Calendar)localObject1).set(14, 0);
    ((Calendar)localObject1).add(11, 1);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    nextHourTime = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = logPath + getLogFileName((String)localObject2);
    localObject2 = new File(logPath);
    for (;;)
    {
      try
      {
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject1 = new File((String)localObject1);
        try
        {
          if (!((File)localObject1).exists())
          {
            boolean bool = ((File)localObject1).createNewFile();
            localObject4 = localObject1;
            if (writer != null)
            {
              writer.write(logTime + "|" + processName + "|D||QQ_Version: " + sBuildNumber + "\r\n");
              writer.write(logTime + "|" + processName + "|D|" + "MSF.D.QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + " create newLogFile " + ((File)localObject1).getName() + " " + bool + "\n");
              writer.flush();
              localObject4 = localObject1;
            }
            if (writer != null)
            {
              writer.close();
              writer = null;
            }
            writer = new BufferedWriter(new h((File)localObject4, true), 8192);
            if (writer != null)
            {
              writer.write(logTime + "|" + processName + "|D||QQ_Version: " + sBuildNumber + "\r\n");
              writer.flush();
            }
            return;
          }
          localObject4 = localObject1;
          if (writer == null) {
            continue;
          }
          writer.write(logTime + "|" + processName + "|D||QQ_Version: " + sBuildNumber + "\r\n");
          writer.write(logTime + "|" + processName + "|E|" + "MSF.D.QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + "|newLogFile " + ((File)localObject1).getName() + " is existed.\n");
          writer.flush();
          localObject4 = localObject1;
          continue;
          localThrowable1.printStackTrace();
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        Object localObject4;
        localObject1 = localException;
        Object localObject3 = localThrowable2;
        continue;
      }
      localObject4 = localObject1;
      try
      {
        if (!TextUtils.isEmpty(processName))
        {
          localObject4 = localObject1;
          if (processName.endsWith("msf"))
          {
            localObject4 = new StringWriter();
            localThrowable1.printStackTrace(new PrintWriter((Writer)localObject4));
            String str = ((StringWriter)localObject4).toString();
            localObject4 = localObject1;
            if (MsfService.getCore() != null)
            {
              localObject4 = localObject1;
              if (MsfService.getCore().statReporter != null)
              {
                localObject4 = new HashMap();
                ((HashMap)localObject4).put("acount", MsfService.getCore().getAccountCenter().i());
                ((HashMap)localObject4).put("except", str);
                ((HashMap)localObject4).put("exceptMsg", "" + localThrowable1.getMessage());
                MsfService.getCore().statReporter.a("msfloginitexcpt", false, 0L, 0L, (Map)localObject4, false, false);
                localObject4 = localObject1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject4 = localObject1;
      }
    }
  }
  
  public static boolean initLogLevelForUnbindProcess(Context paramContext)
  {
    try
    {
      boolean bool = com.tencent.mobileqq.msf.core.h.a(paramContext, false);
      return bool;
    }
    catch (Exception paramContext)
    {
      e("MSF.D.QLog", 1, "initLogLevelForUnbindProcess error ", paramContext);
    }
    return false;
  }
  
  public static boolean isColorLevel()
  {
    return UIN_REPORTLOG_LEVEL > 1;
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static final boolean isDevelopLevel()
  {
    return UIN_REPORTLOG_LEVEL >= 4;
  }
  
  public static boolean isExistSDCard()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void p(String paramString1, String paramString2)
  {
    Log.d(paramString1, "[s]" + paramString2);
  }
  
  public static void setLogCallback(ILogCallback paramILogCallback)
  {
    sLogCallback = paramILogCallback;
  }
  
  public static void setManualLogLevel(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 4) && (UIN_REPORTLOG_LEVEL != paramInt))
    {
      UIN_REPORTLOG_LEVEL = paramInt;
      d("MSF.D.QLog", 1, Thread.currentThread().getName() + " set log level manual, " + UIN_REPORTLOG_LEVEL, new RuntimeException());
    }
  }
  
  /* Error */
  public static void setUIN_REPORTLOG_LEVEL(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 698	com/tencent/qphone/base/util/QLog:isExistSDCard	()Z
    //   3: ifeq +157 -> 160
    //   6: new 288	java/io/File
    //   9: dup
    //   10: getstatic 154	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   13: invokespecial 289	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 292	java/io/File:exists	()Z
    //   21: ifeq +238 -> 259
    //   24: aload_2
    //   25: invokevirtual 701	java/io/File:isFile	()Z
    //   28: ifeq +231 -> 259
    //   31: new 703	java/io/BufferedReader
    //   34: dup
    //   35: new 705	java/io/FileReader
    //   38: dup
    //   39: getstatic 154	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   42: invokespecial 706	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   45: invokespecial 709	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: invokevirtual 712	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: invokestatic 717	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   58: invokevirtual 720	java/lang/Integer:intValue	()I
    //   61: istore_1
    //   62: aload_3
    //   63: astore_2
    //   64: iload_1
    //   65: iconst_1
    //   66: if_icmplt +195 -> 261
    //   69: aload_3
    //   70: astore_2
    //   71: iload_1
    //   72: iconst_4
    //   73: if_icmpgt +188 -> 261
    //   76: aload_3
    //   77: astore_2
    //   78: iload_1
    //   79: putstatic 115	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   82: aload_3
    //   83: astore_2
    //   84: ldc 96
    //   86: iconst_1
    //   87: new 107	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   94: invokestatic 686	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   97: invokevirtual 687	java/lang/Thread:getName	()Ljava/lang/String;
    //   100: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 689
    //   106: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: iload_1
    //   110: invokevirtual 692	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 722	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 723	java/io/BufferedReader:close	()V
    //   127: return
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_3
    //   132: aload_3
    //   133: astore_2
    //   134: aload 4
    //   136: invokevirtual 585	java/lang/Throwable:printStackTrace	()V
    //   139: aload_3
    //   140: astore_2
    //   141: ldc 96
    //   143: iconst_1
    //   144: ldc_w 725
    //   147: aload 4
    //   149: invokestatic 365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 723	java/io/BufferedReader:close	()V
    //   160: iload_0
    //   161: iconst_1
    //   162: if_icmplt -35 -> 127
    //   165: iload_0
    //   166: iconst_4
    //   167: if_icmpgt -40 -> 127
    //   170: getstatic 115	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   173: iload_0
    //   174: if_icmpeq -47 -> 127
    //   177: iload_0
    //   178: putstatic 115	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   181: ldc 96
    //   183: iconst_1
    //   184: new 107	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   191: invokestatic 686	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   194: invokevirtual 687	java/lang/Thread:getName	()Ljava/lang/String;
    //   197: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 727
    //   203: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload_0
    //   207: invokevirtual 692	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: new 694	java/lang/RuntimeException
    //   216: dup
    //   217: invokespecial 695	java/lang/RuntimeException:<init>	()V
    //   220: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   223: return
    //   224: astore_3
    //   225: aconst_null
    //   226: astore_2
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 723	java/io/BufferedReader:close	()V
    //   235: aload_3
    //   236: athrow
    //   237: astore_2
    //   238: aload_2
    //   239: invokevirtual 728	java/io/IOException:printStackTrace	()V
    //   242: goto -7 -> 235
    //   245: astore_2
    //   246: aload_2
    //   247: invokevirtual 728	java/io/IOException:printStackTrace	()V
    //   250: goto -90 -> 160
    //   253: astore_2
    //   254: aload_2
    //   255: invokevirtual 728	java/io/IOException:printStackTrace	()V
    //   258: return
    //   259: aconst_null
    //   260: astore_2
    //   261: aload_2
    //   262: ifnull -102 -> 160
    //   265: aload_2
    //   266: invokevirtual 723	java/io/BufferedReader:close	()V
    //   269: goto -109 -> 160
    //   272: astore_2
    //   273: goto -27 -> 246
    //   276: astore_3
    //   277: goto -50 -> 227
    //   280: astore 4
    //   282: goto -150 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramInt	int
    //   61	49	1	i	int
    //   16	216	2	localObject1	Object
    //   237	2	2	localIOException1	IOException
    //   245	2	2	localIOException2	IOException
    //   253	2	2	localIOException3	IOException
    //   260	6	2	localObject2	Object
    //   272	1	2	localIOException4	IOException
    //   48	109	3	localBufferedReader	java.io.BufferedReader
    //   224	12	3	localObject3	Object
    //   276	1	3	localObject4	Object
    //   128	20	4	localThrowable1	Throwable
    //   280	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   6	49	128	java/lang/Throwable
    //   6	49	224	finally
    //   231	235	237	java/io/IOException
    //   156	160	245	java/io/IOException
    //   123	127	253	java/io/IOException
    //   265	269	272	java/io/IOException
    //   51	62	276	finally
    //   78	82	276	finally
    //   84	119	276	finally
    //   134	139	276	finally
    //   141	152	276	finally
    //   51	62	280	java/lang/Throwable
    //   78	82	280	java/lang/Throwable
    //   84	119	280	java/lang/Throwable
  }
  
  public static void startColorLog(String[] paramArrayOfString)
  {
    colorLogTime = System.currentTimeMillis();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      colorTags.add(str);
      i += 1;
    }
  }
  
  public static void syncReportLogSelf(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = paramString1 + "_" + getReportLevel(getUIN_REPORTLOG_LEVEL()) + ".zip";
    File localFile = new File(str);
    localFile.delete();
    try
    {
      localFile.createNewFile();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new a(paramString1));
      com.tencent.mobileqq.msf.core.h.a(localArrayList, str);
      com.tencent.mobileqq.msf.core.h.a(paramInt, str, paramString2, paramString3, paramString4, paramString5);
      localFile.delete();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      d("MSF.D.QLog", 1, "doReportLogSelf error " + paramString1);
    }
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    w(paramString1, paramInt, paramString2, null);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.w(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.w(paramString1, str, paramThrowable);
    }
  }
  
  private static boolean writeLogToFile()
  {
    boolean bool1 = false;
    b localb;
    try
    {
      if (writer == null) {
        return true;
      }
      Object localObject1;
      if ((isColorLevel()) && (BaseApplication.getContext() != null) && (System.currentTimeMillis() - lastPrintMemeoryTime > 180000L))
      {
        localObject1 = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
        ??? = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)???);
        d("MSF.D.QLog", 2, "availMem:" + ((ActivityManager.MemoryInfo)???).availMem / 1024L / 1024L + "M" + " lowThreshold:" + ((ActivityManager.MemoryInfo)???).threshold / 1024L / 1024L + "M");
        lastPrintMemeoryTime = System.currentTimeMillis();
      }
      if ((System.currentTimeMillis() - lastCheckLogFileTime > 180000L) && (!checkCurrentLogFileExists()))
      {
        lastCheckLogFileTime = System.currentTimeMillis();
        return true;
      }
      synchronized (processName)
      {
        localb = sTail;
        localObject1 = sHead;
        sTail = null;
        sHead = null;
        if (localObject1 == null) {
          return false;
        }
      }
      bool2 = bool1;
    }
    catch (Throwable localThrowable)
    {
      e("MSF.D.QLog", 1, "writeLogToFile Exeption", localThrowable);
      ??? = localThrowable.getMessage();
      if ((??? != null) && (!((String)???).contains("ENOSPC"))) {
        e("MSF.D.QLog", 1, localThrowable.getMessage());
      }
      return true;
    }
    for (;;)
    {
      boolean bool2;
      if (!bool1)
      {
        bool2 = bool1;
        if (localThrowable.a > nextHourTime) {
          bool2 = true;
        }
      }
      long l = localThrowable.a;
      if ((l >= currentLogSecond + 1000L) || (l < currentLogSecond))
      {
        logTime = MsfSdkUtils.timeFormatter.format(Long.valueOf(l));
        if ((l >= currentLogSecond + 1000L) && (l < currentLogSecond + 2000L)) {
          currentLogSecond += 1000L;
        }
      }
      else
      {
        ??? = sBuilder.delete(0, sBuilder.length());
        ((StringBuilder)???).append(logTime).append('|').append(localThrowable.a).append('[').append(myProcessId).append(']').append(localThrowable.b).append('|').append(getReportLevel(localThrowable.c)).append('|').append(localThrowable.d).append('|').append(localThrowable.e).append('\n');
        if ((sValues == null) || (sValues.length != ((StringBuilder)???).capacity())) {
          sValues = getStringValue((StringBuilder)???);
        }
        if (sValues == null) {
          break label632;
        }
        writer.write(sValues, 0, ((StringBuilder)???).length());
      }
      for (;;)
      {
        if (sLogCallback != null) {
          sLogCallback.onWriteLog(localThrowable.d, localThrowable.e);
        }
        if (localThrowable.f != null)
        {
          writer.write(Log.getStackTraceString(localThrowable.f));
          writer.write(10);
        }
        ??? = (b)localThrowable.getNext();
        sPool.recycle(localThrowable);
        if (localThrowable != localb) {
          break label646;
        }
        writer.flush();
        return bool2;
        ??? = Calendar.getInstance();
        ((Calendar)???).setTimeInMillis(l);
        ((Calendar)???).set(14, 0);
        currentLogSecond = ((Calendar)???).getTimeInMillis();
        break;
        label632:
        writer.write(((StringBuilder)???).toString());
      }
      label646:
      Object localObject3 = ???;
      bool1 = bool2;
    }
  }
  
  public static abstract interface ILogCallback
  {
    public abstract void onWriteLog(String paramString1, String paramString2);
  }
  
  public static class a
    extends File
  {
    public String a = "";
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
    
    public a(String paramString)
    {
      super();
    }
  }
  
  public static class b
    extends RecyclablePool.Recyclable
  {
    public long a;
    public int b;
    public int c;
    public String d;
    public String e;
    public Throwable f;
    
    public void recycle()
    {
      super.recycle();
      this.a = 0L;
      this.b = 0;
      this.c = 0;
      this.d = "";
      this.e = "";
      this.f = null;
    }
  }
  
  static class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: ldc2_w 17
      //   3: lstore 4
      //   5: aload_1
      //   6: getfield 24	android/os/Message:what	I
      //   9: tableswitch	default:+27 -> 36, 1:+28->37, 2:+241->250, 3:+62->71
      //   37: ldc 26
      //   39: ldc 28
      //   41: invokestatic 34	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   44: pop
      //   45: invokestatic 40	java/lang/System:currentTimeMillis	()J
      //   48: invokestatic 44	com/tencent/qphone/base/util/QLog:initLogFile	(J)V
      //   51: iconst_0
      //   52: invokestatic 48	com/tencent/qphone/base/util/QLog:access$002	(I)I
      //   55: pop
      //   56: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   59: iconst_2
      //   60: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   63: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   66: iconst_2
      //   67: invokevirtual 60	com/tencent/qphone/base/util/QLog$c:sendEmptyMessage	(I)Z
      //   70: pop
      //   71: invokestatic 64	com/tencent/qphone/base/util/QLog:access$000	()I
      //   74: ifle -38 -> 36
      //   77: ldc 26
      //   79: ldc 66
      //   81: invokestatic 34	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   84: pop
      //   85: invokestatic 70	com/tencent/qphone/base/util/QLog:access$200	()Ljava/lang/String;
      //   88: astore_1
      //   89: aload_1
      //   90: monitorenter
      //   91: aconst_null
      //   92: invokestatic 74	com/tencent/qphone/base/util/QLog:access$402	(Lcom/tencent/qphone/base/util/QLog$b;)Lcom/tencent/qphone/base/util/QLog$b;
      //   95: invokestatic 77	com/tencent/qphone/base/util/QLog:access$302	(Lcom/tencent/qphone/base/util/QLog$b;)Lcom/tencent/qphone/base/util/QLog$b;
      //   98: pop
      //   99: aload_1
      //   100: monitorexit
      //   101: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   104: iconst_3
      //   105: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   108: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   111: iconst_3
      //   112: ldc2_w 17
      //   115: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   118: pop
      //   119: return
      //   120: astore_1
      //   121: aload_1
      //   122: invokevirtual 85	java/lang/Exception:printStackTrace	()V
      //   125: invokestatic 64	com/tencent/qphone/base/util/QLog:access$000	()I
      //   128: istore_2
      //   129: ldc 26
      //   131: new 87	java/lang/StringBuilder
      //   134: dup
      //   135: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   138: ldc 28
      //   140: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: iload_2
      //   144: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   147: ldc 98
      //   149: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   152: invokestatic 102	com/tencent/qphone/base/util/QLog:access$100	()[I
      //   155: iload_2
      //   156: iaload
      //   157: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   160: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   163: invokestatic 34	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   166: pop
      //   167: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   170: iconst_1
      //   171: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   174: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   177: iconst_1
      //   178: invokestatic 102	com/tencent/qphone/base/util/QLog:access$100	()[I
      //   181: iload_2
      //   182: iaload
      //   183: ldc 106
      //   185: imul
      //   186: i2l
      //   187: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   190: pop
      //   191: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   194: iconst_3
      //   195: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   198: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   201: astore_1
      //   202: invokestatic 64	com/tencent/qphone/base/util/QLog:access$000	()I
      //   205: ifne +8 -> 213
      //   208: ldc2_w 107
      //   211: lstore 4
      //   213: aload_1
      //   214: iconst_3
      //   215: lload 4
      //   217: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   220: pop
      //   221: iload_2
      //   222: iconst_1
      //   223: iadd
      //   224: istore_3
      //   225: iload_3
      //   226: istore_2
      //   227: iload_3
      //   228: invokestatic 102	com/tencent/qphone/base/util/QLog:access$100	()[I
      //   231: arraylength
      //   232: if_icmplt +5 -> 237
      //   235: iconst_1
      //   236: istore_2
      //   237: iload_2
      //   238: invokestatic 48	com/tencent/qphone/base/util/QLog:access$002	(I)I
      //   241: pop
      //   242: return
      //   243: astore 6
      //   245: aload_1
      //   246: monitorexit
      //   247: aload 6
      //   249: athrow
      //   250: invokestatic 112	com/tencent/qphone/base/util/QLog:access$500	()Z
      //   253: ifeq +22 -> 275
      //   256: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   259: iconst_1
      //   260: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   263: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   266: iconst_1
      //   267: ldc2_w 113
      //   270: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   273: pop
      //   274: return
      //   275: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   278: iconst_2
      //   279: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   282: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   285: iconst_2
      //   286: ldc2_w 113
      //   289: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   292: pop
      //   293: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	294	0	this	c
      //   128	110	2	i	int
      //   224	9	3	j	int
      //   3	213	4	l	long
      //   243	5	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   37	71	120	java/lang/Exception
      //   91	101	243	finally
      //   245	247	243	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog
 * JD-Core Version:    0.7.0.1
 */