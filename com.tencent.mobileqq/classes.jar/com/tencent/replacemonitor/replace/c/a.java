package com.tencent.replacemonitor.replace.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Handler;
import com.tencent.replacemonitor.MonitorListener;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.st.ReplaceMonitorLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements MonitorListener
{
  private List<WeakReference<MonitorListener>> a = new CopyOnWriteArrayList();
  private ReferenceQueue<MonitorListener> b = new ReferenceQueue();
  private com.tencent.replacemonitor.replace.a c;
  private Map<Integer, Long> d = new ConcurrentHashMap();
  private com.tencent.replacemonitor.replace.b e = new b(this);
  
  private void a(MonitorTask paramMonitorTask, MonitorResult paramMonitorResult)
  {
    if ((this.a == null) || (this.a.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((MonitorListener)((WeakReference)localIterator.next()).get()).onMonitorFinish(paramMonitorTask, paramMonitorResult);
      }
    }
  }
  
  private void b(MonitorTask paramMonitorTask, MonitorResult paramMonitorResult)
  {
    ReplaceMonitorLog localReplaceMonitorLog = new ReplaceMonitorLog();
    localReplaceMonitorLog.packageName = paramMonitorTask.packageName;
    localReplaceMonitorLog.yybAppId = paramMonitorTask.yybAppId;
    localReplaceMonitorLog.yybApkId = paramMonitorTask.yybApkId;
    localReplaceMonitorLog.additionalId = paramMonitorTask.additionalId;
    localReplaceMonitorLog.channelId = paramMonitorTask.cpChannelId;
    localReplaceMonitorLog.fileSize = paramMonitorTask.fileSize;
    localReplaceMonitorLog.appType = paramMonitorTask.appType;
    localReplaceMonitorLog.replaceInterval = (paramMonitorResult.replaceTime - paramMonitorTask.lastModifedTime);
    localReplaceMonitorLog.traceId = paramMonitorTask.traceId;
    localReplaceMonitorLog.versionCode = paramMonitorTask.versionCode;
    localReplaceMonitorLog.replacePackageName = paramMonitorResult.replacedPkgName;
    localReplaceMonitorLog.replaceVersionCode = paramMonitorResult.replacedVersionCode;
    localReplaceMonitorLog.replaceChannelId = paramMonitorResult.replaceChannelId;
    localReplaceMonitorLog.replaceFileMd5 = paramMonitorResult.replaceFileMD5;
    localReplaceMonitorLog.replaceFileSize = paramMonitorResult.replacedFileSize;
    localReplaceMonitorLog.step = paramMonitorResult.step;
    localReplaceMonitorLog.monitorType = paramMonitorResult.monitorType;
    localReplaceMonitorLog.isTDownloadApp = paramMonitorTask.isTencentDownload;
    localReplaceMonitorLog.externalParams = paramMonitorTask.externalParams;
    localReplaceMonitorLog.doReport();
    ac.c("WashMonitor", "ReplaceMonitorImpl >>onMonitorFinish 检测到洗包，开始上报" + localReplaceMonitorLog.build());
  }
  
  public long a(MonitorTask paramMonitorTask)
  {
    ac.c("WashMonitor", "ReplaceMonitorImpl >>addTask task = " + paramMonitorTask);
    if (paramMonitorTask != null)
    {
      ac.c("WashMonitor", "ReplaceMonitorImpl >>addTask task.packageName = " + paramMonitorTask.packageName + " task.versionCode = " + paramMonitorTask.versionCode + " task.appType = " + paramMonitorTask.appType);
      paramMonitorTask.id = com.tencent.replacemonitor.replace.b.a.a().a(paramMonitorTask);
      int i = this.c.a(paramMonitorTask);
      this.d.put(Integer.valueOf(i), Long.valueOf(paramMonitorTask.id));
      return paramMonitorTask.id;
    }
    return -1L;
  }
  
  public MonitorTask a(long paramLong)
  {
    return com.tencent.replacemonitor.replace.b.a.a().a(paramLong);
  }
  
  public MonitorTask a(String paramString)
  {
    return com.tencent.replacemonitor.replace.b.a.a().a(paramString);
  }
  
  public void a(Context paramContext, Map<String, String> paramMap)
  {
    GlobalUtil.getInstance().setContext(paramContext);
    this.c = new com.tencent.replacemonitor.replace.a(this.e);
    if (paramContext != null)
    {
      com.tencent.replacemonitor.a.a = paramContext.getSharedPreferences("replace_monitor_spf", 0).getLong("md5_check_max_file_size", 209715200L);
      ac.d("WashMonitor", "ReplaceMonitorImpl ReplaceMonitorImpl MD5_CHECK_MAX_FILE_SIZE = " + com.tencent.replacemonitor.a.a);
    }
    for (;;)
    {
      com.tencent.replacemonitor.replace.b.a.a();
      return;
      ac.d("WashMonitor", "ReplaceMonitorImpl ReplaceMonitorImpl context = null");
    }
  }
  
  public void a(MonitorListener paramMonitorListener)
  {
    ac.c("WashMonitor", "ReplaceMonitorImpl >>register listener = " + paramMonitorListener);
    Object localObject;
    for (;;)
    {
      localObject = this.b.poll();
      if (localObject == null) {
        break;
      }
      this.a.remove(localObject);
    }
    if (paramMonitorListener != null)
    {
      localObject = this.a.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)((Iterator)localObject).next();
      } while ((localWeakReference == null) || (localWeakReference.get() != paramMonitorListener));
    }
    return;
    paramMonitorListener = new WeakReference(paramMonitorListener, this.b);
    this.a.add(paramMonitorListener);
  }
  
  public void a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    ac.c("WashMonitor", "ReplaceMonitorImpl >>execSync task = " + paramMonitorTask + " step = " + paramMonitorStep);
    if (paramMonitorTask != null)
    {
      ac.c("WashMonitor", "ReplaceMonitorImpl >>execSync task.packageName = " + paramMonitorTask.packageName + " task.versionCode = " + paramMonitorTask.versionCode + " task.appType = " + paramMonitorTask.appType);
      paramMonitorTask = new com.tencent.replacemonitor.replace.c(paramMonitorTask, paramMonitorStep, this);
      l.a().post(paramMonitorTask);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = r.c(paramString);
    ac.c("WashMonitor", "ReplaceMonitorImpl >>onAppInstalled packageInfo = " + paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
      Object localObject1 = com.tencent.replacemonitor.replace.b.a.a().a(paramString.packageName, paramString.versionCode);
      Object localObject2 = com.tencent.replacemonitor.replace.b.a.a().b(r.a(paramString));
      ac.c("WashMonitor", "ReplaceMonitorImpl >>onAppInstalled tasks = " + e.b((List)localObject1) + " tasksByName = " + e.b((List)localObject2));
      if (!e.a((List)localObject1))
      {
        paramString = ((List)localObject1).iterator();
        while (paramString.hasNext())
        {
          localObject1 = (MonitorTask)paramString.next();
          if (((MonitorTask)localObject1).lastStep == MonitorStep.BEFORE_INSTALL)
          {
            ac.c("WashMonitor", "ReplaceMonitorImpl >>onAppInstalled 执行安装中检测  " + ((MonitorTask)localObject1).appName);
            a((MonitorTask)localObject1, MonitorStep.INSTALLING);
          }
          else if (((MonitorTask)localObject1).lastStep == MonitorStep.INSTALLING)
          {
            ac.c("WashMonitor", "ReplaceMonitorImpl >>onAppInstalled 发现覆盖安装，执行安装后检测  " + ((MonitorTask)localObject1).appName);
            a((MonitorTask)localObject1, MonitorStep.AFTER_INSTALL);
          }
        }
      }
      else if (!e.a((List)localObject2))
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MonitorTask)((Iterator)localObject1).next();
          if ((((MonitorTask)localObject2).packageName.equals(paramString.packageName)) && (((MonitorTask)localObject2).versionCode < paramString.versionCode))
          {
            ac.c("WashMonitor", "ReplaceMonitorImpl >>onAppInstalled " + ((MonitorTask)localObject2).appName + " 发现安装了更高版本，不做洗包判定并删除任务");
            com.tencent.replacemonitor.replace.b.a.a().b((MonitorTask)localObject2);
          }
          else if (((MonitorTask)localObject2).lastStep == MonitorStep.BEFORE_INSTALL)
          {
            ac.c("WashMonitor", "ReplaceMonitorImpl >>onAppInstalled 发现同名应用安装，执行安装中检测  " + ((MonitorTask)localObject2).appName);
            a((MonitorTask)localObject2, MonitorStep.INSTALLING);
          }
          else if ((((MonitorTask)localObject2).lastStep == MonitorStep.INSTALLING) && (!r.a(((MonitorTask)localObject2).packageName)))
          {
            ac.c("WashMonitor", "ReplaceMonitorImpl >>onAppInstalled,发现已安装应用被卸载，但是appName相同包名不同的应用被安装，执行安装后检测  " + ((MonitorTask)localObject2).appName);
            a((MonitorTask)localObject2, MonitorStep.AFTER_INSTALL);
          }
        }
      }
    }
  }
  
  public MonitorResult b(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    return null;
  }
  
  public void b(MonitorTask paramMonitorTask)
  {
    ac.c("WashMonitor", "ReplaceMonitorImpl >>deleteTask task = " + paramMonitorTask);
    if (paramMonitorTask != null) {
      com.tencent.replacemonitor.replace.b.a.a().b(paramMonitorTask);
    }
  }
  
  public void onMonitorFinish(MonitorTask paramMonitorTask, MonitorResult paramMonitorResult)
  {
    if ((paramMonitorTask == null) || (paramMonitorResult == null)) {}
    for (;;)
    {
      try
      {
        ac.c("WashMonitor", "ReplaceMonitorImpl >>onMonitorFinish task == null || result == null");
        return;
      }
      finally {}
      ac.c("WashMonitor", "ReplaceMonitorImpl >>onMonitorFinish " + paramMonitorTask.appName + paramMonitorResult.step + " 检测结果为" + paramMonitorResult.resultCode);
      if (paramMonitorResult.resultCode == 1) {
        b(paramMonitorTask, paramMonitorResult);
      }
      a(paramMonitorTask, paramMonitorResult);
      if ((paramMonitorResult.resultCode == 1) || (paramMonitorResult.step == MonitorStep.AFTER_INSTALL))
      {
        ac.c("WashMonitor", "ReplaceMonitorImpl >>onMonitorFinish 删除已经检测到洗包或完整执行的任务");
        com.tencent.replacemonitor.replace.b.a.a().b(paramMonitorTask);
        if (paramMonitorResult.step == MonitorStep.INSTALLING) {
          l.a().postDelayed(new c(this, paramMonitorTask), 1800000L);
        }
      }
      else
      {
        ac.c("WashMonitor", "ReplaceMonitorImpl >>onMonitorFinish " + paramMonitorTask.packageName + " " + paramMonitorTask.appName + paramMonitorResult.step + "检测通过，更新MonitorTask.lastStep");
        paramMonitorTask.lastStep = paramMonitorResult.step;
        com.tencent.replacemonitor.replace.b.a.a().a(paramMonitorTask);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.c.a
 * JD-Core Version:    0.7.0.1
 */