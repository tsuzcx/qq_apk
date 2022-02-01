package com.tencent.open.appcommon.now.download;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DownloadCenterImpl$3
  implements Runnable
{
  DownloadCenterImpl$3(DownloadCenterImpl paramDownloadCenterImpl, ArrayList paramArrayList) {}
  
  public void run()
  {
    LogUtility.a("DownloadCenterImpl", "getQueryDownloadAction enter");
    ArrayList localArrayList = new ArrayList();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      localObject = (DownloadInfo)this.a.get(i);
      if (DownloadManager.a().a((DownloadInfo)localObject)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    Object localObject = DownloadCenterImpl.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IDownloadCallback)((Iterator)localObject).next()).a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl.3
 * JD-Core Version:    0.7.0.1
 */