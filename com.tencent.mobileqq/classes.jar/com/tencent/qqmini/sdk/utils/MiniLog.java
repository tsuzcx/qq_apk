package com.tencent.qqmini.sdk.utils;

import android.os.Handler;
import android.util.LruCache;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiniLog
{
  public static final int MAX_MINI_LOG_NUM = 5;
  private static long MAX_MINI_LOG_SIZE = 1048576L;
  public static final String MINI_LOG_TAG = "log";
  private static final String TAG = "MiniLog";
  private static final int WRITE_MINI_LOG_MSG = 2;
  private static final int WRITE_NATIVE_LOG_MSG = 1;
  private static long lastCheckLogSizeTime;
  private static LruCache<String, Integer> mLastNumCache;
  private static volatile MiniLog.WriteHandler mWriteHandler;
  private static Map<String, BufferedWriter> miniFlushMap = new HashMap();
  private static LinkedBlockingQueue<MiniLog.MiniItem> miniQueue = new LinkedBlockingQueue(256);
  
  static
  {
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
  
  private static Integer getLastLogNum(String paramString, Integer paramInteger, File paramFile)
  {
    localObject = paramInteger;
    if (paramInteger == null)
    {
      paramInteger = Integer.valueOf(1);
      localObject = paramInteger;
      try
      {
        File[] arrayOfFile = paramFile.listFiles();
        paramFile = paramInteger;
        if (arrayOfFile != null)
        {
          localObject = paramInteger;
          paramFile = paramInteger;
          if (arrayOfFile.length > 0)
          {
            localObject = paramInteger;
            int j = arrayOfFile.length;
            int i = 0;
            for (;;)
            {
              paramFile = paramInteger;
              if (i >= j) {
                break;
              }
              localObject = paramInteger;
              String str = arrayOfFile[i].getName();
              paramFile = paramInteger;
              localObject = paramInteger;
              if (str.contains("log"))
              {
                localObject = paramInteger;
                str = str.substring(str.lastIndexOf("log") + 1);
                paramFile = paramInteger;
                localObject = paramInteger;
                if (isInteger(str))
                {
                  paramFile = paramInteger;
                  localObject = paramInteger;
                  if (Integer.valueOf(str).intValue() > paramInteger.intValue())
                  {
                    localObject = paramInteger;
                    paramFile = Integer.valueOf(str);
                  }
                }
              }
              i += 1;
              paramInteger = paramFile;
            }
          }
        }
        return localObject;
      }
      catch (Exception paramInteger)
      {
        QMLog.e("MiniLog", paramString, paramInteger);
        paramFile = (File)localObject;
        localObject = paramFile;
      }
    }
  }
  
  public static String getMiniLogFolderPath()
  {
    return MiniSDKConst.getMiniCacheFilePath();
  }
  
  public static String getMiniLogFolderPath(String paramString)
  {
    String str = LoginManager.getInstance().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniSDKConst.getMiniCacheFilePath());
    localStringBuilder.append(MD5Utils.toMD5(paramString));
    localStringBuilder.append("/");
    localStringBuilder.append(str);
    localStringBuilder.append("/miniprogramLog/");
    return localStringBuilder.toString();
  }
  
  private static String getMiniLogPath(String paramString)
  {
    String str = getMiniLogFolderPath(paramString);
    Integer localInteger1 = (Integer)mLastNumCache.get(paramString);
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localInteger1 = getLastLogNum(paramString, localInteger1, (File)localObject2);
    localObject2 = localInteger1;
    if (System.currentTimeMillis() - lastCheckLogSizeTime > 60000L)
    {
      lastCheckLogSizeTime = System.currentTimeMillis();
      Integer localInteger2 = localInteger1;
      try
      {
        Object localObject3 = new StringBuilder();
        localInteger2 = localInteger1;
        ((StringBuilder)localObject3).append(str);
        localInteger2 = localInteger1;
        ((StringBuilder)localObject3).append("log");
        localInteger2 = localInteger1;
        ((StringBuilder)localObject3).append(localInteger1);
        localInteger2 = localInteger1;
        localObject2 = localInteger1;
        if (FileUtils.createFile(((StringBuilder)localObject3).toString()).length() > MAX_MINI_LOG_SIZE)
        {
          localInteger2 = localInteger1;
          if (localInteger1.intValue() < 5)
          {
            localInteger2 = localInteger1;
            localObject2 = Integer.valueOf(localInteger1.intValue() + 1);
          }
          else
          {
            localInteger2 = localInteger1;
            localObject2 = new StringBuilder();
            localInteger2 = localInteger1;
            ((StringBuilder)localObject2).append(str);
            localInteger2 = localInteger1;
            ((StringBuilder)localObject2).append("log");
            localInteger2 = localInteger1;
            ((StringBuilder)localObject2).append(1);
            localInteger2 = localInteger1;
            new File(((StringBuilder)localObject2).toString()).delete();
            localInteger2 = localInteger1;
            localInteger1 = Integer.valueOf(1);
            int i = 2;
            for (;;)
            {
              localObject2 = localInteger1;
              if (i > 5) {
                break label463;
              }
              localInteger2 = localInteger1;
              localObject2 = new StringBuilder();
              localInteger2 = localInteger1;
              ((StringBuilder)localObject2).append(str);
              localInteger2 = localInteger1;
              ((StringBuilder)localObject2).append("log");
              localInteger2 = localInteger1;
              ((StringBuilder)localObject2).append(i);
              localInteger2 = localInteger1;
              localObject3 = new File(((StringBuilder)localObject2).toString());
              localObject2 = localInteger1;
              localInteger2 = localInteger1;
              if (((File)localObject3).exists())
              {
                localInteger2 = localInteger1;
                localObject2 = new StringBuilder();
                localInteger2 = localInteger1;
                ((StringBuilder)localObject2).append("rename from file:log");
                localInteger2 = localInteger1;
                ((StringBuilder)localObject2).append(i);
                localInteger2 = localInteger1;
                ((StringBuilder)localObject2).append(" to file:");
                localInteger2 = localInteger1;
                ((StringBuilder)localObject2).append(localInteger1);
                localInteger2 = localInteger1;
                QMLog.i("MiniLog", ((StringBuilder)localObject2).toString());
                localInteger2 = localInteger1;
                StringBuilder localStringBuilder = new StringBuilder();
                localInteger2 = localInteger1;
                localStringBuilder.append(str);
                localInteger2 = localInteger1;
                localStringBuilder.append("log");
                localInteger2 = localInteger1;
                localObject2 = Integer.valueOf(localInteger1.intValue() + 1);
                try
                {
                  localStringBuilder.append(localInteger1);
                  ((File)localObject3).renameTo(new File(localStringBuilder.toString()));
                }
                catch (Exception localException1)
                {
                  break;
                }
              }
              i += 1;
              Object localObject1 = localObject2;
            }
          }
        }
        mLastNumCache.put(paramString, localObject2);
      }
      catch (Exception localException2)
      {
        localObject2 = localInteger2;
        localException2.printStackTrace();
      }
    }
    label463:
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append("log");
    paramString.append(localObject2);
    return paramString.toString();
  }
  
  private static void initWriteHandler()
  {
    if (mWriteHandler == null) {
      try
      {
        if (mWriteHandler == null) {
          mWriteHandler = new MiniLog.WriteHandler(ThreadManager.getSubThreadHandler().getLooper(), null);
        }
        return;
      }
      finally {}
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
    //   3: getstatic 50	com/tencent/qqmini/sdk/utils/MiniLog:miniQueue	Ljava/util/concurrent/LinkedBlockingQueue;
    //   6: invokevirtual 324	java/util/concurrent/LinkedBlockingQueue:isEmpty	()Z
    //   9: ifne +144 -> 153
    //   12: getstatic 50	com/tencent/qqmini/sdk/utils/MiniLog:miniQueue	Ljava/util/concurrent/LinkedBlockingQueue;
    //   15: invokevirtual 327	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   18: checkcast 73	com/tencent/qqmini/sdk/utils/MiniLog$MiniItem
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -20 -> 3
    //   26: aload_2
    //   27: getfield 80	com/tencent/qqmini/sdk/utils/MiniLog$MiniItem:filePath	Ljava/lang/String;
    //   30: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +6 -> 39
    //   36: goto -33 -> 3
    //   39: aload_2
    //   40: getfield 80	com/tencent/qqmini/sdk/utils/MiniLog$MiniItem:filePath	Ljava/lang/String;
    //   43: astore_3
    //   44: new 112	java/io/File
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 4
    //   54: aload 4
    //   56: invokevirtual 200	java/io/File:exists	()Z
    //   59: ifne +32 -> 91
    //   62: aload_3
    //   63: invokestatic 222	com/tencent/qqmini/sdk/core/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   66: pop
    //   67: new 305	java/io/BufferedWriter
    //   70: dup
    //   71: new 333	com/tencent/qqmini/sdk/utils/MiniLogWriter
    //   74: dup
    //   75: aload 4
    //   77: iconst_1
    //   78: invokespecial 336	com/tencent/qqmini/sdk/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   81: sipush 8192
    //   84: invokespecial 339	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   87: astore_0
    //   88: goto +43 -> 131
    //   91: getstatic 43	com/tencent/qqmini/sdk/utils/MiniLog:miniFlushMap	Ljava/util/Map;
    //   94: aload_3
    //   95: invokeinterface 340 2 0
    //   100: checkcast 305	java/io/BufferedWriter
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_1
    //   107: ifnonnull +24 -> 131
    //   110: new 305	java/io/BufferedWriter
    //   113: dup
    //   114: new 333	com/tencent/qqmini/sdk/utils/MiniLogWriter
    //   117: dup
    //   118: aload 4
    //   120: iconst_1
    //   121: invokespecial 336	com/tencent/qqmini/sdk/utils/MiniLogWriter:<init>	(Ljava/io/File;Z)V
    //   124: sipush 8192
    //   127: invokespecial 339	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   130: astore_0
    //   131: aload_0
    //   132: aload_2
    //   133: getfield 77	com/tencent/qqmini/sdk/utils/MiniLog$MiniItem:msg	Ljava/lang/String;
    //   136: invokevirtual 343	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   139: getstatic 43	com/tencent/qqmini/sdk/utils/MiniLog:miniFlushMap	Ljava/util/Map;
    //   142: aload_3
    //   143: aload_0
    //   144: invokeinterface 344 3 0
    //   149: pop
    //   150: goto -147 -> 3
    //   153: invokestatic 346	com/tencent/qqmini/sdk/utils/MiniLog:miniFlushAndClean	()V
    //   156: goto +27 -> 183
    //   159: astore_0
    //   160: goto +27 -> 187
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 349	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   168: ifnull -15 -> 153
    //   171: ldc 18
    //   173: aload_0
    //   174: invokevirtual 349	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   177: invokestatic 351	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -27 -> 153
    //   183: ldc 2
    //   185: monitorexit
    //   186: return
    //   187: invokestatic 346	com/tencent/qqmini/sdk/utils/MiniLog:miniFlushAndClean	()V
    //   190: aload_0
    //   191: athrow
    //   192: astore_0
    //   193: ldc 2
    //   195: monitorexit
    //   196: goto +5 -> 201
    //   199: aload_0
    //   200: athrow
    //   201: goto -2 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   87	57	0	localObject1	Object
    //   159	1	0	localObject2	Object
    //   163	28	0	localThrowable	java.lang.Throwable
    //   192	8	0	localObject3	Object
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
    //   164	180	159	finally
    //   3	22	163	java/lang/Throwable
    //   26	36	163	java/lang/Throwable
    //   39	88	163	java/lang/Throwable
    //   91	104	163	java/lang/Throwable
    //   110	131	163	java/lang/Throwable
    //   131	150	163	java/lang/Throwable
    //   153	156	192	finally
    //   187	192	192	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniLog
 * JD-Core Version:    0.7.0.1
 */