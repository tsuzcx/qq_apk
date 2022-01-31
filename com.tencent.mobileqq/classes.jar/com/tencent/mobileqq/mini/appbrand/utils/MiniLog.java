package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Process;
import android.util.LruCache;
import bdcs;
import bdje;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class MiniLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final int MAX_MINI_LOG_NUM = 5;
  private static long MAX_MINI_LOG_SIZE = 1048576L;
  public static final String MINI_LOG_TAG = "log";
  private static final int RECYCLE_CAPACITY = 512;
  private static final String TAG = "MiniLog";
  public static final int USR = 1;
  private static final int WRITE_MINI_LOG_MSG = 2;
  private static final int WRITE_NATIVE_LOG_MSG = 1;
  private static long currentLogSecond;
  private static HashMap<String, Boolean> debugControlMap;
  private static long lastCheckLogSizeTime;
  private static SimpleDateFormat logFileFormatter;
  private static String logTime;
  private static LruCache<String, Integer> mLastNumCache;
  private static volatile MiniLog.WriteHandler mWriteHandler;
  private static Map<String, BufferedWriter> miniFlushMap;
  private static LinkedBlockingQueue<MiniLog.MiniItem> miniQueue;
  private static final int myProcessId;
  private static Map<String, BufferedWriter> nativeFlushMap;
  private static String packageName;
  private static String processName;
  private static String sBuildNumber;
  private static StringBuilder sBuilder = new StringBuilder(10240);
  private static MiniLog.QLogItem sHead;
  private static RecyclablePool sPool;
  private static MiniLog.QLogItem sTail;
  private static SimpleDateFormat timeFormatter;
  
  static
  {
    logTime = "";
    myProcessId = Process.myPid();
    processName = "";
    packageName = "";
    sBuildNumber = "";
    debugControlMap = new HashMap();
    nativeFlushMap = new HashMap();
    logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");
    timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    miniFlushMap = new HashMap();
    miniQueue = new LinkedBlockingQueue(256);
    mLastNumCache = new LruCache(5);
  }
  
  private static void addMiniLogItem(String paramString1, String paramString2)
  {
    MiniLog.MiniItem localMiniItem = new MiniLog.MiniItem();
    localMiniItem.msg = paramString2;
    localMiniItem.filePath = paramString1;
    initWriteHandler();
    if (miniQueue.offer(localMiniItem))
    {
      mWriteHandler.removeMessages(2);
      mWriteHandler.sendEmptyMessageDelayed(2, 1000L);
    }
  }
  
  private static void addNativeLogItem(String arg0, String paramString2, int paramInt, String paramString3, Throwable paramThrowable)
  {
    if ((sPool == null) || (bdje.a(???))) {}
    MiniLog.QLogItem localQLogItem;
    do
    {
      return;
      localQLogItem = (MiniLog.QLogItem)sPool.obtain(MiniLog.QLogItem.class);
    } while (localQLogItem == null);
    localQLogItem.logTime = System.currentTimeMillis();
    localQLogItem.threadId = Process.myTid();
    localQLogItem.level = paramInt;
    localQLogItem.tag = paramString2;
    localQLogItem.msg = paramString3;
    localQLogItem.trace = paramThrowable;
    localQLogItem.appId = ???;
    synchronized (processName)
    {
      if (sHead == null)
      {
        sHead = localQLogItem;
        sTail = localQLogItem;
        initWriteHandler();
        mWriteHandler.removeMessages(1);
        mWriteHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
      sTail.changeNext(localQLogItem, true);
      sTail = localQLogItem;
    }
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    d(paramString1, paramInt, paramString2, paramString3, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (isEnableDebug(paramString2).booleanValue()) {
      addNativeLogItem(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
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
    d(paramString1, paramInt, paramString2, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    d(paramString1, paramInt, paramString2, null, paramVarArgs);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    e(paramString1, paramInt, paramString2, paramString3, null);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (isEnableDebug(paramString2).booleanValue()) {
      addNativeLogItem(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
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
    e(paramString1, paramInt, paramString2, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    e(paramString1, paramInt, paramString2, null, paramVarArgs);
  }
  
  private static String getLogFileName(String paramString)
  {
    return processName.replace(":", "_") + "." + paramString + ".log";
  }
  
  public static String getMiniLogFolderPath()
  {
    return MiniAppGlobal.getMiniCacheFilePath();
  }
  
  public static String getMiniLogFolderPath(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(paramString) + "/" + str + "/miniprogramLog/";
  }
  
  private static String getMiniLogPath(String paramString)
  {
    int j = 2;
    String str = getMiniLogFolderPath(paramString);
    Object localObject2 = (Integer)mLastNumCache.get(paramString);
    Object localObject6 = new File(str);
    if (!((File)localObject6).exists()) {
      ((File)localObject6).mkdirs();
    }
    Object localObject1 = localObject2;
    Object localObject5;
    int i;
    Object localObject7;
    Object localObject3;
    if (localObject2 == null)
    {
      localObject2 = Integer.valueOf(1);
      localObject5 = localObject2;
      try
      {
        localObject6 = ((File)localObject6).listFiles();
        localObject1 = localObject2;
        if (localObject6 != null)
        {
          localObject5 = localObject2;
          localObject1 = localObject2;
          if (localObject6.length > 0)
          {
            localObject5 = localObject2;
            int k = localObject6.length;
            i = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= k) {
                break;
              }
              localObject5 = localObject2;
              localObject7 = localObject6[i].getName();
              localObject1 = localObject2;
              localObject5 = localObject2;
              if (((String)localObject7).contains("log"))
              {
                localObject5 = localObject2;
                localObject7 = ((String)localObject7).substring(((String)localObject7).lastIndexOf("log") + 1);
                localObject1 = localObject2;
                localObject5 = localObject2;
                if (isInteger((String)localObject7))
                {
                  localObject1 = localObject2;
                  localObject5 = localObject2;
                  if (Integer.valueOf((String)localObject7).intValue() > ((Integer)localObject2).intValue())
                  {
                    localObject5 = localObject2;
                    localObject1 = Integer.valueOf((String)localObject7);
                  }
                }
              }
              i += 1;
              localObject2 = localObject1;
            }
          }
        }
        if (System.currentTimeMillis() - lastCheckLogSizeTime <= 60000L) {
          break label621;
        }
      }
      catch (Exception localException1)
      {
        localObject1 = localObject5;
        if (QLog.isColorLevel())
        {
          QLog.e("MiniLog", 2, paramString, localException1);
          localObject1 = localObject5;
        }
      }
    }
    else
    {
      lastCheckLogSizeTime = System.currentTimeMillis();
      localObject3 = localObject1;
    }
    for (;;)
    {
      try
      {
        if (bdcs.a(str + "log" + localObject1).length() <= MAX_MINI_LOG_SIZE) {
          break label621;
        }
        localObject3 = localObject1;
        if (((Integer)localObject1).intValue() >= 5) {
          continue;
        }
        localObject3 = localObject1;
        i = ((Integer)localObject1).intValue();
        localObject3 = Integer.valueOf(i + 1);
      }
      catch (Exception localException3)
      {
        localObject1 = localObject3;
        localObject3 = localException3;
        ((Exception)localObject3).printStackTrace();
        localObject3 = localObject1;
        continue;
      }
      mLastNumCache.put(paramString, localObject3);
      return str + "log" + localObject3;
      localObject3 = localObject1;
      new File(str + "log" + 1).delete();
      localObject1 = Integer.valueOf(1);
      i = j;
      localObject3 = localObject1;
      if (i <= 5)
      {
        try
        {
          localObject6 = new File(str + "log" + i);
          if (!((File)localObject6).exists()) {
            break label618;
          }
          if (QLog.isColorLevel()) {
            QLog.i("MiniLog", 2, "rename from file:log" + i + " to file:" + localObject1);
          }
          localObject7 = new StringBuilder().append(str).append("log");
          j = ((Integer)localObject1).intValue();
          localObject5 = Integer.valueOf(j + 1);
          localObject3 = localObject5;
          ((File)localObject6).renameTo(new File(localObject1));
          localObject1 = localObject5;
        }
        catch (Exception localException2)
        {
          continue;
          label618:
          continue;
        }
        i += 1;
        continue;
        label621:
        Object localObject4 = localObject1;
      }
    }
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    return QLog.getStackTraceString(paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    i(paramString1, paramInt, paramString2, paramString3, null);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (isEnableDebug(paramString2).booleanValue()) {
      addNativeLogItem(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
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
    i(paramString1, paramInt, paramString2, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    i(paramString1, paramInt, paramString2, null, paramVarArgs);
  }
  
  public static void init()
  {
    if ((sPool == null) && (BaseApplicationImpl.getApplication() != null))
    {
      sBuildNumber = AppSetting.a();
      processName = BaseApplicationImpl.getApplication().getQQProcessName();
      packageName = BaseApplicationImpl.getApplication().getPackageName();
      sPool = new RecyclablePool(MiniLog.QLogItem.class, 512);
    }
    MiniLogManager.init();
  }
  
  private static void initWriteHandler()
  {
    if (mWriteHandler == null) {
      try
      {
        if (mWriteHandler == null) {
          mWriteHandler = new MiniLog.WriteHandler(ThreadManager.getSubThreadLooper(), null);
        }
        return;
      }
      finally {}
    }
  }
  
  public static boolean isColorLevel(String paramString)
  {
    return (isEnableDebug(paramString).booleanValue()) || (QLog.isColorLevel());
  }
  
  public static boolean isDevelopLevel(String paramString)
  {
    return (isEnableDebug(paramString).booleanValue()) || (QLog.isDevelopLevel());
  }
  
  public static Boolean isEnableDebug(String paramString)
  {
    if ((debugControlMap.get(paramString) != null) && (((Boolean)debugControlMap.get(paramString)).booleanValue())) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  private static boolean isInteger(String paramString)
  {
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
  
  private static void miniFlushAndClean()
  {
    Iterator localIterator = miniFlushMap.values().iterator();
    while (localIterator.hasNext())
    {
      BufferedWriter localBufferedWriter = (BufferedWriter)localIterator.next();
      if (localBufferedWriter != null) {
        try
        {
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    miniFlushMap.clear();
  }
  
  private static void nativeFlushAndClean()
  {
    Iterator localIterator = nativeFlushMap.values().iterator();
    while (localIterator.hasNext())
    {
      BufferedWriter localBufferedWriter = (BufferedWriter)localIterator.next();
      if (localBufferedWriter != null) {
        try
        {
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    nativeFlushMap.clear();
  }
  
  public static void p(String paramString1, String paramString2)
  {
    QLog.p(paramString1, paramString2);
  }
  
  public static void setEnableDebug(String paramString, boolean paramBoolean)
  {
    debugControlMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    w(paramString1, paramInt, paramString2, paramString3, null);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (isEnableDebug(paramString2).booleanValue()) {
      addNativeLogItem(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
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
    w(paramString1, paramInt, paramString2, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    w(paramString1, paramInt, paramString2, null, paramVarArgs);
  }
  
  public static void writeMiniLog(String paramString1, String paramString2)
  {
    addMiniLogItem(getMiniLogPath(paramString1), paramString2);
  }
  
  private static void writeMiniLogToFile()
  {
    for (;;)
    {
      try
      {
        if (miniQueue.isEmpty()) {
          break label193;
        }
        localMiniItem = (MiniLog.MiniItem)miniQueue.poll();
        if ((localMiniItem == null) || (bdje.a(localMiniItem.filePath))) {
          continue;
        }
        str = localMiniItem.filePath;
        localFile = new File(str);
        if (localFile.exists()) {
          continue;
        }
        bdcs.a(str);
        localBufferedWriter1 = new BufferedWriter(new MiniLogWriter(localFile, true), 8192);
      }
      catch (Throwable localThrowable)
      {
        MiniLog.MiniItem localMiniItem;
        String str;
        File localFile;
        BufferedWriter localBufferedWriter1;
        if ((localThrowable.getMessage() == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.e("MiniLog", 2, localThrowable.getMessage());
        try
        {
          return;
        }
        finally {}
        localBufferedWriter2 = (BufferedWriter)miniFlushMap.get(str);
        localObject1 = localBufferedWriter2;
        if (localBufferedWriter2 != null) {
          continue;
        }
        localObject1 = new BufferedWriter(new MiniLogWriter(localFile, true), 8192);
        continue;
      }
      finally
      {
        miniFlushAndClean();
      }
      localBufferedWriter1.write(localMiniItem.msg);
      miniFlushMap.put(str, localBufferedWriter1);
    }
    for (;;)
    {
      BufferedWriter localBufferedWriter2;
      Object localObject1;
      label193:
      miniFlushAndClean();
    }
  }
  
  /* Error */
  private static void writeNativeLogToFile()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 84	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:processName	Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: getstatic 222	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sTail	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   12: astore 5
    //   14: getstatic 131	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sHead	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   17: astore_3
    //   18: aconst_null
    //   19: putstatic 222	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sTail	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   22: aconst_null
    //   23: putstatic 131	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sHead	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: ifnonnull +51 -> 82
    //   34: invokestatic 552	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: astore_3
    //   42: aload_2
    //   43: monitorexit
    //   44: aload_3
    //   45: athrow
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 545	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   51: ifnull +19 -> 70
    //   54: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +13 -> 70
    //   60: ldc 24
    //   62: iconst_2
    //   63: aload_2
    //   64: invokevirtual 545	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   67: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: invokestatic 552	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   73: goto -36 -> 37
    //   76: astore_2
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    //   82: aload_2
    //   83: astore_3
    //   84: aload_3
    //   85: getfield 200	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:logTime	J
    //   88: lstore_0
    //   89: lload_0
    //   90: getstatic 554	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   93: ldc2_w 171
    //   96: ladd
    //   97: lcmp
    //   98: ifge +11 -> 109
    //   101: lload_0
    //   102: getstatic 554	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   105: lcmp
    //   106: ifge +50 -> 156
    //   109: getstatic 109	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:timeFormatter	Ljava/text/SimpleDateFormat;
    //   112: lload_0
    //   113: invokestatic 559	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: invokevirtual 563	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: putstatic 74	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logTime	Ljava/lang/String;
    //   122: lload_0
    //   123: getstatic 554	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   126: ldc2_w 171
    //   129: ladd
    //   130: lcmp
    //   131: iflt +346 -> 477
    //   134: lload_0
    //   135: getstatic 554	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   138: ldc2_w 564
    //   141: ladd
    //   142: lcmp
    //   143: ifge +334 -> 477
    //   146: getstatic 554	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   149: ldc2_w 171
    //   152: ladd
    //   153: putstatic 554	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   156: new 64	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   163: aload_3
    //   164: getfield 220	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:appId	Ljava/lang/String;
    //   167: invokestatic 325	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:getMiniLogFolderPath	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 105	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logFileFormatter	Ljava/text/SimpleDateFormat;
    //   176: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   179: invokestatic 559	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: invokevirtual 563	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   185: invokestatic 567	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:getLogFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   188: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore 6
    //   196: new 333	java/io/File
    //   199: dup
    //   200: aload 6
    //   202: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: astore 7
    //   207: aload 7
    //   209: invokevirtual 337	java/io/File:exists	()Z
    //   212: ifne +297 -> 509
    //   215: aload 6
    //   217: invokestatic 381	bdcs:a	(Ljava/lang/String;)Ljava/io/File;
    //   220: pop
    //   221: new 494	java/io/BufferedWriter
    //   224: dup
    //   225: new 532	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter
    //   228: dup
    //   229: aload 7
    //   231: iconst_1
    //   232: invokespecial 535	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   235: sipush 8192
    //   238: invokespecial 538	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   241: astore_2
    //   242: aload_2
    //   243: new 64	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   250: getstatic 74	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logTime	Ljava/lang/String;
    //   253: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 569
    //   259: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: getstatic 84	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:processName	Ljava/lang/String;
    //   265: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 571
    //   271: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: getstatic 88	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sBuildNumber	Ljava/lang/String;
    //   277: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 573
    //   283: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokevirtual 541	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   292: getstatic 70	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sBuilder	Ljava/lang/StringBuilder;
    //   295: iconst_0
    //   296: getstatic 70	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sBuilder	Ljava/lang/StringBuilder;
    //   299: invokevirtual 575	java/lang/StringBuilder:length	()I
    //   302: invokevirtual 578	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   305: astore 4
    //   307: aload 4
    //   309: getstatic 74	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logTime	Ljava/lang/String;
    //   312: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: bipush 124
    //   317: invokevirtual 581	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   320: aload_3
    //   321: getfield 200	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:logTime	J
    //   324: invokevirtual 584	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   327: aload_3
    //   328: getfield 220	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:appId	Ljava/lang/String;
    //   331: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: bipush 91
    //   336: invokevirtual 581	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   339: getstatic 82	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:myProcessId	I
    //   342: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: bipush 93
    //   347: invokevirtual 581	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   350: aload_3
    //   351: getfield 206	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:threadId	I
    //   354: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: bipush 124
    //   359: invokevirtual 581	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   362: aload_3
    //   363: getfield 209	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:level	I
    //   366: invokestatic 587	com/tencent/qphone/base/util/QLog:getReportLevel	(I)Ljava/lang/String;
    //   369: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: bipush 124
    //   374: invokevirtual 581	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   377: aload_3
    //   378: getfield 212	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:tag	Ljava/lang/String;
    //   381: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: bipush 124
    //   386: invokevirtual 581	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   389: aload_3
    //   390: getfield 213	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:msg	Ljava/lang/String;
    //   393: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: bipush 10
    //   398: invokevirtual 581	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_2
    //   403: aload 4
    //   405: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokevirtual 541	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   411: aload_3
    //   412: getfield 217	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:trace	Ljava/lang/Throwable;
    //   415: ifnull +20 -> 435
    //   418: aload_2
    //   419: aload_3
    //   420: getfield 217	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:trace	Ljava/lang/Throwable;
    //   423: invokestatic 590	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   426: invokevirtual 541	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   429: aload_2
    //   430: bipush 10
    //   432: invokevirtual 592	java/io/BufferedWriter:write	(I)V
    //   435: getstatic 96	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushMap	Ljava/util/Map;
    //   438: aload 6
    //   440: aload_2
    //   441: invokeinterface 542 3 0
    //   446: pop
    //   447: aload_3
    //   448: invokevirtual 596	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:getNext	()Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   451: checkcast 186	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem
    //   454: astore_2
    //   455: getstatic 135	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sPool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   458: aload_3
    //   459: invokevirtual 600	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   462: aload_3
    //   463: aload 5
    //   465: if_acmpne -383 -> 82
    //   468: invokestatic 552	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   471: invokestatic 552	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   474: goto -437 -> 37
    //   477: invokestatic 606	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   480: astore_2
    //   481: aload_2
    //   482: lload_0
    //   483: invokevirtual 610	java/util/Calendar:setTimeInMillis	(J)V
    //   486: aload_2
    //   487: bipush 14
    //   489: iconst_0
    //   490: invokevirtual 614	java/util/Calendar:set	(II)V
    //   493: aload_2
    //   494: invokevirtual 617	java/util/Calendar:getTimeInMillis	()J
    //   497: putstatic 554	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   500: goto -344 -> 156
    //   503: astore_2
    //   504: invokestatic 552	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   507: aload_2
    //   508: athrow
    //   509: getstatic 96	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushMap	Ljava/util/Map;
    //   512: aload 6
    //   514: invokeinterface 550 2 0
    //   519: checkcast 494	java/io/BufferedWriter
    //   522: astore 4
    //   524: aload 4
    //   526: astore_2
    //   527: aload 4
    //   529: ifnonnull -237 -> 292
    //   532: new 494	java/io/BufferedWriter
    //   535: dup
    //   536: new 532	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter
    //   539: dup
    //   540: aload 7
    //   542: iconst_1
    //   543: invokespecial 535	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   546: sipush 8192
    //   549: invokespecial 538	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   552: astore_2
    //   553: goto -261 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   88	395	0	l	long
    //   46	18	2	localThrowable	Throwable
    //   76	7	2	localObject2	Object
    //   241	253	2	localObject3	Object
    //   503	5	2	localObject4	Object
    //   526	27	2	localObject5	Object
    //   17	14	3	localQLogItem1	MiniLog.QLogItem
    //   41	4	3	localObject6	Object
    //   83	380	3	localObject7	Object
    //   305	223	4	localObject8	Object
    //   12	452	5	localQLogItem2	MiniLog.QLogItem
    //   194	319	6	str	String
    //   205	336	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   9	28	41	finally
    //   42	44	41	finally
    //   3	9	46	java/lang/Throwable
    //   44	46	46	java/lang/Throwable
    //   84	109	46	java/lang/Throwable
    //   109	156	46	java/lang/Throwable
    //   156	292	46	java/lang/Throwable
    //   292	435	46	java/lang/Throwable
    //   435	462	46	java/lang/Throwable
    //   468	471	46	java/lang/Throwable
    //   477	500	46	java/lang/Throwable
    //   509	524	46	java/lang/Throwable
    //   532	553	46	java/lang/Throwable
    //   34	37	76	finally
    //   70	73	76	finally
    //   471	474	76	finally
    //   504	509	76	finally
    //   3	9	503	finally
    //   44	46	503	finally
    //   47	70	503	finally
    //   84	109	503	finally
    //   109	156	503	finally
    //   156	292	503	finally
    //   292	435	503	finally
    //   435	462	503	finally
    //   468	471	503	finally
    //   477	500	503	finally
    //   509	524	503	finally
    //   532	553	503	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLog
 * JD-Core Version:    0.7.0.1
 */