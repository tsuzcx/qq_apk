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
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      LogUtility.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((IntentFactory.b + "." + this.b).equals(this.c))
      {
        DownloadManagerV2.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((IntentFactory.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        DownloadManagerV2.a().b(localDownloadInfo);
        return;
      }
      if ((IntentFactory.c + "." + this.b).equals(this.c))
      {
        DownloadManagerV2.a().b(localDownloadInfo);
        return;
      }
    } while (!(IntentFactory.d + "." + this.b).equals(this.c));
    AppUtil.a(this.jdField_a_of_type_AndroidContentContext, DownloadManagerV2.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"), localDownloadInfo.a("hideInstallSuccessPage"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    DownloadManagerV2.a().a(localDownloadInfo, true);
    AppCenterReporter.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */