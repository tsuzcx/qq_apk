package com.tencent.mobileqq.filemanager.activity;

import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

class UniformDownloadActivity$7$1
  implements Runnable
{
  UniformDownloadActivity$7$1(UniformDownloadActivity.7 param7) {}
  
  public void run()
  {
    DownloadManager.a().a(UniformDownloadActivity.a(this.a.a));
    MyAppApi.a().a(this.a.a, "https://a.app.qq.com/o/myapp-down?g_f=1001647", "ANDROIDQQ.WIFIDLYYB.GAME", 2, true);
    OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3004", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.7.1
 * JD-Core Version:    0.7.0.1
 */