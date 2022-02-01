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
    if (!this.isRunning) {
      return;
    }
    if (paramBundle.getInt("key_action") == 6)
    {
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
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if (this.isRunning) {
      synchronized (this.fg30MinMap)
      {
        Iterator localIterator1 = this.bg5MinMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "bg5LogCount", "|", String.valueOf(i) });
        localIterator1 = this.bg5MinMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          HashSet localHashSet = (HashSet)this.bg5MinMap.get(str);
          StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          while (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first);
            localStringBuilder.append(",");
            localStringBuilder.append(localPair.second);
            int j = i + 1;
            i = j;
            if (j < localHashSet.size())
            {
              localStringBuilder.append("#");
              i = j;
            }
          }
          BatteryLog.writeReportLogByMonitor(new String[] { "bg5LogAlarm", "|", str, "|", localStringBuilder.toString() });
        }
        this.bg5MinMap.clear();
        return;
      }
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if (this.isRunning) {
      synchronized (this.fg30MinMap)
      {
        Iterator localIterator1 = this.fg30MinMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "fg30LogCount", "|", String.valueOf(i) });
        localIterator1 = this.fg30MinMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
          HashSet localHashSet = (HashSet)this.fg30MinMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          while (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first);
            localStringBuilder.append(",");
            localStringBuilder.append(localPair.second);
            int j = i + 1;
            i = j;
            if (j < localHashSet.size())
            {
              localStringBuilder.append("#");
              i = j;
            }
          }
          BatteryLog.writeReportLogByMonitor(new String[] { "fg30LogAlarm", "|", str, "|", localStringBuilder.toString() });
        }
        this.fg30MinMap.clear();
        return;
      }
    }
  }
  
  public void onProcessStart() {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    if (!this.isRunning)
    {
      this.detector.clear();
      return;
    }
    if (this.startMonitorTimeStamp == 0L) {
      this.startMonitorTimeStamp = SystemClock.uptimeMillis();
    }
    Object localObject1 = this.detector;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(paramString2);
    ((HighFrequencyStringDetector)localObject1).putString(((StringBuilder)localObject2).toString());
    if (SystemClock.uptimeMillis() - this.startMonitorTimeStamp > this.monitorInterval)
    {
      paramString1 = this.detector.getHighFrequencyString();
      this.startMonitorTimeStamp = 0L;
      this.detector.clear();
      if (paramString1 != null)
      {
        paramString2 = this.logWhiteMap.keySet().iterator();
        while (paramString2.hasNext())
        {
          localObject1 = (String)paramString2.next();
          if ((paramString1.containsKey(localObject1)) && (((Integer)paramString1.get(localObject1)).intValue() < ((Integer)this.logWhiteMap.get(localObject1)).intValue())) {
            paramString1.remove(localObject1);
          }
        }
      }
      if ((paramString1 != null) && (paramString1.size() > 0))
      {
        paramString2 = new StringBuilder(paramString1.size() * 20 + 10);
        localObject1 = paramString1.keySet().iterator();
        int j;
        for (int i = 0; ((Iterator)localObject1).hasNext(); i = j)
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (paramString2.length() > 0) {
            paramString2.append("#");
          }
          paramString2.append("[");
          paramString2.append((String)localObject2);
          paramString2.append(",");
          paramString2.append(paramString1.get(localObject2));
          paramString2.append("]");
          j = i;
          if (((Integer)paramString1.get(localObject2)).intValue() > i) {
            j = ((Integer)paramString1.get(localObject2)).intValue();
          }
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_action", 6);
          localBundle.putString("key_log", (String)localObject2);
          localBundle.putInt("key_count", ((Integer)paramString1.get(localObject2)).intValue());
          onOtherProcReport(localBundle);
        }
        BatteryLog.writeCommonLogByMonitor(new String[] { "log|", paramString2.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.LogMonitor
 * JD-Core Version:    0.7.0.1
 */