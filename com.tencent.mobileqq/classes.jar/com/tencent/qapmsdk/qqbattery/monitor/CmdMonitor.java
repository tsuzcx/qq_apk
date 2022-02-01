package com.tencent.qapmsdk.qqbattery.monitor;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.qqbattery.BatteryLog;
import com.tencent.qapmsdk.qqbattery.BatteryUsageItem;
import com.tencent.qapmsdk.qqbattery.HighFrequencyStringDetector;
import com.tencent.qapmsdk.qqbattery.config.CmdMeta;
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
    if (!this.isRunning)
    {
      this.detector.clear();
      return;
    }
    if (this.startMonitorTimeStamp == 0L) {
      this.startMonitorTimeStamp = SystemClock.uptimeMillis();
    }
    this.detector.putString(paramString);
    if (SystemClock.uptimeMillis() - this.startMonitorTimeStamp > this.monitorInterval)
    {
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
      if ((paramString != null) && (paramString.size() > 0))
      {
        localObject1 = new StringBuilder(paramString.size() * 20);
        localObject2 = paramString.keySet().iterator();
        int j;
        for (int i = 0; ((Iterator)localObject2).hasNext(); i = j)
        {
          String str = (String)((Iterator)localObject2).next();
          if (((StringBuilder)localObject1).length() > 0) {
            ((StringBuilder)localObject1).append("#");
          }
          ((StringBuilder)localObject1).append("[");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(paramString.get(str));
          ((StringBuilder)localObject1).append("]");
          j = i;
          if (((Integer)paramString.get(str)).intValue() > i) {
            j = ((Integer)paramString.get(str)).intValue();
          }
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_action", 7);
          localBundle.putString("key_log", str);
          localBundle.putInt("key_count", ((Integer)paramString.get(str)).intValue());
          onOtherProcReport(localBundle);
        }
        BatteryLog.writeCommonLogByMonitor(new String[] { "cmd|", ((StringBuilder)localObject1).toString() });
      }
      this.startMonitorTimeStamp = 0L;
      this.detector.clear();
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    if (!this.isRunning) {
      return;
    }
    if (paramBundle.getInt("key_action") == 7)
    {
      String str = paramBundle.getString("key_log");
      int i = paramBundle.getInt("key_count");
      paramBundle = Logger.INSTANCE;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", count:");
      ((StringBuilder)localObject).append(i);
      paramBundle.i(new String[] { "QAPM_battery_CmdMonitor", "CMD.onOtherProcReport:", str, ((StringBuilder)localObject).toString() });
      try
      {
        if (this.isBeforeRun30Min)
        {
          localObject = (HashSet)this.fg30MinMap.get(str);
          paramBundle = (Bundle)localObject;
          if (localObject == null)
          {
            paramBundle = new HashSet();
            this.fg30MinMap.put(str, paramBundle);
          }
          paramBundle.add(new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
        }
        if ((this.isAppBackground) && (this.isInFirstBg5min))
        {
          localObject = (HashSet)this.bg5MinMap.get(str);
          paramBundle = (Bundle)localObject;
          if (localObject == null)
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
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if (this.isRunning) {
      try
      {
        Iterator localIterator1 = this.bg5MinMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "bg5CmdCount", "|", String.valueOf(i) });
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
          BatteryLog.writeReportLogByMonitor(new String[] { "bg5CmdAlarm", "|", str, "|", localStringBuilder.toString() });
        }
        this.bg5MinMap.clear();
        return;
      }
      finally {}
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if (this.isRunning) {
      try
      {
        Iterator localIterator1 = this.fg30MinMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "fg30CmdCount", "|", String.valueOf(i) });
        localIterator1 = this.fg30MinMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          HashSet localHashSet = (HashSet)this.fg30MinMap.get(str);
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
          BatteryLog.writeReportLogByMonitor(new String[] { "fg30CmdAlarm", "|", str, "|", localStringBuilder.toString() });
        }
        this.fg30MinMap.clear();
        return;
      }
      finally {}
    }
  }
  
  public void onProcessStart() {}
  
  public void setDebugAlarm(boolean paramBoolean)
  {
    this.debugAlarm = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.CmdMonitor
 * JD-Core Version:    0.7.0.1
 */