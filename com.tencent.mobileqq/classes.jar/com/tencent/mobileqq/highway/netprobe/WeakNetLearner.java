package com.tencent.mobileqq.highway.netprobe;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.IHwManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class WeakNetLearner
  implements IHwManager
{
  private static final long REPORT_INTERVAL = 600000L;
  public static final String REPORT_TAG_NAME = "actWeaknetProbe";
  private static final int REPORT_THRESHOLD = 12;
  public static final String TAG = "WekaNet Learner";
  public static Context mContext;
  private WeakNetCallback cb;
  private AtomicInteger doneNum = new AtomicInteger(0);
  private volatile boolean isDestroy = false;
  public long lastReportTime = -1L;
  private WeakNetLearner.ProbeHandler probeHandler;
  private HandlerThread probeThread;
  private HashMap<String, Long> repeactTaskMonitor;
  private HashMap<String, String> reports;
  
  public WeakNetLearner(Context paramContext, WeakNetCallback paramWeakNetCallback)
  {
    mContext = paramContext;
    this.probeThread = new HandlerThread("WekaNet Learner");
    this.reports = new HashMap();
    this.repeactTaskMonitor = new HashMap();
    this.cb = paramWeakNetCallback;
    this.probeThread.setName("Highway-BDH-WeakNet");
    this.probeThread.start();
    this.probeHandler = new WeakNetLearner.ProbeHandler(this, this.probeThread.getLooper());
  }
  
  private void doAfterOverflow()
  {
    HashMap localHashMap = getReportParams(this.reports);
    if ((this.cb != null) && (localHashMap != null)) {
      this.cb.onResultOverflow(localHashMap);
    }
  }
  
  private HashMap<String, String> getReportParams(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = new ArrayList();
    Object localObject2;
    String str1;
    try
    {
      Iterator localIterator = paramHashMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label238;
        }
        localObject2 = (Map.Entry)localIterator.next();
        str1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((String)((Map.Entry)localObject2).getValue()).trim();
        if (((String)localObject2).length() >= 1000) {
          break;
        }
        localHashMap.put(str1.trim(), localObject2);
        ((ArrayList)localObject1).add(str1);
      }
      k = 1;
    }
    finally {}
    int k;
    int j = 0;
    int i = 1000;
    label144:
    String str2;
    if (i <= ((String)localObject2).length())
    {
      str2 = ((String)localObject2).substring(j, i);
      if (i + 1000 < ((String)localObject2).length()) {
        break label278;
      }
    }
    label278:
    for (j = ((String)localObject2).length();; j = i + 1000)
    {
      localHashMap1.put(str1.trim() + "_" + k, str2);
      int m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break label144;
      break;
      label238:
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramHashMap.remove((String)((Iterator)localObject1).next());
      }
      return localHashMap1;
    }
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
    if (this.doneNum.get() != 0)
    {
      doAfterOverflow();
      this.doneNum = null;
    }
    if (this.probeHandler != null) {
      this.probeHandler.sendEmptyMessage(2);
    }
    this.reports.clear();
    mContext = null;
  }
  
  public void onInit() {}
  
  public void onTaskFinish(ProbeTask paramProbeTask)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      synchronized (this.reports)
      {
        this.reports.put(paramProbeTask.getKey(), paramProbeTask.resp.getResult());
        int i = this.doneNum.incrementAndGet();
        long l = SystemClock.uptimeMillis();
        if ((this.lastReportTime > 0L) && (l - this.lastReportTime < 600000L) && (i < 12)) {
          continue;
        }
        doAfterOverflow();
        this.doneNum.set(0);
        this.lastReportTime = l;
        return;
      }
    }
  }
  
  public boolean startProbe(ProbeTask paramProbeTask)
  {
    if ((paramProbeTask == null) || (this.isDestroy)) {
      return false;
    }
    ??? = (Long)this.repeactTaskMonitor.get(paramProbeTask.getKey());
    long l = SystemClock.uptimeMillis();
    if ((??? != null) && (l - ((Long)???).longValue() < 60000L)) {
      return false;
    }
    synchronized (this.repeactTaskMonitor)
    {
      this.repeactTaskMonitor.put(paramProbeTask.getKey(), Long.valueOf(l));
      paramProbeTask.learner = new WeakReference(this);
      if (this.probeHandler != null)
      {
        ??? = this.probeHandler.obtainMessage();
        ((Message)???).what = 1;
        ((Message)???).obj = paramProbeTask;
        this.probeHandler.sendMessage((Message)???);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.WeakNetLearner
 * JD-Core Version:    0.7.0.1
 */