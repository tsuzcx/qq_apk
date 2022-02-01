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
    Object localObject3 = (Integer)mLastNumCache.get(paramString);
    Object localObject6 = new File(str);
    if (!((File)localObject6).exists()) {
      ((File)localObject6).mkdirs();
    }
    Object localObject1 = localObject3;
    Object localObject5;
    int j;
    int i;
    Object localObject7;
    Object localObject2;
    if (localObject3 == null)
    {
      localObject3 = Integer.valueOf(1);
      localObject5 = localObject3;
      try
      {
        localObject6 = ((File)localObject6).listFiles();
        localObject1 = localObject3;
        if (localObject6 != null)
        {
          localObject5 = localObject3;
          localObject1 = localObject3;
          if (localObject6.length > 0)
          {
            localObject5 = localObject3;
            j = localObject6.length;
            i = 0;
            for (;;)
            {
              localObject1 = localObject3;
              if (i >= j) {
                break;
              }
              localObject5 = localObject3;
              localObject7 = localObject6[i].getName();
              localObject1 = localObject3;
              localObject5 = localObject3;
              if (((String)localObject7).contains("log"))
              {
                localObject5 = localObject3;
                localObject7 = ((String)localObject7).substring(((String)localObject7).lastIndexOf("log") + 1);
                localObject1 = localObject3;
                localObject5 = localObject3;
                if (isInteger((String)localObject7))
                {
                  localObject1 = localObject3;
                  localObject5 = localObject3;
                  if (Integer.valueOf((String)localObject7).intValue() > ((Integer)localObject3).intValue())
                  {
                    localObject5 = localObject3;
                    localObject1 = Integer.valueOf((String)localObject7);
                  }
                }
              }
              i += 1;
              localObject3 = localObject1;
            }
          }
        }
        if (System.currentTimeMillis() - lastCheckLogSizeTime <= 60000L) {
          break label572;
        }
      }
      catch (Exception localException1)
      {
        QMLog.e("MiniLog", paramString, localException1);
        localObject2 = localObject5;
      }
    }
    else
    {
      lastCheckLogSizeTime = System.currentTimeMillis();
      localObject3 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (FileUtils.createFile(str + "log" + localObject2).length() <= MAX_MINI_LOG_SIZE) {
          break label572;
        }
        localObject3 = localObject2;
        if (((Integer)localObject2).intValue() >= 5) {
          continue;
        }
        localObject3 = localObject2;
        i = ((Integer)localObject2).intValue();
        localObject3 = Integer.valueOf(i + 1);
      }
      catch (Exception localException3)
      {
        localObject2 = localObject3;
        localObject3 = localException3;
        ((Exception)localObject3).printStackTrace();
        localObject3 = localObject2;
        continue;
      }
      mLastNumCache.put(paramString, localObject3);
      return str + "log" + localObject3;
      localObject3 = localObject2;
      new File(str + "log" + 1).delete();
      localObject2 = Integer.valueOf(1);
      i = 2;
      localObject3 = localObject2;
      if (i <= 5)
      {
        try
        {
          localObject6 = new File(str + "log" + i);
          if (!((File)localObject6).exists()) {
            break label569;
          }
          QMLog.i("MiniLog", "rename from file:log" + i + " to file:" + localObject2);
          localObject7 = new StringBuilder().append(str).append("log");
          j = ((Integer)localObject2).intValue();
          localObject5 = Integer.valueOf(j + 1);
          localObject3 = localObject5;
          ((File)localObject6).renameTo(new File(localObject2));
          localObject2 = localObject5;
        }
        catch (Exception localException2)
        {
          continue;
          label569:
          continue;
        }
        i += 1;
        continue;
        label572:
        Object localObject4 = localObject2;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniLog
 * JD-Core Version:    0.7.0.1
 */