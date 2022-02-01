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
import com.tencent.mobileqq.statistics.StatisticCollector;
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
  private static SceneTracker jdField_a_of_type_ComTencentQqperfToolsSceneTracker = null;
  private int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Handler a;
  private RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(SceneTracker.Tracker.class, 5);
  private MemoryManager.DebugMemoryInfo jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo = new MemoryManager.DebugMemoryInfo();
  private LinkedHashMap<String, SceneTracker.Tracker> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(4);
  private LinkedList<SceneTracker.Tracker> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet(10);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  private int c = 0;
  
  private SceneTracker()
  {
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_rand_time", 0L);
    if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("rand_rs", false))
      {
        this.jdField_a_of_type_Int = i;
        this.b = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("rpt_nest_count", 0);
        this.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("rpt_nnest_count", 0);
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
        Foreground.addActivityLifeCallback(this);
        if (Foreground.getResumeActivityCount() <= 0) {
          break label328;
        }
      }
    }
    label258:
    label323:
    label328:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      i = 1;
      break;
      if (Math.random() < 0.0005000000237487257D)
      {
        bool1 = true;
        if (!bool1) {
          break label323;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("rpt_nest_count", 0).putInt("rpt_nnest_count", 0).apply();
        break;
        bool1 = false;
        break label258;
        i = 1;
      }
    }
  }
  
  public static SceneTracker a()
  {
    if (jdField_a_of_type_ComTencentQqperfToolsSceneTracker == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqperfToolsSceneTracker == null) {
        jdField_a_of_type_ComTencentQqperfToolsSceneTracker = new SceneTracker();
      }
      return jdField_a_of_type_ComTencentQqperfToolsSceneTracker;
    }
    finally {}
  }
  
  private void a(SceneTracker.Tracker paramTracker)
  {
    if ((paramTracker.jdField_a_of_type_Int > 0) && (Math.random() < 0.1500000059604645D)) {
      if (paramTracker.jdField_c_of_type_JavaLangString == null)
      {
        if (this.c >= 20) {
          break label704;
        }
        this.c += 1;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("rpt_nnest_count", this.c);
      }
    }
    label704:
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i != 0)
        {
          HashMap localHashMap = new HashMap(30);
          localHashMap.put("stage", paramTracker.jdField_a_of_type_JavaLangString);
          localHashMap.put("nestStage", paramTracker.jdField_c_of_type_JavaLangString);
          localHashMap.put("fromStage", paramTracker.jdField_b_of_type_JavaLangString);
          localHashMap.put("model", Build.MODEL);
          localHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          localHashMap.put("startPss", String.valueOf(paramTracker.g / 1024L));
          localHashMap.put("startHeap", String.valueOf(paramTracker.jdField_a_of_type_Long / 1024L));
          localHashMap.put("startCache", String.valueOf(paramTracker.jdField_c_of_type_Long / 1024L));
          localHashMap.put("startNativePss", String.valueOf(paramTracker.h / 1024L));
          if (paramTracker.jdField_a_of_type_Int > 0)
          {
            localHashMap.put("avgPss", String.valueOf(paramTracker.k / paramTracker.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgHeap", String.valueOf(paramTracker.m / paramTracker.jdField_a_of_type_Int / 1024L));
            localHashMap.put("avgNativePss", String.valueOf(paramTracker.l / paramTracker.jdField_a_of_type_Int / 1024L));
          }
          localHashMap.put("maxPss", String.valueOf(paramTracker.n / 1024L));
          localHashMap.put("maxNativePss", String.valueOf(paramTracker.o / 1024L));
          localHashMap.put("maxHeap", String.valueOf(paramTracker.p / 1024L));
          localHashMap.put("endPss", String.valueOf(paramTracker.i / 1024L));
          localHashMap.put("endNativePss", String.valueOf(paramTracker.j / 1024L));
          localHashMap.put("endHeap", String.valueOf(paramTracker.d / 1024L));
          localHashMap.put("endCache", String.valueOf(paramTracker.f / 1024L));
          if (paramTracker.jdField_a_of_type_Boolean)
          {
            ??? = "0";
            localHashMap.put("firstTrack", ???);
            localHashMap.put("processId", String.valueOf(MobileQQ.sProcessId));
            StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "actSceneMem", true, 0L, 0L, localHashMap, "");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SceneTracker", 2, new Object[] { paramTracker.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(paramTracker.jdField_a_of_type_Long), "->", Long.valueOf(paramTracker.d), "; free:", Long.valueOf(paramTracker.jdField_b_of_type_Long), "->", Long.valueOf(paramTracker.e) });
        }
        synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
        {
          if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramTracker)) {
            this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramTracker);
          }
          return;
          if (this.b < 20)
          {
            this.b += 1;
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("rpt_nest_count", this.b);
            i = 1;
            continue;
            ??? = "1";
          }
        }
      }
    }
  }
  
  private boolean a(MemoryManager.DebugMemoryInfo paramDebugMemoryInfo, long paramLong1, long paramLong2, SceneTracker.Tracker paramTracker)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        SceneTracker.Tracker localTracker = (SceneTracker.Tracker)localIterator.next();
        if (localTracker != paramTracker)
        {
          localTracker.m += paramLong1;
          localTracker.l = paramDebugMemoryInfo.jdField_b_of_type_Long;
          localTracker.k += paramDebugMemoryInfo.jdField_a_of_type_Long;
          localTracker.n = Math.max(paramDebugMemoryInfo.jdField_a_of_type_Long, localTracker.n);
          localTracker.jdField_a_of_type_Int += 1;
          localTracker.o = Math.max(paramDebugMemoryInfo.jdField_b_of_type_Long, localTracker.o);
          localTracker.p = Math.max(paramLong1, localTracker.p);
        }
      }
    }
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0) && (this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String a()
  {
    ??? = null;
    try
    {
      localStringBuilder = new StringBuilder();
      try
      {
        for (;;)
        {
          synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
          {
            int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
            if (i >= 0)
            {
              SceneTracker.Tracker localTracker = (SceneTracker.Tracker)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
              long l1;
              if (localTracker.d == 0L)
              {
                l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                if (localTracker.e == 0L)
                {
                  l2 = Runtime.getRuntime().freeMemory();
                  localStringBuilder.append(localTracker.jdField_a_of_type_JavaLangString).append("(From ").append(localTracker.jdField_b_of_type_JavaLangString).append(")").append(":Alloc ").append(localTracker.jdField_a_of_type_Long).append("->").append(l1).append(";Free ").append(localTracker.jdField_b_of_type_Long).append("->").append(l2).append("|");
                  i -= 1;
                }
              }
              else
              {
                l1 = localTracker.d;
                continue;
              }
              long l2 = localTracker.e;
            }
            else
            {
              if (localStringBuilder != null) {
                break;
              }
              return "Exception";
            }
          }
        }
      }
      catch (Exception localException3) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        Exception localException2 = localException3;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    SceneTracker.Tracker localTracker2 = (SceneTracker.Tracker)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(SceneTracker.Tracker.class);
    localTracker2.jdField_a_of_type_JavaLangString = paramString;
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      localTracker2.jdField_a_of_type_Boolean = bool;
      if (localTracker2.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      SceneTracker.Tracker localTracker1;
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() <= 0) {
          break label172;
        }
        localTracker1 = null;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
        while (localIterator.hasNext()) {
          localTracker1 = (SceneTracker.Tracker)localIterator.next();
        }
        if (localTracker1 == null) {
          return;
        }
      }
      localTracker2.jdField_b_of_type_JavaLangString = localTracker1.jdField_a_of_type_JavaLangString;
      if (localTracker1.jdField_c_of_type_JavaLangString == null) {
        localTracker1.jdField_c_of_type_JavaLangString = localTracker2.jdField_a_of_type_JavaLangString;
      }
      label172:
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, localTracker2);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 8)
      {
        paramString = (SceneTracker.Tracker)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        if ((!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsValue(paramString)) && (!paramString.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString);
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(localTracker2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if (this.jdField_a_of_type_Int == 1)
      {
        localTracker2.jdField_a_of_type_Long = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        localTracker2.jdField_b_of_type_Long = Runtime.getRuntime().freeMemory();
        return;
      }
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      paramString.obj = localTracker2;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 1000L);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageAtFrontOfQueue(paramString);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        paramString = (SceneTracker.Tracker)this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
        if (paramString == null) {
          return;
        }
      }
      paramString.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Int == 1)
      {
        paramString.d = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        paramString.e = Runtime.getRuntime().freeMemory();
        if (QLog.isColorLevel()) {
          QLog.d("SceneTracker", 2, new Object[] { paramString.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(paramString.jdField_a_of_type_Long), "->", Long.valueOf(paramString.d), "; free:", Long.valueOf(paramString.jdField_b_of_type_Long), "->", Long.valueOf(paramString.e) });
        }
        for (;;)
        {
          synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
          {
            if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramString))
            {
              this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString);
              return;
            }
          }
          paramString.jdField_b_of_type_Boolean = false;
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    ??? = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)???).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)???, 2000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1 = 0L;
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l3 = Runtime.getRuntime().freeMemory();
    MemoryManager.a(Process.myPid(), this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo);
    if (paramMessage.what == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      paramMessage = (SceneTracker.Tracker)paramMessage.obj;
      paramMessage.jdField_a_of_type_Long = l2;
      paramMessage.jdField_b_of_type_Long = l3;
      paramMessage.h = this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo.jdField_b_of_type_Long;
      if (GlobalImageCache.a != null)
      {
        l1 = GlobalImageCache.a.size();
        paramMessage.jdField_c_of_type_Long = l1;
        paramMessage.g = this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo.jdField_a_of_type_Long;
        if (a(this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo, l2, l3, paramMessage)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
        }
      }
    }
    for (;;)
    {
      return false;
      l1 = 0L;
      break;
      if (paramMessage.what == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        paramMessage = (SceneTracker.Tracker)paramMessage.obj;
        paramMessage.d = l2;
        paramMessage.e = l3;
        paramMessage.j = this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo.jdField_b_of_type_Long;
        if (GlobalImageCache.a != null) {
          l1 = GlobalImageCache.a.size();
        }
        paramMessage.f = l1;
        paramMessage.i = this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo.jdField_a_of_type_Long;
        if (a(this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo, l2, l3, null)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
        }
        a(paramMessage);
      }
      else if (a(this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo, l2, l3, null))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
      }
    }
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
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onProcessForeground()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.tools.SceneTracker
 * JD-Core Version:    0.7.0.1
 */