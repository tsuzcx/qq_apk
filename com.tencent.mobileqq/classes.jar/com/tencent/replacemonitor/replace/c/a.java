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
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.d;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.q;
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
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MonitorListener)((WeakReference)((Iterator)localObject).next()).get()).onMonitorFinish(paramMonitorTask, paramMonitorResult);
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
    paramMonitorTask = new StringBuilder();
    paramMonitorTask.append("ReplaceMonitorImpl >>onMonitorFinish 检测到洗包，开始上报");
    paramMonitorTask.append(localReplaceMonitorLog.build());
    ab.c("WashMonitor", paramMonitorTask.toString());
  }
  
  public long a(MonitorTask paramMonitorTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReplaceMonitorImpl >>addTask task = ");
    localStringBuilder.append(paramMonitorTask);
    ab.c("WashMonitor", localStringBuilder.toString());
    if (paramMonitorTask != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReplaceMonitorImpl >>addTask task.packageName = ");
      localStringBuilder.append(paramMonitorTask.packageName);
      localStringBuilder.append(" task.versionCode = ");
      localStringBuilder.append(paramMonitorTask.versionCode);
      localStringBuilder.append(" task.appType = ");
      localStringBuilder.append(paramMonitorTask.appType);
      ab.c("WashMonitor", localStringBuilder.toString());
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
      paramContext = new StringBuilder();
      paramContext.append("ReplaceMonitorImpl ReplaceMonitorImpl MD5_CHECK_MAX_FILE_SIZE = ");
      paramContext.append(com.tencent.replacemonitor.a.a);
      ab.d("WashMonitor", paramContext.toString());
    }
    else
    {
      ab.d("WashMonitor", "ReplaceMonitorImpl ReplaceMonitorImpl context = null");
    }
    com.tencent.replacemonitor.replace.b.a.a();
  }
  
  public void a(MonitorListener paramMonitorListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ReplaceMonitorImpl >>register listener = ");
    ((StringBuilder)localObject).append(paramMonitorListener);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
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
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramMonitorListener)) {
          return;
        }
      }
      paramMonitorListener = new WeakReference(paramMonitorListener, this.b);
      this.a.add(paramMonitorListener);
    }
  }
  
  public void a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReplaceMonitorImpl >>execSync task = ");
    localStringBuilder.append(paramMonitorTask);
    localStringBuilder.append(" step = ");
    localStringBuilder.append(paramMonitorStep);
    ab.c("WashMonitor", localStringBuilder.toString());
    if (paramMonitorTask != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReplaceMonitorImpl >>execSync task.packageName = ");
      localStringBuilder.append(paramMonitorTask.packageName);
      localStringBuilder.append(" task.versionCode = ");
      localStringBuilder.append(paramMonitorTask.versionCode);
      localStringBuilder.append(" task.appType = ");
      localStringBuilder.append(paramMonitorTask.appType);
      ab.c("WashMonitor", localStringBuilder.toString());
      paramMonitorTask = new com.tencent.replacemonitor.replace.c(paramMonitorTask, paramMonitorStep, this);
      k.a().post(paramMonitorTask);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = q.c(paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ReplaceMonitorImpl >>onAppInstalled packageInfo = ");
    ((StringBuilder)localObject1).append(paramString);
    ab.c("WashMonitor", ((StringBuilder)localObject1).toString());
    if (paramString == null) {
      return;
    }
    localObject1 = com.tencent.replacemonitor.replace.b.a.a().a(paramString.packageName, paramString.versionCode);
    Object localObject2 = com.tencent.replacemonitor.replace.b.a.a().b(q.a(paramString));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReplaceMonitorImpl >>onAppInstalled tasks = ");
    localStringBuilder.append(d.b((List)localObject1));
    localStringBuilder.append(" tasksByName = ");
    localStringBuilder.append(d.b((List)localObject2));
    ab.c("WashMonitor", localStringBuilder.toString());
    if (!d.a((List)localObject1))
    {
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (MonitorTask)paramString.next();
        if (((MonitorTask)localObject1).lastStep == MonitorStep.BEFORE_INSTALL)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ReplaceMonitorImpl >>onAppInstalled 执行安装中检测  ");
          ((StringBuilder)localObject2).append(((MonitorTask)localObject1).appName);
          ab.c("WashMonitor", ((StringBuilder)localObject2).toString());
          a((MonitorTask)localObject1, MonitorStep.INSTALLING);
        }
        else if (((MonitorTask)localObject1).lastStep == MonitorStep.INSTALLING)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ReplaceMonitorImpl >>onAppInstalled 发现覆盖安装，执行安装后检测  ");
          ((StringBuilder)localObject2).append(((MonitorTask)localObject1).appName);
          ab.c("WashMonitor", ((StringBuilder)localObject2).toString());
          a((MonitorTask)localObject1, MonitorStep.AFTER_INSTALL);
        }
      }
    }
    if (!d.a((List)localObject2))
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MonitorTask)((Iterator)localObject1).next();
        if ((((MonitorTask)localObject2).packageName.equals(paramString.packageName)) && (((MonitorTask)localObject2).versionCode < paramString.versionCode))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ReplaceMonitorImpl >>onAppInstalled ");
          localStringBuilder.append(((MonitorTask)localObject2).appName);
          localStringBuilder.append(" 发现安装了更高版本，不做洗包判定并删除任务");
          ab.c("WashMonitor", localStringBuilder.toString());
          com.tencent.replacemonitor.replace.b.a.a().b((MonitorTask)localObject2);
        }
        else if (((MonitorTask)localObject2).lastStep == MonitorStep.BEFORE_INSTALL)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ReplaceMonitorImpl >>onAppInstalled 发现同名应用安装，执行安装中检测  ");
          localStringBuilder.append(((MonitorTask)localObject2).appName);
          ab.c("WashMonitor", localStringBuilder.toString());
          a((MonitorTask)localObject2, MonitorStep.INSTALLING);
        }
        else if ((((MonitorTask)localObject2).lastStep == MonitorStep.INSTALLING) && (!q.a(((MonitorTask)localObject2).packageName)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ReplaceMonitorImpl >>onAppInstalled,发现已安装应用被卸载，但是appName相同包名不同的应用被安装，执行安装后检测  ");
          localStringBuilder.append(((MonitorTask)localObject2).appName);
          ab.c("WashMonitor", localStringBuilder.toString());
          a((MonitorTask)localObject2, MonitorStep.AFTER_INSTALL);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReplaceMonitorImpl >>deleteTask task = ");
    localStringBuilder.append(paramMonitorTask);
    ab.c("WashMonitor", localStringBuilder.toString());
    if (paramMonitorTask != null) {
      com.tencent.replacemonitor.replace.b.a.a().b(paramMonitorTask);
    }
  }
  
  public void onMonitorFinish(MonitorTask paramMonitorTask, MonitorResult paramMonitorResult)
  {
    if ((paramMonitorTask != null) && (paramMonitorResult != null)) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReplaceMonitorImpl >>onMonitorFinish ");
      localStringBuilder.append(paramMonitorTask.appName);
      localStringBuilder.append(paramMonitorResult.step);
      localStringBuilder.append(" 检测结果为");
      localStringBuilder.append(paramMonitorResult.resultCode);
      ab.c("WashMonitor", localStringBuilder.toString());
      if (paramMonitorResult.resultCode == 1) {
        b(paramMonitorTask, paramMonitorResult);
      }
      a(paramMonitorTask, paramMonitorResult);
      if ((paramMonitorResult.resultCode != 1) && (paramMonitorResult.step != MonitorStep.AFTER_INSTALL))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ReplaceMonitorImpl >>onMonitorFinish ");
        localStringBuilder.append(paramMonitorTask.packageName);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramMonitorTask.appName);
        localStringBuilder.append(paramMonitorResult.step);
        localStringBuilder.append("检测通过，更新MonitorTask.lastStep");
        ab.c("WashMonitor", localStringBuilder.toString());
        paramMonitorTask.lastStep = paramMonitorResult.step;
        com.tencent.replacemonitor.replace.b.a.a().a(paramMonitorTask);
      }
      else
      {
        ab.c("WashMonitor", "ReplaceMonitorImpl >>onMonitorFinish 删除已经检测到洗包或完整执行的任务");
        com.tencent.replacemonitor.replace.b.a.a().b(paramMonitorTask);
      }
      if (paramMonitorResult.step == MonitorStep.INSTALLING) {
        k.a().postDelayed(new c(this, paramMonitorTask), 1800000L);
      }
      return;
    }
    finally {}
    ab.c("WashMonitor", "ReplaceMonitorImpl >>onMonitorFinish task == null || result == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.c.a
 * JD-Core Version:    0.7.0.1
 */