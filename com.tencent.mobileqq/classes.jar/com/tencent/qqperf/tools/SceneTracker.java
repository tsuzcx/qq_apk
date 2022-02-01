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
  private static SceneTracker jdField_a_of_type_ComTencentQqperfToolsSceneTracker;
  private int jdField_a_of_type_Int;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  private RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  private MemoryManager.DebugMemoryInfo jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo;
  private LinkedHashMap<String, SceneTracker.Tracker> jdField_a_of_type_JavaUtilLinkedHashMap;
  private LinkedList<SceneTracker.Tracker> jdField_a_of_type_JavaUtilLinkedList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private SceneTracker()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.c = 0;
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(SceneTracker.Tracker.class, 5);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(4);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet(10);
    this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo = new MemoryManager.DebugMemoryInfo();
    BaseApplication localBaseApplication = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scene_tracker");
    localStringBuilder.append(MobileQQ.sProcessId);
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_rand_time", 0L);
    l = Math.abs(System.currentTimeMillis() - l);
    int i = 2;
    if (l < 86400000L)
    {
      if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("rand_rs", false)) {
        i = 1;
      }
      this.jdField_a_of_type_Int = i;
      this.b = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("rpt_nest_count", 0);
      this.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("rpt_nnest_count", 0);
    }
    else
    {
      if (Math.random() < 0.0005000000237487257D) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (!bool1) {
        i = 1;
      }
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("rpt_nest_count", 0).putInt("rpt_nnest_count", 0).apply();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    Foreground.addActivityLifeCallback(this);
    boolean bool1 = bool2;
    if (Foreground.getResumeActivityCount() > 0) {
      bool1 = true;
    }
    this.jdField_a_of_type_Boolean = bool1;
  }
  
  public static SceneTracker a()
  {
    if (jdField_a_of_type_ComTencentQqperfToolsSceneTracker == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfToolsSceneTracker == null) {
          jdField_a_of_type_ComTencentQqperfToolsSceneTracker = new SceneTracker();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfToolsSceneTracker;
  }
  
  private void a(SceneTracker.Tracker paramTracker)
  {
    if ((paramTracker.jdField_a_of_type_Int > 0) && (Math.random() < 0.1500000059604645D))
    {
      if (paramTracker.jdField_c_of_type_JavaLangString == null)
      {
        i = this.c;
        if (i >= 20) {
          break label110;
        }
        this.c = (i + 1);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("rpt_nnest_count", this.c);
      }
      else
      {
        i = this.b;
        if (i >= 20) {
          break label110;
        }
        this.b = (i + 1);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("rpt_nest_count", this.b);
      }
      i = 1;
      break label112;
    }
    label110:
    int i = 0;
    label112:
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
      if (paramTracker.jdField_a_of_type_Boolean) {
        ??? = "0";
      } else {
        ??? = "1";
      }
      localHashMap.put("firstTrack", ???);
      localHashMap.put("processId", String.valueOf(MobileQQ.sProcessId));
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "actSceneMem", true, 0L, 0L, localHashMap, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("SceneTracker", 2, new Object[] { paramTracker.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(paramTracker.jdField_a_of_type_Long), "->", Long.valueOf(paramTracker.d), "; free:", Long.valueOf(paramTracker.jdField_b_of_type_Long), "->", Long.valueOf(paramTracker.e) });
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramTracker)) {
        this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramTracker);
      }
      return;
    }
  }
  
  private boolean a(MemoryManager.DebugMemoryInfo paramDebugMemoryInfo, long paramLong1, long paramLong2, SceneTracker.Tracker paramTracker)
  {
    boolean bool1;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
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
          localTracker.m += paramLong1;
          localTracker.l = paramDebugMemoryInfo.jdField_b_of_type_Long;
          localTracker.k += paramDebugMemoryInfo.jdField_a_of_type_Long;
          localTracker.n = Math.max(paramDebugMemoryInfo.jdField_a_of_type_Long, localTracker.n);
          localTracker.jdField_a_of_type_Int += 1;
          localTracker.o = Math.max(paramDebugMemoryInfo.jdField_b_of_type_Long, localTracker.o);
          localTracker.p = Math.max(paramLong1, localTracker.p);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0) && (this.jdField_a_of_type_Boolean)) {
        return bool1;
      }
    }
  }
  
  public String a()
  {
    try
    {
      localStringBuilder = new StringBuilder();
    }
    catch (Exception localException1)
    {
      StringBuilder localStringBuilder;
      int i;
      label28:
      label249:
      label252:
      break label249;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
        if (i >= 0)
        {
          SceneTracker.Tracker localTracker = (SceneTracker.Tracker)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
          long l1;
          if (localTracker.d == 0L) {
            l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
          } else {
            l1 = localTracker.d;
          }
          long l2;
          if (localTracker.e == 0L) {
            l2 = Runtime.getRuntime().freeMemory();
          } else {
            l2 = localTracker.e;
          }
          localStringBuilder.append(localTracker.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("(From ");
          localStringBuilder.append(localTracker.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(")");
          localStringBuilder.append(":Alloc ");
          localStringBuilder.append(localTracker.jdField_a_of_type_Long);
          localStringBuilder.append("->");
          localStringBuilder.append(l1);
          localStringBuilder.append(";Free ");
          localStringBuilder.append(localTracker.jdField_b_of_type_Long);
          localStringBuilder.append("->");
          localStringBuilder.append(l2);
          localStringBuilder.append("|");
          i -= 1;
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
    localTracker2.jdField_a_of_type_Boolean = (this.jdField_a_of_type_JavaUtilSet.contains(paramString) ^ true);
    if (localTracker2.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0)
      {
        SceneTracker.Tracker localTracker1 = null;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
        while (localIterator.hasNext()) {
          localTracker1 = (SceneTracker.Tracker)localIterator.next();
        }
        if (localTracker1 == null) {
          return;
        }
        localTracker2.jdField_b_of_type_JavaLangString = localTracker1.jdField_a_of_type_JavaLangString;
        if (localTracker1.jdField_c_of_type_JavaLangString == null) {
          localTracker1.jdField_c_of_type_JavaLangString = localTracker2.jdField_a_of_type_JavaLangString;
        }
      }
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
      int i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        localTracker2.jdField_a_of_type_Long = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        localTracker2.jdField_b_of_type_Long = Runtime.getRuntime().freeMemory();
        return;
      }
      if (i == 2)
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
        paramString.obj = localTracker2;
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 1000L);
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessageAtFrontOfQueue(paramString);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      paramString = (SceneTracker.Tracker)this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.jdField_b_of_type_Boolean = true;
      int i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        paramString.d = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        paramString.e = Runtime.getRuntime().freeMemory();
        if (QLog.isColorLevel()) {
          QLog.d("SceneTracker", 2, new Object[] { paramString.jdField_a_of_type_JavaLangString, "alloc:", Long.valueOf(paramString.jdField_a_of_type_Long), "->", Long.valueOf(paramString.d), "; free:", Long.valueOf(paramString.jdField_b_of_type_Long), "->", Long.valueOf(paramString.e) });
        }
        synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
        {
          if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramString)) {
            this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString);
          } else {
            paramString.jdField_b_of_type_Boolean = false;
          }
          return;
        }
      }
      if (i == 2)
      {
        ??? = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)???).obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)???, 2000L);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l3 = Runtime.getRuntime().freeMemory();
    MemoryManager.a(Process.myPid(), this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo);
    int i = paramMessage.what;
    long l1 = 0L;
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      paramMessage = (SceneTracker.Tracker)paramMessage.obj;
      paramMessage.jdField_a_of_type_Long = l2;
      paramMessage.jdField_b_of_type_Long = l3;
      paramMessage.h = this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo.jdField_b_of_type_Long;
      if (GlobalImageCache.a != null) {
        l1 = GlobalImageCache.a.size();
      }
      paramMessage.jdField_c_of_type_Long = l1;
      paramMessage.g = this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo.jdField_a_of_type_Long;
      if (a(this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$DebugMemoryInfo, l2, l3, paramMessage)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
      }
    }
    else if (paramMessage.what == 1)
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
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onProcessForeground()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.tools.SceneTracker
 * JD-Core Version:    0.7.0.1
 */