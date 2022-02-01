package com.tencent.open.downloadnew;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;

class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  MyAppApi$YYBDownloadListener$2(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    LogUtility.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (ControlPolicyUtil.a(l))
    {
      if (AppUtil.b())
      {
        DownloadInfo localDownloadInfo = this.a;
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.q)))
        {
          AppUtil.h(this.a.q);
          return;
        }
      }
      LogUtility.c("MyAppApi", "root confused and remember user operation time!");
      ControlPolicyUtil.b(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */