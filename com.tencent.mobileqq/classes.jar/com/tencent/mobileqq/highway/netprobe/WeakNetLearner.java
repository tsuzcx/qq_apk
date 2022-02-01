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
    WeakNetCallback localWeakNetCallback = this.cb;
    if ((localWeakNetCallback != null) && (localHashMap != null)) {
      localWeakNetCallback.onResultOverflow(localHashMap);
    }
  }
  
  private HashMap<String, String> getReportParams(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap;
    Object localObject2;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      localHashMap = new HashMap();
      localObject2 = new ArrayList();
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (Map.Entry)localIterator.next();
          String str1 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = ((String)((Map.Entry)localObject3).getValue()).trim();
          if (((String)localObject3).length() >= 1000) {
            break label295;
          }
          localHashMap.put(str1.trim(), localObject3);
          continue;
          if (i <= ((String)localObject3).length())
          {
            String str2 = ((String)localObject3).substring(j, i);
            int m = i + 1000;
            j = m;
            if (m >= ((String)localObject3).length()) {
              j = ((String)localObject3).length();
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str1.trim());
            localStringBuilder.append("_");
            localStringBuilder.append(k);
            localHashMap.put(localStringBuilder.toString(), str2);
            m = k + 1;
            k = i;
            i = j;
            j = k;
            k = m;
            continue;
          }
          ((ArrayList)localObject2).add(str1);
          continue;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramHashMap.remove((String)((Iterator)localObject2).next());
          continue;
        }
        return localHashMap;
      }
      finally {}
      return null;
      label295:
      int k = 1;
      int i = 1000;
      int j = 0;
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
    WeakNetLearner.ProbeHandler localProbeHandler = this.probeHandler;
    if (localProbeHandler != null) {
      localProbeHandler.sendEmptyMessage(2);
    }
    this.reports.clear();
    mContext = null;
  }
  
  public void onInit() {}
  
  public void onTaskFinish(ProbeTask paramProbeTask)
  {
    if (this.isDestroy) {
      return;
    }
    synchronized (this.reports)
    {
      this.reports.put(paramProbeTask.getKey(), paramProbeTask.resp.getResult());
      int i = this.doneNum.incrementAndGet();
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.lastReportTime;
      if ((l2 <= 0L) || (l1 - l2 >= 600000L) || (i >= 12))
      {
        doAfterOverflow();
        this.doneNum.set(0);
        this.lastReportTime = l1;
      }
      return;
    }
  }
  
  public boolean startProbe(ProbeTask paramProbeTask)
  {
    if (paramProbeTask != null)
    {
      if (this.isDestroy) {
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
        ??? = this.probeHandler;
        if (??? != null)
        {
          ??? = ((WeakNetLearner.ProbeHandler)???).obtainMessage();
          ((Message)???).what = 1;
          ((Message)???).obj = paramProbeTask;
          this.probeHandler.sendMessage((Message)???);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.WeakNetLearner
 * JD-Core Version:    0.7.0.1
 */