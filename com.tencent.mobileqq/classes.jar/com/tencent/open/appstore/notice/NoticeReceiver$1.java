package com.tencent.open.appstore.notice;

import android.content.Context;
import bdgv;
import bdhk;
import bdht;
import bdiw;
import bdmf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bdgv.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bdht.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bdmf.b + "." + this.b).equals(this.c))
      {
        bdgv.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bdmf.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bdgv.a().b(localDownloadInfo);
        return;
      }
      if ((bdmf.c + "." + this.b).equals(this.c))
      {
        bdgv.a().b(localDownloadInfo);
        return;
      }
    } while (!(bdmf.d + "." + this.b).equals(this.c));
    bdiw.a(this.jdField_a_of_type_AndroidContentContext, bdgv.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bdgv.a().a(localDownloadInfo, true);
    bdhk.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */