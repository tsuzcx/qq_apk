package com.tencent.qphone.base.util;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.a.a.c;
import com.tencent.qphone.base.util.a.b.e;
import com.tencent.qphone.base.util.a.d.d.a;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class QLog
{
  private static final int BYTES_CONTENT = 1;
  public static final int CLR = 2;
  public static final int DEV = 4;
  private static final int[] INTERVAL_RETRY_INIT;
  private static final String LOG_HOOK_PREFIX_TAG = "log_hook_pre_";
  public static final String MSF_IS_COLOR_LEVEL = "QLogConfig_B";
  private static final int MSG_CLEAR = 3;
  private static final int MSG_INIT_WRITER = 1;
  private static final int MSG_WRITE = 2;
  private static final String[] PERMS = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  public static final String QLOG_BEAN_CONF_SWITCH = "QLogConfig_C";
  private static final String QlogSpTag = "QLog";
  private static final String ReportLogSelfTimeTag = "";
  private static final int STRING_CONTENT = 0;
  public static final String TAG_REPORTLEVEL_COLORUSER = "W";
  public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
  public static final String TAG_REPORTLEVEL_USER = "E";
  private static int UIN_REPORTLOG_LEVEL = 0;
  public static final int USR = 1;
  public static final int _DEFAULT_REPORTLOG_LEVEL = 1;
  static long colorLogTime = 0L;
  static HashSet colorTags;
  private static boolean compressAndEncrypt = false;
  private static String currentLogFileName;
  private static long currentLogSecond = 0L;
  protected static final boolean isDebug = false;
  protected static boolean isLogToFile = false;
  private static long lastCheckLogFileTime = 0L;
  private static long lastPrintMemeoryTime = 0L;
  public static final Charset logCharset;
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
  static String sBuildNumber;
  private static ThreadLocal sBuilderLocal;
  private static boolean sHasStoragePermission = false;
  private static QLog.c sHead;
  public static long sInitLogTime = 0L;
  private static QLog.ILogCallback sLogCallback;
  public static boolean sLogcatHooked = false;
  private static QLog.b sOnPrintlnCallback;
  private static RecyclablePool sPool;
  private static QLog.c sTail;
  static Field sValueField;
  private static char[] sValues;
  static QLog.d sWriteHandler;
  private static final String tag = "MSF.D.QLog";
  static SimpleDateFormat timeFormatter;
  private static boolean useNewLog = false;
  static byte[] wrapBytes;
  private static com.tencent.qphone.base.util.a.a writer;
  
  static
  {
    compressAndEncrypt = false;
    sLogCallback = null;
    isLogToFile = true;
    sHead = null;
    sTail = null;
    sLogcatHooked = false;
    sBuildNumber = "";
    logCharset = Charset.forName("UTF-8");
    sBuilderLocal = new ThreadLocal();
    sValues = null;
    sValueField = null;
    UIN_REPORTLOG_LEVEL = 1;
    logPath = "";
    currentLogFileName = "";
    processName = "";
    packageName = "";
    myProcessId = Process.myPid();
    lastPrintMemeoryTime = 0L;
    lastCheckLogFileTime = 0L;
    manualLogLevelPath = Environment.getExternalStorageDirectory() + "/mqqLogLevel";
    INTERVAL_RETRY_INIT = new int[] { 1, 1, 1, 2, 2, 4, 4, 8, 16, 29 };
    retryInitTimes = 0;
    logTime = "";
    logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");
    timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    sInitLogTime = 0L;
    colorTags = new HashSet();
    colorLogTime = 0L;
  }
  
  private static void addLogItem(String arg0, int paramInt1, int paramInt2, String paramString2, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    long l = System.currentTimeMillis();
    if ((colorLogTime != 0L) && (l - colorLogTime > 1800000L))
    {
      colorLogTime = 0L;
      colorTags.clear();
    }
    QLog.c localc = (QLog.c)sPool.obtain(QLog.c.class);
    if (localc == null)
    {
      Log.e("QLog", "addLogItem obtain return null");
      return;
    }
    localc.a = l;
    localc.b = Process.myTid();
    localc.c = paramInt1;
    localc.d = ???;
    localc.f = paramString2;
    localc.h = paramArrayOfByte;
    localc.e = paramInt2;
    localc.g = paramThrowable;
    for (;;)
    {
      synchronized (processName)
      {
        if (sHead == null)
        {
          sHead = localc;
          sTail = localc;
          return;
        }
      }
      sTail.changeNext(localc, true);
      sTail = localc;
    }
  }
  
  private static void addLogItem(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    addLogItem(paramString1, paramInt, 0, paramString2, null, paramThrowable);
  }
  
  private static void addLogItem(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    addLogItem(paramString, paramInt, 1, "", paramArrayOfByte, paramThrowable);
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
  
  private static com.tencent.qphone.base.util.a.a createJavaMmapLogAppender(int paramInt, boolean paramBoolean, File paramFile1, File paramFile2)
  {
    return new d.a().b(paramFile1.getAbsolutePath()).a(paramInt).a(paramBoolean).b(paramBoolean).a(paramFile2.getAbsolutePath()).a();
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    int j = 0;
    int i;
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      i = 1;
      if ((i != 0) || (useNewLog)) {
        j = 1;
      }
      if (j != 0)
      {
        str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        if (i != 0)
        {
          paramString2 = getTag(paramString1);
          if (paramThrowable != null) {
            break label96;
          }
          Log.d(paramString2, str);
          onPrintln(3, paramString2, str);
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      i = 0;
      break;
      label96:
      Log.d(paramString2, str, paramThrowable);
      onPrintln(3, paramString2, str);
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
  
  public static void d(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int k = 1;
    int i;
    int j;
    label42:
    byte[] arrayOfByte;
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString)))
    {
      i = 1;
      j = k;
      if (i == 0)
      {
        if (!useNewLog) {
          break label116;
        }
        j = k;
      }
      if (j != 0)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          arrayOfByte = new byte[0];
        }
        if (i != 0)
        {
          paramArrayOfByte = getTag(paramString);
          str = new String(arrayOfByte, logCharset);
          if (paramThrowable != null) {
            break label122;
          }
          Log.d(paramArrayOfByte, str);
          onPrintln(3, paramArrayOfByte, str);
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
      return;
      i = 0;
      break;
      label116:
      j = 0;
      break label42;
      label122:
      Log.d(paramArrayOfByte, str, paramThrowable);
      onPrintln(3, paramArrayOfByte, str, paramThrowable);
    }
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
      paramString1 = new i(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
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
    int j = 0;
    int i;
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      i = 1;
      if ((i != 0) || (useNewLog)) {
        j = 1;
      }
      if (j != 0)
      {
        str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        if (i != 0)
        {
          if (paramThrowable != null) {
            break label87;
          }
          Log.e(getTag(paramString1), str);
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      i = 0;
      break;
      label87:
      Log.e(getTag(paramString1), str, paramThrowable);
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
        Object localObject = paramVarArgs[i];
        if (localObject != null) {
          localStringBuilder.append(localObject.toString());
        }
        i += 1;
      }
    }
    e(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int k = 1;
    int i;
    int j;
    label42:
    byte[] arrayOfByte;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString)))
    {
      i = 1;
      j = k;
      if (i == 0)
      {
        if (!useNewLog) {
          break label103;
        }
        j = k;
      }
      if (j != 0)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          arrayOfByte = new byte[0];
        }
        if (i != 0)
        {
          if (paramThrowable != null) {
            break label109;
          }
          Log.e(getTag(paramString), new String(arrayOfByte, logCharset));
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
      return;
      i = 0;
      break;
      label103:
      j = 0;
      break label42;
      label109:
      Log.e(getTag(paramString), new String(arrayOfByte, logCharset), paramThrowable);
    }
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
  
  public static String getLogExternalPath(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (!isHasStoragePermission(paramContext))) {
      return localFile.getPath();
    }
    return Environment.getExternalStorageDirectory().getPath();
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
  
  private static String getTag(String paramString)
  {
    String str = paramString;
    if (sLogcatHooked) {
      str = "log_hook_pre_" + paramString;
    }
    return str;
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
    int j = 0;
    int i;
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      i = 1;
      if ((i != 0) || (useNewLog)) {
        j = 1;
      }
      if (j != 0)
      {
        str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        if (i != 0)
        {
          if (paramThrowable != null) {
            break label87;
          }
          Log.i(getTag(paramString1), str);
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      i = 0;
      break;
      label87:
      Log.i(getTag(paramString1), str, paramThrowable);
    }
  }
  
  public static void i(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int k = 1;
    int i;
    int j;
    label42:
    byte[] arrayOfByte;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString)))
    {
      i = 1;
      j = k;
      if (i == 0)
      {
        if (!useNewLog) {
          break label103;
        }
        j = k;
      }
      if (j != 0)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          arrayOfByte = new byte[0];
        }
        if (i != 0)
        {
          if (paramThrowable != null) {
            break label109;
          }
          Log.i(getTag(paramString), new String(arrayOfByte, logCharset));
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
      return;
      i = 0;
      break;
      label103:
      j = 0;
      break label42;
      label109:
      Log.i(getTag(paramString), new String(arrayOfByte, logCharset), paramThrowable);
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
      sWriteHandler = new QLog.d(paramString1.getLooper());
      sWriteHandler.sendEmptyMessageDelayed(1, paramLong);
      if (!isDevelopLevel()) {
        break label83;
      }
      i = 512;
    }
    for (;;)
    {
      sPool = new RecyclablePool(QLog.c.class, i);
      return;
      label83:
      if (isColorLevel()) {
        i = 256;
      } else {
        i = 128;
      }
    }
  }
  
  static void initLogFile(long paramLong)
  {
    logPath = getLogExternalPath(BaseApplication.context) + "/tencent/msflogs/" + packageName.replace(".", "/") + "/";
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(paramLong);
    logTime = timeFormatter.format(Long.valueOf(paramLong));
    Object localObject3 = logFileFormatter.format(((Calendar)localObject1).getTime());
    currentLogFileName = (String)localObject3;
    ((Calendar)localObject1).set(14, 0);
    ((Calendar)localObject1).add(11, 1);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    nextHourTime = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = logPath + getLogFileName((String)localObject3);
    String str1 = logPath + getLogFileName("mmapCacheLog");
    localObject3 = new File(logPath);
    File localFile = new File(str1);
    for (;;)
    {
      try
      {
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        localObject1 = new File((String)localObject1);
        try
        {
          sInitLogTime = System.currentTimeMillis();
          if (!((File)localObject1).exists())
          {
            boolean bool = ((File)localObject1).createNewFile();
            localObject3 = localObject1;
            if (writer != null)
            {
              writer.write(logTime + "|" + processName + "|D||QQ_Version: " + sBuildNumber + "\r\n");
              writer.write(logTime + "|" + processName + "|D|" + "MSF.D.QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + " create newLogFile " + ((File)localObject1).getName() + " " + bool + "\n");
              writer.flush();
              localObject3 = localObject1;
            }
            if (writer != null)
            {
              writer.close();
              writer = null;
            }
          }
        }
        catch (Throwable localThrowable2) {}
      }
      catch (Throwable localThrowable3)
      {
        Object localObject4;
        Object localObject2 = localObject4;
        continue;
      }
      try
      {
        localObject1 = c.a(e.b());
        if ((!new File(logPath + "QLogConfig_B").exists()) && (!new File(logPath + "QLogConfig_C").exists())) {}
        d("init_log", 1, new Object[] { "useNewLog ", Boolean.valueOf(useNewLog), " MSF=", Boolean.valueOf(new File(logPath + "QLogConfig_B").exists()), " QLogBean=", Boolean.valueOf(new File(logPath + "QLogConfig_C").exists()), " isGrayVersion|DebugVersion=", Boolean.valueOf(false), Boolean.valueOf(isDebugVersion()), " EncryptedKey", Boolean.valueOf(TextUtils.isEmpty((CharSequence)localObject1)) });
      }
      catch (Throwable localThrowable1)
      {
        Log.d("MSF.D.QLog", "QLog useNewLog Init Fail," + localThrowable1);
        continue;
        writer = new com.tencent.qphone.base.util.a.d.a(new j(localObject4, true), 8192);
        continue;
      }
      if (!useNewLog) {
        continue;
      }
      writer = createJavaMmapLogAppender(8192, true, (File)localObject3, localFile);
      if (writer != null)
      {
        writer.write(logTime + "|" + processName + "|D||QQ_Version: " + sBuildNumber + "\r\n");
        writer.flush();
      }
      return;
      localObject3 = localObject1;
      if (writer != null)
      {
        writer.write(logTime + "|" + processName + "|D||QQ_Version: " + sBuildNumber + "\r\n");
        writer.write(logTime + "|" + processName + "|E|" + "MSF.D.QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + "|newLogFile " + ((File)localObject1).getName() + " is existed.\n");
        writer.flush();
        localObject3 = localObject1;
        continue;
        localThrowable2.printStackTrace();
        localObject3 = localObject1;
        try
        {
          if (!TextUtils.isEmpty(processName))
          {
            localObject3 = localObject1;
            if (processName.endsWith("msf"))
            {
              localObject3 = new StringWriter();
              localThrowable2.printStackTrace(new PrintWriter((Writer)localObject3));
              String str2 = ((StringWriter)localObject3).toString();
              localObject3 = localObject1;
              if (MsfService.getCore() != null)
              {
                localObject3 = localObject1;
                if (MsfService.getCore().statReporter != null)
                {
                  localObject3 = new HashMap();
                  ((HashMap)localObject3).put("acount", MsfService.getCore().getAccountCenter().i());
                  ((HashMap)localObject3).put("except", str2);
                  ((HashMap)localObject3).put("exceptMsg", "" + localThrowable2.getMessage());
                  MsfService.getCore().statReporter.a("msfloginitexcpt", false, 0L, 0L, (Map)localObject3, false, false);
                  localObject3 = localObject1;
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
  }
  
  public static boolean initLogLevelForUnbindProcess(Context paramContext)
  {
    try
    {
      boolean bool = com.tencent.mobileqq.msf.core.i.a(paramContext, false);
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
    return (UIN_REPORTLOG_LEVEL > 1) || (useNewLog);
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
  
  public static boolean isHasStoragePermission(Context paramContext)
  {
    boolean bool2 = sHasStoragePermission;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label48;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(PERMS[0]) == 0)
        {
          sHasStoragePermission = true;
          bool1 = sHasStoragePermission;
        }
      }
    }
    return bool1;
    label48:
    sHasStoragePermission = true;
    return sHasStoragePermission;
  }
  
  private static void onPrintln(int paramInt, String paramString1, String paramString2)
  {
    QLog.b localb = sOnPrintlnCallback;
    if (localb != null) {
      localb.a(paramInt, paramString1, paramString2);
    }
  }
  
  private static void onPrintln(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.b localb = sOnPrintlnCallback;
    if (localb != null) {
      localb.a(paramInt, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void p(String paramString1, String paramString2)
  {
    Log.d(getTag(paramString1), "[s]" + paramString2);
  }
  
  public static void setLogCallback(QLog.ILogCallback paramILogCallback)
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
  
  public static void setOnPrintlnCallback(QLog.b paramb)
  {
    sOnPrintlnCallback = paramb;
  }
  
  /* Error */
  public static void setUIN_REPORTLOG_LEVEL(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 871	com/tencent/qphone/base/util/QLog:isExistSDCard	()Z
    //   3: ifeq +141 -> 144
    //   6: new 351	java/io/File
    //   9: dup
    //   10: getstatic 196	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   13: invokespecial 352	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 355	java/io/File:exists	()Z
    //   21: ifeq +113 -> 134
    //   24: aload_2
    //   25: invokevirtual 874	java/io/File:isFile	()Z
    //   28: ifeq +106 -> 134
    //   31: new 876	java/io/BufferedReader
    //   34: dup
    //   35: new 878	java/io/FileReader
    //   38: dup
    //   39: getstatic 196	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   42: invokespecial 879	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   45: invokespecial 882	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: invokevirtual 885	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: invokestatic 890	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   58: invokevirtual 893	java/lang/Integer:intValue	()I
    //   61: istore_1
    //   62: aload_3
    //   63: astore_2
    //   64: iload_1
    //   65: iconst_1
    //   66: if_icmplt +70 -> 136
    //   69: aload_3
    //   70: astore_2
    //   71: iload_1
    //   72: iconst_4
    //   73: if_icmpgt +63 -> 136
    //   76: aload_3
    //   77: astore_2
    //   78: iload_1
    //   79: putstatic 152	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   82: aload_3
    //   83: astore_2
    //   84: ldc 105
    //   86: iconst_1
    //   87: new 174	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   94: invokestatic 855	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   97: invokevirtual 856	java/lang/Thread:getName	()Ljava/lang/String;
    //   100: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 858
    //   106: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: iload_1
    //   110: invokevirtual 861	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 895	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 896	java/io/BufferedReader:close	()V
    //   127: return
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 897	java/io/IOException:printStackTrace	()V
    //   133: return
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 896	java/io/BufferedReader:close	()V
    //   144: iload_0
    //   145: iconst_1
    //   146: if_icmplt -19 -> 127
    //   149: iload_0
    //   150: iconst_4
    //   151: if_icmpgt -24 -> 127
    //   154: getstatic 152	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   157: iload_0
    //   158: if_icmpeq -31 -> 127
    //   161: iload_0
    //   162: putstatic 152	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   165: ldc 105
    //   167: iconst_1
    //   168: new 174	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   175: invokestatic 855	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   178: invokevirtual 856	java/lang/Thread:getName	()Ljava/lang/String;
    //   181: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 899
    //   187: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_0
    //   191: invokevirtual 861	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: new 863	java/lang/RuntimeException
    //   200: dup
    //   201: invokespecial 864	java/lang/RuntimeException:<init>	()V
    //   204: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: return
    //   208: astore_2
    //   209: aload_2
    //   210: invokevirtual 897	java/io/IOException:printStackTrace	()V
    //   213: goto -69 -> 144
    //   216: astore 4
    //   218: aconst_null
    //   219: astore_3
    //   220: aload_3
    //   221: astore_2
    //   222: aload 4
    //   224: invokevirtual 736	java/lang/Throwable:printStackTrace	()V
    //   227: aload_3
    //   228: astore_2
    //   229: ldc 105
    //   231: iconst_1
    //   232: ldc_w 901
    //   235: aload 4
    //   237: invokestatic 470	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload_3
    //   241: ifnull -97 -> 144
    //   244: aload_3
    //   245: invokevirtual 896	java/io/BufferedReader:close	()V
    //   248: goto -104 -> 144
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 897	java/io/IOException:printStackTrace	()V
    //   256: goto -112 -> 144
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_2
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 896	java/io/BufferedReader:close	()V
    //   270: aload_3
    //   271: athrow
    //   272: astore_2
    //   273: aload_2
    //   274: invokevirtual 897	java/io/IOException:printStackTrace	()V
    //   277: goto -7 -> 270
    //   280: astore_3
    //   281: goto -19 -> 262
    //   284: astore 4
    //   286: goto -66 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramInt	int
    //   61	49	1	i	int
    //   16	68	2	localObject1	Object
    //   128	2	2	localIOException1	IOException
    //   135	6	2	localObject2	Object
    //   208	2	2	localIOException2	IOException
    //   221	8	2	localObject3	Object
    //   251	2	2	localIOException3	IOException
    //   261	6	2	localObject4	Object
    //   272	2	2	localIOException4	IOException
    //   48	197	3	localBufferedReader	java.io.BufferedReader
    //   259	12	3	localObject5	Object
    //   280	1	3	localObject6	Object
    //   216	20	4	localThrowable1	Throwable
    //   284	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   123	127	128	java/io/IOException
    //   140	144	208	java/io/IOException
    //   6	49	216	java/lang/Throwable
    //   244	248	251	java/io/IOException
    //   6	49	259	finally
    //   266	270	272	java/io/IOException
    //   51	62	280	finally
    //   78	82	280	finally
    //   84	119	280	finally
    //   222	227	280	finally
    //   229	240	280	finally
    //   51	62	284	java/lang/Throwable
    //   78	82	284	java/lang/Throwable
    //   84	119	284	java/lang/Throwable
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
      localArrayList.add(new QLog.a(paramString1));
      com.tencent.mobileqq.msf.core.i.a(localArrayList, str);
      com.tencent.mobileqq.msf.core.i.a(paramInt, str, paramString2, paramString3, paramString4, paramString5);
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
    int j = 0;
    int i;
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      i = 1;
      if ((i != 0) || (useNewLog)) {
        j = 1;
      }
      if (j != 0)
      {
        str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        if (i != 0)
        {
          if (paramThrowable != null) {
            break label87;
          }
          Log.w(getTag(paramString1), str);
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      i = 0;
      break;
      label87:
      Log.w(getTag(paramString1), str, paramThrowable);
    }
  }
  
  public static void w(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int k = 1;
    int i;
    int j;
    label42:
    byte[] arrayOfByte;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString)))
    {
      i = 1;
      j = k;
      if (i == 0)
      {
        if (!useNewLog) {
          break label103;
        }
        j = k;
      }
      if (j != 0)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          arrayOfByte = new byte[0];
        }
        if (i != 0)
        {
          if (paramThrowable != null) {
            break label109;
          }
          Log.w(getTag(paramString), new String(arrayOfByte, logCharset));
        }
      }
    }
    for (;;)
    {
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
      return;
      i = 0;
      break;
      label103:
      j = 0;
      break label42;
      label109:
      Log.w(getTag(paramString), new String(arrayOfByte, logCharset), paramThrowable);
    }
  }
  
  private static boolean writeLogToFile()
  {
    boolean bool1 = false;
    QLog.c localc;
    try
    {
      if ((wrapBytes == null) || (wrapBytes.length == 0)) {
        wrapBytes = String.valueOf('\n').getBytes("UTF-8");
      }
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
        localc = sTail;
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
        StringBuilder localStringBuilder = (StringBuilder)sBuilderLocal.get();
        ??? = localStringBuilder;
        if (localStringBuilder == null)
        {
          ??? = new StringBuilder(10240);
          sBuilderLocal.set(???);
        }
        ((StringBuilder)???).setLength(0);
        if (localThrowable.e != 1) {
          break label705;
        }
        ((StringBuilder)???).append(logTime).append('|').append(localThrowable.a).append('[').append(myProcessId).append(']').append(localThrowable.b).append('|').append(getReportLevel(localThrowable.c)).append('|').append(localThrowable.d).append('|');
        sValues = getStringValue((StringBuilder)???);
        writer.write(sValues, 0, ((StringBuilder)???).length());
        writer.a(localThrowable.h, 0, localThrowable.h.length);
        writer.a(wrapBytes, 0, wrapBytes.length);
        if (sLogCallback != null) {
          sLogCallback.onWriteLog(localThrowable.d, localThrowable.h);
        }
      }
      label705:
      label888:
      for (;;)
      {
        if (localThrowable.g != null)
        {
          writer.write(Log.getStackTraceString(localThrowable.g));
          writer.write(10);
        }
        ??? = (QLog.c)localThrowable.getNext();
        sPool.recycle(localThrowable);
        if (localThrowable != localc) {
          break label890;
        }
        writer.flush();
        return bool2;
        ??? = Calendar.getInstance();
        ((Calendar)???).setTimeInMillis(l);
        ((Calendar)???).set(14, 0);
        currentLogSecond = ((Calendar)???).getTimeInMillis();
        break;
        ((StringBuilder)???).append(logTime).append('|').append(localThrowable.a).append('[').append(myProcessId).append(']').append(localThrowable.b).append('|').append(getReportLevel(localThrowable.c)).append('|').append(localThrowable.d).append('|').append(localThrowable.f).append('\n');
        if ((sValues == null) || (sValues.length != ((StringBuilder)???).capacity())) {
          sValues = getStringValue((StringBuilder)???);
        }
        if (sValues != null) {
          writer.write(sValues, 0, ((StringBuilder)???).length());
        }
        for (;;)
        {
          if (sLogCallback == null) {
            break label888;
          }
          sLogCallback.onWriteLog(localThrowable.d, localThrowable.f);
          break;
          writer.write(((StringBuilder)???).toString());
        }
      }
      label890:
      Object localObject3 = ???;
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog
 * JD-Core Version:    0.7.0.1
 */