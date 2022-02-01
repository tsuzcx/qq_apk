package com.tencent.open.appstore.notice;

import android.content.Context;
import bjjq;
import bjkf;
import bjko;
import bjlo;
import bjoq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bjjq.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bjko.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bjoq.b + "." + this.b).equals(this.c))
      {
        bjjq.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bjoq.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bjjq.a().b(localDownloadInfo);
        return;
      }
      if ((bjoq.c + "." + this.b).equals(this.c))
      {
        bjjq.a().b(localDownloadInfo);
        return;
      }
    } while (!(bjoq.d + "." + this.b).equals(this.c));
    bjlo.a(this.jdField_a_of_type_AndroidContentContext, bjjq.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"), localDownloadInfo.a("hideInstallSuccessPage"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bjjq.a().a(localDownloadInfo, true);
    bjkf.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */