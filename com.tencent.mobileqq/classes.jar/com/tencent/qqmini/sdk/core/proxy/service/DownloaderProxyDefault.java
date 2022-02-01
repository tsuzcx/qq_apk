package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ProxyService(proxy=DownloaderProxy.class)
public class DownloaderProxyDefault
  extends DownloaderProxy
{
  public static final int ERR_ABORTED = -3;
  public static final int ERR_INVALID_URL = -1;
  public static final int ERR_IO_ISSUES = -2;
  public static final int ERR_UNKOWN = -100;
  public static final int ERR_UNREASONABLE_REDIRECT_COUNT = -4;
  private static final String TAG = "DefaultDownloader";
  private static AtomicInteger uniqueTaskID = new AtomicInteger(1);
  public ConcurrentHashMap<Integer, DownloaderProxyDefault.DownloadTask> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    Object localObject = null;
    Iterator localIterator = this.taskMap.values().iterator();
    if (localIterator.hasNext())
    {
      DownloaderProxyDefault.DownloadTask localDownloadTask = (DownloaderProxyDefault.DownloadTask)localIterator.next();
      if (!localDownloadTask.mUrl.equals(paramString)) {
        break label78;
      }
      localObject = localDownloadTask;
    }
    label78:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        localObject.mAbort = true;
        this.taskMap.remove(Integer.valueOf(localObject.mTaskId));
      }
      return;
    }
  }
  
  public boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    paramString1 = new DownloaderProxyDefault.DownloadTask(this, uniqueTaskID.getAndIncrement(), paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
    this.taskMap.put(Integer.valueOf(paramString1.mTaskId), paramString1);
    ThreadManager.executeOnNetworkIOThreadPool(paramString1);
    return true;
  }
  
  public void preConnectDownloadHost() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault
 * JD-Core Version:    0.7.0.1
 */