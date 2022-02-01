package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class FavroamingManagerServiceImpl$7
  implements Runnable
{
  FavroamingManagerServiceImpl$7(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl, String[] paramArrayOfString, TransferRequest paramTransferRequest) {}
  
  public void run()
  {
    if (!FileUtils.fileExists(this.a[1]))
    {
      Object localObject = new File(this.a[1]);
      localObject = new DownloadTask(this.a[0], (File)localObject);
      ((DownloadTask)localObject).J = true;
      if (((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject, FavroamingManagerServiceImpl.access$1600(this.this$0)) != 0)
      {
        if ((this.b.mUpCallBack instanceof EmoBatchAddedCallback)) {
          EmoBatchAddedCallback.a((EmoBatchAddedCallback)this.b.mUpCallBack);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("collectEmoji fail to download thumbFile: ");
        ((StringBuilder)localObject).append(this.a[1]);
        QLog.e("FavroamingManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (this.this$0.mFileController != null) {
      this.this$0.mFileController.transferAsync(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */