package com.tencent.qapmsdk.qqbattery.monitor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.resource.StatCollector;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.qqbattery.BatteryLog;
import com.tencent.qapmsdk.qqbattery.BatteryUsageItem;
import com.tencent.qapmsdk.qqbattery.QQBatteryMonitor;
import com.tencent.qapmsdk.qqbattery.config.CpuMeta;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class CpuMonitor
  extends BatteryUsageItem
  implements Handler.Callback
{
  public static final String BG_5_CPU = "bg5Cpu";
  public static final String FG_30_CPU = "fg30Cpu";
  private static final String KEY_CPU_USAGE = "key_cpu_usage";
  private static final String KEY_MONITOR_SECS = "key_monitor_secs";
  private static final String KEY_PROCESS_ID = "key_process_id";
  private static final int MSG_BG_TIMER = 3;
  private static final int MSG_FG_TIMER = 0;
  private static final String TAG = "QAPM_battery_CpuMonitor";
  private long bgCollectCount;
  private long deviceBaseUsage;
  private long deviceBaseUsageOnEnterBg;
  private long dumpOtherProcessInterval = 180000L;
  private long dumpQqBgInterval;
  private long dumpQqProcessInterval1;
  private long dumpQqProcessInterval2;
  private long dumpQqProcessInterval3;
  private long enterBgTimeStamp;
  private Map<Integer, CpuMonitor.ProcessCpu> otherProcessMap = new HashMap();
  private long qqBaseUsage;
  private long qqBaseUsageOnEnterBg;
  private StatCollector statCollector;
  @NonNull
  private Handler subHandler;
  
  public CpuMonitor(CpuMeta paramCpuMeta)
  {
    this.dumpQqProcessInterval1 = paramCpuMeta.firstFgInterval;
    this.dumpQqProcessInterval2 = paramCpuMeta.secondFgInterval;
    this.dumpQqProcessInterval3 = paramCpuMeta.thirdFgInterval;
    this.dumpQqBgInterval = paramCpuMeta.firstBgInterval;
    this.bgCollectCount = paramCpuMeta.bgCollectCount;
    this.statCollector = new StatCollector();
    this.subHandler = new Handler(ThreadManager.getBatteryThreadLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    ??? = this.statCollector.getStatInfo();
    long l1 = 0L;
    long l2;
    if (??? != null)
    {
      l2 = ???[0];
      l1 = ???[2];
    }
    else
    {
      l2 = 0L;
    }
    int i;
    if (paramMessage.what == 0)
    {
      StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
      synchronized (this.otherProcessMap)
      {
        localStringBuilder.ensureCapacity(this.otherProcessMap.size() * 10);
        Iterator localIterator = this.otherProcessMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("#");
          }
          localStringBuilder.append("[");
          localStringBuilder.append(localInteger);
          localStringBuilder.append(",");
          localStringBuilder.append(((CpuMonitor.ProcessCpu)this.otherProcessMap.get(localInteger)).monitorSecs);
          localStringBuilder.append(",");
          localStringBuilder.append(((CpuMonitor.ProcessCpu)this.otherProcessMap.get(localInteger)).cpuUsage);
          localStringBuilder.append("]");
        }
        i = (int)(((Long)paramMessage.obj).longValue() / 1000L);
        Logger.INSTANCE.i(new String[] { "QAPM_battery_CpuMonitor", "cpu, onStartup ", String.valueOf(i), "sec: ", String.valueOf(l1 - this.qqBaseUsage), "|", String.valueOf(l2 - this.deviceBaseUsage), "|", localStringBuilder.toString() });
        BatteryLog.writeCommonLogByMonitor(new String[] { "cpu|fg|", String.valueOf(i), "|", String.valueOf(l1 - this.qqBaseUsage), "|", String.valueOf(l2 - this.deviceBaseUsage), "|", localStringBuilder.toString() });
        if ((i != 1800) && (!QQBatteryMonitor.debug)) {
          break label691;
        }
        BatteryLog.writeReportLogByMonitor(new String[] { "fg30Cpu", "|", String.valueOf(l1 - this.qqBaseUsage), "|", String.valueOf(l2 - this.deviceBaseUsage), "|", localStringBuilder.toString() });
        return false;
      }
    }
    this.bgCollectCount -= 1L;
    long l3 = System.currentTimeMillis();
    long l4 = this.enterBgTimeStamp;
    long l5 = this.dumpQqBgInterval;
    if (l3 - l4 < l5 + 5000L)
    {
      i = (int)(l5 / 1000L);
      Logger.INSTANCE.i(new String[] { "QAPM_battery_CpuMonitor", "cpu, bg", String.valueOf(i), "sec: ", String.valueOf(l1 - this.qqBaseUsageOnEnterBg), "/", String.valueOf(l2 - this.deviceBaseUsageOnEnterBg) });
      BatteryLog.writeCommonLogByMonitor(new String[] { "cpu|bg|", String.valueOf(i), "|", String.valueOf(l1 - this.qqBaseUsageOnEnterBg), "|", String.valueOf(l2 - this.deviceBaseUsageOnEnterBg) });
      if (i == 300) {
        BatteryLog.writeReportLogByMonitor(new String[] { "bg5Cpu", "|", String.valueOf(l1 - this.qqBaseUsage), "|", String.valueOf(l2 - this.deviceBaseUsage) });
      }
    }
    label691:
    return false;
  }
  
  public void onAppBackground()
  {
    if (this.bgCollectCount > 0L)
    {
      this.enterBgTimeStamp = System.currentTimeMillis();
      long[] arrayOfLong = this.statCollector.getStatInfo();
      if (arrayOfLong != null)
      {
        this.deviceBaseUsageOnEnterBg = arrayOfLong[0];
        this.qqBaseUsageOnEnterBg = arrayOfLong[2];
      }
      this.subHandler.sendEmptyMessageDelayed(3, this.dumpQqBgInterval);
    }
  }
  
  public void onAppForeground()
  {
    super.onAppForeground();
    this.subHandler.removeMessages(3);
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    if (paramBundle.getInt("key_action") == 0)
    {
      int i = paramBundle.getInt("key_process_id");
      int j = paramBundle.getInt("key_monitor_secs");
      long l = paramBundle.getLong("key_cpu_usage");
      synchronized (this.otherProcessMap)
      {
        CpuMonitor.ProcessCpu localProcessCpu = (CpuMonitor.ProcessCpu)this.otherProcessMap.get(Integer.valueOf(i));
        paramBundle = localProcessCpu;
        if (localProcessCpu == null)
        {
          paramBundle = new CpuMonitor.ProcessCpu(this);
          this.otherProcessMap.put(Integer.valueOf(i), paramBundle);
        }
        paramBundle.cpuUsage += l;
        paramBundle.monitorSecs += j;
        return;
      }
    }
  }
  
  public void onProcessStart()
  {
    Object localObject = this.statCollector.getStatInfo();
    if (localObject != null)
    {
      this.deviceBaseUsage = localObject[0];
      this.qqBaseUsage = localObject[2];
    }
    localObject = this.subHandler.obtainMessage(0, Long.valueOf(this.dumpQqProcessInterval1));
    this.subHandler.sendMessageDelayed((Message)localObject, this.dumpQqProcessInterval1);
    localObject = this.subHandler.obtainMessage(0, Long.valueOf(this.dumpQqProcessInterval2));
    this.subHandler.sendMessageDelayed((Message)localObject, this.dumpQqProcessInterval2);
    localObject = this.subHandler.obtainMessage(0, Long.valueOf(this.dumpQqProcessInterval3));
    this.subHandler.sendMessageDelayed((Message)localObject, this.dumpQqProcessInterval3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.CpuMonitor
 * JD-Core Version:    0.7.0.1
 */