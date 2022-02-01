package com.tencent.open.appstore.dl;

import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;

class DownloadManagerV2$18
  implements Runnable
{
  public void run()
  {
    if (UpdateManager.a()) {
      UpdateManager.a().a();
    }
    if (MyAppApi.d()) {
      MyAppApi.a().h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.18
 * JD-Core Version:    0.7.0.1
 */