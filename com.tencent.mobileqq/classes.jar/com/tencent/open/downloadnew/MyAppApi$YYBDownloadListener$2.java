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
      if (AppUtil.a())
      {
        DownloadInfo localDownloadInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.l)))
        {
          AppUtil.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
          return;
        }
      }
      LogUtility.c("MyAppApi", "root confused and remember user operation time!");
      ControlPolicyUtil.a(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */