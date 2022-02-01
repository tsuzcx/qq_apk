package com.tencent.qapmsdk.qqbattery.monitor;

import android.net.wifi.WifiManager.WifiLock;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.qqbattery.BatteryUsageItem;
import com.tencent.qapmsdk.qqbattery.HighFrequencyDetector;
import com.tencent.qapmsdk.qqbattery.config.WifiMeta;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WifiMonitor
  extends BatteryUsageItem
  implements HookMethodCallback
{
  public static final String BG_5_WF_LOCK_COUNT = "bg5WFLCount";
  public static final String BG_5_WF_LOCK_DETAIL = "bg5WFLDetail";
  public static final String BG_5_WF_SCAN_COUNT = "bg5WFSCount";
  public static final String BG_5_WF_SCAN_DETAIL = "bg5WFSDetail";
  public static final String FG_30_WF_LOCK_COUNT = "fg30WFLCount";
  public static final String FG_30_WF_LOCK_DETAIL = "fg30WFLDetail";
  public static final String FG_30_WF_SCAN_COUNT = "fg30WFSCount";
  public static final String FG_30_WF_SCAN_DETAIL = "fg30WFSDetail";
  private static final String KEY_DURATION = "key_duration";
  private static final String KEY_STACK = "key_stack";
  private static final String KEY_TAG = "key_tag";
  public static final String TAG = "QAPM_battery_WifiLock";
  public static final String WF_LOCK_NOT_RELEASE = "wflNotRelease";
  private HashMap<String, WifiMonitor.ReportEntity> bg5MinLockMap = new HashMap();
  private HashMap<String, HashSet<Long>> bg5MinScanMap = new HashMap();
  private HighFrequencyDetector detector1;
  private HighFrequencyDetector detector2;
  private HashMap<String, WifiMonitor.ReportEntity> fg30MinLockMap = new HashMap();
  private HashMap<String, HashSet<Long>> fg30MinScanMap = new HashMap();
  private long longTime = 18000000L;
  private HashMap<WeakReference<WifiManager.WifiLock>, WifiMonitor.WifiLockEntity> map = new HashMap();
  private int maxCallTimeInLongTime = 10;
  private int maxCallTimeInShortTime = 3;
  private long shortTime = 900000L;
  
  public WifiMonitor(WifiMeta paramWifiMeta)
  {
    this.maxCallTimeInShortTime = paramWifiMeta.maxCallTimeInShortTime;
    this.shortTime = paramWifiMeta.shortTime;
    this.maxCallTimeInLongTime = paramWifiMeta.maxCallTimeInLongTime;
    this.longTime = paramWifiMeta.longTime;
    this.detector1 = new HighFrequencyDetector(this.maxCallTimeInShortTime, this.shortTime);
    this.detector2 = new HighFrequencyDetector(this.maxCallTimeInLongTime, this.longTime);
  }
  
  private final void doLockReport(WifiMonitor.WifiLockEntity paramWifiLockEntity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramWifiLockEntity.createStack);
    localBundle.putString("key_tag", paramWifiLockEntity.tag);
    if (paramInt == 9) {
      localBundle.putLong("key_duration", SystemClock.uptimeMillis() - paramWifiLockEntity.firstAcquireTimeStamp);
    }
    onOtherProcReport(localBundle);
  }
  
  private final void writeLockReport(boolean paramBoolean)
  {
    localHashMap2 = this.fg30MinLockMap;
    if (paramBoolean) {}
    try
    {
      localHashMap1 = this.fg30MinLockMap;
      break label28;
      localHashMap1 = this.bg5MinLockMap;
      label28:
      localObject2 = localHashMap1.values().iterator();
      l1 = 0L;
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WifiMonitor.ReportEntity)((Iterator)localObject2).next();
        int j = i + ((WifiMonitor.ReportEntity)localObject3).useList.size();
        localObject3 = ((WifiMonitor.ReportEntity)localObject3).useList.iterator();
        for (long l2 = l1;; l2 += ((Long)((Pair)((Iterator)localObject3).next()).second).longValue())
        {
          i = j;
          l1 = l2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        }
      }
      if (!paramBoolean) {
        break label447;
      }
      localObject2 = "fg30WFLCount";
    }
    finally
    {
      for (;;)
      {
        HashMap localHashMap1;
        long l1;
        int i;
        Object localObject3;
        Iterator localIterator;
        for (;;)
        {
          throw localObject1;
        }
        Object localObject2 = "bg5WFLCount";
        continue;
        continue;
        localObject2 = "bg5WFSDetail";
      }
    }
    writeReportLog(new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l1), "|0" });
    localIterator = localHashMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject3 = (WifiMonitor.ReportEntity)localHashMap1.get(str);
      StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
      localObject2 = ((WifiMonitor.ReportEntity)localObject3).useList.iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject2).next();
        localStringBuilder.append(localPair.first);
        localStringBuilder.append(",");
        localStringBuilder.append(localPair.second);
        i += 1;
        if (i >= ((WifiMonitor.ReportEntity)localObject3).useList.size()) {
          break label454;
        }
        localStringBuilder.append("#");
        break label454;
      }
      if (!paramBoolean) {
        break label457;
      }
      localObject2 = "fg30WFLDetail";
      if (((WifiMonitor.ReportEntity)localObject3).tag == null) {
        localObject3 = "";
      } else {
        localObject3 = ((WifiMonitor.ReportEntity)localObject3).tag.replace("|", "_");
      }
      writeReportLog(new String[] { localObject2, "|", localObject3, "|0|", str, "|", localStringBuilder.toString() });
    }
    localHashMap1.clear();
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.isRunning) {
      return;
    }
    if (paramMethodHookParam == null) {
      return;
    }
    try
    {
      ??? = getAppStack().toString();
      Object localObject3;
      if ("release".equals(paramMethodHookParam.method.getName())) {
        synchronized (this.map)
        {
          localObject3 = this.map.keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
            WifiMonitor.WifiLockEntity localWifiLockEntity = (WifiMonitor.WifiLockEntity)this.map.get(localWeakReference);
            if (localWeakReference.get() == paramMethodHookParam.thisObject)
            {
              writeCommonLog(new String[] { "wf_rl|", localWifiLockEntity.uuid, "|", ??? });
              if (!((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld())
              {
                writeCommonLog(new String[] { "wf_time|", localWifiLockEntity.uuid, "|", String.valueOf(SystemClock.uptimeMillis() - localWifiLockEntity.firstAcquireTimeStamp) });
                ((Iterator)localObject3).remove();
              }
              doLockReport(localWifiLockEntity, 9);
            }
            else if (localWeakReference.get() == null)
            {
              writeCommonLog(new String[] { "wf_alarm|", localWifiLockEntity.uuid });
              ((Iterator)localObject3).remove();
              doLockReport(localWifiLockEntity, 10);
            }
          }
          return;
        }
      }
      if ("createWifiLock".equals(paramMethodHookParam.method.getName()))
      {
        ??? = new WifiMonitor.WifiLockEntity(this, null);
        ((WifiMonitor.WifiLockEntity)???).uuid = String.valueOf(???.hashCode());
        ((WifiMonitor.WifiLockEntity)???).createStack = ((String)???);
        if ((paramMethodHookParam.args != null) && (paramMethodHookParam.args.length == 2)) {
          ((WifiMonitor.WifiLockEntity)???).tag = ((String)paramMethodHookParam.args[1]);
        } else if ((paramMethodHookParam.args != null) && (paramMethodHookParam.args.length == 1)) {
          ((WifiMonitor.WifiLockEntity)???).tag = ((String)paramMethodHookParam.args[0]);
        }
        localObject3 = new WeakReference((WifiManager.WifiLock)paramMethodHookParam.result);
        synchronized (this.map)
        {
          this.map.put(localObject3, ???);
          if (paramMethodHookParam.args == null) {
            return;
          }
          if (paramMethodHookParam.args.length == 1)
          {
            writeCommonLog(new String[] { "wf_new|", ((WifiMonitor.WifiLockEntity)???).uuid, "|0|", String.valueOf(paramMethodHookParam.args[0]) });
            return;
          }
          writeCommonLog(new String[] { "wf_new|", ((WifiMonitor.WifiLockEntity)???).uuid, "|", String.valueOf(paramMethodHookParam.args[0]), "|", String.valueOf(paramMethodHookParam.args[1]) });
          return;
        }
      }
      return;
    }
    catch (Throwable paramMethodHookParam)
    {
      Logger.INSTANCE.exception("QAPM_battery_WifiLock", paramMethodHookParam);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.isRunning) {
      return;
    }
    try
    {
      String str = getAppStack().toString();
      if (Logger.debug)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(paramMethodHookParam.method.getName());
        ((StringBuilder)???).append(str);
        printLog(((StringBuilder)???).toString());
      }
      if ("startScan".equals(paramMethodHookParam.method.getName()))
      {
        writeCommonLog(new String[] { "wfScan", "|", str });
        paramMethodHookParam = this.detector1.onAction(str);
        if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("Wifi scan is too frequently(");
          ((StringBuilder)???).append(this.maxCallTimeInShortTime);
          ((StringBuilder)???).append(" in ");
          ((StringBuilder)???).append(this.shortTime / 60L / 1000L);
          ((StringBuilder)???).append(" seconds");
          onUsageAlarm(5, 0, 0, ((StringBuilder)???).toString(), HighFrequencyDetector.getDescription(paramMethodHookParam));
          this.detector1.trimCache();
        }
        paramMethodHookParam = this.detector2.onAction(str);
        if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("Wifi scan is too frequently(");
          ((StringBuilder)???).append(this.maxCallTimeInLongTime);
          ((StringBuilder)???).append(" in ");
          ((StringBuilder)???).append(this.longTime / 60L / 1000L);
          ((StringBuilder)???).append(" seconds");
          onUsageAlarm(5, 0, 0, ((StringBuilder)???).toString(), HighFrequencyDetector.getDescription(paramMethodHookParam));
          this.detector2.trimCache();
        }
        paramMethodHookParam = new Bundle();
        paramMethodHookParam.putInt("key_action", 8);
        paramMethodHookParam.putString("key_stack", str);
        onOtherProcReport(paramMethodHookParam);
        return;
      }
      if ("acquire".equals(paramMethodHookParam.method.getName())) {
        synchronized (this.map)
        {
          Iterator localIterator = this.map.keySet().iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            WifiMonitor.WifiLockEntity localWifiLockEntity = (WifiMonitor.WifiLockEntity)this.map.get(localWeakReference);
            if (localWeakReference.get() == paramMethodHookParam.thisObject)
            {
              writeCommonLog(new String[] { "wf_ac|", localWifiLockEntity.uuid, "|", str });
              if (!((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld()) {
                localWifiLockEntity.firstAcquireTimeStamp = SystemClock.uptimeMillis();
              }
            }
            else if (localWeakReference.get() == null)
            {
              writeCommonLog(new String[] { "wf_alarm|", localWifiLockEntity.uuid });
              localIterator.remove();
            }
          }
          return;
        }
      }
      return;
    }
    catch (Throwable paramMethodHookParam)
    {
      Logger.INSTANCE.exception("QAPM_battery_WifiLock", paramMethodHookParam);
    }
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    synchronized (this.fg30MinScanMap)
    {
      this.bg5MinScanMap.clear();
      synchronized (this.fg30MinLockMap)
      {
        this.bg5MinLockMap.clear();
        return;
      }
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    if (!this.isRunning) {
      return;
    }
    int i = paramBundle.getInt("key_action");
    String str = paramBundle.getString("key_stack");
    ??? = paramBundle.getString("key_tag");
    long l = paramBundle.getLong("key_duration");
    Object localObject1;
    if (i == 8)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_battery_WifiLock", "WiFi.onOtherProcReport: scan:", str });
      synchronized (this.fg30MinScanMap)
      {
        if (this.isBeforeRun30Min)
        {
          localObject1 = (HashSet)this.fg30MinScanMap.get(str);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = new HashSet();
            this.fg30MinScanMap.put(str, paramBundle);
          }
          paramBundle.add(Long.valueOf(System.currentTimeMillis()));
        }
        if ((this.isAppBackground) && (this.isInFirstBg5min))
        {
          localObject1 = (HashSet)this.bg5MinScanMap.get(str);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = new HashSet();
            this.bg5MinScanMap.put(str, paramBundle);
          }
          paramBundle.add(Long.valueOf(System.currentTimeMillis()));
        }
        return;
      }
    }
    if (i == 9) {
      synchronized (this.fg30MinLockMap)
      {
        if (this.isBeforeRun30Min)
        {
          localObject1 = (WifiMonitor.ReportEntity)this.fg30MinLockMap.get(str);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = new WifiMonitor.ReportEntity(this, null);
            paramBundle.tag = ((String)???);
            paramBundle.createStack = str;
            this.fg30MinLockMap.put(str, paramBundle);
          }
          paramBundle.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
        }
        if ((this.isAppBackground) && (this.isInFirstBg5min))
        {
          localObject1 = (WifiMonitor.ReportEntity)this.bg5MinLockMap.get(str);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = new WifiMonitor.ReportEntity(this, null);
            paramBundle.tag = ((String)???);
            paramBundle.createStack = str;
            this.bg5MinLockMap.put(str, paramBundle);
          }
          paramBundle.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
        }
        return;
      }
    }
    if (i == 10) {
      writeReportLog(new String[] { "wflNotRelease", "|", str, "|", ???, "|0|0" });
    }
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if ((this.isRunning) && (!this.fg30MinScanMap.isEmpty())) {
      synchronized (this.fg30MinScanMap)
      {
        Iterator localIterator1 = this.bg5MinScanMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        writeReportLog(new String[] { "bg5WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.bg5MinScanMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
          HashSet localHashSet = (HashSet)this.bg5MinScanMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          while (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            int j = i + 1;
            i = j;
            if (j < localHashSet.size())
            {
              localStringBuilder.append("#");
              i = j;
            }
          }
          writeReportLog(new String[] { "bg5WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
        this.bg5MinScanMap.clear();
        writeLockReport(false);
        return;
      }
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    synchronized (this.fg30MinScanMap)
    {
      if ((this.isRunning) && (!this.fg30MinScanMap.isEmpty()))
      {
        Iterator localIterator1 = this.fg30MinScanMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        writeReportLog(new String[] { "fg30WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.fg30MinScanMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
          HashSet localHashSet = (HashSet)this.fg30MinScanMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          while (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            int j = i + 1;
            i = j;
            if (j < localHashSet.size())
            {
              localStringBuilder.append("#");
              i = j;
            }
          }
          writeReportLog(new String[] { "fg30WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
        this.fg30MinScanMap.clear();
      }
      writeLockReport(true);
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onProcessStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.WifiMonitor
 * JD-Core Version:    0.7.0.1
 */