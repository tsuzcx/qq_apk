package com.tencent.qqmini.sdk.utils;

import android.os.Handler;
import android.text.TextUtils;
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
    if (paramInteger == null)
    {
      paramInteger = Integer.valueOf(1);
      Integer localInteger = paramInteger;
      try
      {
        File[] arrayOfFile = paramFile.listFiles();
        paramFile = paramInteger;
        if (arrayOfFile != null)
        {
          localInteger = paramInteger;
          paramFile = paramInteger;
          if (arrayOfFile.length > 0)
          {
            localInteger = paramInteger;
            int j = arrayOfFile.length;
            int i = 0;
            for (;;)
            {
              paramFile = paramInteger;
              if (i >= j) {
                break;
              }
              localInteger = paramInteger;
              String str = arrayOfFile[i].getName();
              paramFile = paramInteger;
              localInteger = paramInteger;
              if (str.contains("log"))
              {
                localInteger = paramInteger;
                str = str.substring(str.lastIndexOf("log") + 1);
                paramFile = paramInteger;
                localInteger = paramInteger;
                if (isInteger(str))
                {
                  paramFile = paramInteger;
                  localInteger = paramInteger;
                  if (Integer.valueOf(str).intValue() > paramInteger.intValue())
                  {
                    localInteger = paramInteger;
                    paramFile = Integer.valueOf(str);
                  }
                }
              }
              i += 1;
              paramInteger = paramFile;
            }
          }
        }
        return paramFile;
      }
      catch (Exception paramInteger)
      {
        QMLog.e("MiniLog", paramString, paramInteger);
        paramFile = localInteger;
      }
    }
    return paramInteger;
  }
  
  public static String getMiniLogFolderPath()
  {
    return MiniSDKConst.getMiniCacheFilePath();
  }
  
  public static String getMiniLogFolderPath(String paramString)
  {
    String str = LoginManager.getInstance().getAccount();
    return MiniSDKConst.getMiniCacheFilePath() + MD5Utils.toMD5(paramString) + "/" + str + "/miniprogramLog/";
  }
  
  private static String getMiniLogPath(String paramString)
  {
    String str = getMiniLogFolderPath(paramString);
    localObject1 = (Integer)mLastNumCache.get(paramString);
    localObject2 = new File(str);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = getLastLogNum(paramString, (Integer)localObject1, (File)localObject2);
    localObject2 = localObject1;
    if (System.currentTimeMillis() - lastCheckLogSizeTime > 60000L)
    {
      lastCheckLogSizeTime = System.currentTimeMillis();
      localObject2 = localObject1;
      localObject3 = localObject1;
    }
    label179:
    do
    {
      try
      {
        if (FileUtils.createFile(str + "log" + localObject1).length() > MAX_MINI_LOG_SIZE)
        {
          localObject3 = localObject1;
          if (((Integer)localObject1).intValue() >= 5) {
            break label179;
          }
          localObject3 = localObject1;
          i = ((Integer)localObject1).intValue();
          localObject2 = Integer.valueOf(i + 1);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            int i;
            File localFile;
            StringBuilder localStringBuilder;
            int j;
            localFile.renameTo(new File(localObject1));
            localObject1 = localObject2;
            i += 1;
          }
          catch (Exception localException2)
          {
            continue;
          }
          localException1 = localException1;
          localObject2 = localObject3;
          localException1.printStackTrace();
        }
      }
      mLastNumCache.put(paramString, localObject2);
      return str + "log" + localObject2;
      localObject3 = localObject1;
      new File(str + "log" + 1).delete();
      localObject3 = localObject1;
      localObject1 = Integer.valueOf(1);
      i = 2;
      localObject2 = localObject1;
    } while (i > 5);
    localObject3 = localObject1;
    localFile = new File(str + "log" + i);
    localObject3 = localObject1;
    if (localFile.exists())
    {
      localObject3 = localObject1;
      QMLog.i("MiniLog", "rename from file:log" + i + " to file:" + localObject1);
      localObject3 = localObject1;
      localStringBuilder = new StringBuilder().append(str).append("log");
      localObject3 = localObject1;
      j = ((Integer)localObject1).intValue();
      localObject2 = Integer.valueOf(j + 1);
    }
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
  
  private static void writeMiniLogToFile()
  {
    for (;;)
    {
      try
      {
        if (miniQueue.isEmpty()) {
          break label186;
        }
        localMiniItem = (MiniLog.MiniItem)miniQueue.poll();
        if ((localMiniItem == null) || (TextUtils.isEmpty(localMiniItem.filePath))) {
          continue;
        }
        str = localMiniItem.filePath;
        localFile = new File(str);
        if (localFile.exists()) {
          continue;
        }
        FileUtils.createFile(str);
        localBufferedWriter1 = new BufferedWriter(new MiniLogWriter(localFile, true), 8192);
      }
      catch (Throwable localThrowable)
      {
        MiniLog.MiniItem localMiniItem;
        String str;
        File localFile;
        BufferedWriter localBufferedWriter1;
        if (localThrowable.getMessage() == null) {
          continue;
        }
        QMLog.e("MiniLog", localThrowable.getMessage());
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
      label186:
      miniFlushAndClean();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniLog
 * JD-Core Version:    0.7.0.1
 */