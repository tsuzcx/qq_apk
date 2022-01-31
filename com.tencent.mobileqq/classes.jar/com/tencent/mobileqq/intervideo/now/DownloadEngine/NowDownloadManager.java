package com.tencent.mobileqq.intervideo.now.DownloadEngine;

import adkq;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.open.wadl.WLog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NowDownloadManager
{
  private int jdField_a_of_type_Int;
  private Downloader jdField_a_of_type_ComTencentHlyybDownloaderDownloader;
  private DownloadTaskListenerBridge jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge;
  private IHellyEventListener jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineIHellyEventListener = new adkq(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  private DownloaderTask a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.getAllTasks();
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {
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
    return null;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setProgressInterval(1000);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.enableUserAction(true);
    UserAction.initUserAction(paramContext);
  }
  
  private void b(NowDownloadTaskInfo paramNowDownloadTaskInfo)
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
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge.a();
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineDownloadTaskListenerBridge = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
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
    DownloaderTask localDownloaderTask = a(paramNowDownloadTaskInfo.b);
    try
    {
      str = paramNowDownloadTaskInfo.b;
      if (TextUtils.isEmpty(str))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
          ((IDownloadListener)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a(-1000, -1, "url is invalid");
        }
      }
      else if ((localDownloaderTask == null) || (!str.equals(localDownloaderTask.getUrl())))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, appId:" + paramNowDownloadTaskInfo.a + "," + str);
        if (localDownloaderTask != null) {
          this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.deleteTask(localDownloaderTask, true);
        }
        b(paramNowDownloadTaskInfo);
        this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(paramNowDownloadTaskInfo.a());
        return;
      }
    }
    catch (Exception localException)
    {
      String str;
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", localException);
      if (this.jdField_a_of_type_Int < 3)
      {
        this.jdField_a_of_type_Int += 1;
        a(paramNowDownloadTaskInfo);
        return;
        paramNowDownloadTaskInfo.a(localException);
        DownloaderTaskStatus localDownloaderTaskStatus = localException.getStatus();
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + localDownloaderTaskStatus);
        if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
            ((IDownloadListener)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
          }
          a(localException.getUrl(), false);
          return;
        }
        if (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING)
        {
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----Task is already Downloading!");
          return;
        }
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----resume halley task");
        localException.resume();
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
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
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {}
    DownloaderTask localDownloaderTask;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = ((List)localObject).iterator();
      }
      localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
    } while (!localDownloaderTask.getUrl().equals(paramString));
    WLog.b("DownloadManager_Now_for_qq", "removeDownloadTask---delete unactive halley task, Id:" + localDownloaderTask.getId());
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.deleteTask(localDownloaderTask, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadManager
 * JD-Core Version:    0.7.0.1
 */