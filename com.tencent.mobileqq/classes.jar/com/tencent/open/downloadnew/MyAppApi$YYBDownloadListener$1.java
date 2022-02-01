package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;

class MyAppApi$YYBDownloadListener$1
  implements Runnable
{
  MyAppApi$YYBDownloadListener$1(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.b.a.k != null) && (this.b.a.k.isShowing())) {
      this.b.a.k.dismiss();
    }
    DownloadManager.b().d(this.a);
    new Handler(Looper.getMainLooper()).postAtTime(new MyAppApi.YYBDownloadListener.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */