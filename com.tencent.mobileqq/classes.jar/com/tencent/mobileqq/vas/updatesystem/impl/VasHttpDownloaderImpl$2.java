package com.tencent.mobileqq.vas.updatesystem.impl;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.vas.update.callback.listener.IDownloadListener;

class VasHttpDownloaderImpl$2
  extends DownloadListener
{
  VasHttpDownloaderImpl$2(VasHttpDownloaderImpl paramVasHttpDownloaderImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (VasHttpDownloaderImpl.a(this.a) != null)
    {
      if (paramDownloadTask == null) {
        return;
      }
      int i = paramDownloadTask.e();
      int j = 0;
      if ((i == 3) && (paramDownloadTask.c == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject = paramDownloadTask.b();
      if ((localObject != null) && (((Bundle)localObject).getString("from") != null) && (((Bundle)localObject).getString("from").contains("silent_download"))) {
        VasHttpDownloaderImpl.a(this.a, paramDownloadTask.h, paramDownloadTask.j);
      }
      localObject = VasHttpDownloaderImpl.a(this.a);
      String str = paramDownloadTask.b;
      if (i != 0) {
        i = j;
      } else {
        i = 8;
      }
      ((IDownloadListener)localObject).onCompleted(str, i, paramDownloadTask.c, paramDownloadTask.d);
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if ((VasHttpDownloaderImpl.a(this.a) != null) && (paramDownloadTask != null)) {
      VasHttpDownloaderImpl.a(this.a).onProgress(paramDownloadTask.b, paramDownloadTask.k, paramDownloadTask.j, (int)paramDownloadTask.l);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if (VasHttpDownloaderImpl.a(this.a) != null) {
      VasHttpDownloaderImpl.a(this.a).onDownloadStart(paramDownloadTask.b);
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */