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
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.r;
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
    if (this.c != null) {
      this.c.onMonitorFinish(this.a, new MonitorResult(this.b, paramInt, paramString, paramMonitorType));
    }
  }
  
  private void b()
  {
    ac.c("WashMonitor", "ReplaceMonitorTask >>updateLastModifyTime enter lastModifyTime = " + this.a.lastModifedTime);
    Object localObject;
    if ((this.b == MonitorStep.DOWNLOADING) || (this.b == MonitorStep.BEFORE_INSTALL))
    {
      localObject = new File(this.a.filePath);
      if (((File)localObject).exists()) {
        this.a.lastModifedTime = ((File)localObject).lastModified();
      }
    }
    for (;;)
    {
      com.tencent.replacemonitor.replace.b.a.a().a(this.a);
      ac.c("WashMonitor", "ReplaceMonitorTask >>updateLastModifyTime exit lastModifyTime = " + this.a.lastModifedTime);
      return;
      localObject = r.c(this.a.packageName);
      if (localObject != null) {
        this.a.lastModifedTime = ((PackageInfo)localObject).lastUpdateTime;
      }
    }
  }
  
  private void c()
  {
    ac.c("WashMonitor", "ReplaceMonitorTask >>updateAppName enter appName = " + this.a.appName);
    PackageInfo localPackageInfo2 = r.c(this.a.packageName);
    PackageInfo localPackageInfo1 = localPackageInfo2;
    if (localPackageInfo2 == null) {
      localPackageInfo1 = r.b(this.a.filePath);
    }
    if (localPackageInfo1 != null)
    {
      localPackageInfo1.applicationInfo.sourceDir = this.a.filePath;
      localPackageInfo1.applicationInfo.publicSourceDir = this.a.filePath;
      this.a.appName = r.a(localPackageInfo1);
      ac.c("WashMonitor", "ReplaceMonitorTask >>updateAppName success appName = " + this.a.appName);
      com.tencent.replacemonitor.replace.b.a.a().a(this.a);
    }
  }
  
  private void d()
  {
    ac.c("WashMonitor", "ReplaceMonitorTask >>updateInstallDir enter installDir = " + this.a.installDir);
    PackageInfo localPackageInfo = r.c(this.a.packageName);
    if ((localPackageInfo != null) && (localPackageInfo.versionCode == this.a.versionCode))
    {
      this.a.installDir = localPackageInfo.applicationInfo.sourceDir;
      ac.c("WashMonitor", "ReplaceMonitorTask >>updateInstallDir success installDir = " + this.a.installDir);
      com.tencent.replacemonitor.replace.b.a.a().a(this.a);
    }
  }
  
  private boolean e()
  {
    int i;
    int j;
    if ((!TextUtils.isEmpty(this.a.packageName)) && (this.a.versionCode > 0))
    {
      i = 1;
      if (TextUtils.isEmpty(this.a.filePath)) {
        break label86;
      }
      j = 1;
      label40:
      if ((this.a.fileSize <= 0L) && (TextUtils.isEmpty(this.a.fileMd5))) {
        break label91;
      }
    }
    label86:
    label91:
    for (int k = 1;; k = 0)
    {
      if ((i == 0) || (j == 0) || (k == 0)) {
        break label96;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label40;
    }
    label96:
    return false;
  }
  
  private boolean f()
  {
    return (Build.VERSION.SDK_INT < 23) || (GlobalUtil.getInstance().getContext().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0);
  }
  
  public void a()
  {
    this.d = new ArrayList();
    this.d.add(new d());
    this.d.add(new j());
    this.d.add(new h());
    if ((com.tencent.replacemonitor.a.a > 0L) && (this.a.fileSize < com.tencent.replacemonitor.a.a)) {}
    for (int i = 1;; i = 0)
    {
      if ((this.a.appType == 1) || (i != 0)) {
        this.d.add(new f());
      }
      if (this.a.appType == 2) {
        this.d.add(new com.tencent.replacemonitor.replace.a.a());
      }
      if (this.a.appType == 3) {
        this.d.add(new b());
      }
      return;
    }
  }
  
  public void run()
  {
    if (!e())
    {
      if (!TextUtils.isEmpty(this.a.filePath)) {
        b();
      }
      a(3, "普通检测未通过" + toString(), MonitorType.BY_COMMON);
    }
    for (;;)
    {
      return;
      if (!f())
      {
        a(4, "没有SD卡读权限", MonitorType.BY_COMMON);
        return;
      }
      d();
      c();
      Iterator localIterator = this.d.iterator();
      label91:
      if (localIterator.hasNext())
      {
        Object localObject1 = (i)localIterator.next();
        try
        {
          localObject1 = ((i)localObject1).a(this.a, this.b);
          if ((localObject1 == null) || (((MonitorResult)localObject1).resultCode != 1)) {
            break label91;
          }
          if (this.c != null)
          {
            this.c.onMonitorFinish(this.a, (MonitorResult)localObject1);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject2 = null;
          }
        }
      }
    }
    b();
    a(0, this.b + "检测通过", MonitorType.BY_COMMON);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.c
 * JD-Core Version:    0.7.0.1
 */