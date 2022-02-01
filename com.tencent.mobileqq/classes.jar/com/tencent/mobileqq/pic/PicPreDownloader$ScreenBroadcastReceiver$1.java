package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class PicPreDownloader$ScreenBroadcastReceiver$1
  implements Runnable
{
  PicPreDownloader$ScreenBroadcastReceiver$1(PicPreDownloader.ScreenBroadcastReceiver paramScreenBroadcastReceiver) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (!TextUtils.isEmpty(((AppRuntime)localObject).getAccount()))
    {
      localObject = ((PicPreDownloadImpl)((AppRuntime)localObject).getRuntimeService(IPicPreDownload.class, "")).picPreDownloader;
      ((PicPreDownloader)localObject).d();
      PicPreDownloader.b((PicPreDownloader)localObject);
      ((IDep)QRoute.api(IDep.class)).consumeAllThumbsInPendingQueue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */