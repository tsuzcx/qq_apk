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
    localHashMap2 = this.fg30MinMap;
    if (paramBoolean) {}
    try
    {
      localHashMap1 = this.fg30MinMap;
      break label28;
      localHashMap1 = this.bg5MinMap;
      label28:
      if (localHashMap1.isEmpty()) {
        break label528;
      }
      localObject2 = localHashMap1.values().iterator();
      l4 = 0L;
      l2 = l4;
      i = 0;
      boolean bool = ((Iterator)localObject2).hasNext();
      j = 1;
      if (!bool) {
        break label208;
      }
      localObject3 = (WakeLockMonitor.ReportEntity)((Iterator)localObject2).next();
      k = i + ((WakeLockMonitor.ReportEntity)localObject3).useList.size();
      if ((((WakeLockMonitor.ReportEntity)localObject3).flag & 0x1) <= 0) {
        break label546;
      }
    }
    finally
    {
      for (;;)
      {
        HashMap localHashMap1;
        long l4;
        long l2;
        int i;
        int k;
        long l3;
        long l1;
        Object localObject4;
        for (;;)
        {
          throw localObject1;
        }
        int j = 0;
        continue;
        Object localObject2 = "bg5WlCount";
        continue;
        continue;
        localObject2 = "bg5WlUse";
        continue;
        Object localObject3 = "0";
      }
    }
    localObject3 = ((WakeLockMonitor.ReportEntity)localObject3).useList.iterator();
    l3 = l2;
    l1 = l4;
    for (;;)
    {
      i = k;
      l4 = l1;
      l2 = l3;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject4 = (Pair)((Iterator)localObject3).next();
      l2 = l1 + ((Long)((Pair)localObject4).second).longValue();
      l1 = l2;
      if (j != 0)
      {
        l3 += ((Long)((Pair)localObject4).second).longValue();
        l1 = l2;
      }
    }
    label208:
    if (paramBoolean)
    {
      localObject2 = "fg30WlCount";
      writeReportLog(new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l4), "|", String.valueOf(l2) });
      localObject4 = localHashMap1.keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        localObject3 = (WakeLockMonitor.ReportEntity)localHashMap1.get(str);
        StringBuilder localStringBuilder = ThreadTool.getReuseStringBuilder();
        localObject2 = ((WakeLockMonitor.ReportEntity)localObject3).useList.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(((Pair)localObject5).first);
          localStringBuilder.append(",");
          localStringBuilder.append(((Pair)localObject5).second);
          i += 1;
          if (i >= ((WakeLockMonitor.ReportEntity)localObject3).useList.size()) {
            break label558;
          }
          localStringBuilder.append("#");
          break label558;
        }
        if (!paramBoolean) {
          break label561;
        }
        localObject2 = "fg30WlUse";
        Object localObject5 = ((WakeLockMonitor.ReportEntity)localObject3).tag.replace("|", "_");
        if ((((WakeLockMonitor.ReportEntity)localObject3).flag & 0x1) <= 0) {
          break label568;
        }
        localObject3 = "1";
        writeReportLog(new String[] { localObject2, "|", localObject5, "|", localObject3, "|", str, "|", localStringBuilder.toString() });
      }
      localHashMap1.clear();
      return;
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
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Acquire ");
          ((StringBuilder)localObject).append(paramMessage.tag);
          ((StringBuilder)localObject).append(" too long time");
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("CallStack: ");
          localStringBuilder.append(paramMessage.createStack);
          onUsageAlarm(4, 1, 0, (String)localObject, localStringBuilder.toString());
        }
        else
        {
          Logger.INSTANCE.i(new String[] { "QAPM_battery_WakeLock", "wake lock is lost ?" });
        }
        return false;
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
    long l;
    int i;
    label1282:
    label1290:
    label1297:
    label1300:
    label1303:
    label1309:
    label1316:
    label1319:
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
      }
      else
      {
        Iterator localIterator;
        Object localObject2;
        Object localObject1;
        if ("acquire".equals(???))
        {
          paramObject2 = getAppStack().toString();
          localIterator = this.map.keySet().iterator();
          if (localIterator.hasNext())
          {
            localObject2 = (WeakReference)localIterator.next();
            localObject1 = (WakeLockMonitor.WakeLockEntity)this.map.get(localObject2);
            if (((WeakReference)localObject2).get() == paramObject1)
            {
              if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
                break label1282;
              }
              l = ((Long)paramArrayOfObject[0]).longValue();
              Object localObject3 = ((WakeLockMonitor.WakeLockEntity)localObject1).getCallStackIndex(paramObject2);
              String str = ((WakeLockMonitor.WakeLockEntity)localObject1).uuid;
              if (!((Boolean)((Pair)localObject3).first).booleanValue()) {
                break label1290;
              }
              ??? = paramObject2;
              writeCommonLog(new String[] { "wl_usg", "|", str, "|0|", ???, "|", String.valueOf(((Pair)localObject3).second), "|", String.valueOf(l) });
              ??? = ((WakeLockMonitor.WakeLockEntity)localObject1).onAcquire((PowerManager.WakeLock)paramObject1, paramObject2, l);
              if (((Boolean)???.first).booleanValue())
              {
                localObject3 = this.subHandler.obtainMessage(1);
                ((Message)localObject3).obj = localObject2;
                this.subHandler.sendMessageDelayed((Message)localObject3, this.maxAcquireTime);
                break label1297;
              }
              if (l < this.maxAcquireTime) {
                break label1297;
              }
              writeCommonLog(new String[] { "wl_alm", "|", ((WakeLockMonitor.WakeLockEntity)localObject1).uuid, "|0|", String.valueOf(((Pair)localObject3).second) });
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Acquire ");
              ((StringBuilder)localObject2).append(((WakeLockMonitor.WakeLockEntity)localObject1).tag);
              ((StringBuilder)localObject2).append(" too long time");
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("CallStack: ");
              ((StringBuilder)localObject3).append(((WakeLockMonitor.WakeLockEntity)localObject1).createStack);
              onUsageAlarm(4, 1, 0, (String)localObject2, ((StringBuilder)localObject3).toString());
              if (???.second == null) {
                break label1300;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Acquire ");
              ((StringBuilder)localObject2).append(((WakeLockMonitor.WakeLockEntity)localObject1).tag);
              ((StringBuilder)localObject2).append(" too frequently");
              onUsageAlarm(4, 0, 0, ((StringBuilder)localObject2).toString(), HighFrequencyDetector.getDescription((List)???.second));
              break label1300;
            }
            if (((WeakReference)localObject2).get() != null) {
              break label1300;
            }
            if (((WakeLockMonitor.WakeLockEntity)localObject1).isHeld())
            {
              ??? = new StringBuilder();
              ???.append("WakeLock ");
              ???.append(((WakeLockMonitor.WakeLockEntity)localObject1).tag);
              ???.append(" not release");
              ??? = ???.toString();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("CreateStack: ");
              ((StringBuilder)localObject2).append(((WakeLockMonitor.WakeLockEntity)localObject1).createStack);
              onUsageAlarm(4, 2, 1, ???, ((StringBuilder)localObject2).toString());
              writeCommonLog(new String[] { "wl_alm", "|", ((WakeLockMonitor.WakeLockEntity)localObject1).uuid, "|1" });
              doReport((WakeLockMonitor.WakeLockEntity)localObject1, 4);
            }
            ((WakeLockMonitor.WakeLockEntity)localObject1).destroy();
            localIterator.remove();
            break label1300;
          }
        }
        else if ("release".equals(???))
        {
          paramObject2 = getAppStack().toString();
          localIterator = this.map.keySet().iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (WeakReference)localIterator.next();
            ??? = (WakeLockMonitor.WakeLockEntity)this.map.get(localObject1);
            if (((WeakReference)localObject1).get() == paramObject1)
            {
              if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
                break label1303;
              }
              i = ((Integer)paramArrayOfObject[0]).intValue();
              localObject2 = ???.onRelease((PowerManager.WakeLock)paramObject1, i);
              if (((Boolean)((Pair)localObject2).first).booleanValue())
              {
                this.subHandler.removeMessages(1, localObject1);
                writeCommonLog(new String[] { "wl_tm", "|", ???.uuid, "|", String.valueOf(((Pair)localObject2).second) });
                doReport(???, 3);
              }
              localObject1 = ???.getCallStackIndex(paramObject2);
              localObject2 = ???.uuid;
              if (!((Boolean)((Pair)localObject1).first).booleanValue()) {
                break label1309;
              }
              ??? = paramObject2;
              writeCommonLog(new String[] { "wl_usg", "|", localObject2, "|1|", ???, "|", String.valueOf(((Pair)localObject1).second), "|", String.valueOf(i) });
              break label1319;
            }
            if (((WeakReference)localObject1).get() != null) {
              break label1319;
            }
            if (!???.isHeld()) {
              break label1316;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("WakeLock ");
            ((StringBuilder)localObject1).append(???.tag);
            ((StringBuilder)localObject1).append(" not release");
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("CreateStack: ");
            ((StringBuilder)localObject2).append(???.createStack);
            onUsageAlarm(4, 2, 1, (String)localObject1, ((StringBuilder)localObject2).toString());
            writeCommonLog(new String[] { "wl_alm", "|", ???.uuid, "|1" });
            doReport(???, 4);
            ???.destroy();
            localIterator.remove();
          }
        }
      }
      return;
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_action");
    if ((this.isRunning) && ((i == 3) || (i == 4) || (i == 5)))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_battery_WakeLock", "WakeLock.onOtherProcReport:action=", String.valueOf(i), ", tag=", paramBundle.getString("key_tag"), ", stack=", paramBundle.getString("key_stack"), ", time=", String.valueOf(paramBundle.getLong("key_time")) });
      Object localObject4 = paramBundle.getString("key_stack");
      Object localObject2;
      Object localObject1;
      if (i == 3) {
        synchronized (this.fg30MinMap)
        {
          if (this.isBeforeRun30Min)
          {
            localObject2 = (WakeLockMonitor.ReportEntity)this.fg30MinMap.get(localObject4);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new WakeLockMonitor.ReportEntity(this, null);
              ((WakeLockMonitor.ReportEntity)localObject1).flag = paramBundle.getInt("key_flag");
              ((WakeLockMonitor.ReportEntity)localObject1).tag = paramBundle.getString("key_tag");
              this.fg30MinMap.put(localObject4, localObject1);
            }
            ((WakeLockMonitor.ReportEntity)localObject1).useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          if ((this.isAppBackground) && (this.isInFirstBg5min))
          {
            localObject2 = (WakeLockMonitor.ReportEntity)this.bg5MinMap.get(localObject4);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new WakeLockMonitor.ReportEntity(this, null);
              ((WakeLockMonitor.ReportEntity)localObject1).flag = paramBundle.getInt("key_flag");
              ((WakeLockMonitor.ReportEntity)localObject1).tag = paramBundle.getString("key_tag");
              this.bg5MinMap.put(localObject4, localObject1);
            }
            ((WakeLockMonitor.ReportEntity)localObject1).useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          return;
        }
      }
      if (i == 4)
      {
        localObject1 = paramBundle.getString("key_stack");
        localObject2 = paramBundle.getString("key_tag");
        ??? = new StringBuilder();
        ((StringBuilder)???).append(paramBundle.getInt("key_flag"));
        ((StringBuilder)???).append("");
        ??? = ((StringBuilder)???).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramBundle.getLong("key_time"));
        ((StringBuilder)localObject4).append("");
        writeReportLog(new String[] { "wlNotRelease", "|", localObject1, "|", localObject2, "|", ???, "|", ((StringBuilder)localObject4).toString() });
        return;
      }
      if (i == 5)
      {
        localObject1 = paramBundle.getString("key_stack");
        localObject2 = paramBundle.getString("key_tag");
        ??? = new StringBuilder();
        ((StringBuilder)???).append(paramBundle.getInt("key_flag"));
        ((StringBuilder)???).append("");
        ??? = ((StringBuilder)???).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramBundle.getLong("key_time"));
        ((StringBuilder)localObject4).append("");
        writeReportLog(new String[] { "wlTimeout", "|", localObject1, "|", localObject2, "|", ???, "|", ((StringBuilder)localObject4).toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.WakeLockMonitor
 * JD-Core Version:    0.7.0.1
 */