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
import com.tencent.qphone.base.util.log.RecyclablePool.Recyclable;
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
  private static final Charset logCharset = Charset.forName("UTF-8");
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
  static String sBuildNumber = "";
  private static ThreadLocal<StringBuilder> sBuilderLocal = new ThreadLocal();
  private static boolean sHasStoragePermission = false;
  private static QLog.QLogItem sHead;
  private static long sInitLogTime = 0L;
  private static QLog.ILogCallback sLogCallback;
  public static boolean sLogcatHooked = false;
  private static QLog.OnPrintlnCallback sOnPrintlnCallback;
  private static RecyclablePool sPool;
  private static QLog.QLogItem sTail;
  static Field sValueField;
  private static char[] sValues = null;
  static QLog.WriteHandler sWriteHandler;
  private static final String tag = "QLog";
  static SimpleDateFormat timeFormatter;
  private static boolean useNewLog = false;
  static byte[] wrapBytes;
  private static ILogWriter writer;
  
  static
  {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/mqqLogLevel");
    manualLogLevelPath = localStringBuilder.toString();
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
    long l1 = System.currentTimeMillis();
    long l2 = colorLogTime;
    if ((l2 != 0L) && (l1 - l2 > 1800000L))
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
    localQLogItem.logTime = l1;
    localQLogItem.threadId = Process.myTid();
    localQLogItem.level = paramInt1;
    localQLogItem.tag = ???;
    localQLogItem.msg = paramString2;
    localQLogItem.msgBytes = paramArrayOfByte;
    localQLogItem.contentType = paramInt2;
    localQLogItem.trace = paramThrowable;
    synchronized (processName)
    {
      if (sHead == null)
      {
        sHead = localQLogItem;
        sTail = localQLogItem;
      }
      else
      {
        sTail.changeNext(localQLogItem, true);
        sTail = localQLogItem;
      }
      return;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(logPath);
    localStringBuilder.append(getLogFileName((String)localObject));
    localObject = localStringBuilder.toString();
    if (!new File(logPath).exists()) {
      return false;
    }
    return new File((String)localObject).exists();
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
    int i = UIN_REPORTLOG_LEVEL;
    int j = 0;
    if ((i < paramInt) && (!colorTags.contains(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) || (useNewLog)) {
      j = 1;
    }
    if (j != 0)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (i != 0)
      {
        paramString2 = getTag(paramString1);
        if (paramThrowable == null)
        {
          Log.d(paramString2, str);
          onPrintln(3, paramString2, str);
        }
        else
        {
          Log.d(paramString2, str, paramThrowable);
          onPrintln(3, paramString2, str);
        }
      }
      addLogItem(paramString1, paramInt, str, paramThrowable);
    }
  }
  
  public static void d(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    if (paramThrowable == null) {
      i = 0;
    } else {
      i = 128;
    }
    StringBuilder localStringBuilder = new StringBuilder(k * 30 + i);
    int i = j;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    d(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void d(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int i = UIN_REPORTLOG_LEVEL;
    int k = 1;
    if ((i < paramInt) && (!colorTags.contains(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    int j = k;
    if (i == 0) {
      if (useNewLog) {
        j = k;
      } else {
        j = 0;
      }
    }
    if (j != 0)
    {
      byte[] arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        arrayOfByte = new byte[0];
      }
      if (i != 0)
      {
        paramArrayOfByte = getTag(paramString);
        String str = new String(arrayOfByte, logCharset);
        if (paramThrowable == null)
        {
          Log.d(paramArrayOfByte, str);
          onPrintln(3, paramArrayOfByte, str);
        }
        else
        {
          Log.d(paramArrayOfByte, str, paramThrowable);
          onPrintln(3, paramArrayOfByte, str, paramThrowable);
        }
      }
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
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
    int i = UIN_REPORTLOG_LEVEL;
    int j = 0;
    if ((i < paramInt) && (!colorTags.contains(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) || (useNewLog)) {
      j = 1;
    }
    if (j != 0)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (i != 0) {
        if (paramThrowable == null) {
          Log.e(getTag(paramString1), str);
        } else {
          Log.e(getTag(paramString1), str, paramThrowable);
        }
      }
      addLogItem(paramString1, paramInt, str, paramThrowable);
    }
  }
  
  public static void e(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    if (paramThrowable == null) {
      i = 0;
    } else {
      i = 128;
    }
    StringBuilder localStringBuilder = new StringBuilder(k * 30 + i);
    int i = j;
    while (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localStringBuilder.append(localObject.toString());
      }
      i += 1;
    }
    e(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  private static void e(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int i = UIN_REPORTLOG_LEVEL;
    int k = 1;
    if ((i < paramInt) && (!colorTags.contains(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    int j = k;
    if (i == 0) {
      if (useNewLog) {
        j = k;
      } else {
        j = 0;
      }
    }
    if (j != 0)
    {
      byte[] arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        arrayOfByte = new byte[0];
      }
      if (i != 0) {
        if (paramThrowable == null) {
          Log.e(getTag(paramString), new String(arrayOfByte, logCharset));
        } else {
          Log.e(getTag(paramString), new String(arrayOfByte, logCharset), paramThrowable);
        }
      }
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(processName.replace(":", "_"));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".log");
    return localStringBuilder.toString();
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return "E";
        }
        return "D";
      }
      return "W";
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
    catch (IllegalAccessException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
    }
    catch (IllegalArgumentException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
    }
    catch (NoSuchFieldException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
    }
    return null;
  }
  
  private static String getTag(String paramString)
  {
    Object localObject = paramString;
    if (sLogcatHooked)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("log_hook_pre_");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
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
    int i = UIN_REPORTLOG_LEVEL;
    int j = 0;
    if ((i < paramInt) && (!colorTags.contains(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) || (useNewLog)) {
      j = 1;
    }
    if (j != 0)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (i != 0) {
        if (paramThrowable == null) {
          Log.i(getTag(paramString1), str);
        } else {
          Log.i(getTag(paramString1), str, paramThrowable);
        }
      }
      addLogItem(paramString1, paramInt, str, paramThrowable);
    }
  }
  
  private static void i(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int i = UIN_REPORTLOG_LEVEL;
    int k = 1;
    if ((i < paramInt) && (!colorTags.contains(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    int j = k;
    if (i == 0) {
      if (useNewLog) {
        j = k;
      } else {
        j = 0;
      }
    }
    if (j != 0)
    {
      byte[] arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        arrayOfByte = new byte[0];
      }
      if (i != 0) {
        if (paramThrowable == null) {
          Log.i(getTag(paramString), new String(arrayOfByte, logCharset));
        } else {
          Log.i(getTag(paramString), new String(arrayOfByte, logCharset), paramThrowable);
        }
      }
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
    }
  }
  
  public static void init(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (sWriteHandler == null)
    {
      processName = paramString2;
      packageName = paramString1;
      sBuildNumber = paramString3;
      paramString1 = new HandlerThread("logWriteThread");
      paramString1.start();
      int i;
      if (isDevelopLevel()) {
        i = 512;
      } else if (isColorLevel()) {
        i = 256;
      } else {
        i = 128;
      }
      sPool = new RecyclablePool(QLog.QLogItem.class, i);
      sWriteHandler = new QLog.WriteHandler(paramString1.getLooper());
      sWriteHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  static void initLogFile(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getLogExternalPath(sAppContext));
    ((StringBuilder)localObject1).append("/tencent/msflogs/");
    ((StringBuilder)localObject1).append(packageName.replace(".", "/"));
    ((StringBuilder)localObject1).append("/");
    logPath = ((StringBuilder)localObject1).toString();
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(paramLong);
    logTime = timeFormatter.format(Long.valueOf(paramLong));
    localObject1 = logFileFormatter.format(((Calendar)localObject2).getTime());
    currentLogFileName = (String)localObject1;
    ((Calendar)localObject2).set(14, 0);
    ((Calendar)localObject2).add(11, 1);
    ((Calendar)localObject2).set(12, 0);
    ((Calendar)localObject2).set(13, 0);
    nextHourTime = ((Calendar)localObject2).getTimeInMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(logPath);
    ((StringBuilder)localObject2).append(getLogFileName((String)localObject1));
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(logPath);
    ((StringBuilder)localObject2).append(getLogFileName("mmapCacheLog"));
    Object localObject4 = ((StringBuilder)localObject2).toString();
    localObject2 = new File(logPath);
    File localFile = new File((String)localObject4);
    boolean bool;
    try
    {
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject1 = new File((String)localObject1);
      try
      {
        sInitLogTime = System.currentTimeMillis();
        bool = ((File)localObject1).exists();
        if (!bool)
        {
          bool = ((File)localObject1).createNewFile();
          localObject2 = localObject1;
          if (writer != null)
          {
            localObject2 = writer;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(logTime);
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(processName);
            ((StringBuilder)localObject4).append("|D||QQ_Version: ");
            ((StringBuilder)localObject4).append(sBuildNumber);
            ((StringBuilder)localObject4).append("\r\n");
            ((ILogWriter)localObject2).write(((StringBuilder)localObject4).toString());
            localObject2 = writer;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(logTime);
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(processName);
            ((StringBuilder)localObject4).append("|D|");
            ((StringBuilder)localObject4).append("QLog");
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(Build.MODEL);
            ((StringBuilder)localObject4).append(" ");
            ((StringBuilder)localObject4).append(Build.VERSION.RELEASE);
            ((StringBuilder)localObject4).append(" create newLogFile ");
            ((StringBuilder)localObject4).append(((File)localObject1).getName());
            ((StringBuilder)localObject4).append(" ");
            ((StringBuilder)localObject4).append(bool);
            ((StringBuilder)localObject4).append("\n");
            ((ILogWriter)localObject2).write(((StringBuilder)localObject4).toString());
            writer.flush();
            localObject2 = localObject1;
          }
        }
        else
        {
          localObject2 = localObject1;
          if (writer != null)
          {
            localObject2 = writer;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(logTime);
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(processName);
            ((StringBuilder)localObject4).append("|D||QQ_Version: ");
            ((StringBuilder)localObject4).append(sBuildNumber);
            ((StringBuilder)localObject4).append("\r\n");
            ((ILogWriter)localObject2).write(((StringBuilder)localObject4).toString());
            localObject2 = writer;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(logTime);
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(processName);
            ((StringBuilder)localObject4).append("|E|");
            ((StringBuilder)localObject4).append("QLog");
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(Build.MODEL);
            ((StringBuilder)localObject4).append(" ");
            ((StringBuilder)localObject4).append(Build.VERSION.RELEASE);
            ((StringBuilder)localObject4).append("|newLogFile ");
            ((StringBuilder)localObject4).append(((File)localObject1).getName());
            ((StringBuilder)localObject4).append(" is existed.\n");
            ((ILogWriter)localObject2).write(((StringBuilder)localObject4).toString());
            writer.flush();
            localObject2 = localObject1;
          }
        }
      }
      catch (Throwable localThrowable2) {}
      ((Throwable)localObject3).printStackTrace();
    }
    catch (Throwable localThrowable3)
    {
      localObject1 = localThrowable2;
      localObject3 = localThrowable3;
    }
    Object localObject3 = localObject1;
    localObject1 = writer;
    if (localObject1 != null)
    {
      ((ILogWriter)localObject1).close();
      writer = null;
    }
    for (;;)
    {
      try
      {
        localObject1 = XorKey.encryptedKey(XOREncryption.getXorKey());
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1208;
        }
        i = 1;
        if ((fullEncryptedLogMode) && (i != 0)) {
          useNewLog = true;
        }
        bool = useNewLog;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(logPath);
        localStringBuilder.append("QLogConfig_B");
        d("QLog", 1, new Object[] { "initLog: useNewLog ", Boolean.valueOf(bool), " MSF_IS_COLOR_LEVEL=", Boolean.valueOf(new File(localStringBuilder.toString()).exists()), " fullEncryptedLogMode=", Boolean.valueOf(fullEncryptedLogMode), " DebugVersion=", Boolean.valueOf(isDebugVersion()), " EncryptedKey=", localObject1, " QLog.isColorLevel()=", Boolean.valueOf(isColorLevel()), " UIN_REPORTLOG_LEVEL=", Integer.valueOf(UIN_REPORTLOG_LEVEL) });
      }
      catch (Throwable localThrowable1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QLog useNewLog Init Fail,");
        localStringBuilder.append(localThrowable1);
        Log.d("QLog", localStringBuilder.toString());
      }
      if (useNewLog) {
        writer = createJavaMmapLogAppender(8192, true, (File)localObject3, localFile);
      } else {
        writer = new BufferWriterWrapper(new QLogWriter((File)localObject3, true), 8192);
      }
      ILogWriter localILogWriter = writer;
      if (localILogWriter != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(logTime);
        ((StringBuilder)localObject3).append("|");
        ((StringBuilder)localObject3).append(processName);
        ((StringBuilder)localObject3).append("|D||QQ_Version: ");
        ((StringBuilder)localObject3).append(sBuildNumber);
        ((StringBuilder)localObject3).append("\r\n");
        localILogWriter.write(((StringBuilder)localObject3).toString());
        writer.flush();
      }
      return;
      label1208:
      int i = 0;
    }
  }
  
  public static boolean isColorLevel()
  {
    int i = UIN_REPORTLOG_LEVEL;
    boolean bool = true;
    if (i <= 1)
    {
      if (useNewLog) {
        return true;
      }
      bool = false;
    }
    return bool;
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
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return false;
  }
  
  public static boolean isHasStoragePermission(Context paramContext)
  {
    boolean bool2 = sHasStoragePermission;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(PERMS[0]) == 0)
          {
            sHasStoragePermission = true;
            return sHasStoragePermission;
          }
        }
      }
      else
      {
        sHasStoragePermission = true;
        bool1 = sHasStoragePermission;
      }
    }
    return bool1;
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
    paramString1 = getTag(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[s]");
    localStringBuilder.append(paramString2);
    Log.d(paramString1, localStringBuilder.toString());
  }
  
  public static void setAppContext(Context paramContext)
  {
    sAppContext = paramContext;
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    isDebug = paramBoolean;
    if (paramBoolean) {
      _DEFAULT_REPORTLOG_LEVEL = 4;
    } else {
      _DEFAULT_REPORTLOG_LEVEL = 1;
    }
    UIN_REPORTLOG_LEVEL = _DEFAULT_REPORTLOG_LEVEL;
    d("QLog", 1, new Object[] { "[init] setDebugMode call. ", " UIN_REPORTLOG_LEVEL: ", Integer.valueOf(UIN_REPORTLOG_LEVEL), " _DEFAULT_REPORTLOG_LEVEL: ", Integer.valueOf(_DEFAULT_REPORTLOG_LEVEL), " debug: ", Boolean.valueOf(paramBoolean) });
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append("[level]  set log level manual, ");
      localStringBuilder.append(UIN_REPORTLOG_LEVEL);
      d("QLog", 1, localStringBuilder.toString(), new RuntimeException());
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
    //   0: invokestatic 764	com/tencent/qphone/base/util/QLog:isExistSDCard	()Z
    //   3: ifeq +242 -> 245
    //   6: aconst_null
    //   7: astore_3
    //   8: new 336	java/io/File
    //   11: dup
    //   12: getstatic 181	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   15: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload_3
    //   21: astore_2
    //   22: aload 4
    //   24: invokevirtual 340	java/io/File:exists	()Z
    //   27: ifeq +139 -> 166
    //   30: aload_3
    //   31: astore_2
    //   32: aload 4
    //   34: invokevirtual 767	java/io/File:isFile	()Z
    //   37: ifeq +129 -> 166
    //   40: new 769	java/io/BufferedReader
    //   43: dup
    //   44: new 771	java/io/FileReader
    //   47: dup
    //   48: getstatic 181	com/tencent/qphone/base/util/QLog:manualLogLevelPath	Ljava/lang/String;
    //   51: invokespecial 772	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 775	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_2
    //   60: aload_3
    //   61: invokevirtual 778	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: invokestatic 781	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   67: invokevirtual 784	java/lang/Integer:intValue	()I
    //   70: istore_1
    //   71: iload_1
    //   72: iconst_1
    //   73: if_icmplt +83 -> 156
    //   76: iload_1
    //   77: iconst_4
    //   78: if_icmpgt +78 -> 156
    //   81: aload_3
    //   82: astore_2
    //   83: iload_1
    //   84: putstatic 137	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   87: aload_3
    //   88: astore_2
    //   89: new 159	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   96: astore 4
    //   98: aload_3
    //   99: astore_2
    //   100: aload 4
    //   102: invokestatic 748	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   105: invokevirtual 749	java/lang/Thread:getName	()Ljava/lang/String;
    //   108: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: astore_2
    //   114: aload 4
    //   116: ldc_w 786
    //   119: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: astore_2
    //   125: aload 4
    //   127: iload_1
    //   128: invokevirtual 754	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_3
    //   133: astore_2
    //   134: ldc 29
    //   136: iconst_1
    //   137: aload 4
    //   139: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 788	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_3
    //   146: invokevirtual 789	java/io/BufferedReader:close	()V
    //   149: return
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 790	java/io/IOException:printStackTrace	()V
    //   155: return
    //   156: aload_3
    //   157: astore_2
    //   158: goto +8 -> 166
    //   161: astore 4
    //   163: goto +32 -> 195
    //   166: aload_2
    //   167: ifnull +78 -> 245
    //   170: aload_2
    //   171: invokevirtual 789	java/io/BufferedReader:close	()V
    //   174: goto +71 -> 245
    //   177: astore_2
    //   178: aload_2
    //   179: invokevirtual 790	java/io/IOException:printStackTrace	()V
    //   182: goto +63 -> 245
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_2
    //   188: goto +39 -> 227
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_3
    //   195: aload_3
    //   196: astore_2
    //   197: aload 4
    //   199: invokevirtual 629	java/lang/Throwable:printStackTrace	()V
    //   202: aload_3
    //   203: astore_2
    //   204: ldc 29
    //   206: iconst_1
    //   207: ldc_w 792
    //   210: aload 4
    //   212: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload_3
    //   216: ifnull +29 -> 245
    //   219: aload_3
    //   220: invokevirtual 789	java/io/BufferedReader:close	()V
    //   223: goto +22 -> 245
    //   226: astore_3
    //   227: aload_2
    //   228: ifnull +15 -> 243
    //   231: aload_2
    //   232: invokevirtual 789	java/io/BufferedReader:close	()V
    //   235: goto +8 -> 243
    //   238: astore_2
    //   239: aload_2
    //   240: invokevirtual 790	java/io/IOException:printStackTrace	()V
    //   243: aload_3
    //   244: athrow
    //   245: iload_0
    //   246: iconst_1
    //   247: if_icmplt +167 -> 414
    //   250: iload_0
    //   251: iconst_4
    //   252: if_icmpgt +162 -> 414
    //   255: getstatic 137	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   258: iload_0
    //   259: if_icmpeq +155 -> 414
    //   262: iload_0
    //   263: putstatic 137	com/tencent/qphone/base/util/QLog:UIN_REPORTLOG_LEVEL	I
    //   266: new 159	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   273: astore_2
    //   274: aload_2
    //   275: invokestatic 748	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   278: invokevirtual 749	java/lang/Thread:getName	()Ljava/lang/String;
    //   281: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_2
    //   286: ldc_w 794
    //   289: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_2
    //   294: iload_0
    //   295: invokevirtual 754	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc 29
    //   301: iconst_1
    //   302: aload_2
    //   303: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: new 756	java/lang/RuntimeException
    //   309: dup
    //   310: invokespecial 757	java/lang/RuntimeException:<init>	()V
    //   313: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: getstatic 143	com/tencent/qphone/base/util/QLog:processName	Ljava/lang/String;
    //   319: ldc_w 459
    //   322: invokevirtual 796	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   325: ifne +89 -> 414
    //   328: invokestatic 801	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   331: invokestatic 804	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   334: if_acmpeq +80 -> 414
    //   337: new 159	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   344: astore_2
    //   345: aload_2
    //   346: invokestatic 806	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   349: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: ldc 20
    //   356: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: new 336	java/io/File
    //   363: dup
    //   364: aload_2
    //   365: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;)V
    //   371: astore_2
    //   372: iload_0
    //   373: iconst_2
    //   374: if_icmplt +16 -> 390
    //   377: aload_2
    //   378: invokevirtual 340	java/io/File:exists	()Z
    //   381: ifne +33 -> 414
    //   384: aload_2
    //   385: invokevirtual 582	java/io/File:createNewFile	()Z
    //   388: pop
    //   389: return
    //   390: aload_2
    //   391: invokevirtual 340	java/io/File:exists	()Z
    //   394: ifeq +20 -> 414
    //   397: aload_2
    //   398: invokevirtual 809	java/io/File:delete	()Z
    //   401: pop
    //   402: return
    //   403: astore_2
    //   404: ldc 29
    //   406: iconst_1
    //   407: ldc_w 811
    //   410: aload_2
    //   411: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   414: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	paramInt	int
    //   70	58	1	i	int
    //   21	113	2	localBufferedReader1	java.io.BufferedReader
    //   150	2	2	localIOException1	java.io.IOException
    //   157	14	2	localBufferedReader2	java.io.BufferedReader
    //   177	2	2	localIOException2	java.io.IOException
    //   187	45	2	localObject1	Object
    //   238	2	2	localIOException3	java.io.IOException
    //   273	125	2	localObject2	Object
    //   403	8	2	localThrowable1	Throwable
    //   7	150	3	localBufferedReader3	java.io.BufferedReader
    //   185	1	3	localObject3	Object
    //   194	26	3	localObject4	Object
    //   226	18	3	localObject5	Object
    //   18	120	4	localObject6	Object
    //   161	1	4	localThrowable2	Throwable
    //   191	20	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   145	149	150	java/io/IOException
    //   60	71	161	java/lang/Throwable
    //   83	87	161	java/lang/Throwable
    //   89	98	161	java/lang/Throwable
    //   100	112	161	java/lang/Throwable
    //   114	123	161	java/lang/Throwable
    //   125	132	161	java/lang/Throwable
    //   134	145	161	java/lang/Throwable
    //   170	174	177	java/io/IOException
    //   219	223	177	java/io/IOException
    //   8	20	185	finally
    //   22	30	185	finally
    //   32	58	185	finally
    //   8	20	191	java/lang/Throwable
    //   22	30	191	java/lang/Throwable
    //   32	58	191	java/lang/Throwable
    //   60	71	226	finally
    //   83	87	226	finally
    //   89	98	226	finally
    //   100	112	226	finally
    //   114	123	226	finally
    //   125	132	226	finally
    //   134	145	226	finally
    //   197	202	226	finally
    //   204	215	226	finally
    //   231	235	238	java/io/IOException
    //   316	372	403	java/lang/Throwable
    //   377	389	403	java/lang/Throwable
    //   390	402	403	java/lang/Throwable
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    w(paramString1, paramInt, paramString2, null);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    int i = UIN_REPORTLOG_LEVEL;
    int j = 0;
    if ((i < paramInt) && (!colorTags.contains(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) || (useNewLog)) {
      j = 1;
    }
    if (j != 0)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (i != 0) {
        if (paramThrowable == null) {
          Log.w(getTag(paramString1), str);
        } else {
          Log.w(getTag(paramString1), str, paramThrowable);
        }
      }
      addLogItem(paramString1, paramInt, str, paramThrowable);
    }
  }
  
  private static void w(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    int i = UIN_REPORTLOG_LEVEL;
    int k = 1;
    if ((i < paramInt) && (!colorTags.contains(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    int j = k;
    if (i == 0) {
      if (useNewLog) {
        j = k;
      } else {
        j = 0;
      }
    }
    if (j != 0)
    {
      byte[] arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        arrayOfByte = new byte[0];
      }
      if (i != 0) {
        if (paramThrowable == null) {
          Log.w(getTag(paramString), new String(arrayOfByte, logCharset));
        } else {
          Log.w(getTag(paramString), new String(arrayOfByte, logCharset), paramThrowable);
        }
      }
      addLogItem(paramString, paramInt, arrayOfByte, paramThrowable);
    }
  }
  
  private static boolean writeLogToFile()
  {
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
        ??? = (ActivityManager)((Context)localObject1).getSystemService("activity");
        localObject1 = new ActivityManager.MemoryInfo();
        ((ActivityManager)???).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("availMem:");
        ((StringBuilder)???).append(((ActivityManager.MemoryInfo)localObject1).availMem / 1024L / 1024L);
        ((StringBuilder)???).append("M");
        ((StringBuilder)???).append(" lowThreshold:");
        ((StringBuilder)???).append(((ActivityManager.MemoryInfo)localObject1).threshold / 1024L / 1024L);
        ((StringBuilder)???).append("M");
        d("QLog", 2, ((StringBuilder)???).toString());
        lastPrintMemeoryTime = System.currentTimeMillis();
      }
      if ((System.currentTimeMillis() - lastCheckLogFileTime > 180000L) && (!checkCurrentLogFileExists()))
      {
        lastCheckLogFileTime = System.currentTimeMillis();
        return true;
      }
      synchronized (processName)
      {
        QLog.QLogItem localQLogItem = sTail;
        localObject1 = sHead;
        sTail = null;
        sHead = null;
        if (localObject1 == null) {
          return false;
        }
        boolean bool1 = false;
        boolean bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (((QLog.QLogItem)localObject1).logTime > nextHourTime) {
            bool2 = true;
          }
        }
        long l = ((QLog.QLogItem)localObject1).logTime;
        if ((l >= currentLogSecond + 1000L) || (l < currentLogSecond))
        {
          logTime = timeFormatter.format(Long.valueOf(l));
          if ((l >= currentLogSecond + 1000L) && (l < currentLogSecond + 2000L))
          {
            currentLogSecond += 1000L;
          }
          else
          {
            ??? = Calendar.getInstance();
            ((Calendar)???).setTimeInMillis(l);
            ((Calendar)???).set(14, 0);
            currentLogSecond = ((Calendar)???).getTimeInMillis();
          }
        }
        StringBuilder localStringBuilder = (StringBuilder)sBuilderLocal.get();
        ??? = localStringBuilder;
        if (localStringBuilder == null)
        {
          ??? = new StringBuilder(10240);
          sBuilderLocal.set(???);
        }
        ((StringBuilder)???).setLength(0);
        if (((QLog.QLogItem)localObject1).contentType == 1)
        {
          ((StringBuilder)???).append(logTime);
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(((QLog.QLogItem)localObject1).logTime);
          ((StringBuilder)???).append('[');
          ((StringBuilder)???).append(myProcessId);
          ((StringBuilder)???).append(']');
          ((StringBuilder)???).append(((QLog.QLogItem)localObject1).threadId);
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(getReportLevel(((QLog.QLogItem)localObject1).level));
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(((QLog.QLogItem)localObject1).tag);
          ((StringBuilder)???).append('|');
          sValues = getStringValue((StringBuilder)???);
          writer.write(sValues, 0, ((StringBuilder)???).length());
          writer.write(((QLog.QLogItem)localObject1).msgBytes, 0, ((QLog.QLogItem)localObject1).msgBytes.length);
          writer.write(wrapBytes, 0, wrapBytes.length);
          if (sLogCallback != null) {
            sLogCallback.onWriteLog(((QLog.QLogItem)localObject1).tag, ((QLog.QLogItem)localObject1).msgBytes);
          }
        }
        else
        {
          ((StringBuilder)???).append(logTime);
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(((QLog.QLogItem)localObject1).logTime);
          ((StringBuilder)???).append('[');
          ((StringBuilder)???).append(myProcessId);
          ((StringBuilder)???).append(']');
          ((StringBuilder)???).append(((QLog.QLogItem)localObject1).threadId);
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(getReportLevel(((QLog.QLogItem)localObject1).level));
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(((QLog.QLogItem)localObject1).tag);
          ((StringBuilder)???).append('|');
          ((StringBuilder)???).append(((QLog.QLogItem)localObject1).msg);
          ((StringBuilder)???).append('\n');
          if ((sValues == null) || (sValues.length != ((StringBuilder)???).capacity())) {
            sValues = getStringValue((StringBuilder)???);
          }
          if (sValues != null) {
            writer.write(sValues, 0, ((StringBuilder)???).length());
          } else {
            writer.write(((StringBuilder)???).toString());
          }
          if (sLogCallback != null) {
            sLogCallback.onWriteLog(((QLog.QLogItem)localObject1).tag, ((QLog.QLogItem)localObject1).msg);
          }
        }
        if (((QLog.QLogItem)localObject1).trace != null)
        {
          writer.write(Log.getStackTraceString(((QLog.QLogItem)localObject1).trace));
          writer.write(10);
        }
        ??? = (QLog.QLogItem)((QLog.QLogItem)localObject1).getNext();
        sPool.recycle((RecyclablePool.Recyclable)localObject1);
        if (localObject1 == localQLogItem)
        {
          writer.flush();
          return bool2;
        }
        localObject1 = ???;
        bool1 = bool2;
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QLog", "writeLogToFile Exeption", localThrowable);
      try
      {
        e("QLog", 1, "writeLogToFile Exeption", localThrowable);
        ??? = localThrowable.getMessage();
        if ((??? != null) && (!((String)???).contains("ENOSPC")))
        {
          e("QLog", 1, localThrowable.getMessage());
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.e("QLog", "QLog write log failed. ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog
 * JD-Core Version:    0.7.0.1
 */