package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class PreloadComDownloader$3
  implements Runnable
{
  PreloadComDownloader$3(PreloadComDownloader paramPreloadComDownloader, DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle) {}
  
  public void run()
  {
    DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.filePath));
    localDownloadTask.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localDownloadTask.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (PreloadComDownloader.a(this.this$0) != null) {
      PreloadComDownloader.a(this.this$0).startDownload(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */