package com.tencent.qqperf.tools;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.perf.report.FeatureFlag;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import com.tencent.qqperf.monitor.memory.MemoryManager.DebugMemoryInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;

public class SceneTracker
  implements Handler.Callback, QActivityLifecycleCallbacks
{
  private static SceneTracker g;
  public Handler a;
  private int b;
  private int c;
  private int d;
  private SharedPreferences e;
  private boolean f;
  private RecyclablePool h;
  private LinkedHashMap<String, SceneTracker.Tracker> i;
  private LinkedList<SceneTracker.Tracker> j;
  private Set<String> k;
  private MemoryManager.DebugMemoryInfo l;
  
  private SceneTracker()
  {
    boolean bool2 = false;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = null;
    this.f = false;
    this.h = new RecyclablePool(SceneTracker.Tracker.class, 5);
    this.i = new LinkedHashMap(4);
    this.j = new LinkedList();
    this.k = new HashSet(10);
    this.l = new MemoryManager.DebugMemoryInfo();
    BaseApplication localBaseApplication = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scene_tracker");
    localStringBuilder.append(MobileQQ.sProcessId);
    this.e = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    long l1 = this.e.getLong("last_rand_time", 0L);
    l1 = Math.abs(System.currentTimeMillis() - l1);
    int m = 2;
    if (l1 < 86400000L)
    {
      if (!this.e.getBoolean("rand_rs", false)) {
        m = 1;
      }
      this.b = m;
      this.c = this.e.getInt("rpt_nest_count", 0);
      this.d = this.e.getInt("rpt_nnest_count", 0);
    }
    else
    {
      if (Math.random() < 0.0005000000237487257D) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (!bool1) {
        m = 1;
      }
      this.b = m;
      this.e.edit().putLong("last_rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("rpt_nest_count", 0).putInt("rpt_nnest_count", 0).apply();
    }
    this.a = new Handler(ThreadManager.getFileThreadLooper(), this);
    Foreground.addActivityLifeCallback(this);
    boolean bool1 = bool2;
    if (Foreground.getResumeActivityCount() > 0) {
      bool1 = true;
    }
    this.f = bool1;
  }
  
  public static SceneTracker a()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new SceneTracker();
        }
      }
      finally {}
    }
    return g;
  }
  
  private void a(SceneTracker.Tracker paramTracker)
  {
    if ((paramTracker.o > 0) && (Math.random() < 0.1500000059604645D))
    {
      if (paramTracker.t == null)
      {
        m = this.d;
        if (m >= 20) {
          break label110;
        }
        this.d = (m + 1);
        this.e.edit().putInt("rpt_nnest_count", this.d);
      }
      else
      {
        m = this.c;
        if (m >= 20) {
          break label110;
        }
        this.c = (m + 1);
        this.e.edit().putInt("rpt_nest_count", this.c);
      }
      m = 1;
      break label112;
    }
    label110:
    int m = 0;
    label112:
    if (m != 0)
    {
      HashMap localHashMap = new HashMap(30);
      localHashMap.put("stage", paramTracker.a);
      localHashMap.put("nestStage", paramTracker.t);
      localHashMap.put("fromStage", paramTracker.s);
      localHashMap.put("model", Build.MODEL);
      localHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
      localHashMap.put("startPss", String.valueOf(paramTracker.h / 1024L));
      localHashMap.put("startHeap", String.valueOf(paramTracker.b / 1024L));
      localHashMap.put("startCache", String.valueOf(paramTracker.d / 1024L));
      localHashMap.put("startNativePss", String.valueOf(paramTracker.i / 1024L));
      if (paramTracker.o > 0)
      {
        localHashMap.put("avgPss", String.valueOf(paramTracker.l / paramTracker.o / 1024L));
        localHashMap.put("avgHeap", String.valueOf(paramTracker.n / paramTracker.o / 1024L));
        localHashMap.put("avgNativePss", String.valueOf(paramTracker.m / paramTracker.o / 1024L));
      }
      localHashMap.put("maxPss", String.valueOf(paramTracker.p / 1024L));
      localHashMap.put("maxNativePss", String.valueOf(paramTracker.q / 1024L));
      localHashMap.put("maxHeap", String.valueOf(paramTracker.r / 1024L));
      localHashMap.put("endPss", String.valueOf(paramTracker.j / 1024L));
      localHashMap.put("endNativePss", String.valueOf(paramTracker.k / 1024L));
      localHashMap.put("endHeap", String.valueOf(paramTracker.e / 1024L));
      localHashMap.put("endCache", String.valueOf(paramTracker.g / 1024L));
      if (paramTracker.u) {
        ??? = "0";
      } else {
        ??? = "1";
      }
      localHashMap.put("firstTrack", ???);
      localHashMap.put("processId", String.valueOf(MobileQQ.sProcessId));
      FeatureFlag.a(localHashMap);
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "actSceneMem", true, 0L, 0L, localHashMap, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("SceneTracker", 2, new Object[] { paramTracker.a, "alloc:", Long.valueOf(paramTracker.b), "->", Long.valueOf(paramTracker.e), "; free:", Long.valueOf(paramTracker.c), "->", Long.valueOf(paramTracker.f) });
    }
    synchronized (this.i)
    {
      if (!this.j.contains(paramTracker)) {
        this.h.recycle(paramTracker);
      }
      return;
    }
  }
  
  private boolean a(MemoryManager.DebugMemoryInfo paramDebugMemoryInfo, long paramLong1, long paramLong2, SceneTracker.Tracker paramTracker)
  {
    boolean bool1;
    synchronized (this.i)
    {
      Iterator localIterator = this.i.values().iterator();
      for (;;)
      {
        boolean bool2 = localIterator.hasNext();
        bool1 = true;
        if (!bool2) {
          break;
        }
        SceneTracker.Tracker localTracker = (SceneTracker.Tracker)localIterator.next();
        if (localTracker != paramTracker)
        {
          localTracker.n += paramLong1;
          localTracker.m = paramDebugMemoryInfo.b;
          localTracker.l += paramDebugMemoryInfo.a;
          localTracker.p = Math.max(paramDebugMemoryInfo.a, localTracker.p);
          localTracker.o += 1;
          localTracker.q = Math.max(paramDebugMemoryInfo.b, localTracker.q);
          localTracker.r = Math.max(paramLong1, localTracker.r);
        }
      }
      if ((this.i.size() > 0) && (this.f)) {
        return bool1;
      }
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.b == 0) {
      return;
    }
    SceneTracker.Tracker localTracker2 = (SceneTracker.Tracker)this.h.obtain(SceneTracker.Tracker.class);
    localTracker2.a = paramString;
    localTracker2.u = (this.k.contains(paramString) ^ true);
    if (localTracker2.u) {
      this.k.add(paramString);
    }
    synchronized (this.i)
    {
      if (this.i.size() > 0)
      {
        SceneTracker.Tracker localTracker1 = null;
        Iterator localIterator = this.i.values().iterator();
        while (localIterator.hasNext()) {
          localTracker1 = (SceneTracker.Tracker)localIterator.next();
        }
        if (localTracker1 == null) {
          return;
        }
        localTracker2.s = localTracker1.a;
        if (localTracker1.t == null) {
          localTracker1.t = localTracker2.a;
        }
      }
      this.i.put(paramString, localTracker2);
      if (this.j.size() > 8)
      {
        paramString = (SceneTracker.Tracker)this.j.remove(0);
        if ((!this.i.containsValue(paramString)) && (!paramString.v)) {
          this.h.recycle(paramString);
        }
      }
      this.j.add(localTracker2);
      this.a.removeMessages(2);
      int m = this.b;
      if (m == 1)
      {
        localTracker2.b = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        localTracker2.c = Runtime.getRuntime().freeMemory();
        return;
      }
      if (m == 2)
      {
        paramString = this.a.obtainMessage(0);
        paramString.obj = localTracker2;
        if (paramBoolean)
        {
          this.a.sendMessageDelayed(paramString, 1000L);
          return;
        }
        this.a.sendMessageAtFrontOfQueue(paramString);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public String b()
  {
    try
    {
      localStringBuilder = new StringBuilder();
    }
    catch (Exception localException1)
    {
      StringBuilder localStringBuilder;
      int m;
      label28:
      label249:
      label252:
      break label249;
    }
    try
    {
      synchronized (this.i)
      {
        m = this.j.size() - 1;
        if (m >= 0)
        {
          SceneTracker.Tracker localTracker = (SceneTracker.Tracker)this.j.get(m);
          long l1;
          if (localTracker.e == 0L) {
            l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
          } else {
            l1 = localTracker.e;
          }
          long l2;
          if (localTracker.f == 0L) {
            l2 = Runtime.getRuntime().freeMemory();
          } else {
            l2 = localTracker.f;
          }
          localStringBuilder.append(localTracker.a);
          localStringBuilder.append("(From ");
          localStringBuilder.append(localTracker.s);
          localStringBuilder.append(")");
          localStringBuilder.append(":Alloc ");
          localStringBuilder.append(localTracker.b);
          localStringBuilder.append("->");
          localStringBuilder.append(l1);
          localStringBuilder.append(";Free ");
          localStringBuilder.append(localTracker.c);
          localStringBuilder.append("->");
          localStringBuilder.append(l2);
          localStringBuilder.append("|");
          m -= 1;
          break label28;
        }
      }
      localStringBuilder = null;
    }
    catch (Exception localException2)
    {
      break label252;
    }
    if (localStringBuilder == null) {
      return "Exception";
    }
    return localStringBuilder.toString();
  }
  
  public void b(String paramString)
  {
    if (this.b == 0) {
      return;
    }
    synchronized (this.i)
    {
      paramString = (SceneTracker.Tracker)this.i.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.v = true;
      int m = this.b;
      if (m == 1)
      {
        paramString.e = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        paramString.f = Runtime.getRuntime().freeMemory();
        if (QLog.isColorLevel()) {
          QLog.d("SceneTracker", 2, new Object[] { paramString.a, "alloc:", Long.valueOf(paramString.b), "->", Long.valueOf(paramString.e), "; free:", Long.valueOf(paramString.c), "->", Long.valueOf(paramString.f) });
        }
        synchronized (this.i)
        {
          if (!this.j.contains(paramString)) {
            this.h.recycle(paramString);
          } else {
            paramString.v = false;
          }
          return;
        }
      }
      if (m == 2)
      {
        ??? = this.a.obtainMessage(1);
        ((Message)???).obj = paramString;
        this.a.sendMessageDelayed((Message)???, 2000L);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l3 = Runtime.getRuntime().freeMemory();
    MemoryManager.a(Process.myPid(), this.l);
    int m = paramMessage.what;
    long l1 = 0L;
    if (m == 0)
    {
      this.a.removeMessages(2);
      paramMessage = (SceneTracker.Tracker)paramMessage.obj;
      paramMessage.b = l2;
      paramMessage.c = l3;
      paramMessage.i = this.l.b;
      if (GlobalImageCache.a != null) {
        l1 = GlobalImageCache.a.size();
      }
      paramMessage.d = l1;
      paramMessage.h = this.l.a;
      if (a(this.l, l2, l3, paramMessage)) {
        this.a.sendEmptyMessageDelayed(2, 2000L);
      }
    }
    else if (paramMessage.what == 1)
    {
      this.a.removeMessages(2);
      paramMessage = (SceneTracker.Tracker)paramMessage.obj;
      paramMessage.e = l2;
      paramMessage.f = l3;
      paramMessage.k = this.l.b;
      if (GlobalImageCache.a != null) {
        l1 = GlobalImageCache.a.size();
      }
      paramMessage.g = l1;
      paramMessage.j = this.l.a;
      if (a(this.l, l2, l3, null)) {
        this.a.sendEmptyMessageDelayed(2, 2000L);
      }
      a(paramMessage);
    }
    else if (a(this.l, l2, l3, null))
    {
      this.a.sendEmptyMessageDelayed(2, 2000L);
    }
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    b(paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onProcessBackground()
  {
    this.f = false;
  }
  
  public void onProcessForeground()
  {
    this.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.SceneTracker
 * JD-Core Version:    0.7.0.1
 */