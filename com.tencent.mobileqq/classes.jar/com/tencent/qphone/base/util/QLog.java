package com.tencent.qphone.base.util;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.log.ILogWriter;
import com.tencent.qphone.base.util.log.QLogWriter;
import com.tencent.qphone.base.util.log.RecyclablePool;
import com.tencent.qphone.base.util.log.encrypt.XorKey;
import com.tencent.qphone.base.util.log.processor.XOREncryption;
import com.tencent.qphone.base.util.log.wrapper.BufferWriterWrapper;
import com.tencent.qphone.base.util.log.wrapper.MmapLogWrapper.Builder;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;

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
  private static final String QlogSpTag = "QLog";
  private static final String ReportLogSelfTimeTag = "";
  private static final int STRING_CONTENT = 0;
  public static final String TAG_REPORTLEVEL_COLORUSER = "W";
  public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
  public static final String TAG_REPORTLEVEL_USER = "E";
  private static int UIN_REPORTLOG_LEVEL = 0;
  public static final int USR = 1;
  public static int _DEFAULT_REPORTLOG_LEVEL = 0;
  static long colorLogTime = 0L;
  static HashSet<String> colorTags;
  private static boolean compressAndEncrypt = false;
  private static String currentLogFileName;
  private static long currentLogSecond = 0L;
  private static boolean fullEncryptedLogMode = false;
  protected static boolean isDebug = false;
  private static long lastCheckLogFileTime = 0L;
  private static long lastPrintMemeoryTime = 0L;
  private static final Charset logCharset;
  static SimpleDateFormat logFileFormatter;
  public static final String logLevelHead = "LOGLEVEL_";
  public static final String logLevelTime = "LOGLEVELTIME";
  private static String logPath;
  private static String logTime;
  private static String manualLogLevelPath;
  private static final int myProcessId;
  private static long nextHourTime = 0L;
  private static String packageName;
  private static String processName;
  private static int retryInitTimes = 0;
  private static Context sAppContext;
  static String sBuildNumber;
  private static ThreadLocal<StringBuilder> sBuilderLocal;
  private static boolean sHasStoragePermission = false;
  private static QLog.QLogItem sHead;
  private static long sInitLogTime = 0L;
  private static QLog.ILogCallback sLogCallback;
  public static boolean sLogcatHooked = false;
  private static QLog.OnPrintlnCallback sOnPrintlnCallback;
  private static RecyclablePool sPool;
  private static QLog.QLogItem sTail;
  static Field sValueField;
  private static char[] sValues;
  static QLog.WriteHandler sWriteHandler;
  private static final String tag = "QLog";
  static SimpleDateFormat timeFormatter;
  private static boolean useNewLog = false;
  static byte[] wrapBytes;
  private static ILogWriter writer;
  
  static
  {
    compressAndEncrypt = false;
    sLogCallback = null;
    isDebug = false;
    sHead = null;
    sTail = null;
    sLogcatHooked = false;
    sBuildNumber = "";
    logCharset = Charset.forName("UTF-8");
    sBuilderLocal = new ThreadLocal();
    sValues = null;
    sValueField = null;
    _DEFAULT_REPORTLOG_LEVEL = 4;
    UIN_REPORTLOG_LEVEL = _DEFAULT_REPORTLOG_LEVEL;
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
    QLog.QLogItem localQLogItem = (QLog.QLogItem)sPool.obtain(QLog.QLogItem.class);
    if (localQLogItem == null)
    {
      Log.e("QLog", "addLogItem obtain return null");
      return;
    }
    localQLogItem.logTime = l;
    localQLogItem.threadId = Process.myTid();
    localQLogItem.level = paramInt1;
    localQLogItem.tag = ???;
    localQLogItem.msg = paramString2;
    localQLogItem.msgBytes = paramArrayOfByte;
    localQLogItem.contentType = paramInt2;
    localQLogItem.trace = paramThrowable;
    for (;;)
    {
      synchronized (processName)
      {
        if (sHead == null)
        {
          sHead = localQLogItem;
          sTail = localQLogItem;
          return;
        }
      }
      sTail.changeNext(localQLogItem, true);
      sTail = localQLogItem;
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
  
  private static ILogWriter createJavaMmapLogAppender(int paramInt, boolean paramBoolean, File paramFile1, File paramFile2)
  {
    return new MmapLogWrapper.Builder().setLogFilePath(paramFile1.getAbsolutePath()).setBufferSize(paramInt).setCompress(paramBoolean).setEncrypt(paramBoolean).setBufferFilePath(paramFile2.getAbsolutePath()).create();
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
  
  private static void e(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
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
  
  private static String getLogExternalPath(Context paramContext)
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
  
  private static String getLogFileName(String paramString)
  {
    return processName.replace(":", "_") + "." + paramString + ".log";
  }
  
  public static String getLogPath()
  {
    return logPath;
  }
  
  public static String getManualLogLevelPath()
  {
    return manualLogLevelPath;
  }
  
  public static String getPackageName()
  {
    return packageName;
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
    return Log.getStackTraceString(paramThrowable);
  }
  
  private static char[] getStringValue(StringBuilder paramStringBuilder)
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
  
  private static void i(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
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
      if (!isDevelopLevel()) {
        break label83;
      }
      i = 512;
    }
    for (;;)
    {
      sPool = new RecyclablePool(QLog.QLogItem.class, i);
      sWriteHandler = new QLog.WriteHandler(paramString1.getLooper());
      sWriteHandler.sendEmptyMessageDelayed(1, paramLong);
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
    logPath = getLogExternalPath(sAppContext) + "/tencent/msflogs/" + packageName.replace(".", "/") + "/";
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
    String str = logPath + getLogFileName("mmapCacheLog");
    localObject3 = new File(logPath);
    File localFile = new File(str);
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
              writer.write(logTime + "|" + processName + "|D|" + "QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + " create newLogFile " + ((File)localObject1).getName() + " " + bool + "\n");
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
        int i;
        Object localObject2 = localObject4;
        Object localObject4 = localThrowable3;
        continue;
      }
      try
      {
        localObject1 = XorKey.encryptedKey(XOREncryption.getXorKey());
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        i = 1;
        if ((fullEncryptedLogMode) && (i != 0)) {
          useNewLog = true;
        }
        d("QLog", 1, new Object[] { "initLog: useNewLog ", Boolean.valueOf(useNewLog), " MSF_IS_COLOR_LEVEL=", Boolean.valueOf(new File(logPath + "QLogConfig_B").exists()), " fullEncryptedLogMode=", Boolean.valueOf(fullEncryptedLogMode), " DebugVersion=", Boolean.valueOf(isDebugVersion()), " EncryptedKey=", localObject1, " QLog.isColorLevel()=", Boolean.valueOf(isColorLevel()), " UIN_REPORTLOG_LEVEL=", Integer.valueOf(UIN_REPORTLOG_LEVEL) });
      }
      catch (Throwable localThrowable1)
      {
        Log.d("QLog", "QLog useNewLog Init Fail," + localThrowable1);
        continue;
        writer = new BufferWriterWrapper(new QLogWriter(localObject4, true), 8192);
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
        writer.write(logTime + "|" + processName + "|E|" + "QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + "|newLogFile " + ((File)localObject1).getName() + " is existed.\n");
        writer.flush();
        localObject3 = localObject1;
        continue;
        localThrowable2.printStackTrace();
        localObject4 = localObject1;
        continue;
        i = 0;
      }
    }
  }
  
  public static boolean isColorLevel()
  {
    return (UIN_REPORTLOG_LEVEL > 1) || (useNewLog);
  }
  
  public static boolean isDebugVersion()
  {
    return isDebug;
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
    QLog.OnPrintlnCallback localOnPrintlnCallback = sOnPrintlnCallback;
    if (localOnPrintlnCallback != null) {
      localOnPrintlnCallback.onPrintln(paramInt, paramString1, paramString2);
    }
  }
  
  private static void onPrintln(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.OnPrintlnCallback localOnPrintlnCallback = sOnPrintlnCallback;
    if (localOnPrintlnCallback != null) {
      localOnPrintlnCallback.onPrintln(paramInt, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void p(String paramString1, String paramString2)
  {
    Log.d(getTag(paramString1), "[s]" + paramString2);
  }
  
  public static void setAppContext(Context paramContext)
  {
    sAppContext = paramContext;
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    isDebug = paramBoolean;
    if (paramBoolean) {}
    for (_DEFAULT_REPORTLOG_LEVEL = 4;; _DEFAULT_REPORTLOG_LEVEL = 1)
    {
      UIN_REPORTLOG_LEVEL = _DEFAULT_REPORTLOG_LEVEL;
      d("QLog", 1, new Object[] { "[init] setDebugMode call. ", " UIN_REPORTLOG_LEVEL: ", Integer.valueOf(UIN_REPORTLOG_LEVEL), " _DEFAULT_REPORTLOG_LEVEL: ", Integer.valueOf(_DEFAULT_REPORTLOG_LEVEL), " debug: ", Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public static void setFullEncryptedLogMode(boolean paramBoolean)
  {
    fullEncryptedLogMode = paramBoolean;
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
      d("QLog", 1, Thread.currentThread().getName() + "[level]  set log level manual, " + UIN_REPORTLOG_LEVEL, new RuntimeException());
    }
  }
  
  public static void setOnPrintlnCallback(QLog.OnPrintlnCallback paramOnPrintlnCallback)
  {
    sOnPrintlnCallback = paramOnPrintlnCallback;
  }
  
  /* Error */
  public static void setUIN_REPORTLOG_LEVEL(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 766	com/tencent/qphone/base/util/QLog:isExistSDCard	()Z
    //   3: ifeq +141 -> 144
    //   6: new 348	java/io/File
    //   9: dup
    //   10: getstatic 197	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   13: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 352	java/io/File:exists	()Z
    //   21: ifeq +113 -> 134
    //   24: aload_2
    //   25: invokevirtual 769	java/io/File:isFile	()Z
    //   28: ifeq +106 -> 134
    //   31: new 771	java/io/BufferedReader
    //   34: dup
    //   35: new 773	java/io/FileReader
    //   38: dup
    //   39: getstatic 197	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   42: invokespecial 774	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   45: invokespecial 777	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: invokevirtual 780	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: invokestatic 783	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   58: invokevirtual 786	java/lang/Integer:intValue	()I
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
    //   79: putstatic 153	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   82: aload_3
    //   83: astore_2
    //   84: ldc 29
    //   86: iconst_1
    //   87: new 175	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   94: invokestatic 750	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   97: invokevirtual 751	java/lang/Thread:getName	()Ljava/lang/String;
    //   100: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 788
    //   106: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: iload_1
    //   110: invokevirtual 756	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 790	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 791	java/io/BufferedReader:close	()V
    //   127: return
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 792	java/io/IOException:printStackTrace	()V
    //   133: return
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 791	java/io/BufferedReader:close	()V
    //   144: iload_0
    //   145: iconst_1
    //   146: if_icmplt -19 -> 127
    //   149: iload_0
    //   150: iconst_4
    //   151: if_icmpgt -24 -> 127
    //   154: getstatic 153	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   157: iload_0
    //   158: if_icmpeq -31 -> 127
    //   161: iload_0
    //   162: putstatic 153	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   165: ldc 29
    //   167: iconst_1
    //   168: new 175	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   175: invokestatic 750	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   178: invokevirtual 751	java/lang/Thread:getName	()Ljava/lang/String;
    //   181: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 794
    //   187: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_0
    //   191: invokevirtual 756	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: new 758	java/lang/RuntimeException
    //   200: dup
    //   201: invokespecial 759	java/lang/RuntimeException:<init>	()V
    //   204: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: getstatic 159	com/tencent/qphone/base/util/QLog:processName	Ljava/lang/String;
    //   210: ldc_w 469
    //   213: invokevirtual 796	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   216: ifne -89 -> 127
    //   219: invokestatic 801	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   222: invokestatic 804	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   225: if_acmpeq -98 -> 127
    //   228: new 348	java/io/File
    //   231: dup
    //   232: new 175	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   239: invokestatic 806	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   242: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc 20
    //   247: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   256: astore_2
    //   257: iload_0
    //   258: iconst_2
    //   259: if_icmplt +100 -> 359
    //   262: aload_2
    //   263: invokevirtual 352	java/io/File:exists	()Z
    //   266: ifne -139 -> 127
    //   269: aload_2
    //   270: invokevirtual 588	java/io/File:createNewFile	()Z
    //   273: pop
    //   274: return
    //   275: astore_2
    //   276: ldc 29
    //   278: iconst_1
    //   279: ldc_w 808
    //   282: aload_2
    //   283: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   286: return
    //   287: astore_2
    //   288: aload_2
    //   289: invokevirtual 792	java/io/IOException:printStackTrace	()V
    //   292: goto -148 -> 144
    //   295: astore 4
    //   297: aconst_null
    //   298: astore_3
    //   299: aload_3
    //   300: astore_2
    //   301: aload 4
    //   303: invokevirtual 687	java/lang/Throwable:printStackTrace	()V
    //   306: aload_3
    //   307: astore_2
    //   308: ldc 29
    //   310: iconst_1
    //   311: ldc_w 810
    //   314: aload 4
    //   316: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: aload_3
    //   320: ifnull -176 -> 144
    //   323: aload_3
    //   324: invokevirtual 791	java/io/BufferedReader:close	()V
    //   327: goto -183 -> 144
    //   330: astore_2
    //   331: aload_2
    //   332: invokevirtual 792	java/io/IOException:printStackTrace	()V
    //   335: goto -191 -> 144
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_2
    //   341: aload_2
    //   342: ifnull +7 -> 349
    //   345: aload_2
    //   346: invokevirtual 791	java/io/BufferedReader:close	()V
    //   349: aload_3
    //   350: athrow
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 792	java/io/IOException:printStackTrace	()V
    //   356: goto -7 -> 349
    //   359: aload_2
    //   360: invokevirtual 352	java/io/File:exists	()Z
    //   363: ifeq -236 -> 127
    //   366: aload_2
    //   367: invokevirtual 813	java/io/File:delete	()Z
    //   370: pop
    //   371: return
    //   372: astore_3
    //   373: goto -32 -> 341
    //   376: astore 4
    //   378: goto -79 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramInt	int
    //   61	49	1	i	int
    //   16	68	2	localObject1	Object
    //   128	2	2	localIOException1	java.io.IOException
    //   135	135	2	localFile	File
    //   275	8	2	localThrowable1	Throwable
    //   287	2	2	localIOException2	java.io.IOException
    //   300	8	2	localObject2	Object
    //   330	2	2	localIOException3	java.io.IOException
    //   340	6	2	localObject3	Object
    //   351	16	2	localIOException4	java.io.IOException
    //   48	276	3	localBufferedReader	java.io.BufferedReader
    //   338	12	3	localObject4	Object
    //   372	1	3	localObject5	Object
    //   295	20	4	localThrowable2	Throwable
    //   376	1	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   123	127	128	java/io/IOException
    //   207	257	275	java/lang/Throwable
    //   262	274	275	java/lang/Throwable
    //   359	371	275	java/lang/Throwable
    //   140	144	287	java/io/IOException
    //   6	49	295	java/lang/Throwable
    //   323	327	330	java/io/IOException
    //   6	49	338	finally
    //   345	349	351	java/io/IOException
    //   51	62	372	finally
    //   78	82	372	finally
    //   84	119	372	finally
    //   301	306	372	finally
    //   308	319	372	finally
    //   51	62	376	java/lang/Throwable
    //   78	82	376	java/lang/Throwable
    //   84	119	376	java/lang/Throwable
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
  
  private static void w(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
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
    bool1 = false;
    try
    {
      if ((wrapBytes == null) || (wrapBytes.length == 0)) {
        wrapBytes = String.valueOf('\n').getBytes("UTF-8");
      }
      if (writer == null) {
        return true;
      }
      Object localObject1 = sAppContext;
      if ((isColorLevel()) && (localObject1 != null) && (System.currentTimeMillis() - lastPrintMemeoryTime > 180000L))
      {
        localObject1 = (ActivityManager)((Context)localObject1).getSystemService("activity");
        ??? = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)???);
        d("QLog", 2, "availMem:" + ((ActivityManager.MemoryInfo)???).availMem / 1024L / 1024L + "M" + " lowThreshold:" + ((ActivityManager.MemoryInfo)???).threshold / 1024L / 1024L + "M");
        lastPrintMemeoryTime = System.currentTimeMillis();
      }
      if ((System.currentTimeMillis() - lastCheckLogFileTime > 180000L) && (!checkCurrentLogFileExists()))
      {
        lastCheckLogFileTime = System.currentTimeMillis();
        return true;
      }
      QLog.QLogItem localQLogItem;
      synchronized (processName)
      {
        localQLogItem = sTail;
        localObject1 = sHead;
        sTail = null;
        sHead = null;
        if (localObject1 == null) {
          return false;
        }
      }
      try
      {
        e("QLog", 1, "writeLogToFile Exeption", localThrowable);
        ??? = localThrowable.getMessage();
        if ((??? != null) && (!((String)???).contains("ENOSPC"))) {
          e("QLog", 1, localThrowable.getMessage());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool2;
          long l;
          StringBuilder localStringBuilder;
          Log.e("QLog", "QLog write log failed. ", localException);
          continue;
          Object localObject3 = ???;
          bool1 = bool2;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("QLog", "writeLogToFile Exeption", localThrowable);
    }
    return true;
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (localThrowable.logTime > nextHourTime) {
        bool2 = true;
      }
    }
    l = localThrowable.logTime;
    if ((l >= currentLogSecond + 1000L) || (l < currentLogSecond))
    {
      logTime = timeFormatter.format(Long.valueOf(l));
      if ((l >= currentLogSecond + 1000L) && (l < currentLogSecond + 2000L)) {
        currentLogSecond += 1000L;
      }
    }
    else
    {
      localStringBuilder = (StringBuilder)sBuilderLocal.get();
      ??? = localStringBuilder;
      if (localStringBuilder == null)
      {
        ??? = new StringBuilder(10240);
        sBuilderLocal.set(???);
      }
      ((StringBuilder)???).setLength(0);
      if (localThrowable.contentType != 1) {
        break label719;
      }
      ((StringBuilder)???).append(logTime).append('|').append(localThrowable.logTime).append('[').append(myProcessId).append(']').append(localThrowable.threadId).append('|').append(getReportLevel(localThrowable.level)).append('|').append(localThrowable.tag).append('|');
      sValues = getStringValue((StringBuilder)???);
      writer.write(sValues, 0, ((StringBuilder)???).length());
      writer.write(localThrowable.msgBytes, 0, localThrowable.msgBytes.length);
      writer.write(wrapBytes, 0, wrapBytes.length);
      if (sLogCallback != null) {
        sLogCallback.onWriteLog(localThrowable.tag, localThrowable.msgBytes);
      }
    }
    label902:
    for (;;)
    {
      if (localThrowable.trace != null)
      {
        writer.write(Log.getStackTraceString(localThrowable.trace));
        writer.write(10);
      }
      ??? = (QLog.QLogItem)localThrowable.getNext();
      sPool.recycle(localThrowable);
      if (localThrowable != localQLogItem) {
        break label920;
      }
      writer.flush();
      return bool2;
      ??? = Calendar.getInstance();
      ((Calendar)???).setTimeInMillis(l);
      ((Calendar)???).set(14, 0);
      currentLogSecond = ((Calendar)???).getTimeInMillis();
      break;
      label719:
      ((StringBuilder)???).append(logTime).append('|').append(localThrowable.logTime).append('[').append(myProcessId).append(']').append(localThrowable.threadId).append('|').append(getReportLevel(localThrowable.level)).append('|').append(localThrowable.tag).append('|').append(localThrowable.msg).append('\n');
      if ((sValues == null) || (sValues.length != ((StringBuilder)???).capacity())) {
        sValues = getStringValue((StringBuilder)???);
      }
      if (sValues != null) {
        writer.write(sValues, 0, ((StringBuilder)???).length());
      }
      for (;;)
      {
        if (sLogCallback == null) {
          break label902;
        }
        sLogCallback.onWriteLog(localThrowable.tag, localThrowable.msg);
        break;
        writer.write(((StringBuilder)???).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog
 * JD-Core Version:    0.7.0.1
 */