package com.tencent.qqperf.opt.clearmemory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.v4.util.LruCache;
import android.support.v4.util.MQLruCache;
import com.tencent.commonsdk.cache.CacheInfo;
import com.tencent.commonsdk.cache.HashMapInfo;
import com.tencent.commonsdk.cache.IMemoryManager;
import com.tencent.commonsdk.cache.LruCacheInfo;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMMemoryClearListener;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import com.tencent.qqperf.monitor.memory.MemoryManager.IReportListener;
import com.tencent.qqperf.opt.vm.HackVmImpl;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.qqperf.repoter.ResultObject;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.theme.SkinEngine;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.IAppStateChangeListener;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class MemoryClearManager
  implements IMemoryManager, IAPMMemoryClearListener, MemoryManager.IReportListener, IAppStateChangeListener
{
  private static MemoryClearManager jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager;
  public static int l = 1;
  public static int m = 2;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private LinkedList<String> jdField_a_of_type_JavaUtilLinkedList;
  List<WeakReference<QQHashMap>> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Vector<MemoryClearManager.IClearMemoryListener> jdField_a_of_type_JavaUtilVector;
  public boolean a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  List<WeakReference<QQConcurrentHashMap>> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  List<WeakReference<QQLruCache>> jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public int d;
  long jdField_d_of_type_Long;
  List<WeakReference<LruCache>> jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public int e;
  int f;
  int g;
  public int h;
  public int i;
  public int j;
  public int k;
  private int n;
  
  private MemoryClearManager()
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.n = -1;
    Object localObject = MobileQQ.getContext().getSharedPreferences("CommonMemoryCacheSP", 0);
    if (((SharedPreferences)localObject).contains("lastShotTime")) {
      ((SharedPreferences)localObject).edit().clear().commit();
    }
    localObject = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonMemoryCacheSP_");
    localStringBuilder.append(MobileQQ.sProcessId);
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    long l1 = ((SharedPreferences)localObject).getLong("lastShotTime", 0L);
    if (Math.abs(System.currentTimeMillis() - l1) >= 43200000L)
    {
      if (0.001F >= Math.random()) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      ((SharedPreferences)localObject).edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", this.jdField_a_of_type_Boolean).apply();
    }
    else
    {
      this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("lastShotResult", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MemoryClearManager init needReport= ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("MemoryClearManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  private static int a()
  {
    Object localObject1 = GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    int i2 = 0;
    int i1 = 0;
    if (localObject1 != null)
    {
      localObject1 = GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      i2 = i1;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof Bitmap)) {}
        for (i2 = Utils.getBitmapSize((Bitmap)localObject2);; i2 = Utils.getBitmapSize((Bitmap)localObject2))
        {
          i1 += i2;
          break;
          if (!(localObject2 instanceof BitmapDrawable)) {
            break;
          }
          localObject2 = ((BitmapDrawable)localObject2).getBitmap();
          if (localObject2 == null) {
            break;
          }
        }
      }
    }
    return i2 / 1024;
  }
  
  public static MemoryClearManager a()
  {
    if (jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager == null) {
          jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager = new MemoryClearManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager;
  }
  
  private static String a(Exception paramException)
  {
    if (paramException == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramException = paramException.getStackTrace();
    int i1 = 1;
    int i2 = 0;
    while (i1 < paramException.length)
    {
      String str = paramException[i1].toString();
      if (localStringBuilder.length() == 0) {
        localStringBuilder.append("[");
      } else {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
      i2 += 1;
      if (i2 >= 16) {
        break;
      }
      i1 += 1;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a().jdField_a_of_type_Boolean)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportMemoryMsg : ");
      ((StringBuilder)localObject1).append(paramInt);
      String str = a(new IllegalStateException(((StringBuilder)localObject1).toString()));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportMemoryMsg|stack= ");
        ((StringBuilder)localObject1).append(str);
        QLog.d("CommonMemoryCache", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = MobileQQ.sMobileQQ;
      localObject1 = null;
      localObject2 = ((MobileQQ)localObject2).waitAppRuntime(null);
      if (localObject2 != null) {
        localObject2 = ((AppRuntime)localObject2).getAccount();
      } else {
        localObject2 = null;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_stack", str);
      localHashMap.put("sProcessId", String.valueOf(MobileQQ.sProcessId));
      if (paramInt == m)
      {
        localHashMap.put("key", paramString);
        localObject1 = "sImageCacheKey";
      }
      else if (paramInt == l)
      {
        localHashMap.put("name", paramString);
        localObject1 = "DexPathListHook";
      }
      if (localObject1 != null) {
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance((String)localObject2, (String)localObject1, true, 0L, 0L, localHashMap, "", true);
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, long paramLong)
  {
    try
    {
      paramJSONObject.put("MemorySize", paramLong);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("p_id", MagnifierSDK.b());
      localJSONObject2.put("plugin", String.valueOf(22));
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("memorydata", paramJSONObject);
      localJSONObject1.put("clientinfo", localJSONObject2);
      localJSONObject1.put("newplugin", 129);
      ReporterMachine.a(new ResultObject(0, "testcase", false, 1L, 1L, localJSONObject1, true, true, MagnifierSDK.jdField_a_of_type_Long));
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("reportTOAPM : ");
        paramJSONObject.append(localJSONObject1.toString());
        QLog.d("MemoryClearManager", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryClearManager", 2, paramJSONObject, new Object[0]);
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, CacheInfo paramCacheInfo, int paramInt1, int paramInt2)
  {
    if (paramCacheInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", paramInt1);
        localJSONObject.put("action", paramInt2);
        localJSONObject.put("capacity", paramCacheInfo.capacity);
        localJSONObject.put("size", paramCacheInfo.size);
        localJSONObject.put("getCount", paramCacheInfo.getCount);
        localJSONObject.put("putCount", paramCacheInfo.putCount);
        paramInt1 = paramCacheInfo.putCount;
        if (paramInt1 > 0) {
          localJSONObject.put("getRate", paramCacheInfo.getCount / paramCacheInfo.putCount);
        } else {
          localJSONObject.put("getRate", -1.0D);
        }
        localJSONObject.put("removeCount", paramCacheInfo.removeCount);
        localJSONObject.put("hitCount", paramCacheInfo.hitCount);
        localJSONObject.put("missCount", paramCacheInfo.missCount);
        paramInt1 = paramCacheInfo.hitCount;
        if ((paramInt1 <= 0) && (paramCacheInfo.missCount <= 0)) {
          localJSONObject.put("hitRate", -1.0D);
        } else {
          localJSONObject.put("hitRate", paramCacheInfo.hitCount / (paramCacheInfo.hitCount + paramCacheInfo.missCount));
        }
        localJSONObject.put("lifeTime", paramCacheInfo.lifeTime);
        localJSONObject.put("gapTime", paramCacheInfo.gapTime);
        localJSONObject.put("MemorySize", paramCacheInfo.mMemorySize);
        localJSONObject.put("ClearSize", paramCacheInfo.mClearSize);
        if ((paramCacheInfo instanceof HashMapInfo)) {
          localJSONObject.put("extra_traversalCount", ((HashMapInfo)paramCacheInfo).traversalCount);
        } else if ((paramCacheInfo instanceof LruCacheInfo)) {
          localJSONObject.put("extra_evictionCount", ((LruCacheInfo)paramCacheInfo).evictionCount);
        }
        paramJSONObject.put(String.valueOf(paramCacheInfo.tagId), localJSONObject);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MemoryClearManager", 2, paramJSONObject.toString());
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long) >= paramInt;
  }
  
  private void b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      long l1 = 0L;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (QQHashMap)((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            localObject2 = ((QQHashMap)localObject2).getReportCacheInfo();
            a(localJSONObject, (CacheInfo)localObject2, 1, paramInt);
            l1 += ((CacheInfo)localObject2).mMemorySize;
          }
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (QQConcurrentHashMap)((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            localObject2 = ((QQConcurrentHashMap)localObject2).getReportCacheInfo();
            a(localJSONObject, (CacheInfo)localObject2, 1, paramInt);
            l1 += ((CacheInfo)localObject2).mMemorySize;
          }
        }
      }
      localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (QQLruCache)((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            localObject2 = ((QQLruCache)localObject2).getCacheInfos();
            a(localJSONObject, (CacheInfo)localObject2, 2, paramInt);
            l1 += ((CacheInfo)localObject2).mMemorySize;
          }
        }
      }
      a(localJSONObject, l1);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        Object localObject1 = new StringBuilder(50);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          ((StringBuilder)localObject1).append((String)localIterator.next());
          ((StringBuilder)localObject1).append("-");
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        return localObject1;
      }
      return "-1";
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a()
  {
    a(2);
    DexPathListHook.a(MobileQQ.class.getClassLoader());
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportMemoryInfo|action= ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MemoryClearManager", 2, ((StringBuilder)localObject1).toString());
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = MobileQQ.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CommonMemoryCacheSP_");
    ((StringBuilder)localObject2).append(MobileQQ.sProcessId);
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    if (paramInt == 1) {
      localObject2 = "low_mem_report_rdm_time";
    } else {
      localObject2 = "bg_mem_report_rdm_time";
    }
    long l1 = localSharedPreferences.getLong((String)localObject2, 0L);
    if (l1 > 0L)
    {
      if (Math.abs(l2 - l1) > 3600000L)
      {
        HashMap localHashMap = new HashMap();
        if (MagnifierSDK.a().a().a.jdField_a_of_type_Boolean) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("ClearEnable", localObject1);
        localHashMap.put("DpcConfigId", MagnifierSDK.a().a().a.jdField_a_of_type_JavaLangString);
        localHashMap.put("trimCount", String.valueOf(this.jdField_d_of_type_Int));
        localHashMap.put("topTrimCount", String.valueOf(this.e));
        localHashMap.put("secondTrimCount", String.valueOf(this.f));
        localHashMap.put("thirdTrimCount", String.valueOf(this.g));
        localHashMap.put("sProcessId", String.valueOf(MobileQQ.sProcessId));
        l1 = Runtime.getRuntime().maxMemory() / 1024L;
        l3 = Runtime.getRuntime().totalMemory() / 1024L;
        int i1 = (int)(1000L * l3 / l1);
        localHashMap.put("maxMemory", String.valueOf(l1));
        localHashMap.put("totalMemory", String.valueOf(l3));
        localHashMap.put("memoryPercent", String.valueOf(i1));
        localHashMap.put("freeMemory", String.valueOf(Runtime.getRuntime().freeMemory() / 1024L));
        localHashMap.put("clearTotalMem", String.valueOf(this.jdField_d_of_type_Long));
        if (paramInt == 2)
        {
          localHashMap.put("memoryPss", String.valueOf(MemoryManager.a(Process.myPid()) / 1024L));
          localObject1 = "memory_info_on_bg_guard";
        }
        for (;;)
        {
          break;
          if (paramInt == 1)
          {
            localHashMap.put("everEnterStory", String.valueOf(this.h));
            localHashMap.put("everEnterAIOCapture", String.valueOf(this.i));
            localHashMap.put("enterStory", String.valueOf(this.j));
            localHashMap.put("enterAIOCapture", String.valueOf(this.k));
            localObject1 = "memory_info_on_low_report";
          }
          else
          {
            localObject1 = null;
          }
        }
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, (String)localObject1, true, 0L, 0L, localHashMap, null);
        localSharedPreferences.edit().putLong((String)localObject2, l2).commit();
      }
    }
    else {
      localSharedPreferences.edit().putLong((String)localObject2, l2).apply();
    }
    if (MobileQQ.sProcessId != 1) {
      return;
    }
    if (paramInt == 1) {
      localObject1 = "lowReportLastTime";
    } else {
      localObject1 = "cacheReportLastTime";
    }
    long l3 = localSharedPreferences.getLong((String)localObject1, 0L);
    l1 = 43200000L;
    if (paramInt == 1) {
      l1 = 14400000L;
    }
    if (l3 > 0L)
    {
      if (Math.abs(l2 - l3) > l1)
      {
        b(paramInt);
        localSharedPreferences.edit().putLong((String)localObject1, l2).commit();
      }
    }
    else {
      localSharedPreferences.edit().putLong((String)localObject1, l2).commit();
    }
  }
  
  public void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo)
  {
    Object localObject = MagnifierSDK.a().a().a;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNeedTrimMemory|clear= ");
      localStringBuilder.append(((ClearMemoryConfig)localObject).jdField_a_of_type_Boolean);
      localStringBuilder.append("configId");
      localStringBuilder.append(((ClearMemoryConfig)localObject).jdField_a_of_type_JavaLangString);
      QLog.d("MemoryClearManager", 2, localStringBuilder.toString());
    }
    if ((a(paramMemoryLevelInfo.jdField_b_of_type_Int * ((ClearMemoryConfig)localObject).jdField_b_of_type_Int * 1000)) && (((ClearMemoryConfig)localObject).jdField_a_of_type_Boolean)) {
      try
      {
        b(paramInt, paramMemoryLevelInfo);
        return;
      }
      catch (Exception paramMemoryLevelInfo)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("clearMemory Exception= ");
          ((StringBuilder)localObject).append(paramMemoryLevelInfo);
          QLog.d("MemoryClearManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    a(1);
  }
  
  public void a(MemoryClearManager.IClearMemoryListener paramIClearMemoryListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramIClearMemoryListener);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = (int)(Runtime.getRuntime().totalMemory() * 1000L / Runtime.getRuntime().maxMemory());
    Object localObject1;
    Object localObject4;
    if ((i1 > 600) && (i1 - this.n > 250) && (this.jdField_a_of_type_Boolean))
    {
      long l1 = System.currentTimeMillis();
      localObject1 = MobileQQ.getContext();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("CommonMemoryCacheSP_");
      ((StringBuilder)???).append(MobileQQ.sProcessId);
      ??? = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)???).toString(), 0);
      long l2 = ((SharedPreferences)???).getLong("memory_increase_report_time", 0L);
      if (l2 > 0L)
      {
        if (Math.abs(l1 - l2) >= 3600000L)
        {
          localObject4 = new HashMap();
          ((HashMap)localObject4).put("lastPer", String.valueOf(this.n));
          ((HashMap)localObject4).put("curPer", String.valueOf(i1));
          ((HashMap)localObject4).put("memInfo", a());
          ((HashMap)localObject4).put("topActivity", ((IPerfApi)QRoute.api(IPerfApi.class)).getTopActivityName());
          ((HashMap)localObject4).put("totalMemory", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
          ((HashMap)localObject4).put("MaxMemory", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          if (paramBoolean) {
            localObject1 = "1";
          } else {
            localObject1 = "0";
          }
          ((HashMap)localObject4).put("isForeground", localObject1);
          ((HashMap)localObject4).put("sProcessId", String.valueOf(MobileQQ.sProcessId));
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "MemoryIncreaseInfo", true, 0L, 0L, (HashMap)localObject4, "", true);
          ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
        }
      }
      else {
        ((SharedPreferences)???).edit().putLong("memory_increase_report_time", l1);
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() >= 16)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.poll();
          break label437;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(i1);
          ((StringBuilder)localObject4).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject4).toString();
          this.jdField_a_of_type_JavaUtilLinkedList.offer(localObject1);
          this.n = i1;
          return;
        }
      }
      label437:
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      }
    }
  }
  
  public void addConCurrentHashMap(QQConcurrentHashMap paramQQConcurrentHashMap)
  {
    if (paramQQConcurrentHashMap != null) {
      this.jdField_b_of_type_JavaUtilList.add(new WeakReference(paramQQConcurrentHashMap));
    }
  }
  
  public void addHashMap(QQHashMap paramQQHashMap)
  {
    if (paramQQHashMap != null) {
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramQQHashMap));
    }
  }
  
  public void addLruCache(LruCache paramLruCache)
  {
    if (paramLruCache != null) {
      this.jdField_d_of_type_JavaUtilList.add(new WeakReference(paramLruCache));
    }
  }
  
  public void addQQLruCache(QQLruCache paramQQLruCache)
  {
    if (paramQQLruCache != null) {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(paramQQLruCache));
    }
  }
  
  public void b()
  {
    try
    {
      Object localObject = MobileQQ.getContext().getSharedPreferences("mem_cache_oom", 0);
      if (((SharedPreferences)localObject).contains("trim_count")) {
        ((SharedPreferences)localObject).edit().clear().commit();
      }
      localObject = MobileQQ.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mem_cache_oom_");
      localStringBuilder.append(MobileQQ.sProcessId);
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("trim_count", this.jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("img_size", GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.size() / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_init_maxsize", GlobalImageCache.jdField_a_of_type_Int / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_cur_maxsize", GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.maxSize() / 1024);
      ((SharedPreferences.Editor)localObject).putInt("img_hashmap_size", a());
      ((SharedPreferences.Editor)localObject).putInt("clear_type", this.jdField_c_of_type_Int);
      ((SharedPreferences.Editor)localObject).putLong("clear_size", this.jdField_c_of_type_Long);
      ((SharedPreferences.Editor)localObject).putLong("clear_total_size", this.jdField_d_of_type_Long);
      ((SharedPreferences.Editor)localObject).putString("total_memory_info", a());
      ((SharedPreferences.Editor)localObject).putLong("total_size", Runtime.getRuntime().totalMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("free_size", Runtime.getRuntime().freeMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("heap_size", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("heap_org_max", HackVmImpl.jdField_a_of_type_Long / 1024L);
      ((SharedPreferences.Editor)localObject).putLong("max_heap", Runtime.getRuntime().maxMemory() / 1024L);
      ((SharedPreferences.Editor)localObject).putString("topActivity", ((IPerfApi)QRoute.api(IPerfApi.class)).getTopActivityName());
      ((SharedPreferences.Editor)localObject).putString("key_mem_info", SceneTracker.a().a());
      ((SharedPreferences.Editor)localObject).putInt("hackArtResult", HackVmImpl.jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject).putString("clear_config_id", MagnifierSDK.a().a().a.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("clear_config_enable", MagnifierSDK.a().a().a.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putInt("enter_aio_capture", this.k);
      ((SharedPreferences.Editor)localObject).putInt("enter_story_capture", this.j);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MemoryClearManager", 2, "clearMemory start");
        }
        l4 = System.currentTimeMillis();
        i6 = 0;
        if (paramInt != 1) {
          if (paramInt != 2) {
            continue;
          }
        }
      }
      finally
      {
        long l4;
        Object localObject2;
        int i9;
        long l6;
        continue;
        throw paramMemoryLevelInfo;
        continue;
        long l1 = 0L;
        long l2 = l1;
        int i3 = 0;
        continue;
        i1 += i2;
        continue;
        int i4 = 0;
        long l5 = i4;
        l2 = l2 + l6 + l5;
        l1 = l1 + l3 + l5;
        if ((paramInt == 1) || (paramInt == 2)) {
          continue;
        }
        int i5 = 0;
        continue;
        l2 += i1;
        i5 = i1;
        if ((paramInt == 1) || (paramInt == 2)) {
          continue;
        }
        int i1 = i6;
        continue;
        continue;
        l2 += i1;
        continue;
        continue;
        l2 += i2;
        int i6 = i2;
        int i7 = i1;
        continue;
        i6 = 0;
        i7 = i1;
        continue;
        l1 = l2 + i1;
        int i8 = i1;
        continue;
        i8 = 0;
        long l3 = l1;
        l1 = l2;
        if (paramInt == 1) {
          continue;
        }
        if (paramInt == 2) {
          continue;
        }
        i1 = 0;
        l2 = 0L;
        continue;
        continue;
        int i2 = 0;
        l2 = 0L;
        i1 = i2;
        l1 += l2;
        continue;
      }
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilVector.iterator();
        i1 = 0;
        if (((Iterator)localObject2).hasNext())
        {
          i1 += ((MemoryClearManager.IClearMemoryListener)((Iterator)localObject2).next()).a();
          continue;
        }
        l1 = i1 + 0L;
        l2 = l1;
        i3 = i1;
        i1 = GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.size();
        i2 = (int)(i1 * paramMemoryLevelInfo.jdField_b_of_type_Float);
        l3 = i1;
        GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.trimToSize(i2);
        if ((paramMemoryLevelInfo.a > 0.0F) && (paramMemoryLevelInfo.a < 1.0F))
        {
          l5 = MemoryManager.a() * 1L / 32L;
          if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.maxSize() >= l5) {
            GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.resetMaxSize(paramMemoryLevelInfo.a);
          }
        }
        i9 = i1 - i2 + 0;
        l6 = i9;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("clearMemory|sImageCache= ");
          ((StringBuilder)???).append(i1);
          QLog.d("MemoryClearManager", 2, ((StringBuilder)???).toString());
        }
        if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          ??? = GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
          i1 = 0;
          if (((Iterator)???).hasNext())
          {
            localObject2 = ((Iterator)???).next();
            if ((localObject2 instanceof Bitmap))
            {
              i2 = Utils.getBitmapSize((Bitmap)localObject2);
            }
            else
            {
              if (!(localObject2 instanceof BitmapDrawable)) {
                continue;
              }
              localObject2 = ((BitmapDrawable)localObject2).getBitmap();
              if (localObject2 == null) {
                continue;
              }
              i2 = Utils.getBitmapSize((Bitmap)localObject2);
            }
          }
          else
          {
            GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            i4 = i1;
            continue;
            ??? = this.jdField_c_of_type_JavaUtilList.iterator();
            i1 = 0;
            if (!((Iterator)???).hasNext()) {
              continue;
            }
            localObject2 = (WeakReference)((Iterator)???).next();
            if (localObject2 == null) {
              continue;
            }
            Object localObject3 = (QQLruCache)((WeakReference)localObject2).get();
            if (localObject3 != null)
            {
              l1 += ((QQLruCache)localObject3).getCacheInfos().mMemorySize;
              ((QQLruCache)localObject3).clearOnLowMemory((int)(((QQLruCache)localObject3).size() * paramMemoryLevelInfo.jdField_b_of_type_Float));
              i1 += ((QQLruCache)localObject3).getCacheInfos().mClearSize;
              continue;
            }
            this.jdField_c_of_type_JavaUtilList.remove(localObject2);
            continue;
            ??? = this.jdField_d_of_type_JavaUtilList;
            i2 = ((List)???).size();
            localObject2 = ((List)???).iterator();
            i1 = 0;
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (WeakReference)((Iterator)localObject2).next();
              if (localObject3 == null) {
                continue;
              }
              LruCache localLruCache = (LruCache)((WeakReference)localObject3).get();
              if (localLruCache != null)
              {
                localLruCache.trimToSize((int)(localLruCache.size() * paramMemoryLevelInfo.jdField_b_of_type_Float));
                i1 += localLruCache.getClearMemory();
                continue;
              }
              ((List)???).remove(localObject3);
              continue;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            paramMemoryLevelInfo = new StringBuilder();
            paramMemoryLevelInfo.append("clearMemory|LruCache List Size = ");
            paramMemoryLevelInfo.append(i2);
            QLog.d("MemoryClearManager", 2, paramMemoryLevelInfo.toString());
            continue;
            if (paramInt != 1) {
              continue;
            }
            paramMemoryLevelInfo = this.jdField_b_of_type_JavaUtilList.iterator();
            i2 = 0;
            if (!paramMemoryLevelInfo.hasNext()) {
              continue;
            }
            ??? = (WeakReference)paramMemoryLevelInfo.next();
            if (??? == null) {
              continue;
            }
            localObject2 = (QQConcurrentHashMap)((WeakReference)???).get();
            if (localObject2 != null)
            {
              l1 += ((QQConcurrentHashMap)localObject2).getReportCacheInfo().mMemorySize;
              ((QQConcurrentHashMap)localObject2).onClearOnLowMemory();
              i2 += ((HashMapInfo)((QQConcurrentHashMap)localObject2).getReportCacheInfo()).mClearSize;
              continue;
            }
            this.jdField_b_of_type_JavaUtilList.remove(???);
            continue;
            if (paramInt != 1) {
              continue;
            }
            paramMemoryLevelInfo = this.jdField_a_of_type_JavaUtilList.iterator();
            i1 = 0;
            l3 = l1;
            if (!paramMemoryLevelInfo.hasNext()) {
              continue;
            }
            ??? = (WeakReference)paramMemoryLevelInfo.next();
            if (??? == null) {
              continue;
            }
            localObject2 = (QQHashMap)((WeakReference)???).get();
            if (localObject2 != null)
            {
              l3 += ((QQHashMap)localObject2).getReportCacheInfo().mMemorySize;
              ((QQHashMap)localObject2).onClearOnLowMemory();
              i1 += ((QQHashMap)localObject2).getReportCacheInfo().mClearSize;
              continue;
            }
            this.jdField_a_of_type_JavaUtilList.remove(???);
            continue;
            paramMemoryLevelInfo = SkinEngine.getInstances().releasePreloadDrawableCache();
            if (paramMemoryLevelInfo.length < 2) {
              continue;
            }
            i1 = 0;
            if ((paramMemoryLevelInfo[0] instanceof Integer)) {
              i1 = Integer.parseInt(paramMemoryLevelInfo[0].toString());
            }
            i2 = i1;
            if (!(paramMemoryLevelInfo[1] instanceof Long)) {
              continue;
            }
            l2 = Long.parseLong(paramMemoryLevelInfo[1].toString());
            continue;
            DexPathListHook.a(MobileQQ.class.getClassLoader());
            this.jdField_c_of_type_Long = (l1 / 1024L);
            l3 /= 1024L;
            this.jdField_d_of_type_Long += l1;
            this.jdField_d_of_type_Int += 1;
            this.jdField_c_of_type_Int = paramInt;
            if (paramInt == 1) {
              this.e += 1;
            } else if (paramInt == 2) {
              this.f += 1;
            } else if (paramInt == 3) {
              this.g += 1;
            }
            this.jdField_b_of_type_Long = System.currentTimeMillis();
            this.jdField_b_of_type_Int = ((int)Runtime.getRuntime().totalMemory() / 1024);
            l5 = System.currentTimeMillis();
            paramMemoryLevelInfo = new StringBuilder(1024);
            paramMemoryLevelInfo.append("totalMemory=");
            paramMemoryLevelInfo.append(l3);
            paramMemoryLevelInfo.append(", clearTotalMem=");
            paramMemoryLevelInfo.append(this.jdField_d_of_type_Long);
            paramMemoryLevelInfo.append(", trimCount=");
            paramMemoryLevelInfo.append(this.jdField_d_of_type_Int);
            paramMemoryLevelInfo.append(", trimCountTop=");
            paramMemoryLevelInfo.append(this.e);
            paramMemoryLevelInfo.append(", trimCountSecond=");
            paramMemoryLevelInfo.append(this.f);
            paramMemoryLevelInfo.append(", trimCountThrid=");
            paramMemoryLevelInfo.append(this.g);
            paramMemoryLevelInfo.append(", cleatType=");
            paramMemoryLevelInfo.append(paramInt);
            paramMemoryLevelInfo.append(", clearMemory=");
            paramMemoryLevelInfo.append(l1);
            paramMemoryLevelInfo.append("\nlistenerClearSize=");
            paramMemoryLevelInfo.append(i3);
            paramMemoryLevelInfo.append(", imageCacheMemory=");
            paramMemoryLevelInfo.append(i9);
            paramMemoryLevelInfo.append(", staticBitmapSize=");
            paramMemoryLevelInfo.append(i4);
            paramMemoryLevelInfo.append(", qqLruCacheMem=");
            paramMemoryLevelInfo.append(i5);
            paramMemoryLevelInfo.append(", lruCacheMem=");
            paramMemoryLevelInfo.append(i7);
            paramMemoryLevelInfo.append(", qqConcurrentMem=");
            paramMemoryLevelInfo.append(i6);
            paramMemoryLevelInfo.append(", qqHashMapMem=");
            paramMemoryLevelInfo.append(i8);
            paramMemoryLevelInfo.append(", skinEngineCount=");
            paramMemoryLevelInfo.append(i1);
            paramMemoryLevelInfo.append(", skinEngineSize=");
            paramMemoryLevelInfo.append(l2);
            paramMemoryLevelInfo.append(", cost=");
            paramMemoryLevelInfo.append(String.valueOf(l5 - l4));
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("ClearMemory|result= \n");
              ((StringBuilder)???).append(paramMemoryLevelInfo.toString());
              QLog.d("MemoryClearManager", 2, ((StringBuilder)???).toString());
            }
            return;
          }
        }
      }
    }
  }
  
  public void b(MemoryClearManager.IClearMemoryListener paramIClearMemoryListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(paramIClearMemoryListener);
      return;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = ((int)Runtime.getRuntime().totalMemory() / 1024);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d()
  {
    Object localObject1 = MobileQQ.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mem_cache_oom_");
    ((StringBuilder)localObject2).append(MobileQQ.sProcessId);
    localObject2 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    if (((SharedPreferences)localObject2).contains("trim_count"))
    {
      HashMap localHashMap = new HashMap(23);
      localHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("hackArtResult", String.valueOf(((SharedPreferences)localObject2).getInt("hackArtResult", 0)));
      localHashMap.put("trim_count", String.valueOf(((SharedPreferences)localObject2).getInt("trim_count", -1)));
      localHashMap.put("img_size", String.valueOf(((SharedPreferences)localObject2).getInt("img_size", -1)));
      localHashMap.put("img_init_maxsize", String.valueOf(((SharedPreferences)localObject2).getInt("img_init_maxsize", -1)));
      localHashMap.put("img_cur_maxsize", String.valueOf(((SharedPreferences)localObject2).getInt("img_cur_maxsize", -1)));
      localHashMap.put("img_hashmap_size", String.valueOf(((SharedPreferences)localObject2).getInt("img_hashmap_size", -1)));
      localHashMap.put("clear_type", String.valueOf(((SharedPreferences)localObject2).getInt("clear_type", -1)));
      localHashMap.put("clear_size", String.valueOf(((SharedPreferences)localObject2).getLong("clear_size", -1L)));
      localHashMap.put("clear_total_size", String.valueOf(((SharedPreferences)localObject2).getLong("clear_total_size", -1L)));
      localHashMap.put("total_memory_info", ((SharedPreferences)localObject2).getString("total_memory_info", "-1"));
      localHashMap.put("max_heap", String.valueOf(((SharedPreferences)localObject2).getLong("max_heap", -1L)));
      localHashMap.put("total_size", String.valueOf(((SharedPreferences)localObject2).getLong("total_size", -1L)));
      localHashMap.put("heap_size", String.valueOf(((SharedPreferences)localObject2).getLong("heap_size", -1L)));
      localHashMap.put("free_size", String.valueOf(((SharedPreferences)localObject2).getLong("free_size", -1L)));
      localHashMap.put("heap_org_max", String.valueOf(((SharedPreferences)localObject2).getLong("heap_org_max", -1L)));
      localHashMap.put("topActivity", ((SharedPreferences)localObject2).getString("topActivity", "NULL"));
      localHashMap.put("key_mem_info", ((SharedPreferences)localObject2).getString("key_mem_info", "NULL"));
      localHashMap.put("clear_config_id", ((SharedPreferences)localObject2).getString("clear_config_id", "0"));
      if (((SharedPreferences)localObject2).getBoolean("clear_config_enable", false)) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localHashMap.put("clear_config_enable", localObject1);
      localHashMap.put("enter_aio_capture", String.valueOf(((SharedPreferences)localObject2).getInt("enter_aio_capture", 0)));
      localHashMap.put("enter_story_capture", String.valueOf(((SharedPreferences)localObject2).getInt("enter_story_capture", 0)));
      localHashMap.put("sProcessId", String.valueOf(MobileQQ.sProcessId));
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "memory_oom_Info", true, 0L, 0L, localHashMap, null);
      ((SharedPreferences)localObject2).edit().remove("trim_count").commit();
    }
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MemoryClearManager", 2, "onRunningBackground");
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.MemoryClearManager
 * JD-Core Version:    0.7.0.1
 */