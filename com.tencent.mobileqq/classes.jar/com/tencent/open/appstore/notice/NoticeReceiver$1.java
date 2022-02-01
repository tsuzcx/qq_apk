package com.tencent.open.appstore.notice;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.IntentFactory;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(this.a);
    if (localDownloadInfo == null)
    {
      LogUtility.b("NoticeReceiver", "downloadInfo is null.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.b);
    localStringBuilder.append(".");
    localStringBuilder.append(this.b);
    if (localStringBuilder.toString().equals(this.c))
    {
      DownloadManagerV2.a().e(this.a);
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.a);
    localStringBuilder.append(".");
    localStringBuilder.append(this.b);
    if (localStringBuilder.toString().equals(this.c))
    {
      DownloadManagerV2.a().b(localDownloadInfo);
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.c);
    localStringBuilder.append(".");
    localStringBuilder.append(this.b);
    if (localStringBuilder.toString().equals(this.c))
    {
      DownloadManagerV2.a().b(localDownloadInfo);
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.d);
    localStringBuilder.append(".");
    localStringBuilder.append(this.b);
    if (localStringBuilder.toString().equals(this.c))
    {
      AppUtil.a(this.d, DownloadManagerV2.a().d(localDownloadInfo.b), localDownloadInfo.r, localDownloadInfo.a("big_brother_ref_source_key"), localDownloadInfo.a("hideInstallSuccessPage"));
      localDownloadInfo.R = BaseApplicationImpl.getApplication().getQQProcessName();
      DownloadManagerV2.a().b(localDownloadInfo, true);
      AppCenterReporter.c(localDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */