package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;

class MyAppApi$YYBDownloadListener$1
  implements Runnable
{
  MyAppApi$YYBDownloadListener$1(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.isShowing())) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.dismiss();
    }
    DownloadManager.a().c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    new Handler(Looper.getMainLooper()).postAtTime(new MyAppApi.YYBDownloadListener.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */