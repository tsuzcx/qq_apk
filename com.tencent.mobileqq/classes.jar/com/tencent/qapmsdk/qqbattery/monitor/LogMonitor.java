package com.tencent.qapmsdk.qqbattery.monitor;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.qqbattery.BatteryLog;
import com.tencent.qapmsdk.qqbattery.BatteryUsageItem;
import com.tencent.qapmsdk.qqbattery.HighFrequencyStringDetector;
import com.tencent.qapmsdk.qqbattery.config.LogMeta;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LogMonitor
  extends BatteryUsageItem
{
  public static final String BG_5_LOG_ALARM = "bg5LogAlarm";
  public static final String BG_5_LOG_COUNT = "bg5LogCount";
  public static final String FG_30_LOG_ALARM = "fg30LogAlarm";
  public static final String FG_30_LOG_COUNT = "fg30LogCount";
  private static final String KEY_COUNT = "key_count";
  private static final String KEY_LOG = "key_log";
  private static final String TAG = "QAPM_battery_LogMonitor";
  @NonNull
  private Map<String, HashSet<Pair<Long, Integer>>> bg5MinMap = new HashMap();
  private HighFrequencyStringDetector detector;
  @NonNull
  private Map<String, HashSet<Pair<Long, Integer>>> fg30MinMap = new HashMap();
  @NonNull
  private Map<String, Integer> logWhiteMap = new HashMap();
  private long monitorInterval;
  private long startMonitorTimeStamp = 0L;
  
  public LogMonitor(LogMeta paramLogMeta)
  {
    this.monitorInterval = paramLogMeta.monitorInterval;
    this.detector = new HighFrequencyStringDetector(paramLogMeta.maintainCount, paramLogMeta.alarmTime);
  }
  
  @NonNull
  public Map<String, Integer> getLogWhiteMap()
  {
    return this.logWhiteMap;
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    synchronized (this.fg30MinMap)
    {
      this.bg5MinMap.clear();
      return;
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    if (!this.isRunning) {}
    while (paramBundle.getInt("key_action") != 6) {
      return;
    }
    String str = paramBundle.getString("key_log");
    int i = paramBundle.getInt("key_count");
    synchronized (this.fg30MinMap)
    {
      HashSet localHashSet;
      if (this.isBeforeRun30Min)
      {
        localHashSet = (HashSet)this.fg30MinMap.get(str);
        paramBundle = localHashSet;
        if (localHashSet == null)
        {
          paramBundle = new HashSet();
          this.fg30MinMap.put(str, paramBundle);
        }
        paramBundle.add(new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
      }
      if ((this.isAppBackground) && (this.isInFirstBg5min))
      {
        localHashSet = (HashSet)this.bg5MinMap.get(str);
        paramBundle = localHashSet;
        if (localHashSet == null)
        {
          paramBundle = new HashSet();
          this.bg5MinMap.put(str, paramBundle);
        }
        paramBundle.add(new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
      }
      return;
    }
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if (this.isRunning) {}
    label276:
    for (;;)
    {
      synchronized (this.fg30MinMap)
      {
        Iterator localIterator1 = this.bg5MinMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "bg5LogCount", "|", String.valueOf(i) });
        localIterator1 = this.bg5MinMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          HashSet localHashSet = (HashSet)this.bg5MinMap.get(str);
          StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first).append(",").append(localPair.second);
            i += 1;
            if (i >= localHashSet.size()) {
              break label276;
            }
            localStringBuilder.append("#");
            break label276;
          }
          BatteryLog.writeReportLogByMonitor(new String[] { "bg5LogAlarm", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.bg5MinMap.clear();
      return;
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if (this.isRunning) {}
    label276:
    for (;;)
    {
      synchronized (this.fg30MinMap)
      {
        Iterator localIterator1 = this.fg30MinMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "fg30LogCount", "|", String.valueOf(i) });
        localIterator1 = this.fg30MinMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
          HashSet localHashSet = (HashSet)this.fg30MinMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first).append(",").append(localPair.second);
            i += 1;
            if (i >= localHashSet.size()) {
              break label276;
            }
            localStringBuilder.append("#");
            break label276;
          }
          BatteryLog.writeReportLogByMonitor(new String[] { "fg30LogAlarm", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.fg30MinMap.clear();
      return;
    }
  }
  
  public void onProcessStart() {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    if (!this.isRunning) {
      this.detector.clear();
    }
    do
    {
      do
      {
        return;
        if (this.startMonitorTimeStamp == 0L) {
          this.startMonitorTimeStamp = SystemClock.uptimeMillis();
        }
        this.detector.putString(paramString1 + "|" + paramString2);
      } while (SystemClock.uptimeMillis() - this.startMonitorTimeStamp <= this.monitorInterval);
      paramString1 = this.detector.getHighFrequencyString();
      this.startMonitorTimeStamp = 0L;
      this.detector.clear();
      if (paramString1 != null)
      {
        paramString2 = this.logWhiteMap.keySet().iterator();
        while (paramString2.hasNext())
        {
          localObject = (String)paramString2.next();
          if ((paramString1.containsKey(localObject)) && (((Integer)paramString1.get(localObject)).intValue() < ((Integer)this.logWhiteMap.get(localObject)).intValue())) {
            paramString1.remove(localObject);
          }
        }
      }
    } while ((paramString1 == null) || (paramString1.size() <= 0));
    paramString2 = new StringBuilder(paramString1.size() * 20 + 10);
    Object localObject = paramString1.keySet().iterator();
    int i = 0;
    String str;
    if (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (paramString2.length() > 0) {
        paramString2.append("#");
      }
      paramString2.append("[").append(str).append(",").append(paramString1.get(str)).append("]");
      if (((Integer)paramString1.get(str)).intValue() <= i) {
        break label423;
      }
      i = ((Integer)paramString1.get(str)).intValue();
    }
    label423:
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 6);
      localBundle.putString("key_log", str);
      localBundle.putInt("key_count", ((Integer)paramString1.get(str)).intValue());
      onOtherProcReport(localBundle);
      break;
      BatteryLog.writeCommonLogByMonitor(new String[] { "log|", paramString2.toString() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.LogMonitor
 * JD-Core Version:    0.7.0.1
 */