package com.tencent.open.appcommon.now.download;

import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DownloadCenterImpl$2
  implements DownloadListener
{
  DownloadCenterImpl$2(DownloadCenterImpl paramDownloadCenterImpl) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (((INowUtil)QRoute.api(INowUtil.class)).copyNowApkToCommonDir(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath().equals(paramDownloadInfo.l))
      {
        ((INowUtil)QRoute.api(INowUtil.class)).delete(paramDownloadInfo.l);
        paramDownloadInfo.l = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
      }
      DownloadManager.a().e(paramDownloadInfo);
    }
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl.2
 * JD-Core Version:    0.7.0.1
 */