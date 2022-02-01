package com.tencent.mobileqq.qwallet.preload.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.io.File;
import java.util.Map;

class PreloadComDownloader$1
  extends PreloadResourceImpl.DownloadListenerWrapper
{
  PreloadComDownloader$1(PreloadComDownloader paramPreloadComDownloader, DownloadListener paramDownloadListener)
  {
    super(paramDownloadListener);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    if ((paramDownloadTask != null) && (paramDownloadTask.g != null) && (!TextUtils.isEmpty(paramDownloadTask.b)))
    {
      File localFile = (File)paramDownloadTask.g.get(paramDownloadTask.b);
      if (localFile != null)
      {
        Object localObject = QWalletHelperImpl.getAppRuntime();
        if (localObject != null)
        {
          localObject = (IPreDownloadController)((AppInterface)localObject).getRuntimeService(IPreDownloadController.class, "");
          String str = paramDownloadTask.b;
          int i = paramDownloadTask.c;
          long l2 = -1L;
          long l1 = l2;
          if (i == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((IPreDownloadController)localObject).preDownloadSuccess(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader.1
 * JD-Core Version:    0.7.0.1
 */