package com.tencent.mobileqq.qqgamepub.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class QQGamePreDownloadServiceImpl$3
  implements Runnable
{
  QQGamePreDownloadServiceImpl$3(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl, DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle) {}
  
  public void run()
  {
    DownloadTask localDownloadTask = new DownloadTask(this.a.url, new File(this.a.filePath));
    localDownloadTask.L = "qqgame_pubaccount";
    if (this.a.headers != null)
    {
      Iterator localIterator = this.a.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localDownloadTask.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (QQGamePreDownloadServiceImpl.access$100(this.this$0) != null) {
      QQGamePreDownloadServiceImpl.access$100(this.this$0).startDownload(localDownloadTask, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */