package com.tencent.mobileqq.studyroom.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NowDownloadManager
{
  public static NowDownloadManager b = new NowDownloadManager();
  Map<String, NowDownloadTaskInfo> a = new HashMap();
  private Downloader c;
  private DownloadTaskListenerBridge d;
  private HashMap<String, IDownloadListener> e;
  private boolean f = false;
  private int g = 0;
  private IHellyEventListener h = new NowDownloadManager.1(this);
  
  private void a(String paramString)
  {
    try
    {
      QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask taskUrl=%s", new Object[] { paramString }));
      this.a.remove(paramString);
      if (this.a.size() > 0)
      {
        paramString = this.a.entrySet().iterator();
        while (paramString.hasNext())
        {
          NowDownloadTaskInfo localNowDownloadTaskInfo = (NowDownloadTaskInfo)((Map.Entry)paramString.next()).getValue();
          if (localNowDownloadTaskInfo != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localNowDownloadTaskInfo.b }));
            a(localNowDownloadTaskInfo);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private DownloaderTask b(String paramString)
  {
    Object localObject = this.c.getAllTasks();
    if (!TextUtils.isEmpty(paramString))
    {
      if (localObject == null) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DownloaderTask localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
        if (localDownloaderTask.getUrl().equals(paramString))
        {
          QLog.i("DownloadManager_Now_for_qq", 4, "isHalleyTaskAlreadyExist:YES");
          return localDownloaderTask;
        }
      }
    }
    return null;
  }
  
  private void b(Context paramContext)
  {
    this.c.setProgressInterval(1000);
    this.c.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
    this.c.enableUserAction(true);
    QQBeaconReport.a();
  }
  
  private void b(NowDownloadTaskInfo paramNowDownloadTaskInfo)
  {
    DownloaderTask localDownloaderTask = this.c.createNewTask(paramNowDownloadTaskInfo.b, paramNowDownloadTaskInfo.h, paramNowDownloadTaskInfo.i, this.d);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(paramNowDownloadTaskInfo.d);
    if (!TextUtils.isEmpty(paramNowDownloadTaskInfo.e)) {
      localDownloaderTask.setApkId(paramNowDownloadTaskInfo.e);
    }
    localDownloaderTask.setNotUseTempFile();
    paramNowDownloadTaskInfo.a(localDownloaderTask);
  }
  
  public void a(Context paramContext)
  {
    if (this.f) {
      return;
    }
    this.f = true;
    this.g = 0;
    this.e = new HashMap();
    HalleyAgent.init(paramContext, "1", "now_for_qq");
    this.c = HalleyAgent.getDownloader();
    b(paramContext);
    this.d = new DownloadTaskListenerBridge(this.h);
  }
  
  public void a(NowDownloadTaskInfo paramNowDownloadTaskInfo)
  {
    if (this.c == null) {
      return;
    }
    Object localObject = b(paramNowDownloadTaskInfo.b);
    try
    {
      String str = paramNowDownloadTaskInfo.b;
      if (TextUtils.isEmpty(str))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startDownload, wurl:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("wrong status or parammter");
        QLog.i("DownloadManager_Now_for_qq", 4, ((StringBuilder)localObject).toString());
        if ((this.e != null) && (this.e.containsKey(str))) {
          ((IDownloadListener)this.e.get(str)).a(-1000, -1, "url is invalid");
        }
      }
      else
      {
        if ((localObject != null) && (str.equals(((DownloaderTask)localObject).getUrl())))
        {
          paramNowDownloadTaskInfo.a((DownloaderTask)localObject);
          DownloaderTaskStatus localDownloaderTaskStatus = ((DownloaderTask)localObject).getStatus();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDownload----hstatus:");
          localStringBuilder.append(localDownloaderTaskStatus);
          QLog.i("DownloadManager_Now_for_qq", 4, localStringBuilder.toString());
          if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
          {
            if ((this.e != null) && (this.e.containsKey(str))) {
              ((IDownloadListener)this.e.get(str)).a();
            }
            a(((DownloaderTask)localObject).getUrl(), false);
            return;
          }
          if (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING)
          {
            QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----Task is already Downloading!");
            return;
          }
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----resume halley task");
          ((DownloaderTask)localObject).resume();
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startDownload: url is changed, thread = ");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("path = ");
        ((StringBuilder)localObject).append(paramNowDownloadTaskInfo.i);
        QLog.i("DownloadManager_Now_for_qq", 4, ((StringBuilder)localObject).toString());
        b(paramNowDownloadTaskInfo);
        this.c.addNewTask(paramNowDownloadTaskInfo.a());
        QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", localException);
      int i = this.g;
      if (i < 3)
      {
        this.g = (i + 1);
        a(paramNowDownloadTaskInfo);
      }
      return;
    }
  }
  
  public void a(String paramString, IDownloadListener paramIDownloadListener)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    this.e.put(paramString, paramIDownloadListener);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.c.getAllTasks();
    if (!TextUtils.isEmpty(paramString))
    {
      if (localObject == null) {
        return;
      }
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (DownloaderTask)localIterator.next();
        if (((DownloaderTask)localObject).getUrl().equals(paramString))
        {
          paramString = new StringBuilder();
          paramString.append("removeDownloadTask---delete unactive halley task, Id:");
          paramString.append(((DownloaderTask)localObject).getId());
          QLog.i("DownloadManager_Now_for_qq", 2, paramString.toString());
          this.c.deleteTask((DownloaderTask)localObject, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.download.NowDownloadManager
 * JD-Core Version:    0.7.0.1
 */