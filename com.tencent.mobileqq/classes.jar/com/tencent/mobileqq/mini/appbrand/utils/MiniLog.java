package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Process;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
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
    sHead = null;
    sTail = null;
    packageName = "";
    sBuildNumber = "";
    debugControlMap = new HashMap();
    nativeFlushMap = new HashMap();
    logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");
    timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    miniFlushMap = new HashMap();
    miniQueue = new LinkedBlockingQueue(256);
    mLastNumCache = new LruCache(5);
    lastCheckLogSizeTime = 0L;
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
    if (sPool != null)
    {
      if (StringUtil.a(???)) {
        return;
      }
      MiniLog.QLogItem localQLogItem = (MiniLog.QLogItem)sPool.obtain(MiniLog.QLogItem.class);
      if (localQLogItem == null) {
        return;
      }
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
        }
        else
        {
          sTail.changeNext(localQLogItem, true);
          sTail = localQLogItem;
        }
        initWriteHandler();
        mWriteHandler.removeMessages(1);
        mWriteHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
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
    e(paramString1, paramInt, paramString2, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    e(paramString1, paramInt, paramString2, null, paramVarArgs);
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
  
  public static String getMiniLogFolderPath()
  {
    return MiniAppGlobal.getMiniCacheFilePath();
  }
  
  public static String getMiniLogFolderPath(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniAppGlobal.getMiniCacheFilePath());
    localStringBuilder.append(MD5.toMD5(paramString));
    localStringBuilder.append("/");
    localStringBuilder.append(str);
    localStringBuilder.append("/miniprogramLog/");
    return localStringBuilder.toString();
  }
  
  private static String getMiniLogPath(String paramString)
  {
    String str1 = getMiniLogFolderPath(paramString);
    Object localObject3 = (Integer)mLastNumCache.get(paramString);
    Object localObject7 = new File(str1);
    if (!((File)localObject7).exists()) {
      ((File)localObject7).mkdirs();
    }
    Object localObject1 = localObject3;
    Object localObject6;
    int i;
    if (localObject3 == null)
    {
      localObject3 = Integer.valueOf(1);
      localObject6 = localObject3;
      try
      {
        localObject7 = ((File)localObject7).listFiles();
        localObject1 = localObject3;
        if (localObject7 != null)
        {
          localObject6 = localObject3;
          localObject1 = localObject3;
          if (localObject7.length > 0)
          {
            localObject6 = localObject3;
            int j = localObject7.length;
            i = 0;
            for (;;)
            {
              localObject1 = localObject3;
              if (i >= j) {
                break;
              }
              localObject6 = localObject3;
              String str2 = localObject7[i].getName();
              localObject1 = localObject3;
              localObject6 = localObject3;
              if (str2.contains("log"))
              {
                localObject6 = localObject3;
                str2 = str2.substring(str2.lastIndexOf("log") + 1);
                localObject1 = localObject3;
                localObject6 = localObject3;
                if (isInteger(str2))
                {
                  localObject1 = localObject3;
                  localObject6 = localObject3;
                  if (Integer.valueOf(str2).intValue() > ((Integer)localObject3).intValue())
                  {
                    localObject6 = localObject3;
                    localObject1 = Integer.valueOf(str2);
                  }
                }
              }
              i += 1;
              localObject3 = localObject1;
            }
          }
        }
        localObject4 = localObject1;
      }
      catch (Exception localException2)
      {
        localObject1 = localObject6;
        if (QLog.isColorLevel())
        {
          QLog.e("MiniLog", 2, paramString, localException2);
          localObject1 = localObject6;
        }
      }
    }
    Object localObject4;
    label609:
    Object localObject5;
    if (System.currentTimeMillis() - lastCheckLogSizeTime > 60000L)
    {
      lastCheckLogSizeTime = System.currentTimeMillis();
      Object localObject2;
      try
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(str1);
        ((StringBuilder)localObject6).append("log");
        ((StringBuilder)localObject6).append(localObject1);
        localObject4 = localObject1;
        if (FileUtils.createFile(((StringBuilder)localObject6).toString()).length() <= MAX_MINI_LOG_SIZE) {
          break label617;
        }
        if (((Integer)localObject1).intValue() < 5)
        {
          localObject4 = Integer.valueOf(((Integer)localObject1).intValue() + 1);
          break label617;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(str1);
        ((StringBuilder)localObject4).append("log");
        ((StringBuilder)localObject4).append(1);
        new File(((StringBuilder)localObject4).toString()).delete();
        localObject1 = Integer.valueOf(1);
        i = 2;
        for (;;)
        {
          localObject4 = localObject1;
          if (i > 5) {
            break label617;
          }
          try
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(str1);
            ((StringBuilder)localObject4).append("log");
            ((StringBuilder)localObject4).append(i);
            localObject6 = new File(((StringBuilder)localObject4).toString());
            localObject4 = localObject1;
            if (((File)localObject6).exists())
            {
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("rename from file:log");
                ((StringBuilder)localObject4).append(i);
                ((StringBuilder)localObject4).append(" to file:");
                ((StringBuilder)localObject4).append(localObject1);
                QLog.i("MiniLog", 2, ((StringBuilder)localObject4).toString());
              }
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append(str1);
              ((StringBuilder)localObject7).append("log");
              localObject4 = Integer.valueOf(((Integer)localObject1).intValue() + 1);
              try
              {
                ((StringBuilder)localObject7).append(localObject1);
                ((File)localObject6).renameTo(new File(((StringBuilder)localObject7).toString()));
              }
              catch (Exception localException1)
              {
                localObject6 = localObject4;
                localObject4 = localException1;
                localObject2 = localObject6;
                break label609;
              }
            }
            i += 1;
            localObject2 = localObject4;
          }
          catch (Exception localException3) {}
        }
        localException4.printStackTrace();
      }
      catch (Exception localException4) {}
      localObject5 = localObject2;
    }
    label617:
    mLastNumCache.put(paramString, localObject5);
    paramString = new StringBuilder();
    paramString.append(str1);
    paramString.append("log");
    paramString.append(localObject5);
    return paramString.toString();
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
    boolean bool;
    if ((debugControlMap.get(paramString) != null) && (((Boolean)debugControlMap.get(paramString)).booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
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
  
  /* Error */
  private static void writeMiniLogToFile()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 120	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:miniQueue	Ljava/util/concurrent/LinkedBlockingQueue;
    //   6: invokevirtual 528	java/util/concurrent/LinkedBlockingQueue:isEmpty	()Z
    //   9: ifne +144 -> 153
    //   12: getstatic 120	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:miniQueue	Ljava/util/concurrent/LinkedBlockingQueue;
    //   15: invokevirtual 531	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   18: checkcast 153	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$MiniItem
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -20 -> 3
    //   26: aload_2
    //   27: getfield 160	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$MiniItem:filePath	Ljava/lang/String;
    //   30: invokestatic 188	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   33: ifeq +6 -> 39
    //   36: goto -33 -> 3
    //   39: aload_2
    //   40: getfield 160	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$MiniItem:filePath	Ljava/lang/String;
    //   43: astore_3
    //   44: new 335	java/io/File
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 4
    //   54: aload 4
    //   56: invokevirtual 339	java/io/File:exists	()Z
    //   59: ifne +32 -> 91
    //   62: aload_3
    //   63: invokestatic 382	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   66: pop
    //   67: new 495	java/io/BufferedWriter
    //   70: dup
    //   71: new 533	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter
    //   74: dup
    //   75: aload 4
    //   77: iconst_1
    //   78: invokespecial 536	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   81: sipush 8192
    //   84: invokespecial 539	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   87: astore_0
    //   88: goto +43 -> 131
    //   91: getstatic 115	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:miniFlushMap	Ljava/util/Map;
    //   94: aload_3
    //   95: invokeinterface 540 2 0
    //   100: checkcast 495	java/io/BufferedWriter
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_1
    //   107: ifnonnull +24 -> 131
    //   110: new 495	java/io/BufferedWriter
    //   113: dup
    //   114: new 533	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter
    //   117: dup
    //   118: aload 4
    //   120: iconst_1
    //   121: invokespecial 536	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   124: sipush 8192
    //   127: invokespecial 539	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   130: astore_0
    //   131: aload_0
    //   132: aload_2
    //   133: getfield 157	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$MiniItem:msg	Ljava/lang/String;
    //   136: invokevirtual 543	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   139: getstatic 115	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:miniFlushMap	Ljava/util/Map;
    //   142: aload_3
    //   143: aload_0
    //   144: invokeinterface 544 3 0
    //   149: pop
    //   150: goto -147 -> 3
    //   153: invokestatic 546	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:miniFlushAndClean	()V
    //   156: goto +34 -> 190
    //   159: astore_0
    //   160: goto +34 -> 194
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 549	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   168: ifnull -15 -> 153
    //   171: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -21 -> 153
    //   177: ldc 24
    //   179: iconst_2
    //   180: aload_0
    //   181: invokevirtual 549	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   184: invokestatic 551	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: goto -34 -> 153
    //   190: ldc 2
    //   192: monitorexit
    //   193: return
    //   194: invokestatic 546	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:miniFlushAndClean	()V
    //   197: aload_0
    //   198: athrow
    //   199: astore_0
    //   200: ldc 2
    //   202: monitorexit
    //   203: goto +5 -> 208
    //   206: aload_0
    //   207: athrow
    //   208: goto -2 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   87	57	0	localObject1	Object
    //   159	1	0	localObject2	Object
    //   163	35	0	localThrowable	Throwable
    //   199	8	0	localObject3	Object
    //   103	4	1	localBufferedWriter	BufferedWriter
    //   21	112	2	localMiniItem	MiniLog.MiniItem
    //   43	100	3	str	String
    //   52	67	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	22	159	finally
    //   26	36	159	finally
    //   39	88	159	finally
    //   91	104	159	finally
    //   110	131	159	finally
    //   131	150	159	finally
    //   164	187	159	finally
    //   3	22	163	java/lang/Throwable
    //   26	36	163	java/lang/Throwable
    //   39	88	163	java/lang/Throwable
    //   91	104	163	java/lang/Throwable
    //   110	131	163	java/lang/Throwable
    //   131	150	163	java/lang/Throwable
    //   153	156	199	finally
    //   194	199	199	finally
  }
  
  /* Error */
  private static void writeNativeLogToFile()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 84	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:processName	Ljava/lang/String;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: getstatic 88	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sTail	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   12: astore 5
    //   14: getstatic 86	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sHead	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   17: astore_2
    //   18: aconst_null
    //   19: putstatic 88	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sTail	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   22: aconst_null
    //   23: putstatic 86	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sHead	Lcom/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem;
    //   26: aload_3
    //   27: monitorexit
    //   28: aload_2
    //   29: astore_3
    //   30: aload_2
    //   31: ifnonnull +10 -> 41
    //   34: invokestatic 553	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: aload_3
    //   42: getfield 204	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:logTime	J
    //   45: lstore_0
    //   46: lload_0
    //   47: getstatic 555	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   50: ldc2_w 175
    //   53: ladd
    //   54: lcmp
    //   55: ifge +11 -> 66
    //   58: lload_0
    //   59: getstatic 555	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   62: lcmp
    //   63: ifge +76 -> 139
    //   66: getstatic 113	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:timeFormatter	Ljava/text/SimpleDateFormat;
    //   69: lload_0
    //   70: invokestatic 560	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: invokevirtual 564	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   76: putstatic 74	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logTime	Ljava/lang/String;
    //   79: lload_0
    //   80: getstatic 555	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   83: ldc2_w 175
    //   86: ladd
    //   87: lcmp
    //   88: iflt +28 -> 116
    //   91: lload_0
    //   92: getstatic 555	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   95: ldc2_w 565
    //   98: ladd
    //   99: lcmp
    //   100: ifge +16 -> 116
    //   103: getstatic 555	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   106: ldc2_w 175
    //   109: ladd
    //   110: putstatic 555	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   113: goto +26 -> 139
    //   116: invokestatic 572	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   119: astore_2
    //   120: aload_2
    //   121: lload_0
    //   122: invokevirtual 576	java/util/Calendar:setTimeInMillis	(J)V
    //   125: aload_2
    //   126: bipush 14
    //   128: iconst_0
    //   129: invokevirtual 580	java/util/Calendar:set	(II)V
    //   132: aload_2
    //   133: invokevirtual 583	java/util/Calendar:getTimeInMillis	()J
    //   136: putstatic 555	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:currentLogSecond	J
    //   139: new 64	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   146: astore_2
    //   147: aload_2
    //   148: aload_3
    //   149: getfield 224	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:appId	Ljava/lang/String;
    //   152: invokestatic 327	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:getMiniLogFolderPath	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_2
    //   160: getstatic 109	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logFileFormatter	Ljava/text/SimpleDateFormat;
    //   163: invokestatic 202	java/lang/System:currentTimeMillis	()J
    //   166: invokestatic 560	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   169: invokevirtual 564	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokestatic 585	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:getLogFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore 6
    //   185: new 335	java/io/File
    //   188: dup
    //   189: aload 6
    //   191: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore 7
    //   196: aload 7
    //   198: invokevirtual 339	java/io/File:exists	()Z
    //   201: ifne +105 -> 306
    //   204: aload 6
    //   206: invokestatic 382	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   209: pop
    //   210: new 495	java/io/BufferedWriter
    //   213: dup
    //   214: new 533	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter
    //   217: dup
    //   218: aload 7
    //   220: iconst_1
    //   221: invokespecial 536	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   224: sipush 8192
    //   227: invokespecial 539	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   230: astore_2
    //   231: new 64	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   238: astore 4
    //   240: aload 4
    //   242: getstatic 74	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logTime	Ljava/lang/String;
    //   245: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 4
    //   251: ldc_w 587
    //   254: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 4
    //   260: getstatic 84	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:processName	Ljava/lang/String;
    //   263: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 4
    //   269: ldc_w 589
    //   272: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 4
    //   278: getstatic 92	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sBuildNumber	Ljava/lang/String;
    //   281: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 4
    //   287: ldc_w 591
    //   290: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_2
    //   295: aload 4
    //   297: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokevirtual 543	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   303: goto +47 -> 350
    //   306: getstatic 100	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushMap	Ljava/util/Map;
    //   309: aload 6
    //   311: invokeinterface 540 2 0
    //   316: checkcast 495	java/io/BufferedWriter
    //   319: astore 4
    //   321: aload 4
    //   323: astore_2
    //   324: aload 4
    //   326: ifnonnull +24 -> 350
    //   329: new 495	java/io/BufferedWriter
    //   332: dup
    //   333: new 533	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter
    //   336: dup
    //   337: aload 7
    //   339: iconst_1
    //   340: invokespecial 536	com/tencent/mobileqq/mini/appbrand/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   343: sipush 8192
    //   346: invokespecial 539	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   349: astore_2
    //   350: getstatic 70	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sBuilder	Ljava/lang/StringBuilder;
    //   353: iconst_0
    //   354: getstatic 70	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sBuilder	Ljava/lang/StringBuilder;
    //   357: invokevirtual 593	java/lang/StringBuilder:length	()I
    //   360: invokevirtual 596	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   363: astore 4
    //   365: aload 4
    //   367: getstatic 74	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:logTime	Ljava/lang/String;
    //   370: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 4
    //   376: bipush 124
    //   378: invokevirtual 599	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 4
    //   384: aload_3
    //   385: getfield 204	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:logTime	J
    //   388: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 4
    //   394: aload_3
    //   395: getfield 224	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:appId	Ljava/lang/String;
    //   398: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 4
    //   404: bipush 91
    //   406: invokevirtual 599	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 4
    //   412: getstatic 82	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:myProcessId	I
    //   415: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 4
    //   421: bipush 93
    //   423: invokevirtual 599	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 4
    //   429: aload_3
    //   430: getfield 210	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:threadId	I
    //   433: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 4
    //   439: bipush 124
    //   441: invokevirtual 599	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 4
    //   447: aload_3
    //   448: getfield 213	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:level	I
    //   451: invokestatic 605	com/tencent/qphone/base/util/QLog:getReportLevel	(I)Ljava/lang/String;
    //   454: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 4
    //   460: bipush 124
    //   462: invokevirtual 599	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 4
    //   468: aload_3
    //   469: getfield 216	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:tag	Ljava/lang/String;
    //   472: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 4
    //   478: bipush 124
    //   480: invokevirtual 599	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 4
    //   486: aload_3
    //   487: getfield 217	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:msg	Ljava/lang/String;
    //   490: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 4
    //   496: bipush 10
    //   498: invokevirtual 599	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_2
    //   503: aload 4
    //   505: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 543	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   511: aload_3
    //   512: getfield 221	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:trace	Ljava/lang/Throwable;
    //   515: ifnull +20 -> 535
    //   518: aload_2
    //   519: aload_3
    //   520: getfield 221	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:trace	Ljava/lang/Throwable;
    //   523: invokestatic 608	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   526: invokevirtual 543	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   529: aload_2
    //   530: bipush 10
    //   532: invokevirtual 610	java/io/BufferedWriter:write	(I)V
    //   535: getstatic 100	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushMap	Ljava/util/Map;
    //   538: aload 6
    //   540: aload_2
    //   541: invokeinterface 544 3 0
    //   546: pop
    //   547: aload_3
    //   548: invokevirtual 614	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem:getNext	()Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   551: checkcast 190	com/tencent/mobileqq/mini/appbrand/utils/MiniLog$QLogItem
    //   554: astore_2
    //   555: getstatic 139	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:sPool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   558: aload_3
    //   559: invokevirtual 618	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   562: aload_3
    //   563: aload 5
    //   565: if_acmpne +12 -> 577
    //   568: invokestatic 553	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   571: invokestatic 553	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   574: goto +44 -> 618
    //   577: aload_2
    //   578: astore_3
    //   579: goto -538 -> 41
    //   582: astore_2
    //   583: aload_3
    //   584: monitorexit
    //   585: aload_2
    //   586: athrow
    //   587: astore_2
    //   588: goto +34 -> 622
    //   591: astore_2
    //   592: aload_2
    //   593: invokevirtual 549	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   596: ifnull -25 -> 571
    //   599: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq -31 -> 571
    //   605: ldc 24
    //   607: iconst_2
    //   608: aload_2
    //   609: invokevirtual 549	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   612: invokestatic 551	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: goto -44 -> 571
    //   618: ldc 2
    //   620: monitorexit
    //   621: return
    //   622: invokestatic 553	com/tencent/mobileqq/mini/appbrand/utils/MiniLog:nativeFlushAndClean	()V
    //   625: aload_2
    //   626: athrow
    //   627: astore_2
    //   628: ldc 2
    //   630: monitorexit
    //   631: goto +5 -> 636
    //   634: aload_2
    //   635: athrow
    //   636: goto -2 -> 634
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	77	0	l	long
    //   17	561	2	localObject1	Object
    //   582	4	2	localObject2	Object
    //   587	1	2	localObject3	Object
    //   591	35	2	localThrowable	Throwable
    //   627	8	2	localObject4	Object
    //   238	266	4	localObject6	Object
    //   12	552	5	localQLogItem	MiniLog.QLogItem
    //   183	356	6	str	String
    //   194	144	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   9	28	582	finally
    //   583	585	582	finally
    //   3	9	587	finally
    //   41	66	587	finally
    //   66	113	587	finally
    //   116	139	587	finally
    //   139	303	587	finally
    //   306	321	587	finally
    //   329	350	587	finally
    //   350	535	587	finally
    //   535	562	587	finally
    //   568	571	587	finally
    //   585	587	587	finally
    //   592	615	587	finally
    //   3	9	591	java/lang/Throwable
    //   41	66	591	java/lang/Throwable
    //   66	113	591	java/lang/Throwable
    //   116	139	591	java/lang/Throwable
    //   139	303	591	java/lang/Throwable
    //   306	321	591	java/lang/Throwable
    //   329	350	591	java/lang/Throwable
    //   350	535	591	java/lang/Throwable
    //   535	562	591	java/lang/Throwable
    //   568	571	591	java/lang/Throwable
    //   585	587	591	java/lang/Throwable
    //   34	37	627	finally
    //   571	574	627	finally
    //   622	627	627	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLog
 * JD-Core Version:    0.7.0.1
 */