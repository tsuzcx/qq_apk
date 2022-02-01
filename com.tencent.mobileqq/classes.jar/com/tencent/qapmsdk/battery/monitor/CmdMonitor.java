package com.tencent.qapmsdk.battery.monitor;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.qapmsdk.battery.BatteryLog;
import com.tencent.qapmsdk.battery.BatteryUsageItem;
import com.tencent.qapmsdk.battery.HighFrequencyStringDetector;
import com.tencent.qapmsdk.battery.config.CmdMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CmdMonitor
  extends BatteryUsageItem
{
  public static final String BG_5_CMD_ALARM = "bg5CmdAlarm";
  public static final String BG_5_CMD_COUNT = "bg5CmdCount";
  public static final String FG_30_CMD_ALARM = "fg30CmdAlarm";
  public static final String FG_30_CMD_COUNT = "fg30CmdCount";
  private static final String KEY_CMD = "key_log";
  private static final String KEY_COUNT = "key_count";
  private static final String TAG = "QAPM_battery_CmdMonitor";
  @NonNull
  private Map<String, HashSet<Pair<Long, Integer>>> bg5MinMap = new HashMap();
  @NonNull
  private Map<String, Integer> cmdWhiteMap = new HashMap();
  private boolean debugAlarm = true;
  private HighFrequencyStringDetector detector;
  @NonNull
  private Map<String, HashSet<Pair<Long, Integer>>> fg30MinMap = new HashMap();
  private long monitorInterval;
  private long startMonitorTimeStamp = 0L;
  
  public CmdMonitor(CmdMeta paramCmdMeta)
  {
    this.monitorInterval = paramCmdMeta.monitorInterval;
    this.detector = new HighFrequencyStringDetector(paramCmdMeta.maintainCount, paramCmdMeta.alarmSendTime);
  }
  
  @NonNull
  public Map<String, Integer> getCmdWhiteMap()
  {
    return this.cmdWhiteMap;
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    if (this.isRunning) {
      try
      {
        this.bg5MinMap.clear();
        return;
      }
      finally {}
    }
  }
  
  public void onCmdRequest(String paramString)
  {
    if (!this.isRunning) {
      this.detector.clear();
    }
    do
    {
      return;
      if (this.startMonitorTimeStamp == 0L) {
        this.startMonitorTimeStamp = SystemClock.uptimeMillis();
      }
      this.detector.putString(paramString);
    } while (SystemClock.uptimeMillis() - this.startMonitorTimeStamp <= this.monitorInterval);
    paramString = this.detector.getHighFrequencyString();
    Object localObject1;
    Object localObject2;
    if ((paramString != null) && (Logger.debug) && (this.debugAlarm))
    {
      localObject1 = this.cmdWhiteMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((paramString.containsKey(localObject2)) && (((Integer)paramString.get(localObject2)).intValue() < ((Integer)this.cmdWhiteMap.get(localObject2)).intValue())) {
          paramString.remove(localObject2);
        }
      }
    }
    String str;
    if ((paramString != null) && (paramString.size() > 0))
    {
      localObject1 = new StringBuilder(paramString.size() * 20);
      localObject2 = paramString.keySet().iterator();
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append("#");
        }
        ((StringBuilder)localObject1).append("[").append(str).append(",").append(paramString.get(str)).append("]");
        if (((Integer)paramString.get(str)).intValue() <= i) {
          break label408;
        }
        i = ((Integer)paramString.get(str)).intValue();
      }
    }
    label408:
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 7);
      localBundle.putString("key_log", str);
      localBundle.putInt("key_count", ((Integer)paramString.get(str)).intValue());
      onOtherProcReport(localBundle);
      break;
      BatteryLog.writeCommonLogByMonitor(new String[] { "cmd|", ((StringBuilder)localObject1).toString() });
      this.startMonitorTimeStamp = 0L;
      this.detector.clear();
      return;
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    if (!this.isRunning) {}
    while (paramBundle.getInt("key_action") != 7) {
      return;
    }
    String str = paramBundle.getString("key_log");
    int i = paramBundle.getInt("key_count");
    Logger.INSTANCE.i(new String[] { "QAPM_battery_CmdMonitor", "CMD.onOtherProcReport:", str, ", count:" + i });
    try
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
    finally {}
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if (this.isRunning) {}
    label274:
    for (;;)
    {
      try
      {
        Iterator localIterator1 = this.bg5MinMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "bg5CmdCount", "|", String.valueOf(i) });
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
              break label274;
            }
            localStringBuilder.append("#");
            break label274;
          }
          BatteryLog.writeReportLogByMonitor(new String[] { "bg5CmdAlarm", "|", str, "|", localStringBuilder.toString() });
          continue;
        }
        this.bg5MinMap.clear();
      }
      finally {}
      return;
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if (this.isRunning) {}
    label274:
    for (;;)
    {
      try
      {
        Iterator localIterator1 = this.fg30MinMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "fg30CmdCount", "|", String.valueOf(i) });
        localIterator1 = this.fg30MinMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          HashSet localHashSet = (HashSet)this.fg30MinMap.get(str);
          StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first).append(",").append(localPair.second);
            i += 1;
            if (i >= localHashSet.size()) {
              break label274;
            }
            localStringBuilder.append("#");
            break label274;
          }
          BatteryLog.writeReportLogByMonitor(new String[] { "fg30CmdAlarm", "|", str, "|", localStringBuilder.toString() });
          continue;
        }
        this.fg30MinMap.clear();
      }
      finally {}
      return;
    }
  }
  
  public void onProcessStart() {}
  
  public void setDebugAlarm(boolean paramBoolean)
  {
    this.debugAlarm = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.monitor.CmdMonitor
 * JD-Core Version:    0.7.0.1
 */