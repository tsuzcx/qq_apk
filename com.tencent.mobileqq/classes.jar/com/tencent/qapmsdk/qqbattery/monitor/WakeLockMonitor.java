package com.tencent.qapmsdk.qqbattery.monitor;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import android.util.Pair;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.qqbattery.BatteryUsageItem;
import com.tencent.qapmsdk.qqbattery.HighFrequencyDetector;
import com.tencent.qapmsdk.qqbattery.config.WakeLockMeta;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WakeLockMonitor
  extends BatteryUsageItem
  implements Handler.Callback, HookMethodCallback
{
  private static final String KEY_FLAG = "key_flag";
  private static final String KEY_STACK = "key_stack";
  private static final String KEY_TAG = "key_tag";
  private static final String KEY_TIME = "key_time";
  private static final String METHOD_ACQUIRE = "acquire";
  private static final String METHOD_NEW_WAKELOCK = "newWakeLock";
  private static final String METHOD_RELEASE = "release";
  private static final int MSG_TIMEOUT = 1;
  public static final String RPT_BG_5_WL_COUNT = "bg5WlCount";
  public static final String RPT_BG_5_WL_USE = "bg5WlUse";
  public static final String RPT_FG_30_WL_COUNT = "fg30WlCount";
  public static final String RPT_FG_30_WL_USE = "fg30WlUse";
  public static final String RPT_WL_NOT_RELEASE = "wlNotRelease";
  public static final String RPT_WL_TIMEOUT = "wlTimeout";
  public static final String TAG = "QAPM_battery_WakeLock";
  private static final String WAKELOCK_ALARM = "wl_alm";
  private static final String WAKELOCK_TIME = "wl_tm";
  private static final String WAKELOCK_USAGE = "wl_usg";
  private HashMap<String, WakeLockMonitor.ReportEntity> bg5MinMap = new HashMap();
  private HashMap<String, WakeLockMonitor.ReportEntity> fg30MinMap = new HashMap();
  private long longTime = 7200000L;
  private HashMap<WeakReference<PowerManager.WakeLock>, WakeLockMonitor.WakeLockEntity> map = new HashMap();
  private long maxAcquireTime = 30000L;
  private int maxCallTimeInLongTime = 10;
  private int maxCallTimeInShortTime = 3;
  private long shortTime = 600000L;
  private Handler subHandler = new Handler(ThreadManager.getBatteryThreadLooper(), this);
  
  public WakeLockMonitor(WakeLockMeta paramWakeLockMeta)
  {
    this.maxAcquireTime = paramWakeLockMeta.maxAcquireTime;
    this.maxAcquireTime *= 10L;
    this.maxCallTimeInShortTime = paramWakeLockMeta.maxCallTimeInShortTime;
    this.shortTime = paramWakeLockMeta.shortTime;
    this.maxCallTimeInLongTime = paramWakeLockMeta.maxCallTimeInLongTime;
    this.longTime = paramWakeLockMeta.longTime;
  }
  
  private final void doReport(WakeLockMonitor.WakeLockEntity paramWakeLockEntity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramWakeLockEntity.createStack);
    localBundle.putString("key_tag", paramWakeLockEntity.tag);
    localBundle.putInt("key_flag", paramWakeLockEntity.levelAndFlags);
    localBundle.putLong("key_time", paramWakeLockEntity.getHoldTime());
    onOtherProcReport(localBundle);
  }
  
  private final void writeReport(boolean paramBoolean)
  {
    HashMap localHashMap2 = this.fg30MinMap;
    long l2 = 0L;
    long l1 = 0L;
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      int k;
      try
      {
        HashMap localHashMap1 = this.fg30MinMap;
        if (localHashMap1.isEmpty()) {
          break label491;
        }
        localObject2 = localHashMap1.values().iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (WakeLockMonitor.ReportEntity)((Iterator)localObject2).next();
          k = ((WakeLockMonitor.ReportEntity)localObject3).useList.size();
          if ((((WakeLockMonitor.ReportEntity)localObject3).flag & 0x1) <= 0) {
            break label498;
          }
          j = 1;
          localObject3 = ((WakeLockMonitor.ReportEntity)localObject3).useList.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label503;
          }
          localObject4 = (Pair)((Iterator)localObject3).next();
          l2 += ((Long)((Pair)localObject4).second).longValue();
          if (j == 0) {
            break label495;
          }
          l1 = ((Long)((Pair)localObject4).second).longValue() + l1;
          break label495;
          localHashMap1 = this.bg5MinMap;
          continue;
        }
        if (!paramBoolean) {
          break label514;
        }
        localObject2 = "fg30WlCount";
        writeReportLog(new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l2), "|", String.valueOf(l1) });
        Object localObject4 = localHashMap1.keySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label486;
        }
        String str = (String)((Iterator)localObject4).next();
        localObject3 = (WakeLockMonitor.ReportEntity)localHashMap1.get(str);
        StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
        localObject2 = ((WakeLockMonitor.ReportEntity)localObject3).useList.iterator();
        i = 0;
        Object localObject5;
        if (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(((Pair)localObject5).first).append(",").append(((Pair)localObject5).second);
          i += 1;
          if (i >= ((WakeLockMonitor.ReportEntity)localObject3).useList.size()) {
            break label511;
          }
          localStringBuilder.append("#");
          break label511;
        }
        if (paramBoolean)
        {
          localObject2 = "fg30WlUse";
          localObject5 = ((WakeLockMonitor.ReportEntity)localObject3).tag.replace("|", "_");
          if ((((WakeLockMonitor.ReportEntity)localObject3).flag & 0x1) <= 0) {
            break label521;
          }
          localObject3 = "1";
          writeReportLog(new String[] { localObject2, "|", localObject5, "|", localObject3, "|", str, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WlUse";
      }
      finally {}
      continue;
      label486:
      localObject1.clear();
      label491:
      return;
      label495:
      continue;
      label498:
      int j = 0;
      continue;
      label503:
      i += k;
      continue;
      label511:
      continue;
      label514:
      Object localObject2 = "bg5WlCount";
      continue;
      label521:
      Object localObject3 = "0";
    }
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!"acquire".equals(paramMethodHookParam.method.getName())) {
      onHook(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ("acquire".equals(paramMethodHookParam.method.getName())) {
      onHook(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      synchronized (this.map)
      {
        paramMessage = (WeakReference)paramMessage.obj;
        paramMessage = (WakeLockMonitor.WakeLockEntity)this.map.get(paramMessage);
        if (paramMessage != null)
        {
          doReport(paramMessage, 5);
          writeCommonLog(new String[] { "wl_alm", "|", paramMessage.uuid, "|0|0" });
          onUsageAlarm(4, 1, 0, "Acquire " + paramMessage.tag + " too long time", "CallStack: " + paramMessage.createStack);
          return false;
        }
        Logger.INSTANCE.i(new String[] { "QAPM_battery_WakeLock", "wake lock is lost ?" });
      }
    }
    return false;
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
  
  public void onHook(String arg1, Object paramObject1, Object[] paramArrayOfObject, Object paramObject2)
  {
    if (!this.isRunning) {
      synchronized (this.map)
      {
        this.subHandler.removeMessages(1);
        return;
      }
    }
    Object localObject2;
    Object localObject3;
    label289:
    label322:
    long l;
    label517:
    label632:
    do
    {
      for (;;)
      {
        synchronized (this.map)
        {
          if ("newWakeLock".equals(???))
          {
            paramObject1 = new WakeLockMonitor.WakeLockEntity(this);
            paramObject1.levelAndFlags = ((Integer)paramArrayOfObject[0]).intValue();
            paramObject1.tag = ((String)paramArrayOfObject[1]);
            paramObject1.createStack = getAppStack().toString();
            paramObject1.uuid = String.valueOf(paramObject1.hashCode());
            paramArrayOfObject = new WeakReference((PowerManager.WakeLock)paramObject2);
            this.map.put(paramArrayOfObject, paramObject1);
            writeCommonLog(new String[] { ???, "|", paramObject1.uuid, "|", String.valueOf(paramObject1.levelAndFlags), "|", paramObject1.tag, "|", paramObject1.createStack });
            return;
          }
        }
        if (!"acquire".equals(???)) {
          break;
        }
        paramObject2 = getAppStack().toString();
        localIterator = this.map.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          localObject3 = (WakeLockMonitor.WakeLockEntity)this.map.get(localObject2);
          if (((WeakReference)localObject2).get() == paramObject1)
          {
            if (paramArrayOfObject == null) {
              break label1174;
            }
            Object localObject4;
            if (paramArrayOfObject.length == 0)
            {
              break label1174;
              localObject4 = ((WakeLockMonitor.WakeLockEntity)localObject3).getCallStackIndex(paramObject2);
              String str = ((WakeLockMonitor.WakeLockEntity)localObject3).uuid;
              if (!((Boolean)((Pair)localObject4).first).booleanValue()) {
                break label1182;
              }
              ??? = paramObject2;
              Object localObject1;
              writeCommonLog(new String[] { "wl_usg", "|", str, "|0|", ???, "|", String.valueOf(((Pair)localObject4).second), "|", String.valueOf(localObject1) });
              ??? = ((WakeLockMonitor.WakeLockEntity)localObject3).onAcquire((PowerManager.WakeLock)paramObject1, paramObject2, localObject1);
              if (!((Boolean)???.first).booleanValue()) {
                break label517;
              }
              localObject4 = this.subHandler.obtainMessage(1);
              ((Message)localObject4).obj = localObject2;
              this.subHandler.sendMessageDelayed((Message)localObject4, this.maxAcquireTime);
            }
            for (;;)
            {
              if (???.second == null) {
                break label632;
              }
              onUsageAlarm(4, 0, 0, "Acquire " + ((WakeLockMonitor.WakeLockEntity)localObject3).tag + " too frequently", HighFrequencyDetector.getDescription((List)???.second));
              break;
              l = ((Long)paramArrayOfObject[0]).longValue();
              break label289;
              if (l >= this.maxAcquireTime)
              {
                writeCommonLog(new String[] { "wl_alm", "|", ((WakeLockMonitor.WakeLockEntity)localObject3).uuid, "|0|", String.valueOf(((Pair)localObject4).second) });
                onUsageAlarm(4, 1, 0, "Acquire " + ((WakeLockMonitor.WakeLockEntity)localObject3).tag + " too long time", "CallStack: " + ((WakeLockMonitor.WakeLockEntity)localObject3).createStack);
              }
            }
          }
          else if (((WeakReference)localObject2).get() == null)
          {
            if (((WakeLockMonitor.WakeLockEntity)localObject3).isHeld())
            {
              onUsageAlarm(4, 2, 1, "WakeLock " + ((WakeLockMonitor.WakeLockEntity)localObject3).tag + " not release", "CreateStack: " + ((WakeLockMonitor.WakeLockEntity)localObject3).createStack);
              writeCommonLog(new String[] { "wl_alm", "|", ((WakeLockMonitor.WakeLockEntity)localObject3).uuid, "|1" });
              doReport((WakeLockMonitor.WakeLockEntity)localObject3, 4);
            }
            ((WakeLockMonitor.WakeLockEntity)localObject3).destroy();
            localIterator.remove();
          }
        }
      }
    } while (!"release".equals(???));
    paramObject2 = getAppStack().toString();
    Iterator localIterator = this.map.keySet().iterator();
    label796:
    label852:
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (WeakReference)localIterator.next();
      ??? = (WakeLockMonitor.WakeLockEntity)this.map.get(localObject2);
      if (((WeakReference)localObject2).get() == paramObject1)
      {
        if (paramArrayOfObject == null) {
          break label1189;
        }
        if (paramArrayOfObject.length == 0)
        {
          break label1189;
          localObject3 = ???.onRelease((PowerManager.WakeLock)paramObject1, i);
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            this.subHandler.removeMessages(1, localObject2);
            writeCommonLog(new String[] { "wl_tm", "|", ???.uuid, "|", String.valueOf(((Pair)localObject3).second) });
            doReport(???, 3);
          }
          localObject2 = ???.getCallStackIndex(paramObject2);
          localObject3 = ???.uuid;
          if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
            break label1195;
          }
        }
      }
    }
    label1174:
    label1182:
    label1189:
    label1195:
    for (??? = paramObject2;; ??? = "")
    {
      writeCommonLog(new String[] { "wl_usg", "|", localObject3, "|1|", ???, "|", String.valueOf(((Pair)localObject2).second), "|", String.valueOf(i) });
      break label796;
      i = ((Integer)paramArrayOfObject[0]).intValue();
      break label852;
      if (((WeakReference)localObject2).get() != null) {
        break label796;
      }
      if (???.isHeld())
      {
        onUsageAlarm(4, 2, 1, "WakeLock " + ???.tag + " not release", "CreateStack: " + ???.createStack);
        writeCommonLog(new String[] { "wl_alm", "|", ???.uuid, "|1" });
        doReport(???, 4);
      }
      ???.destroy();
      localIterator.remove();
      break label796;
      break;
      l = -1L;
      break label289;
      ??? = "";
      break label322;
      i = -1;
      break label852;
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_action");
    if ((this.isRunning) && ((i == 3) || (i == 4) || (i == 5)))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_battery_WakeLock", "WakeLock.onOtherProcReport:action=", String.valueOf(i), ", tag=", paramBundle.getString("key_tag"), ", stack=", paramBundle.getString("key_stack"), ", time=", String.valueOf(paramBundle.getLong("key_time")) });
      String str = paramBundle.getString("key_stack");
      if (i == 3) {
        synchronized (this.fg30MinMap)
        {
          WakeLockMonitor.ReportEntity localReportEntity2;
          WakeLockMonitor.ReportEntity localReportEntity1;
          if (this.isBeforeRun30Min)
          {
            localReportEntity2 = (WakeLockMonitor.ReportEntity)this.fg30MinMap.get(str);
            localReportEntity1 = localReportEntity2;
            if (localReportEntity2 == null)
            {
              localReportEntity1 = new WakeLockMonitor.ReportEntity(this, null);
              localReportEntity1.flag = paramBundle.getInt("key_flag");
              localReportEntity1.tag = paramBundle.getString("key_tag");
              this.fg30MinMap.put(str, localReportEntity1);
            }
            localReportEntity1.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          if ((this.isAppBackground) && (this.isInFirstBg5min))
          {
            localReportEntity2 = (WakeLockMonitor.ReportEntity)this.bg5MinMap.get(str);
            localReportEntity1 = localReportEntity2;
            if (localReportEntity2 == null)
            {
              localReportEntity1 = new WakeLockMonitor.ReportEntity(this, null);
              localReportEntity1.flag = paramBundle.getInt("key_flag");
              localReportEntity1.tag = paramBundle.getString("key_tag");
              this.bg5MinMap.put(str, localReportEntity1);
            }
            localReportEntity1.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          return;
        }
      }
      if (i == 4)
      {
        writeReportLog(new String[] { "wlNotRelease", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
        return;
      }
      if (i == 5) {
        writeReportLog(new String[] { "wlTimeout", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
      }
    }
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if (this.isRunning) {
      writeReport(false);
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if (this.isRunning) {
      writeReport(true);
    }
  }
  
  public void onProcessStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.WakeLockMonitor
 * JD-Core Version:    0.7.0.1
 */