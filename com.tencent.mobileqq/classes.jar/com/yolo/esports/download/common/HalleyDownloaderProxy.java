package com.yolo.esports.download.common;

import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskPriority;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.app.ISingletonLifeCycle;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import com.tencent.timi.game.utils.TimeDetector;
import com.yolo.esports.download.cb.InnerDownloadListener;
import com.yolo.esports.download.cb.TaskCallbackCenter;
import com.yolo.esports.download.db.DownloadInfoDaoProxy;
import com.yolo.esports.download.util.DownloadUtils;
import com.yolo.esports.download.util.SpaceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class HalleyDownloaderProxy
  implements ISingletonLifeCycle
{
  private static volatile HalleyDownloaderProxy b;
  Downloader a;
  private DownloadInfoDaoProxy c;
  private DownloadInfoContainer d = new DownloadInfoContainer();
  private InnerDownloadListener e;
  private List<DownloaderTask> f = new ArrayList();
  private INetInfoHandler g = new HalleyDownloaderProxy.1(this);
  
  private DownloaderTaskPriority a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return DownloaderTaskPriority.NORMAL;
        }
        return DownloaderTaskPriority.URGENT;
      }
      return DownloaderTaskPriority.HIGH;
    }
    return DownloaderTaskPriority.LOW;
  }
  
  public static HalleyDownloaderProxy a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new HalleyDownloaderProxy();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void d()
  {
    TimeDetector localTimeDetector = TimeDetector.a().b();
    g();
    localTimeDetector.a("initHalleySDK finish");
    e();
    localTimeDetector.a("initHalleyTasks finish");
    ThreadManagerV2.excute(new HalleyDownloaderProxy.2(this, localTimeDetector), 32, null, true);
  }
  
  private boolean d(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return false;
    }
    if (paramDownloadInfo.q == 4)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">alreadySuccCheck 状态为下载完成");
      localStringBuilder.append(paramDownloadInfo);
      Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
      if (paramDownloadInfo.c()) {
        return true;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">alreadySuccCheck 文件异常删除任务");
      localStringBuilder.append(paramDownloadInfo);
      Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
      a(paramDownloadInfo.a(), false);
      paramDownloadInfo.d();
    }
    return false;
  }
  
  private void e() {}
  
  private void e(DownloadInfo paramDownloadInfo)
  {
    DownloaderTask localDownloaderTask = a(paramDownloadInfo.b);
    if (localDownloaderTask != null)
    {
      Logger.a("HalleyDownloaderProxy_", "deleteTask");
      this.a.deleteTask(localDownloaderTask, true);
    }
    if (localDownloaderTask == null) {}
    try
    {
      paramDownloadInfo = this.a.createNewTask(paramDownloadInfo.b, paramDownloadInfo.d, paramDownloadInfo.c, this.e);
      this.a.deleteTask(paramDownloadInfo, true);
      Logger.a("HalleyDownloaderProxy_", ">deleteTask succ");
      return;
    }
    catch (Throwable paramDownloadInfo)
    {
      label80:
      break label80;
    }
    Logger.c("HalleyDownloaderProxy_", ">deleteTask error");
  }
  
  private void f()
  {
    Object localObject1 = this.c.b();
    if (localObject1 == null) {
      return;
    }
    try
    {
      Collections.sort((List)localObject1);
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        d((DownloadInfo)localObject2);
        if (((DownloadInfo)localObject2).q == 2) {
          ((DownloadInfo)localObject2).q = 3;
        }
        b((DownloadInfo)localObject2);
      }
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initCache error:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Logger.c("HalleyDownloaderProxy_", ((StringBuilder)localObject2).toString());
    }
  }
  
  private void g()
  {
    HalleyAgent.init(BaseApplication.getContext(), "", "");
    this.a = HalleyAgent.getDownloader();
    this.a.setTaskNumForCategory(DownloaderTaskCategory.Cate_DefaultMass, 3);
    this.a.setNotNetworkWaitMillis(5000);
  }
  
  private void h()
  {
    Iterator localIterator = new ArrayList(this.d.a.values()).iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartCurrentTaskOnNetworkBack state=");
      localStringBuilder.append(localDownloadInfo.q);
      localStringBuilder.append(", errorCode = ");
      localStringBuilder.append(localDownloadInfo.l);
      Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
      int i = localDownloadInfo.q;
      int k = 1;
      if (i == 2) {
        i = 1;
      } else {
        i = 0;
      }
      int j = k;
      if (i == 0)
      {
        if (localDownloadInfo.q == 5)
        {
          j = k;
          if (localDownloadInfo.l == -16) {
            break label181;
          }
          j = k;
          if (localDownloadInfo.l == -15) {
            break label181;
          }
          if (localDownloadInfo.l == -77)
          {
            j = k;
            break label181;
          }
        }
        j = 0;
      }
      label181:
      if (j != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("needRestart ");
        localStringBuilder.append(localDownloadInfo);
        Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
        a(localDownloadInfo, false);
      }
    }
  }
  
  public int a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<startDownload> info:");
      ((StringBuilder)localObject1).append(paramDownloadInfo);
      Logger.a("HalleyDownloaderProxy_", ((StringBuilder)localObject1).toString());
      if (d(paramDownloadInfo))
      {
        b(paramDownloadInfo);
        TaskCallbackCenter.a().a(paramDownloadInfo.a(), paramDownloadInfo);
        return -102;
      }
      float f1 = (float)SpaceUtils.b(paramDownloadInfo.d);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[startDownload]rootDir=");
      ((StringBuilder)localObject1).append(paramDownloadInfo.d);
      ((StringBuilder)localObject1).append(",availableSpace=");
      ((StringBuilder)localObject1).append(f1);
      Logger.a("HalleyDownloaderProxy_", ((StringBuilder)localObject1).toString());
      float f2 = (float)paramDownloadInfo.f;
      if (f1 < 0.0F)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[startDownload]ERROR: availableSpace < 0 可能下载失败，忽略本次下载任务，info=");
        ((StringBuilder)localObject1).append(paramDownloadInfo);
        Logger.c("HalleyDownloaderProxy_", ((StringBuilder)localObject1).toString());
      }
      else if (f1 < f2 * 1.5F)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[startDownload]ERROR: availableSpace < minRequestSpace 可能下载失败，忽略本次下载任务，info=");
        ((StringBuilder)localObject1).append(paramDownloadInfo);
        Logger.c("HalleyDownloaderProxy_", ((StringBuilder)localObject1).toString());
      }
      if (TextUtils.isEmpty(paramDownloadInfo.c)) {
        paramDownloadInfo.c = DownloadUtils.a(paramDownloadInfo.b);
      } else {
        paramDownloadInfo.c = DownloadUtils.b(paramDownloadInfo.c);
      }
      if (paramBoolean)
      {
        Logger.a("HalleyDownloaderProxy_", ">startDownload onlyCreateInfo is true");
      }
      else
      {
        localObject1 = a(paramDownloadInfo.b);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[startDownload] getTaskFromHalleySDK ：");
        ((StringBuilder)localObject2).append(localObject1);
        Logger.a("HalleyDownloaderProxy_", ((StringBuilder)localObject2).toString());
        if (localObject1 == null)
        {
          localObject1 = this.a;
          localObject2 = paramDownloadInfo.b;
          Object localObject3 = paramDownloadInfo.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramDownloadInfo.c);
          localStringBuilder.append(".");
          localStringBuilder.append(paramDownloadInfo.x);
          localObject1 = ((Downloader)localObject1).createNewTask((String)localObject2, (String)localObject3, localStringBuilder.toString(), this.e);
          ((DownloaderTask)localObject1).setCategory(DownloaderTaskCategory.Cate_DefaultMass);
          localObject2 = paramDownloadInfo.a();
          ((DownloaderTask)localObject1).setTag(localObject2);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("<startDownload>set tag:");
          ((StringBuilder)localObject3).append((String)localObject2);
          Logger.a("HalleyDownloaderProxy_", ((StringBuilder)localObject3).toString());
          ((DownloaderTask)localObject1).setPauseTaskOnMobile(paramDownloadInfo.p);
          ((DownloaderTask)localObject1).setPriority(a(paramDownloadInfo.n));
          this.a.addNewTask((DownloaderTask)localObject1);
        }
        else
        {
          ((DownloaderTask)localObject1).setPauseTaskOnMobile(paramDownloadInfo.p);
          ((DownloaderTask)localObject1).setPriority(a(paramDownloadInfo.n));
          ((DownloaderTask)localObject1).addListener(this.e);
          ((DownloaderTask)localObject1).resume();
        }
      }
      a(paramDownloadInfo);
      b(paramDownloadInfo);
      return 0;
    }
    catch (Throwable paramDownloadInfo)
    {
      Logger.c("HalleyDownloaderProxy_", paramDownloadInfo.getMessage());
    }
    return -99;
  }
  
  public DownloaderTask a(String paramString)
  {
    this.f = this.a.getAllTasks();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getTaskFromHalleySDK] mAllHalleyTasks = ");
    ((StringBuilder)localObject).append(this.f);
    Logger.a("HalleyDownloaderProxy_", ((StringBuilder)localObject).toString());
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownloaderTask localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
      if (localDownloaderTask.getUrl().equals(paramString)) {
        return localDownloaderTask;
      }
    }
    return null;
  }
  
  public DownloadInfo a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.d.a(paramString);
        if (paramString != null)
        {
          this.c.b(paramString);
          e(paramString);
          if (!TextUtils.isEmpty(paramString.e))
          {
            File localFile = new File(paramString.e);
            if (localFile.exists()) {
              localFile.delete();
            }
          }
          paramString.q = 6;
          paramString.j = 0L;
          paramString.k = 0L;
          if (paramBoolean) {
            TaskCallbackCenter.a().a(paramString.a(), paramString);
          }
        }
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      Logger.a("HalleyDownloaderProxy_", "delete error", paramString);
    }
    return null;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("info=");
    localStringBuilder.append(paramDownloadInfo.hashCode());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramDownloadInfo);
    Logger.b("HalleyDownloaderProxy_", localStringBuilder.toString());
    try
    {
      if (!this.d.a(paramDownloadInfo.a()))
      {
        this.d.a(paramDownloadInfo.a(), paramDownloadInfo);
        return true;
      }
      if (this.d.b(paramDownloadInfo.a()) != paramDownloadInfo) {
        this.d.a(paramDownloadInfo.a(), paramDownloadInfo);
      }
      return false;
    }
    catch (NullPointerException paramDownloadInfo) {}
    return false;
  }
  
  public DownloadInfo b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getDownloadInfo] = ");
    localStringBuilder.append(paramString);
    Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.d.b(paramString);
      d(paramString);
      if ((paramString != null) && (!paramString.e())) {
        a(paramString.a, false);
      }
      return paramString;
    }
    return null;
  }
  
  public void b()
  {
    this.c = DownloadInfoDaoProxy.a();
    this.e = InnerDownloadListener.a();
    d();
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[saveDownloadInfo] = ");
    localStringBuilder.append(paramDownloadInfo);
    Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
    if ((paramDownloadInfo != null) && (!TextUtils.isEmpty(paramDownloadInfo.a())))
    {
      this.d.a(paramDownloadInfo.a(), paramDownloadInfo);
      ThreadPool.c(new HalleyDownloaderProxy.3(this, paramDownloadInfo));
    }
  }
  
  public void c()
  {
    Logger.a("HalleyDownloaderProxy_", "networkConnected ");
    h();
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (!TextUtils.isEmpty(paramDownloadInfo.a()))) {
      this.d.a(paramDownloadInfo.a(), paramDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.common.HalleyDownloaderProxy
 * JD-Core Version:    0.7.0.1
 */