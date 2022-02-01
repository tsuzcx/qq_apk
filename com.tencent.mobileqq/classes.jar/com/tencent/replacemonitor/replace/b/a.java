package com.tencent.replacemonitor.replace.b;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.d;
import com.tencent.tmassistantbase.util.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static a a;
  private Map<Long, MonitorTask> b = new ConcurrentHashMap();
  private Map<String, MonitorTask> c = new ConcurrentHashMap();
  private b d = new b();
  
  private a()
  {
    Object localObject1 = this.d.a();
    if (!d.a((List)localObject1))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        MonitorTask localMonitorTask = (MonitorTask)((Iterator)localObject1).next();
        if (localMonitorTask.lastStep == MonitorStep.INSTALLING)
        {
          Object localObject2 = q.c(localMonitorTask.packageName);
          if ((localObject2 != null) && (((PackageInfo)localObject2).versionCode == localMonitorTask.versionCode) && (System.currentTimeMillis() - ((PackageInfo)localObject2).lastUpdateTime > 86400000L))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("MonitorTaskCache>>MonitorTaskCache 发现超过24小时脏数据，删除 task.packageName = ");
            ((StringBuilder)localObject2).append(localMonitorTask.packageName);
            ab.c("WashMonitor", ((StringBuilder)localObject2).toString());
            this.d.c(localMonitorTask);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("MonitorTaskCache>>MonitorTaskCache 补充执行一次安装后检测 task.packageName = ");
            ((StringBuilder)localObject2).append(localMonitorTask.packageName);
            ab.c("WashMonitor", ((StringBuilder)localObject2).toString());
            ReplaceMonitor.get().execSync(localMonitorTask, MonitorStep.AFTER_INSTALL);
          }
        }
        else
        {
          this.b.put(Long.valueOf(localMonitorTask.id), localMonitorTask);
          if (!TextUtils.isEmpty(localMonitorTask.additionalId)) {
            this.c.put(localMonitorTask.additionalId, localMonitorTask);
          }
        }
      }
    }
  }
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public long a(MonitorTask paramMonitorTask)
  {
    try
    {
      if (paramMonitorTask.id == 0L)
      {
        paramMonitorTask.id = this.d.a(paramMonitorTask);
        if (paramMonitorTask.id != -1L)
        {
          this.b.put(Long.valueOf(paramMonitorTask.id), paramMonitorTask);
          if (!TextUtils.isEmpty(paramMonitorTask.additionalId)) {
            this.c.put(paramMonitorTask.additionalId, paramMonitorTask);
          }
        }
      }
      else
      {
        this.b.put(Long.valueOf(paramMonitorTask.id), paramMonitorTask);
        this.d.b(paramMonitorTask);
        if (!TextUtils.isEmpty(paramMonitorTask.additionalId)) {
          this.c.put(paramMonitorTask.additionalId, paramMonitorTask);
        }
      }
      long l = paramMonitorTask.id;
      return l;
    }
    finally {}
  }
  
  public MonitorTask a(long paramLong)
  {
    try
    {
      MonitorTask localMonitorTask2 = (MonitorTask)this.b.get(Long.valueOf(paramLong));
      MonitorTask localMonitorTask1 = localMonitorTask2;
      if (localMonitorTask2 == null)
      {
        localMonitorTask2 = this.d.a(paramLong);
        localMonitorTask1 = localMonitorTask2;
        if (localMonitorTask2 != null)
        {
          this.b.put(Long.valueOf(paramLong), localMonitorTask2);
          localMonitorTask1 = localMonitorTask2;
        }
      }
      return localMonitorTask1;
    }
    finally {}
  }
  
  public MonitorTask a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      MonitorTask localMonitorTask2 = (MonitorTask)this.c.get(paramString);
      MonitorTask localMonitorTask1 = localMonitorTask2;
      if (localMonitorTask2 == null)
      {
        localMonitorTask2 = this.d.a(paramString);
        localMonitorTask1 = localMonitorTask2;
        if (localMonitorTask2 != null)
        {
          this.c.put(paramString, localMonitorTask2);
          this.b.put(Long.valueOf(localMonitorTask2.id), localMonitorTask2);
          localMonitorTask1 = localMonitorTask2;
        }
      }
      return localMonitorTask1;
    }
    finally {}
  }
  
  public List<MonitorTask> a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.b.values().iterator();
      MonitorTask localMonitorTask;
      while (((Iterator)localObject).hasNext())
      {
        localMonitorTask = (MonitorTask)((Iterator)localObject).next();
        if ((paramString.equals(localMonitorTask.packageName)) && (paramInt == localMonitorTask.versionCode)) {
          localArrayList.add(localMonitorTask);
        }
      }
      if (d.a(localArrayList))
      {
        localObject = this.c.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localMonitorTask = (MonitorTask)((Iterator)localObject).next();
          if ((paramString.equals(localMonitorTask.packageName)) && (paramInt == localMonitorTask.versionCode)) {
            localArrayList.add(localMonitorTask);
          }
        }
      }
      if (d.a(localArrayList))
      {
        localObject = this.d.a();
        if (localObject != null)
        {
          localObject = ((Collection)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localMonitorTask = (MonitorTask)((Iterator)localObject).next();
            if ((paramString.equals(localMonitorTask.packageName)) && (paramInt == localMonitorTask.versionCode)) {
              localArrayList.add(localMonitorTask);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<MonitorTask> b(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.b.values().iterator();
      MonitorTask localMonitorTask;
      while (((Iterator)localObject).hasNext())
      {
        localMonitorTask = (MonitorTask)((Iterator)localObject).next();
        if (paramString.equals(localMonitorTask.appName)) {
          localArrayList.add(localMonitorTask);
        }
      }
      if (d.a(localArrayList))
      {
        localObject = this.c.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localMonitorTask = (MonitorTask)((Iterator)localObject).next();
          if (paramString.equals(localMonitorTask.appName)) {
            localArrayList.add(localMonitorTask);
          }
        }
      }
      if (d.a(localArrayList))
      {
        localObject = this.d.a();
        if (localObject != null)
        {
          localObject = ((Collection)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localMonitorTask = (MonitorTask)((Iterator)localObject).next();
            if (paramString.equals(localMonitorTask.appName)) {
              localArrayList.add(localMonitorTask);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(MonitorTask paramMonitorTask)
  {
    if (paramMonitorTask == null) {
      return;
    }
    try
    {
      this.b.remove(Long.valueOf(paramMonitorTask.id));
      this.c.remove(paramMonitorTask.additionalId);
      this.d.c(paramMonitorTask);
      return;
    }
    finally
    {
      paramMonitorTask = finally;
      throw paramMonitorTask;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.b.a
 * JD-Core Version:    0.7.0.1
 */