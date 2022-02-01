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
  private static a a = null;
  private Map<Long, MonitorTask> b = new ConcurrentHashMap();
  private Map<String, MonitorTask> c = new ConcurrentHashMap();
  private b d = new b();
  
  private a()
  {
    Object localObject = this.d.a();
    if (!d.a((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MonitorTask localMonitorTask = (MonitorTask)((Iterator)localObject).next();
        if (localMonitorTask.lastStep == MonitorStep.INSTALLING)
        {
          PackageInfo localPackageInfo = q.c(localMonitorTask.packageName);
          if ((localPackageInfo != null) && (localPackageInfo.versionCode == localMonitorTask.versionCode) && (System.currentTimeMillis() - localPackageInfo.lastUpdateTime > 86400000L))
          {
            ab.c("WashMonitor", "MonitorTaskCache>>MonitorTaskCache 发现超过24小时脏数据，删除 task.packageName = " + localMonitorTask.packageName);
            this.d.c(localMonitorTask);
          }
          else
          {
            ab.c("WashMonitor", "MonitorTaskCache>>MonitorTaskCache 补充执行一次安装后检测 task.packageName = " + localMonitorTask.packageName);
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
  
  /* Error */
  public long a(MonitorTask paramMonitorTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 137	com/tencent/replacemonitor/MonitorTask:id	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +78 -> 86
    //   11: aload_1
    //   12: aload_0
    //   13: getfield 33	com/tencent/replacemonitor/replace/b/a:d	Lcom/tencent/replacemonitor/replace/b/b;
    //   16: aload_1
    //   17: invokevirtual 163	com/tencent/replacemonitor/replace/b/b:a	(Lcom/tencent/replacemonitor/MonitorTask;)J
    //   20: putfield 137	com/tencent/replacemonitor/MonitorTask:id	J
    //   23: aload_1
    //   24: getfield 137	com/tencent/replacemonitor/MonitorTask:id	J
    //   27: ldc2_w 164
    //   30: lcmp
    //   31: ifeq +46 -> 77
    //   34: aload_0
    //   35: getfield 26	com/tencent/replacemonitor/replace/b/a:b	Ljava/util/Map;
    //   38: aload_1
    //   39: getfield 137	com/tencent/replacemonitor/MonitorTask:id	J
    //   42: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: aload_1
    //   46: invokeinterface 149 3 0
    //   51: pop
    //   52: aload_1
    //   53: getfield 152	com/tencent/replacemonitor/MonitorTask:additionalId	Ljava/lang/String;
    //   56: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +18 -> 77
    //   62: aload_0
    //   63: getfield 28	com/tencent/replacemonitor/replace/b/a:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 152	com/tencent/replacemonitor/MonitorTask:additionalId	Ljava/lang/String;
    //   70: aload_1
    //   71: invokeinterface 149 3 0
    //   76: pop
    //   77: aload_1
    //   78: getfield 137	com/tencent/replacemonitor/MonitorTask:id	J
    //   81: lstore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: lload_2
    //   85: lreturn
    //   86: aload_0
    //   87: getfield 26	com/tencent/replacemonitor/replace/b/a:b	Ljava/util/Map;
    //   90: aload_1
    //   91: getfield 137	com/tencent/replacemonitor/MonitorTask:id	J
    //   94: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: aload_1
    //   98: invokeinterface 149 3 0
    //   103: pop
    //   104: aload_0
    //   105: getfield 33	com/tencent/replacemonitor/replace/b/a:d	Lcom/tencent/replacemonitor/replace/b/b;
    //   108: aload_1
    //   109: invokevirtual 168	com/tencent/replacemonitor/replace/b/b:b	(Lcom/tencent/replacemonitor/MonitorTask;)Z
    //   112: pop
    //   113: aload_1
    //   114: getfield 152	com/tencent/replacemonitor/MonitorTask:additionalId	Ljava/lang/String;
    //   117: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne -43 -> 77
    //   123: aload_0
    //   124: getfield 28	com/tencent/replacemonitor/replace/b/a:c	Ljava/util/Map;
    //   127: aload_1
    //   128: getfield 152	com/tencent/replacemonitor/MonitorTask:additionalId	Ljava/lang/String;
    //   131: aload_1
    //   132: invokeinterface 149 3 0
    //   137: pop
    //   138: goto -61 -> 77
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	a
    //   0	146	1	paramMonitorTask	MonitorTask
    //   81	4	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	77	141	finally
    //   77	82	141	finally
    //   86	138	141	finally
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
  
  /* Error */
  public MonitorTask a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_3
    //   16: areturn
    //   17: aload_0
    //   18: getfield 28	com/tencent/replacemonitor/replace/b/a:c	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 172 2 0
    //   27: checkcast 59	com/tencent/replacemonitor/MonitorTask
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 4
    //   37: ifnonnull -24 -> 13
    //   40: aload_0
    //   41: getfield 33	com/tencent/replacemonitor/replace/b/a:d	Lcom/tencent/replacemonitor/replace/b/b;
    //   44: aload_1
    //   45: invokevirtual 177	com/tencent/replacemonitor/replace/b/b:a	(Ljava/lang/String;)Lcom/tencent/replacemonitor/MonitorTask;
    //   48: astore 4
    //   50: aload 4
    //   52: astore_3
    //   53: aload 4
    //   55: ifnull -42 -> 13
    //   58: aload_0
    //   59: getfield 28	com/tencent/replacemonitor/replace/b/a:c	Ljava/util/Map;
    //   62: aload_1
    //   63: aload 4
    //   65: invokeinterface 149 3 0
    //   70: pop
    //   71: aload_0
    //   72: getfield 26	com/tencent/replacemonitor/replace/b/a:b	Ljava/util/Map;
    //   75: aload 4
    //   77: getfield 137	com/tencent/replacemonitor/MonitorTask:id	J
    //   80: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   83: aload 4
    //   85: invokeinterface 149 3 0
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: goto -81 -> 13
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	a
    //   0	102	1	paramString	String
    //   6	2	2	bool	boolean
    //   12	82	3	localObject	Object
    //   30	62	4	localMonitorTask	MonitorTask
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   17	32	97	finally
    //   40	50	97	finally
    //   58	91	97	finally
  }
  
  public List<MonitorTask> a(String paramString, int paramInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      MonitorTask localMonitorTask;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
        {
          paramString = null;
          return paramString;
        }
        localArrayList = new ArrayList();
        localObject = this.b.values().iterator();
        if (((Iterator)localObject).hasNext())
        {
          localMonitorTask = (MonitorTask)((Iterator)localObject).next();
          if ((!paramString.equals(localMonitorTask.packageName)) || (paramInt != localMonitorTask.versionCode)) {
            continue;
          }
          localArrayList.add(localMonitorTask);
          continue;
        }
        if (!d.a(localArrayList)) {
          break label183;
        }
      }
      finally {}
      Object localObject = this.c.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMonitorTask = (MonitorTask)((Iterator)localObject).next();
        if ((paramString.equals(localMonitorTask.packageName)) && (paramInt == localMonitorTask.versionCode)) {
          localArrayList.add(localMonitorTask);
        }
      }
      label183:
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
      paramString = localArrayList;
    }
  }
  
  public List<MonitorTask> b(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      MonitorTask localMonitorTask;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
        {
          paramString = null;
          return paramString;
        }
        localArrayList = new ArrayList();
        localObject = this.b.values().iterator();
        if (((Iterator)localObject).hasNext())
        {
          localMonitorTask = (MonitorTask)((Iterator)localObject).next();
          if (!paramString.equals(localMonitorTask.appName)) {
            continue;
          }
          localArrayList.add(localMonitorTask);
          continue;
        }
        if (!d.a(localArrayList)) {
          break label161;
        }
      }
      finally {}
      Object localObject = this.c.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMonitorTask = (MonitorTask)((Iterator)localObject).next();
        if (paramString.equals(localMonitorTask.appName)) {
          localArrayList.add(localMonitorTask);
        }
      }
      label161:
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
      paramString = localArrayList;
    }
  }
  
  public void b(MonitorTask paramMonitorTask)
  {
    if (paramMonitorTask == null) {}
    for (;;)
    {
      return;
      try
      {
        this.b.remove(Long.valueOf(paramMonitorTask.id));
        this.c.remove(paramMonitorTask.additionalId);
        this.d.c(paramMonitorTask);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.b.a
 * JD-Core Version:    0.7.0.1
 */