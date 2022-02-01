package com.tencent.mobileqq.intervideo.now.DownloadEngine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.impl.NowDownloadTaskInfo;
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
  public static NowDownloadManager a;
  private int jdField_a_of_type_Int = 0;
  private Downloader jdField_a_of_type_ComTencentHlyybDownloaderDownloader;
  private DownloadTaskListenerBridge jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge;
  private IHellyEventListener jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineIHellyEventListener = new NowDownloadManager.1(this);
  private HashMap<String, IDownloadListener> jdField_a_of_type_JavaUtilHashMap;
  Map<String, NowDownloadTaskInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager = new NowDownloadManager();
  }
  
  private DownloaderTask a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.getAllTasks();
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
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setProgressInterval(1000);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.enableUserAction(true);
    QQBeaconReport.a();
  }
  
  private void b(String paramString)
  {
    try
    {
      QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask taskUrl=%s", new Object[] { paramString }));
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        paramString = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          NowDownloadTaskInfo localNowDownloadTaskInfo = (NowDownloadTaskInfo)((Map.Entry)paramString.next()).getValue();
          if (localNowDownloadTaskInfo != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localNowDownloadTaskInfo.b }));
            b(localNowDownloadTaskInfo);
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
  
  private void c(NowDownloadTaskInfo paramNowDownloadTaskInfo)
  {
    DownloaderTask localDownloaderTask = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.createNewTask(paramNowDownloadTaskInfo.b, paramNowDownloadTaskInfo.g, paramNowDownloadTaskInfo.h, this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(paramNowDownloadTaskInfo.d);
    if (!TextUtils.isEmpty(paramNowDownloadTaskInfo.e)) {
      localDownloaderTask.setApkId(paramNowDownloadTaskInfo.e);
    }
    localDownloaderTask.setNotUseTempFile();
    paramNowDownloadTaskInfo.a(localDownloaderTask);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge;
    if (localObject != null)
    {
      ((DownloadTaskListenerBridge)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    HalleyAgent.init(paramContext, "1", "now_for_qq");
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader = HalleyAgent.getDownloader();
    b(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge = new DownloadTaskListenerBridge(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineIHellyEventListener);
  }
  
  public void a(NowDownloadTaskInfo paramNowDownloadTaskInfo)
  {
    try
    {
      QLog.d("DownloadManager_Now_for_qq", 1, String.format("addNowDownloadTask taskUrl=%s waitListSize=%s", new Object[] { paramNowDownloadTaskInfo.b, Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramNowDownloadTaskInfo.b, paramNowDownloadTaskInfo);
        b(paramNowDownloadTaskInfo);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramNowDownloadTaskInfo.b, paramNowDownloadTaskInfo);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, IDownloadListener paramIDownloadListener)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramIDownloadListener);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.getAllTasks();
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
          this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.deleteTask((DownloaderTask)localObject, paramBoolean);
        }
      }
    }
  }
  
  public void b(NowDownloadTaskInfo paramNowDownloadTaskInfo)
  {
    Object localObject = a(paramNowDownloadTaskInfo.b);
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
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
          ((IDownloadListener)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a(-1000, -1, "url is invalid");
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
            if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
              ((IDownloadListener)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
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
        ((StringBuilder)localObject).append(paramNowDownloadTaskInfo.h);
        QLog.i("DownloadManager_Now_for_qq", 4, ((StringBuilder)localObject).toString());
        c(paramNowDownloadTaskInfo);
        this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(paramNowDownloadTaskInfo.a());
        QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", localException);
      int i = this.jdField_a_of_type_Int;
      if (i < 3)
      {
        this.jdField_a_of_type_Int = (i + 1);
        b(paramNowDownloadTaskInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadManager
 * JD-Core Version:    0.7.0.1
 */