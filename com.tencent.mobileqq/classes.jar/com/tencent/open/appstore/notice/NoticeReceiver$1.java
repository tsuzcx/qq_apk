package com.tencent.open.appstore.notice;

import android.content.Context;
import bfkr;
import bflg;
import bflp;
import bfms;
import bfqa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bfkr.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bflp.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bfqa.b + "." + this.b).equals(this.c))
      {
        bfkr.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bfqa.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bfkr.a().b(localDownloadInfo);
        return;
      }
      if ((bfqa.c + "." + this.b).equals(this.c))
      {
        bfkr.a().b(localDownloadInfo);
        return;
      }
    } while (!(bfqa.d + "." + this.b).equals(this.c));
    bfms.a(this.jdField_a_of_type_AndroidContentContext, bfkr.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bfkr.a().a(localDownloadInfo, true);
    bflg.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */