package com.tencent.replacemonitor.replace;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.replacemonitor.MonitorListener;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.replacemonitor.replace.a.b;
import com.tencent.replacemonitor.replace.a.d;
import com.tencent.replacemonitor.replace.a.f;
import com.tencent.replacemonitor.replace.a.h;
import com.tencent.replacemonitor.replace.a.i;
import com.tencent.replacemonitor.replace.a.j;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements Runnable
{
  public MonitorTask a;
  private MonitorStep b;
  private MonitorListener c;
  private List<i> d;
  
  public c(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep, MonitorListener paramMonitorListener)
  {
    this.b = paramMonitorStep;
    this.c = paramMonitorListener;
    this.a = paramMonitorTask;
    a();
  }
  
  private void a(int paramInt, String paramString, MonitorType paramMonitorType)
  {
    MonitorListener localMonitorListener = this.c;
    if (localMonitorListener != null) {
      localMonitorListener.onMonitorFinish(this.a, new MonitorResult(this.b, paramInt, paramString, paramMonitorType));
    }
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ReplaceMonitorTask >>updateLastModifyTime enter lastModifyTime = ");
    ((StringBuilder)localObject).append(this.a.lastModifedTime);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    if ((this.b != MonitorStep.DOWNLOADING) && (this.b != MonitorStep.BEFORE_INSTALL))
    {
      localObject = q.c(this.a.packageName);
      if (localObject != null) {
        this.a.lastModifedTime = ((PackageInfo)localObject).lastUpdateTime;
      }
    }
    else
    {
      localObject = new File(this.a.filePath);
      if (((File)localObject).exists()) {
        this.a.lastModifedTime = ((File)localObject).lastModified();
      }
    }
    com.tencent.replacemonitor.replace.b.a.a().a(this.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ReplaceMonitorTask >>updateLastModifyTime exit lastModifyTime = ");
    ((StringBuilder)localObject).append(this.a.lastModifedTime);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
  }
  
  private void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ReplaceMonitorTask >>updateAppName enter appName = ");
    ((StringBuilder)localObject).append(this.a.appName);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    PackageInfo localPackageInfo = q.c(this.a.packageName);
    localObject = localPackageInfo;
    if (localPackageInfo == null) {
      localObject = q.b(this.a.filePath);
    }
    if (localObject != null)
    {
      ((PackageInfo)localObject).applicationInfo.sourceDir = this.a.filePath;
      ((PackageInfo)localObject).applicationInfo.publicSourceDir = this.a.filePath;
      this.a.appName = q.a((PackageInfo)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReplaceMonitorTask >>updateAppName success appName = ");
      ((StringBuilder)localObject).append(this.a.appName);
      ab.c("WashMonitor", ((StringBuilder)localObject).toString());
      com.tencent.replacemonitor.replace.b.a.a().a(this.a);
    }
  }
  
  private void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ReplaceMonitorTask >>updateInstallDir enter installDir = ");
    ((StringBuilder)localObject).append(this.a.installDir);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    localObject = q.c(this.a.packageName);
    if ((localObject != null) && (((PackageInfo)localObject).versionCode == this.a.versionCode))
    {
      this.a.installDir = ((PackageInfo)localObject).applicationInfo.sourceDir;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReplaceMonitorTask >>updateInstallDir success installDir = ");
      ((StringBuilder)localObject).append(this.a.installDir);
      ab.c("WashMonitor", ((StringBuilder)localObject).toString());
      com.tencent.replacemonitor.replace.b.a.a().a(this.a);
    }
  }
  
  private boolean e()
  {
    boolean bool1 = TextUtils.isEmpty(this.a.packageName);
    boolean bool2 = false;
    int i;
    if ((!bool1) && (this.a.versionCode > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool3 = TextUtils.isEmpty(this.a.filePath);
    int j;
    if ((this.a.fileSize <= 0L) && (TextUtils.isEmpty(this.a.fileMd5))) {
      j = 0;
    } else {
      j = 1;
    }
    bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if ((bool3 ^ true))
      {
        bool1 = bool2;
        if (j != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean f()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 23)
    {
      if (GlobalUtil.getInstance().getContext().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void a()
  {
    this.d = new ArrayList();
    this.d.add(new d());
    this.d.add(new j());
    this.d.add(new h());
    int i;
    if ((com.tencent.replacemonitor.a.a > 0L) && (this.a.fileSize < com.tencent.replacemonitor.a.a)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.a.appType == 1) || (i != 0)) {
      this.d.add(new f());
    }
    if (this.a.appType == 2) {
      this.d.add(new com.tencent.replacemonitor.replace.a.a());
    }
    if (this.a.appType == 3) {
      this.d.add(new b());
    }
  }
  
  public void run()
  {
    if (!e())
    {
      if (!TextUtils.isEmpty(this.a.filePath)) {
        b();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("普通检测未通过");
      ((StringBuilder)localObject1).append(toString());
      a(3, ((StringBuilder)localObject1).toString(), MonitorType.BY_COMMON);
      return;
    }
    if (!f())
    {
      a(4, "没有SD卡读权限", MonitorType.BY_COMMON);
      return;
    }
    d();
    c();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (i)localIterator.next();
      localObject1 = null;
      try
      {
        localObject2 = ((i)localObject2).a(this.a, this.b);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if ((localObject1 != null) && (((MonitorResult)localObject1).resultCode == 1))
      {
        MonitorListener localMonitorListener = this.c;
        if (localMonitorListener != null) {
          localMonitorListener.onMonitorFinish(this.a, (MonitorResult)localObject1);
        }
        return;
      }
    }
    b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append("检测通过");
    a(0, ((StringBuilder)localObject1).toString(), MonitorType.BY_COMMON);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.c
 * JD-Core Version:    0.7.0.1
 */