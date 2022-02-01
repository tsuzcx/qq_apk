package com.tencent.qapmsdk.qqbattery;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BatteryLog
{
  private static final String FORMAT_VERSION = "1.3";
  private static final int MSG_CLEAN_LOG = 1;
  private static final int MSG_INIT_LOG = 0;
  private static final int MSG_WRITE_LOG = 2;
  private static final String TAG = "QAPM_battery_BatteryLog";
  private static String commonFileName;
  private static long logInitTimestamp;
  private static String logPath;
  private static String processName;
  private static String reportFileName;
  @Nullable
  private static Handler writeHandler;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtil.getRootPath());
    localStringBuilder.append("/battery/");
    logPath = localStringBuilder.toString();
  }
  
  static void cleanStorage(long paramLong)
  {
    Handler localHandler = writeHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(1, Long.valueOf(paramLong)).sendToTarget();
    }
  }
  
  static File getCommonLogFileForReport(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    Object localObject = FileUtil.getFiles(logPath, ".*(.log)$");
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      long l3;
      try
      {
        localObject = ((List)localObject).iterator();
        l1 = 0L;
        if (((Iterator)localObject).hasNext())
        {
          File localFile = (File)((Iterator)localObject).next();
          l3 = FileUtil.getLastModifiedTime(localFile);
          if ((l3 == -1L) || (l3 >= paramLong2) || (l3 <= paramLong1) || (localFile.length() <= paramLong3)) {
            continue;
          }
          if (paramInt <= 0) {
            break label229;
          }
          localArrayList.add(localFile.getAbsolutePath());
          break label229;
        }
        if (localArrayList.size() > 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(logPath);
          ((StringBuilder)localObject).append(paramLong2);
          ((StringBuilder)localObject).append(".zip");
          localObject = ((StringBuilder)localObject).toString();
          if (FileUtil.zipFiles(localArrayList, (String)localObject, false)) {
            return new File((String)localObject);
          }
          Logger.INSTANCE.e(new String[] { "QAPM_battery_BatteryLog", "zip fail" });
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.INSTANCE.exception("QAPM_battery_BatteryLog", localThrowable);
      }
      return null;
      label229:
      long l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      paramInt -= 1;
      long l1 = l2;
    }
  }
  
  static List<File> getReportLogFile(long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = FileUtil.getFiles(logPath, ".*(.rpt)$");
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      File localFile = (File)((Iterator)localObject).next();
      long l = FileUtil.getLastModifiedTime(localFile);
      if ((QQBatteryMonitor.debug) || ((l < paramLong2) && (l > paramLong1) && (localFile.length() > paramLong3))) {
        localArrayList.add(localFile);
      }
    }
    return localArrayList;
  }
  
  private static String getRevision()
  {
    if ((!"0".equals(BatteryConstants.REVERSION)) && (!TextUtils.isEmpty(BaseInfo.userMeta.version)))
    {
      Matcher localMatcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+)[\\.\\d-]*\\.r?(\\d+)").matcher(BaseInfo.userMeta.version);
      int i = 0;
      while (localMatcher.find(i))
      {
        if (i == 2)
        {
          BatteryConstants.REVERSION = localMatcher.group(i);
          return BatteryConstants.REVERSION;
        }
        i += 1;
      }
      return BatteryConstants.REVERSION;
    }
    return BatteryConstants.REVERSION;
  }
  
  static void init(String paramString, long paramLong)
  {
    processName = paramString;
    logInitTimestamp = paramLong;
    writeHandler = new BatteryLog.LogHandler(ThreadManager.getBatteryThreadLooper(), null);
    writeHandler.sendEmptyMessage(0);
  }
  
  static void writeCommonLog(Object... paramVarArgs)
  {
    Handler localHandler = writeHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(2, 0, 0, paramVarArgs).sendToTarget();
    }
  }
  
  public static void writeCommonLogByMonitor(String... paramVarArgs)
  {
    long l = (System.currentTimeMillis() - BatteryConstants.BATTERY_START_TIME) / 1000L;
    writeCommonLog(new Object[] { BaseInfo.userMeta.uin, Integer.valueOf(BatteryConstants.PROCESS_ID), Long.valueOf(l), paramVarArgs });
  }
  
  static void writeReportLog(Object... paramVarArgs)
  {
    Handler localHandler = writeHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(2, 1, 0, paramVarArgs).sendToTarget();
    }
  }
  
  public static void writeReportLogByMonitor(String... paramVarArgs)
  {
    writeReportLog(new Object[] { Long.valueOf(System.currentTimeMillis()), paramVarArgs });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.BatteryLog
 * JD-Core Version:    0.7.0.1
 */